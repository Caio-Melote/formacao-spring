package odonto.spring.api.dentista;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosListagemDentista {
	
	private Long id;
	private String nome;
	private String email;
	private String crm;
	private Especialidade especialidade;
	
	public DadosListagemDentista(Dentista dentista) {
        this(dentista.getId(), dentista.getNome(), dentista.getEmail(), dentista.getCrm(), dentista.getEspecialidade());
    }
}
