package basic.fxmlTest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class FxControlExController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfName;

    @FXML
    private RadioButton rdSung1;

    @FXML
    private ToggleGroup tgSung;

    @FXML
    private RadioButton rdSung2;

    @FXML
    private CheckBox chkHb1;

    @FXML
    private CheckBox chkHb2;

    @FXML
    private CheckBox chkHb3;

    @FXML
    private CheckBox chkHb4;

    @FXML
    private CheckBox chkHb5;

    @FXML
    private CheckBox chkHb6;

    @FXML
    private CheckBox chkHb7;

    @FXML
    private CheckBox chkHb8;

    @FXML
    private Button btnView;

    @FXML
    private TextArea txtResult;

    @FXML
    void btnViewClicked(ActionEvent event) {
    	// 이름
    	String name = tfName.getText();
    	
    	if(name.isEmpty()) {
    		alert("입력오류", "이름을 입력하세요");
    		tfName.requestFocus();
    		return;
    	}
    	
    	// 성별
    	String sung = "";
    	if(rdSung1.isSelected()) {
    		sung = "남자";
    	}else {
    		sung = "여자";
    	}
    	
    	// 취미
    	String hob = "";
    	for(int i=0; i<cbHobbies.length; i++) {
    		if(cbHobbies[i].isSelected()) {
    			if(!"".equals(hob)) {
    				hob += ", ";
    			}
    			
    			
    			hob += cbHobbies[i].getText();
    		}
    	}
    	
    	txtResult.setText(name + "씨!!\n");
    	txtResult.appendText("당신은 " + sung + "이고,\n");
    	txtResult.appendText("취미는 " +
    			("".equals(hob) ? "없군요!!" : hob + "이군요!!")
    		);
    	
    	
    }

    private CheckBox[] cbHobbies;
    
    @FXML
    void initialize() {
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert rdSung1 != null : "fx:id=\"rdSung1\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert tgSung != null : "fx:id=\"tgSung\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert rdSung2 != null : "fx:id=\"rdSung2\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chkHb1 != null : "fx:id=\"chkHb1\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chkHb2 != null : "fx:id=\"chkHb2\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chkHb3 != null : "fx:id=\"chkHb3\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chkHb4 != null : "fx:id=\"chkHb4\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chkHb5 != null : "fx:id=\"chkHb5\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chkHb6 != null : "fx:id=\"chkHb6\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chkHb7 != null : "fx:id=\"chkHb7\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert chkHb8 != null : "fx:id=\"chkHb8\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert btnView != null : "fx:id=\"btnView\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'FxControlEx.fxml'.";
        // ----------------------------
        
        cbHobbies = new CheckBox[] {
        	chkHb1,chkHb2,chkHb3,chkHb4,chkHb5,chkHb6,chkHb7,chkHb8
        };
        

    }
    
    // 경고창
	public void alert(String header, String msg) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("경고");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}
    
    
    
}
