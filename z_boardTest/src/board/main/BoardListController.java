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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BoardListController {
	
	private IBoardService boardService;
	private ObservableList<BoardVO> boardList;	
	 	
	//한 화면에 출력될 데이터 개수
	private final static int rowsPerPage = 15;
	 	
	// 데이터셋팅
	
	private List<BoardVO> data;

	private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}    

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private BorderPane borderRoot;

    @FXML
    private TableView<BoardVO> boardTable;

    @FXML
    private TableColumn<?, ?> tcNoCol;

    @FXML
    private TableColumn<?, ?> tcTitleCol;

    @FXML
    private TableColumn<?, ?> tcWriterCol;

    @FXML
    private TableColumn<?, ?> tcDateCol;

    @FXML
    private ComboBox<String> cbChooseCol;

    @FXML
    private TextField tfSearchBoard;

    @FXML
    private Button btnSearch;

    @FXML
    private Label lblTitle;

    @FXML
    private Button btnNewBoard;
    
    @FXML
    private Pagination pagination;

    @FXML
    void newBoard(ActionEvent event) throws IOException { 			
		Parent main = FXMLLoader.load(getClass().getResource("NewBoard.fxml"));
		StackPane root = (StackPane) btnNewBoard.getScene().getRoot();
		root.getChildren().add(main);
		
		main.setTranslateX(600);
		
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(main.translateXProperty(), 0);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
		
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		

    }
    
    
    //FIXME : 검색 결과 수정해야한다. 하나의 창에 중복되는 값들을 한번 띄워주게끔 만들어야한다.
    //FIXME : 현상태에서는 정확한 값을 입력해야 나오지만 내용의경우에는 포함된 내용도 검색되게끔 해야한다.
    @FXML
    void searchBoard(ActionEvent event) { 			
		if(cbChooseCol.getValue().equals("제목")){
			for (BoardVO boardVO : boardList) {
				if(tfSearchBoard.getText().equals(boardVO.getBoard_title())) {   						
					
					BoardVO boardVo1 = new BoardVO();
					boardVo1.setBoard_writer(boardVO.getBoard_writer());
					boardVo1.setBoard_title(boardVO.getBoard_title());
					boardVo1.setBoard_data(boardVO.getBoard_data());
					boardVo1.setBoard_content(boardVO.getBoard_content());
					try {
						FXMLLoader main = new FXMLLoader(getClass().getResource("BoardInfo.fxml"));
						Parent content = main.load();
						StackPane root = (StackPane) btnSearch.getScene().getRoot();     
						
						root.getChildren().add(content);
						content.setTranslateX(600);
						
						BoardInfoController boardInfoController =  main.getController();
						boardInfoController.setBoardVo(boardVo1);
						boardInfoController.content();
						
						Timeline timeline = new Timeline();
						KeyValue keyValue = new KeyValue(content.translateXProperty(), 0);
						KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
						
						timeline.getKeyFrames().add(keyFrame);
						timeline.play();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
			}
		} else if(cbChooseCol.getValue().equals("작성자")) {
			for (BoardVO boardVO : boardList) {
				if(tfSearchBoard.getText().equals(boardVO.getBoard_writer())) {
					BoardVO boardVo1 = new BoardVO();
					boardVo1.setBoard_writer(boardVO.getBoard_writer());
					boardVo1.setBoard_title(boardVO.getBoard_title());
					boardVo1.setBoard_data(boardVO.getBoard_data());
					boardVo1.setBoard_content(boardVO.getBoard_content());
					try {
						FXMLLoader main = new FXMLLoader(getClass().getResource("BoardInfo.fxml"));
						Parent content = main.load();
						StackPane root = (StackPane) btnSearch.getScene().getRoot();     
						
						root.getChildren().add(content);
						content.setTranslateX(600);
						
						BoardInfoController boardInfoController =  main.getController();
						boardInfoController.setBoardVo(boardVo1);
						boardInfoController.content();
						
						Timeline timeline = new Timeline();
						KeyValue keyValue = new KeyValue(content.translateXProperty(), 0);
						KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
						
						timeline.getKeyFrames().add(keyFrame);
						timeline.play();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} 
			}
		} else if(cbChooseCol.getValue().equals("내용")) {
			//XXX: 내용의 부분을 입력했을때 그에 관련된 정보가 뜨게끔 만들어야한다.
			for (BoardVO boardVO : boardList) {
				if(tfSearchBoard.getText().equals(boardVO.getBoard_content())) {
					BoardVO boardVo1 = new BoardVO();
					boardVo1.setBoard_writer(boardVO.getBoard_writer());
					boardVo1.setBoard_title(boardVO.getBoard_title());
					boardVo1.setBoard_data(boardVO.getBoard_data());
					boardVo1.setBoard_content(boardVO.getBoard_content());
					try {
						FXMLLoader main = new FXMLLoader(getClass().getResource("BoardInfo.fxml"));
						Parent content = main.load();
						StackPane root = (StackPane) btnSearch.getScene().getRoot();     
						
						root.getChildren().add(content);
						content.setTranslateX(600);
						
						BoardInfoController boardInfoController =  main.getController();
						boardInfoController.setBoardVo(boardVo1);
						boardInfoController.content();
						
						Timeline timeline = new Timeline();
						KeyValue keyValue = new KeyValue(content.translateXProperty(), 0);
						KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
						
						timeline.getKeyFrames().add(keyFrame);
						timeline.play();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		} else {
			info("선택사항","검색할 메뉴를 선택해주세요.");
		}	
    }
   
    
    @FXML
    void initialize() {
    	assert borderRoot != null : "fx:id=\"borderRoot\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert boardTable != null : "fx:id=\"boardTable\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert tcNoCol != null : "fx:id=\"tcNoCol\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert tcTitleCol != null : "fx:id=\"tcTitleCol\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert tcWriterCol != null : "fx:id=\"tcWriterCol\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert tcDateCol != null : "fx:id=\"tcDateCol\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert cbChooseCol != null : "fx:id=\"cbChooseCol\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert tfSearchBoard != null : "fx:id=\"tfSearchBoard\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert btnNewBoard != null : "fx:id=\"btnNewBoard\" was not injected: check your FXML file 'BoardList.fxml'.";
        assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'BoardList.fxml'.";
        
        
        boardService = BoardService.getInstance();
        
        data = boardService.getAllBoard();
        
        tcNoCol.setCellValueFactory(new PropertyValueFactory<>("board_no"));
        tcTitleCol.setCellValueFactory(new PropertyValueFactory<>("board_title"));
        tcWriterCol.setCellValueFactory(new PropertyValueFactory<>("board_writer"));
        tcDateCol.setCellValueFactory(new PropertyValueFactory<>("board_data"));
        
        List<BoardVO> list = boardService.getAllBoard();
        boardList = FXCollections.observableArrayList(list);
        boardTable.setItems(boardList);       
        
        cbChooseCol.getItems().addAll("제목", "작성자", "내용");
    	cbChooseCol.setValue("선택하세요.");	//기본선택값 설정
    	
        boardTable.setOnMouseClicked(e->{
        	BoardVO boardVo = boardTable.getSelectionModel().getSelectedItem();
        	if(boardVo==null) return;
        	
			try {
				FXMLLoader main = new FXMLLoader(getClass().getResource("BoardInfo.fxml"));
				Parent content = main.load();
				StackPane root = (StackPane) boardTable.getScene().getRoot();     
				
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
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        });
       
       int totalPage = data.size()/rowsPerPage + (data.size()/rowsPerPage > 0 ? 1 : 0);
       
       if(data.size() <= 15) {
    	   totalPage = 1;
       }
       
       //Pagination객체의 페이지 번호를 클릭했을 때 이벤트 처리
       pagination.currentPageIndexProperty().addListener(
			new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					changeTableView(newValue.intValue());
				}
			}
   		);
       
       pagination.setPageCount(totalPage);
       pagination.setCurrentPageIndex(0);
       changeTableView(0);

    }
    
    public void changeTableView(int index) {
		int startIndex = index * rowsPerPage;
		int endIndex = Math.min(startIndex + rowsPerPage, data.size());
		
		boardTable.setItems(FXCollections.observableArrayList(data.subList(startIndex, endIndex)));
	}
    
    
    
    //정보 출력하는 Alert창 메서드
  	public void info(String header, String msg) {
  		Alert alertInfo = new Alert(AlertType.INFORMATION);
  		alertInfo.setTitle("정보확인");
  		alertInfo.setHeaderText(header);
  		alertInfo.setContentText(msg);
  		alertInfo.showAndWait();
  	}
    
  
    
    
    
}
