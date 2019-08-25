package com.es.eoi.beca.enums;


public enum Notas {
	
	SOBRESALIENTE("SOBRESALIENTE"), 
	NOTABLE("NOTABLE"), 
	SUFICIENTE("SUFICIENTE"), 
	INSUFICIENTE("INSUFICIENTE");

	private String descripcion;

	private Notas(String text) {
		this.descripcion = text;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String text) {
		this.descripcion = text;
	}

}