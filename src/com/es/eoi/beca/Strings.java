package com.es.eoi.beca;

import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {

		ej1();

		ej2();

		ej3();

		ej4("09/08/1998");
		
		ej5();
	}

	public static void ej1() {
		System.out.println("========================================");
		System.out.println("[EJERCICIO 1]");
		String ej1 = "Esto es una prueba";

		System.out.println(ej1.toUpperCase());
	}

	public static void ej2() {
		System.out.println("========================================");
		System.out.println("[EJERCICIO 2]");
		String str = "La clase String, tiene varios métodos, muy útiles, como saber su longitud, trocear la cadena, etc";
		String[] ej2 = str.split(",");

		for (String string : ej2) {
			System.out.println(string);
		}
	}

	public static void ej3() {
		System.out.println("========================================");
		System.out.println("[EJERCICIO 3]");
		String ej3 = "Esto es un ejemplo usado para determinar un indice";

		System.out.println(ej3.indexOf("ejemplo"));
	}

	public static void ej4(String date) {
		System.out.println("========================================");
		System.out.println("[EJERCICIO 4]");
		String[] fecha = new String[3];
		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		fecha = date.split("/");

		int mes = Integer.parseInt(fecha[1]);
		System.out.println("Es el " + fecha[0] + " de " + meses[mes - 1] + " de " + fecha[2]);
	}
	
	public static void ej5() {
		System.out.println("========================================");
		System.out.println("[EJERCICIO 5]");
		System.out.print("Introduce una frase: ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String frase = scan.nextLine();
		char[] str = frase.toCharArray();
		int cont = 0;
		
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'A' || str[i] == 'a' || str[i] == 'E' || str[i] == 'e' || str[i] == 'I' || str[i] == 'i' || str[i] == 'O' || str[i] == 'o' || str[i] == 'U' || str[i] == 'u')
			{
				cont++;
			}
		}
		System.out.println("Vocales en la frase: " + cont);
	}

}
