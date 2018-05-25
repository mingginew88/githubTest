package basic.controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
//		콤보박스 할때도 이전의 리스트뷰 할때처럼 옵저벌릭리스트를 써야함.
		
		BorderPane root = new BorderPane();
		HBox hbox = new HBox();
		TextArea txtResult = new TextArea();
		
		//ComboBox를 생성하고 데이터 셋팅하기 방법1
		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("한강", "금강", "영산강", "낙동강");
		combo.setValue("한강");	//기본선택값 설정
		
		//콤보박스에서 선택된 값이 변경되었을 때 처리
//		combo.valueProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				String temp = combo.getItems().get((int)(Math.random()*4));
//				txtResult.setText("선택된 강 : " + newValue + "..." + temp);
//			}
//		});
		
		//방법2
		ObservableList<String> dataList = FXCollections.observableArrayList("사과","배", "복숭아", "딸기", "포도", "감");
		ComboBox<String> combo2 = new ComboBox<String>(dataList);
		combo2.setValue("복숭아");
		combo2.getItems().addAll("대추","수박");
		
//		combo2.valueProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				txtResult.setText(newValue);				
//			}
//		});
		
		
		Button btn = new Button("확 인");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				if(combo.getValue()!=null && combo2.getValue()!=null) {
					//getValue() => 현재 선택된 값
					txtResult.setText(combo.getValue()  + "지역의 과일은 " + combo2.getValue() + "(이)가 유명합니다.");
				}
			}
		});
		
		
		
		
		hbox.setSpacing(10);
		hbox.getChildren().addAll(combo, combo2, btn);
		
		root.setTop(hbox);
		root.setCenter(txtResult);
		
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ComboBox 연습");
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
