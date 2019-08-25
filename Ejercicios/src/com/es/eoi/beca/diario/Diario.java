package com.es.eoi.beca.diario;

import java.io.*;
import java.util.Scanner;

public class Diario {

	public static final String SEPARATOR = "===================================";

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		printMenu();

	}

	private static void printMenu() throws IOException {

		System.out.println(SEPARATOR);
		System.out.println("1 - Escribir diario");
		System.out.println("2 - Leer diario");
		System.out.println("3 - Borrar diario");
		System.out.print("--> Introduce una opción: ");

		String option = in.nextLine();
		Integer optionSwitch = 0;
		
		try {
			
			optionSwitch = Integer.parseInt(option);
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}

		if (optionSwitch == 1 || optionSwitch == 2 || optionSwitch == 3) {
			switch (optionSwitch) {
			case 1:
				writeDiary();
				break;
			case 2:
				readDiary();
				break;
			case 3:
				eraseDiary();
				break;
			default:
				break;
			}
			
			printMenu();
		} else {
			System.out.println("ERROR: Opción inválida");
		}

	}

	

	private static void writeDiary() throws IOException {

		FileWriter fw = null;
		String line = "";

		try {

			fw = new FileWriter("./src/com/es/eoi/beca/diario/diary.txt", true);
			System.out.println("Escribe a partir de aqui:");

			while (!line.equals("FIN")) {
				line = in.nextLine();
				fw.write(line + "\n");
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

	private static void readDiary() throws IOException {

		BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("./src/com/es/eoi/beca/diario/diary.txt");
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
        	
            try {
            	
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
                
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
            
        }
        
	}
	
	private static void eraseDiary() throws IOException {
		
		FileWriter fw = null;
		
		try {

			fw = new FileWriter("./src/com/es/eoi/beca/diario/diary.txt", false);
			System.out.println("Se ha borrado correctamente");

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			if (fw != null) {
				fw.close();
			}

		}
		
	}

}
