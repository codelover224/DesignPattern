package com.factoryMethod;

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

class ColorFcatory {
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
}

public class FactoryMethodDemo2 {

	public static void main(String[] args) {

		ColorFcatory cf = new ColorFcatory();

		Color color1 = cf.getColor("black");
		color1.draw();

		Color color2 = cf.getColor("RED");
		color2.draw();

		Color color3 = cf.getColor("BLue");
		color3.draw();

	}

}
