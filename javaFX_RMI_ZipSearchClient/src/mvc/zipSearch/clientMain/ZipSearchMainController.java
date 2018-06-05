package mvc.zipSearch.clientMain;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
import mvc.zipSearch.service.ZipSearchServiceInf;
import mvc.zipSearch.vo.ZipVO;

public class ZipSearchMainController {

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
    private TableView<ZipVO> zipTable;

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

    // '검색'버튼 클릭 이벤트
    @FXML
    void zipSearch(ActionEvent event) throws RemoteException {
    	if(tfData.getText().isEmpty()) {
			alert("검색할 값을 입력하세요.");
			return;
		}
		
		String searchData = tfData.getText();
		
		List<ZipVO> result = null;
		
		// 콤보박스의 선택항목을 구분해서 검색 처리
		if(cmbSelect.getValue().equals("동이름")) {
			result = service.zipSearchDong(searchData);
		}else if(cmbSelect.getValue().equals("우편번호")) {
			result = service.zipSearchZipCode(searchData);
		}
		
		// 검색된 결과를 TableView에서 사용하는 List에 넣어주기
		zipList.clear();
		zipList.addAll(result);
    }

    // Service객체와 데이터저장할 멤버 변수 선언
    private ZipSearchServiceInf service;
    ObservableList<ZipVO> zipList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        assert cmbSelect != null : "fx:id=\"cmbSelect\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert tfData != null : "fx:id=\"tfData\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert zipTable != null : "fx:id=\"zipTable\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert zipCol != null : "fx:id=\"zipCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert sidoCol != null : "fx:id=\"sicoCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert gugunCol != null : "fx:id=\"gugunCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert dongCol != null : "fx:id=\"dongCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert riCol != null : "fx:id=\"riCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert bldgCol != null : "fx:id=\"bldgCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";
        assert bunjiCol != null : "fx:id=\"bunjiCol\" was not injected: check your FXML file 'ZipSearchMain.fxml'.";

        // service객체 생성
        //service = ZipSearchService.getInstance();
        try {
			Registry reg = LocateRegistry.getRegistry("localhost", 9988);
			service = (ZipSearchServiceInf) reg.lookup("zipSearch");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        
        // 콤보박스 설정
        cmbSelect.getItems().addAll("동이름", "우편번호");
        cmbSelect.setValue("동이름");
        
        // 컬럼 설정
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        sidoCol.setCellValueFactory(new PropertyValueFactory<>("sido"));
        gugunCol.setCellValueFactory(new PropertyValueFactory<>("gugun"));
        dongCol.setCellValueFactory(new PropertyValueFactory<>("dong"));
        riCol.setCellValueFactory(new PropertyValueFactory<>("ri"));
        bldgCol.setCellValueFactory(new PropertyValueFactory<>("bldg"));
        bunjiCol.setCellValueFactory(new PropertyValueFactory<>("bunji"));
        
        // TableView에 데이터 셋팅
        zipTable.setItems(zipList);
        
    }
    
    // alert창
    public void alert(String msg) {
    	Alert alertWarning = new Alert(AlertType.WARNING);
    	alertWarning.setTitle("경고");
    	alertWarning.setContentText(msg);
    	alertWarning.showAndWait();
    }
    
    // info창
    public void info(String msg) {
    	Alert alertInfo = new Alert(AlertType.INFORMATION);
    	alertInfo.setTitle("확인");
    	alertInfo.setContentText(msg);
    	alertInfo.showAndWait();
    }
}
