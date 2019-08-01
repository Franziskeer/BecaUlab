package com.es.eoi.beca;

public class Tablero {

	public static void main(String[] args) {
	
		int filas = 5, columnas = 5;
		int[][] tablero = new int[filas][columnas];
		
		tablero = generarTablero(filas, columnas);
		imprime(filas, columnas, tablero);
	
	}

	public static void imprime(int filas, int columnas, int[][] tablero) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] generarTablero(int filas, int columnas) {
		int[][] tablero = new int[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = i + j;
			}
		}
		
		return tablero;
	}

}
