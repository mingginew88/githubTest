package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		FlowPane root = new FlowPane();
		root.setPrefSize(300, 200);
		root.setHgap(10);  // 가로 간격
		root.setVgap(10);  // 세로 간격
		root.setPadding(new Insets(10));
		/*
		Button btn1 = new Button("1번버튼");
		Button btn2 = new Button("2번버튼");
		Button btn3 = new Button("3번버튼");
		Button btn4 = new Button("4번버튼");
		Button btn5 = new Button("5번버튼");
		Button btn6 = new Button("6번버튼");
		Button btn7 = new Button("7번버튼");
		Button btn8 = new Button("8번버튼");
		
		root.getChildren().addAll(btn1, btn2, btn3, 
				btn4, btn5, btn6, btn7, btn8);
		*/
		for(int i=1; i<=8; i++) {
			root.getChildren().add(new Button(i + "번버튼"));
		}
		
		// 버튼의 캡션이 첫번째, 두번째, 세번째, 네번째,
		//        다섯번째, 여섯번째 일때 ??
		
		String[] strArr = {"첫번째", "두번째", "세번째", "네번째",
				"다섯번째", "여섯번째"};
		for(int i=0; i<strArr.length; i++) {
			root.getChildren().add(new Button( strArr[i]) );
		}
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FlowPane 연습");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}













