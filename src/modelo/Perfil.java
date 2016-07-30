package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column
	private String descricao;
	@OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;

	// MENU
	@Column(columnDefinition = "boolean default false")
	private Boolean menuAdministracao;

	// PROFESSOR
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuProfessor;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuProfessorInclusao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuProfessorAlteracao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuProfessorExibicao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuProfessorExclusao;

	// ALUNO
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuAluno;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuAlunoInclusao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuAlunoAlteracao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuAlunoExibicao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuAlunoExclusao;

	// PERFIL
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuPerfil;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuPerfilInclusao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuPerfilAlteracao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuPerfilExibicao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuPerfilExclusao;

	// USUARIO
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuUsuario;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuUsuarioInclusao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuUsuarioAlteracao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuUsuarioExibicao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuUsuarioExclusao;

	// TURMA
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuTurma;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuTurmaInclusao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuTurmaAlteracao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuTurmaExibicao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuTurmaExclusao;

	// DISCIPLINA
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuDisciplina;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuDisciplinaInclusao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuDisciplinaAlteracao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuDisciplinaExibicao;
	@Column(columnDefinition = "boolean default false")
	private Boolean subMenuDisciplinaExclusao;

	public Perfil() {
		// TODO Auto-generated constructor stub
	}

	public Perfil(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao == null ? null : descricao.toUpperCase();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Boolean getMenuAdministracao() {
		return menuAdministracao;
	}

	public void setMenuAdministracao(Boolean menuAdministracao) {
		this.menuAdministracao = menuAdministracao;
	}

	public Boolean getSubMenuProfessor() {
		return subMenuProfessor;
	}

	public void setSubMenuProfessor(Boolean subMenuProfessor) {
		this.subMenuProfessor = subMenuProfessor;
	}

	public Boolean getSubMenuProfessorInclusao() {
		return subMenuProfessorInclusao;
	}

	public void setSubMenuProfessorInclusao(Boolean subMenuProfessorInclusao) {
		this.subMenuProfessorInclusao = subMenuProfessorInclusao;
	}

	public Boolean getSubMenuProfessorAlteracao() {
		return subMenuProfessorAlteracao;
	}

	public void setSubMenuProfessorAlteracao(Boolean subMenuProfessorAlteracao) {
		this.subMenuProfessorAlteracao = subMenuProfessorAlteracao;
	}

	public Boolean getSubMenuProfessorExibicao() {
		return subMenuProfessorExibicao;
	}

	public void setSubMenuProfessorExibicao(Boolean subMenuProfessorExibicao) {
		this.subMenuProfessorExibicao = subMenuProfessorExibicao;
	}

	public Boolean getSubMenuProfessorExclusao() {
		return subMenuProfessorExclusao;
	}

	public void setSubMenuProfessorExclusao(Boolean subMenuProfessorExclusao) {
		this.subMenuProfessorExclusao = subMenuProfessorExclusao;
	}

	public Boolean getSubMenuAluno() {
		return subMenuAluno;
	}

	public void setSubMenuAluno(Boolean subMenuAluno) {
		this.subMenuAluno = subMenuAluno;
	}

	public Boolean getSubMenuAlunoInclusao() {
		return subMenuAlunoInclusao;
	}

	public void setSubMenuAlunoInclusao(Boolean subMenuAlunoInclusao) {
		this.subMenuAlunoInclusao = subMenuAlunoInclusao;
	}

	public Boolean getSubMenuAlunoAlteracao() {
		return subMenuAlunoAlteracao;
	}

	public void setSubMenuAlunoAlteracao(Boolean subMenuAlunoAlteracao) {
		this.subMenuAlunoAlteracao = subMenuAlunoAlteracao;
	}

	public Boolean getSubMenuAlunoExibicao() {
		return subMenuAlunoExibicao;
	}

	public void setSubMenuAlunoExibicao(Boolean subMenuAlunoExibicao) {
		this.subMenuAlunoExibicao = subMenuAlunoExibicao;
	}

	public Boolean getSubMenuAlunoExclusao() {
		return subMenuAlunoExclusao;
	}

	public void setSubMenuAlunoExclusao(Boolean subMenuAlunoExclusao) {
		this.subMenuAlunoExclusao = subMenuAlunoExclusao;
	}

	public Boolean getSubMenuPerfil() {
		return subMenuPerfil;
	}

	public void setSubMenuPerfil(Boolean subMenuPerfil) {
		this.subMenuPerfil = subMenuPerfil;
	}

	public Boolean getSubMenuPerfilInclusao() {
		return subMenuPerfilInclusao;
	}

	public void setSubMenuPerfilInclusao(Boolean subMenuPerfilInclusao) {
		this.subMenuPerfilInclusao = subMenuPerfilInclusao;
	}

	public Boolean getSubMenuPerfilAlteracao() {
		return subMenuPerfilAlteracao;
	}

	public void setSubMenuPerfilAlteracao(Boolean subMenuPerfilAlteracao) {
		this.subMenuPerfilAlteracao = subMenuPerfilAlteracao;
	}

	public Boolean getSubMenuPerfilExibicao() {
		return subMenuPerfilExibicao;
	}

	public void setSubMenuPerfilExibicao(Boolean subMenuPerfilExibicao) {
		this.subMenuPerfilExibicao = subMenuPerfilExibicao;
	}

	public Boolean getSubMenuPerfilExclusao() {
		return subMenuPerfilExclusao;
	}

	public void setSubMenuPerfilExclusao(Boolean subMenuPerfilExclusao) {
		this.subMenuPerfilExclusao = subMenuPerfilExclusao;
	}

	public Boolean getSubMenuUsuario() {
		return subMenuUsuario;
	}

	public void setSubMenuUsuario(Boolean subMenuUsuario) {
		this.subMenuUsuario = subMenuUsuario;
	}

	public Boolean getSubMenuUsuarioInclusao() {
		return subMenuUsuarioInclusao;
	}

	public void setSubMenuUsuarioInclusao(Boolean subMenuUsuarioInclusao) {
		this.subMenuUsuarioInclusao = subMenuUsuarioInclusao;
	}

	public Boolean getSubMenuUsuarioAlteracao() {
		return subMenuUsuarioAlteracao;
	}

	public void setSubMenuUsuarioAlteracao(Boolean subMenuUsuarioAlteracao) {
		this.subMenuUsuarioAlteracao = subMenuUsuarioAlteracao;
	}

	public Boolean getSubMenuUsuarioExibicao() {
		return subMenuUsuarioExibicao;
	}

	public void setSubMenuUsuarioExibicao(Boolean subMenuUsuarioExibicao) {
		this.subMenuUsuarioExibicao = subMenuUsuarioExibicao;
	}

	public Boolean getSubMenuUsuarioExclusao() {
		return subMenuUsuarioExclusao;
	}

	public void setSubMenuUsuarioExclusao(Boolean subMenuUsuarioExclusao) {
		this.subMenuUsuarioExclusao = subMenuUsuarioExclusao;
	}

	public Boolean getSubMenuTurma() {
		return subMenuTurma;
	}

	public void setSubMenuTurma(Boolean subMenuTurma) {
		this.subMenuTurma = subMenuTurma;
	}

	public Boolean getSubMenuTurmaInclusao() {
		return subMenuTurmaInclusao;
	}

	public void setSubMenuTurmaInclusao(Boolean subMenuTurmaInclusao) {
		this.subMenuTurmaInclusao = subMenuTurmaInclusao;
	}

	public Boolean getSubMenuTurmaAlteracao() {
		return subMenuTurmaAlteracao;
	}

	public void setSubMenuTurmaAlteracao(Boolean subMenuTurmaAlteracao) {
		this.subMenuTurmaAlteracao = subMenuTurmaAlteracao;
	}

	public Boolean getSubMenuTurmaExibicao() {
		return subMenuTurmaExibicao;
	}

	public void setSubMenuTurmaExibicao(Boolean subMenuTurmaExibicao) {
		this.subMenuTurmaExibicao = subMenuTurmaExibicao;
	}

	public Boolean getSubMenuTurmaExclusao() {
		return subMenuTurmaExclusao;
	}

	public void setSubMenuTurmaExclusao(Boolean subMenuTurmaExclusao) {
		this.subMenuTurmaExclusao = subMenuTurmaExclusao;
	}

	public Boolean getSubMenuDisciplina() {
		return subMenuDisciplina;
	}

	public void setSubMenuDisciplina(Boolean subMenuDisciplina) {
		this.subMenuDisciplina = subMenuDisciplina;
	}

	public Boolean getSubMenuDisciplinaInclusao() {
		return subMenuDisciplinaInclusao;
	}

	public void setSubMenuDisciplinaInclusao(Boolean subMenuDisciplinaInclusao) {
		this.subMenuDisciplinaInclusao = subMenuDisciplinaInclusao;
	}

	public Boolean getSubMenuDisciplinaAlteracao() {
		return subMenuDisciplinaAlteracao;
	}

	public void setSubMenuDisciplinaAlteracao(Boolean subMenuDisciplinaAlteracao) {
		this.subMenuDisciplinaAlteracao = subMenuDisciplinaAlteracao;
	}

	public Boolean getSubMenuDisciplinaExibicao() {
		return subMenuDisciplinaExibicao;
	}

	public void setSubMenuDisciplinaExibicao(Boolean subMenuDisciplinaExibicao) {
		this.subMenuDisciplinaExibicao = subMenuDisciplinaExibicao;
	}

	public Boolean getSubMenuDisciplinaExclusao() {
		return subMenuDisciplinaExclusao;
	}

	public void setSubMenuDisciplinaExclusao(Boolean subMenuDisciplinaExclusao) {
		this.subMenuDisciplinaExclusao = subMenuDisciplinaExclusao;
	}

}
