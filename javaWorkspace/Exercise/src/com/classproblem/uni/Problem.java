package com.classproblem.uni;

class Name {
	private String name;
	
	public synchronized void printName() {
		for(int i = 0; i<10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
				notify();
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
 
class Thread1 implements Runnable{
	Name n = new Name();
	@Override
	public void run() {
		n.printName();
	}
}

public class Problem {
	public static void main(String[] args) {
		Thread1 r = new Thread1();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
}
