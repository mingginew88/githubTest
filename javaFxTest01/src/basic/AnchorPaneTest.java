package basic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
	/*
		AnchorPane ==> 컨트롤들이 배치될 좌표를 지정하여
					   배치한다.
	*/
		AnchorPane root = new AnchorPane();
		root.setPrefSize(300, 150);
		
		Label lblId = new Label("아 이 디 : ");
		// 컨트롤이 놓일 좌표 지정
		lblId.setLayoutX(62);  // X좌표
		lblId.setLayoutY(22);  // Y좌표
		
		Label lblPass = new Label("패스워드 : ");
		lblPass.setLayoutX(62);
		lblPass.setLayoutY(68);
		
		TextField txtfldId = new TextField();
		txtfldId.setLayoutX(132);
		txtfldId.setLayoutY(22);
		
		PasswordField fldPass = new PasswordField();
		fldPass.setLayoutX(132);
		fldPass.setLayoutY(68);
		
		Button btnLogin = new Button("로그인");
		btnLogin.setLayoutX(86);
		btnLogin.setLayoutY(106);
		
		Button btnCancel = new Button("취 소");
		btnCancel.setLayoutX(160);
		btnCancel.setLayoutY(106);
		
		// AnchorPane에 컨트롤들 추가
		root.getChildren().addAll(lblId, lblPass, 
				txtfldId, fldPass, btnLogin, btnCancel);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("AnchorPane 연습");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
