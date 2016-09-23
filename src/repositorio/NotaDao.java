package repositorio;

import java.io.Serializable;
import java.util.List;

import modelo.Aluno;
import modelo.Disciplina;
import modelo.Nota;
import modelo.Turma;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NotaDao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
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
	
	public Nota porAluno(Aluno a, Turma t, Disciplina d){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Nota n where n.aluno = :aluno and n.turma = :turma and n.disciplina = :disciplina");
			query.setEntity("aluno", a);
			query.setEntity("turma", t);
			query.setEntity("disciplina", d);
			Nota nota = (Nota) query.uniqueResult();
		session.close();
		return nota;
	}
	
	
	
	
}
