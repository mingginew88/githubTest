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
		
		Label lblDan = new Label("��");
		Button btnOk = new Button("Ȯ��");
		
		tfDan.setAlignment(Pos.CENTER_RIGHT);
		
		TextArea txtResult = new TextArea();
		txtResult.setStyle("-fx-alignment:center;");
		
		
		btnOk.setOnAction(e->{
			String strDan = tfDan.getText();
			if(strDan.isEmpty() || 
					!Pattern.matches("^[0-9]+$", strDan)) {
				txtResult.setText("����� ���� ���ڷ� ��Ȯ�� �Է��ϼ���");
				//tfDan.setText("");  // ���������
				tfDan.clear();  // ���������
				
				tfDan.requestFocus();  // ��Ŀ�� �ֱ�
				
				return;
			}
			
			int dan = Integer.parseInt(strDan);
			txtResult.setText(strDan + "��\n\n");
			
			for(int i=1; i<=9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");
			}
		});
		
		hbox.getChildren().addAll(tfDan, lblDan, btnOk);
		root.setTop(hbox);
		root.setCenter(txtResult);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().addAll(getClass().getResource("test.css").toExternalForm());
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("������ ���");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}










