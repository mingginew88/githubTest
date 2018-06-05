package application;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ServerMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnServerStart;

    @FXML
    private Label lblCount;

    @FXML
    private TextArea taOutputMsg;
    
    // ������ ������ ������ list --> (�����ڸ���Ʈ)
    private List<Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>()) ;
    
    ServerSocket mainServerSocket= null;

    @FXML
    void initialize() {
        assert btnServerStart != null : "fx:id=\"btnServerStart\" was not injected: check your FXML file 'ServierMain.fxml'.";
        assert lblCount != null : "fx:id=\"lblCount\" was not injected: check your FXML file 'ServierMain.fxml'.";
        assert taOutputMsg != null : "fx:id=\"taOutputMsg\" was not injected: check your FXML file 'ServierMain.fxml'.";
        
        btnServerStart.setOnAction(e-> { serverStart(e); });
    }
    
    public void serverStart(ActionEvent event){
    	if (btnServerStart.getText().equals("Server Start")) {
				try {
					mainServerSocket = null;
					taOutputMsg.setText("ip : " + InetAddress.getLocalHost() + "\n");
					
					// ���1
					//mainServerSocket = new ServerSocket(port��ȣ);
					
					// ���2
					mainServerSocket = new ServerSocket();
					mainServerSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 4040));
					
					taOutputMsg.appendText("������ ���Ƚ��ϴ�.\n\n");
					btnServerStart.setText("Server Stop");
					lblCount.setText(socketList.size() + " ��");
				
					ConnectThread connectThread = new ConnectThread(mainServerSocket);
					connectThread.setDaemon(true);
					connectThread.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
    	} else if (btnServerStart.getText().equals("Server Stop")) {
    		try {
    			taOutputMsg.appendText("\n������ �������ϴ�.\n\n");
                btnServerStart.setText("Server Start");                    
                
                // to send 'SERVER CLOSE' message to Client
                String sendMessage = "FFFF";
                byte[] byteArray = sendMessage.getBytes("UTF-8");
                for (int i = 0; i < socketList.size(); i++) {
                    OutputStream outputStream = socketList.get(i).getOutputStream();
                    outputStream.write(byteArray);
                }
                socketList.clear();
                mainServerSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    //------------------------------------------------------------------------------
    // Connect class
    class ConnectThread extends Thread {
    	ServerSocket mainServerSocket = null;
 
        ConnectThread(ServerSocket mainServerSocket) {
            this.mainServerSocket = mainServerSocket;
        }
 
        @Override
        public void run() {
            try {
                while (true) {
                    Socket serverSocket = mainServerSocket.accept();
                    
                    //outputField.setText("����� ����!");
 
                    socketList.add(serverSocket);
                    Platform.runLater(() -> {
                        lblCount.setText(socketList.size() + " ��");
                    });
 					
                    InputStream inputStream = serverSocket.getInputStream();
                    byte[] byteArray = new byte[256];
                    int size = inputStream.read(byteArray);
 
                    //System.out.println("------------>>>> size : " + size);
                    
                    if (size == -1) { // 
                        for (int i = 0; i < socketList.size();) {
                            if (serverSocket == socketList.get(i)) {
                            	socketList.remove(i);
                            } else {
                                i++;
                            }
                            Platform.runLater(() -> {
                                lblCount.setText(socketList.size() + " ��");
                            });
                        }
                        break;
                    }
                    String readMessage = new String(byteArray, 0, size, "UTF-8");
                    Platform.runLater(() -> {
                        taOutputMsg.appendText(readMessage + "�� ����\n");
                    });
                    
                    //--
                    
                    String sendMessage = readMessage +"���� �����ϼ̽��ϴ�.";
                    byteArray = sendMessage.getBytes("UTF-8");
                    for (int i = 0; i < socketList.size(); i++) {
                    	if (serverSocket != socketList.get(i)){
	                        OutputStream outputStream = socketList.get(i).getOutputStream();
	                        outputStream.write(byteArray);
	                        outputStream.flush();
                    	}
                    }
                    //--
                    
                    ServerReader serverReader = new ServerReader(serverSocket);
                    serverReader.start();
                }
            } catch (Exception e) {
            	//System.out.println("==> " + mainServerSocket.isClosed());
            	if(!mainServerSocket.isClosed())
            		e.printStackTrace();
            }
        }
    }
    //-------------------------------------------------------------------------------
    // Reader class
    class ServerReader extends Thread {
        Socket serverSocket = null;
 
        ServerReader(Socket serverSocket) {
            this.serverSocket = serverSocket;
        }
 
        @Override
        public void run() {
            try {
                while (true) {
                    InputStream inputStream = serverSocket.getInputStream();
                    byte[] byteArray = new byte[256];
                    int size = inputStream.read(byteArray);
                    //System.out.println("<<<<<============>>>> size = " + size);
                    if (size == -1) { // if(Logout)
                        for (int i = 0; i < socketList.size();) {
                            if (serverSocket == socketList.get(i)) {
                            	socketList.remove(i);
                            } else {
                                i++;
                            }
                            Platform.runLater(() -> {
                                lblCount.setText(socketList.size() + " ��");
                            });
                        }
                        break;
                    }
 
                    String readMessage = new String(byteArray, 0, size, "UTF-8");
                    byteArray = readMessage.getBytes("UTF-8");
                    
                    //--------------------------
                    for (int i = 0; i < socketList.size(); i++) {
							OutputStream outputStream = socketList.get(i).getOutputStream();
							outputStream.write(byteArray);
                    }
                    //---------------------------
                    
                }
            } catch (Exception e) {
                for (int i = 0; i < socketList.size();) {
                    if (serverSocket == socketList.get(i)) {
                    	socketList.remove(i);
                    } else {
                        i++;
                    }
                    Platform.runLater(() -> {
                        lblCount.setText(socketList.size() + " ��");
                    });
                }
            }
        }
    }
    //-----------------------------------------------------------------------------
    
}
