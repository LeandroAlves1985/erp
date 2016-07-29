package repositorio;

import java.util.List;

import modelo.Aluno;
import modelo.Nota;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NotaDao {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Nota n){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(n);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Nota n){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(n);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Nota n){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(n);
		transaction.commit();
		session.close();
		
	}
	
	public List<Nota> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Nota> lst =  session.createQuery("from Nota").list();
		session.close();
		return lst;
	}
	
	public Nota findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Nota n	= (Nota) session.get(Nota.class, cod);
		session.close();
		return n;
	}
	
	
	
	
}
