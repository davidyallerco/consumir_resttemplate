package net.yallerco.consumir_resttemplate.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.yallerco.consumir_resttemplate.entity.Pais;


@Service
public class PaisesServiceImpl implements PaisesService{
	
	String url = "http://localhost:8030/proveedor/pais";
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Pais> obtenerPaises() {
		Pais[]  paises = restTemplate.getForObject(url+"/listar", Pais[].class);
		List<Pais> listaPaises = Arrays.asList(paises);
		System.out.println(listaPaises);
		return listaPaises;
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
	
	
	
	
	

	


	
	

}
