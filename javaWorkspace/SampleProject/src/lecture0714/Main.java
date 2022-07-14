package lecture0714;

import javax.print.PrintException;

public class Main {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		try {
			Object obj  = null;
			System.out.println(obj.toString());
			int result = 10 / 0; // 오류 발생
		}catch(ArithmeticException e){ // excetpion을 처리,
			System.out.println("0으로 나눌 수 없어요!");
		}catch(NullPointerException e) {
			System.out.println("객체가 없어요!");
		}catch(Exception e){
			
		}finally {
			// 오류의 유무상관 없이 무조건 실행됨
		}
			
		System.out.println("프로그램 종료");
	}
}
