package com.es.eoi.beca;

import java.util.Scanner;

public class Random {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Integer numA, numB, numRand;
		
		System.out.print("Introduce un n�mero: ");
		numA = scan.nextInt();
		System.out.print("Introduce otro n�mero: ");
		numB = scan.nextInt();
		
		numRand = (int)Math.floor(Math.random()*(numA-numB)+numB);

		System.out.println("El n�mero aleatorio entre " + numA + " y " + numB + " es " + numRand);
		scan.close();
		
	}

}
