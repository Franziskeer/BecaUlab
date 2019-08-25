package com.es.eoi.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect
public class CuentaDto {

	private int id;
	
	private double sueldo;
	
	private ClienteDto clientes;
	
	private BancoDto bancos;
	
}
