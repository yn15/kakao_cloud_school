package com.problem3.uni;

public class ComputerTest {
	public static void main(String[] args) {
		Computer arrays [] = new Computer[4];
		
		arrays[0] = new Laptop("Lap01", 2, 1024, 2000);
		arrays[1] = new Laptop("Lap02", 3, 2048, 2300);
		arrays[2] = new Tab("Tap01", 2, 1024, 1200);
		arrays[3] = new Tab("Tap02", 3, 2048, 1300);
		
		System.out.println("name\tcpu\tmemory\tbattery");
		System.out.println("--------------------------------");
		for(Computer c : arrays) {
			System.out.println(c.getName()+"\t"+c.getCpu()+"\t"+c.getMemory()+"\t"+c.getBattery());
		}
		System.out.println();
		
		System.out.println("name\tcpu\tmemory\tbattery\trendering time");
		System.out.println("--------------------------------------");
		for(Computer c : arrays) {
			c.operate(55);
		}
		
		for(Computer c : arrays) {
			System.out.println(c.toString() + "\t" + Math.round(((Graphic)c).rendering(100))*1000/1000.0);
		}
		
		
	}
}
