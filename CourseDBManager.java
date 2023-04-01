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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure CDS;
	public CourseDBManager()
	{
		CDS = new CourseDBStructure(100);
	}
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
			CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
			CDS.add(newElement);
	}
	
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	public CourseDBElement get(int crn)
	{
		try {
				return CDS.get(crn);
		}	catch(IOException e)
		{
			e.getMessage();
		}
		return null;
	}
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException
	{
		try {
				Scanner fileData = new Scanner(input);
				while(fileData.hasNextLine())
				{
				
					String id = fileData.next();
					int crn = fileData.nextInt();
					int credits = fileData.nextInt();
					String roomNum = fileData.next();
					String instructor = fileData.nextLine();
					CourseDBElement  element = new CourseDBElement(id, crn, credits, roomNum, instructor);
					CDS.add(element);
//					add(id, crn, credits, roomNum, instructor);
				}
				fileData.close();
			}
		catch(FileNotFoundException e)
		{
			throw new FileNotFoundException();
		}
	}
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	public ArrayList<String> showAll()
	{
		return CDS.showAll();
	}
	
	
	
}
