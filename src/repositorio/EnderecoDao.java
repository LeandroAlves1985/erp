package repositorio;

import java.io.Serializable;
import java.util.List;

import modelo.Disciplina;
import modelo.Endereco;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EnderecoDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Endereco e){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(e);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Endereco e){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(e);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Endereco e){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(e);
		transaction.commit();
		session.close();
		
	}
	
	public List<Endereco> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Endereco> lst =  session.createQuery("from Endereco").list();
		session.close();
		return lst;
	}
	
	public Endereco findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Endereco e = (Endereco) session.get(Endereco.class, cod);
		session.close();
		return e;
	}
	
	
	
	
}
