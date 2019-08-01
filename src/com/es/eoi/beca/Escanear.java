package com.es.eoi.beca;

import java.util.Scanner;

public class Escanear {

	private static final String contrase�a = "123456";

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String resultado = "";
		Integer intentos = 0;

		do {
			intentos++;
			System.out.print("Introduce la contrase�a: ");
			resultado = scan.nextLine();
		} while (!resultado.equals(contrase�a) && intentos != 3);

		if (resultado.equals(contrase�a)) {
			System.out.println("�Enhorabuena!");
		}
		else {
			System.out.println("Te has quedado sin intentos");
		}
		
		scan.close();
	}

}
