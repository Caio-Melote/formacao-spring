package odonto.spring.api.dentista;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import odonto.spring.api.endereco.DadosEndereco;

public class DadosDentista {
	
	@NotBlank
	String nome;
	
	@NotBlank
	@Email
	String email;
	
	@NotBlank
	String telefone;
	
	@NotBlank
	@Pattern(regexp = "\\d{4,6}")
	String crm;
	
	@NotNull
	Especialidade especialidade;
	
	@NotNull
	@Valid
	DadosEndereco endereco;
	
	public DadosDentista() {
		
	}
	
	public DadosDentista(String nome, String email, String telefone, String crm, Especialidade especialidade, DadosEndereco endereco) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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

	public String getTelefone() {
		return telefone;
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

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
				+ "\nTelefone = " + telefone
				+ "\nCrm = " + crm 
				+ "\nEspecialidade = " + especialidade
				+ "\nEndereco = " + endereco;
	}
	
	
}
