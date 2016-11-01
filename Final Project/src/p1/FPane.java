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
 * A class to create a UI when handling Faculty in the Application
 */
public class FPane {
	private Label nameLabel;
	private TextField nameText;
	private Label phoneLabel;
	private TextField phoneText;
	private Label adLabel;
	private TextField adText;
	private Label zipLabel;
	private TextField zipText;
	private Label offLabel;
	private TextField offText;
	private Label offZipLabel;
	private TextField offZipText;
	private Label departLabel;
	private TextField departText;
	private Label titleLabel;
	private TextField titleText;
	private Label payLabel;
	private TextField payText;
	private PersonBag p;
	private HBox hPane;
	private MainPane mP;
	private Scene scene;
	private Button addB;
	private Button removeB;
	private Button editB;
	private Label idLabel;
	private TextField idText;
	/**
	 * Creates the UI setup for the Course Window in the Application. Contains labels, text fields, buttons, a PersonBag, and a MainPane for 
	 * implementation to the main application class
	 * @param mP - MainPane
	 * @param p - PersonBag
	 */
	public FPane(MainPane mP, PersonBag p){
		nameLabel = new Label("Name: ");
		nameText = new TextField();
		phoneLabel = new Label("Phone Number: ");
		phoneText = new TextField();
		adLabel = new Label("Home Address: ");
		adText = new TextField();
		zipLabel = new Label("Home Zip: ");
		zipText = new TextField();
		offLabel = new Label("Office Address");
		offText = new TextField();
		offZipLabel = new Label("Office Zip");
		offZipText = new TextField();
		departLabel = new Label("Department");
		departText = new TextField();
		titleLabel = new Label("Title");
		titleText = new TextField();
		payLabel = new Label("Pay Scale");
		payText = new TextField();
		idLabel = new Label("ID: ");
		idText = new TextField();
		
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
			Faculty newF = null;
			try {
				String[] name = nameText.getText().split(" ");
				String fName = name[0];
				String lName = name[1];
				String pNum = phoneText.getText();
				int split =  adText.getText().indexOf(" ");
				String first = adText.getText().substring(0, split);
				String second = adText.getText().substring(split, adText.getText().length());
				String zip = zipText.getText();
				String first1 = offText.getText().substring(0, split);
				String second1 = offText.getText().substring(split, offText.getText().length());
				String zip1 = offZipText.getText();
				String depart = departText.getText();
				String title = titleText.getText();
				String pay = payText.getText();
				newF = new Faculty(fName,lName,pNum,new Address(first, second, zip),new Address(first1,second1,zip1),title,depart,Integer.parseInt(pay));
			
				p.add(newF);

			} catch(Exception e) {
				badInfo.showAndWait();
			}
			nameText.clear();
			phoneText.clear();
			adText.clear();
			zipText.clear();
			offText.clear();
			offZipText.clear();
			titleText.clear();
			departText.clear();
			payText.clear();
			
		});
		
		editB.setOnAction(event -> {
			Faculty faculty = mP.getF();
			String[] name = nameText.getText().split(" ");
			int split =  adText.getText().indexOf(" ");
			String first = adText.getText().substring(0, split);
			String second = adText.getText().substring(split, adText.getText().length());
			String first1 = offText.getText().substring(0, split);
			String second1 = offText.getText().substring(split, adText.getText().length());
			String depart = departText.getText();
			String title = titleText.getText();
			String pay = payText.getText();
			Address nAd = new Address();
			Address nAd1 = new Address();
			if(faculty != null){
				faculty.setfName(name[0]);
				faculty.setlName(name[1]);
				faculty.setPhone(phoneText.getText());
				nAd.setStNum(first);
				nAd.setAdd(second);
				nAd.setZip(zipText.getText());
				nAd1.setStNum(first1);
				nAd1.setAdd(second1);
				nAd1.setZip(offZipText.getText());
				faculty.setAd(nAd);
				faculty.setOfficeAd(nAd1);
				faculty.setDepart(depart);
				faculty.setTitle(title);
				faculty.setPScale(Integer.parseInt(pay));
			}
		});
		
		removeB.setOnAction(event -> {
			Faculty fac = mP.getF();
			if(fac != null){
				p.remove(fac.getId());
			}
			nameText.clear();
			phoneText.clear();
			adText.clear();
			zipText.clear();
			offText.clear();
			offZipText.clear();
			titleText.clear();
			departText.clear();
			payText.clear();
			
		});
		
		Insets myInsets = new Insets(20,0,20,0);
		VBox v1 = new VBox(20);
		VBox v2 = new VBox(20);
		VBox v3 = new VBox(20);
		VBox v4 = new VBox(20);
		hPane = new HBox(30);
		v1.getChildren().addAll(nameLabel,nameText,phoneLabel,phoneText,titleLabel,titleText,addB);
		v2.getChildren().addAll(adLabel,adText,zipLabel,zipText,offLabel,offText,editB);
		v3.getChildren().addAll(departLabel,departText,payLabel,payText,offZipLabel,offZipText,removeB);
		v4.getChildren().addAll(idLabel,idText);
		hPane.getChildren().addAll(v1,v2,v3,v4);
		hPane.setAlignment(Pos.CENTER);
		HBox.setMargin(v1, myInsets);
		HBox.setMargin(v2, myInsets);
		HBox.setMargin(v3, myInsets);
		HBox.setMargin(v4, myInsets);
		scene = new Scene(hPane, 400, 200);
		this.mP = mP;
		this.p = p;
	}
	/**
	 * returns the add button
	 * @return addB
	 */
	public Button getAddB() {
		return addB;
	}
	/**
	 * returns remove button
	 * @return removeB
	 */
	public Button getRemoveB() {
		return removeB;
	}
	/**
	 * returns edit button
	 * @return editB
	 */
	public Button getEditB() {
		return editB;
	}
	/**
	 * returns the scene
	 * @return scene
	 */
	public Scene getScene(){
		return scene;
	}
	/**
	 * returns the horizontal box pane
	 * @return hPane
	 */
	public HBox getPane(){
		return hPane;
	}
	/**
	 * returns the name text field
	 * @return nameText
	 */
	public TextField getNameText() {
		return nameText;
	}
	/**
	 * returns the phone text field
	 * @return phoneText
	 */
	public TextField getPhoneText() {
		return phoneText;
	}
	/**
	 * returns the address text field
	 * @return adText
	 */
	public TextField getAdText() {
		return adText;
	}
	/**
	 * returns the zip text field
	 * @return zipText
	 */
	public TextField getZipText() {
		return zipText;
	}
	/**
	 * returns the office address text field
	 * @return offText
	 */
	public TextField getOffText() {
		return offText;
	}
	/**
	 * returns the office address text field
	 * @return offZipText
	 */
	public TextField getOffZipText() {
		return offZipText;
	}
	/**
	 * returns the department text field
	 * @return departText
	 */
	public TextField getDepartText() {
		return departText;
	}
	/** 
	 * returns the title text field
	 * @return titleText
	 */
	public TextField getTitleText() {
		return titleText;
	}
	/**
	 * returns the pay scale text field
	 * @return payText
	 */
	public TextField getPayText() {
		return payText;
	}
	/**
	 * returns person bag p
	 * @return p
	 */
	public PersonBag getP() {
		return p;
	}
	/**
	 * returns horizontal box pane
	 * @return hPane
	 */
	public HBox gethPane() {
		return hPane;
	}
	/**
	 * returns the main pane
	 * @return mP
	 */
	public MainPane getmP() {
		return mP;
	}
	/**
	 * returns the id text field
	 * @return idText
	 */
	public TextField getIdText() {
		return idText;
	}
	/**
	 * sets the id text field with a specified value
	 * @param idText - idTextField as a String
	 */
	public void setIdText(TextField idText) {
		this.idText = idText;
	}
	
}
