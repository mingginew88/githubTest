package basic.controlTest;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AlertTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		// ������ ����ϴ� â
		Alert alertInfo = new Alert(AlertType.INFORMATION);
		
		alertInfo.setTitle("INFORMATION");
		// ���� ����
		alertInfo.setHeaderText("�������"); 
		// ����� �޽���
		alertInfo.setContentText("INFORMATION Alertâ �Դϴ�."); 
		
		alertInfo.showAndWait();
		
		//--------------------------------------------
		
		// �޽����� �����ְ� 'OK' �Ǵ� '���' �� �ϳ��� �����ϴ� â
		
		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
		alertConfirm.setTitle("CONFIRMATION");
		alertConfirm.setHeaderText("����???");
		alertConfirm.setContentText("�۾��� �����ұ��?");
		
		// Alertâ�� �����ְ� ������ ���� �о�´�.
		ButtonType  confirmResult = alertConfirm.showAndWait().get();
		
		if(confirmResult == ButtonType.OK) {
			System.out.println("OK ��ư ����");
		}else if(confirmResult==ButtonType.CANCEL) {
			System.out.println("��� ��ư ����");
		}else {
			System.out.println("...");
		}
		
		
		//--------------------------------------------
		Alert alertError = new Alert(AlertType.ERROR);
		alertError.setTitle("ERROR");
		alertError.setHeaderText("����â");
		alertError.setContentText("ERROR �޽����� ����մϴ�.");
		
		alertError.showAndWait();
		
		//--------------------------------------------
		Alert alertWarning = new Alert(AlertType.WARNING);
		alertWarning.setTitle("WARNING");
		alertWarning.setHeaderText("���â");
		alertWarning.setContentText("WARNING �޽����� ����մϴ�.");
		
		alertWarning.showAndWait();
		
		//-------------------------------------------
		
		// �ڹٽ�ũ��Ʈ�� promptâ�� ���� ���
		
		// �⺻���� ���� ����
		TextInputDialog prompt = new TextInputDialog("�⺻��");
		
		prompt.setTitle("�Է�â Title");
		prompt.setHeaderText("�̸��� �Է��ϼ���.");
		
		// â�� �����ְ�, ����ڰ� �Է��� �� �о����
		Optional<String> result = prompt.showAndWait();
		
		String strResult = "�� ����";
		
		// ���� �Է��� �� 'OK'��ư�� ��������...
		if(result.isPresent()) { 
			strResult = result.get();  // �Է°��� �о�� ������ ����
		}
		
		System.out.println("Prompt ��� : " + strResult);
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}













