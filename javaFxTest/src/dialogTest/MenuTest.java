package dialogTest;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 300, 250);
		
		MenuBar menuBar = new MenuBar();
		
		//윈도우 창에 크기에 맞춰서 MenuBar의 크기가 자동 변경
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.setTop(menuBar);
		
		//File Menu ==> new, save, open, exit
		Menu fileMenu = new Menu("File");
		
		//부메뉴 작성
		MenuItem newMenuItem = new MenuItem("Menu");
		MenuItem saveMenuItem = new MenuItem("Save");
		MenuItem openMenuItem = new MenuItem("Open");
		MenuItem exitMenuItem = new MenuItem("Exit");
		
		//부메뉴를 주메뉴에 추가하기
		fileMenu.getItems().addAll(newMenuItem, saveMenuItem, openMenuItem, exitMenuItem);
		
		//부메뉴를 선택했을 때 이벤트 처리
		exitMenuItem.setOnAction(e->{
			Platform.exit(); //프로그램 종료
		});
		//-------------------------------------------------------
		
		
		Menu webMenu = new Menu("Web");
		
		CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
		htmlMenuItem.setSelected(true); 	//체크된 상태
		
		CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
		cssMenuItem.setSelected(false);		//미체크된 상태
		
		webMenu.getItems().addAll(htmlMenuItem, cssMenuItem);
		//-------------------------------------------------------
		
		
		Menu dbMenu = new Menu("DataBase");
		ToggleGroup tg = new ToggleGroup();
		
		RadioMenuItem mysqlMenuItem = new RadioMenuItem("MySQL");
		mysqlMenuItem.setToggleGroup(tg);
		
		RadioMenuItem oracleMenuItem = new RadioMenuItem("Oracle");
		oracleMenuItem.setToggleGroup(tg);
		oracleMenuItem.setSelected(true);
		
		RadioMenuItem mssqlMenuItem = new RadioMenuItem("MS-SQL");
		mssqlMenuItem.setToggleGroup(tg);
		
		dbMenu.getItems().addAll(mysqlMenuItem, oracleMenuItem, mssqlMenuItem);
		//-------------------------------------------------------
		
		//부메뉴
		Menu tutorialMenu = new Menu("Tutorial");
		tutorialMenu.getItems().addAll(
			new CheckMenuItem("JAVA"),
			new CheckMenuItem("C"),
			new CheckMenuItem("C++"),
			new CheckMenuItem("JavaFX")
		);
		
		dbMenu.getItems().addAll(new SeparatorMenuItem() , tutorialMenu);
		
		
		//메뉴바에 주메뉴들 추가하기
		menuBar.getMenus().addAll(fileMenu, webMenu, dbMenu);
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("메뉴만들기");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
