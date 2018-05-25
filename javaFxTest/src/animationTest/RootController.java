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
        
        //�α��� ��ư Ŭ�� �̺�Ʈ
        btnLogin.setOnAction(e-> {
        	try {
				Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
				
				//��Ʈ�� ��ü�� �̿��� ��Ʈ �����̳� ��ü ���ϱ�
				StackPane root = (StackPane) btnLogin.getScene().getRoot();
				root.getChildren().add(login);
				
				
				// �̵� �ִϸ��̼�
				login.setTranslateX(350);  	// ���۰� (�ִϸ��̼��� �����ϴ� ��ġ)
				
				// �ִϸ��̼� ȿ���� �ʿ��� ��ü
				// TimeLine, KeyValue, KeyFrame
				
				// KeyFrame�� ������ ������ �ִϸ��̼��� �����ϴ� ��ü
				Timeline tiemline = new Timeline();
				
				// Ÿ�ټӼ�(����� �Ӽ�)�� ���ᰪ�� �����ϴ� ��ü
				// ����) new KeyValue(Ÿ�ټӼ�, ���ᰪ)
				KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
				
				// �ִϸ��̼��� ����ð��� KeyValue�� �����ϴ� ��ü
				// ����1) new KeyFrame(���ӽð�, KeyValue��)
				// ����2) new KeyFrame(���ӽð�, �ִϸ��̼� ���� �� ó���� �̺�Ʈ, KeyValue��)
				KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);  	//(time, values)
				
				//TimeLine�� KeyFrame�� �߰�
				tiemline.getKeyFrames().add(keyFrame);
				
				//�ִϸ��̼� ����
				tiemline.play();
				
			} catch (IOException e2) {
				e2.printStackTrace();
			}
        });

    }
}




