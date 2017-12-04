package com.ProxyPattern;

interface Image {
	void display();
}

class RealImage implements Image {
	private String filename;

	public RealImage(String filename) {
		this.filename = filename;
		loadFromDisk(filename);
	}

	@Override
	public void display() {
		System.out.println("Displaying: " + filename);
	}

	public void loadFromDisk(String filename) {
		System.out.println("Loading: " + filename);
	}
}

class ProxyImage implements Image {
	private RealImage Image;
	private String filename;

	public ProxyImage(String filename) {
		this.filename = filename;
	}

	@Override
	public void display() {
		if (Image == null) {
			Image = new RealImage(filename);
		}
		Image.display();
	}
}

public class ProxyPatternDemo {
	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");
		image.display();
		System.out.println("");
		image.display();
	}
}
