package lecture0715;

class ThreadEx_08_1 extends Thread {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				System.out.println("interrupt()에 의해서 꺠어났어요!! 응애!");
			}
			gc();
			System.out.println("메모리 청소 완료! 현재 사용 가능한 메모리 양은 : " + freeMemory());
		}
	}
	
	private void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) {
			usedMemory = 0;
		}
	}
	
	public int totalMemory() { return MAX_MEMORY; }
	public int freeMemory() { return MAX_MEMORY - usedMemory; }
	
}

public class ThreadExam08 {
	public static void main(String[] args) {
		ThreadEx_08_1 t = new ThreadEx_08_1();
		t.setDaemon(true);
		t.start();
		
		int requireMemory = 0;
		
		for(int i = 0; i<20; i++) {
			requireMemory = (int)(Math.random() * 10) * 20; // 0.0보다 같거나 크고 200보다 작은 정수;
			
			// 필요한 memory가 사용할 수 있는 양보다 크거나
			// 현재 전체 메모리양의 60%이상을 사용하고 있을 때 gc를 실행
			if(requireMemory > t.freeMemory() || (t.freeMemory() < t.totalMemory()*0.4)) {
				t.interrupt(); // 이 구문만 쓸경우 gc() 실행이 끝날때까지 기다리지 않음
				try {
					t.join(100);
				} catch (Exception e) {
				}
			}
			
			t.usedMemory += requireMemory;
			System.out.println("사용된 메모리 양 : " + t.usedMemory);
		}
	}
	
}








