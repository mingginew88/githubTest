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
		
		Button btnFileOpen = new Button("Open FileChooser 실행");
		Button btnFileSave = new Button("Save FileChooser 실행");
		Button btnDirectory = new Button("Directory FileChooser 실행");
		Button btnPopup = new Button("PopUp 실행");
		
		
		//파일 열기 창
		btnFileOpen.setOnAction(e->{
			FileChooser filechooser = new FileChooser();
			
			//선택할 파일의 종류 설정
			filechooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text Files","*.txt"),
					new ExtensionFilter("Image Files","*.png", "*.gif", "*.jpg"),
					new ExtensionFilter("Audio Files", "*.wav", "*.mp3"),
					new ExtensionFilter("All Files", "*.*")
			);
			
			//파일 열기창 실행
			//반환값 ==> 선택한 파일의 File객체 반환한다.
			File selectedFile = filechooser.showOpenDialog(primaryStage);
			
			if(selectedFile!=null) {	//실제로 작업을 해야하는 공간
				System.out.println("선택한 파일 : " + selectedFile.getPath());
			}
		});	//좌측상단에 열기 라고 뜸.
		
		
		//파일 저장 창
		btnFileSave.setOnAction(e->{
			FileChooser filechooser = new FileChooser();
			
			//선택할 파일의 종류 설정
			filechooser.getExtensionFilters().addAll(					
					new ExtensionFilter("All Files", "*.*")
			);
			
			//파일 저장창 실행
			//반환값 ==> 선택한 파일의 File객체를 반환한다.
			File selectedFile = filechooser.showSaveDialog(primaryStage);	//아직 저장 작업이 이루어지지않음.
			
			if(selectedFile!=null) {	//실제 저장하는 작업이 이루어져야하는 공간
				System.out.println("Save 선택 파일 : " + selectedFile.getPath());
			}
		}); //좌측상단에 다른이름으로 저장 이라고 뜸.
		
		
		//디렉토리(폴더) 변경 창
		btnDirectory.setOnAction(e->{
			DirectoryChooser dirChooser = new DirectoryChooser();
			
			//디렉토리 변경 창 실행
			//반환값 : 변경된 디렉토리에 대한 File객체 반환
			File selectDir = dirChooser.showDialog(primaryStage);
			
			if(selectDir!=null) {
				System.out.println("변경된 디렉토리 위치 : " + selectDir.getPath());
			}
		});	//좌측상단에 폴더선택 이라고 뜸.
		
		
		//팝업 창 ==> 간단한 메시지 전달용으로 사용되는 창으로 자동으로 닫히는 기능이 있다.
		btnPopup.setOnAction(e->{
			Popup popup = new Popup();
			
			HBox popRoot = new HBox();
			popRoot.setAlignment(Pos.CENTER_LEFT);
			popRoot.setStyle("-fx-background-color:black; -fx-background-radius:20;"); 
			
			ImageView imgView = new ImageView();
			imgView.setImage(new Image(getClass().getResourceAsStream("../basic/controlTest/images/ok.png")));
			
			imgView.setFitHeight(30); //보여줄 이미지 크기 설정
			imgView.setFitWidth(30);
			
			//이미지를 클릭했을 때 처리
			imgView.setOnMouseClicked(ee->{
				popup.hide(); 	//팝업창 닫기
			});
			
			Label lblMsg = new Label("메시지가 도착했습니다.");
			lblMsg.setTextFill(Color.web("red"));
			
			popRoot.getChildren().addAll(imgView, lblMsg);
			
			popup.getContent().add(popRoot);
			//창이 나타난 이후에 다른곳을 클릭하면 창이 자동으로 닫힌다.
			popup.setAutoHide(false);
			popup.show(primaryStage);
		});
		
		
		
		
		
		
		root.getChildren().addAll(btnFileOpen, btnFileSave, btnDirectory, btnPopup);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Dialog 연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
