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
    	//��ư�� Ŭ������ �� ó���� ������ ����Ѵ�.
    	//Integer dan = cbDan.getValue();
		Integer dan = cbDan.getSelectionModel().getSelectedItem();
		if(dan==null) {
			result.setText("����� ���� ������ �� �����ϼ���.");
			return;
		}
		result.setText(dan + "��\n\n");
		for (int i = 1; i < 9; i++) {
			result.appendText(dan + " * " + i + " = " + dan*i + "\n");
		}
    }
    
    private ObservableList<Integer> data = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);

    @FXML
    void initialize() {
    	// �� �޼���� FXML������ ��üȭ �� �� ó������ ����ȴ�.
    	// ���� ��ü���� �ʱ�ȭ �۾��� ���ȴ�.
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
							setText(item + "��");
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
					setText(item + "��");
				}
			}
		});
        
        
    }
}






