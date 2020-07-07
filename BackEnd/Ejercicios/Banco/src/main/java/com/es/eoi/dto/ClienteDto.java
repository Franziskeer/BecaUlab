package com.es.eoi.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect
public class ClienteDto {

	private String dni;
	
	private String nombre;
	
	private String direccion;
	
}
