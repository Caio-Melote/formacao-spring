package odonto.spring.api.dentista;

import odonto.spring.api.endereco.DadosEndereco;

public class DadosDentista {
	String nome;
	String email;
	String crm;
	Especialidade especialidade;
	DadosEndereco endereco;
	
	public DadosDentista() {
		
	}
	
	public DadosDentista(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
		this.nome = nome;
		this.email = email;
		this.crm = crm;
		this.especialidade = especialidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCrm() {
		return crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public DadosEndereco getEndereco() {
		return endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public void setEndereco(DadosEndereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "DadosDentista:"
				+ "\nNome = " + nome 
				+ "\nEmail = " + email 
				+ "\nCrm = " + crm 
				+ "\nEspecialidade = " + especialidade
				+ "\nEndereco = " + endereco;
	}
	
	
}
