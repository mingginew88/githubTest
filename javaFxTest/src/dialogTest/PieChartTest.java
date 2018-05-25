package dialogTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
						new PieChart.Data("���", 100),
						new PieChart.Data("��", 200),
						new PieChart.Data("����", 150),
						new PieChart.Data("����", 1000),
						new PieChart.Data("����", 50),
						new PieChart.Data("������", 170)
				);
		
		PieChart pChart = new PieChart(pieChartData);
		
		pChart.setTitle("���Ϻ� �ܰ�");
		pChart.setLabelLineLength(10); 		// ������ ���� ��������� ��Ʈ ũ��� �۾�����.
		pChart.setLegendSide(Side.BOTTOM); 	// ������ ��ġ�� �������ش�.
		
		Scene scene = new Scene(pChart, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pie��Ʈ ����");
		primaryStage.show();
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
