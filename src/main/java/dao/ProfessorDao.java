package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Aluno;
import entidade.Professor;
import util.JPAUtilService;

public class ProfessorDao {
	
	public static void salvar(Professor professor) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		em.persist(professor);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Professor professor) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		em.merge(professor);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(int id) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		Professor deletarProfessor = em.find(Professor.class, id);
		if(deletarProfessor != null) {
			em.remove(deletarProfessor);
		}
		em.getTransaction().commit();
		em.close();
	}

	public static List<Professor> listar() {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		try {
			Query query = em.createQuery("SELECT p FROM Professor p");
			List<Professor> resultado = query.getResultList();
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
