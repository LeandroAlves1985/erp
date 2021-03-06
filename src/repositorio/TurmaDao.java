package repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;
import modelo.Disciplina;
import modelo.Professor;
import modelo.Turma;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TurmaDao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
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
	
	public List<Disciplina> disciplinaPorTurma(Turma t){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Turma t where t.descricao = :descricao");
			query.setString("descricao", t.getDescricao());
			Turma turma = (Turma) query.uniqueResult();
			List<Disciplina> lista = turma.getDisciplinas();
			List<Disciplina> listaResp = new ArrayList<Disciplina>();
			for(Disciplina d : lista){
				Disciplina d1 = new Disciplina();
					d1.setId(d.getId());
					d1.setDescricao(d.getDescricao());
					listaResp.add(d1);
			}
		session.close();
		return listaResp;	
	}	
	
	public List<Professor> professorPorTurma(Turma t){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Turma t where t.descricao = :descricao");
			query.setString("descricao", t.getDescricao());
			Turma turma = (Turma) query.uniqueResult();
			List<Professor> lista = turma.getProfessores();
			List<Professor> listaResp = new ArrayList<Professor>();
			for(Professor p : lista){
				Professor p1 = new Professor();
					p1 = p;
					listaResp.add(p1);
			}
		session.close();
		return listaResp;
	}
	
	public Turma porNome(Turma t){
		session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("from Turma t where t.descricao = :descricao");
			query.setString("descricao", t.getDescricao());
			Turma turma = (Turma) query.uniqueResult();
		session.close();
		return turma;
	}
	
	
}
