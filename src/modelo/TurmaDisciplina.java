package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TurmaDisciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;

	public TurmaDisciplina() {
		// TODO Auto-generated constructor stub
	}

	public TurmaDisciplina(Integer id, Turma turma, Disciplina disciplina) {
		super();
		this.id = id;
		this.turma = turma;
		this.disciplina = disciplina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
