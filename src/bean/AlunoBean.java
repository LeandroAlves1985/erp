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
import modelo.Endereco;
import modelo.Nota;
import modelo.Perfil;
import modelo.Telefone;
import modelo.Turma;
import modelo.Usuario;
import repositorio.AlunoDao;
import repositorio.EnderecoDao;
import repositorio.NotaDao;
import repositorio.PerfilDao;
import repositorio.TelefoneDao;
import repositorio.TurmaDao;
import repositorio.UsuarioDao;

//teste
@ManagedBean(name = "alunoBean")
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno alunoEdicao;
	private Aluno alunoSelecionado;
	private List<Aluno> todosAlunos;
	private AlunoDao alunoDao;
	private Boolean visualizar;
	private Endereco enderecoEdicao;
	private Telefone telefoneEdicao;
	private EnderecoDao enderecoDao;
	private TelefoneDao telefoneDao;
	private Usuario usuarioEdicao;
	private Perfil perfilEdicao;
	private Perfil perfilSalvo;
	private Turma turmaEdicao;
	private List<Turma> turmasPorAluno;
	private Turma turmaSelecionada;
	private Disciplina disciplinaEdicao;
	private Disciplina disciplinaSelecionada;
	private List<Disciplina> todasDisciplinasPorTurma;
	private Nota notaEdicao;
	private Nota notaSelecionada;

	@PostConstruct
	public void construct() {
		alunoEdicao = null;
		alunoSelecionado = null;
		enderecoEdicao = new Endereco();
		telefoneEdicao = new Telefone();
		alunoDao = new AlunoDao();
		enderecoDao = new EnderecoDao();
		telefoneDao = new TelefoneDao();
		turmaEdicao = null;
		turmaSelecionada = null;
		usuarioEdicao = new Usuario();
		perfilEdicao = new Perfil();
		perfilSalvo = new Perfil();
		disciplinaEdicao = null;
		disciplinaSelecionada = null;
		notaEdicao = null;
		notaSelecionada = null;
	}

	public Turma getTurmaEdicao() {
		return turmaEdicao;
	}

	public void setTurmaEdicao(Turma turmaEdicao) {
		this.turmaEdicao = turmaEdicao;
	}

	public Aluno getAlunoEdicao() {
		return alunoEdicao;
	}

	public void setAlunoEdicao(Aluno alunoEdicao) {
		this.alunoEdicao = alunoEdicao;
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public List<Aluno> getTodosAlunos() {
		todosAlunos = alunoDao.findAll();
		return todosAlunos;
	}

	public void setTodosAlunos(List<Aluno> todosAlunos) {
		this.todosAlunos = todosAlunos;
	}

	public AlunoDao getAlunoDao() {
		return alunoDao;
	}

	public void setAlunoDao(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}

	public Endereco getEnderecoEdicao() {
		return enderecoEdicao;
	}

	public void setEnderecoEdicao(Endereco enderecoEdicao) {
		this.enderecoEdicao = enderecoEdicao;
	}

	public Telefone getTelefoneEdicao() {
		return telefoneEdicao;
	}

	public void setTelefoneEdicao(Telefone telefoneEdicao) {
		this.telefoneEdicao = telefoneEdicao;
	}

	public EnderecoDao getEnderecoDao() {
		return enderecoDao;
	}

	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}

	public TelefoneDao getTelefoneDao() {
		return telefoneDao;
	}

	public void setTelefoneDao(TelefoneDao telefoneDao) {
		this.telefoneDao = telefoneDao;
	}

	public Usuario getUsuarioEdicao() {
		return usuarioEdicao;
	}

	public void setUsuarioEdicao(Usuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

	public Perfil getPerfilEdicao() {
		return perfilEdicao;
	}

	public void setPerfilEdicao(Perfil perfilEdicao) {
		this.perfilEdicao = perfilEdicao;
	}

	public Perfil getPerfilSalvo() {
		return perfilSalvo;
	}

	public void setPerfilSalvo(Perfil perfilSalvo) {
		this.perfilSalvo = perfilSalvo;

	}

	public List<Turma> getTurmasPorAluno() {
		return turmasPorAluno;
	}

	public void setTurmasPorAluno(List<Turma> turmasPorAluno) {
		this.turmasPorAluno = turmasPorAluno;
	}

	public Turma getTurmaSelecionada() {
		return turmaSelecionada;
	}

	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
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

	public List<Disciplina> getTodasDisciplinasPorTurma() {
		return todasDisciplinasPorTurma;
	}

	public void setTodasDisciplinasPorTurma(
			List<Disciplina> todasDisciplinasPorTurma) {
		this.todasDisciplinasPorTurma = todasDisciplinasPorTurma;
	}

	public Nota getNotaEdicao() {
		return notaEdicao;
	}

	public void setNotaEdicao(Nota notaEdicao) {
		this.notaEdicao = notaEdicao;
	}

	public Nota getNotaSelecionada() {
		return notaSelecionada;
	}

	public void setNotaSelecionada(Nota notaSelecionada) {
		this.notaSelecionada = notaSelecionada;
	}

	public void preparaNovoCadastro(){
		alunoEdicao = new Aluno();
		alunoSelecionado = new Aluno();
	}

	public void preparaEdicao() {
		turmaEdicao = new Turma();
		turmaSelecionada = new Turma();		
		enderecoEdicao = alunoEdicao.getEndereco();
		telefoneEdicao = alunoEdicao.getTelefone();
		usuarioEdicao = alunoEdicao.getUsuario();
		perfilEdicao = usuarioEdicao.getPerfil();
		turmasPorAluno = new AlunoDao().turmaPorAluno(alunoEdicao);
		disciplinaEdicao = new Disciplina();
		disciplinaSelecionada = new Disciplina();
		notaEdicao = new Nota();
		notaSelecionada = new Nota();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		enderecoEdicao = alunoEdicao.getEndereco();
		telefoneEdicao = alunoEdicao.getTelefone();
		usuarioEdicao = alunoEdicao.getUsuario();
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = true;
	}

	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			perfilSalvo = new PerfilDao().porNome(perfilEdicao);
			usuarioEdicao.setPerfil(perfilSalvo);
			alunoEdicao.setUsuario(usuarioEdicao);
			alunoEdicao.setEndereco(enderecoEdicao);
			alunoEdicao.setTelefone(telefoneEdicao);
			new UsuarioDao().create(usuarioEdicao);
			enderecoDao.create(enderecoEdicao);
			telefoneDao.create(telefoneEdicao);
			alunoDao.create(alunoEdicao);
			construct();
			todosAlunos = alunoDao.findAll();
			fc.addMessage("formAluno", new FacesMessage(
					"Aluno cadastrado com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage(
					"Erro ao cadastrar aluno!" + e.getMessage()));
		}
	}

	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			perfilSalvo = new PerfilDao().porNome(perfilEdicao);
			usuarioEdicao.setPerfil(perfilSalvo);
			alunoEdicao.setUsuario(usuarioEdicao);
			alunoEdicao.setEndereco(enderecoEdicao);
			alunoEdicao.setTelefone(telefoneEdicao);
			new UsuarioDao().update(usuarioEdicao);
			enderecoDao.update(enderecoEdicao);
			telefoneDao.update(telefoneEdicao);
			alunoDao.update(alunoEdicao);
			construct();
			todosAlunos = alunoDao.findAll();
			fc.addMessage("formAluno", new FacesMessage(
					"Aluno atualizado com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage(
					"Erro ao atualizar aluno!" + e.getMessage()));
		}
	}

	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			alunoDao.delete(alunoSelecionado);
			todosAlunos = alunoDao.findAll();
			fc.addMessage("formAluno", new FacesMessage(
					"Aluno excluído com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage(
					"Erro ao excluir aluno!" + e.getMessage()));
		}
	}
	
	public void salvaAlunoTurma() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			turmaEdicao = new TurmaDao().porNome(turmaSelecionada);
			List<Turma> turmas = alunoDao.turmaPorAluno(alunoEdicao);
			turmas.add(turmaEdicao);
			alunoEdicao.setTurmas(turmas);
			alunoDao.update(alunoEdicao);
			turmasPorAluno = alunoDao.turmaPorAluno(alunoEdicao);			
			fc.addMessage("formAluno", new FacesMessage("Turma alocado com sucesso!"));		

		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage("Erro ao alocar turma!"));
		}
	}
	
	public void removerTurma() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			List<Turma> turmas = alunoDao.turmaPorAluno(alunoEdicao);
			turmas.remove(turmaEdicao);
			alunoEdicao.setTurmas(turmas);
			alunoDao.update(alunoEdicao);
			turmasPorAluno = new AlunoDao().turmaPorAluno(alunoEdicao);	
			
			fc.addMessage("formAluno", new FacesMessage("Turma removida com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage("Erro ao remover turma!" + e.getMessage()));
		}
	}
	
	public void preparaListaDisciplina(){
		todasDisciplinasPorTurma = new TurmaDao().disciplinaPorTurma(turmaEdicao);
	}
	
	public void preparaListaNotas(){
		notaEdicao = new NotaDao().porAluno(alunoEdicao, turmaEdicao, disciplinaSelecionada);
		notaEdicao.setMedia(notaEdicao.getNota1() + notaEdicao.getNota2() + notaEdicao.getNota3() + notaEdicao.getNota4() / 4);
		if(notaEdicao.getMedia()>6.9){
			notaEdicao.setSituacao("APROVADO");
		} else{
			notaEdicao.setSituacao("REPROVADO");
		}
	}
	
	public void salvaNota(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {			
			if(notaEdicao.getId()==null){
				notaEdicao.setAluno(alunoEdicao);
				notaEdicao.setTurma(turmaEdicao);
				notaEdicao.setDisciplina(disciplinaSelecionada);
				new NotaDao().create(notaEdicao);
				fc.addMessage("formAluno", new FacesMessage("Nota cadastrada com sucesso!"));
			} else{
				new NotaDao().update(notaEdicao);
				fc.addMessage("formAluno", new FacesMessage("Nota atualizada com sucesso!"));
			}		
			
		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage("Erro ao cadastrar nota!" + e.getMessage()));
		}
	}
	

}
