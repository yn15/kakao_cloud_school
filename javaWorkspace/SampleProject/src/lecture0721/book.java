package lecture0721;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class book extends Application{
	TextArea textarea;
	Button searchBtn, deleteBtn;
	TextField textfield;
	static Connection con = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);  // window 크기
		
		textarea = new TextArea();
		textarea.setEditable(false);
		root.setCenter(textarea); // 화면 center에 textarea 붙임
		
		searchBtn = new Button("Keword로 검색");
		searchBtn.setPrefSize(150, 40); // 버튼의 크기
		searchBtn.setOnAction(e -> {
			textarea.clear();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String jdbcURL = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
				con = DriverManager.getConnection(jdbcURL, "root", "1234");
				
				String sql = "SELECT bisbn, btitle,  bdate FROM book WHERE btitle like ?";

				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, "%" + textfield.getText() + "%");
				
			    rs = pstmt.executeQuery();
				StringBuilder sb = new StringBuilder();
				
				while(rs.next()) {
					sb.append(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "\n");
				}
				
				textarea.appendText(sb.toString()+"\n");
			} catch (Exception e2) {
				System.out.println(e2);
			} finally {
				try {
					if( rs != null) rs.close();
					if( pstmt != null) pstmt.close();
					if( con != null) con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		deleteBtn = new Button("isbn으로 삭제");
		deleteBtn.setPrefSize(150, 40); // 버튼의 크기
		deleteBtn.setOnAction(e -> {
			textarea.clear();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			int rs = 0;
			try {
				String jdbcURL = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
				con = DriverManager.getConnection(jdbcURL, "root", "1234");
				
				String sql = "delete from book where bisbn = ?";

				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, textfield.getText());
				
				rs = pstmt.executeUpdate();
				
				if(rs == 1) {
					textarea.appendText("[삭제 성공] 1개 행 : " + textfield.getText() + "가 삭제 되었습니다.");
				}else {
					textarea.appendText("[삭제 실패]");
				}
				
			} catch (Exception e2) {
				System.out.println(e2);
			} finally {
				try {
					if( pstmt != null) pstmt.close();
					if( con != null) con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		textfield = new TextField();
		textfield.setPrefSize(350, 40);
		// 입력 상자에 글 입력후 enter 입력하면 이벤트 처리
		
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(searchBtn); // 버튼 부착
		flowPane.getChildren().add(textfield); // 입력상자 부착
		flowPane.getChildren().add(deleteBtn);
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
}
