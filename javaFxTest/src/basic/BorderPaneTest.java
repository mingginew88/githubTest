package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BorderPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 200);
		
		//Top 영역에 추가할 내용
		ToolBar toolbar = new ToolBar(
			new Button("첫번째"),
			new Button("두번째"),
			new Button("세번째"),
			new Button("네번째")
		);
		
		// Center영역에 추가할 내용
		TextArea txtArea = new TextArea();
		
		// Bottom영역에 추가할 내용
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(10));
		
		TextField tfTest = new TextField();
		Button btnOk = new Button("확 인");
		hbox.getChildren().addAll(tfTest, btnOk);
		hbox.setAlignment(Pos.CENTER);
		//--------------------------------------------------
		
		root.setTop(toolbar);
		root.setCenter(txtArea);
		root.setBottom(hbox);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane 연습");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
