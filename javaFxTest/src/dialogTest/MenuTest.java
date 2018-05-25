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
		
		//������ â�� ũ�⿡ ���缭 MenuBar�� ũ�Ⱑ �ڵ� ����
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.setTop(menuBar);
		
		//File Menu ==> new, save, open, exit
		Menu fileMenu = new Menu("File");
		
		//�θ޴� �ۼ�
		MenuItem newMenuItem = new MenuItem("Menu");
		MenuItem saveMenuItem = new MenuItem("Save");
		MenuItem openMenuItem = new MenuItem("Open");
		MenuItem exitMenuItem = new MenuItem("Exit");
		
		//�θ޴��� �ָ޴��� �߰��ϱ�
		fileMenu.getItems().addAll(newMenuItem, saveMenuItem, openMenuItem, exitMenuItem);
		
		//�θ޴��� �������� �� �̺�Ʈ ó��
		exitMenuItem.setOnAction(e->{
			Platform.exit(); //���α׷� ����
		});
		//-------------------------------------------------------
		
		
		Menu webMenu = new Menu("Web");
		
		CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
		htmlMenuItem.setSelected(true); 	//üũ�� ����
		
		CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
		cssMenuItem.setSelected(false);		//��üũ�� ����
		
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
		
		//�θ޴�
		Menu tutorialMenu = new Menu("Tutorial");
		tutorialMenu.getItems().addAll(
			new CheckMenuItem("JAVA"),
			new CheckMenuItem("C"),
			new CheckMenuItem("C++"),
			new CheckMenuItem("JavaFX")
		);
		
		dbMenu.getItems().addAll(new SeparatorMenuItem() , tutorialMenu);
		
		
		//�޴��ٿ� �ָ޴��� �߰��ϱ�
		menuBar.getMenus().addAll(fileMenu, webMenu, dbMenu);
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("�޴������");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
