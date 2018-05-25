package dialogTest;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class DialogTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox(15);
		root.setPadding(new Insets(10));
		
		Button btnFileOpen = new Button("Open FileChooser ����");
		Button btnFileSave = new Button("Save FileChooser ����");
		Button btnDirectory = new Button("Directory FileChooser ����");
		Button btnPopup = new Button("PopUp ����");
		
		
		//���� ���� â
		btnFileOpen.setOnAction(e->{
			FileChooser filechooser = new FileChooser();
			
			//������ ������ ���� ����
			filechooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text Files","*.txt"),
					new ExtensionFilter("Image Files","*.png", "*.gif", "*.jpg"),
					new ExtensionFilter("Audio Files", "*.wav", "*.mp3"),
					new ExtensionFilter("All Files", "*.*")
			);
			
			//���� ����â ����
			//��ȯ�� ==> ������ ������ File��ü ��ȯ�Ѵ�.
			File selectedFile = filechooser.showOpenDialog(primaryStage);
			
			if(selectedFile!=null) {	//������ �۾��� �ؾ��ϴ� ����
				System.out.println("������ ���� : " + selectedFile.getPath());
			}
		});	//������ܿ� ���� ��� ��.
		
		
		//���� ���� â
		btnFileSave.setOnAction(e->{
			FileChooser filechooser = new FileChooser();
			
			//������ ������ ���� ����
			filechooser.getExtensionFilters().addAll(					
					new ExtensionFilter("All Files", "*.*")
			);
			
			//���� ����â ����
			//��ȯ�� ==> ������ ������ File��ü�� ��ȯ�Ѵ�.
			File selectedFile = filechooser.showSaveDialog(primaryStage);	//���� ���� �۾��� �̷����������.
			
			if(selectedFile!=null) {	//���� �����ϴ� �۾��� �̷�������ϴ� ����
				System.out.println("Save ���� ���� : " + selectedFile.getPath());
			}
		}); //������ܿ� �ٸ��̸����� ���� �̶�� ��.
		
		
		//���丮(����) ���� â
		btnDirectory.setOnAction(e->{
			DirectoryChooser dirChooser = new DirectoryChooser();
			
			//���丮 ���� â ����
			//��ȯ�� : ����� ���丮�� ���� File��ü ��ȯ
			File selectDir = dirChooser.showDialog(primaryStage);
			
			if(selectDir!=null) {
				System.out.println("����� ���丮 ��ġ : " + selectDir.getPath());
			}
		});	//������ܿ� �������� �̶�� ��.
		
		
		//�˾� â ==> ������ �޽��� ���޿����� ���Ǵ� â���� �ڵ����� ������ ����� �ִ�.
		btnPopup.setOnAction(e->{
			Popup popup = new Popup();
			
			HBox popRoot = new HBox();
			popRoot.setAlignment(Pos.CENTER_LEFT);
			popRoot.setStyle("-fx-background-color:black; -fx-background-radius:20;"); 
			
			ImageView imgView = new ImageView();
			imgView.setImage(new Image(getClass().getResourceAsStream("../basic/controlTest/images/ok.png")));
			
			imgView.setFitHeight(30); //������ �̹��� ũ�� ����
			imgView.setFitWidth(30);
			
			//�̹����� Ŭ������ �� ó��
			imgView.setOnMouseClicked(ee->{
				popup.hide(); 	//�˾�â �ݱ�
			});
			
			Label lblMsg = new Label("�޽����� �����߽��ϴ�.");
			lblMsg.setTextFill(Color.web("red"));
			
			popRoot.getChildren().addAll(imgView, lblMsg);
			
			popup.getContent().add(popRoot);
			//â�� ��Ÿ�� ���Ŀ� �ٸ����� Ŭ���ϸ� â�� �ڵ����� ������.
			popup.setAutoHide(false);
			popup.show(primaryStage);
		});
		
		
		
		
		
		
		root.getChildren().addAll(btnFileOpen, btnFileSave, btnDirectory, btnPopup);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dialog ����");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
