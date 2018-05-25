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
		
		// ������ ����
		
		// ��������
		XYChart.Series<String, Number> serKor = new XYChart.Series<>();
		serKor.setName("����");
		
		// ������ ������ŭ �ݺ�ó��
		for (int i = 0; i < stdList.size(); i++) {
			serKor.getData().add(
				new Data<>(
					stdList.get(i).getStd_name(), stdList.get(i).getStd_kor()
				)
			);
		}
		barChart.getData().add(serKor);		
		//------------------------------------------------------------------------
		
		// ��������
		XYChart.Series<String, Number> serMat = new XYChart.Series<>();
		serMat.setName("����");
		
		for (int i = 0; i < stdList.size(); i++) {
			serMat.getData().add(
				new Data<>(
					stdList.get(i).getStd_name(), stdList.get(i).getStd_mat()
				)
			);
		}		
		barChart.getData().add(serMat);
		//------------------------------------------------------------------------
		
		// ��������
		XYChart.Series<String, Number> serEng = new XYChart.Series<>();
		serEng.setName("����");
		
		for (StudentVO stdVo : stdList) {
			serEng.getData().add(
					new Data<String, Number>(
							stdVo.getStd_name(), stdVo.getStd_eng()
					)
			);
		}
		barChart.getData().add(serEng);
		//------------------------------------------------------------------------

		Button btnClose = new Button("�� ��");
		btnClose.setOnAction(e->{
			Stage thisForm = (Stage) btnClose.getScene().getWindow();
			thisForm.close();
		});
		
		VBox vbox = new VBox(15);
		vbox.setPadding(new Insets(15));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(barChart, btnClose);
		
		
		// ���������� ������� �����̳ʸ� ���簴ü�� �߰��Ѵ�.
		this.getChildren().add(vbox);
		
	}
	
	
	

}
