package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Aluno;
import modelo.Disciplina;
import modelo.Lancamento;
import modelo.Nota;
import modelo.Professor;
import modelo.Turma;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import repositorio.AlunoDao;
import repositorio.DisciplinaDao;
import repositorio.LancamentoDao;
import repositorio.NotaDao;
import repositorio.ProfessorDao;
import repositorio.TurmaDao;

@ManagedBean(name = "turmaBean")
@ViewScoped
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Turma turmaEdicao;
	private Turma turmaSelecionada;
	private List<Turma> todasTurmas;
	private TurmaDao turmaDao;
	private DisciplinaDao disciplinaDao;
	private Disciplina disciplinaEdicao;
	private Boolean visualizar;
	private Disciplina disciplinaSalvo;
	private List<Disciplina> todasDisciplinasPorTurma;	
	private Aluno alunoEdicao;
	private Aluno alunoSalvo;
	private AlunoDao alunoDao;
	private List<Aluno> todosAlunosPorTurma;
	private Professor professorEdicao;
	private Professor professorSalvo;
	private ProfessorDao professorDao;
	private List<Professor> todosProfessorresPorTurma;
	private Boolean testaBotao;
	private Disciplina disciplinaSelecionado;
	private Nota notaEdicao;
	private Lancamento lancamentoEdicao;

	@PostConstruct
	public void construct() {
		disciplinaEdicao = null;
		turmaEdicao = null;
		turmaSelecionada = new Turma();
		turmaDao = new TurmaDao();
		disciplinaSalvo = null;
		disciplinaDao = new DisciplinaDao();
		alunoEdicao = null;
		alunoSalvo = null;
		alunoDao = new AlunoDao();
		professorEdicao = null;
		professorSalvo = null;
		professorDao = new ProfessorDao();
		disciplinaSelecionado = null;
		notaEdicao = null;
		lancamentoEdicao = new Lancamento();
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

	public List<Disciplina> getTodasDisciplinasPorTurma() {
		return todasDisciplinasPorTurma;
	}

	public void setTodasDisciplinasPorTurma(List<Disciplina> todasDisciplinasPorTurma) {
		this.todasDisciplinasPorTurma = todasDisciplinasPorTurma;
	}

	public DisciplinaDao getDisciplinaDao() {
		return disciplinaDao;
	}

	public void setDisciplinaDao(DisciplinaDao disciplinaDao) {
		this.disciplinaDao = disciplinaDao;
	}

	public Aluno getAlunoEdicao() {
		return alunoEdicao;
	}

	public void setAlunoEdicao(Aluno alunoEdicao) {
		this.alunoEdicao = alunoEdicao;
	}

	public Aluno getAlunoSalvo() {
		return alunoSalvo;
	}

	public void setAlunoSalvo(Aluno alunoSalvo) {
		this.alunoSalvo = alunoSalvo;
	}

	public AlunoDao getAlunoDao() {
		return alunoDao;
	}

	public void setAlunoDao(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

	public List<Aluno> getTodosAlunosPorTurma() {
		return todosAlunosPorTurma;
	}

	public void setTodosAlunosPorTurma(List<Aluno> todosAlunosPorTurma) {
		this.todosAlunosPorTurma = todosAlunosPorTurma;
	}

	public Professor getProfessorEdicao() {
		return professorEdicao;
	}

	public void setProfessorEdicao(Professor professorEdicao) {
		this.professorEdicao = professorEdicao;
	}

	public Professor getProfessorSalvo() {
		return professorSalvo;
	}

	public void setProfessorSalvo(Professor professorSalvo) {
		this.professorSalvo = professorSalvo;
	}

	public ProfessorDao getProfessorDao() {
		return professorDao;
	}

	public void setProfessorDao(ProfessorDao professorDao) {
		this.professorDao = professorDao;
	}

	public List<Professor> getTodosProfessorresPorTurma() {
		return todosProfessorresPorTurma;
	}

	public void setTodosProfessorresPorTurma(
			List<Professor> todosProfessorresPorTurma) {
		this.todosProfessorresPorTurma = todosProfessorresPorTurma;
	}

	public Boolean getTestaBotao() {
		return testaBotao;
	}

	public void setTestaBotao(Boolean testaBotao) {
		this.testaBotao = testaBotao;
	}	
	
	public Disciplina getDisciplinaSelecionado() {
		return disciplinaSelecionado;
	}

	public void setDisciplinaSelecionado(Disciplina disciplinaSelecionado) {
		this.disciplinaSelecionado = disciplinaSelecionado;
	}

	public Nota getNotaEdicao() {
		return notaEdicao;
	}

	public void setNotaEdicao(Nota notaEdicao) {
		this.notaEdicao = notaEdicao;
	}	
	
	public Lancamento getLancamentoEdicao() {
		return lancamentoEdicao;
	}

	public void setLancamentoEdicao(Lancamento lancamentoEdicao) {
		this.lancamentoEdicao = lancamentoEdicao;
	}

	public void preparaEdicao() {
		todasDisciplinasPorTurma = new TurmaDao().disciplinaPorTurma(turmaEdicao);
		disciplinaEdicao = new Disciplina();
		disciplinaSalvo = new Disciplina();
		todosAlunosPorTurma = turmaDao.alunoPorTurma(turmaEdicao);
		alunoEdicao = new Aluno();
		alunoSalvo = new Aluno();
		todosProfessorresPorTurma = turmaDao.professorPorTurma(turmaEdicao);
		professorEdicao = new Professor();
		professorSalvo = new Professor();
		disciplinaSelecionado = new Disciplina();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		visualizar = true;
	}

	public void preparaNovoCadastro() {
		turmaEdicao = new Turma();
		visualizar = false;
	}

	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			turmaDao.create(turmaEdicao);
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

	public void salvaTurmaDisciplina() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			disciplinaSalvo = disciplinaDao.porNome(disciplinaEdicao);
			List<Disciplina> disciplinas = turmaDao.disciplinaPorTurma(turmaEdicao);						
			disciplinas.add(disciplinaSalvo);
			turmaEdicao.setDisciplinas(disciplinas);
			turmaDao.update(turmaEdicao);
			todasDisciplinasPorTurma = turmaDao.disciplinaPorTurma(turmaEdicao);
			fc.addMessage("formTurma", new FacesMessage("Disciplina alocada com sucesso!"));		

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao alocar turma!"));
		}
	}
	

	public void removerDisciplina() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			List<Disciplina> disciplinas = turmaDao.disciplinaPorTurma(turmaEdicao);
			disciplinas.remove(disciplinaSalvo);
			turmaEdicao.setDisciplinas(disciplinas);
			turmaDao.update(turmaEdicao);
			todasDisciplinasPorTurma = turmaDao.disciplinaPorTurma(turmaEdicao);
			fc.addMessage("formTurma", new FacesMessage("Disciplina removida com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage(
					"Erro ao remover disciplina!" + e.getMessage()));
		}
	}
	
	public void salvaTurmaAluno() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			alunoSalvo = alunoDao.porNome(alunoEdicao);
			List<Aluno> alunos = turmaDao.alunoPorTurma(turmaEdicao);						
			alunos.add(alunoSalvo);
			turmaEdicao.setAlunos(alunos);
			turmaDao.update(turmaEdicao);
			todosAlunosPorTurma = turmaDao.alunoPorTurma(turmaEdicao);
			fc.addMessage("formTurma", new FacesMessage("Aluno alocado com sucesso!"));		

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao alocar aluno!"));
		}
	}
	
	public void removerAluno() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			List<Aluno> alunos = turmaDao.alunoPorTurma(turmaEdicao);
			alunos.remove(alunoSalvo);
			turmaEdicao.setAlunos(alunos);
			turmaDao.update(turmaEdicao);
			todosAlunosPorTurma = turmaDao.alunoPorTurma(turmaEdicao);
			fc.addMessage("formTurma", new FacesMessage("Aluno removido com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao remover aluno!" + e.getMessage()));
		}
	}
	
	public void salvaTurmaProfessor() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			professorSalvo = professorDao.porNome(professorEdicao);
			List<Professor> professores = turmaDao.professorPorTurma(turmaEdicao);						
			professores.add(professorSalvo);
			turmaEdicao.setProfessores(professores);
			turmaDao.update(turmaEdicao);
			todosProfessorresPorTurma = turmaDao.professorPorTurma(turmaEdicao);
			fc.addMessage("formTurma", new FacesMessage("Professor alocado com sucesso!"));		

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao alocar professor!"));
		}
	}
	
	public void removerProfessor() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			List<Professor> professores = turmaDao.professorPorTurma(turmaEdicao);
			professores.remove(professorSalvo);
			turmaEdicao.setProfessores(professores);
			turmaDao.update(turmaEdicao);
			todosProfessorresPorTurma = turmaDao.professorPorTurma(turmaEdicao);
			fc.addMessage("formTurma", new FacesMessage("Professor removido com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formTurma", new FacesMessage("Erro ao remover professor!" + e.getMessage()));
		}
	}
	
	public void preparaLancamento(){
		
	}
}
