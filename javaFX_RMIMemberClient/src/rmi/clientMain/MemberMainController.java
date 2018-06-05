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
	    
	    // ���̺� �信 ������ �����Ͱ� ����� List
	    private ObservableList<MemberVO> data;
	    
	    private IMemberService service;
	    
	    private String strWork = "";  // �߰���ư, ������ư Ȯ�ο�

	    
	    // �߰�
	    @FXML
	    void dataAdd(ActionEvent event) {
	    	txtId.setEditable(true);  // ���� ���� ���·� �����.
	    	txtName.setEditable(true);
	    	txtTel.setEditable(true);
	    	txtAddr.setEditable(true);
	    	
	    	btnOk.setDisable(false);  // Ȱ��ȭ
	    	btnCancel.setDisable(false);
	    	
	    	btnAdd.setDisable(true);  // ��Ȱ��ȭ
	    	btnEdit.setDisable(true);
	    	btnDel.setDisable(true);
	    	
	    	table.setDisable(true);  // ���̺�� ��Ȱ��ȭ
	    	
	    	txtId.clear();  // TextField�� ���� ����
	    	txtName.clear();
	    	txtTel.clear();
	    	txtAddr.clear();
	    	
	    	strWork = "Insert";
	    	
	    	txtId.requestFocus();  // ��Ŀ�� �ֱ�
	    }

	    // ����
	    @FXML
	    void dataDel(ActionEvent event) throws RemoteException {
	    	if(table.getSelectionModel().getSelectedItem()==null) {
	    		alert("���ÿ���", "������ �ڷḦ �����ϼ���.");
	    		return;
	    	}
	    	
	    	if(confirm("�۾�����", "������ �����Ͻðڽ��ϱ�?")) {
	    		
	    		// ���� ������ �ڷ� �� ȸ��ID�� ���ϱ�
	    		String memId = table.getSelectionModel().getSelectedItem().getMem_id();
	    		int index = table.getSelectionModel().getSelectedIndex();
	    		
	    		int cnt = service.deleteMember(memId);
	    		if(cnt>0) { // DB���� �����۾� ����
	    			info("�۾����", memId + "�� �����߽��ϴ�.");
	    			data.remove(index);  // ���̺���� ������ ����
	    			txtId.clear();
	    			txtName.clear();
	    			txtTel.clear();
	    			txtAddr.clear();
	    		}else {
	    			alert("�۾����", "�����۾� ����~~");
	    		}
	    	}
	    }

	    // ����
	    @FXML
	    void dataEdit(ActionEvent event) {
	    	if(table.getSelectionModel().getSelectedItem()==null) {
	    		alert("�����۾�����", "������ �����͸� �����ϼ���");
	    		return;
	    	}
	    	
	    	txtId.setEditable(false);  
	    	txtName.setEditable(true); // ���� ���� ���·� �����.
	    	txtTel.setEditable(true);
	    	txtAddr.setEditable(true);
	    	
	    	btnOk.setDisable(false);  // Ȱ��ȭ
	    	btnCancel.setDisable(false);
	    	
	    	btnAdd.setDisable(true);  // ��Ȱ��ȭ
	    	btnEdit.setDisable(true);
	    	btnDel.setDisable(true);
	    	
	    	table.setDisable(true);  // ���̺�� ��Ȱ��ȭ
	    	
	    	strWork = "Edit";
	    	
	    	txtName.requestFocus();  // ��Ŀ�� �ֱ�
	    	
	    }

	    // Ȯ��
	    @FXML
	    void dataRun(ActionEvent event) throws RemoteException {
	    	if("Insert".equals(strWork)) {  //�߰� �۾�
	    		if(txtId.getText().isEmpty()) {
	    			alert("�Է¿���", "ȸ��ID�� �Է��ϼ���.");
	    			txtId.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtName.getText().isEmpty()) {
	    			alert("�Է¿���", "ȸ���̸��� �Է��ϼ���.");
	    			txtName.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtTel.getText().isEmpty()) {
	    			alert("�Է¿���", "��ȭ��ȣ�� �Է��ϼ���.");
	    			txtTel.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtAddr.getText().isEmpty()) {
	    			alert("�Է¿���", "�ּҸ� �Է��ϼ���.");
	    			txtAddr.requestFocus();
	    			return;
	    		}
	    		
	    		// ȸ��ID �ߺ� �˻�
	    		if(service.getCountMember(txtId.getText())>0) {
	    			alert("�Է¿���", "ȸ��ID�� �ߺ��˴ϴ�.\nȸ��ID�� �ٽ��Է��ϼ���");
	    			txtId.requestFocus();
	    			return;
	    		}
	    		
	    		MemberVO mvo = new MemberVO();
	    		mvo.setMem_id(txtId.getText());
	    		mvo.setMem_name(txtName.getText());
	    		mvo.setMem_tel(txtTel.getText());
	    		mvo.setMem_addr(txtAddr.getText());
	    		
	    		int cnt = service.insertMember(mvo); 
	    		if(cnt>0) { // DB�� ������ �߰� ����
	    			data.add(mvo);   // ���̺���� �ڷ� ����
	    			info("�۾�����", "������ �߰� �۾� ����!!!");
	    			txtId.clear();
	    			txtName.clear();
	    			txtTel.clear();
	    			txtAddr.clear();
	    		}else {  // DB�� ������ �߰� �۾� ����
	    			alert("�߰�����", "������ �߰� �۾� ����~~");
	    		}
	    		
	    		
	    		
	    	}else if("Edit".equals(strWork)) {  // �����۾�
	    		if(txtName.getText().isEmpty()) {
	    			alert("�Է¿���", "ȸ���̸��� �Է��ϼ���.");
	    			txtName.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtTel.getText().isEmpty()) {
	    			alert("�Է¿���", "��ȭ��ȣ�� �Է��ϼ���.");
	    			txtTel.requestFocus();
	    			return;
	    		}
	    		
	    		if(txtAddr.getText().isEmpty()) {
	    			alert("�Է¿���", "�ּҸ� �Է��ϼ���.");
	    			txtAddr.requestFocus();
	    			return;
	    		}
	    		
	    		MemberVO mvo = new MemberVO();
	    		mvo.setMem_id(txtId.getText());
	    		mvo.setMem_name(txtName.getText());
	    		mvo.setMem_tel(txtTel.getText());
	    		mvo.setMem_addr(txtAddr.getText());
	    		
	    		int cnt = service.updateMember(mvo);
	    		
	    		if(cnt>0) { // DB�� Update ����
	    			int index = table.getSelectionModel().getSelectedIndex();
	    			data.set(index, mvo);  // ���̺�� ������ ����
	    			
	    			info("�۾�����", "������ ���� �۾� ����!!!");
	    		}else {
	    			alert("�۾�����", "������ ���� �۾� ����~~");
	    		}
	    	} //
	    	
	    	
	    	// �߰� �Ǵ� ���� �۾� �Ϸ� �� ���� ���·�...
	    	
	    	txtId.setEditable(false);  // ���� �Ұ��� ���·� �����.
	    	txtName.setEditable(false);
	    	txtTel.setEditable(false);
	    	txtAddr.setEditable(false);
	    	
	    	btnOk.setDisable(true);  // ��Ȱ��ȭ
	    	btnCancel.setDisable(true);
	    	
	    	btnAdd.setDisable(false);  // Ȱ��ȭ
	    	btnEdit.setDisable(false);
	    	btnDel.setDisable(false);
	    	
	    	table.setDisable(false);  // ���̺�� Ȱ��ȭ
	    	
	    	strWork = "";
	    	
	    }
	    
	    // ���
	    @FXML
	    void dataCancel(ActionEvent event) {
	    	txtId.setEditable(false);  // ���� �Ұ��� ���·� �����.
	    	txtName.setEditable(false);
	    	txtTel.setEditable(false);
	    	txtAddr.setEditable(false);
	    	
	    	btnOk.setDisable(true);  // ��Ȱ��ȭ
	    	btnCancel.setDisable(true);
	    	
	    	btnAdd.setDisable(false);  // Ȱ��ȭ
	    	btnEdit.setDisable(false);
	    	btnDel.setDisable(false);
	    	
	    	table.setDisable(false);  // ���̺�� Ȱ��ȭ
	    	
	    	
	    	
	    	strWork = "";
	    }

	    // ���̺�� Ŭ��
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
	        
	        // Service��ü ����
	        //service = MemberService.getInstance();
	        
	        try {
				Registry reg = LocateRegistry.getRegistry("localhost", 9988);
				service = (IMemberService) reg.lookup("member");
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
	        
	        
	        
	        // ���̺���� �� �÷� ����
	        idCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
	        nameCol.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
	        telCol.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
	        addrCol.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
	        
	        // DB���� �ڷḦ ��������
	        List<MemberVO> memList = service.getAllMember();
	        data = FXCollections.observableArrayList(memList);
	        
	        table.setItems(data);
	        

	    }
	    
	    // alertâ
	    public void alert(String head, String msg) {
	    	Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("���");
	    	alert.setHeaderText(head);
	    	alert.setContentText(msg);
	    	alert.showAndWait();
	    }
	    
	    // informationâ
	    public void info(String head, String msg) {
	    	Alert info = new Alert(AlertType.INFORMATION);
	    	info.setTitle("����");
	    	info.setHeaderText(head);
	    	info.setContentText(msg);
	    	info.showAndWait();
	    }
	    
	    // confirmationâ
	    // �޽���â���� 'Ȯ��'��ư ������ true, 
	    //    '���'��ư ������ false�� ��ȯ�ϴ� �޼���
	    public boolean confirm(String head, String msg) {
	    	Alert confirm = new Alert(AlertType.CONFIRMATION);
	    	confirm.setTitle("����");
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
