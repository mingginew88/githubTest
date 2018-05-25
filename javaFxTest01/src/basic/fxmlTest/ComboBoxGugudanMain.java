package basic.fxmlTest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComboBoxGugudanMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = FXMLLoader.load(
				getClass().getResource("ComboBoxGugudan.fxml" )
			);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("콤보박스 구구단");
			primaryStage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
