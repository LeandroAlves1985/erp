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
import repositorio.Turma_DisciplinaDao;
import modelo.Aluno;
import modelo.Disciplina;
import modelo.Endereco;
import modelo.Telefone;
import modelo.Turma;
import modelo.Turma_Disciplina;

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
	private List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	private List<Turma> listaTurma = new ArrayList<Turma>();
	private List<Disciplina> todasDisciplinasPorTurma;
	private List<Disciplina> todasDisciplinasPorTurmaRemove;
	
	private Turma_Disciplina turma_disciplinaEdicao;
	private List<Turma_Disciplina>  todasTurmas_disciplinas;
	
	

	@PostConstruct
	public void construct() {
		disciplinaEdicao = new Disciplina();
		turmaEdicao = new Turma();
		turmaSelecionada = new Turma();
		todasTurmas = new ArrayList<Turma>();
		turmaDao = new TurmaDao();
		disciplinaSalvo = new Disciplina();
		
		turma_disciplinaEdicao = new Turma_Disciplina();
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

	public void setTodasDisciplinasPorTurma(
			List<Disciplina> todasDisciplinasPorTurma) {
		this.todasDisciplinasPorTurma = todasDisciplinasPorTurma;
	}
	
	public List<Disciplina> getTodasDisciplinasPorTurmaRemove() {
		return todasDisciplinasPorTurmaRemove;
	}

	public void setTodasDisciplinasPorTurmaRemove(
			List<Disciplina> todasDisciplinasPorTurmaRemove) {
		this.todasDisciplinasPorTurmaRemove = todasDisciplinasPorTurmaRemove;
	}

	public Turma_Disciplina getTurma_disciplinaEdicao() {
		return turma_disciplinaEdicao;
	}

	public void setTurma_disciplinaEdicao(Turma_Disciplina turma_disciplinaEdicao) {
		this.turma_disciplinaEdicao = turma_disciplinaEdicao;
	}

	public List<Turma_Disciplina> getTodasTurmas_disciplinas() {
		todasTurmas_disciplinas = new Turma_DisciplinaDao().findAll();
		return todasTurmas_disciplinas;
	}

	public void setTodasTurmas_disciplinas(
			List<Turma_Disciplina> todasTurmas_disciplinas) {
		this.todasTurmas_disciplinas = todasTurmas_disciplinas;
	}
	
	
	
	public void preparaEdicao() {
		disciplinaEdicao =  turma_disciplinaEdicao.getDisciplina();
		turmaEdicao =  turma_disciplinaEdicao.getTurma();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		disciplinaEdicao =  turma_disciplinaEdicao.getDisciplina();
		turmaEdicao =  turma_disciplinaEdicao.getTurma();
		visualizar = true;
	}

	

	public void preparaNovoCadastro() {
		//disciplinaEdicao = new Disciplina();
		visualizar = false;
	}

	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			
			turmaDao.create(turmaEdicao);
			construct();
			fc.addMessage("formTurma", new FacesMessage(
					"Turma cadastrada com sucesso"));

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage(
					"Erro ao cadastrar turma" + e.getMessage()));
		}
	}

	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			turmaDao.update(turmaEdicao);
			construct();
			fc.addMessage("formTurma", new FacesMessage(
					"Turma atualizada com sucesso"));

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage(
					"Erro ao atualizar turma" + e.getMessage()));
		}
	}

	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {

			turmaDao.delete(turmaSelecionada);
			fc.addMessage("formTurma", new FacesMessage(
					"Turma excluida com sucesso"));
			turmaDao.findAll();
		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage(
					"Erro ao excluir turma!" + e.getMessage()));
		}
	}

//	public void alocarDisciplina() {
//		FacesContext fc = FacesContext.getCurrentInstance();
//		try {
//			disciplinaSalvo = new DisciplinaDao().porNome(disciplinaEdicao);
//			listaDisciplina.add(disciplinaSalvo);
//			listaTurma.add(turmaEdicao);
//			turmaEdicao.setDisciplinas(listaDisciplina);
//			disciplinaSalvo.setTurmas(listaTurma);
//			new DisciplinaDao().update(disciplinaSalvo);
//			turmaDao.update(turmaEdicao);			
//			todasDisciplinasPorTurma = turmaDao.disciplinaPorTurma(turmaEdicao);
//			fc.addMessage("formTurma", new FacesMessage("Disciplina alocada com sucesso!"));
//			construct();
//
//		} catch (Exception e) {
//			fc.addMessage("formTurma", new FacesMessage("Erro ao alocar disciplina!" + e.getMessage()));
//		}
//	}
	

	public void alocarDisciplina() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			
			turma_disciplinaEdicao.setDisciplina(disciplinaEdicao);
			turma_disciplinaEdicao.setTurma(turmaSelecionada);
			
			new Turma_DisciplinaDao().create(turma_disciplinaEdicao);
						
			
			//todasDisciplinasPorTurma = turmaDao.disciplinaPorTurma(turmaEdicao);
			
			fc.addMessage("formTurma", new FacesMessage("Disciplina alocada com sucesso!"));
			construct();

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao alocar disciplina!" + e.getMessage()));
		}
	}
	
	
	
	
	
	
	
	
//	public void removerDisciplina(){
//		FacesContext fc = FacesContext.getCurrentInstance();
//		try {
//			todasDisciplinasPorTurma = turmaDao.disciplinaPorTurma(turmaEdicao);
//			todasDisciplinasPorTurma.remove(disciplinaSalvo);
//			turmaEdicao.setDisciplinas(todasDisciplinasPorTurma);
//			disciplinaSalvo.setTurmas(listaTurma);
//			new DisciplinaDao().update(disciplinaSalvo);
//			turmaDao.update(turmaEdicao);
//			todasDisciplinasPorTurma = turmaDao.disciplinaPorTurma(turmaEdicao);
//			fc.addMessage("formTurma", new FacesMessage("Disciplina removida com sucesso!"));
//			
//		} catch (Exception e) {
//			fc.addMessage("formTurma", new FacesMessage("Erro ao remover disciplina!" + e.getMessage()));
//		}
//	}
//	
	
	public void removerDisciplina(){
	FacesContext fc = FacesContext.getCurrentInstance();
	try {
		
		fc.addMessage("formTurma", new FacesMessage("Disciplina removida com sucesso!"));
		
	} catch (Exception e) {
		fc.addMessage("formTurma", new FacesMessage("Erro ao remover disciplina!" + e.getMessage()));
	}
}


	
	
	
}
