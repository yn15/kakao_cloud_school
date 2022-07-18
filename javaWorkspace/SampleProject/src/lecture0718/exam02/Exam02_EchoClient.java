package lecture0718.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application{

	TextArea textarea;
	Button connBtn;
	TextField idfield, textfield;

	Socket socket = null;
	PrintWriter pr = null;
	InputStreamReader ir = null;
	BufferedReader br = null;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);  // window 크기
		
		textarea = new TextArea();
		root.setCenter(textarea); // 화면 center에 textarea 붙임
		
		connBtn = new Button("Echo 서버 접속");
		connBtn.setPrefSize(150, 40); // 버튼의 크기
		connBtn.setOnAction(e -> {
			textarea.clear();
			// 서버 process에 접속을 시도
			try {
				socket = new Socket("localhost", 5678);
				textarea.appendText("서버 연결 성공\n");
				pr = new PrintWriter(socket.getOutputStream());
				ir = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(ir);
			} catch (Exception e1) {
				
			}
		});
		
		idfield = new TextField();
		idfield.setPrefSize(100, 40);
		
		textfield = new TextField();
		textfield.setPrefSize(300, 40);
		// 입력 상자에 글 입력후 enter 입력하면 이벤트 처리
		textfield.setOnAction(e -> {
			try {
				String sendMsg = idfield.getText() + " : " + textfield.getText();
				if(textfield.getText().equals("/exit")) {
					pr.println(sendMsg);
					pr.flush();
					textarea.appendText("서버와의 연결을 종료합니다");
					textfield.setDisable(true);
					idfield.setDisable(true);
					br.close();
					ir.close();
					pr.close();
					socket.close();
				}else {
					pr.println(sendMsg);
					pr.flush();
					
					String receiveMsg = br.readLine();
					textarea.appendText(receiveMsg+"\n");
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			textfield.clear();
		}); 
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn); // 버튼 부착
		flowPane.getChildren().add(idfield);
		flowPane.getChildren().add(textfield); // 입력상자 부착
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch();
	}
}
