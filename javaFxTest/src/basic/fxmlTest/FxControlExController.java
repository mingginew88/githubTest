package basic.fxmlTest;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/*
������ 
View - show sample controller skeleton ������  full üũ �ϰ�
�����ؼ� �ڹ� ��Ʈ�ѷ� Ŭ������ �ٿ��ֱ�
������ ���� �� fxml������ �ѹ� ������� ������Ʈ �ȴ�.

-----------------------
������ �����ϴ� ��Ʈ�ѷ���  ��Ʈ�ѷ� Ŭ���� �����ϴ°� ���������
*/


public class FxControlExController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private HBox hbox_name;

    @FXML
    private Label lbl_name;

    @FXML
    private TextField txtField;

    @FXML
    private HBox hbox_gender;

    @FXML
    private Label lbl_gender;

    @FXML
    private RadioButton Gen_Man;

    @FXML
    private ToggleGroup gen;

    @FXML
    private RadioButton Gen_Woman;

    @FXML
    private HBox hbox_hobby;

    @FXML
    private Label lbl_hobby;

    @FXML
    private HBox chk_hobbies;

    @FXML
    private CheckBox chk_trip;

    @FXML
    private CheckBox chk_climbing;

    @FXML
    private CheckBox chk_readbook;

    @FXML
    private CheckBox chk_go;

    @FXML
    private CheckBox chk_chess;

    @FXML
    private CheckBox chk_game;

    @FXML
    private CheckBox chk_tennis;

    @FXML
    private CheckBox chk_bedminton;

    @FXML
    private Button btn;

    @FXML
    private TextArea txtArea;

    @FXML
    void btnClicked(ActionEvent event) {    	
    	txtArea.setText("�Է»���\n");
		if(txtField.getText().equals("") || txtField.getText()==null) {
			txtArea.appendText("�̸��� �Է����� �ʾҽ��ϴ�.\n");
		}else {
			txtArea.appendText("�̸��� " + txtField.getText() +"�Դϴ�.\n");
		}
		if(Gen_Man.isSelected()) {
			txtArea.appendText("������ " + Gen_Man.getText() + "�̰� \n");			
		} else if(Gen_Woman.isSelected()) {
			txtArea.appendText("������ " + Gen_Woman.getText() + "�̰� \n");
		} else {
			txtArea.appendText("������ Ŭ������ �ʾҽ��ϴ�. \n");
		}
		String select_hobby = "";
		for (int j = 0; j < cbHobbies.length; j++) {
			if(cbHobbies[j].isSelected()) {
				select_hobby += cbHobbies[j] + ",";			
			}
		}
		select_hobby = select_hobby.substring(0, select_hobby.length()-1);
		if(select_hobby.equals("")) {
			txtArea.appendText("��̴� ������");
		} else {
			txtArea.appendText("��̴� " + select_hobby + "�Դϴ�.");
		}    	

    }
    
    private CheckBox[] cbHobbies;
    
    @FXML
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert hbox_name != null : "fx:id=\"hbox_name\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert lbl_name != null : "fx:id=\"lbl_name\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert hbox_gender != null : "fx:id=\"hbox_gender\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert lbl_gender != null : "fx:id=\"lbl_gender\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert Gen_Man != null : "fx:id=\"Gen_Man\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert gen != null : "fx:id=\"gen\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert Gen_Woman != null : "fx:id=\"Gen_Woman\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert hbox_hobby != null : "fx:id=\"hbox_hobby\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert lbl_hobby != null : "fx:id=\"lbl_hobby\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_hobbies != null : "fx:id=\"chk_hobbies\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_trip != null : "fx:id=\"chk_trip\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_climbing != null : "fx:id=\"chk_climbing\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_readbook != null : "fx:id=\"chk_readbook\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_go != null : "fx:id=\"chk_go\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_chess != null : "fx:id=\"chk_chess\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_game != null : "fx:id=\"chk_game\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_tennis != null : "fx:id=\"chk_tennis\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chk_bedminton != null : "fx:id=\"chk_bedminton\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        
        cbHobbies = new CheckBox[] {
        		chk_trip, chk_climbing, chk_readbook, chk_go, chk_chess, chk_game, chk_tennis, chk_bedminton
        };
    }
    
    //���â
  	public void alert(String header, String msg) {
  		Alert alert = new Alert(AlertType.WARNING);
  		alert.setTitle("���");
  		alert.setHeaderText(header);
  		alert.setContentText(msg);
  		alert.showAndWait();
  	}
    
    
    
}
