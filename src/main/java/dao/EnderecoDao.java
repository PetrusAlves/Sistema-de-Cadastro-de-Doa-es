package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Endereco;
import util.JPAUtilService;

public class EnderecoDao {
	
	public static void salvar(Endereco endereco) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		em.persist(endereco);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Endereco endereco) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		em.merge(endereco);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(int id) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		Endereco deletarEndereco = em.find(Endereco.class, id);
		if(deletarEndereco != null) {
			em.remove(deletarEndereco);
		}
		em.getTransaction().commit();
		em.close();
	}

	public static List<Endereco> listar() {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		try {
			Query query = em.createQuery("SELECT e FROM Enderco e");
			List<Endereco> resultado = query.getResultList();
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
