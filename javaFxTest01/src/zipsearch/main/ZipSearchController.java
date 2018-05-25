package zipsearch.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import zipsearch.service.IZipSearchService;
import zipsearch.service.ZipSearchServiceImpl;
import zipsearch.vo.ZipDataVO;

public class ZipSearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbSelect;

    @FXML
    private TextField tfData;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<ZipDataVO> zipTable;

    @FXML
    private TableColumn<?, ?> zipCol;

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

    
    // '검색'버튼을 클릭했을 때 이벤트 처리
    @FXML
    void zipSearch(ActionEvent event) {
    	if(tfData.getText().isEmpty()) {
    		alert("입력오류", "검색할 내용을 입력하세요");
    		return;
    	}
    	
    	String searchData = tfData.getText();
    	
    	List<ZipDataVO> result = null;
    	
    	if(cmbSelect.getValue().equals("동이름")) {
    		result = zipService.getSearchDong(searchData);
    	}else if(cmbSelect.getValue().equals("우편번호")) {
    		result = zipService.getSearchZipcode(searchData);
    	}
    	
    	zipList.clear(); // 이전 데이터 삭제
    	
    	zipList.addAll(result);
    	
    	
    }

    private IZipSearchService zipService;
    
    private ObservableList<ZipDataVO> zipList = 
    			FXCollections.observableArrayList();
    
    
    @FXML
    void initialize() {
        assert cmbSelect != null : "fx:id=\"cmbSelect\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert tfData != null : "fx:id=\"tfData\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert zipTable != null : "fx:id=\"zipTable\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert zipCol != null : "fx:id=\"zipCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert sidoCol != null : "fx:id=\"sidoCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert gugunCol != null : "fx:id=\"gugunCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert dongCol != null : "fx:id=\"dongCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert riCol != null : "fx:id=\"riCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert bldgCol != null : "fx:id=\"bldgCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        assert bunjiCol != null : "fx:id=\"bunjiCol\" was not injected: check your FXML file 'ZipSearch.fxml'.";
        //-------------------------------------------------------
        zipService = ZipSearchServiceImpl.getInstance();
        
        cmbSelect.getItems().addAll("동이름", "우편번호");
        cmbSelect.setValue("동이름");
        
        // 테이블뷰의 각 컬럼 설정
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        sidoCol.setCellValueFactory(new PropertyValueFactory<>("sido"));
        gugunCol.setCellValueFactory(new PropertyValueFactory<>("gugun"));
        dongCol.setCellValueFactory(new PropertyValueFactory<>("dong"));
        riCol.setCellValueFactory(new PropertyValueFactory<>("ri"));
        bldgCol.setCellValueFactory(new PropertyValueFactory<>("bldg"));
        bunjiCol.setCellValueFactory(new PropertyValueFactory<>("bunji"));
        
        // 테이블 뷰에 데이터 설정
        zipTable.setItems(zipList);

    }
    
    // alert창
    public void alert(String h, String msg) {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("경고");
    	alert.setHeaderText(h);
    	alert.setContentText(msg);
    	alert.showAndWait();
    }
    
    
}










