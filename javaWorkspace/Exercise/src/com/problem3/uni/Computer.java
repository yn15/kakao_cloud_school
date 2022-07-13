package com.problem3.uni;

public abstract class Computer {
	private String name; // 이름
	private int cpu; // CPU
	private int memory; // 메모리
	private int battery; // 배터리
	
	public Computer() {
		
	}
	
	public Computer(String name, int cpu, int memory, int battery) {
		this.name = name;
		this.cpu = cpu;
		this.memory = memory;
		this.battery = battery;
	}
	
	public abstract void operate(int time); // 사용시간

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	
}
