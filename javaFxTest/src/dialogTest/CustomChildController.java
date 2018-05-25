package dialogTest;
/*
	fxml 파일을 만들면 그에 대한 컨트롤러 파일을 함께 만들어주는것이 좋다.
	컨트롤러의 클래스명은 fxml의 명에 Controller를 추가해서 써주는것이 좋다.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomChildController {
	
	//부모창의 Stage객체가 저장될 변수
	private Stage parentStage;

    public void setParentStage(Stage parentStage) {
		this.parentStage = parentStage;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane childRoot;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    void btn1Clicked(ActionEvent event) {
    	//새로운 화면을 구성하여 Center 영역에 출력 시킨다.
    	VBox vbox = new VBox(10);
    	vbox.setAlignment(Pos.CENTER);
    	vbox.setPadding(new Insets(10));
    	
    	Button btnTest = new Button("화면구성");
    	TextArea txt = new TextArea();
    	
    	vbox.getChildren().addAll(btnTest, txt);
    	
    	childRoot.setCenter(vbox);
    }

    @FXML
    void btn2Clicked(ActionEvent event) {
    	//자식창 띄우기
    	Stage child2 = new Stage();
    	child2.initModality(Modality.WINDOW_MODAL);
    	child2.initOwner(parentStage);
    	
    	VBox vbox = new VBox(10);
    	vbox.setAlignment(Pos.CENTER);
    	vbox.setPadding(new Insets(10));
    	
    	Button btnTest = new Button("새창 버튼");
    	TextArea txt = new TextArea();
    	
    	vbox.getChildren().addAll(btnTest, txt);
    	
    	Scene sceneChild2 = new Scene(vbox, 200, 200);
    	child2.setScene(sceneChild2);
    	child2.setTitle("자식창의 자식창");
    	child2.show();
    	
    }

    @FXML
    void initialize() {
        assert childRoot != null : "fx:id=\"childRoot\" was not injected: check your FXML file 'CustomChild.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'CustomChild.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'CustomChild.fxml'.";

    }
}
