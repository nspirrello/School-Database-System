package p1;

import java.io.Serializable;
/**
 * @author Nicholas Pirrello
 * A Class used to create textbook objects containing title, author, publisher, price, isbn, and year published
 */
public class Textbook implements Serializable{
	String bookTitle;
	String author;
	String publisher;
	double bookPrice;
	String isbn;
	String yearPub;
	/**
	 * Default constructor
	 */
	public Textbook(){};
	/**
	 * Overloaded constructor
	 * @param bookTitle - title as String
	 * @param author - author as String
	 * @param publisher - publisher as String
	 * @param bookPrice - price as double
	 * @param isbn - isbn as String
	 * @param yearPub - year published as String
	 */
	public Textbook(String bookTitle, String author, String publisher, double bookPrice, String isbn, String yearPub) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.bookPrice = bookPrice;
		this.isbn = isbn;
		this.yearPub = yearPub;
	}
	/**
	 * returns book title
	 * @return bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}
	/**
	 * Sets new book title to a specified value
	 * @param bookTitle - title as String
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	/**
	 * returns author
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * Sets author to a specified value
	 * @param author - author as String
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * returns publisher
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * Sets a new publisher to a specified value
	 * @param publisher - publisher as a String
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * returns book price
	 * @return bookPrice
	 */
	public double getBookPrice() {
		return bookPrice;
	}
	/**
	 * Sets a new book price to a specified value
	 * @param bookPrice - book price as String
	 */
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	/**
	 * returns isbn
	 * @return isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * Sets a new isbn to a specified value
	 * @param isbn - isbn as a String
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * returns the year published
	 * @return yearPub
	 */
	public String getYearPub() {
		return yearPub;
	}
	/** 
	 * Sets a new year published to a specified value
	 * @param yearPub - year published as String
	 */
	public void setYearPub(String yearPub) {
		this.yearPub = yearPub;
	}
	/** 
	 * toString of the Textbook class. Handles information formatting.
	 */
	@Override
	public String toString() {
		return bookTitle + " " + author
				+ " " + publisher + " " + bookPrice
				+ " " + isbn + " " + yearPub;
	}
	
	
}
