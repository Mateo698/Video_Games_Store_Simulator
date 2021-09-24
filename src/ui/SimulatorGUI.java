package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimulatorGUI {
	
	private Stage mainStage;
	private Stage popupStage;
	private String LOGIN_IMAGE_PATH= "data/images/ps4-games.gif";

	public void start() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
    	loader.setController(this);
    	Parent root = loader.load();
    	mainStage = new Stage();
    	popupStage = new Stage();
    	Scene e = new Scene(root);
    	mainStage.setScene(e);
    	mainStage.show();
    	File f = new File(LOGIN_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.ImageMainScreen.setImage(img);
		
		
	}
	
	@FXML
    private ImageView ImageMainScreen;
	
	
	 @FXML
	    void startButton(ActionEvent event) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("DigitalCatalogScreen.fxml"));
	    	loader.setController(this);
	    	Parent root = loader.load();
	    	mainStage = new Stage();
	    	popupStage = new Stage();
	    	Scene e = new Scene(root);
	    	mainStage.setScene(e);
	    	mainStage.show();

	    }

}
