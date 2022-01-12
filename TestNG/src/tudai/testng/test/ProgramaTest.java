package tudai.testng.test;
import org.testng.annotations.Test;

import tudai.testng.src.Tarea;
import tudai.testng.src.Usuario;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ProgramaTest {
  @Test(dataProvider = "dp")
  public void fTestProvider(Integer n, String s) {
	  System.out.println("f("+s+")");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod()");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod()");
  }


  @DataProvider
  public Object[][] dp() {
	  System.out.println("dp()");
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass()");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest()");
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest()");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite()");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite()");
  }


  @Test
  public void addProgramacion() {
	  System.out.println("addProgramacion");
  }

  @Test
  public void eliminarProgramaciones() {
	  System.out.println("EliminarProgramaciones");
  }

  @Test
  public void getCantOcurrencias() {
	  System.out.println("getCantOcurrencias");
  } 

  @Test
  public void getCantProgramaciones() {
	// fail();
	   System.out.println("getCantProgramaciones()");
  }

  @Test
  public void getCantTareasEntre() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void programaVacio() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void removeProgramacion() {
  	System.out.println("Remove Programacion");
    throw new RuntimeException("Test not implemented");
  }

/*****************HASTA ACA ********************/
  @DataProvider (name = "generador-usr")
  public Usuario[] dpUsers() {
	  System.out.println("Generando Usuarios");
	  Usuario ret []= new Usuario[7];
	  	
	   ret [0] =  new Usuario("Juan","1979-01-01",42,true);
	   ret [1] =  new Usuario("Pedro","1980-02-01",41,true);
	   ret [2] =  new Usuario("Maria","1981-03-01",47,true);
	   ret [3] = new Usuario("Cecilia","1983-04-01",38,true);
	   ret [4] =  new Usuario("Carlos","1985-04-01",36,true);
	   ret [5]  = new Usuario("Jose","1987-04-01",34,true);
	   ret [6] =   new Usuario("Quique", "23-01-1980",41, true );
	  return ret;
          
  }
  
    @Test(dataProvider = "generador-usr",invocationCount =5)
    
  public void testUsr(Usuario u) {
	  System.out.println("f("+u.getNombre()+")");
  }
    
	  @Test
@Parameters({ "prog-count" })
  public void addMuchasProgramaciones(@Optional("10")int count) {
    for(int i=0;i<count;i++){System.out.println("Se crearan: i" + i);}
}
	  
	  @DataProvider (name="gen-rand")
	  public Iterator<Object[]> getRandTask(){
		  final Random r = new Random(101);
		  ArrayList<Object[]> dp = new ArrayList<Object[]>();
		  int instCount=r.nextInt(100);
		for(int i=0;i<instCount;i++)
			  dp.add(new Object[] {new Tarea("Tarea"+i)});
		  return dp.iterator();
	  }
	  
	   @Test(dataProvider = "gen-rand")
	    
	   public void testTareeas(Object o) {
	 	  System.out.println("f("+o+")");
	   } 
	  /*************HASTA ACA***************/

	  /************** PASO 8 *************/
//	  /************* Agrupamiento *********/
//	   @Test (dataProvider="gen-rand", groups ={"inicializacion"})
//	  public void createTasks(Object a[]){
//		  genericTask = (Tarea)a[0];
//	  }
//	   
}