package lecture0718.exam01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Server쪽 Process
public class Exam01_DateServer {
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(5678);
			System.out.println("Date Server 기동 - 포트번호(5678)");
			// blocking method
			// client의 접속을 대기하다 요청을 받으면 socket 객체를 생성하게 됨
			Socket socket = serverSocket.accept(); 
			
			// 접속이 성공한 상태
			
			PrintWriter pr = new PrintWriter(socket.getOutputStream());
			// 현재 날짜
			Date date = new Date();
			pr.println(date.toLocaleString());
			
			// 버퍼 안에 들어가 있는 데이터를 스트림을 통해 내보내는 시점은
			// 1. 스트림이 강제로 종료될 경우
			// 2. 버퍼의 공간이 다 찰 경우
			// 3. method를 이용해서 flush() 시킬 경우
			
			pr.flush();
			pr.close();
			socket.close();
			serverSocket.close();
			System.out.println("Date Server 종료");
		} catch (Exception e) {
			
		}
	}
}
