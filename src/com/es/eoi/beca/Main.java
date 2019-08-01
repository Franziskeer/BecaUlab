package com.es.eoi.beca;

public class Main {

	public static Animal[] jaula = new Animal[15];

	public static void main(String[] args) {

		rellenarJaula(jaula);

		for (int i = 0; i < jaula.length; i++) {

			if (jaula[i] instanceof Perro) {
				((Perro) jaula[i]).ladrar();
			} else if (jaula[i] instanceof Gato) {
				((Gato) jaula[i]).maullar();
			} else if (jaula[i] instanceof Raton) {
				((Raton) jaula[i]).roer();
			}

		}
	}

	public static void rellenarJaula(Animal[] jaula) {

		for (int i = 0; i < 5; i++) {
			Gato gato = new Gato();
			jaula[i] = gato;
		}

		for (int i = 5; i < 10; i++) {
			Perro perro = new Perro();
			jaula[i] = perro;
		}

		for (int i = 10; i < 15; i++) {
			Raton raton = new Raton();
			jaula[i] = raton;
		}

	}

}
