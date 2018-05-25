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

    @FXML //��ҹ�ư
    void btnCancelClick(ActionEvent event) {
    	//���� â�� �������� ����â�� Stage��ü�� ���� �Ѵ�.
    	//javaFX�� ��Ʈ�� ��ü�� �̿��Ͽ� Stage��ü�� ���� �� �ִ�.
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
    		alert("�Է¿���", "�̸��� �Է��ϼ���.");
    		tfName.requestFocus();
    		return;
    	}
    	
    	//�� ������ ������ ���ڿ����ΰ˻�
    	if(!Pattern.matches("^[0-9]{1,3}$", strKor)) {
    		alert("�Է¿���", "���������� ��Ȯ�� �Է��ϼ���.");
    		tfKor.requestFocus();
    		return;
    	}
    	if(!Pattern.matches("^[0-9]{1,3}$", strEng)) {
    		alert("�Է¿���", "���������� ��Ȯ�� �Է��ϼ���.");
    		tfEng.requestFocus();
    		return;
    	}
    	if(!Pattern.matches("^[0-9]{1,3}$", strMat)) {
    		alert("�Է¿���", "���������� ��Ȯ�� �Է��ϼ���.");
    		tfMat.requestFocus();
    		return;
    	}
    	
    	//�Էµ� �����͸� �̿��Ͽ� StudentVO��ü�� ��Ƽ� DB�� ������.
    	StudentVO stdVo =  new StudentVO(0, name, Integer.parseInt(strKor), Integer.parseInt(strEng), Integer.parseInt(strMat));
    	
    	int cnt = stdService.insertStudent(stdVo);
    	
    	if(cnt>0) { //DB�� insert�� ����
    		stdList.add(stdVo); 	//DB�� insert�� �����͸� ���̺� �信�� �߰��Ѵ�.
    		info("insert����", name + " �л� ���� �߰� �Ϸ�!!");
    	} else {
    		alert("insert����", name + " �л� ���� �߰� ����");
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
    
    
    //���� ����ϴ� Alertâ �޼���
  	public void info(String header, String msg) {
  		Alert alertInfo = new Alert(AlertType.INFORMATION);
  		alertInfo.setTitle("����Ȯ��");
  		alertInfo.setHeaderText(header);
  		alertInfo.setContentText(msg);
  		alertInfo.showAndWait();
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






