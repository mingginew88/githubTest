package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MarginPaddingTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox hbox1 = new HBox(10);	//spacing값 설정 방법1
		hbox1.setSpacing(10);		//spacing값 설정 방법2
		//spacing은 컨트롤과 컨트롤 사이의 간격
		
		
		//padding(안쪽여백)값 설정
		hbox1.setPadding(new Insets(50, 10, 50, 10));	//Padding(안쪽여백) -컨테이너에
//		hbox1.setPadding(new Insets(30));//4군데를 동일하게
		
		Button btn1 = new Button("첫번째");
		btn1.setPrefSize(100, 100);
		
		Button btn2 = new Button("두번째");
		btn2.setPrefSize(100, 100);
		
		
		//---------------------------------------------
		
		
		HBox hbox2 = new HBox();
		Button btn3 = new Button("세번째");
		btn3.setPrefSize(100, 100);
		
		Button btn4 = new Button("네번째");
		btn4.setPrefSize(100, 100);
		
		
		//Margin값 설정하기
		//Margin은 컨테이너에 추가되는 컨트롤을 기준으로 설정한다.
		//컨테이너 객체의 static메서드인 setMargin()을 사용한다. --Margin(바깥에 여백) - 컨트롤에
		
		//예) HBox에 추가될 btn3에 margin를 설정하기
		HBox.setMargin(btn3, new Insets(50, 50, 10, 10));
		
		hbox1.getChildren().addAll(btn1, btn2);
		hbox2.getChildren().addAll(btn3, btn4);
		
		hbox1.setStyle("-fx-background-color:yellow;");
		hbox2.setStyle("-fx-background-color:pink;");
		
		
		VBox vbox = new VBox();
		vbox.setSpacing(20);
		vbox.getChildren().addAll(hbox1, hbox2);		

		Scene scene = new Scene(vbox);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Padding과 Margin의 만남");		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
