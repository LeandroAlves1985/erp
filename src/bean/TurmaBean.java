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

@ManagedBean(name="turmaBean")
@ViewScoped
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Turma turmaEdicao;
	private Turma turmaSelecionada;
	private List<Turma> todasTurmas;
	private TurmaDao turmaDao;
	
	private Disciplina  disciplinaEdicao;
	
	
	
	private Boolean visualizar;

	@PostConstruct
	public void construct() {
		disciplinaEdicao = new Disciplina();
		turmaEdicao = new Turma();
		turmaSelecionada = new Turma();
		todasTurmas = new ArrayList<Turma>();
		turmaDao = new TurmaDao();
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

	public void preparaEdicao() {
		disciplinaEdicao = (Disciplina) turmaEdicao.getDisciplinas();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		disciplinaEdicao = (Disciplina) turmaEdicao.getDisciplinas();
		visualizar = true;
	}
	
	public void preparaNovoCadastro(){
		disciplinaEdicao = new Disciplina();
		visualizar = false;
	}

	
	
	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			//turmaEdicao.setDisciplinas(disciplinaEdicao);
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
			fc.addMessage("formTurma", new FacesMessage("Erro ao cadastrar turma!" + e.getMessage()));
		}
	}

}
