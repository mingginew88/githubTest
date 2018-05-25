package animationTest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    void initialize() {
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Root.fxml'.";
        
        //로그인 버튼 클릭 이벤트
        btnLogin.setOnAction(e-> {
        	try {
				Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
				
				//컨트롤 객체를 이용한 루트 컨테이너 객체 구하기
				StackPane root = (StackPane) btnLogin.getScene().getRoot();
				root.getChildren().add(login);
				
				
				// 이동 애니메이션
				login.setTranslateX(350);  	// 시작값 (애니메이션이 시작하는 위치)
				
				// 애니메이션 효과에 필요한 객체
				// TimeLine, KeyValue, KeyFrame
				
				// KeyFrame에 설정된 내용대로 애니메이션을 진행하는 객체
				Timeline tiemline = new Timeline();
				
				// 타겟속성(변경될 속성)과 종료값을 설정하는 객체
				// 형식) new KeyValue(타겟속성, 종료값)
				KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
				
				// 애니메이션의 진행시간과 KeyValue를 설정하는 객체
				// 형식1) new KeyFrame(지속시간, KeyValue값)
				// 형식2) new KeyFrame(지속시간, 애니메이션 종료 후 처리할 이벤트, KeyValue값)
				KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);  	//(time, values)
				
				//TimeLine에 KeyFrame을 추가
				tiemline.getKeyFrames().add(keyFrame);
				
				//애니메이션 실행
				tiemline.play();
				
			} catch (IOException e2) {
				e2.printStackTrace();
			}
        });

    }
}




