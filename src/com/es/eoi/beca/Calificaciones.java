package com.es.eoi.beca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Calificaciones {

	private static List<Alumno> calif = new ArrayList<>();

	private static final String SEPARATOR = "===============================================";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		printMenu(in);
		
	}

	public static void printMenu(Scanner in) {

		System.out.println(SEPARATOR);
		System.out.println("1 - Nueva calificación");
		System.out.println("2 - Listar calificaciones");
		System.out.println("3 - Listar calificaciones ascendentemente");
		System.out.println("4 - Listar calificaciones descendentemente");
		System.out.println("5 - Listar SOBRESALIENTES");
		System.out.println("6 - Listar NOTABLES");
		System.out.println("7 - Listar SUFICIENTES");
		System.out.println("8 - Listar INSUFICIENTES");
		System.out.print("--> Introduce una opción: ");
		Integer option = in.nextInt();
		in.nextLine();

		if (option < 1 || option > 7) {
			System.out.println("ERROR: El valor de la opción no es correcto");
			printMenu(in);
		} else {

			switch (option) {
			case 1:
				newMark(in);
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

		}

		printMenu(in);

	}

	public static void newMark(Scanner in) {

		System.out.println(SEPARATOR);
		System.out.println("HAS ELEGIDO INTRODUCIR NUEVA CALIFICACIÓN");

		System.out.print("Introduce el nombre del alumno: ");
		String name = in.nextLine();

		System.out.print("Introduce una nota del 0 al 10: ");
		Double mark = in.nextDouble();
		in.nextLine();

		Notas nota = null;

		if (mark < 0 || mark > 10) {
			System.out.println("ERROR: El valor debe estar entre 0 y 10");
			newMark(in);
		} else {

			if (mark >= 0 && mark < 5) {
				nota = Notas.INSUFICIENTE;
			} else if (mark >= 5 && mark < 7) {
				nota = Notas.SUFICIENTE;
			} else if (mark >= 7 && mark < 9) {
				nota = Notas.NOTABLE;
			} else if (mark >= 9 && mark < 10) {
				nota = Notas.SOBRESALIENTE;
			}

			calif.add(new Alumno(name, nota, mark));
			
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
