package examenBankonter.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import examenBankonter.model.TipoContrato;



public class TipoContratoControlador {
private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Bankonter");
	
	
	/** 
	 * 
	 */
	public static TipoContrato findById (int id) {
		EntityManager em = entityManagerFactory.createEntityManager();

		TipoContrato t = (TipoContrato) em.find(TipoContrato.class, 1);
		
		em.close();
		
		return t;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static List<TipoContrato> findAll() {	
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM tipocontrato", TipoContrato.class);
		List<TipoContrato> l = (List<TipoContrato>) q.getResultList();
		
		em.close();
		return l;
	}

	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		List<TipoContrato> tipos = findAll();
		
		for (TipoContrato tipoContrato : tipos) {
			System.out.println(tipoContrato.getDescripcion());
		}
	}
	
	
}
