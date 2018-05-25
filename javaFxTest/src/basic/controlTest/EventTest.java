package basic.controlTest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventTest extends Application {
	TextArea txtArea  = new TextArea();

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);		
		root.setPadding(new Insets(10));//���ʿ���
		
		HBox hbox = new HBox(15);
		hbox.setPadding(new Insets(10));
		
		Button btn1 = new Button("ù��°");
		Button btn2 = new Button("�ι�°");
		Button btn3 = new Button("����°");
		Button btn4 = new Button("�׹�°");
		
		//��ư�� Ŭ���Ǿ������� �̺�Ʈ �����ϱ�
		/*
		- ��� 1
			��ü.setOn�̺�Ʈ��()�޼��忡 EventHandler�������̽��� �͸���ü�� �����Ͽ� �����Ѵ�.
			(�� �������̽��� handle()�޼��尡 �ִµ� �� �޼��忡 �̺�Ʈ�� ���� ó�������� ����Ѵ�.)
			(EventHandler�������̽��� �Լ��� �������̽��̹Ƿ� ���ٽ����� ����� �� �ִ�.)
		*/
		/*
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//�� �κп� �̺�Ʈ�� ���� ó�������� ����Ѵ�.
				txtArea.setText("ù��° ��ư�̴�.");
			}
		});
		*/
		//���ٽ��� �Ű������� ��ȯ���� �� ����.
		btn1.setOnAction(event->{
			txtArea.setText("���ٽ� - ù��° ��ư�̴�.");
		});
		//----------------------------------------------------------------------------
		
		/*
		- ���2
			��ü.addEventHandler()�޼��� ����ϱ�
			==> �� �޼����� ù��° �Ű������δ� '�̺�Ʈ ����'�� �����ϰ�,
				�ι�° �Ű������δ� EventHandler�������̽��� ������ ��ü�� �����Ѵ�.(�͸���ü)
		 */
		btn2.addEventHandler(ActionEvent.ACTION,				
			/*
			new EventHandler<Event>() {		
				@Override
				public void handle(Event event) {
					txtArea.setText("�ι�° ��ư...");
				}
			}
			*/
			e->{
				//setText("����"); ==> ���� ������ ����� '����'�� ����Ѵ�.
				//txtArea.setText("���ٽ� �ι�° ��ư...");
				//appendText("����"); ==> ���� ���� �ڿ� �̾ '����'�� ����Ѵ�.
				//txtArea.appendText("\n��� ����մϴ�.");
				
				txtArea.setText(txtArea.getText() + "\n�̾����� �����Դϴ�.");
			}			
		);
		//----------------------------------------------------------------------------
		
		
		/*
		-���3-2
			setOn�̺�Ʈ��()�޼��峪 addEventHandler()�޼����� EventHandler�������̽� ����ü�ڸ���
			��ü�� �����ؼ� �־��ش�.
		 */
		btn3.setOnAction(new MyeventHandler());
		//----------------------------------------------------------------------------
		
		
		/*
		-��� 4-2
			�ܺ� ������ ��ü�� setOn�̺�Ʈ��()�޼���� addEventHandler()�޼��忡 �Ű������� �־��ش�.
		 */
		//btn4.setOnAction(new MyEventHandler2(txtArea));
		btn4.addEventHandler(ActionEvent.ACTION, new MyEventHandler2(txtArea));		
		
		hbox.getChildren().addAll(btn1, btn2, btn3, btn4);
		
		root.getChildren().addAll(hbox, txtArea);	
		
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Event ����");
		primaryStage.show();		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/*
	-��� 3-1
		innerŬ������ EventHandler�������̽��� ������ Ŭ������ �ۼ��Ѵ�.
	 */
	
	class MyeventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			txtArea.setText("����° ��� - innerŬ���� �̿��ϱ�");
		}
	}	
}


/*
-��� 4-1
	�ܺ��� ������ ������ ��ü�� �̿��ϴ� ���
	�� ��ü�� EventHandler�������̽��� �����Ѵ�.	
 */
class MyEventHandler2 implements EventHandler<ActionEvent>{
	TextArea txt;
	
	public MyEventHandler2(TextArea txt) {
		this.txt = txt;
	}
	
	@Override
	public void handle(ActionEvent event) {
		txt.setText("�׹�° ����Դϴ�.");
	}
}















