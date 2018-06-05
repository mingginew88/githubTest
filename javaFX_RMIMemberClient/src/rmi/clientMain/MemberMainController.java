package rmi.clientMain;

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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import rmi.service.IMemberService;
import rmi.vo.MemberVO;

public class MemberMainController {
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField txtId;

	    @FXML
	    private TextField txtName;

	    @FXML
	    private TextField txtTel;

	    @FXML
	    private TextField txtAddr;

	    @FXML
	    private Button btnAdd;

	    @FXML
	    private Button btnEdit;

	    @FXML
	    private Button btnDel;

	    @FXML
	    private Button btnOk;

	    @FXML
	    private Button btnCancel;

	    @FXML
	    private TableView<MemberVO> table;

	    @FXML
	    private TableColumn<?, ?> idCol;

	    @FXML
	    private TableColumn<?, ?> nameCol;

	    @FXML
	    private TableColumn<?, ?> telCol;

	    @FXML
	    private TableColumn<?, ?> addrCol;
	    
	    // 테이블 뷰에 설정할 데이터가 저장될 List
	    private ObservableList<MemberVO> data;
	    
	    private IMemberService service;
	    
	    private String strWork = "";  // 추가버튼, 수정버튼 확인용

	    
	    // 추가
	    @FXML
	    void dataAdd(ActionEvent event) {
	    	txtId.setEditable(true);  // 편집 가능 상태로 만든다.
	    	txtName.setEditable(true);
	    	txtTel.setEditable(true);
	    	txtAddr.setEditable(true);
	    	
	    	btnOk.setDisable(false);  // 활성화
	    	btnCancel.setDisable(false);
	    	
	    	btnAdd.setDisable(true);  // 비활성화
	    	btnEdit.setDisable(true);
	    	btnDel.setDisable(true);
	    	
	    	table.setDisable(true);  // 테이블뷰 비활성화
	    	
	    	txtId.clear();  // TextField의 내용 삭제
	    	txtName.clear();
	    	txtTel.clear();
	    	txtAddr.clear();
	    	
	    	strWork = "Insert";
	    	
	    	txtId.requestFocus();  // 포커스 주기
	    }

	    // 삭제
	    @FXML
	    void dataDel(ActionEvent event) throws RemoteException {
	    	if(table.getSelectionModel().getSelectedItem()==null) {
	    		alert("선택오류", "삭제할 자료를 선택하세요.");
	    		return;
	    	}
	    	
	    	if(confirm("작업선택", "정말로 삭제하시겠습니까?")) {
	    		
	    		// 현재 선택한 자료 중 회원ID값 구하기
	    		String memId = table.getSelectionModel().getSelectedItem().getMem_id();
	    		int index = table.getSelectionModel().getSelectedIndex();
	    		
	    		int cnt = service.deleteMember(memId);
	    		if(cnt>0) { // DB에서 삭제작업 성공
	    			info("작업결과", memId + "를 삭제했습니다.");
	    			data.remove(index);  // 테이블뷰의 데이터 갱신
	    			txtId.clear();
	    			txtName.clear();
	    			txtTel.clear();
	    			txtAddr.clear();
	    		}else {
	    			alert("작업결과", "삭제작업 실패~~");
	    		}
	    	}
	    }

	    // 수정
	    @FXML
	    void dataEdit(ActionEvent event) {
	    	if(table.getSelectionModel().getSelectedItem()==null) {
	    		alert("수정작업오류", "수정할 데이터를 선택하세요");
	    		return;
	    	}
	    	
	    	txtId.setEditable(false);  
	    	txtName.setEditable(true); // 편집 가능 상태로 만든다.
	    	txtTel.setEditable(true);
	    	txtAddr.setEditable(true);
	    	
	    	btnOk.setDisable(false);  // 활성화
	    	btnCancel.setDisable(false);
	    	
	    	btnAdd.setDisable(true);  // 비활성화
	    	btnEdit.setDisable(true);
	    	btnDel.setDisable(true);
	    	
	    	table.setDisable(true);  // 테이블뷰 비활성화
	    	
	    	strWork = "Edit";
	    	
	    	txtName.requestFocus();  // 포커스 주기
	    	
	    }

	    // 확인
	    @FXML
	    void dataRun(ActionEvent event) throws RemoteException {
	    	if("Insert".equals(strWork)) {  //추가 작업
	    		if(txtId.getText().isEmpty()) {
	    			alert("입력오류", "회원ID를 입력하세요.");
	    			txtId.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtName.getText().isEmpty()) {
	    			alert("입력오류", "회원이름을 입력하세요.");
	    			txtName.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtTel.getText().isEmpty()) {
	    			alert("입력오류", "전화번호를 입력하세요.");
	    			txtTel.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtAddr.getText().isEmpty()) {
	    			alert("입력오류", "주소를 입력하세요.");
	    			txtAddr.requestFocus();
	    			return;
	    		}
	    		
	    		// 회원ID 중복 검사
	    		if(service.getCountMember(txtId.getText())>0) {
	    			alert("입력오류", "회원ID가 중복됩니다.\n회원ID를 다시입력하세요");
	    			txtId.requestFocus();
	    			return;
	    		}
	    		
	    		MemberVO mvo = new MemberVO();
	    		mvo.setMem_id(txtId.getText());
	    		mvo.setMem_name(txtName.getText());
	    		mvo.setMem_tel(txtTel.getText());
	    		mvo.setMem_addr(txtAddr.getText());
	    		
	    		int cnt = service.insertMember(mvo); 
	    		if(cnt>0) { // DB에 데이터 추가 성공
	    			data.add(mvo);   // 테이블뷰의 자료 갱신
	    			info("작업성공", "데이터 추가 작업 성공!!!");
	    			txtId.clear();
	    			txtName.clear();
	    			txtTel.clear();
	    			txtAddr.clear();
	    		}else {  // DB에 데이터 추가 작업 실패
	    			alert("추가실패", "데이터 추가 작업 실패~~");
	    		}
	    		
	    		
	    		
	    	}else if("Edit".equals(strWork)) {  // 수정작업
	    		if(txtName.getText().isEmpty()) {
	    			alert("입력오류", "회원이름을 입력하세요.");
	    			txtName.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtTel.getText().isEmpty()) {
	    			alert("입력오류", "전화번호를 입력하세요.");
	    			txtTel.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtAddr.getText().isEmpty()) {
	    			alert("입력오류", "주소를 입력하세요.");
	    			txtAddr.requestFocus();
	    			return;
	    		}
	    		
	    		MemberVO mvo = new MemberVO();
	    		mvo.setMem_id(txtId.getText());
	    		mvo.setMem_name(txtName.getText());
	    		mvo.setMem_tel(txtTel.getText());
	    		mvo.setMem_addr(txtAddr.getText());
	    		
	    		int cnt = service.updateMember(mvo);
	    		
	    		if(cnt>0) { // DB에 Update 성공
	    			int index = table.getSelectionModel().getSelectedIndex();
	    			data.set(index, mvo);  // 테이블뷰 데이터 갱신
	    			
	    			info("작업성공", "데이터 수정 작업 성공!!!");
	    		}else {
	    			alert("작업실패", "데이터 수정 작업 실패~~");
	    		}
	    	} //
	    	
	    	
	    	// 추가 또는 수정 작업 완료 후 원래 상태로...
	    	
	    	txtId.setEditable(false);  // 편집 불가능 상태로 만든다.
	    	txtName.setEditable(false);
	    	txtTel.setEditable(false);
	    	txtAddr.setEditable(false);
	    	
	    	btnOk.setDisable(true);  // 비활성화
	    	btnCancel.setDisable(true);
	    	
	    	btnAdd.setDisable(false);  // 활성화
	    	btnEdit.setDisable(false);
	    	btnDel.setDisable(false);
	    	
	    	table.setDisable(false);  // 테이블뷰 활성화
	    	
	    	strWork = "";
	    	
	    }
	    
	    // 취소
	    @FXML
	    void dataCancel(ActionEvent event) {
	    	txtId.setEditable(false);  // 편집 불가능 상태로 만든다.
	    	txtName.setEditable(false);
	    	txtTel.setEditable(false);
	    	txtAddr.setEditable(false);
	    	
	    	btnOk.setDisable(true);  // 비활성화
	    	btnCancel.setDisable(true);
	    	
	    	btnAdd.setDisable(false);  // 활성화
	    	btnEdit.setDisable(false);
	    	btnDel.setDisable(false);
	    	
	    	table.setDisable(false);  // 테이블뷰 활성화
	    	
	    	
	    	
	    	strWork = "";
	    }

	    // 테이블뷰 클릭
	    @FXML
	    void tableClick(MouseEvent event) {
	    	MemberVO mvo = table.getSelectionModel().getSelectedItem();
	    	
	    	if(mvo!=null) {
	    		txtId.setText(mvo.getMem_id());
	    		txtName.setText(mvo.getMem_name());
	    		txtTel.setText(mvo.getMem_tel());
	    		txtAddr.setText(mvo.getMem_addr());
	    	}
	    	
	    }

	    @FXML
	    void initialize() throws RemoteException {
	        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert txtTel != null : "fx:id=\"txtTel\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert txtAddr != null : "fx:id=\"txtAddr\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert telCol != null : "fx:id=\"telCol\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        assert addrCol != null : "fx:id=\"addrCol\" was not injected: check your FXML file 'MemberMain.fxml'.";
	        // ==================================================
	        
	        // Service객체 생성
	        //service = MemberService.getInstance();
	        
	        try {
				Registry reg = LocateRegistry.getRegistry("localhost", 9988);
				service = (IMemberService) reg.lookup("member");
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
	        
	        
	        
	        // 테이블뷰의 각 컬럼 설정
	        idCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
	        nameCol.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
	        telCol.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
	        addrCol.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
	        
	        // DB에서 자료를 가져오기
	        List<MemberVO> memList = service.getAllMember();
	        data = FXCollections.observableArrayList(memList);
	        
	        table.setItems(data);
	        

	    }
	    
	    // alert창
	    public void alert(String head, String msg) {
	    	Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("경고");
	    	alert.setHeaderText(head);
	    	alert.setContentText(msg);
	    	alert.showAndWait();
	    }
	    
	    // information창
	    public void info(String head, String msg) {
	    	Alert info = new Alert(AlertType.INFORMATION);
	    	info.setTitle("정보");
	    	info.setHeaderText(head);
	    	info.setContentText(msg);
	    	info.showAndWait();
	    }
	    
	    // confirmation창
	    // 메시지창에서 '확인'버튼 누르면 true, 
	    //    '취소'버튼 누르면 false를 반환하는 메서드
	    public boolean confirm(String head, String msg) {
	    	Alert confirm = new Alert(AlertType.CONFIRMATION);
	    	confirm.setTitle("선택");
	    	confirm.setHeaderText(head);
	    	confirm.setContentText(msg);
	    	
	    	ButtonType result = confirm.showAndWait().get();
	    	
	    	if(result==ButtonType.OK) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    	
	    	
	    }

}
