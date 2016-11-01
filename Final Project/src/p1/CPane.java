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
 * A class to create a UI when handling Courses in the Application
 */
public class CPane {
	private Label titleLabel;
	private TextField titleText;
	private Label numLabel;
	private TextField numText;
	private Label crnLabel;
	private TextField crnText;
	private Label isbnLabel;
	private TextField isbnText;
	private Label creditLabel;
	private TextField creditText;
	private MasterCourseBag mCB;
	private Course newC;
	
	private HBox hPane;
	private MainPane mP;
	private Scene scene;
	private Button addB;
	private Button removeB;
	private Button editB;
	
	/**
	 * Creates the UI setup for the Course Window in the Application. Contains labels, text fields, buttons, a MasterCourseBag, and a MainPane for 
	 * implementation to the main application class
	 * @param mP - MainPane object
	 * @param mCB - MasterCourseBag
	 */
	public CPane(MainPane mP, MasterCourseBag mCB){
		titleLabel = new Label("Course Title: ");
		titleText = new TextField();
		numLabel = new Label("Course Number: ");
		numText = new TextField();
		crnLabel = new Label("CRN: ");
		crnText = new TextField();
		isbnLabel = new Label("ISBN: ");
		isbnText = new TextField();
		creditLabel = new Label("Credits: ");
		creditText = new TextField();
		
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
			newC = null;
			try {
				String title = titleText.getText();
				String cNum = numText.getText();
				String crn = crnText.getText();
				String isbn = isbnText.getText();
				int credit = Integer.parseInt(creditText.getText());
				newC = new Course(title,cNum,crn,isbn,credit);
				mCB.addTo(newC);
			} catch(Exception e) {
				badInfo.showAndWait();
			}
			titleText.clear();
			numText.clear();
			crnText.clear();
			isbnText.clear();
			creditText.clear();
			
		});
		
		removeB.setOnAction(event -> {
			Course c = mP.getC();
			if(c != null){
				mCB.remove(c.getcNum());
			}
			titleText.clear();
			numText.clear();
			crnText.clear();
			creditText.clear();
			isbnText.clear();
		});
		
		editB.setOnAction(event -> {
			Course c = mP.getC();
			if(c != null){
				c.setcTitle(titleText.getText());
				c.setcNum(numText.getText());
				c.setCrn(crnText.getText());
				c.setTb(isbnText.getText());
				c.setNumCredit(Integer.parseInt(creditText.getText()));
			}
		});
		
		Insets myInsets = new Insets(20,0,20,0);
		VBox v1 = new VBox(20);
		VBox v2 = new VBox(20);
		VBox v3 = new VBox(20);
		hPane = new HBox(30);
		Label temp = new Label();
		TextField tempF = new TextField();
		tempF.setVisible(false);
		v1.getChildren().addAll(titleLabel,titleText,numLabel,numText,addB);
		v2.getChildren().addAll(crnLabel,crnText,creditLabel,creditText,editB);
		v3.getChildren().addAll(isbnLabel,isbnText,temp,tempF,removeB);
		hPane.getChildren().addAll(v1,v2,v3);
		hPane.setAlignment(Pos.CENTER);
		HBox.setMargin(v1, myInsets);
		HBox.setMargin(v2, myInsets);
		HBox.setMargin(v3, myInsets);
		scene = new Scene(hPane, 400, 200);
		this.mP = mP;
		this.mCB = mCB;

	}
	/**
	 * returns the Add button
	 * @return addButton
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
	/**
	 * returns the horizontal box hpane
	 * @return hPane
	 */
	public HBox gethPane() {
		return hPane;
	}
	/**
	 * returns the title text field
	 * @return titleText
	 */
	public TextField getTitleText() {
		return titleText;
	}
	/**
	 * returns the number text field
	 * @return numText
	 */
	public TextField getNumText() {
		return numText;
	}
	/**
	 * returns the crn text field
	 * @return crnText
	 */
	public TextField getCrnText() {
		return crnText;
	}
	/**
	 * returns the isbn text field
	 * @return isbnText
	 */
	public TextField getIsbnText() {
		return isbnText;
	}
	/**
	 * returns the credit text field
	 * @return creditText
	 */
	public TextField getCreditText() {
		return creditText;
	}
	/**
	 * returns the master course bag
	 * @return mCB
	 */
	public MasterCourseBag getmCB() {
		return mCB;
	}
	/**
	 * returns the main pane
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
	
}
