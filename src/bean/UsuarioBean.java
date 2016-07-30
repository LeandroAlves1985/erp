package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import repositorio.UsuarioDao;
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Usuario usuarioLogado;
	private UsuarioDao usuarioDao;
	
	@PostConstruct
	public void construct(){
		usuario = new Usuario();
		usuarioLogado = new Usuario();
		usuarioDao = new UsuarioDao();
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
			usuarioDao.criptografia(usuario);
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

}
