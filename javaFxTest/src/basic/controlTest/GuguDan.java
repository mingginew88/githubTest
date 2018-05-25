package basic.controlTest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GuguDan extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		
		TextField txtfield = new TextField();
		TextArea result = new TextArea();
		result.setPrefSize(100, 200);
		result.setFont(new Font(15));		
		
		Label lbl = new Label("단");	
		lbl.setFont(new Font(20));		
		
		Button btn = new Button("출력");		
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(txtfield, lbl, btn);
		
		
		
		btn.addEventHandler(ActionEvent.ACTION,
				e->{
				
					int dan = Integer.parseInt((txtfield.getText()));				
					result.setText(dan+"단\n");					
					for (int i = 1; i <= 9; i++) {
						result.appendText(dan + "*" + i + "=" + dan*i);
						result.appendText("\n");						
					}
				}
		);
		
//		root.setAlignment(result, Pos.CENTER);

		root.setMargin(hbox, new Insets(5));
		root.setMargin(result, new Insets(10));
		root.setTop(hbox);
		root.setCenter(result);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("구구단");
		primaryStage.show();
				
	}

	public static void main(String[] args) {
		launch(args);
	}
}
