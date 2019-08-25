package es.eoi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "VEHICULO")
public class Vehiculo {

	@Id
	@Column(name = "MATRICULA", unique = true)
	private String matricula;

	@Column(name = "MARCA")
	private String marca;

	@Column(name = "MODELO")
	private String modelo;
	
}
