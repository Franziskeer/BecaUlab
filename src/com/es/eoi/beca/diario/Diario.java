package com.es.eoi.beca.diario;

import java.io.*;
import java.util.Scanner;

public class Diario {

	public static final String SEPARATOR = "===================================";

	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException  {

		printMenu();
		in.close();
		
	}

	private static void printMenu() throws IOException {
		
		System.out.println(SEPARATOR);
		System.out.println("1 - Escribir diario");
		System.out.println("2 - Leer diario");
		System.out.print("--> Introduce una opción: ");
		Integer option = in.nextInt();
		in.nextLine();
		
		if (option == 1 || option == 2) {
			switch (option) {
			case 1:
				writeDiary();
				break;
			case 2:
				//readDiary();
				break;

			default:
				break;
			}
		}
		
		printMenu();

	}

	private static void writeDiary() throws IOException {
		
		FileWriter fw = null;
		String line = "";

		try {

			fw = new FileWriter("./src/com/es/eoi/beca/diario/diary.txt", true);
			System.out.println("Escribe a partir de aqui:");
			
			while (!line.equals("FIN")) {
				line = in.nextLine();
				fw.write(line+"\n");
			}
			
			System.out.println("Se ha guardado correctamente");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (fw != null) {
				fw.close();
			}
		}
		
	}
}
