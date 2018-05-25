package basic.controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
//		�޺��ڽ� �Ҷ��� ������ ����Ʈ�� �Ҷ�ó�� ������������Ʈ�� �����.
		
		BorderPane root = new BorderPane();
		HBox hbox = new HBox();
		TextArea txtResult = new TextArea();
		
		//ComboBox�� �����ϰ� ������ �����ϱ� ���1
		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("�Ѱ�", "�ݰ�", "���갭", "������");
		combo.setValue("�Ѱ�");	//�⺻���ð� ����
		
		//�޺��ڽ����� ���õ� ���� ����Ǿ��� �� ó��
//		combo.valueProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				String temp = combo.getItems().get((int)(Math.random()*4));
//				txtResult.setText("���õ� �� : " + newValue + "..." + temp);
//			}
//		});
		
		//���2
		ObservableList<String> dataList = FXCollections.observableArrayList("���","��", "������", "����", "����", "��");
		ComboBox<String> combo2 = new ComboBox<String>(dataList);
		combo2.setValue("������");
		combo2.getItems().addAll("����","����");
		
//		combo2.valueProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				txtResult.setText(newValue);				
//			}
//		});
		
		
		Button btn = new Button("Ȯ ��");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				if(combo.getValue()!=null && combo2.getValue()!=null) {
					//getValue() => ���� ���õ� ��
					txtResult.setText(combo.getValue()  + "������ ������ " + combo2.getValue() + "(��)�� �����մϴ�.");
				}
			}
		});
		
		
		
		
		hbox.setSpacing(10);
		hbox.getChildren().addAll(combo, combo2, btn);
		
		root.setTop(hbox);
		root.setCenter(txtResult);
		
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ComboBox ����");
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
