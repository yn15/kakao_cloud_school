package lecture0718.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientRunnable implements Runnable{
	private SharedObject sharedObject;		
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ClientRunnable(SharedObject sharedObject,Socket socket) throws IOException {
		this.sharedObject = sharedObject;
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(socket.getOutputStream());						
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
				sharedObject.broadcast(msg);					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if( pw != null ) pw.close();
			if( br != null ) br.close();				
			if( socket != null ) socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		sharedObject.clients.remove(this);
	}
}
