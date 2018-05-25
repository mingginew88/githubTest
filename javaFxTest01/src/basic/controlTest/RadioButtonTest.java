package basic.controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// ������ư���� �������� ó���ϴ� ��ü ����
		ToggleGroup group = new ToggleGroup();
		
		ImageView icon = new ImageView();
		
		RadioButton rb1 = new RadioButton("Home");
		rb1.setToggleGroup(group);
		// �������� ���� ���� ��Ÿ�������� �ڷ� ����
		rb1.setUserData("Home");
		
		RadioButton rb2 = new RadioButton("Calendar");
		rb2.setToggleGroup(group);
		rb2.setUserData("Calendar");
		
		RadioButton rb3 = new RadioButton("Contacts");
		rb3.setToggleGroup(group);
		rb3.setUserData("Contacts");
		
		
		// ������ư�� �����ִ� �׷� ������
		// �� ���� ���� ��ư�� ���õǾ��� �� ó���ϱ�
		group.selectedToggleProperty().addListener(
			new ChangeListener<Toggle>() {
				@Override
				public void changed(ObservableValue<? extends Toggle> observable, 
						Toggle oldValue, Toggle newValue) {
					// �̰��� ���õ� ������ư�� ���� ó�������� ����Ѵ�.
					if(group.getSelectedToggle().getUserData()!=null) {
						String url = group.getSelectedToggle().getUserData().toString();
						Image img = new Image(
							getClass().getResourceAsStream("images/" + url + ".jpg")
						);
						icon.setImage(img);
					}
					
					//System.out.println("ù��° ���� : " + rb1.isSelected());
					//rb1.setSelected(true);
					
				}
			}
		);
		
		
		
		HBox hbox = new HBox(50);
		hbox.setPadding(new Insets(10));
		
		VBox vbox = new VBox(10);
		
		vbox.getChildren().addAll(rb1, rb2, rb3);
		
		hbox.getChildren().addAll(vbox, icon);
		
		Scene scene = new Scene(hbox, 250, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("RadioButton ����");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}












