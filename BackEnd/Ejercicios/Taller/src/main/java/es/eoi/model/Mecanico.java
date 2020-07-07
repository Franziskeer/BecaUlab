package es.eoi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mecanico {

	@Id
	@Column(name = "DNI", unique = true)
	private String dni;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "SALARIO")
	private Double salario;
	
	@OneToOne
	@JoinColumn(name = "plaza_id")
	private Aparcamiento plaza;
	
}
