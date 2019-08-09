package com.es.eoi.beca.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Alumno> calif = new ArrayList<>();
	private static final String SEPARATOR = "===============================================";
	public static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		printMenu();

	}

	public static void printMenu() {

		String option;

		do {

			System.out.println(SEPARATOR);
			System.out.println("1 - Nueva calificación");
			System.out.println("2 - Listar calificaciones");
			System.out.println("3 - Listar calificaciones ascendentemente");
			System.out.println("4 - Listar calificaciones descendentemente");
			System.out.println("5 - Listar calificaciones INSUFICIENTES");
			System.out.println("6 - Listar calificaciones SUFICIENTES");
			System.out.println("7 - Listar calificaciones NOTABLES");
			System.out.println("8 - Listar calificaciones SOBRESALIENTES");
			System.out.print("--> Introduce una opción: ");

			option = in.nextLine();
			Integer optionSwitch = 0;

			try {
				optionSwitch = Integer.parseInt(option);
			} catch (Exception e) {
				System.out.println(e);
				printMenu();
			}

			switch (optionSwitch) {

			case 1:
				newMark();
				break;

			case 2:
				listMarks();
				break;

			case 3:
				listAsc();
				break;

			case 4:
				listDes();
				break;

			case 5:
				listCriteria(Notas.INSUFICIENTE);
				break;

			case 6:
				listCriteria(Notas.SUFICIENTE);
				break;

			case 7:
				listCriteria(Notas.NOTABLE);
				break;

			case 8:
				listCriteria(Notas.SOBRESALIENTE);
				break;

			default:
				break;

			}

		} while (!option.equals("1") || !option.equals("2") || !option.equals("3") || !option.equals("4")
				|| !option.equals("5") || !option.equals("6") || !option.equals("7") || !option.equals("8"));

	}

	public static void newMark() {

		System.out.println(SEPARATOR);
		System.out.println("HAS ELEGIDO INTRODUCIR NUEVA CALIFICACIÓN");

		System.out.print("Introduce el nombre del alumno: ");
		String name = in.nextLine();

		String mark;
		Double nota = -1.0;
		
		do {

			System.out.print("Introduce una nota del 0 al 10: ");
			mark = in.nextLine();
			try {
				nota = Double.parseDouble(mark);
			} catch (Exception e) {
				System.out.println(e);
			}
			
		} while (nota < 0 || nota > 10);
		
		if (nota >= 0) {
			calif.add(new Alumno(name, nota));
		}
	}

	public static void listMarks() {

		System.out.println(SEPARATOR);
		System.out.println("HAS ELEGIDO LISTAR CALIFICACIONES");

		for (Alumno alumno : calif) {

			System.out.println(alumno);

		}

	}

	public static void listAsc() {

		System.out.println(SEPARATOR);
		System.out.println("HAS ELEGIDO LISTAR CALIFICACIONES ASCENDENTEMENTE");

		List<Alumno> auxNotas = calif;
		Collections.sort(auxNotas);

		for (Alumno alumno : auxNotas) {

			System.out.println(alumno);

		}

	}

	public static void listDes() {

		System.out.println(SEPARATOR);
		System.out.println("HAS ELEGIDO LISTAR CALIFICACIONES DESCENDENTEMENTE");

		List<Alumno> auxNotas = calif;
		Collections.reverse(auxNotas);

		for (Alumno alumno : auxNotas) {

			System.out.println(alumno);

		}

	}

	public static void listCriteria(Notas nota) {

		System.out.println(SEPARATOR);
		System.out.println("HAS ELEGIDO LISTAR CALIFICACIONES " + nota);

		for (Alumno alumno : calif) {

			if (alumno.getCalificacion().equals(nota)) {

				System.out.println(alumno);

			}

		}

	}

}