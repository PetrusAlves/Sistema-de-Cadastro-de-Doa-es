package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.AlunoDao;
import entidade.Aluno;
import entidade.Cronograma;
import entidade.Professor;

@ManagedBean
@SessionScoped
public class AlunoBean {

	private Aluno aluno = new Aluno();
	private List<Aluno> alunos;
	private Professor professor;
	
    private List<Cronograma> cronogramas;

	
	private String gigabytes;

    public void exibirTamanhos() {
        this.setGigabytes("16, 32, 64, 128, 256, 512, 1000");
    }



	public void salvar() {
		aluno.setDataDoCadastro(new Date());
		AlunoDao.salvar(getAluno());
			setAluno(new Aluno());
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Aluno cadastrado com sucesso!"));
	}	

	public void editar(Aluno aluno) {
		if (aluno != null) {
			AlunoDao.editar(aluno);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Aluno editado com sucesso!"));
			setAlunos(AlunoDao.listar());
		}
	}

	public void excluir(int id) {
		AlunoDao.excluir(id);
		FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Jogo excluído com sucesso!"));
	}

	
	@PostConstruct
    public void init() {
        initCronogramas();
    }
	
	public void initCronogramas() {
        cronogramas = new ArrayList<>();

        cronogramas.add(new Cronograma("02/01/2025","08:00 ás 12:00 e 14 ás 22:00", "Segunda á Sexta", "Antonio Bezerra", "Fortaleza", "1 Mês"));
        cronogramas.add(new Cronograma("04/02/2025","08:00 ás 12:00 e 14 ás 22:00", "Segunda á Sexta", "Jacarecanga", "Fortaleza", "1 Mês"));
        cronogramas.add(new Cronograma("15/03/2025","08:00 ás 12:00 e 14 ás 22:00", "Segunda á Sexta","Jangurussu", "Fortaleza", "1 Mês"));
        cronogramas.add(new Cronograma("23/04/2025","08:00 ás 12:00 e 14 ás 22:00", "Segunda á Sexta","Barroso", "Fortaleza", "1 Mês"));
        cronogramas.add(new Cronograma("26/05/2025","08:00 ás 12:00 e 14 ás 22:00", "Segunda á Sexta","Barra do Ceará", "Fortaleza", "1 Mês"));
    }
	
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}



	public String getGigabytes() {
		return gigabytes;
	}



	public void setGigabytes(String gigabytes) {
		this.gigabytes = gigabytes;
	}



	public List<Cronograma> getCronogramas() {
		return cronogramas;
	}



	public void setCronogramas(List<Cronograma> cronogramas) {
		this.cronogramas = cronogramas;
	}

}
