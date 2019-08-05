package com.es.eoi.beca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Persona implements Comparable<Persona> {

	private String name;
	private int age;
	private int birthYear;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getBirthYear() {
		return birthYear;
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

	public static void main(String[] args) {
		List<Persona> personList = new ArrayList<Persona>();

		personList.add(new Persona("ANA", 20, 2010));
		personList.add(new Persona("ALBA", 26, 1988));
		personList.add(new Persona("ANA", 26, 2009));
		personList.add(new Persona("ALBA", 26, 2007));
		personList.add(new Persona("ANA", 26, 2015));
		personList.add(new Persona("ANA", 22, 2004));
		personList.add(new Persona("ANA", 26, 2006));

		for (Persona person : personList) {
			System.out.println(person);
		}

		Collections.sort(personList);
		System.out.println("Ordenados");
		
		for (Persona person : personList) {
			System.out.println(person);
		}
	}

	public Persona(String name, int age, int birthYear) {
		super();
		this.name = name;
		this.age = age;
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + ", age=" + age + ", birthYear=" + birthYear + "]";
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
