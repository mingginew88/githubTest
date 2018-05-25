package basic.fxmlTest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/*
������ 
View - show sample controller skeleton ������  full üũ �ϰ�
�����ؼ� �ڹ� ��Ʈ�ѷ� Ŭ������ �ٿ��ֱ�
������ ���� �� fxml������ �ѹ� ������� ������Ʈ �ȴ�.

-----------------------
������ �����ϴ� ��Ʈ�ѷ���  ��Ʈ�ѷ� Ŭ���� �����ϴ°� ���������
*/

public class FxControlExMain extends Application {

	@Override
	public void start(Stage primaryStage) {		
		
		try {
			VBox root = FXMLLoader.load(getClass().getResource("FxControlEx.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("����");
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
