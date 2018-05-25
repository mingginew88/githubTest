package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
/*
	자바의 GUI : AWT ==> SWing ==> JavaFX
	
	Stage객체 ==> window창을 나타내는 객체
	Scene객체 ==> 장면(window창에 배치되는 내용들을 구성하는 객체)
	
	실행순서 : main() ==> launch()호출 ==> 객체의 생성자() 호출 ==> init()메서드 호출 ==> start()메서드 실행 ==> 화면에 창 나오고 사용자가 사용한 후 종료
	 		==> stop()메서드 호출
 */

public class Main extends Application {
	//생성자
	public Main() {
		System.out.println("생성자 메서드");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("init메서드");
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			System.out.println("start 메서드");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("stop메서드");
	}
	
	
	public static void main(String[] args) {
		System.out.println("메인메서드");
		launch(args);
	}
}
