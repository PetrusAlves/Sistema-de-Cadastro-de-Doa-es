package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_DAD")
public class Doador {
	
	@Id
	@Column(name = "CD_USR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NM_DAD", nullable = false)
	private String nome;
	
	@Column(name = "EML_DAD", nullable = false)
	private String email;
	
	@Column(name = "TLF_DAD", nullable = false)
	private String telefone;
	
	@Column(name = "CPF_CNPJ_DAD", nullable = false)
	private String cpfCnpj;
	
	@Column(name = "DT_NSC_DAD", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private String dataNascimento;
	
	@Column(name = "TP_DAD", nullable = false)
	private String tipoDoacao;
	
	@Column(name = "END_DAD", nullable = false)
	@OneToOne
	private Endereco endereco;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(String tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
