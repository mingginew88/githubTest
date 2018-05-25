package basic.controlTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComboBoxGuGuDanTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		ObservableList<Integer> danList = FXCollections.observableArrayList(
			1,2,3,4,5,6,7,8,9
		);
		
		BorderPane root = new BorderPane();
		HBox hbox = new HBox(10);
		TextArea result = new TextArea();
		
		ComboBox<Integer> cbDan = new ComboBox<Integer>();
		cbDan.setItems(danList);
		
		Button btn = new Button("출력");
		
		cbDan.setCellFactory(new Callback<ListView<Integer>, ListCell<Integer>>() {
			
			@Override
			public ListCell<Integer> call(ListView<Integer> param) {
				return new ListCell<Integer>() {
					@Override
					protected void updateItem(Integer item, boolean empty) {
						super.updateItem(item, empty);
						if(empty) {
							setText(null);
						} else {
							setText(item + "단");
						}
					}
				};
			}
		});
		
		cbDan.setButtonCell(new ListCell<Integer>() {
			@Override
			protected void updateItem(Integer item, boolean empty) {
				super.updateItem(item, empty);
				if(empty) {
					setText(null);
				} else {
					setText(item + "단");
				}
			}
		});
		
		
		btn.setOnAction(event -> {
			//Integer dan = cbDan.getValue();
			Integer dan = cbDan.getSelectionModel().getSelectedItem();
			if(dan==null) {
				result.setText("출력할 단을 선택한 후 실행하세요.");
				return;
			}
			result.setText(dan + "단\n\n");
			for (int i = 1; i < 9; i++) {
				result.appendText(dan + " * " + i + " = " + dan*i + "\n");
			}
		});
		
		hbox.getChildren().addAll(cbDan, btn);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(15));
		
		root.setTop(hbox);
		root.setCenter(result);		
		
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("콤보박스 구구단");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
