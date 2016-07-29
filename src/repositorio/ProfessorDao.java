package repositorio;

import java.util.List;

import modelo.Aluno;
import modelo.Professor;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProfessorDao {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Professor p){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Professor p){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(p);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Professor p){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(p);
		transaction.commit();
		session.close();
		
	}
	
	public List<Professor> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Professor> lst =  session.createQuery("from Professor").list();
		session.close();
		return lst;
	}
	
	public Professor findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Professor p	= (Professor) session.get(Professor.class, cod);
		session.close();
		return p;
	}
	
	
	
	
}
