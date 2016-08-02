package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Endereco;
import modelo.Professor;
import modelo.Telefone;
import repositorio.EnderecoDao;
import repositorio.ProfessorDao;
import repositorio.TelefoneDao;

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
	
	@PostConstruct
	public void construct(){
		professorEdicao = new Professor();
		professorSelecionado = new Professor();
		enderecoEdicao = new Endereco();
		telefoneEdicao = new Telefone();
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
	
	public void preparaEdicao(){
		enderecoEdicao = professorEdicao.getEndereco();
		telefoneEdicao = professorEdicao.getTelefone();
		visualizar = false;
	}
	
	public void preparaVisualizacao(){
		enderecoEdicao = professorEdicao.getEndereco();
		telefoneEdicao = professorEdicao.getTelefone();
		visualizar = true;
	}
	
	public void salvar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			professorEdicao.setEndereco(enderecoEdicao);
			professorEdicao.setTelefone(telefoneEdicao);
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
	
	public void editar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			professorEdicao.setEndereco(enderecoEdicao);
			professorEdicao.setTelefone(telefoneEdicao);
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
	
	public void remover(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			professorDao.delete(professorSelecionado);
			todosProfessores = professorDao.findAll();
			fc.addMessage("formProf",  new FacesMessage("Professor excluído com sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formProf", new FacesMessage("Erro ao excluir professor!" + e.getMessage()));
		}
	}
	

}
