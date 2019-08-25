package es.eoi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "APARCAMIENTO")
public class Aparcamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Min(1)
	@Column(name = "FILA")
	private Integer fila;

	@Min(1)
	@Column(name = "COLUMNA")
	private Integer columna;

}
