package p1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * @author Nicholas Pirrello
 * A class to create a UI when handling textbooks in the Application
 */
public class TPane {
	private Label bookLabel;
	private TextField bookText;
	private Label authorLabel;
	private TextField authorText;
	private Label pubLabel;
	private TextField pubText;
	private Label priceLabel;
	private TextField priceText;
	private Label isbnLabel;
	private TextField isbnText;
	private Label yearLabel;
	private TextField yearText;
	private TextbookBag t;
	private HBox hPane;
	private MainPane mP;
	private Scene scene;
	private Button addB;
	private Button removeB;
	private Button editB;
	/** 
	 * Handles UI for Textbook window when called upon by the main pane. Uses Label, Text Field, HBox, MainPane, TextbookBag, Buttons and Scene
	 * @param mP - MainPane
	 * @param t - TextbookBag
	 */
	public TPane(MainPane mP, TextbookBag t){
		bookLabel = new Label("Title: ");
		bookText = new TextField();
		authorLabel = new Label("Author: ");
		authorText = new TextField();
		pubLabel = new Label("Publisher: ");
		pubText = new TextField();
		priceLabel = new Label("Price: ");
		priceText = new TextField();
		isbnLabel = new Label("ISBN: ");
		isbnText = new TextField();
		yearLabel = new Label("Published Year: ");
		yearText = new TextField();
		
		addB = new Button("Add");
		addB.setPrefSize(60, 20);
		removeB = new Button("Delete");
		removeB.setPrefSize(60, 20);
		editB = new Button("Update");
		editB.setPrefSize(60, 20);
		
		addB.setOnAction(event -> {
			Alert badInfo = new Alert(AlertType.ERROR);
			badInfo.setHeaderText("Invalid Info entered!");
			badInfo.setContentText("Please double check the information entered.");
			badInfo.setTitle("Error!");
			Textbook newTb = null;
			try {
				String title = bookText.getText();
				String author = authorText.getText();
				String pub = pubText.getText();
				String price = priceText.getText();
				String isbn = isbnText.getText();
				String year = yearText.getText();
				newTb = new Textbook(title,author,pub,Double.parseDouble(price),isbn,year);
			
				t.add(newTb);
			} catch(Exception e) {
				badInfo.showAndWait();
			}
			bookText.clear();
			authorText.clear();
			pubText.clear();
			priceText.clear();
			isbnText.clear();
			yearText.clear();
			
		});
		
		
		
		
		editB.setOnAction(event -> {
			Textbook tb = mP.getTb();
			if(tb != null){
				tb.setBookTitle(bookText.getText());
				tb.setAuthor(authorText.getText());
				tb.setBookPrice(Double.parseDouble(priceText.getText()));
				tb.setPublisher(pubText.getText());
				tb.setIsbn(isbnText.getText());
				tb.setYearPub(yearText.getText());
			}
		});
		
		Insets myInsets = new Insets(20,0,20,0);
		VBox v1 = new VBox(20);
		VBox v2 = new VBox(20);
		VBox v3 = new VBox(20);
		hPane = new HBox(30);
		v1.getChildren().addAll(bookLabel,bookText,authorLabel,authorText,addB);
		v2.getChildren().addAll(pubLabel,pubText,yearLabel,yearText,editB);
		v3.getChildren().addAll(isbnLabel,isbnText,priceLabel,priceText,removeB);
		hPane.getChildren().addAll(v1,v2,v3);
		hPane.setAlignment(Pos.CENTER);
		HBox.setMargin(v1, myInsets);
		HBox.setMargin(v2, myInsets);
		HBox.setMargin(v3, myInsets);
		scene = new Scene(hPane, 400, 200);
		this.mP = mP;
		this.t = t;
	}
	/**
	 * returns the book title text field
	 * @return bookText
	 */
	public TextField getBookText() {
		return bookText;
	}
	/**
	 * returns the author text field
	 * @return authorText
	 */
	public TextField getAuthorText() {
		return authorText;
	}
	/**
	 * returns the publisher text field
	 * @return pubText
	 */
	public TextField getPubText() {
		return pubText;
	}
	/**
	 * returns the price text field
	 * @return priceText
	 */
	public TextField getPriceText() {
		return priceText;
	}
	/**
	 * returns the isbn text field
	 * @return isbnText
	 */
	public TextField getIsbnText() {
		return isbnText;
	}
	/**
	 * returns the year published text field
	 * @return yearText
	 */
	public TextField getYearText() {
		return yearText;
	}
	/**
	 * returns the textbook bag
	 * @return t
	 */
	public TextbookBag getT() {
		return t;
	}
	/** 
	 * returns the horizontal box pane 
	 * @return hPane
	 */
	public HBox gethPane() {
		return hPane;
	}
	/** 
	 * returns the MainPane
	 * @return mP
	 */
	public MainPane getmP() {
		return mP;
	}
	/** 
	 * returns the scene
	 * @return scene
	 */
	public Scene getScene() {
		return scene;
	}
	/**
	 * returns the add button
	 * @return addB
	 */
	public Button getAddB() {
		return addB;
	}
	/**
	 * returns the remove button
	 * @return removeB
	 */
	public Button getRemoveB() {
		return removeB;
	}
	/**
	 * returns the edit button
	 * @return editB
	 */
	public Button getEditB() {
		return editB;
	}
	
}
