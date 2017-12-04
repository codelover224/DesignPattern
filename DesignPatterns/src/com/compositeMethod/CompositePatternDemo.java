package com.compositeMethod;

import java.util.ArrayList;

class Employee {

	private String name;
	private String dept;
	private int salary;
	private ArrayList<Employee> subordinates;

	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		subordinates = new ArrayList<Employee>();
	}

	public void addEmployee(Employee e) {
		subordinates.add(e);
	}

	public void removeEmployee(Employee e) {
		subordinates.remove(e);
	}

	public ArrayList<Employee> getSubordinates() {
		return subordinates;
	}

	public String toString() {
		return ("Employee :[Name: " + name + ", Dept: " + dept + ", Salary: " + salary + "]");
	}

}

public class CompositePatternDemo {

	public static void main(String[] args) {

		Employee CEO = new Employee("Krushna", "CEO", 300000);

		Employee headSales = new Employee("Pratik", "Head Sales", 200000);
		Employee headMarketing = new Employee("Nihal", "Head Marketing", 200000);

		Employee clerk1 = new Employee("Laura", "Marketing", 100000);
		Employee clerk2 = new Employee("Bob", "Marketing", 100000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 100000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 100000);

		CEO.addEmployee(headMarketing);
		CEO.addEmployee(headSales);

		headSales.addEmployee(salesExecutive1);
		headSales.addEmployee(salesExecutive2);

		headMarketing.addEmployee(clerk1);
		headMarketing.addEmployee(clerk2);

		System.out.println(CEO);

		for (Employee headEmployee : CEO.getSubordinates()) {
			System.out.println(headEmployee);

			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee);
			}
		}

	}

}