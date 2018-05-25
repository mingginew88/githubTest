package pagenationTest;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TableViewPagenationTest extends Application {
	
	// 전체 데이터 개수
	private final static int dataSize = 123;
	
	// 한 화면에 출력될 데이터 개수
	private final static int rowsPerPage = 10;
	
	// 데이터셋팅
	private List<Sample> data = createData();
	
	// 테이블 뷰 객체변수 선언
	private TableView<Sample> table;
	
	// 전체 데이터 개수에 맞게 데이터를 만들어 주는 메서드
	private List<Sample> createData() {
		List<Sample> data = new ArrayList<>();
		
		for (int i = 0; i < dataSize; i++) {
			data.add(new Sample(i,"이름 " + i, "내용 " + i));
		}
		return data;
	}

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(15));
		
		
		//-------------------------------------------- 테이블 뷰 설정
		table = new TableView<>();
		
		TableColumn<Sample, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Sample, String> nameCol = new TableColumn<>("이 름");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<Sample, String> contentCol = new TableColumn<>("내 용");
		contentCol.setCellValueFactory(new PropertyValueFactory<>("content"));
		
		table.getColumns().addAll(idCol, nameCol, contentCol);		
		//--------------------------------------------
		
		// 형식) new Pagination(전체 페이지수, 처음선택된 페이지index값) --index는 0부터 시작한다.
		// 전체 페이지 수  = 전체데이터개수/한 페이지당 출력할 개수
		// 전체데이터개수/한 페이지당 출력할 개수의 나머지가 있으면 전체페이지 수 ++
		int totalPage = data.size()/rowsPerPage + (data.size()/rowsPerPage > 0 ? 1 : 0);
		
		//방법1
//		Pagination pagination = new Pagination(totalPage, 0);
		
		//방법2
		Pagination pagination = new Pagination();
		pagination.setPageCount(totalPage);
		pagination.setCurrentPageIndex(0);

		//table.setItems(FXCollections.observableArrayList(data));
		changeTableView(0);
		
		//Pagination객체의 페이지 번호를 클릭했을 때 이벤트 처리
		pagination.currentPageIndexProperty().addListener(
				new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						changeTableView(newValue.intValue());						
					}
				}
		);
		
		
		root.setCenter(table);
		root.setBottom(pagination);
		
		Scene scene = new Scene(root, 1024, 768);
		primaryStage.setScene(scene);
		primaryStage.setTitle("페이징처리 연습");
		primaryStage.show();				
	}
	
	
	//페이징index값을 매개변수로 받아서 List에서 페이징 index번째에 출력할 데이터를 추출하는 메서드
	public void changeTableView(int index) {
		int startIndex = index * rowsPerPage;
		int endIndex = Math.min(startIndex + rowsPerPage, data.size());
		
		// 시작인덱스부터 종료인덱스 이전까지의 자료를 추출한다.
		table.setItems(FXCollections.observableArrayList(data.subList(startIndex, endIndex)));
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
	// 데이터가 저장될 객체(VO)
	public class Sample{
		private int id;
		private String name;
		private String content;
		
		public Sample(int id, String name, String content) {
			super();
			this.id = id;
			this.name = name;
			this.content = content;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
		
		
	}
}
