package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Root extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
		
		Parent root = loader.load();
		
		Scene sc = new Scene(root);
		
		primaryStage.setTitle("Root���� ����");
		primaryStage.setScene(sc);
		primaryStage.show();
		
	}

}
