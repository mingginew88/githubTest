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
		HBox hbox1 = new HBox(10); // spacing�� ���� ���1
		//hbox1.setSpacing(10);  // spacing�� ���� ���2
		
		// padding(���ʿ���)�� ����  
		
		// ��, ��, ��, �� 
		hbox1.setPadding(new Insets(50, 10, 50, 10));
		//hbox1.setPadding(new Insets(30)); // 4������ ����
		
		Button btn1 = new Button("ù��°");
		btn1.setPrefSize(100, 100);
		
		Button btn2 = new Button("�ι�°");
		btn2.setPrefSize(100, 100);
		
		//-----------------------------------
		
		HBox hbox2 = new HBox();
		Button btn3 = new Button("����°");
		btn3.setPrefSize(100, 100);
		
		Button btn4 = new Button("�׹�°");
		btn4.setPrefSize(100, 100);
		
		
		// Margin�� �����ϱ�
		
		// Margin�� �����̳ʿ� �߰��Ǵ� ��Ʈ���� 
		// �������� �����Ѵ�.
		// �����̳� ��ü�� static�޼����� setMargin()��
		// ����Ѵ�.
		
		// ��) HBox�� �߰��� btn3�� margin�� �����ϱ�
		HBox.setMargin(btn3, new Insets(10, 10, 50, 50));
		
		
		hbox1.getChildren().addAll(btn1, btn2);
		hbox2.getChildren().addAll(btn3, btn4);
		
		hbox1.setStyle("-fx-background-color:yellow;");
		hbox2.setStyle("-fx-background-color:pink;");
		
		
		VBox vbox = new VBox();
		
		vbox.getChildren().addAll(hbox1, hbox2);
		
		Scene scene = new Scene(vbox);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Padding�� Margin");
		primaryStage.show();
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}














