package com.es.eoi.beca;

public class TipoDatos {

	public String nombre;
	public String apellidos;
	public int diaNacimiento;
	public int mesNacimiento;
	public int anyoNacimiento;
	public String ciudad;
	public int edad;

	public TipoDatos(String nombre, String apellidos, int diaNacimiento, int mesNacimiento, int anyoNacimiento, String ciudad, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.diaNacimiento = diaNacimiento;
		this.mesNacimiento = mesNacimiento;
		this.anyoNacimiento = anyoNacimiento;
		this.ciudad = ciudad;
		this.edad = edad;
	}
}
