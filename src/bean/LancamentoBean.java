package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import repositorio.TurmaDao;
import modelo.Aluno;
import modelo.Disciplina;
import modelo.Nota;
import modelo.Professor;
import modelo.Turma;

@ManagedBean(name = "lancBean")
@ViewScoped
public class LancamentoBean implements Serializable {

	private Turma turmaEdicao;
	private Turma turmaSelecionada;
	private List<Turma> todasTurmas;
	private TurmaDao turmaDao;

	private Boolean visualizar;

	private Aluno alunoEdicao;
	private Aluno alunoSelecionado;
	private List<Aluno> todosAlunosPorTurma;

	private Nota notaEdicao;

	@PostConstruct
	public void construct() {
		turmaEdicao = new Turma();
		turmaDao = new TurmaDao();
		turmaSelecionada = new Turma();
		alunoEdicao = new Aluno();
		alunoSelecionado = new Aluno();
		notaEdicao = new Nota();

	}

	public Nota getNotaEdicao() {
		return notaEdicao;
	}

	public void setNotaEdicao(Nota notaEdicao) {
		this.notaEdicao = notaEdicao;
	}

	public TurmaDao getTurmaDao() {
		return turmaDao;
	}

	public void setTurmaDao(TurmaDao turmaDao) {
		this.turmaDao = turmaDao;
	}

	public Aluno getAlunoEdicao() {
		return alunoEdicao;
	}

	public void setAlunoEdicao(Aluno alunoEdicao) {
		this.alunoEdicao = alunoEdicao;
	}

	public List<Aluno> getTodosAlunosPorTurma() {
		return todosAlunosPorTurma;
	}

	public void setTodosAlunosPorTurma(List<Aluno> todosAlunosPorTurma) {
		this.todosAlunosPorTurma = todosAlunosPorTurma;
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

	public List<Turma> getTodasTurmas() {
		return todasTurmas;
	}

	public void setTodasTurmas(List<Turma> todasTurmas) {
		this.todasTurmas = todasTurmas;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public void preparaEdicao() {
		turmaEdicao = new Turma();
		turmaSelecionada = new Turma();
		todosAlunosPorTurma = turmaDao.alunoPorTurma(turmaEdicao);
		alunoEdicao = new Aluno();
		alunoSelecionado = new Aluno();
		visualizar = false;
	}

	public void preparaVisualizacao() {

		visualizar = true;
	}

}
