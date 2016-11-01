package p1;

import java.io.Serializable;
/**
 * @author Nicholas Pirrello
 * This class provides Address objects to the Person, Student and Faculty classes
 * Each address object has a Street number, a Street name, and a Zip code
 */
public class Address implements Serializable{
	private String stNum;
	private String add;
	private String zip;
	
	/**
	 * Default constructor for an Address object
	 */
	public Address(){};
	/**
	 * Overloaded Constructor for an Address Object
	 * @param stNum - Street number taken as a String
	 * @param add - Street name taken as a String
	 * @param zip - Zip code taken as a String
	 */
	public Address(String stNum, String add, String zip) {
		super();
		this.stNum = stNum;
		this.add = add;
		this.zip = zip;
	}
	/**
	 * Returns the Street Number
	 * @return street number as a String
	 */
	public String getStNum() {
		return stNum;
	}
	/**
	 * Sets the Street Number to the specified value for an Address object
	 * @param stNum - a Street Number taken as a String
	 */
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	/**
	 * Returns the Zip code
	 * @return zip code as a String
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * Sets the Zip code to a specified value for an Address object
	 * @param zip - a Zip code taken as a String
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * Returns the Street Name 
	 * @return Street name as a String
	 */
	public String getAdd() {
		return add;
	}
	/**
	 * Sets the Street name to a specified value for an Address object
	 * @param add - a Street name taken as a String
	 */
	public void setAdd(String add) {
		this.add = add;
	}
	/**
	 * toString method for the Address objects, formats the information
	 */
	@Override
	public String toString() {
		return stNum + " " + add + " " +zip;
	}
}
