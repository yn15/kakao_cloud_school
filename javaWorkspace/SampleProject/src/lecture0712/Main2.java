package lecture0712;

class Person extends Object{
	String name;    // 이름
	String mobile;  // 전화번호
	
	public void printAll() {
		System.out.println("모두 출력!!");
	}
}

class Student extends Person {
	String name;    // field는 중요정보이기 때문에 재정의하는 것은 일반적이지 않음
	String dept;    // 학과
	
	// default constructor
	public Student() {
		this("홍길동");
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public void printAll() {
		System.out.println("오버라이딩!");
	}
}

public class Main2 {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.name);
	}
}