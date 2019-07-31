package com.es.eoi.beca;

import java.text.MessageFormat;

public class ImprimirTipoDato {

	public static void main(String[] args) {
		
		TipoDatos[] personas = new TipoDatos[2];

		TipoDatos persona1 = new TipoDatos("Francisco", "Piñero Alpañés", 9, 8, 1998, "Villena", 20);
		TipoDatos persona2 = new TipoDatos("Juan José", "Jiménez", 2, 2, 1998, "Alicante", 20);
		personas[0] = persona1;
		personas[1] = persona2;

		muestraMensajes(personas);

	}

	public static void muestraMensajes(TipoDatos[] personas) {

		for (int i = 0; i < personas.length; i++) {

			String fechaNacimiento = personas[i].diaNacimiento + "/" + personas[i].mesNacimiento + "/" + personas[i].anyoNacimiento;

			String mensaje1 = MessageFormat.format("Hola me llamo {0} {1} y tengo {2} años.", personas[i].nombre, personas[i].apellidos, personas[i].edad);
			String mensaje2 = MessageFormat.format("Nací el {0} y vivo en {1}", fechaNacimiento, personas[i].ciudad);
		
			System.out.println(mensaje1);
			System.out.println(mensaje2);
			System.out.println();
		
		}

	}

}
