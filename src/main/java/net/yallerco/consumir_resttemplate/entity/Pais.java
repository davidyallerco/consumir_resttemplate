package net.yallerco.consumir_resttemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
	
	private Long id;
	private String pais;
	private String capital;
	private String codigo;

}
