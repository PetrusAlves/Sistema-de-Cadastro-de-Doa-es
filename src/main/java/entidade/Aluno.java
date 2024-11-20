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
@Table(name = "TBL_ALN")
public class Aluno {
	
	@Id
	@Column(name = "CD_ALN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NM_ALN", nullable = false)
	private String nome;
	
	@Column(name = "CPF_ALN", nullable = false)
	private String cpf;
	
	@Column(name = "DT_NSC_DAD", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private String dataNascimento;
	
	@Column(name = "RG_ALN", nullable = false)
	private int rg;
	
	@Column(name = "ALT_ALN", nullable = false)
	private double altura;
	
	@Column(name = "PES_ALN", nullable = false)
	private double peso;
	
	@OneToOne
	@Column(name = "END_ALN", nullable = false)
	private Endereco endereco;
	
	@OneToOne
	@Column(name = "USR_ALN", nullable = false)
	private Usuario usuario;
	
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
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
