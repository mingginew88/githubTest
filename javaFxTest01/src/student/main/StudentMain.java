package student.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentMain.fxml"));
		
		Parent root = loader.load();
		
		//Controller按眉 备窍扁
		StudentMainController stdMainController = loader.getController();
		stdMainController.setPrimaryStage(primaryStage);
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("切积 己利 包府");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
