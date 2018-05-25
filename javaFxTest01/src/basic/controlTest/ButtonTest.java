package basic.controlTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		Label lblView = new Label();
		// 글자체와 크기 지정
		lblView.setFont(Font.font("궁서체", 22));
		// 글자색 지정
		lblView.setTextFill(Color.web("#33ff66"));
		
		// Image객체 생성
		Image imgDecline = new Image(
			getClass().getResourceAsStream("images/not.png")
		);
		
		Image imgAccept = new Image(
			getClass().getResourceAsStream("images/ok.png")
		);
		
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		
		// 캡션과 이미지가 같이 있는 버튼
		Button btn1 = 
			new Button("Accept", new ImageView(imgAccept) );
		
		// 캡션만 있는 버튼
		Button btn2 = new Button("Accept");
		
		// 이미지만 있는 버튼
		Button btn3 = new Button();
		btn3.setGraphic(new ImageView(imgDecline));
		
		
		vbox.getChildren().addAll(btn1, btn2, btn3);
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(15));
		root.setLeft(vbox);
		root.setCenter(lblView);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("버튼 연습");
		
		primaryStage.setWidth(500);
		primaryStage.setHeight(300);
		
		primaryStage.show();
		
				
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}












