package com.es.eoi.beca.enums;

public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Notas calificacion;
	private Double nota;

	public Alumno(String name, Double nota) {
		super();
		this.nombre = name;
		this.nota = nota;
		setNota(nota);
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

	public void setNota(Double nota) {

		if (nota < 0) {
			
			this.nota = 0.0;
			this.calificacion = Notas.INSUFICIENTE;
			
		} else if (nota > 10) {
			
			this.nota = 10.0;
			this.calificacion = Notas.SOBRESALIENTE;
			
		} else {

			if (nota >= 0 && nota < 5) {
				calificacion = Notas.INSUFICIENTE;
			} else if (nota >= 5 && nota < 7) {
				calificacion = Notas.SUFICIENTE;
			} else if (nota >= 7 && nota < 9) {
				calificacion = Notas.NOTABLE;
			} else if (nota >= 9 && nota < 10) {
				calificacion = Notas.SOBRESALIENTE;
			}

		}

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
