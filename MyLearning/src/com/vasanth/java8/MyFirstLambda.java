package com.vasanth.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.vasanth.model.Person;

public class MyFirstLambda {
	
	private static List<Person> people = Arrays.asList(
			new Person("Karthick", "Maran", 32),
			new Person("Tamil","Vanchi",30),
			new Person("Vimal", "Damo", 32),
			new Person("Anhik", "Mohanty", 29),
			new Person("Vasanth", "Srinivasan", 30));
	
	public static void lambdaTest() {
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2 ) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});

		
		System.out.println("### Printing all names ###");
		printPeople(people, p -> true, 
				p -> System.out.println(p.getFirstName()+" , "+p.getLastName()));
		System.out.println();
		System.out.println("### Printing Last names starting with M ###");
		printPeople(people, p -> p.getLastName().startsWith("M"), 
				p -> System.out.println(p.getFirstName()+" , "+p.getLastName()));
		System.out.println();
		System.out.println("### Printing First name starting with V ###");
		printPeople(people, p -> p.getFirstName().startsWith("V"), 
				p -> System.out.println(p.getFirstName()+" ,  "+p.getLastName()));
	}
	
	public static void printPeople(List<Person> ppl, Predicate<Person> condition, Consumer<Person> consumer) {
		if (null != ppl) {
			for (Person p : ppl) {
				if(condition.test(p)) {
					consumer.accept(p);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFirstLambda.lambdaTest();
	}

}
