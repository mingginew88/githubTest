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
		
		Menu fileMenu = new Menu("파일");
		Menu editMenu = new Menu("편집");
		Menu formMenu = new Menu("서식");
		Menu viewMenu = new Menu("보기");
		Menu helpMenu = new Menu("도움말");		
		
		MenuItem newMenuItem = new MenuItem("새로만들기");
		MenuItem openMenuItem = new MenuItem("열기");
		MenuItem saveMenuItem = new MenuItem("저장");
		MenuItem exitMenuItem = new MenuItem("끝내기");		
		
		fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, exitMenuItem);
		
		
		newMenuItem.setOnAction(e->{
			boolean result = confirm("변경내용을 저장하시겠습니까?", "");
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
			
			if(selectedFile!=null) {	//실제로 작업을 해야하는 공간
				File file = new File(selectedFile.getPath());// 주소값
				FileInputStream fis = null;
				
				try {
					fis = new FileInputStream(file);
					int c; 	//문서를 잘게 int형으로 쪼갬
					String string = "";	// 쪼개진 int형을 char형값으로 문자로 변환
					while((c=fis.read()) != -1) {
						string += (char)c;
					}
					txtArea.setText(string);
					fis.close();
					
					title = selectedFile.getName();
					primaryStage.setTitle(title + " - " +"메모장");
					
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
		primaryStage.setTitle(title + "메모장");
		primaryStage.show();		
		
	}
	
	
	//Confirm창
	public boolean confirm(String header, String msg) {
		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.setTitle("선택");
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
		
		if(selectedFile!=null) {	//실제 저장하는 작업이 이루어져야하는 공간				
			try {					
				FileWriter fw = new FileWriter(selectedFile.getPath());
				String line = "";
				
				StringReader sReader = new StringReader(txtArea.getText());
				BufferedReader br = new BufferedReader(sReader);
				
				while((line = br.readLine()) != null) { // 읽어오는 줄이 null값이 아닌동안
					fw.write(line);
				}
				fw.flush();
				fw.close();
				
				title = selectedFile.getName();
				primaryStage_copy.setTitle(title + " - " +"메모장");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
