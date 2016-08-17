package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.lavieri.modelutil.cep.WebServiceCep;

import modelo.Endereco;
import modelo.Perfil;
import modelo.Professor;
import modelo.Telefone;
import modelo.Usuario;
import repositorio.EnderecoDao;
import repositorio.PerfilDao;
import repositorio.ProfessorDao;
import repositorio.TelefoneDao;
import repositorio.UsuarioDao;

@ManagedBean(name = "professorBean")
@ViewScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Professor professorEdicao;
	private Professor professorSelecionado;
	private ProfessorDao professorDao;
	private Endereco enderecoEdicao;
	private Telefone telefoneEdicao;
	private EnderecoDao enderecoDao;
	private TelefoneDao telefoneDao;
	private List<Professor> todosProfessores;
	private Boolean visualizar;
	private Usuario usuarioEdicao;
	private Perfil perfilEdicao;
	private Perfil perfilSalvo;
	
	private String mbCep="";

	@PostConstruct
	public void construct() {
		professorEdicao = new Professor();
		professorSelecionado = new Professor();
		enderecoEdicao = new Endereco();
		telefoneEdicao = new Telefone();
		professorDao = new ProfessorDao();
		enderecoDao = new EnderecoDao();
		telefoneDao = new TelefoneDao();
		usuarioEdicao = new Usuario();
		perfilEdicao = new Perfil();
		perfilSalvo = new Perfil();
	}

	public Professor getProfessorEdicao() {
		return professorEdicao;
	}

	public void setProfessorEdicao(Professor professorEdicao) {
		this.professorEdicao = professorEdicao;
	}

	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public ProfessorDao getProfessorDao() {
		return professorDao;
	}

	public void setProfessorDao(ProfessorDao professorDao) {
		this.professorDao = professorDao;
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

	public List<Professor> getTodosProfessores() {
		todosProfessores = professorDao.findAll();
		return todosProfessores;
	}

	public void setTodosProfessores(List<Professor> todosProfessores) {
		this.todosProfessores = todosProfessores;
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
	
	public String getMbCep() {
		return mbCep;
	}

	public void setMbCep(String mbCep) {
		this.mbCep = mbCep;
	}

	public void preparaEdicao() {
		enderecoEdicao = professorEdicao.getEndereco();
		telefoneEdicao = professorEdicao.getTelefone();
		usuarioEdicao = professorEdicao.getUsuario();
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		enderecoEdicao = professorEdicao.getEndereco();
		telefoneEdicao = professorEdicao.getTelefone();
		usuarioEdicao = professorEdicao.getUsuario();
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = true;
	}

	public void preparaNovoCadastro() {
		professorEdicao = new Professor();
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
			professorEdicao.setUsuario(usuarioEdicao);
			professorEdicao.setEndereco(enderecoEdicao);
			professorEdicao.setTelefone(telefoneEdicao);
			new UsuarioDao().create(usuarioEdicao);
			enderecoDao.create(enderecoEdicao);
			telefoneDao.create(telefoneEdicao);
			professorDao.create(professorEdicao);
			construct();
			todosProfessores = professorDao.findAll();
			fc.addMessage("formProf", new FacesMessage("Professor cadastrado com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formProf", new FacesMessage("Erro ao cadastrar professor!" + e.getMessage()));
		}
	}

	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			perfilSalvo = new PerfilDao().porNome(perfilEdicao);
			usuarioEdicao.setPerfil(perfilSalvo);
			professorEdicao.setUsuario(usuarioEdicao);
			professorEdicao.setEndereco(enderecoEdicao);
			professorEdicao.setTelefone(telefoneEdicao);
			new UsuarioDao().update(usuarioEdicao);
			enderecoDao.update(enderecoEdicao);
			telefoneDao.update(telefoneEdicao);
			professorDao.update(professorEdicao);
			construct();
			todosProfessores = professorDao.findAll();
			fc.addMessage("formProf", new FacesMessage("Professor atualizado com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formProf", new FacesMessage("Erro ao atualizar professor!" + e.getMessage()));
		}
	}

	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			professorDao.delete(professorSelecionado);
			todosProfessores = professorDao.findAll();
			fc.addMessage("formProf", new FacesMessage("Professor excluído com sucesso!"));

		} catch (Exception e) {
			fc.addMessage("formProf", new FacesMessage("Erro ao excluir professor!" + e.getMessage()));
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
	   			 fc.addMessage("formFunc", new FacesMessage("Cep Encontrado"));
	   			  
	   	   }else{
	   		   enderecoEdicao = new Endereco();
	   		   mbCep = "";
	   		   fc.addMessage("formFunc", new FacesMessage("Cep não localizado"));
	   	   }		 
	   		
			} catch (Exception e) {
				 fc.addMessage("formFunc", new FacesMessage("Error:" + e.getMessage()));
			}
	    }
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
