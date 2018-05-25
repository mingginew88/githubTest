package scoretest.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import scoretest.service.IScoreDataService;
import scoretest.service.ScoreDataServiceImpl;
import scoretest.vo.ScoreDataVO;

public class ScoreDataController {
	
	private Stage parentStage;
	
	public void setParentStage(Stage parentStage) {
		this.parentStage = parentStage;
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane root;

    @FXML
    private TableView<ScoreDataVO> scoreTable;

    @FXML
    private TableColumn<?, ?> tc_nameCol;

    @FXML
    private TableColumn<?, ?> tc_korCol;

    @FXML
    private TableColumn<?, ?> tc_engCol;

    @FXML
    private TableColumn<?, ?> tc_mathCol;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_delete;

    @FXML
    private ComboBox<String> cb_showdata;

    @FXML
    void scoreAdd(ActionEvent event) {
    	
		try {			
			Stage clickedBtnAdd = new Stage(StageStyle.DECORATED);
			clickedBtnAdd.initModality(Modality.WINDOW_MODAL);
			clickedBtnAdd.initOwner(parentStage);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreAdd.fxml"));
			BorderPane childRoot = loader.load();
			
			Scene scene = new Scene(childRoot);
			clickedBtnAdd.setScene(scene);
			clickedBtnAdd.setTitle("�߰�");
			clickedBtnAdd.show();		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    

    @FXML
    void scoreDelete(ActionEvent event) {
    	if(scoreTable.getSelectionModel().isEmpty()) {
    		alert("���ÿ���", "������ �����͸� �������ּ���.");
    		return;
    	} else {
    		
    		int std_num = scoreTable.getSelectionModel().getSelectedItem().getStd_num();
    		String std_name = scoreTable.getSelectionModel().getSelectedItem().getStd_name();
    		
    		if(confirm("������û", std_name + "���� ������ ������ �����Ͻðڽ��ϱ�?")) {
    			int cnt = scoreData.deleteScore(std_num);
    			if(cnt == 1) {
	    			info("�۾�����", std_name + "�� ���� ���� ����!!");
	    		} else {
	    			info("�۾�����", std_name + "�� ���� ������ �����Ͽ����ϴ�.");
	    		}
    		} else {
    			info("�۾����", "�����۾��� ��ҵǾ����ϴ�.");
    		}
    	}
    	
    	scoreList.clear();
    	scoreList.addAll(scoreData.getSearchAllScore());
    	scoreTable.setItems(scoreList);

    }

    @FXML
    void scoreUpdate(ActionEvent event) {
    	try {
    		if(scoreTable.getSelectionModel().isEmpty()) {
        		alert("���ÿ���","������ �����͸� ������ �������ּ���.");
    			return;
        	}
    		
			Stage clickedBtnUpdate = new Stage(StageStyle.DECORATED);
			clickedBtnUpdate.initModality(Modality.WINDOW_MODAL);
			clickedBtnUpdate.initOwner(parentStage);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreUpdate.fxml"));
			BorderPane childRoot = loader.load();
			
			Scene scene = new Scene(childRoot);
			clickedBtnUpdate.setScene(scene);
			clickedBtnUpdate.setTitle("����");
			clickedBtnUpdate.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void showGraph(ActionEvent event) {
    	if(cb_showdata.getValue().equals("BarChart")) {
    		try {
    			Stage clickedBarChart = new Stage(StageStyle.DECORATED);
    			clickedBarChart.initModality(Modality.WINDOW_MODAL);
    			clickedBarChart.initOwner(parentStage);
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowBarChart.fxml"));
    			BorderPane childRoot = loader.load();
    			
    			Scene scene = new Scene(childRoot);
    			clickedBarChart.setScene(scene);
    			clickedBarChart.setTitle("���� �׷���");
    			clickedBarChart.show();
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    	} else if(cb_showdata.getValue().equals("PieChart")) {
    		try {
    			Stage clickedPieChart = new Stage(StageStyle.DECORATED);
    			clickedPieChart.initModality(Modality.WINDOW_MODAL);
    			clickedPieChart.initOwner(parentStage);
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowPieChart.fxml"));
    			BorderPane childRoot = loader.load();
    			
    			Scene scene = new Scene(childRoot);
    			clickedPieChart.setScene(scene);
    			clickedPieChart.setTitle("���� �׷���");
    			clickedPieChart.show();
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    	}
    	
    	
    	

    }
    
    
    private IScoreDataService scoreData;
    
    ObservableList<ScoreDataVO> scoreList = FXCollections.observableArrayList();

     
    
    @FXML
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert scoreTable != null : "fx:id=\"scoreTable\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert tc_nameCol != null : "fx:id=\"tc_nameCol\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert tc_korCol != null : "fx:id=\"tc_korCol\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert tc_engCol != null : "fx:id=\"tc_engCol\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert tc_mathCol != null : "fx:id=\"tc_mathCol\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert btn_add != null : "fx:id=\"btn_add\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert btn_delete != null : "fx:id=\"btn_delete\" was not injected: check your FXML file 'ScoreData.fxml'.";
        assert cb_showdata != null : "fx:id=\"cb_showdata\" was not injected: check your FXML file 'ScoreData.fxml'.";
        
        scoreData = ScoreDataServiceImpl.getInstance();
        
        tc_nameCol.setCellValueFactory(new PropertyValueFactory<>("std_name"));
        tc_korCol.setCellValueFactory(new PropertyValueFactory<>("std_kor"));
        tc_engCol.setCellValueFactory(new PropertyValueFactory<>("std_eng"));
        tc_mathCol.setCellValueFactory(new PropertyValueFactory<>("std_mat"));
        
        scoreList.addAll(scoreData.getSearchAllScore());
        scoreTable.setItems(scoreList);
        
        cb_showdata.getItems().addAll("BarChart", "PieChart");
        

        
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
    
  	//Confirmâ
  	public boolean confirm(String header, String msg) {
  		Alert confirm = new Alert(AlertType.CONFIRMATION);
  		confirm.setTitle("����");
  		confirm.setHeaderText(header);
  		confirm.setContentText(msg);
  		
  		ButtonType conResult = confirm.showAndWait().get();
  		boolean result = false;
  		if(conResult==ButtonType.OK) {
  			result = true;
  		} else if(conResult==ButtonType.CANCEL) {
  			result = false;
  		}
  		return result;
  	}
    
    
    
    
    
}
