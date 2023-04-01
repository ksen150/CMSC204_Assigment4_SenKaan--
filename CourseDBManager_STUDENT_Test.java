import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {

	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("ENEE207",30504,4,"SC420","Lan Xiang");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("ENEE203",30504,4,"SC450","Jane Doe");
		dataMgr.add("ENEE203",30503,4,"SC450","Kurt Weller");
		dataMgr.add("ENEE204",30559,4,"SC450","Jon Jones");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:ENEE204 CRN:30559 Credits:4 Instructor:Jon Jones Room:SC450");
	 	assertEquals(list.get(1),"\nCourse:ENEE203 CRN:30503 Credits:4 Instructor:Kurt Weller Room:SC450");
		assertEquals(list.get(2),"\nCourse:ENEE203 CRN:30504 Credits:4 Instructor:Jane Doe Room:SC450");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC204 30503 4 SC450 Jill B. Who-Dunit");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC203",dataMgr.get(30504).getID());
			assertEquals("CMSC204",dataMgr.get(30503).getID());
			assertEquals("SC450",dataMgr.get(30503).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
