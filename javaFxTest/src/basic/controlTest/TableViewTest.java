package basic.controlTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
		
		ObservableList<Member> data = FXCollections.observableArrayList(
				new Member("홍길동", "gildong", 33, "010-1234-5678", "대전"),
				new Member("홍길서", "gilseo", 43, "010-2222-2222", "대구"),
				new Member("홍길남", "gilnam", 13, "010-3333-3333", "부산"),
				new Member("홍길북", "gilbook", 23, "010-6666-6666", "서울")
		);
		
		BorderPane root = new BorderPane();
		
		//TableView객체 생성 및 출력할 데이터 셋팅하기
		TableView<Member> table = new TableView<Member>(data);
		
		//TableView<Member> table = new TableView<Member>();
		//table.setItems(data);
		//-----------------------------------------------------------
		
		//각 칼럼 생성 및 설정		
		TableColumn<Member, String> korNameCol = new TableColumn<Member, String>("한글");
		
		//칼럼에 데이터 매핑
		korNameCol.setCellValueFactory(
				//VO객체에서 실제 출력할 데이터가 저장된 변수명과 컬럼을 매핑해준다.
				new PropertyValueFactory<Member, String>("korName")
		);
		
		
		TableColumn<Member, String> engNameCol = new TableColumn<Member, String>("영문");
		
		engNameCol.setCellValueFactory(
				//VO객체에서 실제 출력할 데이터가 저장된 변수명과 컬럼을 매핑해준다.
				new PropertyValueFactory<Member, String>("engName")
		);
		
		
		TableColumn<Member, String> nameCol = new TableColumn<Member, String>("이름");
		//nameCol컬럼에 korNameCol과 engNameCol을 추가한다.
		nameCol.getColumns().addAll(korNameCol, engNameCol);
		
		
		TableColumn<Member, Integer> ageCol = new TableColumn<Member, Integer>("나이");
		ageCol.setCellValueFactory(new PropertyValueFactory<Member, Integer>("age"));
		
		
		TableColumn<Member, String> telCol = new TableColumn<Member, String>("전화");
		telCol.setCellValueFactory(new PropertyValueFactory<Member, String>("tel"));
		
		
		TableColumn<Member, String> addrCol = new TableColumn<Member, String>("주소");
		addrCol.setCellValueFactory(new PropertyValueFactory<Member, String>("addr"));
		addrCol.setPrefWidth(100);
		
		//-----------------------------------------------------------
		//생성된 컬럼들을 테이블에 추가한다.
		table.getColumns().addAll(nameCol, ageCol, telCol, addrCol);
		
		
		
		//-----------------------------------------------------------
		GridPane grid = new GridPane();
		Text txt1 = new Text("한글이름");
		Text txt2 = new Text("영문이름");
		Text txt3 = new Text("나  이");
		Text txt4 = new Text("전화번호");
		Text txt5 = new Text("주  소");
		
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
		//-----------------------------------------------------------
		
		VBox vbox = new VBox(5);
		vbox.setPadding(new Insets(5));
		
		Button btnAdd = new Button("추가");
		Button btnEdit = new Button("수정");
		Button btnDel = new Button("삭제");
		Button btnOk = new Button("확인");
		Button btnCancel = new Button("취소");
		
		vbox.getChildren().addAll(btnAdd, btnEdit, btnDel, btnOk, btnCancel);
		//-----------------------------------------------------------
		
		tfKorName.setEditable(false); 	//데이터변경 불가
		tfEngName.setEditable(false); 	//데이터변경 불가
		tfAge.setEditable(false); 		//데이터변경 불가
		tfTel.setEditable(false); 		//데이터변경 불가
		tfAddr.setEditable(false); 		//데이터변경 불가
//		tfKorName.setEditable(true);  	//데이터변경 가능
		
		btnOk.setDisable(true); //컨트롤객체를 비활성화 한다.
//		btnOk.setDisable(false); //컨트롤객체를 활성화 한다.
		btnCancel.setDisable(true);	//비활성화
//		btnCancel.setDisable(false);	//활성화
		
		
		//TableView를 클릭했을 때 처리
		table.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				//선택한 객체 구하기
				Member m = table.getSelectionModel().getSelectedItem();
				if(m!=null) {
					//각각의 TextField에 출력하기
					tfKorName.setText(m.getKorName());
					tfEngName.setText(m.getEngName());
					tfAge.setText(String.valueOf(m.getAge()));
					tfTel.setText(m.getTel());
					tfAddr.setText(m.getAddr());
				}				
			}
		});
		
		//데이터 추가하기
		//TextField에 입력한 자료들을 TableView에 추가하기
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
			
			status = "add";
					
		});
		
		
		//데이터 수정하기
		btnEdit.setOnAction(e->{
			tfKorName.setEditable(true);
			tfEngName.setEditable(true);
			tfAge.setEditable(true);
			tfTel.setEditable(true);
			tfAddr.setEditable(true);
			
			btnAdd.setDisable(true);
			btnEdit.setDisable(true);
			btnDel.setDisable(true);
			btnOk.setDisable(false);
			btnCancel.setDisable(false);
			
			status = "edit";
			
			if(table.getSelectionModel().isEmpty()) {
				alert("선택오류","수정할 데이터를 선택해 수행해주세요.");
				return;
			}		
			
		});
		
		
		btnDel.setOnAction(e->{
			if(table.getSelectionModel().isEmpty()) {	//선택한항목이없으면...
				alert("선택오류","삭제할 데이터를 선택해 수행해주세요.");
				return;
			}
			
			String name = table.getSelectionModel().getSelectedItem().getKorName();
			
			if(confirm("삭제요청", name+ "씨 정보를 정말로 삭제하시겠습니까?")) {
				data.remove(table.getSelectionModel().getSelectedItem());				
				info("작업성공", name + "씨 정보 삭제 성공!!");
			} else {
				info("작업취소", "삭제작업이 취소되었습니다.");
			}
			
			tfKorName.clear();
			tfEngName.clear();
			tfAge.clear();
			tfTel.clear();
			tfAddr.clear();
		});
		
		
		btnOk.setOnAction(e->{
			if("add".equals(status)) {
				if(tfKorName.getText().isEmpty()) {
					alert("입력오류","한글이름을 입력하세요.");
					tfKorName.requestFocus();
					return;
				}
				
				if(tfEngName.getText().isEmpty()) {
					alert("입력오류","영문이름을 입력하세요.");
					tfEngName.requestFocus();
					return;
				}
				
				if(tfAge.getText().isEmpty()) {
					alert("입력오류","나이를 입력하세요.");
					tfAge.requestFocus();
					return;
				}
				
				if(tfTel.getText().isEmpty()) {
					alert("입력오류","전화번호를 입력하세요.");
					tfTel.requestFocus();
					return;
				}
				
				if(tfAddr.getText().isEmpty()) {
					alert("입력오류","주소를 입력하세요.");
					tfAddr.requestFocus();
					return;
				}	
				
				data.add(
					new Member(tfKorName.getText(),
							tfEngName.getText(),
							Integer.parseInt(tfAge.getText()),
							tfTel.getText(),
							tfAddr.getText()
					)
				);
				
				String name = tfKorName.getText();
				
				tfKorName.clear();
				tfEngName.clear();
				tfAge.clear();
				tfTel.clear();
				tfAddr.clear();	
				
				info("작업성공", name + "씨 정보 추가 성공!!");	
				
			} else if ("edit".equals(status)) {
				if(tfKorName.getText().isEmpty()) {
					alert("입력오류","한글이름을 입력하세요.");
					tfKorName.requestFocus();
					return;
				}
				
				if(tfEngName.getText().isEmpty()) {
					alert("입력오류","영문이름을 입력하세요.");
					tfEngName.requestFocus();
					return;
				}
				
				if(tfAge.getText().isEmpty()) {
					alert("입력오류","나이를 입력하세요.");
					tfAge.requestFocus();
					return;
				}
				
				if(tfTel.getText().isEmpty()) {
					alert("입력오류","전화번호를 입력하세요.");
					tfTel.requestFocus();
					return;
				}
				
				if(tfAddr.getText().isEmpty()) {
					alert("입력오류","주소를 입력하세요.");
					tfAddr.requestFocus();
					return;
				}
				
				// 자료 수정 작업
				data.set(table.getSelectionModel().getSelectedIndex(),
					new Member(tfKorName.getText(),
							tfEngName.getText(),
							Integer.parseInt(tfAge.getText()),
							tfTel.getText(),
							tfAddr.getText()
					)
				);
				
				String name = tfKorName.getText();	
				
				tfKorName.clear();
				tfEngName.clear();
				tfAge.clear();
				tfTel.clear();
				tfAddr.clear();	
				
				info("작업성공", name + "씨 정보 수정 성공!!");		
	
			} else {
				alert("작업 오류", "작업 상태");
			}
		});	
		
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
			
			tfKorName.clear();
			tfEngName.clear();
			tfAge.clear();
			tfTel.clear();
			tfAddr.clear();			
			
			if(!table.getSelectionModel().isEmpty()) {
				Member m = table.getSelectionModel().getSelectedItem();
				
				if(m!=null) {
					tfKorName.setText(m.getKorName());
					tfEngName.setText(m.getEngName());
					tfAge.setText(String.valueOf(m.getAge()));
					tfTel.setText(m.getTel());
					tfAddr.setText(m.getAddr());
				}
			}
		});		
		
		root.setCenter(table);
		root.setRight(vbox);
		root.setBottom(grid);
		root.setMaxSize(450, 400);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TableView 연습");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
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
	
	
	//TableView에 사용할 VO클래스 작성    --inner클래스
	public class Member{
		private String korName;
		private String engName;
		private int age;
		private String tel;
		private String addr;
		
		
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
		
	}//End Member클래스
	
}//End TableViewTest클래스







