package lecture0718.chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ReceiveRunnable implements Runnable{
	
	private BufferedReader br;
	private ChatClient cc;
	
	public ReceiveRunnable(BufferedReader br, ChatClient cc) {
		this.br = br;
		this.cc = cc;
	}
	
	@Override
	public void run() {
		String msg = null;
		try {
			while(true) {
				msg = br.readLine();
				if( msg == null ) {
					break;
				}
				cc.printMsg(msg);
			}
		} catch (IOException e) {
			
		} finally {
			try {
				if ( br != null ) br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
