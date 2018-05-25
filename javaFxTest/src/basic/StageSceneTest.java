package basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StageSceneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();	//VBox레이아웃
		root.setPrefWidth(650);	//VBox의 너비
		root.setPrefHeight(150);//VBox의 높이
		
		root.setSpacing(20);	//컨트롤들간의 간격
		root.setAlignment(Pos.CENTER);
		
		Label label = new Label();	//Label객체 생성
		label.setText("안녕하세요. JavaFX입니다.");
		label.setFont(new Font(50));		//글자 크기 설정
		
		Button button = new Button("확인");	//버튼 객체 생성
		
		//버튼을 눌렀을때의 이벤트 처리하기
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {				
				// 이곳에 버튼을 눌렀을 때 처리해야 할 내용을 기술한다.
				Platform.exit(); //프로그램 종료		//되도록이면 이것을 사용하는것이 좋다.
				
				//System.exit(0); //stop()메서드를 호출하지 않는다.
			}
		});
		
		//VBox에 컨트롤들을 배치(추가)한다.
//		root.getChildren().add(label);
//		root.getChildren().add(button);
		
		//여러개의 컨트롤들을 한꺼번에 추가하기
		root.getChildren().addAll(label, button);
		
		//VBox를 루트 컨테이너로 하는 Scene객체 생성
		Scene scene = new Scene(root);
		
		//창 제목
		primaryStage.setTitle("Stage와 Scene연습");
		
		//Stage에 Scene 추가하기
		primaryStage.setScene(scene);
		
		//Stage객체 보이기
		primaryStage.show();		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
