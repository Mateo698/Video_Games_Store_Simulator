package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimulatorGUI {
	
	private Stage mainStage;
	private Stage popupStage;

	public void start() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	mainStage = new Stage();
    	popupStage = new Stage();
    	Scene e = new Scene(root);
    	mainStage.setScene(e);
    	mainStage.show();
		
		
	}
	
	 @FXML
	    void mainScreenButton(ActionEvent event) {

	    }

}
