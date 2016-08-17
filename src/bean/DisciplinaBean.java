package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Aluno;
import modelo.Disciplina;
import modelo.Endereco;
import modelo.Nota;
import modelo.Professor;
import modelo.Telefone;
import modelo.Turma;
import repositorio.DisciplinaDao;
import repositorio.NotaDao;

@ManagedBean(name = "disciplinaBean")
@ViewScoped
public class DisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Disciplina disciplinaEdicao;
	private Disciplina disciplinaSelecionada;
	private List<Disciplina> todasDisciplinas;
	private DisciplinaDao disciplinaDao;

	private Professor professorEdicao;
	private Nota notaEdicao;
	private NotaDao notaDao;
	
	private Turma turmaEdicao;
	private Boolean visualizar;

	
	
	@PostConstruct
	public void construct() {
		disciplinaEdicao = new Disciplina();
		disciplinaSelecionada = new Disciplina();
		todasDisciplinas = new ArrayList<Disciplina>();
		disciplinaDao = new DisciplinaDao();
		professorEdicao = new Professor();
		notaEdicao = new Nota();
		turmaEdicao = new Turma();
		notaDao = new NotaDao();
	}

	
	
	public NotaDao getNotaDao() {
		return notaDao;
	}

	public void setNotaDao(NotaDao notaDao) {
		this.notaDao = notaDao;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}
	
	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}


	public Disciplina getDisciplinaEdicao() {
		return disciplinaEdicao;
	}

	public void setDisciplinaEdicao(Disciplina disciplinaEdicao) {
		this.disciplinaEdicao = disciplinaEdicao;
	}

	public Disciplina getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}

	public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}

	public Professor getProfessorEdicao() {
		return professorEdicao;
	}

	public void setProfessorEdicao(Professor professorEdicao) {
		this.professorEdicao = professorEdicao;
	}

	public Nota getNotaEdicao() {
		return notaEdicao;
	}

	public void setNotaEdicao(Nota notaEdicao) {
		this.notaEdicao = notaEdicao;
	}

	public Turma getTurmaEdicao() {
		return turmaEdicao;
	}

	public void setTurmaEdicao(Turma turmaEdicao) {
		this.turmaEdicao = turmaEdicao;
	}

	public DisciplinaDao getDisciplinaDao() {
		return disciplinaDao;
	}

	public void setDisciplinaDao(DisciplinaDao disciplinaDao) {
		this.disciplinaDao = disciplinaDao;
	}

	public List<Disciplina> getTodasDisciplinas() {
		todasDisciplinas = new DisciplinaDao().findAll();
		return todasDisciplinas;
	}

	public void setTodasDisciplinas(List<Disciplina> todasDisciplinas) {
		this.todasDisciplinas = todasDisciplinas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void preparaEdicao() {
		notaEdicao = disciplinaEdicao.getNota();		
		visualizar = false;
	}

	public void preparaVisualizacao() {
		notaEdicao = disciplinaEdicao.getNota();
		visualizar = true;
	}
	
	public void preparaNovoCadastro(){
		disciplinaEdicao = new Disciplina();
		notaEdicao = new Nota();
		visualizar = false;
	}
	
	
	
	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {			
			disciplinaDao.create(disciplinaEdicao);
			construct();
			fc.addMessage("formDisciplina", new FacesMessage("Disciplina cadastrada com sucesso"));
		
		} catch (Exception e) {
			fc.addMessage("formDisciplina", new FacesMessage("Erro ao cadastrar disciplina" + e.getMessage()));
		}
	}

	
	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			//notaDao.update(notaEdicao);
			//disciplinaEdicao.setNota(notaEdicao);
			disciplinaDao.update(disciplinaEdicao);
			construct();
			fc.addMessage("formDisciplina", new FacesMessage("Disciplina atualizada com sucesso"));
		
		} catch (Exception e) {
			fc.addMessage("formDisciplina", new FacesMessage("Erro ao atualizar disciplina" + e.getMessage()));
		}
	}

	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			disciplinaDao.delete(disciplinaSelecionada);
			disciplinaDao.findAll();
			fc.addMessage("formDisciplina", new FacesMessage("Disciplina excluida com sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formDisciplina", new FacesMessage("Erro ao escluir disciplina" + e.getMessage()));
		}
	}

}
