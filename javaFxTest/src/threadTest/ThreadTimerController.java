package threadTest;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ThreadTimerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTime;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnStop;
    
    //시작과 멈춤을 조절하기 위한 변수
    private boolean stop;

    @FXML
    void initialize() {
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        assert btnStop != null : "fx:id=\"btnStop\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        //-----------------------------------------------------------------
        
        // 시작버튼 이벤트 처리
        btnStart.setOnAction(e->{
        	stop = false;
        	Thread th = new Thread(
    			new Runnable() {
					
					@Override
					public void run() {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
						
						while(!stop) {
							String strTime = sdf.format(new Date());
							
							Platform.runLater(()->{
								//쓰레드에서 UI컴트롤에 변화를 주는 부분은 이곳에서 처리해 주어야한다.
								lblTime.setText(strTime); //이렇게만하면 터짐. why?
							});
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e2) {	}
						}
					}
				}
        	);
        	//-------------------------thread
        	th.setDaemon(true);
        	th.start();
        });
        
        //멈춤버튼 이벤트처리
        btnStop.setOnAction(e->{
        	stop = true;
        });
        
        

    }
}
