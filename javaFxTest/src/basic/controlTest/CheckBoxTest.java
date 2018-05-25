package basic.controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		String[] names = new String[] {"Security", "Project", "Chart"};
		Image[] images = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];	
		
		CheckBox[] chkboxs = new CheckBox[names.length];
		
		Rectangle rect = new Rectangle(90,30);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		rect.setFill(Color.rgb(41, 41, 41));
		
		for (int i = 0; i < names.length; i++) {
			final Image img = images[i] = new Image(getClass().getResourceAsStream("images/" + names[i] + ".png"));
			final ImageView icon = icons[i] = new ImageView();
			chkboxs[i] = new CheckBox(names[i]);
			
			//CheckBox를 클릭해서 체크상태가 변경되었을 때 처리하기
			//CheckBox자체에 이벤트 설정하기
			chkboxs[i].selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					//oldValue ==> 변경되기 전 값
					//newValue ==> 변경된 후 값
					icon.setImage(newValue ? img : null);
				}
			});
		}
		
		
		Button btn = new Button("확인");
		
		btn.setOnAction(e->{
//			//체크상태이면 true, 미체크상태이면 false
//			System.out.println("체크상태 : " + chkboxs[0].isSelected());
//			//setSelected()메서드에 true를 설정하면 체크상태로 되고, false를 설정하면 미체크상태가 된다.
//			chkboxs[1].setSelected(true);
//			chkboxs[2].setSelected(false);
			
			//첫번재와 세번째가 반대로 체크상태가 된다.
//			chkboxs[2].setSelected(!chkboxs[0].isSelected());
			
			if(chkboxs[0].isSelected()==true) {
				System.out.println("체크하셨군요!!");
			} else {
				System.out.println("체크가 해제되었네요!!");
			}			
		});
		
		
		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(chkboxs);
		vbox.getChildren().add(btn);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(icons);
		hbox.setPadding(new Insets(0, 0, 0, 5));
		
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rect, hbox);
		StackPane.setAlignment(rect, Pos.TOP_CENTER);
		
		HBox root = new HBox();
		root.setSpacing(40);
		root.getChildren().addAll(vbox, stack);
		root.setPadding(new Insets(20, 10, 10, 20));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("CheckBox 연습");
		primaryStage.show();	
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}




