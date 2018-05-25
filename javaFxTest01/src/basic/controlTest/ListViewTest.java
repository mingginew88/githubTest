package basic.controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListViewTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		ListView<String> list = new ListView<String>();
		Label label = new Label();
		
		// ObservableList ==> JavaFx에서 사용되는 list컬렉션
		//    JavaFx의 컨트롤에 추가되는 데이터를 저장하는데 사용한다.
		ObservableList<String> data = FXCollections.observableArrayList(
			"green", "gold", "red", "blue", "black",
			"brown", "pink", "chocolate", "lightblue"
		);
		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(list, label);
		
		label.setFont(Font.font(20));
		
		
		list.setItems(data);  // ListView에 데이터 셋팅하기 방법1
		
		//list = new ListView<String>(data);  // 방법2
		
		// ListView에서 값이 선택되었을 때 처리
		list.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, 
						String oldValue, String newValue) {
					
					label.setText(newValue);
					label.setTextFill(Color.web(newValue));
					
				}
			}
		);
		
		// ListView의 내용은 변경하기 않고
		// 화면에 보이는 부분을 변경해서 보여주는 방법
		list.setCellFactory(
			new Callback<ListView<String>, ListCell<String>>() {
				
				@Override
				public ListCell<String> call(ListView<String> param) {
					return new ListCell<String>(){
						protected void updateItem(String item, boolean empty) {
							super.updateItem(item, empty);
							Rectangle rect = new Rectangle(100, 20);
							if(item!=null) {
								rect.setFill(Color.web(item));
								setGraphic(rect);  // 값변경 --> 변경되는 값이 컨트롤일 경우
								//setText(변경될값);  // --> 변경되는 값이 문자열일 경우
							}
						};
					};
				}
			}	
		);
		
		
		
		
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ListView 연습");
		primaryStage.show();
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
















