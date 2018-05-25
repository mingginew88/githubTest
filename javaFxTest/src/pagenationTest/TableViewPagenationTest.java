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
	
	// ��ü ������ ����
	private final static int dataSize = 123;
	
	// �� ȭ�鿡 ��µ� ������ ����
	private final static int rowsPerPage = 10;
	
	// �����ͼ���
	private List<Sample> data = createData();
	
	// ���̺� �� ��ü���� ����
	private TableView<Sample> table;
	
	// ��ü ������ ������ �°� �����͸� ����� �ִ� �޼���
	private List<Sample> createData() {
		List<Sample> data = new ArrayList<>();
		
		for (int i = 0; i < dataSize; i++) {
			data.add(new Sample(i,"�̸� " + i, "���� " + i));
		}
		return data;
	}

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(15));
		
		
		//-------------------------------------------- ���̺� �� ����
		table = new TableView<>();
		
		TableColumn<Sample, Integer> idCol = new TableColumn<>("ID");
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Sample, String> nameCol = new TableColumn<>("�� ��");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<Sample, String> contentCol = new TableColumn<>("�� ��");
		contentCol.setCellValueFactory(new PropertyValueFactory<>("content"));
		
		table.getColumns().addAll(idCol, nameCol, contentCol);		
		//--------------------------------------------
		
		// ����) new Pagination(��ü ��������, ó�����õ� ������index��) --index�� 0���� �����Ѵ�.
		// ��ü ������ ��  = ��ü�����Ͱ���/�� �������� ����� ����
		// ��ü�����Ͱ���/�� �������� ����� ������ �������� ������ ��ü������ �� ++
		int totalPage = data.size()/rowsPerPage + (data.size()/rowsPerPage > 0 ? 1 : 0);
		
		//���1
//		Pagination pagination = new Pagination(totalPage, 0);
		
		//���2
		Pagination pagination = new Pagination();
		pagination.setPageCount(totalPage);
		pagination.setCurrentPageIndex(0);

		//table.setItems(FXCollections.observableArrayList(data));
		changeTableView(0);
		
		//Pagination��ü�� ������ ��ȣ�� Ŭ������ �� �̺�Ʈ ó��
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
		primaryStage.setTitle("����¡ó�� ����");
		primaryStage.show();				
	}
	
	
	//����¡index���� �Ű������� �޾Ƽ� List���� ����¡ index��°�� ����� �����͸� �����ϴ� �޼���
	public void changeTableView(int index) {
		int startIndex = index * rowsPerPage;
		int endIndex = Math.min(startIndex + rowsPerPage, data.size());
		
		// �����ε������� �����ε��� ���������� �ڷḦ �����Ѵ�.
		table.setItems(FXCollections.observableArrayList(data.subList(startIndex, endIndex)));
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
	// �����Ͱ� ����� ��ü(VO)
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
