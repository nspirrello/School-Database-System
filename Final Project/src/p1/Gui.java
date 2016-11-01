package p1;

import javafx.application.Application;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
/**
 * @author Nicholas Pirrello
 * This is the main class of the application. It launches the arguments given by the start method which creates a new mainPaine and sets the stage
 */
public class Gui extends Application{
	/**
	 * Main method, launches the args
	 * @param args - args
	 */
	public static void main(String[] args){
		launch(args);
	}
	/**
	 * start method from Application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		new MainPane(primaryStage);
	}
}
