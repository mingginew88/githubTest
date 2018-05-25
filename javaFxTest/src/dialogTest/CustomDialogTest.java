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
	public void start(Stage primaryStage) {	 //window 창을 나타내는 것이 Stage
		VBox root = new VBox(15);
		root.setPadding(new Insets(15));
		root.setAlignment(Pos.CENTER);
		
		Button btnNone = new Button("None Dialog");
		btnNone.setOnAction(e->{
			/*
			 	StageStyle.DECORATED  ==> 기본 창
			 	StageStyle.UNDECORATED ==> 장식이 없는 창
			 	StageStyle.UTILITY ==> 최소한의 장식만 있는 창
			 	StageStyle.UNIFIED ==> 출력 영역과 장식사이의 경계가 없다.
			 	StageStyle.TRANSPARENT ==> 투명한 배경과 장식이 없는 창
			 */
			Stage dialogNONE = new Stage(StageStyle.DECORATED);
			
			dialogNONE.initModality(Modality.NONE); //모달(양식)창 종류 지정
			dialogNONE.initOwner(primaryStage);		//부모창 지정
			
			VBox vbox = new VBox(10);
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(10));
			
			Text txt1 = new Text("NONE Dialog");
			Text txt2 = new Text("모달 기능이 없는 창 - 모달리스 창");
			
			vbox.getChildren().addAll(txt1, txt2);
			
			Scene sceneNONE = new Scene(vbox, 400, 200);
			dialogNONE.setScene(sceneNONE);
			dialogNONE.setTitle("NONE Dialog");
			dialogNONE.show();
		});
		
		
		Button btnAppModal = new Button("APPLICATION_MODAL Dialog");		
		btnAppModal.setOnAction(e->{
			Stage dialAppModal = new Stage(StageStyle.UNIFIED);
			
			dialAppModal.initModality(Modality.APPLICATION_MODAL); //모달(양식)창 종류 지정
			dialAppModal.initOwner(primaryStage);		//부모창 지정
			
			VBox vbox = new VBox(10);
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(10));
			
			Text txt1 = new Text("APPLICATION_MODAL Dialog");
			Text txt2 = new Text("부모창 및 다른 응용프로그램 창(자식창)을 선택하지 못하는 모달창");
			
			vbox.getChildren().addAll(txt1, txt2);
			
			Scene sceneAppModel = new Scene(vbox, 400, 200);
			dialAppModal.setScene(sceneAppModel);
			dialAppModal.setTitle("APPLICATION_MODAL Dialog");
			dialAppModal.show();
		});
		
		
		Button btnWinModal = new Button("WINDOW_MODAL Dialog");
		btnWinModal.setOnAction(e->{
			Stage dialWinModal = new Stage(StageStyle.TRANSPARENT);
			
			dialWinModal.initModality(Modality.WINDOW_MODAL); //모달(양식)창 종류 지정
			dialWinModal.initOwner(primaryStage);		//부모창 지정
			
			VBox vbox = new VBox(10);
			// 1. transparent 설정1.
			vbox.setStyle("-fx-background-color:transparent");
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(10));
			
			Text txt1 = new Text("WINDOW_MODAL Dialog");
			Text txt2 = new Text("부모창을 선택하지 못하는 모달창");
			
			vbox.getChildren().addAll(txt1, txt2);
			
			Scene sceneWinModel = new Scene(vbox, 400, 200);
			// 2. transparent 설정2.
			sceneWinModel.setFill(Color.TRANSPARENT);
			dialWinModal.setScene(sceneWinModel);
			dialWinModal.setTitle("WINDOW_MODAL Dialog");
			dialWinModal.show();
		});
		
		//--------------------------------------------------------------------
		Button btnFxml = new Button("FXML문서 자식창");
		btnFxml.setOnAction(e->{
			try {
				Stage fxmlDialog = new Stage(StageStyle.DECORATED);
				fxmlDialog.initModality(Modality.WINDOW_MODAL);
				fxmlDialog.initOwner(primaryStage);
				
				//Parent chRoot = FXMLLoader.load(getClass().getResource("CustomChild.fxml"));
				
				//FXML문서에 지정한 Controller객체 구하기
				FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomChild.fxml"));
				Parent chRoot = loader.load();
				
				// Controller객체를 가져온다. 
				CustomChildController childController = loader.getController();
				// Controller객체의 메서드 호출(부모창의 Stage를 셋팅한다.)
				childController.setParentStage(fxmlDialog);
				
				Scene sceneFxml = new Scene(chRoot);
				fxmlDialog.setScene(sceneFxml);
				fxmlDialog.setTitle("FXML로 만든 자식창");
				fxmlDialog.show();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		});		
		
		root.getChildren().addAll(btnNone, btnAppModal, btnWinModal, btnFxml);	
		
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("사용자 정의 Dialog 연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
