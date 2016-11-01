package p1;

import java.io.Serializable;
/**
 * @author Nicholas Pirrello
 * A class based around Faculty. Faculty is made up of a office address, a title, a department, a pay scale, and the inherited methods from the Person class
 */
public class Faculty extends Person implements Serializable{
	Address officeAd;
	String title;
	String depart;
	int pScale;
	/**
	 * Default constructor for a Faculty object
	 */
	public Faculty(){};
	/**
	 * Overloaded constructor for the Faculty class
	 * @param fName - first name as a String
	 * @param lName - last name as a String
	 * @param phone - phone number as a String
	 * @param ad - home address as an Address object
	 * @param officeAd - office address as an Address object
	 * @param title - title as a String
	 * @param depart - department as a String
	 * @param pScale - pay scale as an integer
	 */
	public Faculty(String fName, String lName, String phone, Address ad, Address officeAd, String title, String depart, int pScale) {
		super(fName, lName, phone, ad);
		this.officeAd = officeAd;
		this.title = title;
		this.depart = depart;
		this.pScale = pScale;
	}
	/**
	 * returns office address
	 * @return officeAd
	 */
	public Address getOfficeAd() {
		return officeAd;
	}
	/**
	 * sets a new office address from a specified value
	 * @param officeAd - officeAd as a String
	 */
	public void setOfficeAd(Address officeAd) {
		this.officeAd = officeAd;
	}
	/**
	 * returns title 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * sets a new title from a specified value
	 * @param title - title as a String
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * returns department 
	 * @return depart
	 */
	public String getDepart() {
		return depart;
	}
	/**
	 * Sets a new department from a specified value
	 * @param depart - department as a String
	 */
	public void setDepart(String depart) {
		this.depart = depart;
	}
	/**
	 * returns pay scale
	 * @return pScale
	 */
	public int getPScale() {
		return pScale;
	}
	/**
	 * Sets a new pay scale from a specified value
	 * @param pScale - pay scale as an integer
	 */
	public void setPScale(int pScale) {
		this.pScale = pScale;
	}
	/**
	 * toString for the Faculty object. Handles information formatting
	 */
	@Override
	public String toString() {
		return getfName() + " " + getlName() + " " + getAd() + " " + officeAd + " " + title + " " + depart + " " + pScale ;
	}
	
	
	
	
	
	
	
}
