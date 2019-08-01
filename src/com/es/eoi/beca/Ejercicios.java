package com.es.eoi.beca;

import java.util.Scanner;

public class Ejercicios {

	static Scanner sc;
	
	public static void main(String[] args) {

		ejercicio1();
		ejercicio2();
	}

	public static void ejercicio2() {
		// EJ 2
		sc = new Scanner(System.in);
		Integer num1, num2, resul;
		String op;
		
		System.out.print("Introduce un entero: ");
		num1 = sc.nextInt();
		System.out.print("Introduce otro entero: ");
		num2 = sc.nextInt();
		System.out.print("Introduce una operación (+,-,x,/): ");
		sc = new Scanner(System.in);
		op = sc.nextLine();
		
		System.out.print("Resultado: ");
		switch (op) {
		case "+":
			System.out.println(num1+num2);
			break;
		case "-":
			System.out.println(num1-num2);
			break;
		case "x":
			System.out.println(num1*num2);
			break;
		case "/":
			System.out.println(num1/num2);
			break;
		default:
			System.out.println("No es una operación válida");
			break;
		}
	}

	public static void ejercicio1() {
		// EJ 1
		System.out.println("--=== EJERCICIO 1 ===--");
		Integer num1 = 2, num2 = 3;
		Integer suma = num1 + num2;
		Integer resta = num1 - num2;
		Integer mult = num1 * num2;
		Integer div = num1 / num2;
		Integer mayor = (num1>num2) ? num1 : num2;
		
		System.out.println("Suma: " + suma);
		System.out.println("Resta: " + resta);
		System.out.println("Multiplicación: " + mult);
		System.out.println("División: " + div);
		System.out.println("Mayor: " + mayor);
	}

}
