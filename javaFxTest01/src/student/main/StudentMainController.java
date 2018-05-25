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

    @FXML	//�߰���ư
    void btnAddClick(ActionEvent event) throws IOException {
    	Stage addForm = new Stage();
    	addForm.initModality(Modality.WINDOW_MODAL);
    	addForm.initOwner(primaryStage);
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentAddForm.fxml"));
    	Parent addRoot = loader.load();
    	
    	
    	//���̺��信 ������ List��ü�� �߰��۾��� �����ϴ� ��Ʈ�ѷ��� �־��ش�.
    	StudentAddFormController stdAddController = loader.getController();
    	stdAddController.setStdList(stdList);
    	
    	
    	Scene scene = new Scene(addRoot);
    	addForm.setScene(scene);
    	addForm.setTitle("�ڷ��߰�");
    	addForm.show();

    }

    @FXML 	//�л��� ����׷��� ��ư
    void btnViewBarChartClick(ActionEvent event) {
    	Stage barChartForm = new Stage();
    	barChartForm.initModality(Modality.WINDOW_MODAL);
    	barChartForm.initOwner(primaryStage);
    	
    	BarchartForm barChart = new BarchartForm(stdList);
    	
    	Scene scene = new Scene(barChart, 600, 500);
    	barChartForm.setScene(scene);
    	barChartForm.setTitle("���� �׷���");
    	barChartForm.show();
    	
    }

    
    private IStudentService stdService;
    
    //���̺��信 �� ����
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
        
        //���̺� ���� �÷� ����
        stdNameCol.setCellValueFactory(new PropertyValueFactory<>("std_name"));
        stdKorCol.setCellValueFactory(new PropertyValueFactory<>("std_kor"));
        stdEngCol.setCellValueFactory(new PropertyValueFactory<>("std_eng"));
        stdMatCol.setCellValueFactory(new PropertyValueFactory<>("std_mat"));
        
        //DB�� �ڷḦ �о�� ���̺� �信 �����ϱ�
        List<StudentVO> list = stdService.getAllStudent();
        stdList = FXCollections.observableArrayList(list);
        
        stdTable.setItems(stdList);
        
        
        //�̺�Ʈ ���� (���̺� �並 Ŭ������ ��)
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
				
				stdPieController.viewChart(); //��Ʈ �׷��ִ� �޼��� ȣ��
				
				Scene scene = new Scene(chartRoot);
				chartForm.setScene(scene);
				chartForm.setTitle("�����׷���");
				chartForm.show();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        	
        	
        	
        });
        
        
        
        
    }
}







