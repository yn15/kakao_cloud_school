package lecture0718.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam02_EchoServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		PrintWriter pr = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		try {
			serverSocket = new ServerSocket(5678);
			System.out.println("Echo Server 기동 - 포트번호(5678) - 클라이언트 접속 대기");
			socket = serverSocket.accept(); 
			
			ir = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(ir);
			
			pr = new PrintWriter(socket.getOutputStream());
			
			String msg = null;
			
			while(true) {
				msg = br.readLine();
				if(msg.equals("/exit") || msg == null){
					break;
				}
				pr.println(msg);
				pr.flush();
			}
		} catch (Exception e) {
			
		} finally {
			try {
				if( br != null ) br.close();
				if( ir != null ) ir.close();
				if( br != null ) pr.close();
				if (socket != null ) socket.close();
				if (serverSocket != null ) serverSocket.close();	
				System.out.println("Echo Server 종료");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
