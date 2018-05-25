package basic.controlTest;

import basic.controlTest.ComboBoxTest2.MyFriend;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComboBoxTest2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));
		
		ComboBox<MyFriend> combo = new ComboBox<MyFriend>();
		
		TextArea txtResult = new TextArea();
		
		ObservableList<MyFriend> list = FXCollections.observableArrayList(
			new MyFriend("aaa", "ȫ�浿", "010-1111-1111", "����"),
			new MyFriend("bbb", "�̼���", "010-2222-2222", "��õ"),
			new MyFriend("ccc", "���е�", "010-3333-3333", "����"),
			new MyFriend("ddd", "������", "010-4444-4444", "�λ�"),
			new MyFriend("eee", "������", "010-5555-5555", "���"),
			new MyFriend("fff", "�̸���", "010-6666-6666", "����")
		);
		
		combo.setItems(list); // ���3
		
		// �޺��ڽ��� �������� ����� �������� ���� ������
		// �ٸ��� ��Ÿ���� ���
		// �� ������� ����� ������ ���κи� ����ȴ�.
		combo.setCellFactory(
			new Callback<ListView<MyFriend>, ListCell<MyFriend>>() {
				
				@Override
				public ListCell<MyFriend> call(ListView<MyFriend> param) {
					return new ListCell<MyFriend>() {
						protected void updateItem(MyFriend item, boolean empty) {
							super.updateItem(item, empty);
							if(item==null || empty) { // �ڷᰡ ������..
								setText(null);
							}else {
								setText(item.getId()+ "(" + item.getName() + ")");
							}
						}
					};
				}
			}
		);
		
		//---------------------------------------
		
		// �޺��ڽ����� �׸��� �����ϸ� ���õ� ������ �޺��ڽ��� 
		// ��ư ������ ��Ÿ���µ� �� �κе� ���� ������ �־�� �Ѵ�.
		combo.setButtonCell(new ListCell<MyFriend>() {
			@Override
			protected void updateItem(MyFriend item, boolean empty) {
				super.updateItem(item, empty);
				if(item==null || empty) { // �ڷᰡ ������..
					setText(null);
				}else {
					setText(item.getId()+ "(" + item.getName() + ")");
				}
			}
		});
		
		//----------------------------------------
		
		HBox hbox = new HBox(10);
		Button btn = new Button("Ȯ��");
		
		// ���ٽ����� �̺�Ʈ ó��
		btn.setOnAction(e->{
			MyFriend selData;
			// ���õ� ������ ���ϱ�
			
			// ��� 1
			//selData = combo.getValue();
			
			// ���2
			selData = combo.getSelectionModel().getSelectedItem();
			
			if(selData!=null) {
				txtResult.setText("ID : " + selData.getId() + "\n");
				txtResult.appendText("�̸� : " + selData.getName() + "\n");
				txtResult.appendText("��ȭ : " + selData.getTel() + "\n");
				txtResult.appendText("�ּ� : " + selData.getAddr());
			}
			
		});
		
		
		
		hbox.getChildren().addAll(combo, btn);
		
		vbox.getChildren().addAll(hbox, txtResult);
		
		Scene scene = new Scene(vbox, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("�޺� ����2");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	// VO������ ��ü�� InnerClass�� ����
	class MyFriend{
		private String id;
		private String name;
		private String tel;
		private String addr;
		
		// ������
		public MyFriend(String id, String name, String tel, String addr) {
			super();
			this.id = id;
			this.name = name;
			this.tel = tel;
			this.addr = addr;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
		
		
		
		
	}
}






