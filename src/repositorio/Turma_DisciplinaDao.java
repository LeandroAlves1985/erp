package repositorio;

import java.util.ArrayList;
import java.util.List;

import modelo.Disciplina;
import modelo.Turma;
import modelo.Turma_Disciplina;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Turma_DisciplinaDao {

	Session			session;
	Transaction		transaction;
	Criteria		criteria;
	Query			query;
	
	
	
	public void create(Turma_Disciplina td){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(td);
		transaction.commit();
		session.close();
		
	}
	
	public void update(Turma_Disciplina td){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(td);
		transaction.commit();
		session.close();
		
	}
	
	public void delete(Turma_Disciplina td){
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(td);
		transaction.commit();
		session.close();
		
	}
	
	public List<Turma_Disciplina> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Turma_Disciplina> lst =  session.createQuery("from Turma_Disciplina").list();
		session.close();
		return lst;
	}
	
	public Turma_Disciplina findByCod(Integer cod){
		session = HibernateUtil.getSessionFactory().openSession();
		Turma_Disciplina td = (Turma_Disciplina) session.get(Turma_Disciplina.class, cod);
		session.close();
		return td;
	}
	
	
	public static void main(String[] args) {
		Turma_Disciplina td = new Turma_Disciplina();
		
		try {
			Turma t = new Turma(null, "101");
			new TurmaDao().create(t);
			Disciplina d1 = new Disciplina(null, "Java OO");
			new DisciplinaDao().create(d1);
			
			td.setTurma(t);
			td.setDisciplina(d1);			
			new Turma_DisciplinaDao().create(td);			
			System.out.println("ok");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
