package odonto.spring.api.dentista;

import odonto.spring.api.endereco.Endereco;

public record DadosDetalhadosDentista(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

	public DadosDetalhadosDentista(Dentista dentista) {
		this(dentista.getId(), dentista.getNome(), dentista.getEmail(), dentista.getCrm(), dentista.getTelefone(), dentista.getEspecialidade(), dentista.getEndereco());
	}
}
