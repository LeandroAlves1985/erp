package repositorio;

import java.util.List;

import modelo.Aluno;
import modelo.Funcionario;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class FuncionarioDao  {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Funcionario f) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(f);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Funcionario f){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(f);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Funcionario f){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(f);
		transaction.commit();
		session.close();
		
	}
	
	public List<Funcionario> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Funcionario> lista = session.createCriteria(Funcionario.class).list();
		session.close();
		return lista;
	}
	
	public Funcionario  findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Funcionario f	= (Funcionario) session.get(Funcionario.class, cod);
		session.close();
		return f;
	}
	
	
	
	
	
	
	
}
