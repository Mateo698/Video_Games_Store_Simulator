package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SimulatorGUI{


	private String LOGIN_IMAGE_PATH= "data/images/ps4-games.gif";
	private String INSERT_DATA_IMAGE_PATH= "data/images/videogame.png";
	private String DIGITAL_CATALOG_IMAGE_PATH= "data/images/code.png";

	@FXML
	private ImageView ImageMainScreen;
	@FXML
    private ImageView imageInsertData;
	@FXML
    private ImageView imageDigitalCatalog;


	@FXML
	private Pane MainPane;

	public void loadImage() {
		File f = new File(LOGIN_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.ImageMainScreen.setImage(img);
	}

	@FXML
	private TableView<?> shelfColumn;

	@FXML
	private TableColumn<?, ?> codeColumn;

	@FXML
	private TableColumn<?, ?> amountColumn;

	@FXML
	private TableColumn<?, ?> priceColumn;

	@FXML
	private TableColumn<?, ?> videogamesList;

	@FXML
	private TextField codeList;
	
	 @FXML
	    void sortingContinue(ActionEvent event) throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckerSection.fxml"));
			fxmlLoader.setController(this);
			Parent root = fxmlLoader.load();
			MainPane.getChildren().clear();
			MainPane.getChildren().setAll(root);
	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	System.exit(0);
	    }
    @FXML
    void addVideoGame(ActionEvent event) {
    	
    }

    @FXML
    void insertDataContinue(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DigitalCatalogScreen.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		MainPane.getChildren().clear();
		MainPane.getChildren().setAll(root);
		File f = new File(DIGITAL_CATALOG_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.imageDigitalCatalog.setImage(img);
    }

    @FXML
    void saveData(ActionEvent event) {

    }
	
	@FXML
	void ContinueDigitalCatalog(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VideoGameSorting.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		MainPane.getChildren().clear();
		MainPane.getChildren().setAll(root);
	}

	@FXML
	void GenerateCodeButton(ActionEvent event) throws IOException {
		
	}


	@FXML
	void startButton(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InsertData.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		MainPane.getChildren().clear();
		MainPane.getChildren().setAll(root);
		File f = new File(INSERT_DATA_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.imageInsertData.setImage(img);

	}



}
