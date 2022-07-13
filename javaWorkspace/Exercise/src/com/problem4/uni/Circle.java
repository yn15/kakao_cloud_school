package com.problem4.uni;

public class Circle extends Shape implements Movable{
	private int radius;
	
	public Circle() {
		
	}
	
	public Circle(int radius, int x, int y) {
		super(new Point(x, y));
		this.radius = radius;
	}
	
	public double getArea() {
//		return (double)radius*radius*3.14;
		return Math.PI * Math.pow(this.getRadius(),2);
	}
	
	public double getCircumference() {
//		return (double)2*3.14*radius;
		return Math.PI * this.getRadius() * 2;
	}
	
	@Override
	public void move(int x, int y) {
//		Point p = this.getPoint();
//		this.setPoint(new Point(p.getX()+x+1, p.getY()+y+1));
		getPoint().setX(getPoint().getX() + (x+1));
		getPoint().setY(getPoint().getY() + (y+1));
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		Point p = this.getPoint();
		return this.getClass().getSimpleName() + "\t\t" + getRadius() + "\t" + p.getX() + "\t" + p.getY();
	}
	
}
