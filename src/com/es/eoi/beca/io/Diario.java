package com.es.eoi.beca.io;

import java.io.*;
import java.util.Scanner;

public class Diario {

	public static void main(String[] args) {
		printMenu();
	}

	private static void printMenu() {

		Scanner in = new Scanner(System.in);
		System.out.println("1 - Escribir diario");
		System.out.println("2 - Leer diario");
		System.out.print("--> Introduce una opción: ");
		int option = in.nextInt();
		in.nextLine();

		if (option < 1 || option > 2) {
			System.out.println("ERROR: Introduce una opción válida");
			printMenu();
		} else {
			switch (option) {
			case 1:
				writeDiary();
				break;

			case 2:
				readDiary();
				break;
			default:
				break;
			}
		}

		printMenu();
	}

	private static void writeDiary() {

		FileWriter fw;
		Scanner input;

		try {
			fw = new FileWriter(new File("Diario.txt"), true);

			input = new Scanner(System.in);
			String line = input.nextLine();

			while (!line.equals("FIN")) {

				line = input.nextLine();
				fw.write(line);

			}

			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void readDiary() {
		// TODO Auto-generated method stub

	}

}
