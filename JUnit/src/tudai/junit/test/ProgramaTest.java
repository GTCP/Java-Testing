package tudai.junit.test;
import static org.junit.Assert.*;

import java.util.Date;


//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.jupiter.api.*;
//import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import tudai.junit.java.Programa;
import tudai.junit.java.Programacion;
import tudai.junit.java.ProgramacionNoEncontradaExcepcion;
import tudai.junit.java.Tarea;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


//extends TestCase
public class ProgramaTest {
	
	private Programa 		_defaultPrograma;
	private Programacion 	_defaultProgramacion;
	private Tarea			_defaultTarea;
	
	
	/**
	 * Metodo setup para propiedades de clase
	 * @throws Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("TestPrograma -> BeforeClass ");
	}
	/**
	 * Metodo tearDown para propiedades de clase
	 * @throws Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TestPrograma -> TearDown ");
	}

	/**
	 * Metodo setup para instancias de test
	 * @throws Exception
	 */

@BeforeEach
	public void setUp() throws Exception {
		Date d1 = new Date(2015,12,24,22,00);
		Date d2 = new Date(2015,12,25,06,00);
		System.out.println("Setup");
		
		_defaultTarea 		 = new Tarea("Festejar Navidad");
		_defaultProgramacion = new Programacion(d1,d2,_defaultTarea);
		_defaultPrograma	 = new Programa();
	}
	
	
	/**
	 * Metodo tearDown para instancias de test
	 * @throws Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("TestPrograma -> TearDown");
	}
	
	@Test
	public void testPrograma() {
		System.out.println("TestPrograma -> testPrograma");
	}
	/**
	 * Prueba el metodo de cantidad de ocurrencias
	 * La prueba se realiza vaciando las programaciones existentes y luego agrega tres
	 * programaciones. La cantidad de programaciones debe ser exactamente 3
	 */
	   @RepeatedTest(5)  
	    @DisplayName("Test de contar la cantidad de ocurrencias")
		public void testGetCantOcurrencias() {
	System.out.println("test GetCantOcurrencias");
			
			_defaultPrograma.eliminarProgramaciones();
			assertEquals(0, _defaultPrograma.getCantProgramaciones());
			
			_defaultPrograma.addProgramacion(_defaultProgramacion);
			Date d1 = new Date(2016,1,23,00,00);
			Date d2 = new Date(2016,1,23,23,59);
			Date d3 = new Date(2016,1,06,00,00);
			Date d4 = new Date(2016,1,06,06,00);
			
			Tarea t1	= new Tarea("Festejar Cumpleanios");
			Tarea t2	= new Tarea("Cortar pasto para camellos");
			
			Programacion cumpleanios	= new Programacion(d1, d2,t1);
			Programacion reyes			= new Programacion(d3, d4,t2);
			
			_defaultPrograma.addProgramacion(cumpleanios);
			_defaultPrograma.addProgramacion(reyes);
		
			assertEquals(3, _defaultPrograma.getCantProgramaciones(),"la cantidad debe ser 3");
		}
	/**
	 * Prueba el metodo getCantTareasEntre
	 * La prueba se realiza insertando tres tareas de las cuales exactamente 2
	 * cumplen los requisitos
	 */

	@Test
	public void testGetCantTareasEntre() {
		System.out.println("TestPrograma -> testGetCantTareasEntre");
	}

	/**
	 * Prueba el metodo addPrrogramacion
	 * La prueba se realiza insertando una programacion nueva. El resultado es un
	 * programa con una nueva programacion
	 */
	@Test
	public void testAddProgramacion() {
		System.out.println("testAddProgramacion");
		int programacionesHastaElMomento = _defaultPrograma.getCantProgramaciones();
		_defaultPrograma.addProgramacion(_defaultProgramacion);
		assertEquals(programacionesHastaElMomento+1,_defaultPrograma.getCantProgramaciones());
	}

	/**
	 * Prueba el metodo removeProgramacion
	 * La prueba se realiza insertando una programacion, 
	 * luego se calculan cuantas programaciones se tienen y posteriormente
	 * se elimina. La cantidad de programaciones debe haber disminuido
	 * @throws ProgrmacionNoEncontradaException 
	 */
	@Test
	public void testRemoveProgramacion() throws ProgramacionNoEncontradaExcepcion {
		System.out.println("testRemoveProgramacion");
		Date d1 = new Date(2015,12,31,22,00);
		Date d2 = new Date(2016,1,1,06,00);
		Tarea t	= new Tarea("Recibir nuevo");
		
		Programacion otraProgramacion = new Programacion(d2, d2,t);
		_defaultPrograma.addProgramacion(otraProgramacion);
		int programacionesHastaElMomento = _defaultPrograma.getCantProgramaciones();
		
			_defaultPrograma.removeProgramacion(otraProgramacion);
			assertEquals(programacionesHastaElMomento-1,_defaultPrograma.getCantProgramaciones());
	
		
	}
	
	@Test
	public void testEliminarProgramaciones() {
		System.out.println("testEliminarProgramaciones");
		_defaultPrograma.eliminarProgramaciones();
		assertEquals(0,_defaultPrograma.getCantProgramaciones());
		
	}

	@Test
	public void testProgramaVacio() {
		System.out.println("testProgramaVacio");
		_defaultPrograma.eliminarProgramaciones();
		assertEquals(true,_defaultPrograma.programaVacio());
	}
	
	@Test
	public void testIniciar() throws InterruptedException {
		
		System.out.println("TestPrograma -> Test Iniciar");
		
	}
	@Test
	public void testExpectedProgramacionNoEncontradaExcepcion() {

		Assertions.assertThrows(ProgramacionNoEncontradaExcepcion.class ,()->{
			_defaultPrograma.eliminarProgramaciones();
			_defaultPrograma.removeProgramacion(_defaultProgramacion);
		});

	}	
}