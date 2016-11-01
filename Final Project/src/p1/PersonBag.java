package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Nicholas Pirrello
 * Efficient class to handle basic person arrays and allow methods to manipulate
 */
public class PersonBag implements Serializable{
	private int numOfItems;
	private Person[] p;
	/**
	 * Creates a new array with a size of a specified value and sets the number of items in the array to 0
	 * @param maxSize - an integer value that acts as a size
	 */
	public PersonBag(int maxSize){
		p = new Person[maxSize];
		numOfItems = 0;
	}
	/**
	 * Adds a person object to the array and increments the number of items by one
	 * @param p - a person object to be added to the array
	 */
	public void add(Person p){
		this.p[numOfItems] = p;
		numOfItems++;
	}
	/**
	 * displays the contents of the array
	 */
	public void display(){
		for(int i = 0;i < numOfItems;i++){
			System.out.print(p[i] + "\t");
		}
		System.out.println();
	}
	/**
	 * searches for a person object by id and then shifts the rest of the array up and decrements the number of items by one
	 * @param id - String id reference for a person object
	 * @return person
	 */
	public Person remove(String id){
		for(int i = 0;i < numOfItems;i++){
			if(p[i].getId().equals(id)){
				Person person = p[i];
				p[i] = p[i+1];
				for(int j = i+1;j < numOfItems-1;j++){
						p[j] = p[j+1];		
				}
				numOfItems--;
				return person;
			}
		}
		return null;
	}
	/**
	 * seacrhes for a person object by id and then returns that object
	 * @param id - String id reference for a person object
	 * @return p[i] - person object
	 */
	public Person find(String id){
		int i = -1;
		for(i = 0;i < numOfItems;i++){
			if(p[i].getId().equals(id)){
				break;
			}
		}
		return p[i];
	}
	/**
	 * imports student objects from text file, creates them, and adds them to the person array
	 * @param file - file name as a String
	 */
	public void studLoad(String file){
		Scanner fileScan = null;
		File inputFile = new File(file + ".txt");
		try {
			fileScan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		//requires format (fName, lName, phone, stNum, stName, zip)
		while(fileScan.hasNextLine()){
			String[] split = fileScan.nextLine().split(",");
			
			Student s = new Student(split[0],split[1],split[2],new Address(split[3],split[4],split[5]));
			p[numOfItems++] = s;
		}
	}
	/**
	 * imports faculty objects from a text file, creates them, and adds them to the person array
	 * @param file - file name as a String
	 */
	public void facLoad(String file){
		Scanner fileScan = null;
		File inputFile = new File(file+ ".txt");
		try {
			fileScan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//requires format (fName, lName, phone, stNum, stName, zip, 
		//offNum, offSt, offZip, title, depart, pScale)
		while(fileScan.hasNextLine()){
			String[] split = fileScan.nextLine().split(",");
			
			Faculty f = new Faculty(split[0],split[1],split[2],new Address(split[3],split[4],split[5]),
					new Address(split[6],split[7],split[8]),split[9],split[10],Integer.parseInt(split[11]));
			p[numOfItems++] = f;
			
		}
	}
	/**
	 * returns the number of items
	 * @return numOfItems
	 */
	public int getNumOfItems() {
		return numOfItems;
	}
	/**
	 * returns the person array
	 * @return p
	 */
	public Person[] getP() {
		return p;
	}
	/**
	 * sets a new person array to a specified array
	 * @param p - person array
	 */
	public void setP(Person[] p) {
		this.p = p;
	}
	
	
}
