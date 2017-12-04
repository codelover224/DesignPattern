package com.compositeMethod;

import java.util.ArrayList;

class Graphic {
	private String gName;
	private ArrayList<Graphic> graphics;

	Graphic(String gName) {
		this.gName = gName;
		graphics = new ArrayList<>();
	}

	public void Draw() {
		System.out.println("Drawing " + gName + ".....");
	}

	public void addGraphic(Graphic g) {
		graphics.add(g);
	}

	public void removeGraphic(Graphic g) {
		graphics.remove(g);
	}

	public ArrayList<Graphic> getGraphics() {
		return graphics;
	}

	public String toString() {
		return gName;
	}
}

public class Picture {
	public static void main(String[] args) {
		
		Graphic Picture = new Graphic("main");
		Graphic Picture2 = new Graphic("main2");

		Graphic Line = new Graphic("Line");
		Graphic Rectangle = new Graphic("Rectangle");
		Graphic Text = new Graphic("Text");

		Picture.addGraphic(Rectangle);
		Picture.addGraphic(Line);
		Picture.addGraphic(Picture2);
		Picture.addGraphic(Text);
		Picture2.addGraphic(Rectangle);
		Picture.removeGraphic(Rectangle);

		System.out.println(Picture);

		for (Graphic main : Picture.getGraphics()) {
			System.out.println(main);

			for (Graphic main2 : main.getGraphics()) {
				System.out.println(main2);
			}
		}
	}
}
