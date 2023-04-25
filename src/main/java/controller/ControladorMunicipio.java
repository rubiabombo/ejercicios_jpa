package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Municipio;



public class ControladorMunicipio {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("municipiosyprovincias");

	
	public static List<Municipio> municipioDescripcion(String nombre) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM municipio  where nombre like ? order by nombre", Municipio.class);

		q.setParameter(1, "%" + nombre + "%");

		List<Municipio> muns = (List<Municipio>) q.getResultList();

		em.close();

		return muns;

	}
	
	public static void modificar(Municipio l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}

}