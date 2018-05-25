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
						new PieChart.Data("사과", 100),
						new PieChart.Data("배", 200),
						new PieChart.Data("포도", 150),
						new PieChart.Data("수박", 1000),
						new PieChart.Data("딸기", 50),
						new PieChart.Data("복숭아", 170)
				);
		
		PieChart pChart = new PieChart(pieChartData);
		
		pChart.setTitle("과일별 단가");
		pChart.setLabelLineLength(10); 		// 선길이 선이 길어질수록 차트 크기는 작아진다.
		pChart.setLegendSide(Side.BOTTOM); 	// 범례의 위치를 지정해준다.
		
		Scene scene = new Scene(pChart, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pie차트 연습");
		primaryStage.show();
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
