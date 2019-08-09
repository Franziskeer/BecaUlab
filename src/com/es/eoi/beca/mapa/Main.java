package com.es.eoi.beca.mapa;

import java.util.HashMap;

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
				
		HashMap<String, Persona> personas = new HashMap<String, Persona>();
		
		personas.put(p1.getDni(), p1);
		personas.put(p2.getDni(), p2);
		personas.put(p3.getDni(), p3);
		personas.put(p4.getDni(), p4);
		
		for (Persona p : personas.values()) {
			System.out.println(p);
		}
		
	}

}
