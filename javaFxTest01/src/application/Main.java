package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/*
	�ڹ��� GUI : AWT ==> SWing ==> JavaFX
	
	Stage��ü ==> windowâ�� ��Ÿ���� ��ü
	Scene��ü ==> ���(windowâ�� ��ġ�Ǵ� ������� �����ϴ� ��ü)
	
	������� : main() ==> raunch()ȣ�� ==> ��ü�� ������()
			==> init()�޼��� ==> start()�޼��� ==>
			ȭ�鿡 â�� ������ ��밡 ����� �� ����
			==> stop() �޼���

*/
public class Main extends Application {
	// ������
	public Main() {
		System.out.println("������ �޼���...");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("init �޼��� ...");
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			System.out.println("start �޼��� ...");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("stop �޼��� ....");
	}
	
	
	public static void main(String[] args) {
		System.out.println("main �޼��� ....");
		launch(args);
	}
}
