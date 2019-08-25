package com.es.eoi.beca.strings;

import java.util.Scanner;

public class Strings {

	public static String SEPARATOR = "========================================";

	public static void main(String[] args) {

		ejercicio1();

		ejercicio2();

		ejercicio3();

		ejercicio4("09/08/1998");

		ejercicio5();
	}

	public static void ejercicio1() {
		System.out.println(SEPARATOR);
		System.out.println("[EJERCICIO 1]");
		String frase = "Esto es una prueba";
		System.out.println(frase.toUpperCase());
	}

	public static void ejercicio2() {
		System.out.println(SEPARATOR);
		System.out.println("[EJERCICIO 2]");
		String frase = "La clase String, tiene varios métodos, muy útiles, como saber su longitud, trocear la cadena, etc";
		String[] arrayFrases = frase.split(",");

		for (String linea : arrayFrases) {
			System.out.println(linea.trim());
		}
	}

	public static void ejercicio3() {
		System.out.println(SEPARATOR);
		System.out.println("[EJERCICIO 3]");
		String frase = "Esto es un ejemplo usado para determinar un indice";
		System.out.println(frase.indexOf("ejemplo"));
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

	public static void ejercicio5() {
		System.out.println(SEPARATOR);
		System.out.println("[EJERCICIO 5]");
		System.out.print("Introduce una frase: ");

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String frase = scan.nextLine();
		frase = frase.toUpperCase();

		char[] str = frase.toCharArray();
		int contA = 0;
		int contE = 0;
		int contI = 0;
		int contO = 0;
		int contU = 0;

		for (int i = 0; i < str.length; i++) {
			switch (str[i]) {
			case 'A':
				contA++;
				break;
			case 'E':
				contE++;
				break;
			case 'I':
				contI++;
				break;
			case 'O':
				contO++;
				break;
			case 'U':
				contU++;
				break;
			}
		}
		System.out.println("Vocales en la frase: ");
		System.out.println("Vocal A: " + contA + " veces.");
		System.out.println("Vocal E: " + contE + " veces.");
		System.out.println("Vocal I: " + contI + " veces.");
		System.out.println("Vocal O: " + contO + " veces.");
		System.out.println("Vocal U: " + contU + " veces.");
	}

}
