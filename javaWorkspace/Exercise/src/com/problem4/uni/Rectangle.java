package com.problem4.uni;

public class Rectangle extends Shape implements Movable{
	private int width;
	
	public Rectangle() {
		
	}
	
	public Rectangle(int width, int x, int y) {
		super(new Point(x, y));
		this.width = width;
	}
	
	public double getArea() {
//		return width*width;
		return Math.pow(this.getWidth(),2);
	}
	
	public double getCircumference() {
//		Point p = this.getPoint();
//		return p.getX()*2 + p.getY()*2;
		return this.getWidth()*4;
	}
	
	@Override
	public void move(int x, int y) {
//		Point p = this.getPoint();
//		super.setPoint(new Point(p.getX()+x+2, p.getY()+y+2));
		getPoint().setX(getPoint().getX() + (x+2));
		getPoint().setY(getPoint().getY() + (y+2));
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public String toString() {
		Point p = this.getPoint();
		return this.getClass().getSimpleName() + "\t" + getWidth() + "\t" + p.getX() + "\t" + p.getY();
	}
	
	
}
