package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SelectTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();			
		Label lblTitle = new Label();		
		
		root.setPadding(new Insets(10));
		
		root.setAlignment(lblTitle, Pos.CENTER);
		lblTitle.setText("Select 객체 예제");
		lblTitle.setFont(Font.font(20));
		lblTitle.setPadding(new Insets(10));		
		
		TextArea txtLeft = new TextArea();
		TextArea txtRight = new TextArea();
		txtLeft.setPrefSize(100, 150);
		txtRight.setPrefSize(100, 150);
		
		VBox vbox = new VBox();
		Button btn1 = new Button(">");
		Button btn2 = new Button(">>");
		Button btn3 = new Button("<");
		Button btn4 = new Button("<<");
		
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(btn1, btn2, btn3, btn4);
		
		HBox hbox = new HBox();		
		TextField tfd = new TextField();
		Button btn5 = new Button("추가하기");
		
		hbox.getChildren().addAll(tfd, btn5);
		hbox.setSpacing(30);
		hbox.setPadding(new Insets(10));
		hbox.setAlignment(Pos.CENTER);
		
		root.setTop(lblTitle);
		root.setLeft(txtLeft);
		root.setRight(txtRight);
		root.setCenter(vbox);
		root.setBottom(hbox);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
