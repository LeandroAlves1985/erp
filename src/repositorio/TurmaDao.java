package repositorio;

import java.util.List;

import modelo.Aluno;
import modelo.Turma;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TurmaDao {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Turma t){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Turma t){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Turma t){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		session.close();
		
	}
	
	public List<Turma> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Turma> lst =  session.createQuery("from Turma").list();
		session.close();
		return lst;
	}
	
	public Turma findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Turma t	= (Turma) session.get(Turma.class, cod);
		session.close();
		return t;
	}
	
	
	
	
}
