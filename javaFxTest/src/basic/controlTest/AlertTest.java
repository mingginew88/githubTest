package basic.controlTest;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class AlertTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		//정보를 출력하는 창
		Alert alertInfo = new Alert(AlertType.INFORMATION);
		
		alertInfo.setTitle("INFOMATION");
		
		alertInfo.setHeaderText("본문 제목");		//분문제목
		alertInfo.setContentText("INFORMATION Alert창 입니다."); //출력할메시지
		
		//alertInfo.showAndWait();
		
		//-------------------------------------------------------------------		
		//메시지를 보여주고 OK또는 취소중 하나를 선택하는 창
//		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
//		
//		alertConfirm.setTitle("CONFIRMATION");
//		alertConfirm.setHeaderText("프로그램 오류 #c8d518ad[c9395]");
//		alertConfirm.setContentText("작업을 종료할까요?");
//		
//		//alert 창을 보여주고 선택한 값을 일어온다. 
//		ButtonType confirmResult = alertConfirm.showAndWait().get();
//		
//		if(confirmResult == ButtonType.OK) {
//			System.out.println("OK 버튼 선택");
//		}else if(confirmResult == ButtonType.CANCEL) {
//			System.out.println("취소 버튼 선택");
//		} else {
//			System.out.println("...");
//		}
		
		//-------------------------------------------------------------------
//		Alert alertError = new Alert(AlertType.ERROR);
//		alertError.setTitle("ERROR");
//		alertError.setHeaderText("오류창");
//		alertError.setContentText("ERROR 메시지를 출력합니다.");
//		
//		alertError.showAndWait();
		
		//-------------------------------------------------------------------
//		Alert alertWarning = new Alert(AlertType.WARNING);
//		alertWarning.setTitle("WARNING");
//		alertWarning.setHeaderText("경고창");
//		alertWarning.setContentText("WARNING 메시지를 출력합니다.");
//		
//		alertWarning.showAndWait();
		
		//-------------------------------------------------------------------		
		//자바스크립트의 prompt창과 같은 기능
		TextInputDialog prompt = new TextInputDialog("기본값");
		
		prompt.setTitle("입력창 Title");
		prompt.setHeaderText("이름을 입력하세요.");
		
		//창을 보여주고, 사용자가 입력한 값 읽어오기
		Optional<String> result = prompt.showAndWait();
		String strResult = "값 없음";
		
		//값을 입력한 후 'OK' 버튼을 눌렀으면...
		if(result.isPresent()) {	//입력값이 있으면...
			strResult = result.get();	//입력값을 읽어와 변수에 저장
		}
		
		System.out.println("Prompt 결과 : " + strResult);		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
