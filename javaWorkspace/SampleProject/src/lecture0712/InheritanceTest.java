package lecture0712;

class Superclass {
	// static method
	static int staticCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	// fields
	int a = staticCall("1번입니다.");
	static int b = staticCall("2번입니다.");
	
	// constructor
	public Superclass() {
		staticCall("3번입니다.");
	}
	
	public Superclass(int i) {
		this();
		staticCall("4번입니다.");
	}
	
	// method
	public void myFunc() {
		System.out.println("5번입니다.");
	}
}

public class InheritanceTest extends Superclass{
	// fields
	int c = staticCall("6번입니다.");
	static int d = staticCall("7번입니다.");
	
	// constructor
	public InheritanceTest() {
		super(100);
		staticCall("8번입니다.");
		super.myFunc();
	}
	
	@Override
	public void myFunc() {
		staticCall("9번입니다.");
	}
	
	public static void main(String[] args) {
		System.out.println("10번입니다.");
		Superclass obj = new InheritanceTest();
		obj.myFunc();
		// 객체에 대한 type이 상위 타입이라 할지라도
		// 만약 overriding된 method가 하위에 존재한다면
		// method는 overriding된 method를 사용한다
		// 동적 바인딩(dynamic binding)
	}
}
