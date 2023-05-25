package examenBankonter.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import examenBankonter.model.Usuario;



public class UsuarioControlador {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Bankonter");
	
	
	/**
	 * 
	 * @return
	 */
	public static List<Usuario> findAll() {	
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM usuario", Usuario.class);
		List<Usuario> l = (List<Usuario>) q.getResultList();
		
		em.close();
		return l;
	}

	
	/**
	 * 
	 * @param a
	 */
	public static void modificar (Usuario a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}
	
}
