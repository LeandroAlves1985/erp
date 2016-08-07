package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aluno_Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idAlunoTurma;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_Aluno")
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_Turma")
	private Turma turma;

	public Aluno_Turma() {

	}

	public Aluno_Turma(Integer idAlunoTurma, Aluno aluno, Turma turma) {
		super();
		this.idAlunoTurma = idAlunoTurma;
		this.aluno = aluno;
		this.turma = turma;
	}

	public Integer getIdAlunoTurma() {
		return idAlunoTurma;
	}

	public void setIdAlunoTurma(Integer idAlunoTurma) {
		this.idAlunoTurma = idAlunoTurma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
