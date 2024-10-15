package odonto.spring.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import odonto.spring.api.dentista.DadosDentista;

@RestController //A anotação declara que é uma classe controller do tipo REST para o SPRING
@RequestMapping("dentista") //A anotação mapeia a rota que tera acesso a esta classe
public class DentistaController {

	@PostMapping
	public void cadastrarDentista(@RequestBody DadosDentista json) {
		System.out.println(json.toString());
		
	}
	
}
