package student.main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import student.service.IStudentService;
import student.service.StudentServiceImpl;
import student.vo.StudentVO;

public class StudentMainController {
	
	private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<StudentVO> stdTable;

    @FXML
    private TableColumn<?, ?> stdNameCol;

    @FXML
    private TableColumn<?, ?> stdKorCol;

    @FXML
    private TableColumn<?, ?> stdEngCol;

    @FXML
    private TableColumn<?, ?> stdMatCol;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnViewBarChart;

    @FXML	//추가버튼
    void btnAddClick(ActionEvent event) throws IOException {
    	Stage addForm = new Stage();
    	addForm.initModality(Modality.WINDOW_MODAL);
    	addForm.initOwner(primaryStage);
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentAddForm.fxml"));
    	Parent addRoot = loader.load();
    	
    	
    	//테이블뷰에 설정된 List객체를 추가작업을 수행하는 컨트롤러로 넣어준다.
    	StudentAddFormController stdAddController = loader.getController();
    	stdAddController.setStdList(stdList);
    	
    	
    	Scene scene = new Scene(addRoot);
    	addForm.setScene(scene);
    	addForm.setTitle("자료추가");
    	addForm.show();

    }

    @FXML 	//학생별 막대그래프 버튼
    void btnViewBarChartClick(ActionEvent event) {
    	Stage barChartForm = new Stage();
    	barChartForm.initModality(Modality.WINDOW_MODAL);
    	barChartForm.initOwner(primaryStage);
    	
    	BarchartForm barChart = new BarchartForm(stdList);
    	
    	Scene scene = new Scene(barChart, 600, 500);
    	barChartForm.setScene(scene);
    	barChartForm.setTitle("막대 그래프");
    	barChartForm.show();
    	
    }

    
    private IStudentService stdService;
    
    //테이블뷰에 들어갈 변수
    private ObservableList<StudentVO> stdList;
    
    @FXML
    void initialize() {
        assert stdTable != null : "fx:id=\"stdTable\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert stdNameCol != null : "fx:id=\"stdNameCol\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert stdKorCol != null : "fx:id=\"stdKorCol\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert stdEngCol != null : "fx:id=\"stdEngCol\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert stdMatCol != null : "fx:id=\"stdMatCol\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert btnViewBarChart != null : "fx:id=\"btnViewBarChart\" was not injected: check your FXML file 'StudentMain.fxml'.";

        stdService = StudentServiceImpl.getInstance();
        
        //테이블 뷰의 컬럼 설정
        stdNameCol.setCellValueFactory(new PropertyValueFactory<>("std_name"));
        stdKorCol.setCellValueFactory(new PropertyValueFactory<>("std_kor"));
        stdEngCol.setCellValueFactory(new PropertyValueFactory<>("std_eng"));
        stdMatCol.setCellValueFactory(new PropertyValueFactory<>("std_mat"));
        
        //DB의 자료를 읽어와 테이블 뷰에 셋팅하기
        List<StudentVO> list = stdService.getAllStudent();
        stdList = FXCollections.observableArrayList(list);
        
        stdTable.setItems(stdList);
        
        
        //이벤트 설정 (테이블 뷰를 클릭했을 때)
        stdTable.setOnMouseClicked(e->{
        	StudentVO stdVo = stdTable.getSelectionModel().getSelectedItem();
        	if(stdVo==null) return;
        	
        	try {
        		Stage chartForm = new Stage();
        		chartForm.initModality(Modality.WINDOW_MODAL);
        		chartForm.initOwner(primaryStage);
        		
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentPieChart.fxml"));
        		
				Parent chartRoot = loader.load();
				
				StudentPieChartController stdPieController = loader.getController();
				stdPieController.setStdVo(stdVo);
				
				stdPieController.viewChart(); //차트 그려주는 메서드 호출
				
				Scene scene = new Scene(chartRoot);
				chartForm.setScene(scene);
				chartForm.setTitle("원형그래프");
				chartForm.show();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        	
        	
        	
        });
        
        
        
        
    }
}








