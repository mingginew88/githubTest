package dialogTest;
/*
	fxml ������ ����� �׿� ���� ��Ʈ�ѷ� ������ �Բ� ������ִ°��� ����.
	��Ʈ�ѷ��� Ŭ�������� fxml�� �� Controller�� �߰��ؼ� ���ִ°��� ����.
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
	
	//�θ�â�� Stage��ü�� ����� ����
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
    	//���ο� ȭ���� �����Ͽ� Center ������ ��� ��Ų��.
    	VBox vbox = new VBox(10);
    	vbox.setAlignment(Pos.CENTER);
    	vbox.setPadding(new Insets(10));
    	
    	Button btnTest = new Button("ȭ�鱸��");
    	TextArea txt = new TextArea();
    	
    	vbox.getChildren().addAll(btnTest, txt);
    	
    	childRoot.setCenter(vbox);
    }

    @FXML
    void btn2Clicked(ActionEvent event) {
    	//�ڽ�â ����
    	Stage child2 = new Stage();
    	child2.initModality(Modality.WINDOW_MODAL);
    	child2.initOwner(parentStage);
    	
    	VBox vbox = new VBox(10);
    	vbox.setAlignment(Pos.CENTER);
    	vbox.setPadding(new Insets(10));
    	
    	Button btnTest = new Button("��â ��ư");
    	TextArea txt = new TextArea();
    	
    	vbox.getChildren().addAll(btnTest, txt);
    	
    	Scene sceneChild2 = new Scene(vbox, 200, 200);
    	child2.setScene(sceneChild2);
    	child2.setTitle("�ڽ�â�� �ڽ�â");
    	child2.show();
    	
    }

    @FXML
    void initialize() {
        assert childRoot != null : "fx:id=\"childRoot\" was not injected: check your FXML file 'CustomChild.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'CustomChild.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'CustomChild.fxml'.";

    }
}
