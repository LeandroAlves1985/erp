package repositorio;

import java.io.Serializable;
import java.util.List;

import modelo.Aluno;
import modelo.Telefone;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TelefoneDao implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Telefone t){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Telefone t){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Telefone t){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
		
	}
	
	public List<Telefone> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Telefone> lst =  session.createQuery("from Telefone").list();
		session.close();
		return lst;
	}
	
	public Telefone findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Telefone t	= (Telefone) session.get(Telefone.class, cod);
		session.close();
		return t;
	}
	
	
	
	
}
