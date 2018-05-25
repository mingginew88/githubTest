package dialogTest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomDialogTest extends Application {

	@Override
	public void start(Stage primaryStage) {	 //window â�� ��Ÿ���� ���� Stage
		VBox root = new VBox(15);
		root.setPadding(new Insets(15));
		root.setAlignment(Pos.CENTER);
		
		Button btnNone = new Button("None Dialog");
		btnNone.setOnAction(e->{
			/*
			 	StageStyle.DECORATED  ==> �⺻ â
			 	StageStyle.UNDECORATED ==> ����� ���� â
			 	StageStyle.UTILITY ==> �ּ����� ��ĸ� �ִ� â
			 	StageStyle.UNIFIED ==> ��� ������ ��Ļ����� ��谡 ����.
			 	StageStyle.TRANSPARENT ==> ������ ���� ����� ���� â
			 */
			Stage dialogNONE = new Stage(StageStyle.DECORATED);
			
			dialogNONE.initModality(Modality.NONE); //���(���)â ���� ����
			dialogNONE.initOwner(primaryStage);		//�θ�â ����
			
			VBox vbox = new VBox(10);
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(10));
			
			Text txt1 = new Text("NONE Dialog");
			Text txt2 = new Text("��� ����� ���� â - ��޸��� â");
			
			vbox.getChildren().addAll(txt1, txt2);
			
			Scene sceneNONE = new Scene(vbox, 400, 200);
			dialogNONE.setScene(sceneNONE);
			dialogNONE.setTitle("NONE Dialog");
			dialogNONE.show();
		});
		
		
		Button btnAppModal = new Button("APPLICATION_MODAL Dialog");		
		btnAppModal.setOnAction(e->{
			Stage dialAppModal = new Stage(StageStyle.UNIFIED);
			
			dialAppModal.initModality(Modality.APPLICATION_MODAL); //���(���)â ���� ����
			dialAppModal.initOwner(primaryStage);		//�θ�â ����
			
			VBox vbox = new VBox(10);
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(10));
			
			Text txt1 = new Text("APPLICATION_MODAL Dialog");
			Text txt2 = new Text("�θ�â �� �ٸ� �������α׷� â(�ڽ�â)�� �������� ���ϴ� ���â");
			
			vbox.getChildren().addAll(txt1, txt2);
			
			Scene sceneAppModel = new Scene(vbox, 400, 200);
			dialAppModal.setScene(sceneAppModel);
			dialAppModal.setTitle("APPLICATION_MODAL Dialog");
			dialAppModal.show();
		});
		
		
		Button btnWinModal = new Button("WINDOW_MODAL Dialog");
		btnWinModal.setOnAction(e->{
			Stage dialWinModal = new Stage(StageStyle.TRANSPARENT);
			
			dialWinModal.initModality(Modality.WINDOW_MODAL); //���(���)â ���� ����
			dialWinModal.initOwner(primaryStage);		//�θ�â ����
			
			VBox vbox = new VBox(10);
			// 1. transparent ����1.
			vbox.setStyle("-fx-background-color:transparent");
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(10));
			
			Text txt1 = new Text("WINDOW_MODAL Dialog");
			Text txt2 = new Text("�θ�â�� �������� ���ϴ� ���â");
			
			vbox.getChildren().addAll(txt1, txt2);
			
			Scene sceneWinModel = new Scene(vbox, 400, 200);
			// 2. transparent ����2.
			sceneWinModel.setFill(Color.TRANSPARENT);
			dialWinModal.setScene(sceneWinModel);
			dialWinModal.setTitle("WINDOW_MODAL Dialog");
			dialWinModal.show();
		});
		
		//--------------------------------------------------------------------
		Button btnFxml = new Button("FXML���� �ڽ�â");
		btnFxml.setOnAction(e->{
			try {
				Stage fxmlDialog = new Stage(StageStyle.DECORATED);
				fxmlDialog.initModality(Modality.WINDOW_MODAL);
				fxmlDialog.initOwner(primaryStage);
				
				//Parent chRoot = FXMLLoader.load(getClass().getResource("CustomChild.fxml"));
				
				//FXML������ ������ Controller��ü ���ϱ�
				FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomChild.fxml"));
				Parent chRoot = loader.load();
				
				// Controller��ü�� �����´�. 
				CustomChildController childController = loader.getController();
				// Controller��ü�� �޼��� ȣ��(�θ�â�� Stage�� �����Ѵ�.)
				childController.setParentStage(fxmlDialog);
				
				Scene sceneFxml = new Scene(chRoot);
				fxmlDialog.setScene(sceneFxml);
				fxmlDialog.setTitle("FXML�� ���� �ڽ�â");
				fxmlDialog.show();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		});		
		
		root.getChildren().addAll(btnNone, btnAppModal, btnWinModal, btnFxml);	
		
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("����� ���� Dialog ����");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
