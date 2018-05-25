package basic.fxmlTest;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

public class ComboBoxGugudanController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cbDan;

    @FXML
    private Button btnOk;

    @FXML
    private TextArea result;

    @FXML
    void btnOkClicked(ActionEvent event) {
    	//버튼을 클릭했을 때 처리할 내용을 기술한다.
    	//Integer dan = cbDan.getValue();
		Integer dan = cbDan.getSelectionModel().getSelectedItem();
		if(dan==null) {
			result.setText("출력할 단을 선택한 후 실행하세요.");
			return;
		}
		result.setText(dan + "단\n\n");
		for (int i = 1; i < 9; i++) {
			result.appendText(dan + " * " + i + " = " + dan*i + "\n");
		}
    }
    
    private ObservableList<Integer> data = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);

    @FXML
    void initialize() {
    	// 이 메서드는 FXML문서가 객체화 된 후 처음으로 실행된다.
    	// 보통 객체등의 초기화 작업에 사용된다.
        assert cbDan != null : "fx:id=\"cbDan\" was not injected: check your FXML file 'ComboBoxGugudan.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'ComboBoxGugudan.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'ComboBoxGugudan.fxml'.";
        //----------------------------------------------------------------------------------------------------------
        
        cbDan.setItems(data);
        
        cbDan.setCellFactory(new Callback<ListView<Integer>, ListCell<Integer>>() {
			
			@Override
			public ListCell<Integer> call(ListView<Integer> param) {
				return new ListCell<Integer>() {
					@Override
					protected void updateItem(Integer item, boolean empty) {
						super.updateItem(item, empty);
						if(empty) {
							setText(null);
						} else {
							setText(item + "단");
						}
					}
				};
			}
		});
		
		cbDan.setButtonCell(new ListCell<Integer>() {
			@Override
			protected void updateItem(Integer item, boolean empty) {
				super.updateItem(item, empty);
				if(empty) {
					setText(null);
				} else {
					setText(item + "단");
				}
			}
		});
        
        
    }
}






