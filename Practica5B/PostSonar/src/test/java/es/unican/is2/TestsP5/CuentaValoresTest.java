package es.unican.is2.TestsP5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import is.unican.is2.ClasesP5.CuentaValores;
import is.unican.is2.ClasesP5.Valor;

public class CuentaValoresTest {
	
	private CuentaValores sut;
	
	@BeforeEach
	public void inicializa() {
		sut = new CuentaValores("794311");
	}
	
	@Test
	public void testConstructor() {
		 assertEquals("794311", sut.getNumCuenta());
		 assertEquals(0, sut.getValores().size());
	}
	
	@Test
	public void testAnhadeValor() {
		// CASOS VALIDOS
		Valor v = new Valor("Telepizza", 25, 1.05);
	    assertTrue(sut.anhadeValor(v));
	    assertEquals(1, sut.getValores().size());
	    assertEquals(v, sut.getValores().get(0));

	    v = new Valor("BancoSantander", 100, 200);
	    assertTrue(sut.anhadeValor(v));
	    assertEquals(2, sut.getValores().size());
	    assertEquals(v, sut.getValores().get(1));
		
		// CASOS NO VALIDOS
		assertFalse(sut.anhadeValor(new Valor("Telepizza", 10, 2.5)));
		
	}
}
