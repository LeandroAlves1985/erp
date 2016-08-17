package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.lavieri.modelutil.cep.WebServiceCep;

import modelo.Aluno;
import modelo.Endereco;
import modelo.Perfil;
import modelo.Telefone;
import modelo.Turma;
import modelo.Usuario;
import repositorio.AlunoDao;
import repositorio.EnderecoDao;
import repositorio.PerfilDao;
import repositorio.TelefoneDao;
import repositorio.UsuarioDao;

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
	
	private String mbCep="";

	@PostConstruct
	public void construct() {
		alunoEdicao = new Aluno();
		alunoSelecionado = new Aluno();
		enderecoEdicao = new Endereco();
		telefoneEdicao = new Telefone();
		alunoDao = new AlunoDao();
		enderecoDao = new EnderecoDao();
		telefoneDao = new TelefoneDao();
		turmaEdicao = new Turma();
		usuarioEdicao = new Usuario();
		perfilEdicao = new Perfil();
		perfilSalvo = new Perfil();
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
	
	public String getMbCep() {
		return mbCep;
	}

	public void setMbCep(String mbCep) {
		this.mbCep = mbCep;
	}

	public void preparaEdicao() {
		enderecoEdicao = alunoEdicao.getEndereco();
		telefoneEdicao = alunoEdicao.getTelefone();
		usuarioEdicao = alunoEdicao.getUsuario();
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		enderecoEdicao = alunoEdicao.getEndereco();
		telefoneEdicao = alunoEdicao.getTelefone();
		usuarioEdicao = alunoEdicao.getUsuario();
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = true;
	}

	public void preparaNovoCadastro() {
		alunoEdicao = new Aluno();
		enderecoEdicao = new Endereco();
		telefoneEdicao = new Telefone();
		turmaEdicao = new Turma();
		usuarioEdicao = new Usuario();
		perfilEdicao = new Perfil();
		visualizar = false;
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
			fc.addMessage("formAluno", new FacesMessage("Aluno cadastrado com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formAluno", new FacesMessage("Erro ao cadastrar aluno!" + e.getMessage()));
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

	
	public void buscaCep(){
   	 FacesContext fc = FacesContext.getCurrentInstance();
   	  try {
			 
   		  WebServiceCep cep = WebServiceCep.searchCep(mbCep);    		  
   		  if(cep.wasSuccessful()){
   			  enderecoEdicao.setCep(mbCep);
   			  enderecoEdicao.setRua(cep.getLogradouro());
   			  enderecoEdicao.setBairro(cep.getBairro());
   			  enderecoEdicao.setCidade(cep.getCidade());
   			  enderecoEdicao.setUf(cep.getUf());
   			 fc.addMessage("formAluno", new FacesMessage("Cep Encontrado"));
   			  
   	   }else{
   		   enderecoEdicao = new Endereco();
   		   mbCep = "";
   		   fc.addMessage("formAluno", new FacesMessage("Cep não localizado"));
   	   }		 
   		
		} catch (Exception e) {
			 fc.addMessage("formAluno", new FacesMessage("Error:" + e.getMessage()));
		}
    }
	
	
	
	
}
