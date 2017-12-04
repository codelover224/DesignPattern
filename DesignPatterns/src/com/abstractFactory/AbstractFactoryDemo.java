package com.abstractFactory;

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

interface Color {
	void draw();
}

class Red implements Color {
	public void draw() {
		System.err.println("RED");
	}
}

class Blue implements Color {
	public void draw() {
		System.err.println("BLUE");
	}
}

class Black implements Color {
	public void draw() {
		System.err.println("BLACK");
	}
}

abstract class AbstractFactory {

	abstract Shape getShape(String shape);

	abstract Color getColor(String color);
}

class ShapeFactory extends AbstractFactory {

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

	@Override
	Color getColor(String color) {
		return null;
	}

}

class ColorFactory extends AbstractFactory {
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("red")) {
			return new Red();
		}
		if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}
		if (color.equalsIgnoreCase("Black")) {
			return new Black();
		}
		return null;
	}

	@Override
	Shape getShape(String shape) {
		return null;
	}
}

class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice == null) {
			return null;
		}
		if (choice.equalsIgnoreCase("Shape")) {
			return new ShapeFactory();
		}
		if (choice.equalsIgnoreCase("Color")) {
			return new ColorFactory();
		}
		return null;
	}
}

public class AbstractFactoryDemo {

	public static void main(String[] args) {

		AbstractFactory afs = FactoryProducer.getFactory("shape");

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println("Enter the shape: ");
			String str1 = sc.nextLine();
			Shape shape = afs.getShape(str1);
			shape.draw();
		}
		
		AbstractFactory afc = FactoryProducer.getFactory("COLOR");


		for (int i = 0; i < 3; i++) {
			System.out.println("Enter the color: ");
			String str2 = sc.nextLine();
			Color color = afc.getColor(str2);
			color.draw();
		}
		sc.close();

	}

}
