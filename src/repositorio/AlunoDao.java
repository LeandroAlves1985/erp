package repositorio;

import java.util.List;

import modelo.Aluno;

import org.hibernate.*;

public class AlunoDao {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Aluno a){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(a);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Aluno a){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(a);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Aluno a){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(a);
		transaction.commit();
		session.close();
		
	}
	
	public List<Aluno> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Aluno> lst =  session.createQuery("from Aluno").list();
		session.close();
		return lst;
	}
	
	public Aluno findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Aluno aluno	= (Aluno) session.get(Aluno.class, cod);
		session.close();
		return aluno;
	}
	
	
	
	
	
}
