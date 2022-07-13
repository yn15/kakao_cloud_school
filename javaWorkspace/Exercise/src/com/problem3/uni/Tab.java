package com.problem3.uni;

public class Tab extends Computer implements Graphic{

	public Tab() {
		
	}
	
	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}

	@Override
	public double rendering(int size) {
		return (double)size/(this.getCpu()*this.getMemory())*30;
	}

	@Override
	public void operate(int time) {
		this.setBattery(this.getBattery()-time/5);
	}
	
	@Override
	public String toString() {
		return this.getName() + "\t" + this.getCpu() + "\t" + this.getMemory() + "\t" + Math.round(this.getBattery()*100.0);
	}
	
}
