package p1;

import java.io.Serializable;
/** 
 * @author Nicholas Pirrello
 * The super class for both Student and Faculty. Uses first name, last name, a static id, a phone number and an address object
 */
public class Person implements Serializable{
	private String fName;
	private String lName;
	private int temp;
	private static int count = 0;
	private String id;
	private String phone;
	private Address ad;
	/**
	 * default constructor
	 */
	public Person(){};
	/**
	 * Overloaded constructor
	 * @param fName - first name as a String
	 * @param lName - last name as a String
	 * @param phone - phone number as a String
	 * @param ad - Address as an Address object
	 * Id number is static and is never repeated regardless of the object existing or not, increases by one everytime a new person is made
	 */
	public Person(String fName, String lName, String phone, Address ad){
		super();
		this.fName = fName;
		this.lName = lName;
		this.temp = count+=1;
		this.id = Integer.toString(temp);
		this.phone = phone;
		this.ad = ad;
	}
	/**
	 * returns address
	 * @return ad
	 */
	public Address getAd() {
		return ad;
	}
	/** 
	 * Sets a new Address to a specified address object
	 * @param ad - address object
	 */
	public void setAd(Address ad) {
		this.ad = ad;
	}
	/**
	 * returns first name
	 * @return fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * sets a new first to a specified value
	 * @param fName - first name as a String
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/** 
	 * returns last name
	 * @return lName
	 */
	public String getlName() {
		return lName;
	}
	/** 
	 * Sets a new last name to a specified value
	 * @param lName - last name as a String
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * returns id number
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * returns phone number
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Sets a new phone number to a specified value
	 * @param phone - phone number as a String
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * toString for the Person class. Handles the information formatting.
	 */
	@Override
	public String toString() {
		return fName + " " + lName + " " + id + " " + phone + " " + ad;
	}

	
	
}
