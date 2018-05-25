package mymember.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import mymember.service.IMyMemberService;
import mymember.service.MyMemberServiceImpl;
import mymember.vo.MyMemberVO;

public class MyMemberController {
	private String status = "";		//버튼 사용 유무를 표현하기위한 상태표시

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfMemId;

    @FXML
    private TextField tfMemName;

    @FXML
    private TextField tfMemHp;

    @FXML
    private TextField tfMemAddr;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnChk;

    @FXML
    private Button btnCancel;

    @FXML
    private TableView<MyMemberVO> memberTable;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> hpCol;

    @FXML
    private TableColumn<?, ?> add1Col;   

    @FXML
    void memAdd(ActionEvent event) {
    	
    	btnAdd.setDisable(true);	//추가, 수정, 삭제 비활성화
    	btnUpdate.setDisable(true);
    	btnDel.setDisable(true);
    	
    	btnChk.setDisable(false);	//확인, 취소 활성화 
    	btnCancel.setDisable(false);
    	
    	memberTable.setDisable(true);
    	
    	tfMemId.setEditable(true);	//편집가능상태
    	tfMemName.setEditable(true);
    	tfMemHp.setEditable(true);
    	tfMemAddr.setEditable(true);
    	
    	tfMemId.clear();	//TextField 내용 삭제
    	tfMemName.clear();
    	tfMemHp.clear();
    	tfMemAddr.clear();
    	
    	tfMemId.requestFocus();		//포커스 주기    	
    	
    	status = "add";
    }

    
    @FXML
    void memUpdate(ActionEvent event) {    	
    	btnAdd.setDisable(true);
    	btnUpdate.setDisable(true);
    	btnDel.setDisable(true);
    	btnChk.setDisable(false);
    	btnCancel.setDisable(false);
    	
    	memberTable.setDisable(true);
    	
    	tfMemId.setEditable(false);
    	tfMemName.setEditable(true);
    	tfMemHp.setEditable(true);
    	tfMemAddr.setEditable(true);
    	
    	tfMemName.requestFocus();
    	
    	status = "update";
    }
    
    
    @FXML
    void memDel(ActionEvent event) {    	
    	if(memberTable.getSelectionModel().isEmpty()) {
    		alert("선택오류","삭제할 데이터를 선택해 수행해주세요.");
			return;
    	}
    	
    	btnAdd.setDisable(true);
    	btnUpdate.setDisable(true);
    	btnDel.setDisable(true);
    	btnChk.setDisable(false);
    	btnCancel.setDisable(false);
    	
    	memberTable.setDisable(true);    	
    	
    	status = "delete";
    }    
    
    
    @FXML
    void applicationConfirm(ActionEvent event) {
    	MyMemberVO  memVo = new MyMemberVO();
    	
    	if("add".equals(status)) {
			if(tfMemId.getText().isEmpty()) {
				alert("입력오류","회원ID를 입력하세요.");				
				tfMemId.requestFocus();
				return;
			}
			
			if(tfMemName.getText().isEmpty()) {
				alert("입력오류","이름을 입력하세요.");
				tfMemName.requestFocus();
				return;
			}			
			
			if(tfMemHp.getText().isEmpty()) {
				alert("입력오류","전화번호를 입력하세요.");
				tfMemHp.requestFocus();
				return;
			}
			
			if(tfMemAddr.getText().isEmpty()) {
				alert("입력오류","주소를 입력하세요.");
				tfMemAddr.requestFocus();
				return;
			}
			
			//회원ID 중복검사
			if(myMember.getCountMember(tfMemId.getText())>0) {
				alert("입력오류","회원ID가 중복됩니다. \n회원ID를 다시입력하세요.");
				tfMemId.requestFocus();
				return;
			}
			
			memVo.setMem_id(tfMemId.getText());
			memVo.setMem_name(tfMemName.getText());
			memVo.setMem_tel(tfMemHp.getText());
			memVo.setMem_addr(tfMemAddr.getText());
			
			String name = tfMemName.getText();
			
			//회원 추가 성공시 반환값  1 실패시 0
			int cnt = myMember.addMember(memVo);			
			if(cnt==1) {
				info("작업성공", name + "씨 정보 추가 성공!!");				
			} else {
				info("작업실패", "회원정보 추가에 실패하였습니다.");	
			}
			
			
		} else if ("update".equals(status)) {			
			if(tfMemName.getText().isEmpty()) {
				alert("입력오류","이름을 입력하세요.");
				tfMemName.requestFocus();
				return;
			}
			
			if(tfMemHp.getText().isEmpty()) {
				alert("입력오류","전화번호를 입력하세요.");
				tfMemHp.requestFocus();
				return;
			}
			
			if(tfMemAddr.getText().isEmpty()) {
				alert("입력오류","주소를 입력하세요.");
				tfMemAddr.requestFocus();
				return;
			}
						
			memVo.setMem_id(tfMemId.getText());
			memVo.setMem_name(tfMemName.getText());
			memVo.setMem_tel(tfMemHp.getText());
			memVo.setMem_addr(tfMemAddr.getText());
			
			String name = tfMemName.getText();
			
			int cnt = myMember.updateMember(memVo);
			if(cnt==1) {
		    	info("작업성공", name + "씨 정보 수정 성공!!");
			} else {
				info("작업실패", "회원정보 수정에 실패하였습니다.");
			}
			
		} else if("delete".equals(status)) {
	    	String mem_id = memberTable.getSelectionModel().getSelectedItem().getMem_id();
	    	
	    	if(confirm("삭제요청", mem_id + "씨 정보를 정말로 삭제하시겠습니까?")) {	
	    		int cnt = myMember.deleteMember(mem_id);
	    		if(cnt == 1) {
	    			info("작업성공", mem_id + "씨 정보 삭제 성공!!");
	    		} else {
	    			info("작업실패", mem_id + "씨 정보 삭제에 실패하였습니다.");
	    		}
			} else {
				info("작업취소", "삭제작업이 취소되었습니다.");
			}
		}
    	
    	//테이블뷰 화면 갱신
    	memList.clear();
    	memList.addAll(myMember.getSearchAllMember());
        memberTable.setItems(memList);
        
        
    	//추가 수정 삭제 이후 기본값 복원
    	btnAdd.setDisable(false);
    	btnUpdate.setDisable(false);
    	btnDel.setDisable(false);
    	btnChk.setDisable(true);
    	btnCancel.setDisable(true);
    	
    	tfMemId.setEditable(false);
    	tfMemName.setEditable(false);
    	tfMemHp.setEditable(false);
    	tfMemAddr.setEditable(false);
    	
    	memberTable.setDisable(false);
    	
    	tfMemId.clear();
    	tfMemName.clear();
    	tfMemHp.clear();
    	tfMemAddr.clear();
    	
    	status = "";
    }
    
    
    @FXML
    void applicationCancel(ActionEvent event) {
    	btnAdd.setDisable(false);
    	btnUpdate.setDisable(false);
    	btnDel.setDisable(false);
    	btnChk.setDisable(true);
    	btnCancel.setDisable(true);
    	
    	memberTable.setDisable(false);
    	
    	tfMemId.setEditable(false);
    	tfMemName.setEditable(false);
    	tfMemHp.setEditable(false);
    	tfMemAddr.setEditable(false);
    	
    	tfMemId.clear();
    	tfMemName.clear();
    	tfMemHp.clear();
    	tfMemAddr.clear();
    	
    	status = "";
    	
    	if(!memberTable.getSelectionModel().isEmpty()) {
    		MyMemberVO mv = memberTable.getSelectionModel().getSelectedItem();
			
			if(mv!=null) {
				tfMemId.setText(mv.getMem_id());
				tfMemName.setText(mv.getMem_name());
				tfMemHp.setText(mv.getMem_tel());
				tfMemAddr.setText(mv.getMem_addr());
			}
		}
    }

        
    private IMyMemberService myMember;
    
    //테이블에 출력하기위해서
    ObservableList<MyMemberVO> memList = FXCollections.observableArrayList();
    
    
    @FXML
    void initialize() {
		assert tfMemId != null : "fx:id=\"tfMemId\" was not injected: check your FXML file 'MyMember.fxml'.";
		assert tfMemName != null : "fx:id=\"tfMemName\" was not injected: check your FXML file 'MyMember.fxml'.";
		assert tfMemHp != null : "fx:id=\"tfMemHp\" was not injected: check your FXML file 'MyMember.fxml'.";
		assert tfMemAddr != null : "fx:id=\"tfMemAddr\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnChk != null : "fx:id=\"btnChk\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert memberTable != null : "fx:id=\"memberTable\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert hpCol != null : "fx:id=\"hpCol\" was not injected: check your FXML file 'MyMember.fxml'.";
        assert add1Col != null : "fx:id=\"add1Col\" was not injected: check your FXML file 'MyMember.fxml'.";        
        
        myMember = MyMemberServiceImpl.getInstance();
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
        hpCol.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
        add1Col.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
        
        memList.addAll(myMember.getSearchAllMember());
        memberTable.setItems(memList);
        
        memberTable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				MyMemberVO  mv = memberTable.getSelectionModel().getSelectedItem();
				
				if(mv!=null) {
					tfMemId.setText(mv.getMem_id());
					tfMemName.setText(mv.getMem_name());
					tfMemHp.setText(mv.getMem_tel());
					tfMemAddr.setText(mv.getMem_addr());
				}
			}
		});
        
    }
    
    
    //정보 출력하는 Alert창 메서드
  	public void info(String header, String msg) {
  		Alert alertInfo = new Alert(AlertType.INFORMATION);
  		alertInfo.setTitle("정보확인");
  		alertInfo.setHeaderText(header);
  		alertInfo.setContentText(msg);
  		alertInfo.showAndWait();
  	}      
 
    //경고창
  	public void alert(String header, String msg) {
  		Alert alert = new Alert(AlertType.WARNING);
  		alert.setTitle("경고");
  		alert.setHeaderText(header);
  		alert.setContentText(msg);
  		alert.showAndWait();
  	}
  	
	//Confirm창
	public boolean confirm(String header, String msg) {
		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.setTitle("선택");
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
