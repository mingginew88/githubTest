package memoTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MemoTest extends Application {
	static String title = "";
	Stage primaryStage_copy;
	
	TextArea txtArea = new TextArea();

	@Override
	public void start(Stage primaryStage) {
		primaryStage_copy = primaryStage;
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 300, 250);
		
		MenuBar menuBar = new MenuBar();			
		
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.setTop(menuBar);
		root.setCenter(txtArea);
		
		Menu fileMenu = new Menu("����");
		Menu editMenu = new Menu("����");
		Menu formMenu = new Menu("����");
		Menu viewMenu = new Menu("����");
		Menu helpMenu = new Menu("����");		
		
		MenuItem newMenuItem = new MenuItem("���θ����");
		MenuItem openMenuItem = new MenuItem("����");
		MenuItem saveMenuItem = new MenuItem("����");
		MenuItem exitMenuItem = new MenuItem("������");		
		
		fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, exitMenuItem);
		
		
		newMenuItem.setOnAction(e->{
			boolean result = confirm("���泻���� �����Ͻðڽ��ϱ�?", "");
			if(result) {				
				saveMenu();				
			}
			txtArea.clear();
		});
		
		
		openMenuItem.setOnAction(e->{
			FileChooser fileChooser = new FileChooser();
			
			fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text Files", "*txt"),
					new ExtensionFilter("All Files", "*.*")
			);
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			
			if(selectedFile!=null) {	//������ �۾��� �ؾ��ϴ� ����
				File file = new File(selectedFile.getPath());// �ּҰ�
				FileInputStream fis = null;
				
				try {
					fis = new FileInputStream(file);
					int c; 	//������ �߰� int������ �ɰ�
					String string = "";	// �ɰ��� int���� char�������� ���ڷ� ��ȯ
					while((c=fis.read()) != -1) {
						string += (char)c;
					}
					txtArea.setText(string);
					fis.close();
					
					title = selectedFile.getName();
					primaryStage.setTitle(title + " - " +"�޸���");
					
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		saveMenuItem.setOnAction(e->{
			saveMenu();
		});
		
		exitMenuItem.setOnAction(e->{
			Platform.exit();
		});	
		
		menuBar.getMenus().addAll(fileMenu, editMenu, formMenu, viewMenu, helpMenu);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle(title + "�޸���");
		primaryStage.show();		
		
	}
	
	
	//Confirmâ
	public boolean confirm(String header, String msg) {
		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.setTitle("����");
		confirm.setHeaderText(header);
		confirm.setContentText(msg);
		
		ButtonType conResult = confirm.showAndWait().get();
		boolean result = false;
		if(conResult==ButtonType.OK) {
			result = true;
		} else if(conResult==ButtonType.CANCEL) {
			result = false;
		}
		return result;
	}
	
	
	public void saveMenu() {
		FileChooser fileChooser = new FileChooser();
		
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("All Files", "*.*")
		);
		
		File selectedFile = fileChooser.showSaveDialog(primaryStage_copy);
		
		if(selectedFile!=null) {	//���� �����ϴ� �۾��� �̷�������ϴ� ����				
			try {					
				FileWriter fw = new FileWriter(selectedFile.getPath());
				String line = "";
				
				StringReader sReader = new StringReader(txtArea.getText());
				BufferedReader br = new BufferedReader(sReader);
				
				while((line = br.readLine()) != null) { // �о���� ���� null���� �ƴѵ���
					fw.write(line);
				}
				fw.flush();
				fw.close();
				
				title = selectedFile.getName();
				primaryStage_copy.setTitle(title + " - " +"�޸���");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
