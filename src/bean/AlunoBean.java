package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Aluno;
import modelo.Endereco;
import modelo.Telefone;
import repositorio.AlunoDao;
import repositorio.EnderecoDao;
import repositorio.TelefoneDao;

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

	@PostConstruct
	public void construct() {
		alunoEdicao = new Aluno();
		alunoSelecionado = new Aluno();
		enderecoEdicao = new Endereco();
		telefoneEdicao = new Telefone();
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

	public void preparaEdicao() {
		enderecoEdicao = alunoEdicao.getEndereco();
		telefoneEdicao = alunoEdicao.getTelefone();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		enderecoEdicao = alunoEdicao.getEndereco();
		telefoneEdicao = alunoEdicao.getTelefone();
		visualizar = true;
	}

	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			alunoEdicao.setEndereco(enderecoEdicao);
			alunoEdicao.setTelefone(telefoneEdicao);
			enderecoDao.create(enderecoEdicao);
			telefoneDao.create(telefoneEdicao);
			alunoDao.create(alunoEdicao);
			construct();
			todosAlunos = alunoDao.findAll();
			fc.addMessage("formAluno", new FacesMessage("Aluno cadastrado com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage("Erro ao cadastrar aluno!" + e.getMessage()));
		}
	}
	
	public void editar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			alunoEdicao.setEndereco(enderecoEdicao);
			alunoEdicao.setTelefone(telefoneEdicao);
			enderecoDao.update(enderecoEdicao);
			telefoneDao.update(telefoneEdicao);
			alunoDao.update(alunoEdicao);
			construct();
			todosAlunos = alunoDao.findAll();
			fc.addMessage("formAluno", new FacesMessage("Aluno atualizado com sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage("Erro ao atualizar aluno!" + e.getMessage()));
		}
	}
	
	public void remover(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			alunoDao.delete(alunoSelecionado);
			todosAlunos = alunoDao.findAll();
			fc.addMessage("formAluno", new FacesMessage("Aluno excluído com sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage("Erro ao excluir aluno!" + e.getMessage()));
		}
	}

}
