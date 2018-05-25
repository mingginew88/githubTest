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
		root.setPadding(new Insets(10));//안쪽여백
		
		HBox hbox = new HBox(15);
		hbox.setPadding(new Insets(10));
		
		Button btn1 = new Button("첫번째");
		Button btn2 = new Button("두번째");
		Button btn3 = new Button("세번째");
		Button btn4 = new Button("네번째");
		
		//버튼이 클릭되었을때의 이벤트 설정하기
		/*
		- 방법 1
			객체.setOn이벤트명()메서드에 EventHandler인터페이스를 익명구현체로 구현하여 설정한다.
			(이 인터페이스는 handle()메서드가 있는데 이 메서드에 이벤트에 대한 처리내용을 기술한다.)
			(EventHandler인터페이스는 함수적 인터페이스이므로 람다식으로 기술할 수 있다.)
		*/
		/*
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//이 부분에 이벤트에 대한 처리내용을 기술한다.
				txtArea.setText("첫번째 버튼이다.");
			}
		});
		*/
		//람다식은 매개변수와 반환값을 잘 봐라.
		btn1.setOnAction(event->{
			txtArea.setText("람다식 - 첫번째 버튼이다.");
		});
		//----------------------------------------------------------------------------
		
		/*
		- 방법2
			객체.addEventHandler()메서드 사용하기
			==> 이 메서드의 첫번째 매개변수로는 '이벤트 종류'를 지정하고,
				두번째 매개변수로는 EventHandler인터페이스를 구현한 객체를 지정한다.(익명구현체)
		 */
		btn2.addEventHandler(ActionEvent.ACTION,				
			/*
			new EventHandler<Event>() {		
				@Override
				public void handle(Event event) {
					txtArea.setText("두번째 버튼...");
				}
			}
			*/
			e->{
				//setText("내용"); ==> 원래 내용을 지우고 '내용'을 출력한다.
				//txtArea.setText("람다식 두번째 버튼...");
				//appendText("내용"); ==> 원래 내용 뒤에 이어서 '내용'을 출력한다.
				//txtArea.appendText("\n계속 출력합니다.");
				
				txtArea.setText(txtArea.getText() + "\n이어지는 내용입니다.");
			}			
		);
		//----------------------------------------------------------------------------
		
		
		/*
		-방법3-2
			setOn이벤트명()메서드나 addEventHandler()메서드의 EventHandler인터페이스 구현체자리에
			객체를 생성해서 넣어준다.
		 */
		btn3.setOnAction(new MyeventHandler());
		//----------------------------------------------------------------------------
		
		
		/*
		-방법 4-2
			외부 독립된 객체도 setOn이벤트명()메서드와 addEventHandler()메서드에 매개값으로 넣어준다.
		 */
		//btn4.setOnAction(new MyEventHandler2(txtArea));
		btn4.addEventHandler(ActionEvent.ACTION, new MyEventHandler2(txtArea));		
		
		hbox.getChildren().addAll(btn1, btn2, btn3, btn4);
		
		root.getChildren().addAll(hbox, txtArea);	
		
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Event 연습");
		primaryStage.show();		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/*
	-방법 3-1
		inner클래스로 EventHandler인터페이스를 구현한 클래스를 작성한다.
	 */
	
	class MyeventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			txtArea.setText("세번째 방법 - inner클래스 이용하기");
		}
	}	
}


/*
-방법 4-1
	외부의 독립된 형태의 객체를 이용하는 방법
	이 객체도 EventHandler인터페이스를 구현한다.	
 */
class MyEventHandler2 implements EventHandler<ActionEvent>{
	TextArea txt;
	
	public MyEventHandler2(TextArea txt) {
		this.txt = txt;
	}
	
	@Override
	public void handle(ActionEvent event) {
		txt.setText("네번째 방법입니다.");
	}
}















