package com.es.eoi.beca.strings;

public class EjercicioFechaStrings {

	public static String SEPARATOR = "========================================";

	public static void main(String[] args) {

		ejercicio4("perico");
		ejercicio4("09/08");
		ejercicio4("09/08/1998");
		ejercicio4("32/08/1998");
		ejercicio4("09/083/1998");
	}

	public static void ejercicio4(String date) {
		System.out.println(SEPARATOR);
		System.out.println("[EJERCICIO 4]");
		String[] fecha = new String[3];
		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		fecha = date.split("/");

		int dia, mes, anyo;

		try {

			dia = Integer.parseInt(fecha[0]);
			mes = Integer.parseInt(fecha[1]);
			anyo = Integer.parseInt(fecha[2]);

			if (dia > 0 && dia < 32) {

				if (mes > 0 && mes < 13) {
					System.out.println("Es el " + dia + " de " + meses[mes - 1] + " de " + anyo);
				} else {
					System.out.println("ERROR: El mes introducido no existe");
				}

			} else {
				System.out.println("ERROR: El día introducido no existe");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
