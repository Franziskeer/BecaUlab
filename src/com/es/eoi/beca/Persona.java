package com.es.eoi.beca;

import java.util.HashMap;
import java.util.Map;

public class Persona implements Comparable<Persona> {

	private String name;
	private int age;
	private int birthYear;
	private String dni;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public String getDni() {
		return dni;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	public static void main(String[] args) {
		Map<String, Persona> personList = new HashMap<String, Persona>();

		Persona p1 = new Persona("ANA", 20, 2010, "100");
		Persona p2 = new Persona("ANA", 21, 2010, "101");
		Persona p3 = new Persona("MARTA", 20, 2010, "102");
		Persona p4 = new Persona("ANA", 22, 2010, "103");
		Persona p5 = new Persona("ANA MARIA", 22, 2010, "103");
		
		personList.put(p1.getDni(), p1);
		personList.put(p2.getDni(), p2);
		personList.put(p3.getDni(), p3);
		personList.put(p4.getDni(), p4);
		personList.put(p5.getDni(), p5);
		
		for (Map.Entry<String, Persona> entry : personList.entrySet()) {
            System.out.println(personList.get(entry.getKey()));
		} 

	}

	public Persona(String name, int age, int birthYear, String dni) {
		super();
		this.name = name;
		this.age = age;
		this.birthYear = birthYear;
		this.dni = dni;
	}

	@Override
	public String toString() {
		return dni + " [name=" + name + ", age=" + age + ", birthYear=" + birthYear + "]";
	}

	@Override
	public int compareTo(Persona o) {

		if (this.getName().equals(o.getName())) {

			if (this.getAge() == o.getAge()) {

				if (this.getBirthYear() == o.getBirthYear()) {
					return 0;
				} else if (this.getBirthYear() > o.getBirthYear()) {
					return 1;
				} else {
					return -1;
				}

			} else if (this.getAge() < o.getAge()) {
				return 1;
			} else {
				return -1;
			}

		}

		return this.getName().compareTo(o.getName());
	}

}
