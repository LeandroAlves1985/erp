package repositorio;

import java.util.List;

import modelo.Aluno;
import modelo.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jcommon.encryption.SimpleMD5;




public class UsuarioDao {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public static void criptografia(Usuario u){
		SimpleMD5 md5 = new SimpleMD5("@1001",u.getSenha());
		 u.setSenha(md5.toHexString());
	}
	
	public void create(Usuario u){
		criptografia(u);
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(u);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Usuario u){
		criptografia(u);
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(u);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Usuario u){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(u);
		transaction.commit();
		session.close();
		
	}
	
	public List<Usuario> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> lst =  session.createQuery("from Usuario").list();
		session.close();
		return lst;
	}
	
	public Usuario findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Usuario u = (Usuario) session.get(Usuario.class, cod);
		session.close();
		return u;
	}
	
	public Usuario findByLogin(String nomeLogin) {
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = (Criteria) session.createCriteria(Usuario.class);
		criteria.add(Restrictions.ilike("login", nomeLogin));
		Usuario usu = (Usuario) criteria.uniqueResult();
		session.close();
		return usu;

	}
		
	public Usuario logar(Usuario u) {
		criptografia(u);
		session = HibernateUtil.getSessionFactory().openSession();		
		query = session
				.createQuery("from Usuario where login=:param1 and senha=:param2");
		query.setString("param1", u.getLogin());
		query.setString("param2", u.getSenha());
		Usuario resp = (Usuario) query.uniqueResult();
		session.close();
		return resp;
	}
	
	

	public static void main(String[] args) {
		try {
			
			System.out.println(new UsuarioDao().findByLogin("gallotti"));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	
}
