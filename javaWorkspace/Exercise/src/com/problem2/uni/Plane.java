package com.problem2.uni;

public abstract class Plane {
	private String planeName;
	private int fuelSize;
	
	public Plane() {
		
	}
	
	public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	public void fuel(int fuel) {
		this.setFuelSize(this.getFuelSize() + fuel);
	}; // 주유
	
	public abstract void flight(int distance); // 운항

	@Override
	public String toString() {
		return planeName + "\t" + fuelSize;
	}
	
	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	
}