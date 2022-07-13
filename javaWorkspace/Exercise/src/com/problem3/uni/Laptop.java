package com.problem3.uni;

public class Laptop extends Computer implements Graphic {

	
	public Laptop () {
		
	}
	
	public Laptop(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}

	@Override
	public double rendering(int size) {
		return (double)size/(this.getCpu()*this.getMemory())*20;
	}

	@Override
	public void operate(int time) {
		this.setBattery(this.getBattery()-time/10);
	}
	
	@Override
	public String toString() {
		return this.getName() + "\t" + this.getCpu() + "\t" + this.getMemory() + "\t" + Math.round(this.getBattery()*100.0);
	}
}
