package basic.controlTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableViewTest extends Application {
	private String status = "";

	@Override
	public void start(Stage primaryStage) {
		ObservableList<Member> data = 
			FXCollections.observableArrayList(
				new Member("ȫ�浿", "gildong", 33, "010-1234-5678", "����"),
				new Member("ȫ�漭", "gilseo", 43, "010-2222-2222", "����"),
				new Member("ȫ�泲", "gilnam", 23, "010-4545-6767", "����"),
				new Member("ȫ���", "gilbook", 53, "010-7788-0909", "����")
			);
		
		BorderPane root = new BorderPane();
		
		// TableView��ü ���� �� ����� ������ �����ϱ�
		TableView<Member> table = new TableView<Member>(data);
		
		//TableView<Member> table = new TableView<Member>();
		//table.setItems(data);
		
		//--------------------------------------------
		
		// �� �÷� ���� �� ����
		
		// �÷� ����
		TableColumn<Member, String> korNameCol =
				new TableColumn<Member, String>("�ѱ�");
		
		// �÷��� ������ ����
		korNameCol.setCellValueFactory(
			// VO��ü���� ���� ����� �����Ͱ� ����� �������
			// �÷��� ������ �ش�.
			new PropertyValueFactory<Member, String>("korName")
		);
		
		//----
		TableColumn<Member, String> engNameCol =
				new TableColumn<Member, String>("����");
		
		engNameCol.setCellValueFactory(
			new PropertyValueFactory<Member, String>("engName")
		);
		
		
		TableColumn<Member, String> nameCol =
				new TableColumn<Member, String>("�̸�");
		// nameCol �÷��� korNameCol�� engNameCol�� �߰��Ѵ�.
		nameCol.getColumns().addAll(korNameCol, engNameCol);
		
		
		
		//----
		TableColumn<Member, Integer> ageCol =
				new TableColumn<Member, Integer>("����");
		
		ageCol.setCellValueFactory(
			new PropertyValueFactory<Member, Integer>("age")
		);
		
		//----
		TableColumn<Member, String> telCol =
				new TableColumn<Member,String>("��ȭ��ȣ");
		telCol.setCellValueFactory(
			new PropertyValueFactory<Member, String>("tel")
		);
		
		//----
		TableColumn<Member, String> addrCol = 
				new TableColumn<Member, String>("�ּ�");
		addrCol.setCellValueFactory(
			new PropertyValueFactory<Member, String>("addr")
		);
		addrCol.setPrefWidth(100); // �÷��� �ʺ� ����
		
		//------------------------------------------------
		// ������ �÷����� ���̺� �߰��Ѵ�.
		//table.getColumns().addAll(korNameCol, engNameCol, 
		//		ageCol, telCol, addrCol);
		table.getColumns().addAll(nameCol, ageCol, telCol, addrCol);
		
		//=======================================================
		GridPane grid = new GridPane();
		Text txt1 = new Text("�ѱ��̸�");
		Text txt2 = new Text("�����̸�");
		Text txt3 = new Text("��  ��");
		Text txt4 = new Text("��ȭ��ȣ");
		Text txt5 = new Text("��  ��");
		
		TextField tfKorName = new TextField();
		TextField tfEngName = new TextField();
		TextField tfAge = new TextField();
		TextField tfTel = new TextField();
		TextField tfAddr = new TextField();
		
		grid.add(txt1, 1, 1);
		grid.add(txt2, 2, 1);
		grid.add(txt3, 3, 1);
		grid.add(txt4, 4, 1);
		grid.add(txt5, 5, 1);
		
		grid.add(tfKorName, 1, 2);
		grid.add(tfEngName, 2, 2);
		grid.add(tfAge, 3, 2);
		grid.add(tfTel, 4, 2);
		grid.add(tfAddr, 5, 2);
		
		grid.setVgap(10);
		grid.setHgap(5);
		//===========================================
		VBox vbox = new VBox(5);
		vbox.setPadding(new Insets(5));
		
		Button btnAdd = new Button("�߰�");
		Button btnEdit = new Button("����");
		Button btnDel = new Button("����");
		Button btnOk = new Button("Ȯ��");
		Button btnCancel = new Button("���");
		
		vbox.getChildren().addAll(btnAdd, btnEdit, btnDel, btnOk, btnCancel);
		//=============================================
		
		
		tfKorName.setEditable(false); // ������ ���� �Ұ�
		//tfKorName.setEditable(true);  // ������ ���� ����
		
		tfEngName.setEditable(false);
		tfAge.setEditable(false);
		tfTel.setEditable(false);
		tfAddr.setEditable(false);
		
		
		btnOk.setDisable(true);  // ��Ʈ�Ѱ�ü�� ��Ȱ��ȭ �Ѵ�.
		//btnOk.setDisable(false); // ��Ʈ�Ѱ�ü�� Ȱ��ȭ �Ѵ�.
		btnCancel.setDisable(true); 
		
		
		// TableView�� Ŭ������ �� ó��
		table.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// ������ ��ü ���ϱ�
				Member m = table.getSelectionModel().getSelectedItem();
				if(m!=null) {
					// ������ TextField�� ����ϱ�
					tfKorName.setText(m.getKorName());
					tfEngName.setText(m.getEngName());
					//  ������ �ڷ�� ���ڿ��� ��ȯ�ؼ� ���
					tfAge.setText(String.valueOf( m.getAge())  );
					tfTel.setText(m.getTel());
					tfAddr.setText(m.getAddr());
				}
			}
		});
		
		
		// ������ �߰��ϱ�
		// TextField�� �Է��� �ڷ���� TableView�� �߰��ϱ�
		btnAdd.setOnAction(e->{
			
			tfKorName.setEditable(true);
			tfEngName.setEditable(true);
			tfAge.setEditable(true);
			tfTel.setEditable(true);
			tfAddr.setEditable(true);
			
			tfKorName.clear();
			tfEngName.clear();
			tfAge.clear();
			tfTel.clear();
			tfAddr.clear();
			
			tfKorName.requestFocus();
			
			btnAdd.setDisable(true);
			btnEdit.setDisable(true);
			btnDel.setDisable(true);
			
			btnOk.setDisable(false);
			btnCancel.setDisable(false);
			status = "ADD";
			
			
			/*
			
			*/
		});
		
		
		
		// ������ �����ϱ�
		btnEdit.setOnAction(e->{
			
			// ���̺� �信�� ������ �ڷᰡ �ִ��� �˻�
			if(table.getSelectionModel().isEmpty()) { // ������ �׸��� ������...
				alert("���ÿ���", "������ �����͸� ������ �� �����ϼ���.");
				return;
			}
			
			//tfKorName.setEditable(true);
			tfEngName.setEditable(true);
			tfAge.setEditable(true);
			tfTel.setEditable(true);
			tfAddr.setEditable(true);
			
			tfEngName.requestFocus();
			
			btnAdd.setDisable(true);
			btnEdit.setDisable(true);
			btnDel.setDisable(true);
			
			btnOk.setDisable(false);
			btnCancel.setDisable(false);
			
			status = "EDIT";
			
			
			/*
			
			*/
		});
		
		
		// ������ ����
		btnDel.setOnAction(e->{
			if(table.getSelectionModel().isEmpty()) {
				alert("���ÿ���", "������ �ڷḦ ������ �� �����ϼ���.");
				return;
			}
			
			String name = table.getSelectionModel().getSelectedItem().getKorName();
			
			if(confirm("��������", name + "�� ������ ������ �����ұ��?")) {
			
				data.remove(
					table.getSelectionModel().getSelectedIndex()	
				);
				
				info("�۾�����", name + "�� ������ �����߽��ϴ�.");
				
			}else {
				info("�۾����", "�����۾��� ��� �Ǿ����ϴ�.");
			}
			
			tfKorName.clear();
			tfEngName.clear();
			tfAge.clear();
			tfTel.clear();
			tfAddr.clear();
			
			
		});
		
		
		// ��ҹ�ư
		btnCancel.setOnAction(e->{
			tfKorName.setEditable(false);
			tfEngName.setEditable(false);
			tfAge.setEditable(false);
			tfTel.setEditable(false);
			tfAddr.setEditable(false);
			
			btnOk.setDisable(true);
			btnCancel.setDisable(true);
			btnAdd.setDisable(false);
			btnEdit.setDisable(false);
			btnDel.setDisable(false);
			
			status = "";
			
			if(!table.getSelectionModel().isEmpty()) {
				Member m = table.getSelectionModel().getSelectedItem();
				
				if(m!=null) {
					// ������ TextField�� ����ϱ�
					tfKorName.setText(m.getKorName());
					tfEngName.setText(m.getEngName());
					//  ������ �ڷ�� ���ڿ��� ��ȯ�ؼ� ���
					tfAge.setText(String.valueOf( m.getAge())  );
					tfTel.setText(m.getTel());
					tfAddr.setText(m.getAddr());
				}
			}
			
		});
		
		// Ȯ�� ��ư
		btnOk.setOnAction(e->{
			if("ADD".equals(status)) {  // �߰� �۾�
				
				if(tfKorName.getText().isEmpty()) {
					alert("�Է¿���","�ѱ��̸��� �Է��ϼ���");
					tfKorName.requestFocus();
					return;
				}
				if(tfEngName.getText().isEmpty()) {
					alert("�Է¿���","�����̸��� �Է��ϼ���");
					tfEngName.requestFocus();
					return;
				}
				if(tfAge.getText().isEmpty()) {
					alert("�Է¿���","���̸� �Է��ϼ���");
					tfAge.requestFocus();
					return;
				}
				if(tfTel.getText().isEmpty()) {
					alert("�Է¿���","��ȭ��ȣ�� �Է��ϼ���");
					tfTel.requestFocus();
					return;
				}
				if(tfAddr.getText().isEmpty()) {
					alert("�Է¿���","�ּҸ� �Է��ϼ���");
					tfAddr.requestFocus();
					return;
				}
				
				data.add(
					new Member(
						tfKorName.getText(), 
						tfEngName.getText(), 
						Integer.parseInt(tfAge.getText()), 
						tfTel.getText(), 
						tfAddr.getText())
				);
				
				String name = tfKorName.getText();
				
				tfKorName.clear();
				tfEngName.clear();
				tfAge.clear();
				tfTel.clear();
				tfAddr.clear();
				
				
				info("�۾�����", name + "�� ���� �߰� ����!!");
				
				
			}else if("EDIT".equals(status)) { // ���� �۾�
				
				if(tfKorName.getText().isEmpty()) {
					alert("�Է¿���","�ѱ��̸��� �Է��ϼ���");
					tfKorName.requestFocus();
					return;
				}
				if(tfEngName.getText().isEmpty()) {
					alert("�Է¿���","�����̸��� �Է��ϼ���");
					tfEngName.requestFocus();
					return;
				}
				if(tfAge.getText().isEmpty()) {
					alert("�Է¿���","���̸� �Է��ϼ���");
					tfAge.requestFocus();
					return;
				}
				if(tfTel.getText().isEmpty()) {
					alert("�Է¿���","��ȭ��ȣ�� �Է��ϼ���");
					tfTel.requestFocus();
					return;
				}
				if(tfAddr.getText().isEmpty()) {
					alert("�Է¿���","�ּҸ� �Է��ϼ���");
					tfAddr.requestFocus();
					return;
				}
				
				// �ڷ� ���� �۾�
				data.set(
					// ������ �������� index�� ���ϱ�
					table.getSelectionModel().getSelectedIndex(), 
					new Member(
							tfKorName.getText(), 
							tfEngName.getText(), 
							Integer.parseInt(tfAge.getText()), 
							tfTel.getText(), 
							tfAddr.getText())
				);
				
				String name = tfKorName.getText();
				
				tfKorName.clear();
				tfEngName.clear();
				tfAge.clear();
				tfTel.clear();
				tfAddr.clear();
				
				info("�۾�����", name +"�� ������ �����Ǿ����ϴ�.");
				
				
				
			}else {
				alert("�۾� ����", "�۾� ���� ����");
			}
			
			
			
			tfKorName.setEditable(false);
			tfEngName.setEditable(false);
			tfAge.setEditable(false);
			tfTel.setEditable(false);
			tfAddr.setEditable(false);
			
			btnOk.setDisable(true);
			btnCancel.setDisable(true);
			btnAdd.setDisable(false);
			btnEdit.setDisable(false);
			btnDel.setDisable(false);
			
			status = "";
			
			if(!table.getSelectionModel().isEmpty()) {
				Member m = table.getSelectionModel().getSelectedItem();
				
				if(m!=null) {
					// ������ TextField�� ����ϱ�
					tfKorName.setText(m.getKorName());
					tfEngName.setText(m.getEngName());
					//  ������ �ڷ�� ���ڿ��� ��ȯ�ؼ� ���
					tfAge.setText(String.valueOf( m.getAge())  );
					tfTel.setText(m.getTel());
					tfAddr.setText(m.getAddr());
				}
			}
			
			
			
			
		});
		
		
		
		//======================================
		root.setCenter(table);
		root.setBottom(grid);
		root.setRight(vbox);
		root.setMaxSize(450, 400);  // �ִ� ũ�� ����
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("TableView ����");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	// ���� ����ϴ� Alertâ �޼���
	public void info(String header, String msg) {
		Alert alertInfo = new Alert(AlertType.INFORMATION);
		alertInfo.setTitle("����Ȯ��");
		alertInfo.setHeaderText(header);
		alertInfo.setContentText(msg);
		alertInfo.showAndWait();
	}
	
	// ���â
	public void alert(String header, String msg) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("���");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	// Confirmâ
	public boolean confirm(String header, String msg) {
		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.setTitle("����");
		confirm.setHeaderText(header);
		confirm.setContentText(msg);
		
		ButtonType conResult = confirm.showAndWait().get();
		
		boolean result = false;
		
		if(conResult==ButtonType.OK) {
			result = true;
		}else if(conResult==ButtonType.CANCEL) {
			result = false;
		}
		
		return result;
	}
	
	
	
	
	
	
	// TableView�� ����� VOŬ���� �ۼ�
	public class Member{
		private String korName;
		private String engName;
		private int age;
		private String tel;
		private String addr;
		
		// ������
		public Member(String korName, String engName, int age, String tel, String addr) {
			super();
			this.korName = korName;
			this.engName = engName;
			this.age = age;
			this.tel = tel;
			this.addr = addr;
		}

		public String getKorName() {
			return korName;
		}

		public void setKorName(String korName) {
			this.korName = korName;
		}

		public String getEngName() {
			return engName;
		}

		public void setEngName(String engName) {
			this.engName = engName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}
		
		// getter, setter
		
		
		
	}
	
	
}















