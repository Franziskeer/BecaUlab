package com.es.eoi.beca;

public class Meses {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		for (int i = 0; i < meses.length; i++) {
			int pos = i+1;
			System.out.println("El " + pos + "º mes del año es " + meses[i]);
		}
	}

}
