package com.problem4.uni;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<>();
		list.add(new Rectangle(4, 7, 5));
		list.add(new Rectangle(5, 4, 6));
		list.add(new Circle(6, 6, 7));
		list.add(new Circle(7, 8, 3));
		
		System.out.println("구분\t\t길이\tX좌표\tY좌표\tArea\tCircumference");
		for(Shape s : list) { // 숭실대 정보통신과 - 김영준(98) - 상위객체에 abstract 선언해서 상위객체 타입으로 생성해도 오버라이딩 함수 사용 가능
			System.out.println(s + "\t" + Math.round(s.getArea()) + "\t" + Math.round(s.getCircumference()));
		}
		
		System.out.println("move move......");
		for(Shape s : list) {
			((Movable)s).move(10, 10);
			System.out.println(s);
		}
		
		System.out.println(((Rectangle)list.get(0)).getWidth());
	}

}
