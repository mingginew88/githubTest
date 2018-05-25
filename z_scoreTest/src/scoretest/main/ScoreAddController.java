package scoretest.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scoretest.service.IScoreDataService;
import scoretest.service.ScoreDataServiceImpl;
import scoretest.vo.ScoreDataVO;

public class ScoreAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane addRoot;

    @FXML
    private Label lbl_name;

    @FXML
    private TextField tf_name;

    @FXML
    private Label lbl_kor;

    @FXML
    private TextField tf_kor;

    @FXML
    private Label lbl_eng;

    @FXML
    private TextField tf_eng;

    @FXML
    private Label lbl_math;

    @FXML
    private TextField tf_math;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    void cancelData(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        
        //TODO : 추가 이후 취소버튼 눌렀을시 테이블에 데이터 갱신이 안된다.
        
    }

    @FXML
    void saveData(ActionEvent event) {
    	ScoreDataVO scoreVo = new ScoreDataVO();  	
    	
		if(tf_name.getText().isEmpty()) {
			alert("입력오류","학생이름을 입력하세요.");				
			tf_name.requestFocus();
			return;
		}
		
		if(tf_kor.getText().isEmpty()||!tf_kor.getText().matches("[0-9]{1,3}")) {
			alert("입력오류","국어점수를 입력하세요.");
			tf_kor.requestFocus();
			return;
		}			
		
		if(tf_eng.getText().isEmpty()||!tf_eng.getText().matches("[0-9]{1,3}")) {
			alert("입력오류","영어점수를 입력하세요.");
			tf_eng.requestFocus();
			return;
		}
		
		if(tf_math.getText().isEmpty() ||!tf_math.getText().matches("[0-9]{1,3}")) {
			alert("입력오류","수학점수를 입력하세요.");
			tf_math.requestFocus();
			return;
		}
        
        scoreVo.setStd_name(tf_name.getText());
        scoreVo.setStd_kor(Integer.parseInt(tf_kor.getText()));
        scoreVo.setStd_eng(Integer.parseInt(tf_eng.getText()));
        scoreVo.setStd_mat(Integer.parseInt(tf_math.getText()));
        
    	String name = tf_name.getText();
    	
    	int cnt = scoreData.addScore(scoreVo);   	
		if(cnt==1) {
			info("작업성공", name + "씨 정보 추가 성공!!");				
		} else {
			info("작업실패", "회원정보 추가에 실패하였습니다.");	
		}
		
		tf_name.clear();
		tf_kor.clear();
		tf_eng.clear();
		tf_math.clear();
    }
    
    
    private IScoreDataService scoreData;
    
    ObservableList<ScoreDataVO> scoreList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        assert addRoot != null : "fx:id=\"addRoot\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert lbl_name != null : "fx:id=\"lbl_name\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert lbl_kor != null : "fx:id=\"lbl_kor\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert tf_kor != null : "fx:id=\"tf_kor\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert lbl_eng != null : "fx:id=\"lbl_eng\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert tf_eng != null : "fx:id=\"tf_eng\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert lbl_math != null : "fx:id=\"lbl_math\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert tf_math != null : "fx:id=\"tf_math\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'ScoreAdd.fxml'.";
        
        scoreData = ScoreDataServiceImpl.getInstance();
        
        tf_name.requestFocus();
        
    }
    
    //정보 출력하는 Alert창 메서드
  	public void info(String header, String msg) {
  		Alert alertInfo = new Alert(AlertType.INFORMATION);
  		alertInfo.setTitle("정보확인");
  		alertInfo.setHeaderText(header);
  		alertInfo.setContentText(msg);
  		alertInfo.showAndWait();
  	}
    
    //경고창
  	public void alert(String header, String msg) {
  		Alert alert = new Alert(AlertType.WARNING);
  		alert.setTitle("경고");
  		alert.setHeaderText(header);
  		alert.setContentText(msg);
  		alert.showAndWait();
  	}
    
    
    
    
    
}
