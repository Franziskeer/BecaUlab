package com.es.eoi.beca.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Persona p1 = new Persona();
		p1.setDni("123456789");
		p1.setNombre("Ana");
		p1.setEdad(26);
		p1.setAnyo(2010);
		
		Persona p2 = new Persona();
		p2.setDni("987654321");
		p2.setNombre("Alba");
		p2.setEdad(21);
		p2.setAnyo(1988);
		
		Persona p3 = new Persona();
		p3.setDni("456123789");
		p3.setNombre("Ana");
		p3.setEdad(26);
		p3.setAnyo(2009);
		
		Persona p4 = new Persona();
		p4.setDni("321654987");
		p4.setNombre("Alba");
		p4.setEdad(26);
		p4.setAnyo(2007);
		
		List<Persona> personas = new ArrayList<>();
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		
		for (Persona p : personas) {
			System.out.println(p);
		}

		System.out.println("-----------------------------------");
		
		Collections.sort(personas);
		
		for (Persona p : personas) {
			System.out.println(p);
		}
		
	}

}
