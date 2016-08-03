package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelo.Perfil;
import modelo.Usuario;
import repositorio.DisciplinaDao;
import repositorio.PerfilDao;
import repositorio.UsuarioDao;
@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Usuario usuarioLogado;
	private Usuario usuarioSelecionado;
	private Usuario usuarioEdicao;
	private Perfil  perfil;
	
	private UsuarioDao usuarioDao;
	private List<Usuario> todosUsuarios;
	
	
	@PostConstruct
	public void construct(){
		usuario = new Usuario();
		usuarioSelecionado = new Usuario();
		usuarioEdicao = new Usuario();
		usuarioLogado = new Usuario();
		usuarioDao = new UsuarioDao();
		todosUsuarios = new ArrayList<Usuario>();
		perfil = new Perfil();
	}

	
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public List<Usuario> getTodosUsuarios() {
		todosUsuarios = usuarioDao.findAll();
		return todosUsuarios;
	}

	public void setTodosUsuarios(List<Usuario> todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
		
	public String logar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			usuarioLogado = usuarioDao.logar(usuario);
			if(usuarioLogado!=null){
				HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
				HttpSession session = request.getSession(true);
				session.setAttribute("usuarioLogado", usuarioLogado);				
				return "/logado/menu.jsf?faces-redirect=true";
				
			} else{
				usuario = new Usuario();
				throw new Exception("Acesso Negado");
			}
			
		} catch (Exception e) {
			fc.addMessage("formLogin", new FacesMessage("Erro " + e.getMessage()));
		}
		return null;
	}
	
	public String deslogar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("usuarioLogado");
			session.invalidate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/login.jsf";
	}
	
	public void filtrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			if(session.getAttribute("usuarioLogado")==null){
				fc.getExternalContext().redirect("login.jsf?erro=true");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	public void salvar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {			
						
			if(! (usuarioDao.findByLogin(usuario.getLogin()) == null)){			 
				fc.addMessage("formUsuario", new FacesMessage("Login ja cadastrado"));
			}else{
				
				usuarioEdicao.setPerfil(new PerfilDao().findByCod(perfil.getId()));
				usuarioDao.create(usuarioEdicao);
				usuario = new Usuario();
				fc.addMessage("formUsuario", new FacesMessage("Usuario cadastrado com sucesso"));	
			}			
					
		} catch (Exception e) {
			fc.addMessage("formUsuario", new FacesMessage("Erro ao cadastrar usuario" + e.getMessage()));
		}
	}
	
	
	
	
	public void editar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			
			usuarioDao.update(usuarioEdicao);
			construct();
			fc.addMessage("formUsuario", new FacesMessage("Usuario atualizado com sucesso"));			
		} catch (Exception e) {
			fc.addMessage("formUsuario", new FacesMessage("Erro ao atualizar usuario" + e.getMessage()));
		}
	}
	
	

	public void remover(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			
			usuarioDao.delete(usuarioSelecionado);	
			fc.addMessage("formUsuario", new FacesMessage("Usuario excluido com sucesso"));			
			usuarioDao.findAll();
		} catch (Exception e) {
			fc.addMessage("formUsuario", new FacesMessage("Erro ao excluir usuario" + e.getMessage()));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
