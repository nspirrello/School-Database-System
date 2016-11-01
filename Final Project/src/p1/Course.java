package p1;

import java.io.Serializable;
/**
 * @author Nicholas Pirrello
 * Class for Course objects which contain Course Title, Course Number, CRN, a textbook reference ISBN, and the number of credits
 */
public class Course implements Serializable{
	String cTitle;
	String cNum;
	String crn;
	String isbn;
	int numCredit;
	/**
	 * Default constructor for a Course object
	 */
	public Course(){};
	/**
	 * Constructor for a Course object with only the Course number specified
	 * @param cNum
	 */
	public Course(String cNum){
		this.cNum = cNum;
	}
	/**
	 * Overloaded constructor for a Course object
	 * @param cTitle - Course title taken as a String
	 * @param cNum - Course number taken as a String
	 * @param crn - crn (course registration number) taken as a String
	 * @param tb - reference to an ISBN number for a textbook taken as a String
	 * @param numCredit - Number of credits taken as a integer
	 */
	public Course(String cTitle, String cNum, String crn, String tb, int numCredit) {
		super();
		this.cTitle = cTitle;
		this.cNum = cNum;
		this.crn = crn;
		this.isbn = tb;
		this.numCredit = numCredit;
	}
	/**
	 * Returns the Course title
	 * @return course title as a String
	 */
	public String getcTitle() {
		return cTitle;
	}
	/**
	 * Sets the course title to a specified value taken as an String
	 * @param cTitle
	 */
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
	/**
	 * Returns the Course number
	 * @return course number as a String
	 */
	public String getcNum() {
		return cNum;
	}
	/**
	 * Sets the course number to a specified value taken as an String
	 * @param cNum
	 */
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	/**
	 * Returns the crn 
	 * @return crn as a String
	 */
	public String getCrn() {
		return crn;
	}
	/**
	 * Sets the crn to a specified value taken as an String
	 * @param numCredit
	 */
	public void setCrn(String crn) {
		this.crn = crn;
	}
	/**
	 * Returns the textbook reference
	 * @return isbn as a String
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * Sets the isbn to a specified value taken as an String
	 * @param isbn
	 */
	public void setTb(String tb) {
		this.isbn = tb;
	}
	/**
	 * Returns the number of credit
	 * @return number of credits as an integer
	 */
	public int getNumCredit() {
		return numCredit;
	}
	/**
	 * Sets the number of credits to a specified value taken as an integer
	 * @param numCredit
	 */
	public void setNumCredit(int numCredit) {
		this.numCredit = numCredit;
	}
	/**
	 * toString method for the Course objects, formats the information
	 */
	@Override
	public String toString() {
		return "Course [cTitle=" + cTitle + ", cNum=" + cNum + ", crn=" + crn
				+ ", tb=" + isbn + ", numCredit=" + numCredit + "]";
	}
	
	
	
	
}
