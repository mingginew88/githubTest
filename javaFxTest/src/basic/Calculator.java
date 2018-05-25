package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		
		Label lbl1 = new Label();
		Label lbl2 = new Label();
		Label lbl3 = new Label();
		lbl1.setText("보기(V)");
		lbl2.setText("편집(E)");
		lbl3.setText("도움말(H)");
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(lbl1, lbl2, lbl3);	
		
		TextField txt = new TextField();
		txt.setPrefHeight(60);		
		
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(5));
		
		String[] btn = {
				"1","2","3","4","5","MC","MR","MS","M+","M-",
				" ", "Inv", "ln", "(", ")", "←", "CE", "C", "±", "√",
				"Int", "shih", "sin", "x2", "n!", "7", "8", "9", "/", "%",
				"dms", "cosh", "cos", "xy", "y√x", "4", "5", "6", "*", "1/x",
				"π","tanh","tan", "x3", "3√x", "1", "2", "3", "-", "=",
				"F-E", "Exp", "Mod", "log", "10x", "0",  ".", "+", "="
				};	
		
		for (int i = 0; i < btn.length; i++) {
			Button b = new Button(btn[i]);			
			gp.add(b, i%10, i/10);
			if(i%10==5&&i/10==5) {	
				b.setPrefSize(80, 40);	
				
			}else {
				b.setPrefSize(45, 40);
				gp.setHgap(5);
				gp.setVgap(5);				
			}
			
		}
		
		

		VBox vbox = new VBox();	
		vbox.getChildren().addAll(txt, gp);
		root.setTop(hbox);
		root.setCenter(vbox);		
		
		Scene scene =new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("계산기");
		primaryStage.show();

	}

	private String parseInt(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
