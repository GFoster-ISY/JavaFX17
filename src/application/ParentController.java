package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class ParentController {
	@FXML	private TabPane tabPane;
	@FXML	private Tab homeTab;
	@FXML	private Tab helpTab;
	@FXML	private HomeController homeTabPageController; // must match the fx:id
	@FXML	private HelpController helpTabPageController; // must match the fx:id
	
	private boolean switched = false;
	
	@FXML
	public void switchTabsClicked(ActionEvent event) throws IOException {
		// The resource pages will be reloaded.
		// The link to the parent controller will need to be reestablished
		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("tab1.en.fxml"));
		FXMLLoader loader3 = new FXMLLoader(getClass().getResource("tab3.en.fxml"));
		if (switched) {
			homeTab.setContent((Node)loader1.load());
			helpTab.setContent((Node)loader3.load());
		} else {
			homeTab.setContent((Node)loader3.load());
			helpTab.setContent((Node)loader1.load());
		}
		// Set up the controller after the FXML has been loaded.
		helpTabPageController = ((HelpController)loader3.getController());
		helpTabPageController.setParentController(this);
		// Store the value from the home tab page
		int count = homeTabPageController.getCount();
		homeTabPageController = ((HomeController)loader1.getController());
		// Update the value with the count previously captured
		homeTabPageController.setCount(count);
		switched = !switched;
	}
	
	public void initialize() {
		// Establish a link to the parent controller
		helpTabPageController.setParentController(this);
	}

	public void switchTab(int t) {
		tabPane.getSelectionModel().select(t);
	}
}
