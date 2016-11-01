package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;
/**
 * @author Nicholas Pirrello
 * Efficient class to handle basic course arrays and allow methods to manipulate the items inside
 */
public class MasterCourseBag implements Serializable{
	private int numOfItems;
	private Course[] c;
	/**
	 * Takes a integer size for the CourseBag and creates a new array of CourseType
	 * @param maxSize - size of the new CourseType array
	 * sets numOfItems to 0 to indicate that 0 objects are currently stored
	 */
	public MasterCourseBag(int maxSize){
		c = new Course[maxSize];
		numOfItems = 0;
	}
	/**
	 * Adds a course object to the master course bag
	 * @param c - a course object
	 * increments up the number of objects in the bag
	 */
	public void addTo(Course c){
		this.c[numOfItems] = c;
		numOfItems++;
	}
	/**
	 * displays the contents of the bag
	 */
	public void display(){
		for(int i = 0;i < numOfItems;i++){
			System.out.print(c[i] + "\t");
		}
		System.out.println();
	}
	/**
	 * searches through the bag for a specified course and then shifts up the rest of the array and decrements the numOfItems by one
	 * @param cNum - reference to a course object
	 */
	public void remove(String cNum){
		for(int i = 0;i < numOfItems;i++){
			if(c[i].getcNum().equals(cNum)){
				Course temp = c[i];
				c[i] = c[i+1];
				for(int j = i+1;j < numOfItems-1;j++){
						c[j] = c[j+1];		
				}
				numOfItems--;
			}
		}
	}
	/**
	 * searches for a specified course, when found returns that course object 
	 * @param cNum - reference to the course object as a String
	 * @return c[i] - the Course found 
	 */
	public Course find(String cNum){
		int i = -1;
		for(i = 0;i < numOfItems;i++){
			if(c[i].getcNum().equals(cNum)){
				break;
			}
		}
		if(i == numOfItems){
			return null;
		}else{
			return c[i];
		}
	}
	/**
	 * searches the array for a specified course and returns true or false depending on the state of being found
	 * @param cNum - String reference to the course object
	 * @return found
	 */
	public boolean findBool(String cNum){
		boolean found = false;
		for(int i = 0;i < numOfItems;i++){
			if(c[i].getcNum().equals(cNum)){
				found = true;
			}
		}
		return found;
	}
	/**
	 * imports the courses and creates new objects based on a text file
	 */
	public void load(String fileName){
		File file = new File(fileName+".txt");
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(input.hasNext()){
			String str = input.nextLine();
			String[] data = str.split(",");
			Course c1 = new Course(data[0], data[1], data[2], data[3],Integer.parseInt(data[4]));
			c[numOfItems++] = c1;
		}
		input.close();
	}
	/**
	 * returns the number of items in the array
	 * @return numOfItems
	 */
	public int getNumOfItems() {
		return numOfItems;
	}
	/**
	 * Sets the number of items to a specified value
	 * @param numOfItems
	 */
	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}
	/**
	 * returns the course array
	 * @return
	 */
	public Course[] getC() {
		return c;
	}
	/**
	 * sets the course array to a new course array
	 * @param c - course array
	 */
	public void setC(Course[] c) {
		this.c = c;
	}
	
}
