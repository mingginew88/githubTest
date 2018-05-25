package basic;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlLayout extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// fxml������ �о�� ���� Stage�� �����ϱ�
		
		// Fxml���� �о�� �ؼ��� �� ��ü�� ����� ��ȯ�Ѵ�.
		/*
		// ���1
		Parent root = FXMLLoader.load(
				getClass().getResource("FxmlLayout.fxml")
			);
		*/
		
		// ���2
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("FxmlLayout.fxml")
			);
		Parent root = loader.load();
		
		
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("FXML������ �̿��� ���̾ƿ� ����");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
