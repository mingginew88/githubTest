package student.main;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import student.vo.StudentVO;

public class BarchartForm extends Pane{
	private ObservableList<StudentVO> stdList;

	public BarchartForm(ObservableList<StudentVO> stdList) {
		super();
		this.stdList = stdList;
		
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		
		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		
		// 데이터 설정
		
		// 국어점수
		XYChart.Series<String, Number> serKor = new XYChart.Series<>();
		serKor.setName("국어");
		
		// 데이터 개수만큼 반복처리
		for (int i = 0; i < stdList.size(); i++) {
			serKor.getData().add(
				new Data<>(
					stdList.get(i).getStd_name(), stdList.get(i).getStd_kor()
				)
			);
		}
		barChart.getData().add(serKor);		
		//------------------------------------------------------------------------
		
		// 수학점수
		XYChart.Series<String, Number> serMat = new XYChart.Series<>();
		serMat.setName("수학");
		
		for (int i = 0; i < stdList.size(); i++) {
			serMat.getData().add(
				new Data<>(
					stdList.get(i).getStd_name(), stdList.get(i).getStd_mat()
				)
			);
		}		
		barChart.getData().add(serMat);
		//------------------------------------------------------------------------
		
		// 영어점수
		XYChart.Series<String, Number> serEng = new XYChart.Series<>();
		serEng.setName("영어");
		
		for (StudentVO stdVo : stdList) {
			serEng.getData().add(
					new Data<String, Number>(
							stdVo.getStd_name(), stdVo.getStd_eng()
					)
			);
		}
		barChart.getData().add(serEng);
		//------------------------------------------------------------------------

		Button btnClose = new Button("닫 기");
		btnClose.setOnAction(e->{
			Stage thisForm = (Stage) btnClose.getScene().getWindow();
			thisForm.close();
		});
		
		VBox vbox = new VBox(15);
		vbox.setPadding(new Insets(15));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(barChart, btnClose);
		
		
		// 최종적으로 만들어진 컨테이너를 현재객체에 추가한다.
		this.getChildren().add(vbox);
		
	}
	
	
	

}
