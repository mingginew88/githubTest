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
			new MyFriend("aaa", "홍길동", "010-1111-1111", "대전"),
			new MyFriend("bbb", "이순신", "010-2222-2222", "인천"),
			new MyFriend("ccc", "변학도", "010-3333-3333", "광주"),
			new MyFriend("ddd", "일지매", "010-4444-4444", "부산"),
			new MyFriend("eee", "성춘향", "010-5555-5555", "울산"),
			new MyFriend("fff", "이몽룡", "010-6666-6666", "포항")
		);
		
		combo.setItems(list); // 방법3
		
		// 콤보박스의 데이터의 목록이 보여지는 곳의 내용을
		// 다르게 나타내는 방법
		// 이 방법으로 변경된 내용은 셀부분만 변경된다.
		combo.setCellFactory(
			new Callback<ListView<MyFriend>, ListCell<MyFriend>>() {
				
				@Override
				public ListCell<MyFriend> call(ListView<MyFriend> param) {
					return new ListCell<MyFriend>() {
						protected void updateItem(MyFriend item, boolean empty) {
							super.updateItem(item, empty);
							if(item==null || empty) { // 자료가 없으면..
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
		
		// 콤보박스에서 항목을 선택하면 선택된 내용이 콤보박스의 
		// 버튼 영역에 나타나는데 이 부분도 같이 변경해 주어야 한다.
		combo.setButtonCell(new ListCell<MyFriend>() {
			@Override
			protected void updateItem(MyFriend item, boolean empty) {
				super.updateItem(item, empty);
				if(item==null || empty) { // 자료가 없으면..
					setText(null);
				}else {
					setText(item.getId()+ "(" + item.getName() + ")");
				}
			}
		});
		
		//----------------------------------------
		
		HBox hbox = new HBox(10);
		Button btn = new Button("확인");
		
		// 람다식으로 이벤트 처리
		btn.setOnAction(e->{
			MyFriend selData;
			// 선택된 데이터 구하기
			
			// 방법 1
			//selData = combo.getValue();
			
			// 방법2
			selData = combo.getSelectionModel().getSelectedItem();
			
			if(selData!=null) {
				txtResult.setText("ID : " + selData.getId() + "\n");
				txtResult.appendText("이름 : " + selData.getName() + "\n");
				txtResult.appendText("전화 : " + selData.getTel() + "\n");
				txtResult.appendText("주소 : " + selData.getAddr());
			}
			
		});
		
		
		
		hbox.getChildren().addAll(combo, btn);
		
		vbox.getChildren().addAll(hbox, txtResult);
		
		Scene scene = new Scene(vbox, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("콤보 연습2");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	// VO역할의 객체를 InnerClass로 선언
	class MyFriend{
		private String id;
		private String name;
		private String tel;
		private String addr;
		
		// 생성자
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






