package odonto.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import odonto.spring.api.dentista.DadosDentista;
import odonto.spring.api.dentista.Dentista;
import odonto.spring.api.dentista.DentistaRepository;

@RestController //A anotação declara que é uma classe controller do tipo REST para o SPRING
@RequestMapping("dentista") //A anotação mapeia a rota que tera acesso a esta classe
public class DentistaController {
	
	@Autowired //Injeção de dependência
	private DentistaRepository repository;
	
	@PostMapping
	public void cadastrarDentista(@RequestBody @Valid DadosDentista dados) {
		Dentista dentista = new Dentista(dados);
		repository.save(dentista);	
	}
	
}
