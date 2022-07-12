package lecture0712;

public class Main1 {
	public static void main(String[] args) {
		InstanceTest test; // 지역변수 선언
		System.out.println("3번");
		int k = InstanceTest.myCall("4번");
		test = new InstanceTest();
		test.printMsg("5번");
	}
}
