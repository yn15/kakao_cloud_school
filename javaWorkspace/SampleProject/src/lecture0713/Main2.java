package lecture0713;

class Student {
	private String name;
	private int age;
	
	public Student() {
		
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student tmp = (Student)obj;
		boolean result = false;
		if(this.name == tmp.name && this.age == tmp.age) {
			result = true;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "이름은 " + getName() + " 나이는 " + getAge();
	}
	
	
}


public class Main2 {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 20);
		Student s2 = new Student("홍길동", 20);
		
		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); //true
		
		//System.out.println(s1); // lecture0713.Student@5aaa6d82
		System.out.println(s1); // 이름은 홍길동 나이는 20
	}
}
