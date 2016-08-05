package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import repositorio.PerfilDao;
import repositorio.UsuarioDao;
import modelo.Perfil;
import modelo.Usuario;

@ManagedBean(name="usuarioCadBean")
@ViewScoped
public class UsuarioCadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Usuario usuarioSelecionado;
	private Usuario usuarioEdicao;
	private UsuarioDao dao;
	private Perfil perfilEdicao;
	private List<Usuario> todosUsuarios;
	
	private Boolean visualizar;

	@PostConstruct
	public void construct() {
		
		usuarioSelecionado = new Usuario();
		usuarioEdicao = new Usuario();		
		todosUsuarios = new ArrayList<Usuario>();
		perfilEdicao = new Perfil();
		dao = new UsuarioDao();
	}

	
	public Boolean getVisualizar() {
		return visualizar;
	}


	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}


	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}


	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
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

	public List<Usuario> getTodosUsuarios() {
		todosUsuarios = new UsuarioDao().findAll();
		return todosUsuarios;
	}

	public void setTodosUsuarios(List<Usuario> todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	 public Boolean validarLogin(){
//		 FacesContext fc = FacesContext.getCurrentInstance();				  
//		 if (new UsuarioDao().findByLogin(usuarioEdicao.getLogin())!=null ){			 
//		      return true;
//		 }else{
//			 return false;	 
//		 }	
//	 }	
	
	public void preparaEdicao() {
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = false;
	}

	public void preparaVisualizacao() {
		perfilEdicao = usuarioEdicao.getPerfil();
		visualizar = true;
	}
	
	
	
	
	
	
	
	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
				
			if (dao.findByLogin(usuarioEdicao.getLogin())!=null) {
				fc.addMessage("formUsuario", new FacesMessage("Login ja cadastrado"));
			} else {				
				usuarioEdicao.setPerfil(new PerfilDao().findByCod(perfilEdicao.getId()));
				dao.create(usuarioEdicao);
				construct();
				fc.addMessage("formUsuario", new FacesMessage("Usuario cadastrado com sucesso"));
			}

		} catch (Exception e) {
			fc.addMessage("formUsuario", new FacesMessage("Erro ao cadastrar usuario" + e.getMessage()));
		}
	}

	
	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			usuarioEdicao.setPerfil(new PerfilDao().findByCod(perfilEdicao.getId()));
			dao.update(usuarioEdicao);
			construct();	
			fc.addMessage("formUsuario", new FacesMessage("Usuario atualizado com sucesso"));
		
		} catch (Exception e) {
			fc.addMessage("formUsuario", new FacesMessage("Erro ao atualizar usuario" + e.getMessage()));
		}
	}

	
	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			dao.delete(usuarioSelecionado);
			new UsuarioDao().findAll();
			fc.addMessage("formUsuario", new FacesMessage("Usuario excluido com sucesso"));
		
		} catch (Exception e) {
			fc.addMessage("formUsuario", new FacesMessage("Erro ao excluir usuario" + e.getMessage()));
		}
	}

}
