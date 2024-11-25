package entidade;

public class Cronograma {
    private String data;
    private String horario;
    private String dia;
    private String bairro;
    private String cidade;
    private String tempo;

    public Cronograma(String data,String horario,String dia, String bairro, String cidade, String tempo) {
        this.data = data;
        this.bairro = bairro;
        this.dia = dia;
        this.horario = horario;
        this.cidade = cidade;
        this.tempo = tempo;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
}

