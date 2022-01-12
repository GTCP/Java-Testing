package tudai.junit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ProgramacionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Programacion -> setupBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	System.out.println("Programacion -> tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
	System.out.println("Programacion -> Programacion");
	}

	@After
	public void tearDown() throws Exception {
	System.out.println("Programacion -> TearDownProgramacion");
	}
	/**
	 *  
	 */
	@Test
	public void testProgramacion() {
	System.out.println("Programacion -> TestProgramacion");
	}

	@Test
	public void testGetTask() {
		System.out.println("Programacion -> testGetTask");
	}

	@Test
	public void testGetInicio() {
		System.out.println("Programacion -> testGetInicio");
	}

	@Test
	public void testSetInicio() {
		System.out.println("Programacion -> SetInicio");
	}

	@Test
	public void testGetFin() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetFin() {
		//fail("Not yet implemented");
	}

}
