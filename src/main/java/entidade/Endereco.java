package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_END")
public class Endereco {

	@Id
	@Column(name = "CD_END")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "LOG_END", nullable = false)
	private String longradouro;
	
	@Column(name = "BAI_END", nullable = false)
	private String bairro;
	
	@Column(name = "NMR_END", nullable = false)
	private long numero;
	
	@Column(name = "CEP_END", nullable = false)
	private int cep;
	
	@Column(name = "CMP_END", nullable = false)
	private String complemento;
	
	@Column(name = "CID_END", nullable = false)
	private String cidade;
	
	@Column(name = "EST_END", nullable = false)
	private String estado;
	
	
	public String getLongradouro() {
		return longradouro;
	}
	public void setLongradouro(String longradouro) {
		this.longradouro = longradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
