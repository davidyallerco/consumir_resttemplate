package net.yallerco.consumir_resttemplate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.yallerco.consumir_resttemplate.entity.Pais;
import net.yallerco.consumir_resttemplate.service.exchange.PaisService2;

@RestController
@RequestMapping("/pais2")//Solo cambia aqui , es para metodo exchange de resttemplate
public class PaisController2 {

	@Autowired
	PaisService2 service;
	
	//LISTAR
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> buscarTodos() {
		return service.buscarTodos();
	}
	
	@GetMapping(value = "/listarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pais>> buscarTodos2() {
		return service.buscarTodos2();
	}

	@GetMapping("/buscar/{id}")
	public Pais buscarPorId(@PathVariable("id") int id) {
		return service.buscarPorId(id);
	}
	
	@GetMapping("/buscar2/{id}")
	public ResponseEntity<Pais> buscarPorId2(@PathVariable("id") int id) {
		return service.buscarPorId2(id);
	}
	 
	//CREAR
	@PostMapping("/crear3")
	public ResponseEntity<Pais> crear3(@RequestBody Pais pais) {
		 return service.crear3(pais);
	}
	//ACTUALIZAR
	@PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable int id, @RequestBody Pais pais) {
        return service.actualizar(id, pais);
    }
	//ELIMINAR
	@DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable int id) {
        return service.eliminar(id);
    }
	


}
