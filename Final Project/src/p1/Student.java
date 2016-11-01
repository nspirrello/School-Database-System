package p1;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Person implements Serializable{
	private double gpa;
	String major;
	private CourseBag courseBag = new CourseBag(30);
	private int numCreds;
	
	public Student(){};
	public Student(String fName, String lName, String phone, Address ad){
		super(fName,lName,phone,ad);
	}
	public Student(String fName, String lName, String phone, Address ad,String major){
		super(fName,lName,phone,ad);
		this.major = major;
	}
	
	public Student(String fName, String lName,String phone, Address ad, double gpa, String major, int numCreds) {
		super(fName, lName, phone, ad);
		this.gpa = gpa;
		this.major = major;
		this.numCreds = numCreds;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getNumCreds() {
		return numCreds;
	}
	public void setNumCreds(int numCreds) {
		this.numCreds = numCreds;
	}
	public CourseBag getCBag(){
		return courseBag;
	}
	public void addCourses(String courseId, int type){
		courseBag.add(courseId, type);
	}
	public void set(String courseId, int type, int pos){
		courseBag.set(pos,courseId,type);
	}
	@Override
	public String toString() {
		return getfName() + " " +getlName() + " " + getPhone() + " " + getAd() + " " + " " + major;
	}
	
	
	
	
}
