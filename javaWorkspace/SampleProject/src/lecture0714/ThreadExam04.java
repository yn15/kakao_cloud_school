package lecture0714;

import javax.swing.JOptionPane;

class ThreadEx_04 extends Thread {
	@Override
	public void run() {
		int i = 10;
		while(i!=0 && !isInterrupted()) {
			System.out.println(--i);
			
			// sleep 중 interrupt 가 발생하면 interrupt state가 false로 바뀌면서 기상함
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
				interrupt(); // 위의 주석으로 다시 interrupt 발생시켜줘야함
			}
			// for(long k = 0; k<25000000000L; k++); // 시간지연을 위해서
		}
		
		System.out.println("카운트가 종료되었습니다.");
	}
	
}

public class ThreadExam04 {
	public static void main(String[] args) {
		Thread t = new ThreadEx_04();
		t.start();
		
		String input = JOptionPane.showInputDialog("값을 입력하세요"); // main thread는 여기서 입력받을 때까지 blocking
		System.out.println("입력값음 : " + input);
		
		// Thread t의 interrupted 상태가 true가 됨
		t.interrupt();
		
		System.out.println("Thread의 상태값은 : " + t.isInterrupted());
	}
}
