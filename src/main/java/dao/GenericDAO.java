package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {
	
	public void inserir (Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}
	
	public void excluir(Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
	}
	
	public void atualizar(Object entidade){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
	}
	
	public Object findById(Class classe , long id){
		EntityManager em = getEntityManager();
		return em.find(classe, id);
	}

	private EntityManager getEntityManager(){
		return Banco.getInstance().getEntityManager();
	}
	
	public void inserirLog(Object log){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(log);		
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}	

}
