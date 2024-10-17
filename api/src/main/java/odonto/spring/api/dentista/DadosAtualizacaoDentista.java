package odonto.spring.api.dentista;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import odonto.spring.api.endereco.DadosEndereco;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosAtualizacaoDentista {
	
	@NotNull
	private Long id;
	private String nome;
	private String telefone;
	private DadosEndereco endereco;
}
