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
		root.setHgap(10);  // ���� ����
		root.setVgap(10);  // ���� ����
		root.setPadding(new Insets(10));
		/*
		Button btn1 = new Button("1����ư");
		Button btn2 = new Button("2����ư");
		Button btn3 = new Button("3����ư");
		Button btn4 = new Button("4����ư");
		Button btn5 = new Button("5����ư");
		Button btn6 = new Button("6����ư");
		Button btn7 = new Button("7����ư");
		Button btn8 = new Button("8����ư");
		
		root.getChildren().addAll(btn1, btn2, btn3, 
				btn4, btn5, btn6, btn7, btn8);
		*/
		for(int i=1; i<=8; i++) {
			root.getChildren().add(new Button(i + "����ư"));
		}
		
		// ��ư�� ĸ���� ù��°, �ι�°, ����°, �׹�°,
		//        �ټ���°, ������° �϶� ??
		
		String[] strArr = {"ù��°", "�ι�°", "����°", "�׹�°",
				"�ټ���°", "������°"};
		for(int i=0; i<strArr.length; i++) {
			root.getChildren().add(new Button( strArr[i]) );
		}
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FlowPane ����");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}













