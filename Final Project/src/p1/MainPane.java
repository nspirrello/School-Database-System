package p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * @author Nicholas Pirrello
 * This is the main window for the application
 */
public class MainPane {
	private TabPane tabPane;
	private BorderPane borderPane;
	private MenuBar menuBar;
	private SPane sPane;
	private Tab sTab;
	private FPane fPane;
	private Tab fTab;
	private TPane tPane;
	private Tab tTab;
	private CPane cPane;
	private Tab cTab;
	private MasterCourseBag mCB = new MasterCourseBag(10);
	private Course c = new Course();
	private TextbookBag t = new TextbookBag(10);
	private PersonBag p = new PersonBag(10);
	private Student s = new Student();
	private Faculty f = new Faculty();
	private Textbook tb = new Textbook();
	private File file1;
	private String[] a;
	
	
	/**
	 * This method builds the tab pane, the border pane and the menu shown in the window.
	 * @param stage - stage passed in, used to set scene
	 */
	public MainPane(Stage stage){
		buildTab();
		buildBorder();
		buildMenu();
		
		borderPane.setTop(menuBar);
		borderPane.setCenter(tabPane);
		stage.setScene(new Scene(borderPane, 700, 500));
		stage.show();
	}
	/**
	 * creates a tab pane
	 */
	public void buildTab(){
		tabPane = new TabPane();	
	}
	/** 
	 * creates a border pane
	 */
	public void buildBorder(){
		borderPane = new BorderPane();
	}
	/**
	 * creates a menu pane with a menu bar, menus, and menu items as well as handles and launches the needed pane based on what menu items are clicked
	 */
	public void buildMenu(){
		menuBar = new MenuBar();
		
		Menu file = new Menu("File");
		MenuItem openBin = new MenuItem("Open");
		MenuItem saveBin = new MenuItem("Save");
		Menu importT = new Menu("Import...");
		MenuItem exit = new MenuItem("Exit");
		
		
		
		saveBin.setOnAction(event -> {
			FileChooser fileC = new FileChooser();
			FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
			fileC.getExtensionFilters().add(extensionFilter);
			fileC.setTitle("Save data");
			file1 = fileC.showSaveDialog(new Stage());
			
			FileOutputStream fStream = null;
			ObjectOutputStream outFile = null;
			a = (file1.getName()).split(".");
			//for the personBag
			System.out.println(p.getNumOfItems());
			try {
				fStream = new FileOutputStream(file1,true);
				outFile = new ObjectOutputStream(fStream);
					outFile.writeObject(p);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			//for the textbookBag
			try {
				fStream = new FileOutputStream("Text" + ".dat",true);
				outFile = new ObjectOutputStream(fStream);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
					outFile.writeObject(t);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			//for the MasterCourseBag
			try {
				fStream = new FileOutputStream("Course" + ".dat",true);
				outFile = new ObjectOutputStream(fStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
					outFile.writeObject(mCB);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				outFile.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		});
		
		openBin.setOnAction(event -> {
			FileChooser fileC = new FileChooser();
			FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("DAT files (*.dat)", "*.dat");
			fileC.getExtensionFilters().add(extensionFilter);
			fileC.setTitle("Save data");
			file1 = fileC.showOpenDialog(new Stage());
			FileInputStream fStream = null;
			ObjectInputStream dis = null;
			//personBag
			try {
				fStream = new FileInputStream(file1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				dis = new ObjectInputStream(fStream);
			} catch (Exception e) {
				System.out.println(e.getMessage());   
			}
			try {
				p = ((PersonBag) dis.readObject());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Arrays.toString(p.getP()));
			//textbookBag
			try {
				fStream = new FileInputStream("Text" + ".dat");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				dis = new ObjectInputStream(fStream);
			} catch (Exception e) {
				System.out.println(e.getMessage());   
			}
			try {
				t = (TextbookBag) dis.readObject();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			//MasterCourseBag
			try {
				fStream = new FileInputStream("Course" + ".dat");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				dis = new ObjectInputStream(fStream);
			} catch (Exception e) {
				System.out.println(e.getMessage());   
			}
			try {
				mCB = (MasterCourseBag) dis.readObject();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				dis.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});
		
		MenuItem studentI = new MenuItem("Import Student...");
		MenuItem facultyI = new MenuItem("Import Faculty...");
		MenuItem textbookI = new MenuItem("Import Textbook...");
		MenuItem courseI = new MenuItem("Import Course...");
		
		importT.getItems().addAll(studentI,facultyI,textbookI,courseI);
		
		studentI.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter a file name");
			dialog.setTitle("File name required!");
			dialog.setHeaderText("Enter a file name: ");
			dialog.setContentText("Please enter a valid file name: ");
			Optional<String> result = dialog.showAndWait();
			p.studLoad(result.get());
		});
		
		facultyI.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter a file name");
			dialog.setTitle("File name required!");
			dialog.setHeaderText("Enter a file name: ");
			dialog.setContentText("Please enter a valid file name: ");
			Optional<String> result = dialog.showAndWait();
			p.facLoad(result.get());
		});
		
		textbookI.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter a file name");
			dialog.setTitle("File name required!");
			dialog.setHeaderText("Enter a file name: ");
			dialog.setContentText("Please enter a valid file name: ");
			Optional<String> result = dialog.showAndWait();
			t.load(result.get());
		});
		
		courseI.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter a file name");
			dialog.setTitle("File name required!");
			dialog.setHeaderText("Enter a file name: ");
			dialog.setContentText("Please enter a valid file name: ");
			Optional<String> result = dialog.showAndWait();
			mCB.load(result.get());
		});
		
		Alert badInfo = new Alert(AlertType.ERROR);
		badInfo.setHeaderText("Invalid Info entered!");
		badInfo.setContentText("Please double check the information entered.");
		badInfo.setTitle("Error!");
		
		exit.setOnAction(event -> {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Exiting...");
			confirm.setHeaderText("Are you sure you want to exit?");
			confirm.getButtonTypes().setAll(ButtonType.YES, ButtonType.CANCEL);
			Optional<ButtonType> result = confirm.showAndWait();
			if(result.get() == ButtonType.YES) {
				Platform.exit();
			}
		});
		
		file.getItems().addAll(importT, new SeparatorMenuItem(),openBin, saveBin, new SeparatorMenuItem(),  exit);
		
		Menu student = new Menu("Student");
		MenuItem findStud = new MenuItem("Search for...");
		MenuItem addStud = new MenuItem("Add new...");
		MenuItem editStud = new MenuItem("Edit existing...");
		MenuItem deleteStud = new MenuItem("Delete existing...");
		
		student.getItems().addAll(findStud,new SeparatorMenuItem(),addStud,editStud,new SeparatorMenuItem(),deleteStud);
		
		addStud.setOnAction(event -> {
			tabPane.getTabs().removeAll(sTab,fTab,tTab,cTab);
			sTab = new Tab("Student");
			sPane = new SPane(this, p);
			sTab.setContent(sPane.getPane());
			sPane.getEditB().setDisable(true);
			sPane.getRemoveB().setDisable(true);
			tabPane.getTabs().addAll(sTab);
		});
		
		findStud.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ID");
			dialog.setTitle("ID # required!");
			dialog.setHeaderText("Enter a valid id: ");
			dialog.setContentText("Please enter a valid ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(sTab,fTab,tTab,cTab);
				sTab = new Tab("Student");
				sPane = new SPane(this, p);
				sTab.setContent(sPane.getPane());
				tabPane.getTabs().addAll(sTab);
				sPane.getAddB().setDisable(true);
				try {
					s = (Student) p.find(result.get());
					
					sPane.getNameText().setText(s.getfName() + " " + s.getlName());
					sPane.getPhoneText().setText(s.getPhone());
					Address a = s.getAd();
					String st = a.getAdd();
					String stN = a.getStNum();
					String z = a.getZip();
					String m = s.getMajor();
					sPane.getAdText().setText(stN + " " + st);
					sPane.getZipText().setText(z);;
					sPane.getGpaText().setText(String.valueOf(s.getGpa()));
					sPane.getIdText().setText(s.getId());
					sPane.getIdText().setEditable(false);
					sPane.getMajorText().setText(m);
					for(int i = 0;i < s.getCBag().getNumOfC();i++){
						if(s.getCBag().getcArray()[i].getType() == 0){
							sPane.getcTN().setText(sPane.getcTN().getText() + " " + s.getCBag().getcArray()[i].getCourseId());
						}
						if(s.getCBag().getcArray()[i].getType() == 1){
							sPane.getcTG().setText(sPane.getcTG().getText() + " " + s.getCBag().getcArray()[i].getCourseId());
						}
						if(s.getCBag().getcArray()[i].getType() == 2){
							sPane.getcTE().setText(sPane.getcTE().getText() + " " + s.getCBag().getcArray()[i].getCourseId());
						}
					}

				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(sTab);
				}
			});
		});
		
		editStud.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ID");
			dialog.setTitle("ID # required!");
			dialog.setHeaderText("Enter a valid id: ");
			dialog.setContentText("Please enter a valid ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(sTab,fTab,tTab,cTab);
				sTab = new Tab("Student");
				sPane = new SPane(this, p);
				sTab.setContent(sPane.getPane());
				tabPane.getTabs().addAll(sTab);
				sPane.getAddB().setDisable(true);
				sPane.getRemoveB().setDisable(true);
				try {
					s = (Student) p.find(result.get());
					
					sPane.getNameText().setText(s.getfName() + " " + s.getlName());
					sPane.getPhoneText().setText(s.getPhone());
					Address a = s.getAd();
					String st = a.getAdd();
					String stN = a.getStNum();
					String z = a.getZip();
					String m = s.getMajor();
					sPane.getAdText().setText(stN + " " + st);
					sPane.getZipText().setText(z);;
					sPane.getGpaText().setText(String.valueOf(s.getGpa()));
					sPane.getIdText().setText(s.getId());
					sPane.getIdText().setEditable(false);
					sPane.getMajorText().setText(m);
					for(int i = 0;i < s.getCBag().getNumOfC();i++){
						if(s.getCBag().getcArray()[i].getType() == 0){
							sPane.getcTN().setText(sPane.getcTN().getText() + " " + s.getCBag().getcArray()[i].getCourseId());
						}
					}
						
					for(int j = 0;j < s.getCBag().getNumOfC();j++){
						if(s.getCBag().getcArray()[j].getType() == 1){
							sPane.getcTG().setText(sPane.getcTG().getText() + " " + s.getCBag().getcArray()[j].getCourseId());
						}
					}
						
					for(int k = 0;k < s.getCBag().getNumOfC();k++){
						if(s.getCBag().getcArray()[k].getType() == 2){
							sPane.getcTE().setText(sPane.getcTE().getText() + " " + s.getCBag().getcArray()[k].getCourseId());
						}
					}
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(sTab);
				}
		
			});
		});
		
		deleteStud.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ID");
			dialog.setTitle("ID # required!");
			dialog.setHeaderText("Enter a valid id: ");
			dialog.setContentText("Please enter a valid ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(sTab,fTab,tTab,cTab);
				sTab = new Tab("Student");
				sPane = new SPane(this, p);
				sTab.setContent(sPane.getPane());
				tabPane.getTabs().addAll(sTab);
				sPane.getAddB().setDisable(true);
				sPane.getEditB().setDisable(true);
				try {
					s = (Student) p.find(result.get());
					
					sPane.getNameText().setText(s.getfName() + " " + s.getlName());
					sPane.getPhoneText().setText(s.getPhone());
					Address a = s.getAd();
					String st = a.getAdd();
					String stN = a.getStNum();
					String z = a.getZip();
					String m = s.getMajor();
					sPane.getAdText().setText(stN + " " + st);
					sPane.getZipText().setText(z);
					sPane.getGpaText().setText(String.valueOf(s.getGpa()));
					sPane.getIdText().setText(s.getId());
					sPane.getIdText().setEditable(false);
					sPane.getMajorText().setText(m);
					for(int i = 0;i < s.getCBag().getNumOfC();i++){
						if(s.getCBag().getcArray()[i].getType() == 0){
							sPane.getcTN().setText(sPane.getcTN().getText() + " " + s.getCBag().getcArray()[i].getCourseId());
						}
					}
						
					for(int j = 0;j < s.getCBag().getNumOfC();j++){
						if(s.getCBag().getcArray()[j].getType() == 1){
							sPane.getcTG().setText(sPane.getcTG().getText() + " " + s.getCBag().getcArray()[j].getCourseId());
						}
					}
						
					for(int k = 0;k < s.getCBag().getNumOfC();k++){
						if(s.getCBag().getcArray()[k].getType() == 2){
							sPane.getcTE().setText(sPane.getcTE().getText() + " " + s.getCBag().getcArray()[k].getCourseId());
						}
					}
				} catch (NullPointerException e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(sTab);
				} catch(IndexOutOfBoundsException e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(sTab);
				}
		
			});
		});
		
		Menu faculty = new Menu("Faculty");
		MenuItem findFac = new MenuItem("Search for...");
		MenuItem addFac = new MenuItem("Add new...");
		MenuItem editFac = new MenuItem("Edit existing...");
		MenuItem deleteFac = new MenuItem("Delete existing...");
		
		faculty.getItems().addAll(findFac,new SeparatorMenuItem(),addFac,editFac,new SeparatorMenuItem(),deleteFac);
		
		addFac.setOnAction(event -> {
			tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
			fTab = new Tab("Faculty");
			fPane = new FPane(this, p);
			fTab.setContent(fPane.getPane());
			fPane.getEditB().setDisable(true);
			fPane.getRemoveB().setDisable(true);
			tabPane.getTabs().addAll(fTab);
		});
		
		findFac.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ID");
			dialog.setTitle("ID # required!");
			dialog.setHeaderText("Enter a valid id: ");
			dialog.setContentText("Please enter a valid ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				fTab = new Tab("Faculty");
				fPane = new FPane(this, p);
				fTab.setContent(fPane.getPane());
				tabPane.getTabs().addAll(fTab);
				fPane.getAddB().setDisable(true);
				try {
					f = (Faculty) p.find(result.get());
					
					fPane.getNameText().setText(f.getfName() + " " + f.getlName());
					fPane.getPhoneText().setText(f.getPhone());
					Address a = f.getAd();
					String st = a.getAdd();
					String stN = a.getStNum();
					String z = a.getZip();
					Address a1 = f.getAd();
					String st1 = a1.getAdd();
					String stN1 = a1.getStNum();
					String z1 = a1.getZip();
					fPane.getAdText().setText(stN + " " + st);
					fPane.getZipText().setText(z);
					fPane.getOffText().setText(stN1 + " " + st1);
					fPane.getOffZipText().setText(z1);
					fPane.getDepartText().setText(f.getDepart());
					fPane.getPayText().setText(String.valueOf(f.getPScale()));
					fPane.getTitleText().setText(f.getTitle());
					fPane.getIdText().setText(f.getId());
					fPane.getIdText().setEditable(false);
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});

		editFac.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ID");
			dialog.setTitle("ID # required!");
			dialog.setHeaderText("Enter a valid id: ");
			dialog.setContentText("Please enter a valid ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				fTab = new Tab("Faculty");
				fPane = new FPane(this, p);
				fTab.setContent(fPane.getPane());
				tabPane.getTabs().addAll(fTab);
				fPane.getAddB().setDisable(true);
				fPane.getRemoveB().setDisable(true);
				try {
					f = (Faculty) p.find(result.get());
					
					fPane.getNameText().setText(f.getfName() + " " + f.getlName());
					fPane.getPhoneText().setText(f.getPhone());
					Address a = f.getAd();
					String st = a.getAdd();
					String stN = a.getStNum();
					String z = a.getZip();
					Address a1 = f.getAd();
					String st1 = a1.getAdd();
					String stN1 = a1.getStNum();
					String z1 = a1.getZip();
					fPane.getAdText().setText(stN + " " + st);
					fPane.getZipText().setText(z);
					fPane.getOffText().setText(stN1 + " " + st1);
					fPane.getOffZipText().setText(z1);
					fPane.getDepartText().setText(f.getDepart());
					fPane.getPayText().setText(String.valueOf(f.getPScale()));
					fPane.getTitleText().setText(f.getTitle());
					fPane.getIdText().setText(f.getId());
					fPane.getIdText().setEditable(false);
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});
		
		deleteFac.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ID");
			dialog.setTitle("ID # required!");
			dialog.setHeaderText("Enter a valid id: ");
			dialog.setContentText("Please enter a valid ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				fTab = new Tab("Faculty");
				fPane = new FPane(this, p);
				fTab.setContent(fPane.getPane());
				tabPane.getTabs().addAll(fTab);
				fPane.getAddB().setDisable(true);
				fPane.getEditB().setDisable(true);
				try {
					f = (Faculty) p.find(result.get());
					
					fPane.getNameText().setText(f.getfName() + " " + f.getlName());
					fPane.getPhoneText().setText(f.getPhone());
					Address a = f.getAd();
					String st = a.getAdd();
					String stN = a.getStNum();
					String z = a.getZip();
					Address a1 = f.getAd();
					String st1 = a1.getAdd();
					String stN1 = a1.getStNum();
					String z1 = a1.getZip();
					fPane.getAdText().setText(stN + " " + st);
					fPane.getZipText().setText(z);
					fPane.getOffText().setText(stN1 + " " + st1);
					fPane.getOffZipText().setText(z1);
					fPane.getDepartText().setText(f.getDepart());
					fPane.getPayText().setText(String.valueOf(f.getPScale()));
					fPane.getTitleText().setText(f.getTitle());
					fPane.getIdText().setText(f.getId());
					fPane.getIdText().setEditable(false);
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});
		
		Menu course = new Menu("Course");
		MenuItem findC = new MenuItem("Search for...");
		MenuItem addC = new MenuItem("Add new...");
		MenuItem editC = new MenuItem("Edit existing...");
		MenuItem deleteC = new MenuItem("Delete existing...");
		
		course.getItems().addAll(findC,new SeparatorMenuItem(),addC,editC,new SeparatorMenuItem(),deleteC);
		
		addC.setOnAction(event -> {
			tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
			cTab = new Tab("Course");
			cPane = new CPane(this, mCB);
			cTab.setContent(cPane.gethPane());
			cPane.getEditB().setDisable(true);
			cPane.getRemoveB().setDisable(true);
			tabPane.getTabs().addAll(cTab);
		});
		
		findC.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter a Course ID");
			dialog.setTitle("Course ID # required!");
			dialog.setHeaderText("Enter a valid Course ID: ");
			dialog.setContentText("Please enter a valid Course ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				cTab = new Tab("Course");
				cPane = new CPane(this, mCB);
				cTab.setContent(cPane.gethPane());
				tabPane.getTabs().addAll(cTab);
				cPane.getAddB().setDisable(true);
				try {
					c = (Course) mCB.find(result.get());
					
					cPane.getTitleText().setText(c.getcTitle());
					cPane.getNumText().setText(c.getcNum());
					cPane.getCrnText().setText(c.getCrn());
					cPane.getIsbnText().setText(c.getIsbn());
					cPane.getCreditText().setText(String.valueOf(c.getNumCredit()));
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});
		
		editC.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter a Course ID");
			dialog.setTitle("Course ID # required!");
			dialog.setHeaderText("Enter a valid Course ID: ");
			dialog.setContentText("Please enter a valid Course ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				cTab = new Tab("Course");
				cPane = new CPane(this, mCB);
				cTab.setContent(cPane.gethPane());
				tabPane.getTabs().addAll(cTab);
				cPane.getAddB().setDisable(true);
				try {
					c = (Course) mCB.find(result.get());
					
					cPane.getTitleText().setText(c.getcTitle());
					cPane.getNumText().setText(c.getcNum());
					cPane.getCrnText().setText(c.getCrn());
					cPane.getIsbnText().setText(c.getIsbn());
					cPane.getCreditText().setText(String.valueOf(c.getNumCredit()));
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});
		
		deleteC.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter a Course ID");
			dialog.setTitle("Course ID # required!");
			dialog.setHeaderText("Enter a valid Course ID: ");
			dialog.setContentText("Please enter a valid Course ID: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(id -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				cTab = new Tab("Course");
				cPane = new CPane(this, mCB);
				cTab.setContent(cPane.gethPane());
				tabPane.getTabs().addAll(cTab);
				cPane.getAddB().setDisable(true);
				try {
					c = (Course) mCB.find(result.get());
					
					cPane.getTitleText().setText(c.getcTitle());
					cPane.getNumText().setText(c.getcNum());
					cPane.getCrnText().setText(c.getCrn());
					cPane.getIsbnText().setText(c.getIsbn());
					cPane.getCreditText().setText(String.valueOf(c.getNumCredit()));
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});
		
		Menu text = new Menu("Textbook");
		MenuItem findT = new MenuItem("Search for...");
		MenuItem addT = new MenuItem("Add new...");
		MenuItem editT = new MenuItem("Edit existing...");
		MenuItem deleteT = new MenuItem("Delete existing...");
		
		text.getItems().addAll(findT,new SeparatorMenuItem(),addT,editT,new SeparatorMenuItem(),deleteT);
		
		addT.setOnAction(event -> {
			tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
			tTab = new Tab("Texbook");
			tPane = new TPane(this, t);
			tTab.setContent(tPane.gethPane());
			tPane.getEditB().setDisable(true);
			tPane.getRemoveB().setDisable(true);
			tabPane.getTabs().addAll(tTab);
		});
		
		findT.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ISBN");
			dialog.setTitle("ISBN # required!");
			dialog.setHeaderText("Enter a valid ISBN: ");
			dialog.setContentText("Please enter a valid ISBN: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(isbn -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				tTab = new Tab("Textbook");
				tPane = new TPane(this, t);
				tTab.setContent(tPane.gethPane());
				tabPane.getTabs().addAll(tTab);
				tPane.getAddB().setDisable(true);
				try {
					tb = (Textbook) t.find(result.get());
					
					tPane.getBookText().setText(tb.getBookTitle());
					tPane.getAuthorText().setText(tb.getAuthor());
					tPane.getPubText().setText(tb.getPublisher());
					tPane.getYearText().setText(tb.getYearPub());
					tPane.getIsbnText().setText(tb.getIsbn());
					tPane.getPriceText().setText(String.valueOf(tb.getBookPrice()));
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});
		
		deleteT.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ISBN");
			dialog.setTitle("ISBN # required!");
			dialog.setHeaderText("Enter a valid ISBN: ");
			dialog.setContentText("Please enter a valid ISBN: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(isbn -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				tTab = new Tab("Textbook");
				tPane = new TPane(this, t);
				tTab.setContent(tPane.gethPane());
				tabPane.getTabs().addAll(tTab);
				tPane.getAddB().setDisable(true);
				try {
					tb = (Textbook) t.find(result.get());
					
					tPane.getBookText().setText(tb.getBookTitle());
					tPane.getAuthorText().setText(tb.getAuthor());
					tPane.getPubText().setText(tb.getPublisher());
					tPane.getYearText().setText(tb.getYearPub());
					tPane.getIsbnText().setText(tb.getIsbn());
					tPane.getPriceText().setText(String.valueOf(tb.getBookPrice()));
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});
		
		editT.setOnAction(event -> {
			TextInputDialog dialog = new TextInputDialog("Enter an ISBN");
			dialog.setTitle("ISBN # required!");
			dialog.setHeaderText("Enter a valid ISBN: ");
			dialog.setContentText("Please enter a valid ISBN: ");
			
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(isbn -> {
				tabPane.getTabs().removeAll(fTab,sTab,tTab,cTab);
				tTab = new Tab("Textbook");
				tPane = new TPane(this, t);
				tTab.setContent(tPane.gethPane());
				tabPane.getTabs().addAll(tTab);
				tPane.getAddB().setDisable(true);
				try {
					tb = (Textbook) t.find(result.get());
					
					tPane.getBookText().setText(tb.getBookTitle());
					tPane.getAuthorText().setText(tb.getAuthor());
					tPane.getPubText().setText(tb.getPublisher());
					tPane.getYearText().setText(tb.getYearPub());
					tPane.getIsbnText().setText(tb.getIsbn());
					tPane.getPriceText().setText(String.valueOf(tb.getBookPrice()));
				} catch (Exception e) {
					badInfo.showAndWait();
					tabPane.getTabs().removeAll(fTab);
				}
		
			});
		});
		
		
		menuBar.getMenus().addAll(file, student, faculty, course, text);
		
		
	}
	/**
	 * returns a new Student object
	 * @return s
	 */
	public Student getS(){
		return s;
	}
	/**
	 * returns a new faculty object
	 * @return f
	 */
	public Faculty getF(){
		return f;
	}
	/**
	 * returns a new textbook object
	 * @return tb
	 */
	public Textbook getTb(){
		return tb;
	}
	/**
	 * returns a new course object
	 * @return
	 */
	public Course getC(){
		return c;
	}
	/**
	 * returns a split file name as a String array
	 * @return a
	 */
	public String[] getF1(){
		return a;
	}
}
