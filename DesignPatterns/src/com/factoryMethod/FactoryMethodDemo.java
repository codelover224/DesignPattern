package com.factoryMethod;

import java.util.Scanner;

interface Shape {
	void draw();
}

class Rectangle implements Shape {
	public void draw() {
		System.err.println("Inside Rectangle's draw() method");
	}
}

class Square implements Shape {
	public void draw() {
		System.err.println("Inside Square's draw() method");
	}
}

class Circle implements Shape {
	public void draw() {
		System.err.println("Inside Circle's draw() method");
	}
}

class ShapeFactory {

	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle();
		}
		if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		}
		if (shapeType.equalsIgnoreCase("square")) {
			return new Square();
		}
		return null;
	}

}

public class FactoryMethodDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println("Enter the shape type from \n1)Circle \n2)rectangle \n3)Square");
			String str = sc.nextLine();

			Shape shape = shapeFactory.getShape(str);
			shape.draw();
		}
		sc.close();

		// Shape shape1 = shapeFactory.getShape("CIRCLE");
		// shape1.draw();
		//
		// Shape shape2 = shapeFactory.getShape("Square");
		// shape2.draw();
		//
		// Shape shape3 = shapeFactory.getShape("rectangle");
		// shape3.draw();
	}

}
