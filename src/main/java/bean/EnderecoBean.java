package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.EnderecoDao;
import entidade.Endereco;

@ManagedBean
@SessionScoped
public class EnderecoBean {

	private Endereco endereco = new Endereco();


	public void salvar() {
		EnderecoDao.salvar(getEndereco());
			endereco = new Endereco();
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Endereco cadastrado com sucesso!"));
	}	

	public void editar(Endereco endereco) {
		if (endereco != null) {
			EnderecoDao.editar(endereco);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Endereco editado com sucesso!"));
			EnderecoDao.listar();
		}
	}

	public void excluir(int id) {
		EnderecoDao.excluir(id);
		FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Endereco excluído com sucesso!"));
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
