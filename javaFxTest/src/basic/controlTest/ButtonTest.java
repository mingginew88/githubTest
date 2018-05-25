package basic.controlTest;

import javafx.application.Application;
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
		//����ü�� ũ�� ����
		lblView.setFont(Font.font("�ü�ü", 22));
		//���ڻ� ����
		lblView.setTextFill(Color.web("#33ff66"));
		//Image��ü ����
		Image imgDecline = new Image(getClass().getResourceAsStream("images/not.png"));		
		Image imgAccept = new Image(getClass().getResourceAsStream("images/ok.png"));
		
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		
		//ĸ�ǰ� �̹����� ���� �ִ� ��ư
		Button btn1 = new Button("Accept", new ImageView(imgAccept));		
		Button btn2 = new Button("Decline", new ImageView(imgDecline));
		
		//ĸ�Ǹ� �ִ� ��ư
		Button btn3 = new Button("Accept");
		Button btn4 = new Button("Decline");
		
		//�̹����� �ִ� ��ư
		Button btn5 = new Button();
		btn5.setGraphic(new ImageView(imgAccept));
		Button btn6 = new Button();
		btn6.setGraphic(new ImageView(imgDecline));
		
		vbox.getChildren().addAll(btn1,btn3,btn5, btn2, btn4, btn6);
		
		BorderPane root = new BorderPane();
		root.setLeft(vbox);
		root.setCenter(lblView);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Button ����");
		primaryStage.setWidth(500);
		primaryStage.setHeight(300);
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
