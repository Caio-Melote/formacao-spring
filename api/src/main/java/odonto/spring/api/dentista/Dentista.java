package odonto.spring.api.dentista;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import odonto.spring.api.endereco.Endereco;

@Table(name = "dentistas")
@Entity(name = "Dentista")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dentista {
	
	public Dentista(DadosDentista dados) {
		this.ativo = true;
		this.nome = dados.nome;
		this.email = dados.email;
		this.telefone = dados.telefone;
		this.crm = dados.crm;
		this.especialidade = dados.especialidade;
		this.endereco = new Endereco(dados.endereco);
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private	String email;
	private String telefone;
	private String crm;
	private boolean ativo;
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	
	@Embedded
	private Endereco endereco;

	public void atualizarDados(DadosAtualizacaoDentista dados) {
		if(dados.getNome() != null){
			this.nome = dados.getNome();
		}
		
		if(dados.getTelefone() != null){
			this.telefone = dados.getTelefone();
		}
		
		if(dados.getEndereco() != null){
			this.endereco.atualizarDados(dados.getEndereco());
		}
		
		
	}

	public void excluirDentista() {
		this.ativo = false;
	}
}
