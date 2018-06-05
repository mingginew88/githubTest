package board.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardMain extends Application {
	

	@Override
	public void start(Stage primaryStage) {
		 
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardList.fxml"));		 
			Parent root = loader.load();
			
			BoardListController boardListController = loader.getController();
			boardListController.setPrimaryStage(primaryStage);
			
			Scene scene = new Scene(root, 600, 500);
			primaryStage.setScene(scene);
			primaryStage.setTitle("DDIT 자유게시판");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
