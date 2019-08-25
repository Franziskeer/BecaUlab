package com.es.eoi.beca.mapa;

public class Persona implements Comparable<Persona> {
	
	// ATRIBUTOS
	private String dni;
	private String nombre;
	private Integer anyo;
	private Integer edad;
	
	// GETTERS & SETTERS
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getAnyo() {
		return anyo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	// METODOS
	@Override
	public int compareTo(Persona o) {

		int valor = this.getNombre().compareTo(o.getNombre());

		if (valor == 0) {
			if (this.getEdad().equals(o.getEdad())) {
				if (this.getAnyo().equals(o.getAnyo())) {
					return 0;
				} else if (this.getAnyo() > o.getAnyo()) {
					return 1;
				} else {
					return -1;
				}
			} else if (this.getEdad() < o.getEdad()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return valor;
		}

	}
	
	@Override
	public String toString() {
		return String.format("Persona [dni=%s, nombre=%s, edad=%s, anyo=%s]", dni, nombre, edad, anyo);
	}

}
