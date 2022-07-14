package lecture0714;

class ThreadEx_01_1 extends Thread {
	@Override
	public void run(){
		for(int i = 0; i<5; i++) {
			System.out.println(getName());
			
		}
	}
	
}

class ThreadEx_01_2 implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println(Thread.currentThread().getName()); // 현재 실행되고 있는 Thread
		}
	}
}

public class ThreadExam01 {
	public static void main(String[] args) {
		ThreadEx_01_1 t1 = new ThreadEx_01_1();
		
		ThreadEx_01_2 a = new ThreadEx_01_2();
		Thread t2 = new Thread(a);
		
		// 싱글코어 환경에서 각 쓰레드의 우선순위를 부여하는 것이지만
		// 멀티코어 환경에서는 우선순위의 의미가 없음
		t1.setPriority(10); 
		t2.setPriority(2);
		
		t1.start();
		t2.start();

		System.out.println("main thread 종료");
	}
}
