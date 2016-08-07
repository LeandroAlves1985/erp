package repositorio;

import java.util.List;

import modelo.Aluno;
import modelo.Aluno_Turma;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Aluno_TurmaDao {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Aluno_Turma at) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(at);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Aluno_Turma at){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(at);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Aluno_Turma at){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(at);
		transaction.commit();
		session.close();
		
	}
	
	public List<Aluno> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Aluno> lista = session.createCriteria(Aluno_Turma.class).list();
		session.close();
		return lista;
	}
	
	public Aluno_Turma findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Aluno_Turma  alunoTurma	= (Aluno_Turma) session.get(Aluno_Turma.class, cod);
		session.close();
		return alunoTurma;
	}
	
	
	
}
