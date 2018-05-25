package basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StageSceneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();	//VBox���̾ƿ�
		root.setPrefWidth(650);	//VBox�� �ʺ�
		root.setPrefHeight(150);//VBox�� ����
		
		root.setSpacing(20);	//��Ʈ�ѵ鰣�� ����
		root.setAlignment(Pos.CENTER);
		
		Label label = new Label();	//Label��ü ����
		label.setText("�ȳ��ϼ���. JavaFX�Դϴ�.");
		label.setFont(new Font(50));		//���� ũ�� ����
		
		Button button = new Button("Ȯ��");	//��ư ��ü ����
		
		//��ư�� ���������� �̺�Ʈ ó���ϱ�
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {				
				// �̰��� ��ư�� ������ �� ó���ؾ� �� ������ ����Ѵ�.
				Platform.exit(); //���α׷� ����		//�ǵ����̸� �̰��� ����ϴ°��� ����.
				
				//System.exit(0); //stop()�޼��带 ȣ������ �ʴ´�.
			}
		});
		
		//VBox�� ��Ʈ�ѵ��� ��ġ(�߰�)�Ѵ�.
//		root.getChildren().add(label);
//		root.getChildren().add(button);
		
		//�������� ��Ʈ�ѵ��� �Ѳ����� �߰��ϱ�
		root.getChildren().addAll(label, button);
		
		//VBox�� ��Ʈ �����̳ʷ� �ϴ� Scene��ü ����
		Scene scene = new Scene(root);
		
		//â ����
		primaryStage.setTitle("Stage�� Scene����");
		
		//Stage�� Scene �߰��ϱ�
		primaryStage.setScene(scene);
		
		//Stage��ü ���̱�
		primaryStage.show();		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
