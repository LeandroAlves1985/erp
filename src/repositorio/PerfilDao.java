package repositorio;

import java.util.List;

import modelo.Aluno;
import modelo.Perfil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PerfilDao {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Perfil p){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Perfil p){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(p);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Perfil p){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(p);
		transaction.commit();
		session.close();
		
	}
	
	public List<Perfil> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Perfil> lst =  session.createQuery("from Perfil").list();
		session.close();
		return lst;
	}
	
	public Perfil findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Perfil p = (Perfil) session.get(Perfil.class, cod);
		session.close();
		return p;
	}
	
	
	
}
