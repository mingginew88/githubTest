package student.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import student.vo.StudentVO;

public class StudentPieChartController {
	
	// Pie Chart�� ��Ÿ�� �����Ͱ� ����� ����
	private StudentVO stdVo;

    public void setStdVo(StudentVO stdVo) {
		this.stdVo = stdVo;
	}

    
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart stdPieChart;

    @FXML
    private Button btnClose;

    @FXML
    void btnCloseClick(ActionEvent event) {
    	Stage thisForm = (Stage) btnClose.getScene().getWindow();
    	thisForm.close();
    }

    
    //Chart�� �����Ͽ� �����ִ� �޼���
    public void viewChart() {
    	stdPieChart.setTitle(stdVo.getStd_name() + "�л��� ���� ����");
    	stdPieChart.setData(FXCollections.observableArrayList(
    				new PieChart.Data("����", stdVo.getStd_kor()),
    				new PieChart.Data("����", stdVo.getStd_eng()),
    				new PieChart.Data("����", stdVo.getStd_mat())
    			));
    }
    
    
    
    
    @FXML
    void initialize() {
        assert stdPieChart != null : "fx:id=\"stdPieChart\" was not injected: check your FXML file 'StudentPieChart.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'StudentPieChart.fxml'.";
        
        

    }
}
