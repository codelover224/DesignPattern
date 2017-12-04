package com.facadeDP;

import java.io.IOException;
import java.util.Scanner;

interface MobileShop {
	
	public void modelNo();
	public void price();
}

class IPhone implements MobileShop {

	@Override
	public void modelNo() {
		System.out.println("IPhone 7+");
	}

	@Override
	public void price() {
		System.out.println("Rs 73,950.00");
	}
}

class Samsung implements MobileShop {

	@Override
	public void modelNo() {
		System.out.println("Samsung S8");
	}

	@Override
	public void price() {
		System.out.println("Rs 69,850.00");
	}
}

class Blackberry implements MobileShop {

	@Override
	public void modelNo() {
		System.out.println("Blackberry Z10");
	}

	@Override
	public void price() {
		System.out.println("Rs 55,000.00");
	}
}

class ShopKeeper {
	private MobileShop iphone;
	private MobileShop samsung;
	private MobileShop blackberry;

	public ShopKeeper() {
		iphone = new IPhone();
		samsung = new Samsung();
		blackberry = new Blackberry();
	}

	public void iphoneSale() {
		iphone.modelNo();
		iphone.price();
	}

	public void samsungSale() {
		samsung.modelNo();
		samsung.price();
	}

	public void blackberrySale() {
		blackberry.modelNo();
		blackberry.price();
	}
}

public class FacadeDP {
	private static int choice;

	public static void main(String[] args) throws NumberFormatException, IOException {
		do {
			System.out.print("========= Mobile Shop ============ \n");
			System.out.print("            1. IPHONE.              \n");
			System.out.print("            2. SAMSUNG.              \n");
			System.out.print("            3. BLACKBERRY.            \n");
			System.out.print("            4. Exit.                     \n");
			System.out.print("Enter your choice: ");

			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			ShopKeeper sk = new ShopKeeper();
			sc.close();

			switch (choice) {
			case 1: {
				sk.iphoneSale();
			}
				break;
			case 2: {
				sk.samsungSale();
			}
				break;
			case 3: {
				sk.blackberrySale();
			}
				break;
			default: {
				System.out.println("You purchased nothing");
			}
				return;
			}

		} while (choice != 4);
	}
}
