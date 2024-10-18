package odonto.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import odonto.spring.api.dentista.DadosAtualizacaoDentista;
import odonto.spring.api.dentista.DadosDentista;
import odonto.spring.api.dentista.DadosDetalhadosDentista;
import odonto.spring.api.dentista.DadosListagemDentista;
import odonto.spring.api.dentista.Dentista;
import odonto.spring.api.dentista.DentistaRepository;

@RestController // A anotação declara que é uma classe controller do tipo REST para o SPRING
@RequestMapping("dentista") // A anotação mapeia a rota que tera acesso a esta classe
public class DentistaController {

	@Autowired // Injeção de dependência
	private DentistaRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrarDentista(@RequestBody @Valid DadosDentista dados, UriComponentsBuilder uriBuilder) {
		Dentista dentista = new Dentista(dados);
		repository.save(dentista);
		
		var uri = uriBuilder.path("/dentista/{id}").buildAndExpand(dentista.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhadosDentista(dentista));
	}

	@GetMapping
	public ResponseEntity<Page<DadosListagemDentista>> listar(@PageableDefault(sort = { "nome" }) Pageable paginacao) {
		var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemDentista::new);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detalharDentista(@PathVariable Long id) {
		var dentista = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhadosDentista(dentista) );
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizarDentista(@RequestBody @Valid DadosAtualizacaoDentista dados) {
		var dentista = repository.getReferenceById(dados.getId());
		dentista.atualizarDados(dados);
		
		return ResponseEntity.ok(new DadosDetalhadosDentista(dentista)); //Usando o DTO da listagem
	}

	// Exclusão física (dados são apagados)
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluirDentista(@PathVariable Long id) {
//    	repository.deleteById(id);
//    }
	

	// Exclusão lógica (inativa e persiste os dados)
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluirDentista(@PathVariable Long id) {
		var dentista = repository.getReferenceById(id);
		dentista.excluirDentista();
		
		return ResponseEntity.noContent().build();
	}

	/*
	 * GET SEM PAGINAÇÃO
	 * 
	 * // @GetMapping // public List<DadosListagemDentista> listarDentista() { //
	 * return
	 * repository.findAll().stream().map(DadosListagemDentista::new).toList(); // }
	 * 
	 * // @GetMapping // public List<DadosListagemDentista> listar() { //
	 * List<DadosListagemDentista> listagemDentista = new ArrayList<>(); // for
	 * (Dentista dentista : repository.findAll()) { // listagemDentista.add(new
	 * DadosListagemDentista(dentista)); // } // return listagemDentista; // }
	 * 
	 */

}
