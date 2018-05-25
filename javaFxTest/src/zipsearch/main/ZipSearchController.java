package zipsearch.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import zipsearch.service.IZipSearchService;
import zipsearch.service.ZipSearchServiceImpl;
import zipsearch.vo.ZipDataVO;

public class ZipSearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ZipDataVO> zipTable;

    @FXML
    private TableColumn<?, ?> zipCodeCol;

    @FXML
    private TableColumn<?, ?> sidoCol;

    @FXML
    private TableColumn<?, ?> gugunCol;

    @FXML
    private TableColumn<?, ?> dongCol;

    @FXML
    private TableColumn<?, ?> riCol;

    @FXML
    private TableColumn<?, ?> bldgCol;

    @FXML
    private TableColumn<?, ?> bunjiCol;

    @FXML
    private HBox hbox;

    @FXML
    private ComboBox<String> cmbSelect;

    @FXML
    private TextField tfData;

    @FXML
    private Button btnSearch;

    @FXML
    void zipSearch(ActionEvent event) {
    	if(tfData.getText().isEmpty()) {
    		alert("�Է¿���", "�˻��� ������ �Է��ϼ���.");
    		return;
    	}
    	
    	String searchData = tfData.getText();
    	
    	List<ZipDataVO> result = null;
    	
    	if(cmbSelect.getValue().equals("���̸�")) {
    		result = zipService.getSearchDong(searchData);
    	} else if(cmbSelect.getValue().equals("�����ȣ")) {
    		result = zipService.getSearchZipcode(searchData);
    	}
    	
    	zipList.clear(); //���� ������ ����
    	
    	zipList.addAll(result);
    }
    
    
    
    private IZipSearchService zipService;
    
    //���̺� ����� �����ʹ�.. ����������Ʈ�� ���
    ObservableList<ZipDataVO> zipList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        assert zipTable != null : "fx:id=\"zipTable\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert zipCodeCol != null : "fx:id=\"zipCodeCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert sidoCol != null : "fx:id=\"sidoCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert gugunCol != null : "fx:id=\"gugunCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert dongCol != null : "fx:id=\"dongCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert riCol != null : "fx:id=\"riCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert bldgCol != null : "fx:id=\"bldgCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert bunjiCol != null : "fx:id=\"bunjiCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert hbox != null : "fx:id=\"hbox\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert cmbSelect != null : "fx:id=\"cmbSelect\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert tfData != null : "fx:id=\"tfData\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        //--------------------------------------------
        
        zipService = ZipSearchServiceImpl.getInstance();
        cmbSelect.getItems().addAll("���̸�", "�����ȣ");
        cmbSelect.setValue("���̸�");
        
        //���̺���� �� �÷� ����
        zipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        sidoCol.setCellValueFactory(new PropertyValueFactory<>("sido"));
        gugunCol.setCellValueFactory(new PropertyValueFactory<>("gugun"));
        dongCol.setCellValueFactory(new PropertyValueFactory<>("dong"));
        riCol.setCellValueFactory(new PropertyValueFactory<>("ri"));
        bldgCol.setCellValueFactory(new PropertyValueFactory<>("bldg"));
        bunjiCol.setCellValueFactory(new PropertyValueFactory<>("bunji"));
        
        //���̺� �信 ������ ����
        zipTable.setItems(zipList);
        
        
    }
    
    //���(alert)â
    public void alert(String h, String msg) {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("���");
    	alert.setHeaderText(h);
    	alert.setContentText(msg);
    	alert.showAndWait();
    }
    
    
    
    
    
    
    
    
    
    
}
