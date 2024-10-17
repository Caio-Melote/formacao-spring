package odonto.spring.api.dentista;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import odonto.spring.api.endereco.DadosEndereco;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
