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
	
//����� scene builder  button, choicebox, combobox, borderpane
//��Ʈ���� �ϳ��ۿ� ���ִ´�. ���� ���� �ְ�ʹٸ� �����̳ʿ� ��Ʈ���� ��Ƽ� ��ġ�ϸ�ȴ�.
	

	@Override
	public void start(Stage primaryStage) {
		/*
		 AnchorPane ==> ��Ʈ�ѵ��� ��ġ�� ��ǥ�� �����Ͽ� ��ġ�Ѵ�.
		 */
		
		AnchorPane root = new AnchorPane();
		root.setPrefSize(300, 150);
		
		Label lblId = new Label("�� �� �� : ");	//�̸� ���ö� ������ ������ ����� ���̻��
		//��Ʈ���� ���� ��ǥ ����
		lblId.setLayoutX(62);	//x��ǥ
		lblId.setLayoutY(22);	//y��ǥ
		
		Label lblPass = new Label("�н����� : ");	
		lblPass.setLayoutX(62);
		lblPass.setLayoutY(68);
		
		TextField txtfldId = new TextField();
		txtfldId.setLayoutX(132);
		txtfldId.setLayoutY(22);
		
		PasswordField fldPass = new PasswordField();
		fldPass.setLayoutX(132);
		fldPass.setLayoutY(68);
		
		Button btnLogin = new Button("�α���");
		btnLogin.setLayoutX(86);
		btnLogin.setLayoutY(106);
		
		Button btnCancel = new Button("�� ��");
		btnCancel.setLayoutX(160);
		btnCancel.setLayoutY(106);
		
		root.getChildren().addAll(lblId, lblPass, txtfldId, fldPass, btnLogin, btnCancel);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("AnchorPane����");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
