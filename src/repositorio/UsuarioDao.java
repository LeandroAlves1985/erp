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
	
	
	public void criptografia(Usuario u){
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
	
	
	public Usuario login(Usuario u) throws Exception {
		criptografia(u);
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.and(Restrictions.eq("login", u.getLogin()),
				     Restrictions.eq("senha", u.getSenha())));
		Usuario user = (Usuario) criteria.uniqueResult();
		session.close();
		return user;
	}
	
	
	
	
}
