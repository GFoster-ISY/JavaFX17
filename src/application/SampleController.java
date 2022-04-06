package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class SampleController {
	@FXML
	private Button btnClick;
	@FXML
	private Label message;

	private int btnClickCount = 0;
	// Event Listener on Button[#btnClick].onAction
	@FXML
	public void btnClicked(ActionEvent event) {
		if (btnClickCount > 0) {
	        Platform.exit();
	        System.exit(0);
		} else {
			message.setText("Good bye");
			btnClickCount++;
		}
	}
}
