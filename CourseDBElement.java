/*
 * Class: CMSC204
 * Instructor: Professor Monshi
 * Description: (Give a brief description for each Class)
 * Due: 04/04/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Kaan Sen________
*/
public class CourseDBElement implements Comparable<CourseDBElement> {

	private String id;
	private int crn;
	private int credits;
	private String roomNum;
	private String instructor; 
	
	public CourseDBElement()
	{
		this.id = "";
		this.crn = 0;
		this.credits = 0;
		this.roomNum = "";
		this.instructor = "";
	}
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor)
	{
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	@Override
	public int compareTo(CourseDBElement element)
	{
		return (this.crn - element.crn);
	}

	public int getCRN() {
		return crn;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	@Override
	public int hashCode()
	{
		String str = Integer.toString(crn);
		return str.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(getClass() != o.getClass())
			return false;
		CourseDBElement other = (CourseDBElement) o;
		if(crn != other.crn)
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "\nCourse:" + id + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum; 
	}
}
