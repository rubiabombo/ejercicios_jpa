package examenBankonter.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import examenBankonter.model.Contrato;

public class ContratoControlador {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Bankonter");
	

	
	
	/**
	 * 
	 * @return
	 */
//	public static List<Portatil> findAll() {	
//		EntityManager em = entityManagerFactory.createEntityManager();
//		Query q = em.createNativeQuery("SELECT * FROM portatil;", Portatil.class);
//		List<Portatil> l = (List<Portatil>) q.getResultList();
//		
//		em.close();
//		return l;
//	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public static Contrato findBySQL(String sql) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery(sql, Contrato.class);
		Contrato p = null;
		try {
			p = (Contrato) q.getSingleResult();
		}
		catch(Exception ex) {
			System.out.println("No se ha encontrado Contrato para la sql: " + sql);
		}
		
		em.close();
		return p;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Contrato findFirst () {
		return findBySQL("select * from contrato order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Contrato findLast () {
		return findBySQL("select * from contrato order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Contrato findNext (int idActual) {
		return findBySQL("select * from contrato where id > " + idActual + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Contrato findPrevious (int idActual) {
		return findBySQL("select * from contrato where id < " + idActual + " order by id desc limit 1");
	}

	
	/**
	 * 
	 * @param a
	 */
	public static void eliminar (Contrato a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		a = em.merge(a);	
		em.remove(a);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param a
	 */
	public static void nuevo (Contrato a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 * @param a
	 */
	public static void modificar (Contrato a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 */
	public static void guardar (Contrato a) {
		if (a.getId() == 0) {
			nuevo(a);
		}
		else {
			modificar(a);
		}
	}
	
}
