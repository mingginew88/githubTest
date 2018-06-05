package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ClientMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfIp;

    @FXML
    private TextField tfPort;

    @FXML
    private Button btnJoin;

    @FXML
    private TextArea taOutputMsg;

    @FXML
    private TextField tfMsg;

    @FXML
    private Button btnSend;
    
    @FXML
    private TextField tfName;
    
    private Socket clientSocket= null;

    @FXML
    void initialize() {
        assert tfIp != null : "fx:id=\"tfIp\" was not injected: check your FXML file 'ClientMain.fxml'.";
        assert tfPort != null : "fx:id=\"tfPort\" was not injected: check your FXML file 'ClientMain.fxml'.";
        assert btnJoin != null : "fx:id=\"btnJoin\" was not injected: check your FXML file 'ClientMain.fxml'.";
        assert taOutputMsg != null : "fx:id=\"taOutputMsg\" was not injected: check your FXML file 'ClientMain.fxml'.";
        assert tfMsg != null : "fx:id=\"tfMsg\" was not injected: check your FXML file 'ClientMain.fxml'.";
        assert btnSend != null : "fx:id=\"btnSend\" was not injected: check your FXML file 'ClientMain.fxml'.";
        
        btnJoin.setOnAction(e->{ socketConnect(e); } ); 
        tfMsg.setOnKeyPressed(e -> tfMsgSend(e));
        btnSend.setOnAction(e-> btnMsgSend(e) );

    }
    
    public void msgSend(){
    	try {
        	if(clientSocket==null){
        		taOutputMsg.setText("������ ���ӵ��� �ʾҽ��ϴ�.\n");
        		return;
        	}
        	
        	// �Է�â���� �Է� �� 'Enter'Ű�� ������ �޽��� ����
            String sendMessage = tfName.getText() + " : " + tfMsg.getText();
            byte[] byteArray = sendMessage.getBytes("UTF-8");
            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tfMsg.clear();
    }
    
    public void btnMsgSend(ActionEvent event){
    	msgSend();
    }
    
    
    public void tfMsgSend(KeyEvent event){
    	if (event.getCode() == KeyCode.ENTER) {
            msgSend();
        }
    }
    
    // ������ �����ϱ�
    public void socketConnect(ActionEvent event){
    	if (btnJoin.getText().equals("���� ����")) {
    		try {
    			if(tfIp.getText().isEmpty()){
    				taOutputMsg.setText("������ ������ IP�ּҸ� �Է��ϼ���");
    				tfIp.requestFocus();
    				return;
    			}
				
    			if(tfPort.getText().isEmpty()){
    				taOutputMsg.setText("������ ������ Port��ȣ�� �Է��ϼ���");
    				tfPort.requestFocus();
    				return;
    			}
    			
    			if(tfName.getText().isEmpty()){
    				taOutputMsg.setText("�̸��� �Է��ϼ���");
    				tfName.requestFocus();
    				return;
    			}
    			
    			// ���1
    			clientSocket = new Socket(tfIp.getText(), Integer.parseInt(tfPort.getText()));
    			
    			/*
    			// ���2
    			clientSocket = new Socket();
					//clientSocket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 4040));
    			clientSocket.connect(new InetSocketAddress(tfIp.getText(), Integer.parseInt( tfPort.getText())) );
    			*/
    			tfIp.setDisable(true);
    			tfPort.setDisable(true);
    			tfName.setDisable(true);
    			
    			taOutputMsg.setDisable(false);
    			tfMsg.setDisable(false);
    			btnSend.setDisable(false);
    			
				taOutputMsg.setText("������ �����Ͽ����ϴ�.\n\n");
				btnJoin.setText("���� ����");
			
				try {
					// ���� ������ '�̸�'�� ������ ����
					String sendMessage = tfName.getText();
					//System.out.println("�޽��� : " + sendMessage);
					byte[] byteArray = sendMessage.getBytes("UTF-8");
					OutputStream outputStream = clientSocket.getOutputStream();
					outputStream.write(byteArray);
					outputStream.flush();
						 
				 } catch (Exception e) {
						 e.printStackTrace();
				 }
					// ClientReader��ü ����
					ClientReader clientReader = new ClientReader(clientSocket);
					clientReader.setDaemon(true);
					clientReader.start();
				 } catch (Exception e) {
						 e.printStackTrace();
				 }
		 } else if (btnJoin.getText().equals("���� ����")) {
			 try {
				 tfIp.setDisable(false);
				 tfPort.setDisable(false);
				 tfName.setDisable(false);
    			
				 taOutputMsg.setDisable(true);
				 tfMsg.setDisable(true);
				 btnSend.setDisable(true);
				 
				 
				 taOutputMsg.setText("\n������ ���������Ͽ����ϴ�.\n\n");
				 btnJoin.setText("���� ����");
				 clientSocket.close();
		     } catch (Exception e) {
		    	 if(!clientSocket.isClosed())
		    		 e.printStackTrace();
		     }
		 }
    }
    
    
    // Reader class
    class ClientReader extends Thread {
        Socket clientSocket = null;
        String readMessage = null;
 
        ClientReader(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
 
        @Override
        public void run() {
            try {
                while (true) {
                    InputStream inputStream = clientSocket.getInputStream();
                    byte[] byteArray = new byte[256];
                    int size = inputStream.read(byteArray);
                    if (size == -1){
                    	break;  // ���������� ���
                    }
                    readMessage = new String(byteArray, 0, size, "UTF-8");
                    if(readMessage.equals("FFFF")) {
                        tfMsg.clear();
                        taOutputMsg.clear();
                        
                        readMessage = "������ ����Ǿ����ϴ�";    
                        Platform.runLater(() -> {
                        	tfIp.setDisable(false);
	           				tfPort.setDisable(false);
	           				tfName.setDisable(false);
	               			
	           				taOutputMsg.setDisable(true);
	           				tfMsg.setDisable(true);
	           				btnSend.setDisable(true);
	           				 
	           				btnJoin.setText("���� ����");
                        });
                    }
                    taOutputMsg.appendText(readMessage + "\n");

                }
            } catch (Exception e) {
            	//System.out.println("--> " + clientSocket.isClosed());
            	if(!clientSocket.isClosed())
					try {	
						clientSocket.close();  
						taOutputMsg.appendText("������ ����Ǿ����ϴ�\n");
					} catch (IOException e1) {	}
            	else
            		e.printStackTrace();
            }
        }
    }
}
