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
	
	// Pie Chart에 나타낼 데이터가 저장될 변수
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

    
    //Chart를 구성하여 보여주는 메서드
    public void viewChart() {
    	stdPieChart.setTitle(stdVo.getStd_name() + "학생의 성적 분포");
    	stdPieChart.setData(FXCollections.observableArrayList(
    				new PieChart.Data("국어", stdVo.getStd_kor()),
    				new PieChart.Data("영어", stdVo.getStd_eng()),
    				new PieChart.Data("수학", stdVo.getStd_mat())
    			));
    }
    
    
    
    
    @FXML
    void initialize() {
        assert stdPieChart != null : "fx:id=\"stdPieChart\" was not injected: check your FXML file 'StudentPieChart.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'StudentPieChart.fxml'.";
        
        

    }
}
