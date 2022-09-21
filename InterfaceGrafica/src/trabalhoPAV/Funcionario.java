package trabalhoPAV;

public class Funcionario {

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String endereço;
	
	public Funcionario() {}
	
	public Funcionario(String nome, String cpf, String dataNascimento, String endereço) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereço = endereço;
	}
	
	public Funcionario(String cpf) {
		this.cpf = cpf;
	}
	
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

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	@Override
	public String toString() {
		return "Funcionario [Nome: " + nome + ", CPF: " + cpf + ", Data de Nascimento: " + dataNascimento + ", Endereço: "
				+ endereço + "]";
	}
}
