package com.es.eoi.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect
public class BancoDto {

	private int id;

	private String nombre;

	private String ciudad;
	
}
