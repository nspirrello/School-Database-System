package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;
/** 
 * @author Nicholas Pirrello
 * Efficient class to handle basic textbook arrays and allow methods to manipulate the items inside
 */
public class TextbookBag implements Serializable{
	private int numOfItems;
	private Textbook[] t;
	/**
	 * creates a new textbook array with a size specified in maxSize
	 * @param maxSize - size stored as an int
	 */
	public TextbookBag(int maxSize){
		t = new Textbook[maxSize];
		numOfItems = 0;
	}
	/**
	 * Adds a textbook to the array
	 * @param t - textbook object
	 */
	public void add(Textbook t){
		this.t[numOfItems] = t;
		numOfItems++;
	}
	/**
	 * displays the contents of the array
	 */
	public void display(){
		for(int i = 0;i < numOfItems;i++){
			System.out.print(t[i] + "\t");
		}
		System.out.println();
	}
	/**
	 * searches through the bag for a specified textbook and then shifts up the rest of the array and decrements the numOfItems by one
	 * @param isbn - String reference to a textbook object
	 * @return text
	 */
	public Textbook remove(String isbn){
		for(int i = 0;i < numOfItems;i++){
			if(t[i].getIsbn().equals(isbn)){
				Textbook text = t[i];
				t[i] = t[i+1];
				for(int j = i+1;j < numOfItems-1;j++){
						t[j] = t[j+1];		
				}
				numOfItems--;
				return text;
			}
		}
		return null;
	}
	/**
	 * searches for a textbook object using isbn and returns the textbook object if found
	 * @param isbn - String reference to a textbook object
	 * @return t[i] - textbook object
	 */
	public Textbook find(String isbn){
		int i = -1;
		for(i = 0;i < numOfItems;i++){
			if(t[i].getIsbn().equals(isbn)){
				break;
			}
		}
		return t[i];
	}
	/** 
	 * imports textbook objects from a text file and adds them to the textbook array
	 * @param file - name of file as a String
	 */
	public void load(String file){
		Scanner fileScan = null;
		File inputFile = new File(file + ".txt");
		try {
			fileScan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(fileScan.hasNext()){
			String str = fileScan.nextLine();
			String[] data = str.split(",");
			Textbook t1 = new Textbook(data[0], data[1], data[2],Double.parseDouble(data[3]),data[4],data[5]);
			t[numOfItems++] = t1;
		}
		fileScan.close();
	}
	/**
	 * returns the textbook array
	 * @return t
	 */
	public Textbook[] getT() {
		return t;
	}
	/**
	 * Sets the textbook array to a new specified textbook array
	 * @param t - textbook array
	 */
	public void setT(Textbook[] t) {
		this.t = t;
	}
	/**
	 * returns the number of items in the array
	 * @return numOfItems
	 */
	public int getNumOfItems() {
		return numOfItems;
	}
	
	
}
