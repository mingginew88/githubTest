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
		
		// ObservableList ==> JavaFx���� ���Ǵ� list�÷���
		//    JavaFx�� ��Ʈ�ѿ� �߰��Ǵ� �����͸� �����ϴµ� ����Ѵ�.
		ObservableList<String> data = FXCollections.observableArrayList(
			"green", "gold", "red", "blue", "black",
			"brown", "pink", "chocolate", "lightblue"
		);
		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(list, label);
		
		label.setFont(Font.font(20));
		
		
		list.setItems(data);  // ListView�� ������ �����ϱ� ���1
		
		//list = new ListView<String>(data);  // ���2
		
		// ListView���� ���� ���õǾ��� �� ó��
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
		
		// ListView�� ������ �����ϱ� �ʰ�
		// ȭ�鿡 ���̴� �κ��� �����ؼ� �����ִ� ���
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
								setGraphic(rect);  // ������ --> ����Ǵ� ���� ��Ʈ���� ���
								//setText(����ɰ�);  // --> ����Ǵ� ���� ���ڿ��� ���
							}
						};
					};
				}
			}	
		);
		
		
		
		
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ListView ����");
		primaryStage.show();
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
















