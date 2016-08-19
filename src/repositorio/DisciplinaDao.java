package repositorio;

import java.io.Serializable;
import java.util.List;

import modelo.Aluno;
import modelo.Disciplina;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DisciplinaDao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Disciplina d){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(d);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Disciplina d){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(d);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Disciplina d){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(d);
		transaction.commit();
		session.close();
		
	}
	
	public List<Disciplina> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Disciplina> lst =  session.createQuery("from Disciplina").list();
		session.close();
		return lst;
	}
	
	public Disciplina findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Disciplina d = (Disciplina) session.get(Disciplina.class, cod);
		session.close();
		return d;
	}
	
	public Disciplina porNome(Disciplina d){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Disciplina d where d.descricao = :descricao");
			query.setString("descricao", d.getDescricao());
			Disciplina resp = (Disciplina) query.uniqueResult();
		session.close();
		return resp;
	}
	
	
	
	
	
	
}
