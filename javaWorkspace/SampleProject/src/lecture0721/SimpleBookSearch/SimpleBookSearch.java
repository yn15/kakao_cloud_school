package lecture0721.SimpleBookSearch;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lecture0721.SimpleBookSearch.service.BookService;
import lecture0721.SimpleBookSearch.vo.BookVO;

// View
public class SimpleBookSearch extends Application{
	TextArea textarea;
	Button searchBtn, deleteBtn;
	TextField textfield;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BookService service = new BookService();
		
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);  // window 크기
		
		textarea = new TextArea();
		textarea.setEditable(false);
		root.setCenter(textarea); // 화면 center에 textarea 붙임
		
		searchBtn = new Button("Keword로 검색");
		searchBtn.setPrefSize(150, 40); // 버튼의 크기
		searchBtn.setOnAction(e -> {
			textarea.clear();
			ArrayList<BookVO> result = service.bookSearchByKeyword(textfield.getText());
			
			for(BookVO i : result) {
				textarea.appendText(i.getBtitle() + "  " + i.getBauthor() + "  " + i.getBisbn() + "\n");
			}
		});
		
		deleteBtn = new Button("isbn으로 삭제");
		deleteBtn.setPrefSize(150, 40); // 버튼의 크기
		deleteBtn.setOnAction(e -> {
			textarea.clear();
			int count = service.bookDeleteByISSBN(textfield.getText());
			
			if(count == 1) {
				textarea.appendText("[삭제 성공] 1개 행 : " + textfield.getText() + "가 삭제 되었습니다.");
			}else {
				textarea.appendText("[삭제 실패]");
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
