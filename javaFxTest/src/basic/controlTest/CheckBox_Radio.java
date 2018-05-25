package basic.controlTest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBox_Radio extends Application {

	@Override
	public void start(Stage primaryStage) {	
		
		Label lbl_name = new Label();
		lbl_name.setText("이  름 : ");
		
		TextField txtField = new TextField();
		
		HBox hbox_name = new HBox(10);
		hbox_name.getChildren().addAll(lbl_name, txtField);
		
		Label lbl_gender = new Label();
		lbl_gender.setText("성  별 : ");
		
		ToggleGroup group = new ToggleGroup();
		RadioButton Gen_Man = new RadioButton("남자");
		RadioButton Gen_Woman = new RadioButton("여자");
		Gen_Man.setToggleGroup(group);
		Gen_Woman.setToggleGroup(group);
		
		HBox hbox_gender = new HBox(10);
		hbox_gender.getChildren().addAll(lbl_gender, Gen_Man, Gen_Woman);
		
		Label lbl_hobby = new Label();
		lbl_hobby.setText("취  미 : ");
		
		String[] hobby = new String[] {"여행","등산","독서","바둑","장기","게임","테니스","배드민턴"};
		CheckBox[] chk_hobbies = new CheckBox[hobby.length];
		
		for (int i = 0; i < chk_hobbies.length; i++) {
			chk_hobbies[i] = new CheckBox(hobby[i]);
		}
		
		HBox hbox_hobby = new HBox();
		hbox_hobby.getChildren().addAll(lbl_hobby, chk_hobbies[0], chk_hobbies[1], chk_hobbies[2], 
				chk_hobbies[3], chk_hobbies[4], chk_hobbies[5], chk_hobbies[6], chk_hobbies[7]);
		
		Button btn = new Button("보 기");
		TextArea txtArea = new TextArea();
		
		btn.setOnAction(e->{
			txtArea.setText("입력사항\n");
			if(txtField.getText().equals("") || txtField.getText()==null) {
				txtArea.appendText("이름을 입력하지 않았습니다.\n");
			}else {
				txtArea.appendText("이름은 " + txtField.getText() +"입니다.\n");
			}
			if(Gen_Man.isSelected()) {
				txtArea.appendText("성별은 " + Gen_Man.getText() + "이고 \n");			
			} else if(Gen_Woman.isSelected()) {
				txtArea.appendText("성별은 " + Gen_Woman.getText() + "이고 \n");
			} else {
				txtArea.appendText("성별을 클릭하지 않았습니다. \n");
			}
			String select_hobby = "";
			for (int j = 0; j < chk_hobbies.length; j++) {
				if(chk_hobbies[j].isSelected()) {
					select_hobby += hobby[j] + ",";			
				}
			}
			select_hobby = select_hobby.substring(0, select_hobby.length()-1);
			if(select_hobby.equals("")) {
				txtArea.appendText("취미는 없군요");
			} else {
				txtArea.appendText("취미는 " + select_hobby + "입니다.");
			}
		});		
		
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));
		vbox.getChildren().addAll(hbox_name, hbox_gender, hbox_hobby, btn, txtArea);	
		
		Scene scene = new Scene(vbox, 800, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("체크박스 및 라디오버튼 연습");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
