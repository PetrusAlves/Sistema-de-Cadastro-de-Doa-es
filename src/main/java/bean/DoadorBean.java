package bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.DoadorDao;
import entidade.Doador;

@ManagedBean
@SessionScoped
public class DoadorBean {

	private Doador doador = new Doador();

	public void salvar() {
		getDoador().setDataDaDoacao(new Date());
		DoadorDao.salvar(getDoador());
			setDoador(new Doador());
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Doador cadastrado com sucesso!"));
	}	

	public void editar(Doador doador) {
		if (doador != null) {
			DoadorDao.editar(doador);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Doador editado com sucesso!"));
			DoadorDao.listar();
		}
	}

	public void excluir(int id) {
		DoadorDao.excluir(id);
		FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Doador excluído com sucesso!"));
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}
}
