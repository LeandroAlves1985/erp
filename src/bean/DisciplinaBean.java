package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import repositorio.DisciplinaDao;
import repositorio.PerfilDao;
import modelo.Disciplina;
@ManagedBean(name="disciplinaBean")
@ViewScoped
public class DisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Disciplina disciplina;
	private List<Disciplina>  todasDisciplinas;
	private DisciplinaDao     disciplinaDao;
	
	@PostConstruct
	public void construct(){
		disciplina = new Disciplina();
		todasDisciplinas = new ArrayList<Disciplina>();
		disciplinaDao = new DisciplinaDao();
	}

	

	public DisciplinaDao getDisciplinaDao() {
		return disciplinaDao;
	}



	public void setDisciplinaDao(DisciplinaDao disciplinaDao) {
		this.disciplinaDao = disciplinaDao;
	}



	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public List<Disciplina> getTodasDisciplinas() {
		todasDisciplinas = new DisciplinaDao().findAll();
		return todasDisciplinas;
	}


	public void setTodasDisciplinas(List<Disciplina> todasDisciplinas) {
		this.todasDisciplinas = todasDisciplinas;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public void salvar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			
			disciplinaDao.create(disciplina);
			construct();
			fc.addMessage("formDisciplina", new FacesMessage("Disciplina cadastrada com sucesso"));			
		} catch (Exception e) {
			fc.addMessage("formDisciplina", new FacesMessage("Erro ao cadastrar disciplina" + e.getMessage()));
		}
	}
	
	
	public void editar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			
			disciplinaDao.update(disciplina);		
			construct();
			fc.addMessage("formDisciplina", new FacesMessage("Disciplina atualizada com sucesso"));			
		} catch (Exception e) {
			fc.addMessage("formDisciplina", new FacesMessage("Erro ao atualizar disciplina" + e.getMessage()));
		}
	}
	
	

	public void remover(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			
			disciplinaDao.delete(disciplina);	
			fc.addMessage("formDisciplina", new FacesMessage("Disciplina excluida com sucesso!"));			
			disciplinaDao.findAll();
		} catch (Exception e) {
			fc.addMessage("formDisciplina", new FacesMessage("Erro ao cadastrar disciplina" + e.getMessage()));
		}
	}
	
	
	
	
	
}
