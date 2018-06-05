package board.main;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class BoardInfoController {
	
	private BoardVO boardVo;

    public void setBoardVo(BoardVO boardVo) {
		this.boardVo = boardVo;
	}

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private BorderPane borderRoot;

    @FXML
    private URL location;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnBack;

    @FXML
    private Label lblWriter;

    @FXML
    private TextField tfWriter;

    @FXML
    private Label lblDate;

    @FXML
    private TextField tfDate;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea txtArea;

    @FXML
    void boardDelete(ActionEvent event) throws IOException {
    	int num = boardVo.getBoard_no();
    	int cnt = boardService.deleteBoard(num);
    	
    	if(cnt > 0) {
    		info("정보확인", "삭제하였습니다.");
    		Parent main = FXMLLoader.load(getClass().getResource("BoardList.fxml"));
        	StackPane root = (StackPane)btnBack.getScene().getRoot();
        	root.getChildren().add(main);
        	main.setTranslateX(600);
        	
        	Timeline timeline = new Timeline();
    		KeyValue keyValue = new KeyValue(main.translateXProperty(), 0);
    		KeyFrame keyFrame = new KeyFrame(Duration.millis(300),keyValue);
    		
    		timeline.getKeyFrames().add(keyFrame);
    		
    		timeline.play();
    		
    	}else {
    		alert("삭제 실패!!", "글 삭제에 실패하셨습니다!");
    	}
    }

    @FXML
    void boardUpdate(ActionEvent event) {
    	//FIXME 현재 정보창에서 수정버튼을 눌렀을시 발생하는 에러문제 해결해야한다.
		try {
			FXMLLoader main = new FXMLLoader(getClass().getResource("UpdateBoard.fxml"));
			Parent content = main.load();
			StackPane root = (StackPane) btnUpdate.getScene().getRoot();     
			
			root.getChildren().add(content);
			content.setTranslateX(600);
			
			UpdateBoardController updateBoardController =  main.getController();
			updateBoardController.setBoardVo(boardVo);
			updateBoardController.content();
			
			Timeline timeline = new Timeline();
			KeyValue keyValue = new KeyValue(content.translateXProperty(), 0);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
			
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void gotoBoardList(ActionEvent event) throws IOException {
    	Parent main = FXMLLoader.load(getClass().getResource("BoardList.fxml"));
		StackPane root = (StackPane) btnBack.getScene().getRoot();
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
    
    public void content() {
    	tfWriter.setText(boardVo.getBoard_writer());
    	tfTitle.setText(boardVo.getBoard_title());
    	tfDate.setText(boardVo.getBoard_data());
    	txtArea.setText(boardVo.getBoard_content());
    }
    
    private IBoardService boardService;
    private ObservableList<BoardVO> boardList;
    BoardListController boardListController;

    @FXML
    void initialize() {
    	assert borderRoot != null : "fx:id=\"borderRoot\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert lblWriter != null : "fx:id=\"lblWriter\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert tfWriter != null : "fx:id=\"tfWriter\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert lblDate != null : "fx:id=\"lblDate\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert tfDate != null : "fx:id=\"tfDate\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'BoardInfo.fxml'.";
        
        boardService = BoardService.getInstance();
        
        tfTitle.setDisable(true);
        tfWriter.setDisable(true);
        tfDate.setDisable(true);
        txtArea.setDisable(true);
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
