package application;

/**
 * Sample Skeleton for 'tab3.en.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HelpController {

    @FXML
    void helpClicked(ActionEvent event) {
    	parentController.switchTab(1);
    }

    private ParentController parentController;

    public void setParentController(ParentController parentController) {
        this.parentController = parentController;
    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }
}
