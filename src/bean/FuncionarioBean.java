package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import repositorio.EnderecoDao;
import repositorio.FuncionarioDao;
import repositorio.PerfilDao;
import repositorio.ProfessorDao;
import repositorio.TelefoneDao;
import repositorio.UsuarioDao;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Perfil;
import modelo.Professor;
import modelo.Telefone;
import modelo.Usuario;

@ManagedBean(name="funcionarioBean")
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionarioEdicao;
	private Funcionario funcionarioSelecionado;
	private FuncionarioDao funcionarioDao;
	private Endereco enderecoEdicao;
	private Telefone telefoneEdicao;
	private EnderecoDao enderecoDao;
	private TelefoneDao telefoneDao;
	private List<Funcionario> todosFuncionarios;
	private Boolean visualizar;
	private Usuario usuarioEdicao;
	private Perfil perfilEdicao;
	private Perfil perfilSalvo;

	@PostConstruct
	public void construct() {
		funcionarioEdicao = new Funcionario();
		funcionarioSelecionado = new Funcionario();
		enderecoEdicao = new Endereco();
		telefoneEdicao = new Telefone();
		funcionarioDao = new FuncionarioDao();
		enderecoDao = new EnderecoDao();
		telefoneDao = new TelefoneDao();
		usuarioEdicao = new Usuario();
		perfilEdicao = new Perfil();
		perfilSalvo = new Perfil();
	}

	public Funcionario getFuncionarioEdicao() {
		return funcionarioEdicao;
	}

	public void setFuncionarioEdicao(Funcionario funcionarioEdicao) {
		this.funcionarioEdicao = funcionarioEdicao;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}

	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
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

	public List<Funcionario> getTodosFuncionarios() {
		todosFuncionarios = funcionarioDao.findAll();
		return todosFuncionarios;
	}

	public void setTodosFuncionarios(List<Funcionario> todosFuncionarios) {
		this.todosFuncionarios = todosFuncionarios;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public void preparaEdicao() {
		enderecoEdicao = funcionarioEdicao.getEndereco();
		telefoneEdicao = funcionarioEdicao.getTelefone();
		usuarioEdicao = funcionarioEdicao.getUsuario();
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		enderecoEdicao = funcionarioEdicao.getEndereco();
		telefoneEdicao = funcionarioEdicao.getTelefone();
		usuarioEdicao = funcionarioEdicao.getUsuario();
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = true;
	}

	public void preparaNovoCadastro() {
		funcionarioEdicao = new Funcionario();
		enderecoEdicao = new Endereco();
		telefoneEdicao = new Telefone();
		usuarioEdicao = new Usuario();
		perfilEdicao = new Perfil();
	}


	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			perfilSalvo = new PerfilDao().porNome(perfilEdicao);
			usuarioEdicao.setPerfil(perfilSalvo);
			funcionarioEdicao.setUsuario(usuarioEdicao);
			funcionarioEdicao.setEndereco(enderecoEdicao);
			funcionarioEdicao.setTelefone(telefoneEdicao);
			new UsuarioDao().create(usuarioEdicao);
			enderecoDao.create(enderecoEdicao);
			telefoneDao.create(telefoneEdicao);
			funcionarioDao.create(funcionarioEdicao);
			construct();
			todosFuncionarios = funcionarioDao.findAll();
			fc.addMessage("formFunc", new FacesMessage("Funcionario cadastrado com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formFunc", new FacesMessage("Erro ao cadastrar funcionario!" + e.getMessage()));
		}
	}

	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			perfilSalvo = new PerfilDao().porNome(perfilEdicao);
			usuarioEdicao.setPerfil(perfilSalvo);
			funcionarioEdicao.setUsuario(usuarioEdicao);
			funcionarioEdicao.setEndereco(enderecoEdicao);
			funcionarioEdicao.setTelefone(telefoneEdicao);
			new UsuarioDao().update(usuarioEdicao);
			enderecoDao.update(enderecoEdicao);
			telefoneDao.update(telefoneEdicao);
			funcionarioDao.update(funcionarioEdicao);
			construct();
			todosFuncionarios = funcionarioDao.findAll();
			fc.addMessage("formFunc", new FacesMessage("Funcionario atualizado com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formFunc", new FacesMessage("Erro ao atualizar funcionario!" + e.getMessage()));
		}
	}

	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			funcionarioDao.delete(funcionarioSelecionado);
			todosFuncionarios = funcionarioDao.findAll();
			fc.addMessage("formFunc", new FacesMessage("Funcionario excluído com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formFunc", new FacesMessage("Erro ao excluir funcionario!" + e.getMessage()));
		}
	}













}
