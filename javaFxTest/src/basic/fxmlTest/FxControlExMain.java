package basic.fxmlTest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/*
씬빌더 
View - show sample controller skeleton 누르고  full 체크 하고
복사해서 자바 컨트롤러 클래스에 붙여넣기
씬빌더 수정 후 fxml문서를 한번 열어줘야 업데이트 된다.

-----------------------
씬빌더 좌측하단 컨트롤러에  컨트롤러 클래스 설정하는것 까먹지말기
*/

public class FxControlExMain extends Application {

	@Override
	public void start(Stage primaryStage) {		
		
		try {
			VBox root = FXMLLoader.load(getClass().getResource("FxControlEx.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("연습");
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
