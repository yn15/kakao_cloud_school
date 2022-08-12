package lecture0718.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import chatex.Exam03_ChatServer.ClientRunnable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ChatServer {
	TextArea textarea;
	Button startBtn, stopBtn;
	ServerSocket serverSocket;
	ExecutorService executorService = Executors.newCachedThreadPool();
	SharedObject sharedObject = new SharedObject();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textarea = new TextArea();
		textarea.setEditable(false);
		root.setCenter(textarea);
		
		
		startBtn = new Button("Chat Server 기동");
		startBtn.setPrefSize(150, 40);
		startBtn.setOnAction(e->{
			textarea.clear();
			printMsg("[ 채팅서버 기동 - 5555 ]");
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						serverSocket = new ServerSocket(5555);
						while(true) {
							printMsg("[ 클라이언트 접속 대기중 ]");
							Socket socket = serverSocket.accept();
							ClientRunnable cRunnable = new ClientRunnable(sharedObject,socket);
							synchronized (this) {
								sharedObject.clients.add(cRunnable);
							}
							printMsg("[ 클라이언트 접속 - 현재 클라이언트 수 : " + sharedObject.clients.size() + " ]");							
							executorService.execute(cRunnable);							
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(runnable);
		});

		stopBtn = new Button("Chat Server 중지");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(e->{
			printMsg("[ 서버 중지 - 프로그램 재시작 필요 ]");
			executorService.shutdownNow();
		});
		
		
		FlowPane flowPane = new FlowPane();
     	flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(startBtn);
		flowPane.getChildren().add(stopBtn);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chat Server ( Java IO )");
		primaryStage.setOnCloseRequest(e->{
			executorService.shutdownNow();
		});
		primaryStage.show();	
		
		 
	}
	 
	public static void main(String[] args) {
		launch();
	}
}
