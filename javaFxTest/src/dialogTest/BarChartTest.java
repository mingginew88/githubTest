package dialogTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		CategoryAxis xAxis = new CategoryAxis(); //x축 역할
		NumberAxis   yAxis = new NumberAxis();   //y축 역할
		
		BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		
		bc.setTitle("막대그래프"); 	// 차트제목
		xAxis.setLabel("나라");
		yAxis.setLabel("금액");
		
		//차트에 출력할 데이터 셋팅하기
		XYChart.Series<String, Number> ser1 = new XYChart.Series<String, Number>();
		ser1.setName("2016년");
		ser1.getData().add(new XYChart.Data<String, Number>("호주", 10000));
		ser1.getData().add(new XYChart.Data<String, Number>("한국", 15000));
		ser1.getData().add(new XYChart.Data<String, Number>("영국", 20000));
		ser1.getData().add(new XYChart.Data<String, Number>("미국", 11100));
		ser1.getData().add(new XYChart.Data<String, Number>("중국", 18000));
		
		
		XYChart.Series<String, Number> ser2 = new XYChart.Series<String, Number>();
		ser2.setName("2017년");
		ser2.getData().add(new XYChart.Data<String, Number>("호주", 14000));
		ser2.getData().add(new XYChart.Data<String, Number>("한국", 10000));
		ser2.getData().add(new XYChart.Data<String, Number>("영국", 22000));
		ser2.getData().add(new XYChart.Data<String, Number>("미국", 21100));
		ser2.getData().add(new XYChart.Data<String, Number>("중국", 12000));
		
		
		XYChart.Series<String, Number> ser3 = new XYChart.Series<String, Number>();
		ser3.setName("2018년");
		ser3.getData().add(new XYChart.Data<String, Number>("호주", 24000));
		ser3.getData().add(new XYChart.Data<String, Number>("한국", 18000));
		ser3.getData().add(new XYChart.Data<String, Number>("영국", 22000));
		ser3.getData().add(new XYChart.Data<String, Number>("미국", 32100));
		ser3.getData().add(new XYChart.Data<String, Number>("중국", 22000));
		
		//차트에 데이터 추가
		bc.getData().addAll(ser1, ser2, ser3);
		
		Scene scene = new Scene(bc, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bar차트 연습");
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
