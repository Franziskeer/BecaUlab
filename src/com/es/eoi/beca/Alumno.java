package com.es.eoi.beca;

public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Notas calificacion;
	private Double nota;

	public Alumno(String name, Notas calificacion, Double nota) {
		super();
		this.nombre = name;
		this.calificacion = calificacion;
		this.nota = nota;
	}

	public String getName() {
		return nombre;
	}

	public Notas getCalificacion() {
		return calificacion;
	}

	public Double getNota() {
		return nota;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public void setCalificacion(Notas calificacion) {
		this.calificacion = calificacion;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [name=" + nombre + ", calificacion=" + calificacion + ", nota=" + nota + "]";
	}

	@Override
	public int compareTo(Alumno o) {
		if (this.getNota() > o.getNota()) {
			return 1;
		} else if (this.getNota() < o.getNota()) {
			return -1;
		}
		return 0;
	}

}
