package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	private SimulatorGUI gui;
	
	public Main() {
		gui = new SimulatorGUI();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		gui.start();
	}
}
