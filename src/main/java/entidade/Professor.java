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
@Table(name = "TBL_PRF")
public class Professor {
	
	@Id
	@Column(name = "CD_PRF")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NM_PRF", nullable = false)
	private String nome;
	
	@Column(name = "NM_PAI_PRF", nullable = false)
	private String nomePai;

	@Column(name = "NM_MAE_PRF", nullable = false)
	private String nomeMae;
	
	@Column(name = "CPF_PRF", nullable = false)
	private String cpf;
	
	@Column(name = "RG_PRF", nullable = false)
	private String rg;
	
	@Column(name = "DT_NSC_DAD", nullable = false)
	private String dataNascimento;
	
	@Column(name = "MAT_PRF", nullable = false)
	private long matricula;
	
	@Column(name = "TRN_PRF", nullable = false)
	private String turno;
	
	@Column(name = "TRM_PRF", nullable = false)
	private String turma;

	@Column(name = "PRD_PRF", nullable = false)
	private String periodo;
	
	@Column(name = "DSC_PRF", nullable = false)
	private String disciplina;
	
	@Column(name = "DT_CAD_ALN", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDoCadastro;
	
	@OneToOne
	@Column(name = "END_PRF", nullable = false)
	private Endereco endereco;
	
	@OneToOne
	@Column(name = "USR_PRF", nullable = false)
	private Usuario usuario;
	
	@ManyToMany
	@Column(name = "PRF_ALN", nullable = false)
	private Aluno aluno;
	
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
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataDoCadastro() {
		return dataDoCadastro;
	}
	public void setDataDoCadastro(Date dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	
}
