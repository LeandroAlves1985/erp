package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import repositorio.DisciplinaDao;
import repositorio.TurmaDao;
import modelo.Aluno;
import modelo.Disciplina;
import modelo.Endereco;
import modelo.Telefone;
import modelo.Turma;

@ManagedBean(name = "turmaBean")
@ViewScoped
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Turma turmaEdicao;
	private Turma turmaSelecionada;
	private List<Turma> todasTurmas;
	private TurmaDao turmaDao;
	private Disciplina disciplinaEdicao;
	private Boolean visualizar;
	private Disciplina disciplinaSalvo;
	private List<Disciplina> listaDisciplina;
	private List<Turma> listaTurma;
	private List<Disciplina> todasDisciplinasPorTurma;

	@PostConstruct
	public void construct() {
		disciplinaEdicao = new Disciplina();
		turmaEdicao = new Turma();
		turmaSelecionada = new Turma();
		todasTurmas = new ArrayList<Turma>();
		turmaDao = new TurmaDao();
		disciplinaSalvo = new Disciplina();
		listaTurma = new ArrayList<Turma>();
		listaDisciplina = new ArrayList<Disciplina>();
	}

	public Disciplina getDisciplinaEdicao() {
		return disciplinaEdicao;
	}

	public void setDisciplinaEdicao(Disciplina disciplinaEdicao) {
		this.disciplinaEdicao = disciplinaEdicao;
	}

	public TurmaDao getTurmaDao() {
		return turmaDao;
	}

	public void setTurmaDao(TurmaDao turmaDao) {
		this.turmaDao = turmaDao;
	}

	public List<Turma> getTodasTurmas() {
		todasTurmas = turmaDao.findAll();
		return todasTurmas;
	}

	public void setTodasTurmas(List<Turma> todasTurmas) {
		this.todasTurmas = todasTurmas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Turma getTurmaEdicao() {
		return turmaEdicao;
	}

	public void setTurmaEdicao(Turma turmaEdicao) {
		this.turmaEdicao = turmaEdicao;
	}

	public Turma getTurmaSelecionada() {
		return turmaSelecionada;
	}

	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}

	public Disciplina getDisciplinaSalvo() {
		return disciplinaSalvo;
	}

	public void setDisciplinaSalvo(Disciplina disciplinaSalvo) {
		this.disciplinaSalvo = disciplinaSalvo;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	public List<Turma> getListaTurma() {
		return listaTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	public List<Disciplina> getTodasDisciplinasPorTurma() {		
		return todasDisciplinasPorTurma;
	}

	public void setTodasDisciplinasPorTurma(List<Disciplina> todasDisciplinasPorTurma) {
		this.todasDisciplinasPorTurma = todasDisciplinasPorTurma;
	}
	
	public void preparaEdicao() {
		todasDisciplinasPorTurma = new TurmaDao().disciplinaPorTurma(turmaEdicao);
		visualizar = false;			
	}

	public void preparaVisualizacao() {
		
		visualizar = true;
	}

	public void preparaNovoCadastro() {		
		visualizar = false;
	}

	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {

			turmaDao.create(turmaEdicao);
			construct();
			fc.addMessage("formTurma", new FacesMessage("Turma cadastrada com sucesso"));

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao cadastrar turma" + e.getMessage()));
		}
	}

	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			turmaDao.update(turmaEdicao);
			construct();
			fc.addMessage("formTurma", new FacesMessage("Turma atualizada com sucesso"));

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao atualizar turma" + e.getMessage()));
		}
	}

	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			turmaDao.delete(turmaSelecionada);
			fc.addMessage("formTurma", new FacesMessage("Turma excluida com sucesso"));
			turmaDao.findAll();
		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao excluir turma!" + e.getMessage()));
		}
	}
	
	public void salvaTurmaDisciplina(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			disciplinaSalvo = new DisciplinaDao().porNome(disciplinaEdicao);
			listaDisciplina.clear();
			listaDisciplina.add(disciplinaSalvo);
			listaTurma.clear();
			listaTurma.add(turmaEdicao);
			disciplinaSalvo.setTurmas(listaTurma);
			turmaEdicao.setDisciplinas(listaDisciplina);			
			new TurmaDao().update(turmaEdicao);
			new DisciplinaDao().update(disciplinaSalvo);
			listaTurma.clear();
			listaDisciplina.clear();
			todasDisciplinasPorTurma = new TurmaDao().disciplinaPorTurma(turmaEdicao);
			fc.addMessage("formTurma", new FacesMessage("Disciplina alocada com sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao alocar turma!"));
		}
	}
	
	public void removerDisciplina(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			todasDisciplinasPorTurma = turmaDao.disciplinaPorTurma(turmaEdicao);
			todasDisciplinasPorTurma.remove(disciplinaSalvo);
			turmaEdicao.setDisciplinas(todasDisciplinasPorTurma);
			disciplinaSalvo.setTurmas(listaTurma);
			new DisciplinaDao().update(disciplinaSalvo);
			turmaDao.update(turmaEdicao);
			todasDisciplinasPorTurma = turmaDao.disciplinaPorTurma(turmaEdicao);
			
			fc.addMessage("formTurma", new FacesMessage("Disciplina removida com sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao remover disciplina!" + e.getMessage()));
		}
	}

}
