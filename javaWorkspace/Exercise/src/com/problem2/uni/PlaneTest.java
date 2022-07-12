package com.problem2.uni;

public class PlaneTest {

	public static void main(String[] args) {
		Airplane a = new Airplane("L747", 1000);
		Cargoplane b = new Cargoplane("C40", 1000);
		
		printHead(a, b);

		a.flight(100);
		b.flight(100);
		System.out.println("100운항");
		printHead(a, b);

		a.fuel(200);
		b.fuel(200);
		System.out.println("200운항");
		printHead(a, b);
		
	}
	
	public static void printHead(Airplane a, Cargoplane b) {
		System.out.println("Plane\tfuelSize");
		System.out.println("----------------------");
		System.out.println(a);
		System.out.println(b);
		System.out.println();
	}
}
