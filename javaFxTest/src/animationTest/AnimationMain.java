package animationTest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnimationMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		
		Scene scene = new Scene(root, 350, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ȭ�� ��ȯ �ִϸ��̼� ����");
		primaryStage.setResizable(false); // âũ�� ����  --ȭ������� ���� ��Ű�� �޼��� 
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
