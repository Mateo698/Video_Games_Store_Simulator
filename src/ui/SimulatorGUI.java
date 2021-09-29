package ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Shelf;
import model.Store;
import model.Videogame;

public class SimulatorGUI{


	private final String LOGIN_IMAGE_PATH= "data/images/ps4-games.gif";
	private final String INSERT_DATA_IMAGE_PATH= "data/images/videogame.png";
	private final String DIGITAL_CATALOG_IMAGE_PATH= "data/images/code.png";
	private final String CHECKER_IMAGE_PATH= "data/images/game-store.png";
	private Store st;
	private ArrayList<Shelf> values;
	
	public SimulatorGUI() {
		st = new Store();
		values = new ArrayList<Shelf>();
	}
	
	public void alertMethod(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setContentText(msg);
		alert.showAndWait();
	}


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
    private Button saveBtn;
    
    private int gamesRemaining;
    
    private Boolean gamesAdded;
    
    private ArrayList<Videogame> totalGames = new ArrayList<>();
		
	@FXML
	public void insertDataContinue(ActionEvent event) throws Exception {
		validateGamesAmount();
		if(gamesAdded) {
			st.setShelf(values);
			saveBtn.setDisable(false);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DigitalCatalogScreen.fxml"));
			fxmlLoader.setController(this);
			Parent root = fxmlLoader.load();
			MainPane.getChildren().clear();
			MainPane.getChildren().setAll(root);
			File f = new File(DIGITAL_CATALOG_IMAGE_PATH);
			Image img = new Image(f.toURI().toString());
			this.imageDigitalCatalog.setImage(img);
			initClientListInformation();
			initCatalogInformation();
		}else {
			alertMethod("Please add all the games before trying to continue");
		}		
	}
	
	private void validateGamesAmount() {
		int a=0;
		for(int i=0;i<values.size();i++) {
			a+=values.get(i).getGames().size();
		}
		if(a<gamesRemaining) {
			gamesAdded=false;
		}else {
			gamesAdded=true;
		}
	}

	@FXML
	public void saveData(ActionEvent event) throws NumberFormatException, Exception {
		shelfAmount.setEditable(false);
		videoGamesPerShelf.setEditable(false);
		checkersAmount.setEditable(false);
		clientsAmount.setEditable(false);
		saveBtn.setDisable(true);
		if(!shelfAmount.getText().isEmpty() &&
				!videoGamesPerShelf.getText().isEmpty() &&
				!checkersAmount.getText().isEmpty() && 
				!clientsAmount.getText().isEmpty()) {
			st.setChecker(Integer.parseInt(checkersAmount.getText()));
			st.setClientsAmount(Integer.parseInt(clientsAmount.getText()));
			createShelfs(Integer.parseInt(shelfAmount.getText()));
		}else {
			alertMethod("Fields can't be empty");
		}
	}
	
	@FXML
	public void addVideoGame(ActionEvent event) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String[] a =  videoGamesPerShelf.getText().split(" ");
		gamesRemaining=0;
		if(!videoGameCode.getText().isEmpty() &&
				!videoGamePrice.getText().isEmpty() &&
				!videoGameAmount.getText().isEmpty()) {
			Videogame newGame = new Videogame (Integer.parseInt(videoGameCode.getText()),
					Integer.parseInt(videoGameAmount.getText()),
					Integer.parseInt(videoGamePrice.getText()));
			Boolean added = false;
			for(int i=0;i<values.size() && !added;i++) {
				gamesRemaining+=Integer.parseInt(a[i]);
				if(values.get(i).getGames().size()<Integer.parseInt(a[i])) {
					values.get(i).addGame(newGame);
					totalGames.add(newGame);
					added=true;
					newGame.setShelf(chars.charAt(i));
					videoGameCode.setText("");
					videoGamePrice.setText("");
					videoGameAmount.setText("");
				}
			}
		}
	}

	private ArrayList<Shelf> createShelfs(int amount) {
		for (int i=0;i<amount;i++) {
			values.add(new Shelf());
		}
		return values;
	}
	
	
	//******DIGITAL CATALOG
	
    @FXML
    private TableView<Videogame> catalogTable;

    @FXML
    private TableColumn<Videogame, Integer> codeColumn;

    @FXML
    private TableColumn<Videogame, Integer> amountColumn;

    @FXML
    private TableColumn<Videogame, Character> shelfColumn;

    @FXML
    private TableColumn<Videogame, Integer> priceColumn;

    @FXML
    private TableView<Videogame> listTable;

    @FXML
    private TableColumn<Videogame,String> videogamesList;

    @FXML
    private TextField codeList;

    @FXML
    private ImageView imageDigitalCatalog;
    
    @FXML
    private Button generateCodeBtn;
    
    private Videogame selectedVideogame;
    
    private ArrayList<Videogame> clientList = new ArrayList<>();

	@FXML
	public void ContinueDigitalCatalog(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VideoGameSorting.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		MainPane.getChildren().clear();
		MainPane.getChildren().setAll(root);
	}
	
	private  int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con l�mite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
	@FXML
	public void GenerateCodeButton(ActionEvent event) throws IOException {
		 // El banco de caracteres
	    String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    // La cadena en donde iremos agregando un car�cter aleatorio
	    String cadena = "";
	    for (int x = 0; x < 5; x++) {
	        int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
	        char caracterAleatorio = banco.charAt(indiceAleatorio);
	        cadena += caracterAleatorio;
	    }
	    generateCodeBtn.setDisable(true);
		codeList.setText(cadena);
	}
	
	@FXML
	public void deselectVideogame(MouseEvent event) throws IOException {
		if (event.getClickCount()==2) {
			selectedVideogame = catalogTable.getSelectionModel().getSelectedItem();	
			clientList.remove(selectedVideogame);
			totalGames.add(selectedVideogame);
			initCatalogInformation();
			initClientListInformation();
		}
	}

	@FXML
	public void selectVideoGame(MouseEvent event) throws IOException {
		if (event.getClickCount()==2) {
			selectedVideogame = catalogTable.getSelectionModel().getSelectedItem();
			clientList.add(selectedVideogame);
			totalGames.remove(selectedVideogame);
			initClientListInformation();
			initCatalogInformation();
		}
	}

	public void initCatalogInformation() throws IOException {
		ObservableList<Videogame> games = FXCollections.observableArrayList(totalGames);
		catalogTable.setItems(games);
		codeColumn.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("code"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("quantity"));
		shelfColumn.setCellValueFactory(new PropertyValueFactory<Videogame, Character>("shelf"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<Videogame, Integer>("price"));
	}

	public void initClientListInformation() throws IOException {
		ObservableList<Videogame> games = FXCollections.observableArrayList(clientList);
		listTable.setItems(games);
		videogamesList.setCellValueFactory(new PropertyValueFactory<Videogame, String>("infoList"));
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
