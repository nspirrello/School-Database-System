package p1;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 * 
 * @author Nicholas Pirrello
 * A class to create a UI when handling Students in the Application
 */
public class SPane {
	private Label nameLabel;
	private TextField nameText;
	private Label phoneLabel;
	private TextField phoneText;
	private Label adLabel;
	private TextField adText;
	private Label zipLabel;
	private TextField zipText;
	private Label gpaLabel;
	private TextField gpaText;
	private Label majorLabel;
	private TextField majorText;
	private PersonBag p;
	private HBox hPane;
	private MainPane mP;
	private Scene scene;
	private Button addB;
	private Button removeB;
	private Button editB;
	private Label cTaken;
	private Label cTake;
	private Label cTaking;
	private TextField cTN;
	private TextField cTE;
	private TextField cTG;
	private Label numCred;
	private Label idLabel;
	private TextField idText;
	private Student newS = null;
	
	private CourseBag cb;;
	
	/**
	 * Creates the UI for the Student tab. Contains Labels, Text Fields, Buttons, a Student object, a MainPane, and a PersonBag
	 * @param mP - MainPane
	 * @param p - PersonBag
	 */
	public SPane(MainPane mP, PersonBag p){
		nameLabel = new Label("Name: ");
		nameText = new TextField();
		phoneLabel = new Label("Phone Number: ");
		phoneText = new TextField();
		adLabel = new Label("Address: ");
		adText = new TextField();
		zipLabel = new Label("Zip: ");
		zipText = new TextField();
		gpaLabel = new Label("Gpa: ");
		gpaText = new TextField();
		majorLabel = new Label("Major: ");
		majorText = new TextField();
		idLabel = new Label("ID: ");
		idText = new TextField();
		idText.setEditable(false);
		
		
		cTaken = new Label("Courses Taken: ");
		cTN = new TextField();
		cTN.setPrefSize(200, 100);
		cTaking = new Label("Enrolled Courses: ");
		cTG = new TextField();
		cTG.setPrefSize(200, 100);
		cTake = new Label("Courses not taken: ");
		cTE = new TextField();
		cTE.setPrefSize(200, 100);
		
		Course c112 = new Course("CST112");
		Course c141 = new Course("CST141");
		Course c242 = new Course("CST242");
		Course c246 = new Course("CST246");
		
		
		MasterCourseBag compSci = new MasterCourseBag(10);
		compSci.addTo(c112);
		compSci.addTo(c141);
		compSci.addTo(c242);
		compSci.addTo(c246);
		
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
			try {
				String[] name = nameText.getText().split(" ");
				String fName = name[0];
				String lName = name[1];
				String pNum = null;
				if(phoneText.getText().length() == 10){
					pNum = phoneText.getText();
				}else {
					throw new Exception();
				}
				int split =  adText.getText().indexOf(" ");
				String first = adText.getText().substring(0, split);
				String second = adText.getText().substring(split, adText.getText().length());
				String zip = zipText.getText();
				String major = majorText.getText();
				newS = new Student(fName,lName,pNum,new Address(first, second, zip));
				
//				newS.setAd(new Address(first,second,zip));
//				newS.setfName(fName);
//				newS.setlName(lName);
//				newS.setPhone(pNum);
				
				p.add(newS);
				newS.setMajor(major);
				
				String[] tempArr = cTN.getText().split(" ");
				for(int i = 0;i < tempArr.length;i++){
					newS.addCourses(tempArr[i], 0);
				}
				
				String[] tempArr1 = cTG.getText().split(" ");
				for(int j = 0;j < tempArr1.length;j++){
					newS.addCourses(tempArr1[j], 1);
				}
				
				MasterCourseBag tempCompSci = compSci;
				cb = newS.getCBag();
				if(newS.getMajor().equals("Computer Science")){
					for(int i = 0;i < cb.getNumOfC();i++){
						if(compSci.findBool(cb.getcArray()[i].getCourseId())){
							tempCompSci.remove(cb.getcArray()[i].getCourseId());
						}
					}
					
					for(int i = 0;i < tempCompSci.getNumOfItems();i++){
						System.out.println(tempCompSci.getC()[i].getcNum());
						newS.addCourses(tempCompSci.getC()[i].getcNum(), 2);
					}
				} 
				if(Double.parseDouble(gpaText.getText()) > 0 && Double.parseDouble(gpaText.getText()) < 4){
					newS.setGpa(Double.parseDouble(gpaText.getText()));
				}else{
					throw new Exception();
				}
				
			} catch(Exception e) {
				badInfo.showAndWait();
			}
			nameText.clear();
			phoneText.clear();
			adText.clear();
			zipText.clear();
			gpaText.clear();
			majorText.clear();
			cTG.clear();
			cTN.clear();
			cTE.clear();
		});
		
		removeB.setOnAction(event -> {
			Student student = mP.getS();
			if(student != null){
				p.remove(student.getId());
			}
			nameText.clear();
			phoneText.clear();
			adText.clear();
			zipText.clear();
			gpaText.clear();
			majorText.clear();
			cTN.clear();
			cTG.clear();
			cTE.clear();
		});
		
		editB.setOnAction(event -> {
			Student student = mP.getS();
			
			System.out.print(student.getCBag().getNumOfC());
			
//			for(int i = 0;i > student.getCBag().getNumOfC();i++){
//				System.out.println("wtf");
//				System.out.print(student.getCBag().getcArray()[i].getType() + " ");
//			}
			Alert badInfo = new Alert(AlertType.ERROR);
			badInfo.setHeaderText("Invalid Info entered!");
			badInfo.setContentText("Please double check the information entered.");
			badInfo.setTitle("Error!");
			
			String[] name = nameText.getText().split(" ");
			int split =  adText.getText().indexOf(" ");
			String first = adText.getText().substring(0, split);
			String second = adText.getText().substring(split, adText.getText().length());
			String major = majorText.getText();
			Double gpa = null;
			
			if(Double.parseDouble(gpaText.getText()) > 0 && Double.parseDouble(gpaText.getText()) < 4){
				gpa = Double.parseDouble(gpaText.getText());
			}else{
				badInfo.showAndWait();
			}
			Address nAd = new Address();
			
			if(student != null){
				student.setfName(name[0]);
				student.setlName(name[1]);
				student.setGpa(gpa);
				student.setPhone(phoneText.getText());
				nAd.setStNum(first);
				nAd.setAdd(second);
				nAd.setZip(zipText.getText());
				student.setAd(nAd);
				student.setMajor(major);
			}
			
			for(int i = student.getCBag().getNumOfC()-1;i >= 0;i--){
				System.out.print(student.getCBag().getcArray()[i].getType() + " ");
//				if(student.getCBag().getcArray()[i].getType() == 0){
//					student.getCBag().delete(student.getCBag().getcArray()[i].getCourseId(), 0);
//				}
//				if(student.getCBag().getcArray()[i].getType() == 1){
//					student.getCBag().delete(student.getCBag().getcArray()[i].getCourseId(), 1);
//				}
				if(student.getCBag().getcArray()[i].getType() == 2){
					student.getCBag().delete(student.getCBag().getcArray()[i].getCourseId(), 2);
				}else if(student.getCBag().getcArray()[i].getType() == 1){
					student.getCBag().delete(student.getCBag().getcArray()[i].getCourseId(), 1);
				}else if(student.getCBag().getcArray()[i].getType() == 0){
					student.getCBag().delete(student.getCBag().getcArray()[i].getCourseId(), 0);
				}
			}
			System.out.print("After delete");
			student.getCBag().display();
			System.out.println();
			
			String[] tempArr = cTN.getText().split(" ");
			for(int k = 0;k < tempArr.length;k++){
				student.addCourses(tempArr[k], 0);
			}
			
			System.out.print("After first array ");
			student.getCBag().display();
			System.out.println();
			
			String[] tempArr1 = cTG.getText().split(" ");
			for(int j = 0;j < tempArr1.length;j++){
				student.addCourses(tempArr1[j], 1);
			}
			
			System.out.print("After second array ");
			student.getCBag().display();
			System.out.println();
			
//			MasterCourseBag tempBag = new MasterCourseBag(compSci.getC().length);
//			tempBag.setNumOfItems(compSci.getNumOfItems());
//			for(int i= 0;i < compSci.getNumOfItems();i++){
//				tempBag.getC()[i] = compSci.getC()[i];
//			}
			CourseBag cbTemp = new CourseBag(10);
			MasterCourseBag tempCompSci = compSci;
			cb = student.getCBag();
			if(student.getMajor().equals("Computer Science")){
				for(int k = 0;k < cb.getNumOfC();k++){
//					if(compSci.findBool(cb.getcArray()[i].getCourseId()) == false){
//						cbTemp.add(cb.getcArray()[i].getCourseId(), 2);
//						cbTemp.display();
//						for(int j = 0;j < cbTemp.getNumOfC();j++){
//							if(compSci.findBool(cbTemp.getcArray()[j].getCourseId())){
//								student.addCourses(cbTemp.getcArray()[j].getCourseId(), 2);
//							}
//						}
//					}
					for(int m = 0;m < cb.getNumOfC();m++){
						if(compSci.findBool(cb.getcArray()[m].getCourseId())){
							tempCompSci.remove(cb.getcArray()[m].getCourseId());
						}
					}
					
					for(int j = 0;j < tempCompSci.getNumOfItems();j++){
						System.out.println(tempCompSci.getC()[j].getcNum());
						student.addCourses(tempCompSci.getC()[j].getcNum(), 2);
					}
				}
				
//				for(int i = 0;i < tempBag.getNumOfItems();i++){
//					System.out.println(tempBag.getC()[i].getcNum());
//					student.addCourses(tempBag.getC()[i].getcNum(), 2);
//				}
			} 
			
			
			
			nameText.clear();
			phoneText.clear();
			adText.clear();
			zipText.clear();
			gpaText.clear();
			majorText.clear();
			cTG.clear();
			cTN.clear();
			cTE.clear();
		});
		
		Insets myInsets = new Insets(20,0,20,0);
		VBox v1 = new VBox(20);
		VBox v2 = new VBox(20);
		VBox v3 = new VBox(20);
		hPane = new HBox(30);
		Label temp = new Label();
		Label temp1 = new Label();
		TextField temp2 = new TextField();
		TextField temp3 = new TextField();
		temp2.setVisible(false);
		temp3.setVisible(false);
		
		v1.getChildren().addAll(nameLabel,nameText,phoneLabel,phoneText,gpaLabel,gpaText,cTaken,cTN,addB);
		v2.getChildren().addAll(adLabel,adText,zipLabel,zipText,temp1,temp3,cTaking,cTG,editB);
		v3.getChildren().addAll(idLabel,idText,majorLabel,majorText,temp,temp2,cTake,cTE,removeB);
		hPane.getChildren().addAll(v1,v2,v3);
		hPane.setAlignment(Pos.CENTER);
		HBox.setMargin(v1, myInsets);
		HBox.setMargin(v2, myInsets);
		HBox.setMargin(v3, myInsets);
		scene = new Scene(hPane, 400, 200);
		this.mP = mP;
		this.p = p;
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
	 * returns the zip code text field
	 * @return zipText
	 */
	public TextField getZipText() {
		return zipText;
	}
	/** 
	 * returns the gpa text field
	 * @return gpaText
	 */
	public TextField getGpaText() {
		return gpaText;
	}
	/** 
	 * returns the major text field
	 * @return majorText
	 */
	public TextField getMajorText() {
		return majorText;
	}
	/**
	 * returns the add button
	 * @return addB
	 */
	public Button getAddB() {
		return addB;
	}
	/**
	 * returns the edit button
	 * @return editB
	 */
	public Button getEditB() {
		return editB;
	}
	/**
	 * returns the remove button
	 * @return removeB
	 */
	public Button getRemoveB() {
		return removeB;
	}
	/**
	 * returns id text
	 * @return idText
	 */
	public TextField getIdText() {
		return idText;
	}
	/**
	 * sets the id text to a specified value
	 * @param idText - idtext as a text field
	 */
	public void setIdText(TextField idText) {
		this.idText = idText;
	}
	/**
	 * returns the coursebag
	 * @return cb
	 */
	public CourseBag getCb(){
		return cb;
	}
	/**
	 * returns the major label
	 * @return majorLabel
	 */
	public Label getMajorLabel() {
		return majorLabel;
	}
	/**
	 * returns the personbag
	 * @return p
	 */
	public PersonBag getP() {
		return p;
	}
	/**
	 * returns the horizontal box pane
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
	 * returns the courses taken text field
	 * @return cTN
	 */
	public TextField getcTN() {
		return cTN;
	}
	/**
	 * returns the courses needed to take text field
	 * @return cTE
	 */
	public TextField getcTE() {
		return cTE;
	}
	/**
	 * returns the currently taking courses text field
	 * @return cTG
	 */
	public TextField getcTG() {
		return cTG;
	}
	/**
	 * returns a student object
	 */
	public Student getNewS(){
		return newS;
	}
	
	
}
