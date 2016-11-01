package p1;

import java.io.Serializable;
/**
 * @author Nicholas Pirrello
 * Efficient class to handle basic course type arrays and allow methods to manipulate
 */
public class CourseBag implements Serializable{
	CourseType[] cArray;
	int numOfC;
	/**
	 * Takes a integer size for the CourseBag and creates a new array of CourseType
	 * @param maxSize - size of the new CourseType array
	 * sets numOfC to 0 to indicate that 0 objects are currently stored
	 */
	public CourseBag(int maxSize){
		cArray = new CourseType[maxSize];
		numOfC = 0;
	}
	/**
	 * When called, the specified values are inputed into the bag as a newly created CourseType object and adds one to the counter
	 * @param courseId - course id for the newly created CourseType object
	 * @param type - number indicating 0, 1, 2 for (taken, currently taking, and need to take)
	 */
	public void add(String courseId, int type){
		CourseType c = new CourseType(courseId, type);
		cArray[numOfC++] = c;
	}
	/**
	 * Searches the CourseBag for a specified CourseType object and when found, shifts the entire array up a space and decreases the amount of 
	 * specified objects down by one
	 * @param courseId - courseId of the CourseType object
	 * @param type - type of the CourseType object
	 */
	public void delete(String courseId, int type){
		for(int i = 0;i < numOfC;i++){
			if(cArray[i].getCourseId().equals(courseId) && cArray[i].getType() == type){
				cArray[i] = cArray[i+1];
				for(int j = i+1;j < numOfC - 1;j++){
					cArray[j] = cArray[j+1];
				}
				numOfC--;
			}
		}
	}
	/**
	 * Returns the whole CourseType array
	 * @return cArray
	 */
	public CourseType[] getcArray() {
		return cArray;
	}
	/**
	 * Returns the number of objects currently in the CourseType array
	 * @return numOfC
	 */
	public int getNumOfC(){
		return numOfC;
	}
	/**
	 * Displays the contents of the CourseType array
	 */
	public void display(){
		for(int i = 0;i < numOfC;i++){
			System.out.print(cArray[i]);
		}
	}
	/**
	 * Sets a new CourseType object at a specified location in the array
	 * @param pos - position in the array
	 * @param courseId - course id for the CourseType object
	 * @param type - type for the CourseType object
	 */
	public void set(int pos, String courseId, int type){
		CourseType c = new CourseType(courseId,type);
		cArray[pos] = c;
	}
	/**
	 * Searches through the array for a specified CourseType and returns the object if found
	 * @param courseId - course id for the CourseType object
	 * @param type - type for the CourseType object
	 * @return CourseType object if found
	 */
	public CourseType search(String courseId, int type){
		int i = -1;
		for(i = 0;i < numOfC;i++){
			if(cArray[i].getCourseId() == courseId && cArray[i].getType() == type){
				break;
			}
		}
		if(i == numOfC){
			return null;
		} else {
			return cArray[i];
		}
	}

	
}
