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
		// ����ü�� ũ�� ����
		lblView.setFont(Font.font("�ü�ü", 22));
		// ���ڻ� ����
		lblView.setTextFill(Color.web("#33ff66"));
		
		// Image��ü ����
		Image imgDecline = new Image(
			getClass().getResourceAsStream("images/not.png")
		);
		
		Image imgAccept = new Image(
			getClass().getResourceAsStream("images/ok.png")
		);
		
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		
		// ĸ�ǰ� �̹����� ���� �ִ� ��ư
		Button btn1 = 
			new Button("Accept", new ImageView(imgAccept) );
		
		// ĸ�Ǹ� �ִ� ��ư
		Button btn2 = new Button("Accept");
		
		// �̹����� �ִ� ��ư
		Button btn3 = new Button();
		btn3.setGraphic(new ImageView(imgDecline));
		
		
		vbox.getChildren().addAll(btn1, btn2, btn3);
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(15));
		root.setLeft(vbox);
		root.setCenter(lblView);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("��ư ����");
		
		primaryStage.setWidth(500);
		primaryStage.setHeight(300);
		
		primaryStage.show();
		
				
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}












