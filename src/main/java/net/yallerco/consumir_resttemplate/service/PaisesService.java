package net.yallerco.consumir_resttemplate.service;

import java.util.List;

import net.yallerco.consumir_resttemplate.entity.Pais;


public interface PaisesService {

	List<Pais> obtenerPaises();
	
	Pais buscarPorId(int id);
	
	void crear(String nombrePais,String capital,String codigo);
	
	void crear2(String nombrePais,String capital,String codigo);

	Pais crear3(Pais pais);

	void actualizar(Long id,Pais pais);
	
	void actualizar2(Pais pais);
	

}
