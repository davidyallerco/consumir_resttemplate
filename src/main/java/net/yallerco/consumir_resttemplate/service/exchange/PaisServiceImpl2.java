package net.yallerco.consumir_resttemplate.service.exchange;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.yallerco.consumir_resttemplate.entity.Pais;

@Service
public class PaisServiceImpl2 implements PaisService2 {
	
	String url = "http://localhost:8030/proveedor/pais";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Pais> buscarTodos() {
		// Crear los headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
     // Crear la entidad de la solicitud
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
		ResponseEntity<List<Pais>> response = restTemplate.exchange(
				url+"/listar",
				HttpMethod.GET, 
				entity ,
				new ParameterizedTypeReference<List<Pais>>() {}
				);
		 
		return response.getBody();
	}
	
	@Override
	public ResponseEntity<List<Pais>> buscarTodos2() {
		// Crear los headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
     // Crear la entidad de la solicitud
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
		ResponseEntity<List<Pais>> response = restTemplate.exchange(
				url+"/listar",
				HttpMethod.GET, 
				entity ,
				new ParameterizedTypeReference<List<Pais>>() {}
				);
        return response;
	}
	
	
	@Override
	public Pais buscarPorId(int id) {
		
		// Crear los headers (opcional, puedes agregar headers si es necesario)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        
     // Crear la entidad de la solicitud
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<Pais> response = restTemplate.exchange(
                url+"/buscar/{id}",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Pais>() {},
                id
        );
        return response.getBody();
	}
	
	@Override
	public ResponseEntity<Pais> buscarPorId2(int id) {
		
		// Crear los headers (opcional, puedes agregar headers si es necesario)
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        
     // Crear la entidad de la solicitud
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<Pais> response = restTemplate.exchange(
                url+"/buscar/{id}",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Pais>() {},
                id
        );
        return response;
	}
	
	//CREAR

	@Override
	public ResponseEntity<Pais> crear3(Pais pais) {
        // Crear los headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        // Crear la entidad de la solicitud
        HttpEntity<Pais> entity = new HttpEntity<>(pais, headers);

        // Realizar la solicitud usando exchange
        ResponseEntity<Pais> response = restTemplate.exchange(
                url+"/crear",
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<Pais>() {}
        );
        return response;
    }
	
	//ACTUALIZAR
	 @Override
	 public ResponseEntity<Pais> actualizar(int id, Pais pais) {
	        // Crear los headers
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Content-Type", "application/json");
	        headers.set("Accept", "application/json");
	        // Crear la entidad de la solicitud
	        HttpEntity<Pais> entity = new HttpEntity<>(pais, headers);
	        // Realizar la solicitud usando exchange
	        ResponseEntity<Pais> response = restTemplate.exchange(
	                url+"/{id}",
	                HttpMethod.PUT,
	                entity,
	                new ParameterizedTypeReference<Pais>() {},
	                id
	        );
	        return response;
	 }
	 
	 //ELIMINAR
	 @Override
	    public ResponseEntity<Void> eliminar(int id) {
	        // Crear los headers (opcional, puedes agregar headers si es necesario)
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Accept", "application/json");
	        // Crear la entidad de la solicitud (sin cuerpo para DELETE)
	        HttpEntity<Void> entity = new HttpEntity<>(headers);
	        // Realizar la solicitud usando exchange
	        ResponseEntity<Void> response = restTemplate.exchange(
	                url+"/eliminar/{id}",
	                HttpMethod.DELETE,
	                entity,
	                new ParameterizedTypeReference<Void>() {},
	                id
	        );
	        return response;
	  }


}
