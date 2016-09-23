package repositorio;

import java.io.Serializable;
import java.util.List;

import modelo.Disciplina;
import modelo.Lancamento;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LancamentoDao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Lancamento l){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(l);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Lancamento l){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(l);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Lancamento l){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(l);
		transaction.commit();
		session.close();
		
	}
	
	public List<Lancamento> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Lancamento> lst =  session.createQuery("from Lancamento").list();
		session.close();
		return lst;
	}
	
	public Lancamento findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Lancamento l = (Lancamento) session.get(Lancamento.class, cod);
		session.close();
		return l;
	}
	
	
	
	
	
	
	
}
