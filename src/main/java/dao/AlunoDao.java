package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Aluno;
import util.JPAUtilService;

public class AlunoDao {
	
	public static void salvar(Aluno aluno) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Aluno aluno) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(int id) {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		em.getTransaction().begin();
		Aluno deletarAluno = em.find(Aluno.class, id);
		if(deletarAluno != null) {
			em.remove(deletarAluno);
		}
		em.getTransaction().commit();
		em.close();
	}

	public static List<Aluno> listar() {
		EntityManager em = JPAUtilService.fabricarEntityManager();
		try {
			Query query = em.createQuery("SELECT a FROM Aluno a");
			List<Aluno> resultado = query.getResultList();
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
