package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import code.EvaluateurNiveau;
import code.ExceptionValeurHorsBorne;
import code.ExceptionValeurNonEntiere;

class EvaluateurNiveauTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testMauvaisFormatCours() {
		assertThrows( ExceptionValeurNonEntiere.class , 
				() -> { EvaluateurNiveau.evaluerNiveau("xxX" , "30"); } );
	}
	
	@Test
	void testMauvaisFormatExamen() {
		assertThrows( ExceptionValeurNonEntiere.class , 
				() -> { EvaluateurNiveau.evaluerNiveau("20" , "30.23"); } );
	}
	
	@Test
	void testValeurHorsBorneCours() {
		assertThrows( ExceptionValeurHorsBorne.class , 
				() -> { EvaluateurNiveau.evaluerNiveau("26" , "30"); } );
	}
	
	
	@Test
	void testValeurHorsBorneExamen() {
		assertThrows( ExceptionValeurHorsBorne.class , 
				() -> { EvaluateurNiveau.evaluerNiveau("20" , "-1"); } );
	}
	
	
	@ParameterizedTest(name = "test avec cours={0} et examen={1} attendu={2}")
	@CsvSource({"0,0,D","14,15,D","15,15,C","20,29,C","20,30,B","20,49,B","20,50,A", "25,75,A"})
	void testNiveau( String cours , String examen , String attendu ) throws ExceptionValeurNonEntiere, ExceptionValeurHorsBorne {
		String niveauObtenu = EvaluateurNiveau.evaluerNiveau( cours , examen );
		assertEquals(niveauObtenu , attendu  );
	}
	

}
