package board.main;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import board.service.BoardService;
import board.service.IBoardService;
import board.vo.BoardVO;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class NewBoardController {
	
	private ObservableList<BoardVO> boardList;
	private IBoardService boardService;
	
    public void setBoardList(ObservableList<BoardVO> boardList) {
		this.boardList = boardList;
	}

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private BorderPane borderRoot;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private Label lblWriter;

    @FXML
    private TextField tfWriter;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea txtArea;    
    
    @FXML
    void cancelNewBoard(ActionEvent event) throws IOException {
    	Parent main = FXMLLoader.load(getClass().getResource("BoardList.fxml"));
		StackPane root = (StackPane) btnCancel.getScene().getRoot();
		root.getChildren().add(main);
		
		main.setTranslateX(600);
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(main.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(300),
				new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().remove(borderRoot);
				}
		}, 
		keyValue);
		
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		
    }

    @FXML
    void saveNewBoard(ActionEvent event) throws IOException {
    	String writer = tfWriter.getText();
    	String title = tfTitle.getText();
    	String content = txtArea.getText();
    	   	
    	BoardVO boardVo = new BoardVO();     	
    	boardVo.setBoard_writer(writer);
    	boardVo.setBoard_title(title);
    	boardVo.setBoard_content(content);    	
    	int cnt = boardService.addNewBoard(boardVo);    	
    	
    	if(cnt>0) { 
    		//boardList.add(boardVo);   // 테이블뷰의 자료 갱신
			info("작업성공", "데이터 추가 작업 성공!!!");
			tfWriter.clear();
			tfTitle.clear();
			txtArea.clear();
			
			Parent main = FXMLLoader.load(getClass().getResource("BoardList.fxml"));
			StackPane root = (StackPane) btnSave.getScene().getRoot();
			root.getChildren().add(main);
			
			main.setTranslateX(600);
			
			Timeline timeline = new Timeline();
			KeyValue keyValue = new KeyValue(main.translateXProperty(), 0);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(300),
					new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						root.getChildren().remove(borderRoot);
					}
			}, 
			keyValue);
			
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
			
			
			
		}else {  // DB에 데이터 추가 작업 실패
			alert("추가실패", "데이터 추가 작업 실패~~");
		}
    	
    }

    @FXML
    void initialize() {
    	assert borderRoot != null : "fx:id=\"borderRoot\" was not injected: check your FXML file 'NewBoard.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'NewBoard.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'NewBoard.fxml'.";
        assert lblWriter != null : "fx:id=\"lblWriter\" was not injected: check your FXML file 'NewBoard.fxml'.";
        assert tfWriter != null : "fx:id=\"tfWriter\" was not injected: check your FXML file 'NewBoard.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'NewBoard.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'NewBoard.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'NewBoard.fxml'.";
        
        boardService = BoardService.getInstance();
        
    }
    
    
    //정보 출력하는 Alert창 메서드
  	public void info(String header, String msg) {
  		Alert alertInfo = new Alert(AlertType.INFORMATION);
  		alertInfo.setTitle("정보확인");
  		alertInfo.setHeaderText(header);
  		alertInfo.setContentText(msg);
  		alertInfo.showAndWait();
  	}
    
    //경고창
  	public void alert(String header, String msg) {
  		Alert alert = new Alert(AlertType.WARNING);
  		alert.setTitle("경고");
  		alert.setHeaderText(header);
  		alert.setContentText(msg);
  		alert.showAndWait();
  	}
  	
    
}
