package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_ALN")
public class Aluno {
	
	@Id
	@Column(name = "CD_ALN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NM_ALN", nullable = false)
	private String nome;
	
	@Column(name = "NM_PAI_ALN", nullable = false)
	private String nomePai;
	
	@Column(name = "NM_MAE_ALN", nullable = false)
	private String nomeMae;
	
	@Column(name = "CPF_ALN", nullable = false)
	private String cpf;

	@Column(name = "RG_ALN", nullable = false)
	private String rg;

	@Column(name = "CPF_ALN", nullable = false)
	private String telefone;
	
	@Column(name = "DT_NSC_DAD", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private String dataNascimento;
	
	@Column(name = "DT_CAD_ALN", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDoCadastro;
	
	@OneToOne
	@Column(name = "END_ALN", nullable = false)
	private Endereco endereco;
	
	@OneToOne
	@Column(name = "USR_ALN", nullable = false)
	private Usuario usuario;
	
	@ManyToMany
	@Column(name = "PRF_ALN", nullable = false)
	private Professor professor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataDoCadastro() {
		return dataDoCadastro;
	}
	public void setDataDoCadastro(Date dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
}
