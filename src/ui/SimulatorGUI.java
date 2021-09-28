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
	private String CHECKER_IMAGE_PATH= "data/images/game-store.png";


	//******* MAIN SCREEN

	@FXML
	public void startButton(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InsertData.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		MainPane.getChildren().clear();
		MainPane.getChildren().setAll(root);
		File f = new File(INSERT_DATA_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.imageInsertData.setImage(img);

	}

	@FXML
	private Pane MainPane;

	public void loadImage() {
		File f = new File(LOGIN_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.ImageMainScreen.setImage(img);
	}

	@FXML
	private ImageView ImageMainScreen;


	//*******INSERT DATA

	@FXML
	private TextField checkersAmount;

	@FXML
	private TextField videoGameCode;

	@FXML
	private TextField videoGamePrice;

	@FXML
	private TextField shelfAmount;

	@FXML
	private TextField videoGamesPerShelf;

	@FXML
	private TextField videoGameAmount;

	@FXML
	private TextField clientsAmount;

	@FXML
	private ImageView imageInsertData;

	@FXML
	public void addVideoGame(ActionEvent event) {

	}

	@FXML
	public void insertDataContinue(ActionEvent event) throws IOException {
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
	public void saveData(ActionEvent event) {

	}


	//******DIGITAL CATALOG
	
    @FXML
    private TableView<?> catalogTable;

    @FXML
    private TableColumn<?, ?> codeColumn;

    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    private TableColumn<?, ?> shelfColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableView<?> listTable;

    @FXML
    private TableColumn<?, ?> videogamesList;

    @FXML
    private TextField codeList;

    @FXML
    private ImageView imageDigitalCatalog;

	@FXML
	public void ContinueDigitalCatalog(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VideoGameSorting.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		MainPane.getChildren().clear();
		MainPane.getChildren().setAll(root);
	}

	@FXML
	public void GenerateCodeButton(ActionEvent event) throws IOException {

	}

	//*******VIDEO GAME SORTING

    @FXML
    private TextField txtListCode;

    @FXML
    private TableView<?> checkInTable;

    @FXML
    private TableColumn<?, ?> clientColumn;

    @FXML
    private TableColumn<?, ?> videoGamesColumn;

    @FXML
    private TableColumn<?, ?> timeColumn;
    
    @FXML
    public void btnInsertionSrt(ActionEvent event) {

    }

    @FXML
    public void btnSelectionSrt(ActionEvent event) {

    }

    @FXML
    public void enterCode(ActionEvent event) {

    }
    
	@FXML
	public void sortingContinue(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheckerSection.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		MainPane.getChildren().clear();
		MainPane.getChildren().setAll(root);
		File f = new File(CHECKER_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.imageCheckerSection.setImage(img);
	}

	//*******CHECKER SECTION

    @FXML
    private TableView<?> paymentTable;

    @FXML
    private TableColumn<?, ?> paymentPosition;

    @FXML
    private TableColumn<?, ?> paymentClient;

    @FXML
    private TableColumn<?, ?> paymentVideoGames;

    @FXML
    private TableColumn<?, ?> paymentTime;

    @FXML
    private TableView<?> chekOutTable;

    @FXML
    private TableColumn<?, ?> checkOutClient;

    @FXML
    private TableColumn<?, ?> chechOutVideoGames;

    @FXML
    private TableColumn<?, ?> checkOutPrice;

    @FXML
    private TableView<?> checkersTable;

    @FXML
    private TableColumn<?, ?> checkerColumn;

    @FXML
    private TableColumn<?, ?> checkerActualClient;

    @FXML
    private ImageView imageCheckerSection;


	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}








}
