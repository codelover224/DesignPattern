package com.testClass;

import java.util.Scanner;

class Phone {

	String os, processor;
	double ram, screenS;

	Phone() {
		os = "Android";
		processor = "Snapdragon 820";
		ram = 5;
		screenS = 100;
	}

}

class PhoneBuilder {

	Phone P;

	PhoneBuilder(String os, String processor, int ram, int screenS) {
		P = new Phone();
		setOS(os);
		setProcessor(processor);
		setRam(ram);
		setscreenS(screenS);
	}

	void setOS(String os) {
		P.os = os;
	}

	void setProcessor(String processor) {
		P.processor = processor;
	}

	void setRam(int ram) {
		P.ram = ram;
	}

	void setscreenS(int screenS) {
		P.screenS = screenS;
	}
}

public class ClientDp {
	static PhoneBuilder pb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter os name:");
		String os = sc.nextLine();

		System.out.println("Enter processor name:");
		String processor = sc.nextLine();

		System.out.println("Enter ram size:");
		int ram = sc.nextInt();

		System.out.println("Enter Screen size:");
		int screenS = sc.nextInt();

		pb = new PhoneBuilder(os, processor, ram, screenS);
		pb.setOS("ios");
		pb.setProcessor("Snapdragon 850");
		System.out.println("OS is : " + os + "\nProcessor is: " + processor + "\nRAM is: " + ram);
	}
}