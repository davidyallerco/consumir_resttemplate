package net.yallerco.consumir_resttemplate.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.yallerco.consumir_resttemplate.entity.Pais;


@Service
public class PaisesServiceImpl implements PaisesService{
	
	String url = "http://localhost:8030/proveedor/pais";
	
	@Autowired
	RestTemplate restTemplate;

	//Útil cuando solo necesitas el cuerpo de la respuesta 
	//y no necesitas acceso a otros detalles como el código de estado o los encabezados.
	@Override
	public List<Pais> obtenerPaises() {
		Pais[]  paises = restTemplate.getForObject(url+"/listar", Pais[].class);
		List<Pais> listaPaises = Arrays.asList(paises);
		System.out.println(listaPaises);
		return listaPaises;
	}

	//Útil cuando necesitas acceder a información adicional 
	//de la respuesta HTTP, como los encabezados o el código de estado.
	@Override
	public ResponseEntity<List<Pais>> obtenerPaises2() {
		ResponseEntity<Pais[]> response = restTemplate.getForEntity(url+"/listar", Pais[].class);
		Pais[] paisesArray = response.getBody();
		List<Pais> paisesList = Arrays.asList(paisesArray);
		HttpStatus statusCode = (HttpStatus) response.getStatusCode();
	    HttpHeaders headers = response.getHeaders();
	 // Crear una nueva ResponseEntity con la lista de paises y los mismos encabezados y código de estado
	    return new ResponseEntity<>(paisesList, headers, statusCode);
	}
	
	@Override
	public Pais buscarPorId(int id) {
		
		return restTemplate.getForObject(url+"/{id}", Pais.class,id);
	}
	
	@Override
	public void crear(String nombrePais,String capital,String codigo) {
		Pais pais = new Pais();
		pais.setPais(nombrePais);
		pais.setCapital(capital);
		pais.setCodigo(codigo);
		//postForLocation no devuelve resultado
		restTemplate.postForLocation(url+"/crear", pais);
	}
	
	@Override
	public void crear2(String nombrePais,String capital,String codigo) {
		//postForLocation no devuelve resultado
		restTemplate.postForLocation(url+"/agregar/{nombrePais}/{capital}/{codigo}", Pais.class,nombrePais, capital, codigo);
	}
	
	@Override
	public Pais crear3(Pais pais) {
		//postForObject SI devuelve resultado
		Pais response = restTemplate.postForObject(url+"/crear",pais, Pais.class);
		return response;
	}
	
	//ACTUALIZAR
	@Override
	public void actualizar(Long id,Pais pais) {
		//put no devuelve resultado
		restTemplate.put(url+"/{id}",pais, id);
	}
	
	@Override
	public void actualizar2(Pais pais) {
		//put no devuelve resultado
		restTemplate.put(url,pais);
	}
	
	//ELIMINAR
	@Override
	public void eliminar(Long id) {
		//delete no devuelve resultado
		restTemplate.delete(url+"/eliminar/{id}",id);
	}
	
	
	
	
	

	


	
	

}
