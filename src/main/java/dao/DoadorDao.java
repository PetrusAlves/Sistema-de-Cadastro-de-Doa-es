package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Doador;
import util.JPAUtilService;

public class DoadorDao {
	
	public static void salvar(Doador doador) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		em.persist(doador);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Doador doador) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		em.merge(doador);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(int id) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		Doador deletarDoador = em.find(Doador.class, id);
		if(deletarDoador != null) {
			em.remove(deletarDoador);
		}
		em.getTransaction().commit();
		em.close();
	}

	public static List<Doador> listar() {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		try {
			Query query = em.createQuery("SELECT a FROM Doador a");
			List<Doador> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
