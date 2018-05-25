package basic.controlTest;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextAreaGugudan extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPrefSize(200, 300);
		
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(10));
		hbox.setAlignment(Pos.CENTER);
		
		TextField tfDan = new TextField();
		tfDan.setPrefWidth(70);
		Label lbl = new Label("단");
		Button btnOk = new Button("확인");
		
		TextArea txtResult = new TextArea();
		tfDan.setAlignment(Pos.CENTER_RIGHT);		
		
		btnOk.setOnAction(e->{
			String strDan = tfDan.getText();			
			
			if(strDan.isEmpty() || !Pattern.matches("^[0-9]+$", strDan)) {
				txtResult.setText("출력할 단을 숫자로 \n정확히 입력하세요.");
				//tfDan.setText("");	//내용지우기
				tfDan.clear(); 			//내용지우기
				
				tfDan.requestFocus(); 	//포커스주기
				return;
			}
			
			int dan = Integer.parseInt(strDan);
			txtResult.setText(strDan + "단\n\n");
			
			for (int i = 1; i <= 9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + "*" + i + "=" + r + "\n");
			}
		});	
		
		hbox.getChildren().addAll(tfDan, lbl, btnOk);
		root.setTop(hbox);
		root.setCenter(txtResult);
		
		Scene scene = new Scene(root);
		//textArea가운데 정렬 하기위해서    --application.css 에서 설정 바꿔줌 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm().toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("구구단 출력");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
