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
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	private int size;
	private int hashSize = 0;
	static LinkedList<CourseDBElement> hashTable[];
	private ArrayList<CourseDBElement> A = new ArrayList();
	private CourseDBStructure CDS;
	

	
	public CourseDBStructure(int n)
	{
		double loadFactor = 1.5;
		int capacity = (int) Math.ceil(n/loadFactor);
		size = fourKPlus3(n);
		hashTable = new LinkedList[size];	
	}
	
	public CourseDBStructure(String testing, int size)
	{
		this.size = size;
		hashTable = new LinkedList[size];
	}
	
	public int fourKPlus3(int n)
	{
		boolean fkp3 = false;
		boolean aPrime = false;
		int prime, highDivisor, d;
		
		prime = (int)(n/1.5);
		if(prime % 2 == 0)
		{
			prime = prime + 1; 
		}
		
		while(fkp3==false)
		{
			while(aPrime == false)
			{
				highDivisor = (int)(Math.sqrt(prime) + 0.5);
				for(d = highDivisor; d>1; d--)
				{
					if(prime%d==0)
						break;
				}
				if( d!= 1)
					prime = prime + 2;
				else
					aPrime = true;
			}
			if((prime - 3) % 4 == 0)
				fkp3 = true;
			else
			{
				prime = prime + 2;
				aPrime = false;
			}
		}
		return prime;
	}

	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/

	public void add(CourseDBElement element)
	{
		int index = element.hashCode() % size;
		
		boolean flag = false;
		if(hashTable[index] == null)
		{
			hashTable[index] = new LinkedList<CourseDBElement>();
		}
		else
		{
			for(int i=0; i<hashTable[index].size(); i++)
			{
				CourseDBElement current = hashTable[index].get(i);
				if(current.compareTo(element) == 0)
				{
					A.set(i, element);
					hashTable[index].set(i, element);
					flag = true;
					break;
				}
				
			}
		}
		if(flag == false)
		{
			A.add(element);
			hashTable[index].add(element);
			hashSize++;
		}
	}
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */

	
	public CourseDBElement get(int crn) throws IOException
	{
		String str = Integer.toString(crn);
		int index = str.hashCode() % size;
		if(hashTable[index] == null)
		{
			throw new IOException();
		}
		else
		{
		for(int i = 0; i < size; i++)
		{
			CourseDBElement temp = hashTable[index].get(i);
			if(temp.getCRN() == crn)
			{
				return temp;				
			}
		}
			return null;
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
		ArrayList<String> list = new ArrayList<String>();
		for(int i=A.size()-1; i>= 0; i--)
		{
			list.add(A.get(i).toString());
			
		}
		return list;
	}
	
	
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	public int getTableSize()
	{
		return size;
	}
}

