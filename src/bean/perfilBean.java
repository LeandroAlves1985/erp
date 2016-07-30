package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Menu;
import modelo.Perfil;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;

import repositorio.PerfilDao;
@ManagedBean(name = "perfilBean")
@ViewScoped
public class perfilBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Perfil perfil;
	private Perfil perfilEdicao;
	private Perfil perfilSelecionado;
	private List<Perfil> todosPerfis;
	
	private PerfilDao perfilDao;
	
	private Boolean visualizar;
	
	@PostConstruct
	public void construct(){
		perfil = new Perfil();
		perfilEdicao = new Perfil();
		perfilSelecionado = new Perfil();
		perfilDao = new PerfilDao();
	}
	
	public void preparaListaPerfil(){
		todosPerfis = perfilDao.findAll();
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Perfil getPerfilEdicao() {
		return perfilEdicao;
	}

	public void setPerfilEdicao(Perfil perfilEdicao) {
		this.perfilEdicao = perfilEdicao;
	}

	public Perfil getPerfilSelecionado() {
		return perfilSelecionado;
	}

	public void setPerfilSelecionado(Perfil perfilSelecionado) {
		this.perfilSelecionado = perfilSelecionado;
	}

	public List<Perfil> getTodosPerfis() {
		todosPerfis = perfilDao.findAll();
		return todosPerfis;
	}

	public void setTodosPerfis(List<Perfil> todosPerfis) {
		this.todosPerfis = todosPerfis;
	}

	public PerfilDao getPerfilDao() {
		return perfilDao;
	}

	public void setPerfilDao(PerfilDao perfilDao) {
		this.perfilDao = perfilDao;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;
	}
	
	public void salvar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			gravaMenuAdministracaoSelecionados(menuAdministracaoSelecionados);
			perfilDao.create(perfilEdicao);
			construct();
			fc.addMessage("formPerfil", new FacesMessage("Perfil cadastrado com sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formPerfil", new FacesMessage("Erro ao cadastrar perfil!" + e.getMessage()));
		}
	}
	
	public void editar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			gravaMenuAdministracaoSelecionados(menuAdministracaoSelecionados);
			perfilDao.update(perfilEdicao);
			construct();
			fc.addMessage("formPerfil", new FacesMessage("Perfil atualizado com sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formPerfil", new FacesMessage("Erro ao atualizar perfil!" + e.getMessage()));
		}
	}
	
	public void remover(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			perfilDao.delete(perfilSelecionado);
			fc.addMessage("formPerfil", new FacesMessage("Perfil deletado com sucesso!"));
			perfilDao.findAll();
			
		} catch (Exception e) {
			fc.addMessage("formPerfil", new FacesMessage("Erro ao deletar perfil!"));
		}
	}
	
	public TreeNode getMenuAdministracao(){
		TreeNode root = new CheckboxTreeNode(new Menu("root", "root"), null);
		
		TreeNode menuAdministracao = new CheckboxTreeNode(new Menu("MenuAdministracao", "Administração"), root);
        menuAdministracao.setSelected(perfilEdicao.getMenuAdministracao() == null ? false : perfilEdicao.getMenuAdministracao());
        
        TreeNode subMenuProfessor = new CheckboxTreeNode(new Menu("SubMenuProfessor", "Professor"), menuAdministracao);
        subMenuProfessor.setSelected(perfilEdicao.getSubMenuProfessor() == null ? false : perfilEdicao.getSubMenuProfessor());
        
        TreeNode subMenuProfessorInclusao = new CheckboxTreeNode(new Menu("SubMenuProfessorInclusao", "Inclusão"), subMenuProfessor);
        subMenuProfessorInclusao.setSelected(perfilEdicao.getSubMenuProfessorInclusao() == null ? false : perfilEdicao.getSubMenuProfessorInclusao());
        
        TreeNode subMenuProfessorAlteracao = new CheckboxTreeNode(new Menu("SubMenuProfessorAlteracao", "Alteração"), subMenuProfessor);
        subMenuProfessorAlteracao.setSelected(perfilEdicao.getSubMenuProfessorAlteracao() == null ? false : perfilEdicao.getSubMenuProfessorAlteracao());
        
        TreeNode subMenuProfessorExibicao = new CheckboxTreeNode(new Menu("SubMenuProfessorExibicao", "Exibição"), subMenuProfessor);
        subMenuProfessorExibicao.setSelected(perfilEdicao.getSubMenuProfessorExibicao() == null ? false : perfilEdicao.getSubMenuProfessorExibicao());
        
        TreeNode subMenuProfessorExclusao = new CheckboxTreeNode(new Menu("SubMenuProfessorExclusao", "Exclusão"), subMenuProfessor);
        subMenuProfessorExclusao.setSelected(perfilEdicao.getSubMenuProfessorExclusao() == null ? false : perfilEdicao.getSubMenuProfessorExclusao());
		
        TreeNode subMenuAluno = new CheckboxTreeNode(new Menu("SubMenuAluno", "Aluno"), menuAdministracao);
        subMenuAluno.setSelected(perfilEdicao.getSubMenuAluno() == null ? false : perfilEdicao.getSubMenuAluno());
        
        TreeNode subMenuAlunoInclusao = new CheckboxTreeNode(new Menu("SubMenuAlunoInclusao", "Inclusão"), subMenuAluno);
        subMenuAlunoInclusao.setSelected(perfilEdicao.getSubMenuAlunoInclusao() == null ? false : perfilEdicao.getSubMenuAlunoInclusao());
        
        TreeNode subMenuAlunoAlteracao = new CheckboxTreeNode(new Menu("SubMenuAlunoAlteracao", "Alteração"), subMenuAluno);
        subMenuAlunoAlteracao.setSelected(perfilEdicao.getSubMenuAlunoAlteracao() == null ? false : perfilEdicao.getSubMenuAlunoAlteracao());
       
        TreeNode subMenuAlunoExibicao = new CheckboxTreeNode(new Menu("SubMenuAlunoExibicao", "Exibição"), subMenuAluno);
        subMenuAlunoExibicao.setSelected(perfilEdicao.getSubMenuAlunoExibicao() == null ? false : perfilEdicao.getSubMenuAlunoExibicao());
        
        TreeNode subMenuAlunoExclusao = new CheckboxTreeNode(new Menu("SubMenuAlunoExclusao", "Exclusão"), subMenuAluno);
        subMenuAlunoExclusao.setSelected(perfilEdicao.getSubMenuAlunoExclusao() == null ? false : perfilEdicao.getSubMenuAlunoExclusao());
        
        TreeNode subMenuPerfil = new CheckboxTreeNode(new Menu("SubMenuPerfil", "Perfil"), menuAdministracao);
        subMenuPerfil.setSelected(perfilEdicao.getSubMenuPerfil() == null ? false : perfilEdicao.getSubMenuPerfil());
        
        TreeNode subMenuPerfilInclusao = new CheckboxTreeNode(new Menu("SubMenuPerfilInclusao", "Inclusão"), subMenuPerfil);
        subMenuPerfilInclusao.setSelected(perfilEdicao.getSubMenuPerfilInclusao() == null ? false : perfilEdicao.getSubMenuPerfilInclusao());
        
        TreeNode subMenuPerfilAlteracao = new CheckboxTreeNode(new Menu("SubMenuPerfilAlteracao", "Alteração"), subMenuPerfil);
        subMenuPerfilAlteracao.setSelected(perfilEdicao.getSubMenuPerfilAlteracao() == null ? false : perfilEdicao.getSubMenuPerfilAlteracao());
        
        TreeNode subMenuPerfilExibicao = new CheckboxTreeNode(new Menu("SubMenuPerfilExibicao", "Exibição"), subMenuPerfil);
        subMenuPerfilExibicao.setSelected(perfilEdicao.getSubMenuPerfilExibicao() == null ? false : perfilEdicao.getSubMenuPerfilExibicao());
        
        TreeNode subMenuPerfilExclusao = new CheckboxTreeNode(new Menu("SubMenuPerfilExclusao", "Exclusão"), subMenuPerfil);
        subMenuPerfilExclusao.setSelected(perfilEdicao.getSubMenuPerfilExclusao() == null ? false : perfilEdicao.getSubMenuPerfilExclusao());
        
        TreeNode subMenuUsuario = new CheckboxTreeNode(new Menu("SubMenuUsuario", "Usuário"), menuAdministracao);
        subMenuUsuario.setSelected(perfilEdicao.getSubMenuUsuario() == null ? false : perfilEdicao.getSubMenuUsuario());
        
        TreeNode subMenuUsuarioInclusao = new CheckboxTreeNode(new Menu("SubMenuUsuarioInclusao", "Inclusão"), subMenuUsuario);
        subMenuUsuarioInclusao.setSelected(perfilEdicao.getSubMenuUsuarioInclusao() == null ? false : perfilEdicao.getSubMenuUsuarioInclusao());
        
        TreeNode subMenuUsuarioAlteracao = new CheckboxTreeNode(new Menu("SubMenuUsuarioAlteracao", "Alteração"), subMenuUsuario);
        subMenuUsuarioAlteracao.setSelected(perfilEdicao.getSubMenuUsuarioAlteracao() == null ? false : perfilEdicao.getSubMenuUsuarioAlteracao());
        
        TreeNode subMenuUsuarioExibicao = new CheckboxTreeNode(new Menu("SubMenuUsuarioExibicao", "Exibição"), subMenuUsuario);
        subMenuUsuarioExibicao.setSelected(perfilEdicao.getSubMenuUsuarioExibicao() == null ? false : perfilEdicao.getSubMenuUsuarioExibicao());
        
        TreeNode subMenuUsuarioExclusao = new CheckboxTreeNode(new Menu("SubMenuUsuarioExclusao", "Exclusão"), subMenuUsuario);
        subMenuUsuarioExclusao.setSelected(perfilEdicao.getSubMenuUsuarioExclusao() == null ? false : perfilEdicao.getSubMenuUsuarioExclusao());
        
        TreeNode subMenuTurma = new CheckboxTreeNode(new Menu("SubMenuTurma", "Turma"), menuAdministracao);
        subMenuTurma.setSelected(perfilEdicao.getSubMenuTurma() == null ? false : perfilEdicao.getSubMenuTurma());
        
        TreeNode subMenuTurmaInclusao = new CheckboxTreeNode(new Menu("SubMenuTurmaInclusao", "Inclusão"), subMenuTurma);
        subMenuTurmaInclusao.setSelected(perfilEdicao.getSubMenuTurmaInclusao() == null ? false : perfilEdicao.getSubMenuTurmaInclusao());
        
        TreeNode subMenuTurmaAlteracao = new CheckboxTreeNode(new Menu("SubMenuTurmaAlteracao", "Alteração"), subMenuTurma);
        subMenuTurmaAlteracao.setSelected(perfilEdicao.getSubMenuTurmaAlteracao() == null ? false : perfilEdicao.getSubMenuTurmaAlteracao());
        
        TreeNode subMenuTurmaExibicao = new CheckboxTreeNode(new Menu("SubMenuTurmaExibicao", "Exibição"), subMenuTurma);
        subMenuTurmaExibicao.setSelected(perfilEdicao.getSubMenuTurmaExibicao() == null ? false : perfilEdicao.getSubMenuTurmaExibicao());
        
        TreeNode subMenuTurmaExclusao = new CheckboxTreeNode(new Menu("SubMenuTurmaExclusao", "Exclusão"), subMenuTurma);
        subMenuTurmaExclusao.setSelected(perfilEdicao.getSubMenuTurmaExclusao() == null ? false : perfilEdicao.getSubMenuTurmaExclusao());
        
        TreeNode subMenuDisciplina = new CheckboxTreeNode(new Menu("SubMenuDisciplina", "Disciplina"), menuAdministracao);
        subMenuDisciplina.setSelected(perfilEdicao.getSubMenuDisciplina() == null ? false : perfilEdicao.getSubMenuDisciplina());
        
        TreeNode subMenuDisciplinaInclusao = new CheckboxTreeNode(new Menu("SubMenuDisciplinaInclusao", "Inclusão"), subMenuDisciplina);
        subMenuDisciplinaInclusao.setSelected(perfilEdicao.getSubMenuDisciplinaInclusao() == null ? false : perfilEdicao.getSubMenuDisciplinaInclusao());
        
        TreeNode subMenuDisciplinaAlteracao = new CheckboxTreeNode(new Menu("SubMenuDisciplinaAlteracao", "Alteração"), subMenuDisciplina);
        subMenuDisciplinaAlteracao.setSelected(perfilEdicao.getSubMenuDisciplinaAlteracao() == null ? false : perfilEdicao.getSubMenuDisciplinaAlteracao());
        
        TreeNode subMenuDisciplinaExibicao = new CheckboxTreeNode(new Menu("SubMenuDisciplinaExibicao", "Exibição"), subMenuDisciplina);
        subMenuDisciplinaExibicao.setSelected(perfilEdicao.getSubMenuDisciplinaExibicao() == null ? false : perfilEdicao.getSubMenuDisciplinaExibicao());
        
        TreeNode subMenuDisciplinaExclusao = new CheckboxTreeNode(new Menu("SubMenuDisciplinaExclusao", "Exclusão"), subMenuDisciplina);
        subMenuDisciplinaExclusao.setSelected(perfilEdicao.getSubMenuDisciplinaExclusao() == null ? false : perfilEdicao.getSubMenuDisciplinaExclusao());
        
		return root;
	}
	
	private TreeNode[] menuAdministracaoSelecionados;

	public TreeNode[] getMenuAdministracaoSelecionados() {
		return menuAdministracaoSelecionados;
	}

	public void setMenuAdministracaoSelecionados(
			TreeNode[] menuAdministracaoSelecionados) {
		this.menuAdministracaoSelecionados = menuAdministracaoSelecionados;
	}
	
	public void gravaMenuAdministracaoSelecionados(TreeNode[] nodes){
		
		perfilEdicao.setMenuAdministracao(false);
		perfilEdicao.setSubMenuProfessor(false);
		perfilEdicao.setSubMenuProfessorInclusao(false);
		perfilEdicao.setSubMenuProfessorAlteracao(false);
		perfilEdicao.setSubMenuProfessorExibicao(false);
		perfilEdicao.setSubMenuProfessorExclusao(false);
		perfilEdicao.setSubMenuAluno(false);
		perfilEdicao.setSubMenuAlunoInclusao(false);
		perfilEdicao.setSubMenuAlunoAlteracao(false);
		perfilEdicao.setSubMenuAlunoExibicao(false);
		perfilEdicao.setSubMenuAlunoExclusao(false);
		perfilEdicao.setSubMenuPerfil(false);
		perfilEdicao.setSubMenuPerfilInclusao(false);
		perfilEdicao.setSubMenuPerfilAlteracao(false);
		perfilEdicao.setSubMenuPerfilExibicao(false);
		perfilEdicao.setSubMenuPerfilExclusao(false);
		perfilEdicao.setSubMenuUsuario(false);
		perfilEdicao.setSubMenuUsuarioInclusao(false);
		perfilEdicao.setSubMenuUsuarioAlteracao(false);
		perfilEdicao.setSubMenuUsuarioExibicao(false);
		perfilEdicao.setSubMenuUsuarioExclusao(false);
		perfilEdicao.setSubMenuTurma(false);
		perfilEdicao.setSubMenuTurmaInclusao(false);
		perfilEdicao.setSubMenuTurmaAlteracao(false);
		perfilEdicao.setSubMenuTurmaExibicao(false);
		perfilEdicao.setSubMenuTurmaExclusao(false);
		perfilEdicao.setSubMenuDisciplina(false);
		perfilEdicao.setSubMenuDisciplinaInclusao(false);
		perfilEdicao.setSubMenuDisciplinaExibicao(false);
		perfilEdicao.setSubMenuDisciplinaAlteracao(false);
		perfilEdicao.setSubMenuDisciplinaExclusao(false);
		
		if (nodes != null && nodes.length > 0){
			
			for (TreeNode node : nodes){
				if (node.getData().toString().equals("MenuAdministracao")) {
                    perfilEdicao.setMenuAdministracao(true);
                }
				if(node.getData().toString().equals("SubMenuProfessor")){	
					perfilEdicao.setSubMenuProfessor(true);
					perfilEdicao.setMenuAdministracao(true);					
				}
				if(node.getData().toString().equals("SubMenuProfessorInclusao")){					
					perfilEdicao.setSubMenuProfessor(true);	
					perfilEdicao.setMenuAdministracao(true);					
					perfilEdicao.setSubMenuProfessorInclusao(true);
				}
				if(node.getData().toString().equals("SubMenuProfessorAlteracao")){						
					perfilEdicao.setSubMenuProfessor(true);
					perfilEdicao.setMenuAdministracao(true);				
					perfilEdicao.setSubMenuProfessorAlteracao(true);
				}
				if(node.getData().toString().equals("SubMenuProfessorExibicao")){					
					perfilEdicao.setSubMenuProfessor(true);
					perfilEdicao.setMenuAdministracao(true);					
					perfilEdicao.setSubMenuProfessorExibicao(true);
				}
				if(node.getData().toString().equals("SubMenuProfessorExclusao")){					
					perfilEdicao.setSubMenuProfessor(true);	
					perfilEdicao.setMenuAdministracao(true);					
					perfilEdicao.setSubMenuProfessorExclusao(true);
				}
				if(node.getData().toString().equals("SubMenuAluno")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuAluno(true);
				}
				if(node.getData().toString().equals("SubMenuAlunoInclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuAluno(true);
					perfilEdicao.setSubMenuAlunoInclusao(true);
				}
				if(node.getData().toString().equals("SubMenuAlunoAlteracao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuAluno(true);
					perfilEdicao.setSubMenuAlunoAlteracao(true);
				}
				if(node.getData().toString().equals("SubMenuAlunoExibicao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuAluno(true);
					perfilEdicao.setSubMenuAlunoExibicao(true);
				}
				if(node.getData().toString().equals("SubMenuAlunoExclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuAluno(true);
					perfilEdicao.setSubMenuAlunoExclusao(true);
				}
				if(node.getData().toString().equals("SubMenuPerfil")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuPerfil(true);
				}
				if(node.getData().toString().equals("SubMenuPerfilInclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuPerfil(true);
					perfilEdicao.setSubMenuPerfilInclusao(true);
				}
				if(node.getData().toString().equals("SubMenuPerfilAlteracao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuPerfil(true);
					perfilEdicao.setSubMenuPerfilAlteracao(true);
				}
				if(node.getData().toString().equals("SubMenuPerfilExibicao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuPerfil(true);
					perfilEdicao.setSubMenuPerfilExibicao(true);
				}
				if(node.getData().toString().equals("SubMenuPerfilExclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuPerfil(true);
					perfilEdicao.setSubMenuPerfilExclusao(true);
				}
				if(node.getData().toString().equals("SubMenuUsuario")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuUsuario(true);
				}
				if(node.getData().toString().equals("SubMenuUsuarioInclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuUsuario(true);
					perfilEdicao.setSubMenuUsuarioInclusao(true);
				}
				if(node.getData().toString().equals("SubMenuUsuarioAlteracao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuUsuario(true);
					perfilEdicao.setSubMenuUsuarioAlteracao(true);
				}
				if(node.getData().toString().equals("SubMenuUsuarioExibicao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuUsuario(true);
					perfilEdicao.setSubMenuUsuarioExibicao(true);
				}
				if(node.getData().toString().equals("SubMenuUsuarioExclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuUsuario(true);
					perfilEdicao.setSubMenuUsuarioExclusao(true);
				}
				if(node.getData().toString().equals("SubMenuTurma")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuTurma(true);
				}
				if(node.getData().toString().equals("SubMenuTurmaInclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuTurma(true);
					perfilEdicao.setSubMenuTurmaInclusao(true);
				}
				if(node.getData().toString().equals("SubMenuTurmaAlteracao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuTurma(true);
					perfilEdicao.setSubMenuTurmaAlteracao(true);
				}
				if(node.getData().toString().equals("SubMenuTurmaExibicao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuTurma(true);
					perfilEdicao.setSubMenuTurmaExibicao(true);
				}
				if(node.getData().toString().equals("SubMenuTurmaExclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuTurma(true);
					perfilEdicao.setSubMenuTurmaExclusao(true);
				}
				if(node.getData().toString().equals("SubMenuDisciplina")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuDisciplina(true);
				}
				if(node.getData().toString().equals("SubMenuDisciplinaInclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuDisciplina(true);
					perfilEdicao.setSubMenuDisciplinaInclusao(true);
				}
				if(node.getData().toString().equals("SubMenuDisciplinaAlteracao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuDisciplina(true);
					perfilEdicao.setSubMenuDisciplinaAlteracao(true);
				}
				if(node.getData().toString().equals("SubMenuDisciplinaExibicao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuDisciplina(true);
					perfilEdicao.setSubMenuDisciplinaExibicao(true);
				}
				if(node.getData().toString().equals("SubMenuDisciplinaExclusao")){
					perfilEdicao.setMenuAdministracao(true);
					perfilEdicao.setSubMenuDisciplina(true);
					perfilEdicao.setSubMenuDisciplinaExclusao(true);
				}
				
			}
		}
		
		
	}
	
	

}
