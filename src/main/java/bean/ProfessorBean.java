package bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ProfessorDao;
import entidade.Professor;

@ManagedBean
@SessionScoped
public class ProfessorBean {

	private Professor professor = new Professor();
	private List<Professor> professores;


	public void salvar() {
		getProfessor().setDataDoCadastro(new Date());
		ProfessorDao.salvar(getProfessor());
			setProfessor(new Professor());
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Professor cadastrado com sucesso!"));
	}	

	public void editar(Professor professor) {
		if (professor != null) {
			ProfessorDao.editar(professor);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Professor editado com sucesso!"));
			setProfessores(ProfessorDao.listar());
		}
	}

	public void excluir(int id) {
		ProfessorDao.excluir(id);
		FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Professor excluído com sucesso!"));
	}
	
	public List<Professor> listarProfessores(){
		return ProfessorDao.listar();
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
}
