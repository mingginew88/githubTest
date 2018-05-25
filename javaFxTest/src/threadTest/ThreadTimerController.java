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
    
    //���۰� ������ �����ϱ� ���� ����
    private boolean stop;

    @FXML
    void initialize() {
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        assert btnStop != null : "fx:id=\"btnStop\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        //-----------------------------------------------------------------
        
        // ���۹�ư �̺�Ʈ ó��
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
								//�����忡�� UI��Ʈ�ѿ� ��ȭ�� �ִ� �κ��� �̰����� ó���� �־���Ѵ�.
								lblTime.setText(strTime); //�̷��Ը��ϸ� ����. why?
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
        
        //�����ư �̺�Ʈó��
        btnStop.setOnAction(e->{
        	stop = true;
        });
        
        

    }
}
