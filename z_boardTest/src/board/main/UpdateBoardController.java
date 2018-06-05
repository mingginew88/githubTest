package board.main;

import java.io.IOException;
import java.net.URL;
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

public class UpdateBoardController {
	private BoardVO boardVo;

    public void setBoardVo(BoardVO boardVo) {
		this.boardVo = boardVo;
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private BorderPane borderRoot;

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
    private Button btnUpdate;

    @FXML
    private Button btnCancel;

    @FXML
    void UpdateBoard(ActionEvent event) {
		try {
			boardVo.setBoard_writer(tfWriter.getText());
			boardVo.setBoard_title(tfTitle.getText());
			boardVo.setBoard_content(txtArea.getText());
			
			int cnt = boardService.updateBoard(boardVo);    	
			
			if(cnt>0) { 
				//boardList.add(boardVo);   // 테이블뷰의 자료 갱신
				info("작업성공", "데이터 수정 작업 성공!!!");
				tfWriter.clear();
				tfTitle.clear();
				txtArea.clear();
			Parent main = FXMLLoader.load(getClass().getResource("BoardList.fxml"));
			
			StackPane root = (StackPane) btnUpdate.getScene().getRoot();
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
			
			}else {  // DB에 데이터 수정 작업 실패
				alert("수정실패", "데이터 수정 작업 실패~~");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void cancelUpdateBoard(ActionEvent event) throws IOException {
    	FXMLLoader main = new FXMLLoader(getClass().getResource("BoardInfo.fxml"));
		Parent content = main.load();
		StackPane root = (StackPane) btnCancel.getScene().getRoot();     
		
		root.getChildren().add(content);
		content.setTranslateX(600);
		
		BoardInfoController boardInfoController =  main.getController();
		boardInfoController.setBoardVo(boardVo);
		boardInfoController.content();
		
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(content.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
		
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
    	

    }
    
    
    public void content() {
    	tfWriter.setText(boardVo.getBoard_writer());
    	tfTitle.setText(boardVo.getBoard_title());    	
    	txtArea.setText(boardVo.getBoard_content());
    }
    
    
    
    private IBoardService boardService;
    private ObservableList<BoardVO> boardList;
    BoardListController boardListController;
    

    @FXML
    void initialize() {
    	 assert borderRoot != null : "fx:id=\"borderRoot\" was not injected: check your FXML file 'UpdateBoard.fxml'.";
        assert lblWriter != null : "fx:id=\"lblWriter\" was not injected: check your FXML file 'UpdateBoard.fxml'.";
        assert tfWriter != null : "fx:id=\"tfWriter\" was not injected: check your FXML file 'UpdateBoard.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'UpdateBoard.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'UpdateBoard.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'UpdateBoard.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'UpdateBoard.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'UpdateBoard.fxml'.";
        
        boardService = BoardService.getInstance();
        
        //content();

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
