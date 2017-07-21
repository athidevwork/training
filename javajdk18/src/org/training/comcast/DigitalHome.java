package org.training.comcast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Employee {
	String name;

	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
}

public class DigitalHome {

	public static void main(String[] args) {
		//[6, 5, 4, 3, 1]
		example1();
		
		//ConcurrentModificationException
		example2();
		
		//A
		//BB
		//CCC
		example3();
	}

	private static void example3() {
		StringBuilder sb = new StringBuilder();

		List<String> letters = Arrays.asList("A","B","C");

		for (String letter : letters) {
			for (int i = 0; i <= letters.indexOf(letter); i++) {
				sb.append(letter);
			}
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}

	private static void example2() {
		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee("Paul"));
		employees.add(new Employee("John"));
		employees.add(new Employee("George"));
		employees.add(new Employee("Ringo"));

		/*for (Employee e : employees) {
			if (e.getName() == "John") {
			employees.remove(e);
			}
		}*/

		System.out.println(employees);
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getName().equals("John")) {
				employees.remove(i);
			}
		}
		System.out.println(employees);
	}

	private static void example1() {
		Integer a = new Integer(1);

		Set<Integer> numbers = new HashSet<>();
		numbers.add(4);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(new Integer(6));
		numbers.add(a);

		List sortedList = new ArrayList(numbers);
		Collections.sort(sortedList, Collections.reverseOrder());

		System.out.println(sortedList);
	}

}
