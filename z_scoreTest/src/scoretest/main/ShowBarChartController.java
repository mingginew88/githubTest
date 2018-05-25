package scoretest.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import scoretest.service.IScoreDataService;
import scoretest.service.ScoreDataServiceImpl;
import scoretest.vo.ScoreDataVO;

public class ShowBarChartController {	
	
	private Stage parentStage;

    public void setParentStage(Stage parentStage) {
		this.parentStage = parentStage;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClose;

    @FXML
    void closeWindow(ActionEvent event) {
    	Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    
    private IScoreDataService scoreData;
    
    ObservableList<ScoreDataVO> scoreList = FXCollections.observableArrayList();
    
    
    @FXML
    void initialize() {
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'ShowBarChart.fxml'.";
                
        
        scoreData = ScoreDataServiceImpl.getInstance();
        scoreList.addAll(scoreData.getSearchAllScore());
        
        CategoryAxis xAxis = new CategoryAxis(); //x축 역할
		NumberAxis   yAxis = new NumberAxis();   //y축 역할
        
		BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		
		//bc.setTitle("막대그래프"); 	// 차트제목
		xAxis.setLabel("이름");
		yAxis.setLabel("점수");
		
//		for (int i = 0; i < scoreList.size(); i++) {
//			XYChart.Series<String, Number> ser3 = new XYChart.Series<String, Number>();
//			ser3.setName(scoreList.get(i).getStd_name());
//			//ser3.getData().add(new XYChart.Series<String, Number>("국어",scoreList.get(i).getStd_kor()));
//			
//			
//			
//			bc.getData().addAll(ser3);			
//		}
//		Scene scene = new Scene(bc, 600, 400);
//		parentStage.setScene(scene);
//		parentStage.setTitle("Bar차트 연습");
//		parentStage.show();
//		
		
		
		
        
        
    }
}
