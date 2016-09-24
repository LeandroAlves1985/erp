package repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;
import modelo.Professor;
import modelo.Turma;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class AlunoDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Aluno a) throws Exception{
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
		List<Aluno> lista = session.createCriteria(Aluno.class).list();
		session.close();
		return lista;
	}
	
	public Aluno findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Aluno aluno	= (Aluno) session.get(Aluno.class, cod);
		session.close();
		return aluno;
	}
	
	public Aluno porNome(Aluno a){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Aluno a where a.nome = :nome");
			query.setString("nome", a.getNome());
			Aluno resp = (Aluno) query.uniqueResult();
		session.close();
		return resp;
	}
	
	public List<Turma> turmaPorAluno(Aluno a){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Aluno a where a.nome = :nome");
			query.setString("nome", a.getNome());
			Aluno aluno = (Aluno) query.uniqueResult();
			List<Turma> lista = aluno.getTurmas();
			List<Turma> listaResp = new ArrayList<Turma>();
			for(Turma t : lista){
				Turma t1 = new Turma();
					t1 = t;
					listaResp.add(t1);
			}
		session.close();
		return listaResp;
	}
	
	
	
	
	
}
