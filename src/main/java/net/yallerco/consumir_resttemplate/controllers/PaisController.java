package net.yallerco.consumir_resttemplate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.yallerco.consumir_resttemplate.entity.Pais;
import net.yallerco.consumir_resttemplate.service.PaisesService;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	PaisesService service;
	//LISTAR
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> buscarTodos() {
		return service.obtenerPaises();
	}

	@GetMapping("/buscar/{id}")
	public Pais buscarPorId(@PathVariable("id") int id) {
		return service.buscarPorId(id);
	}
	
	//CREAR
	
	@PostMapping("/crear/{nombrePais}/{capital}/{codigo}")
	public void crear(
			@PathVariable("nombrePais") String nombrePais, 
			@PathVariable("capital") String capital,
			@PathVariable("codigo") String codigo) {
		service.crear(nombrePais, capital, codigo);
	}
	
	@PostMapping("/crear2/{nombrePais}/{capital}/{codigo}")
	public void crear2(
			@PathVariable("nombrePais") String nombrePais, 
			@PathVariable("capital") String capital,
			@PathVariable("codigo") String codigo) {
		service.crear2(nombrePais, capital, codigo);
	}
	
	@PostMapping("/crear3")
	public Pais crear3(@RequestBody Pais pais) {
		Pais response = service.crear3(pais);
		return response;
	}
	
	

}
