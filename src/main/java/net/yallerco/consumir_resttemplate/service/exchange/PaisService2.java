package net.yallerco.consumir_resttemplate.service.exchange;

import java.util.List;

import org.springframework.http.ResponseEntity;

import net.yallerco.consumir_resttemplate.entity.Pais;

public interface PaisService2 {


	List<Pais> buscarTodos();
	ResponseEntity<List<Pais>> buscarTodos2();
	Pais buscarPorId(int id);
	ResponseEntity<Pais> buscarPorId2(int id);
	ResponseEntity<Pais> crear3(Pais pais);
	ResponseEntity<Pais> actualizar(int id, Pais pais);
	ResponseEntity<Void> eliminar(int id);
	
}
