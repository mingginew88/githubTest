package student.main;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import student.service.IStudentService;
import student.service.StudentServiceImpl;
import student.vo.StudentVO;

public class StudentAddFormController {
	
	private ObservableList<StudentVO> stdList;
	
    public void setStdList(ObservableList<StudentVO> stdList) {
		this.stdList = stdList;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfKor;

    @FXML
    private TextField tfEng;

    @FXML
    private TextField tfMat;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML //취소버튼
    void btnCancelClick(ActionEvent event) {
    	//현재 창을 닫으려면 현재창의 Stage객체를 얻어야 한다.
    	//javaFX의 컨트롤 객체를 이용하여 Stage객체를 구할 수 있다.
    	Stage thisForm = (Stage) btnCancel.getScene().getWindow();
    	thisForm.close();
    }

    @FXML
    void btnSaveClick(ActionEvent event) {
    	String name = tfName.getText();
    	String strKor = tfKor.getText();
    	String strEng = tfEng.getText();
    	String strMat = tfMat.getText();
    	
    	if(name.isEmpty()) {
    		alert("입력오류", "이름을 입력하세요.");
    		tfName.requestFocus();
    		return;
    	}
    	
    	//각 과목의 점수는 숫자여여부검사
    	if(!Pattern.matches("^[0-9]{1,3}$", strKor)) {
    		alert("입력오류", "국어점수를 정확히 입력하세요.");
    		tfKor.requestFocus();
    		return;
    	}
    	if(!Pattern.matches("^[0-9]{1,3}$", strEng)) {
    		alert("입력오류", "영어점수를 정확히 입력하세요.");
    		tfEng.requestFocus();
    		return;
    	}
    	if(!Pattern.matches("^[0-9]{1,3}$", strMat)) {
    		alert("입력오류", "수학점수를 정확히 입력하세요.");
    		tfMat.requestFocus();
    		return;
    	}
    	
    	//입력된 데이터를 이용하여 StudentVO객체에 담아서 DB로 보낸다.
    	StudentVO stdVo =  new StudentVO(0, name, Integer.parseInt(strKor), Integer.parseInt(strEng), Integer.parseInt(strMat));
    	
    	int cnt = stdService.insertStudent(stdVo);
    	
    	if(cnt>0) { //DB에 insert가 성공
    		stdList.add(stdVo); 	//DB에 insert한 데이터를 테이블 뷰에도 추가한다.
    		info("insert성공", name + " 학생 성적 추가 완료!!");
    	} else {
    		alert("insert실패", name + " 학생 성적 추가 실패");
    	}
    	
    	tfName.clear();
    	tfKor.clear();
    	tfEng.clear();
    	tfMat.clear();
    	
    }
    
    
    private IStudentService stdService;
    

    @FXML
    void initialize() {
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert tfKor != null : "fx:id=\"tfKor\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert tfEng != null : "fx:id=\"tfEng\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert tfMat != null : "fx:id=\"tfMat\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        
        stdService = StudentServiceImpl.getInstance();

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






