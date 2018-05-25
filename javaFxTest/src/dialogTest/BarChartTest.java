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
		
		CategoryAxis xAxis = new CategoryAxis(); //x�� ����
		NumberAxis   yAxis = new NumberAxis();   //y�� ����
		
		BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		
		bc.setTitle("����׷���"); 	// ��Ʈ����
		xAxis.setLabel("����");
		yAxis.setLabel("�ݾ�");
		
		//��Ʈ�� ����� ������ �����ϱ�
		XYChart.Series<String, Number> ser1 = new XYChart.Series<String, Number>();
		ser1.setName("2016��");
		ser1.getData().add(new XYChart.Data<String, Number>("ȣ��", 10000));
		ser1.getData().add(new XYChart.Data<String, Number>("�ѱ�", 15000));
		ser1.getData().add(new XYChart.Data<String, Number>("����", 20000));
		ser1.getData().add(new XYChart.Data<String, Number>("�̱�", 11100));
		ser1.getData().add(new XYChart.Data<String, Number>("�߱�", 18000));
		
		
		XYChart.Series<String, Number> ser2 = new XYChart.Series<String, Number>();
		ser2.setName("2017��");
		ser2.getData().add(new XYChart.Data<String, Number>("ȣ��", 14000));
		ser2.getData().add(new XYChart.Data<String, Number>("�ѱ�", 10000));
		ser2.getData().add(new XYChart.Data<String, Number>("����", 22000));
		ser2.getData().add(new XYChart.Data<String, Number>("�̱�", 21100));
		ser2.getData().add(new XYChart.Data<String, Number>("�߱�", 12000));
		
		
		XYChart.Series<String, Number> ser3 = new XYChart.Series<String, Number>();
		ser3.setName("2018��");
		ser3.getData().add(new XYChart.Data<String, Number>("ȣ��", 24000));
		ser3.getData().add(new XYChart.Data<String, Number>("�ѱ�", 18000));
		ser3.getData().add(new XYChart.Data<String, Number>("����", 22000));
		ser3.getData().add(new XYChart.Data<String, Number>("�̱�", 32100));
		ser3.getData().add(new XYChart.Data<String, Number>("�߱�", 22000));
		
		//��Ʈ�� ������ �߰�
		bc.getData().addAll(ser1, ser2, ser3);
		
		Scene scene = new Scene(bc, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bar��Ʈ ����");
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
