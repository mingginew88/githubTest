package basic.controlTest;

import basic.controlTest.GuguDan2.Dan;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GuguDan2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		TextArea txtArea = new TextArea();
		txtArea.setFont(new Font(25));
		
		ComboBox<Dan> combo = new ComboBox<Dan>();
		
		ObservableList<Dan> list = FXCollections.observableArrayList(
				new Dan(1), new Dan(2), new Dan(3), new Dan(4), new Dan(5), new Dan(6), new Dan(7), new Dan(8), new Dan(9)
		);
		
		combo.setItems(list);
		
		combo.setCellFactory(new Callback<ListView<Dan>, ListCell<Dan>>() {
			
			@Override
			public ListCell<Dan> call(ListView<Dan> param) {
				return new ListCell<Dan>() {
					@Override
					protected void updateItem(Dan item, boolean empty) {
						super.updateItem(item, empty);
						if(item==null||empty) {
							setText(null);
						} else {							
							setText(item.getDan() + "단");				
						}
					}
				};
			}
		});		
		
		combo.setButtonCell(new ListCell<Dan>() {
			@Override
			protected void updateItem(Dan item, boolean empty) {
				super.updateItem(item, empty);
				if(item==null||empty) {
					setText(null);
				} else {							
					setText(item.getDan() + "단");				
				}
			}
		});	
		
		Button btn = new Button("출력");
		
		btn.setOnAction(e -> {
			Dan dan;
			dan = combo.getValue();
			
			if(dan!=null) {
				txtArea.setText(dan.getDan() + "단" + "\n\n");				
				for (int i = 1; i <= 9; i++) {
					txtArea.appendText(dan.getDan() + "*" + i + "=" + dan.getDan()*i + "\n");
				}				
			}			
		});	
		
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(combo, btn);	
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(0, 0, 10, 0));
		
		root.setTop(hbox);
		root.setCenter(txtArea);
		
		Scene scene = new Scene(root, 250, 450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm().toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("구구단");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	class Dan{
		private int dan;
		

		public Dan(int dan) {
			super();
			this.dan = dan;
		}

		public int getDan() {
			return dan;
		}

		public void setDan(int dan) {
			this.dan = dan;
		}
	}
}





