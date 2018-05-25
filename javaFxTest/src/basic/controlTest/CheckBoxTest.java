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
			
			//CheckBox�� Ŭ���ؼ� üũ���°� ����Ǿ��� �� ó���ϱ�
			//CheckBox��ü�� �̺�Ʈ �����ϱ�
			chkboxs[i].selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					//oldValue ==> ����Ǳ� �� ��
					//newValue ==> ����� �� ��
					icon.setImage(newValue ? img : null);
				}
			});
		}
		
		
		Button btn = new Button("Ȯ��");
		
		btn.setOnAction(e->{
//			//üũ�����̸� true, ��üũ�����̸� false
//			System.out.println("üũ���� : " + chkboxs[0].isSelected());
//			//setSelected()�޼��忡 true�� �����ϸ� üũ���·� �ǰ�, false�� �����ϸ� ��üũ���°� �ȴ�.
//			chkboxs[1].setSelected(true);
//			chkboxs[2].setSelected(false);
			
			//ù����� ����°�� �ݴ�� üũ���°� �ȴ�.
//			chkboxs[2].setSelected(!chkboxs[0].isSelected());
			
			if(chkboxs[0].isSelected()==true) {
				System.out.println("üũ�ϼ̱���!!");
			} else {
				System.out.println("üũ�� �����Ǿ��׿�!!");
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
		primaryStage.setTitle("CheckBox ����");
		primaryStage.show();	
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}




