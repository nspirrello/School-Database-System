package p1;

import java.io.Serializable;
/**
 * @author Nicholas Pirrello
 * A type of course which specifies three states of completion. Taken, Currently Taking, and Need to take
 */
public class CourseType implements Serializable{
	String courseId;
	int type;
	/**
	 * Overloaded constructor for the CourseType object
	 * @param courseId - Course id taken as a String
	 * @param type - type (state of completion) taken as an integer
	 */
	CourseType(String courseId, int type){
		this.courseId = courseId;
		this.type = type;
	}
	/**
	 * Returns the course id as a String
	 * @return courseId
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * Sets a new course id
	 * @param courseId - Course id of a CourseType object taken as a String
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * Returns the type of a CourseType object
	 * @return type
	 */
	public int getType() {
		return type;
	}
	/**
	 * Sets a new type
	 * @param type - type for a CourseType object taken as an integer
	 */
	public void setType(int type) {
		this.type = type;
	}
	/** 
	 * toString method for the CourseType object. Manages information formatting
	 */
	@Override
	public String toString() {
		return "[courseId=" + courseId + ", type=" + type + "]";
	}
	
}
