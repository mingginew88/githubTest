package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		root.setPrefSize(300, 200);
		root.setPadding(new Insets(10));
		root.setHgap(10);
		root.setVgap(10);
		
		Label lblId = new Label("�� �� �� :");
		Label lblPass = new Label("�н����� :");
		
		TextField tfId = new TextField();
		tfId.setStyle("-fx-background-color:green; -fx-text-fill:red; ");
		
		PasswordField pfPass = new PasswordField();
		
		Button btnLogin = new Button("�α���");
		Button btnCancel = new Button("�� ��");
		
		
		root.setStyle("-fx-background-color:yellow;");
		// GridPane�� ��Ʈ�� ��ġ�ϱ� ==> add()�޼��� �̿�
		// ����) add(�߰�����Ʈ��, ĭ��ȣ, 
		//						���ȣ, colspan, rowspan)
		root.add(lblId, 1, 1, 2, 1);
		root.add(lblPass, 1, 2, 2, 1);
		root.add(tfId, 3, 1, 3, 1);
		root.add(pfPass, 3, 2, 3, 1);
		
		root.add(btnLogin, 3, 4);
		root.add(btnCancel, 5, 4);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("GridPane ����");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}













