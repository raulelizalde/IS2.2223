package is.unican.is2.Seguro.gestion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import is.unican.is2.SegurosCommon.Seguro;
import is.unican.is2.SegurosCommon.Cobertura;

class seguroTest {


	private Seguro seguro1 = new Seguro(70, "123456789", LocalDate.now().minusDays(745), Cobertura.TERCEROS);
	private Seguro seguro2= new Seguro(89, "123456780", LocalDate.now().minusDays(745), Cobertura.TERCEROSLUNAS);
	private Seguro seguro3 = new Seguro(90, "123456781", LocalDate.now().minusDays(730), Cobertura.TODORIESGO);
	private Seguro seguro4 = new Seguro(91, "123456782", LocalDate.now().minusDays(729), Cobertura.TERCEROS);
	private Seguro seguro5 = new Seguro(100, "123456783", LocalDate.now().minusDays(550), Cobertura.TERCEROSLUNAS);
	private Seguro seguro6 = new Seguro(109, "123456784", LocalDate.now().minusDays(365), Cobertura.TODORIESGO);
	private Seguro seguro7 = new Seguro(110, "123456785", LocalDate.now().minusDays(364), Cobertura.TERCEROS);
	private Seguro seguro8 = new Seguro(111, "123456786", LocalDate.now().minusDays(200), Cobertura.TERCEROSLUNAS);
	private Seguro seguro9 = new Seguro(120, "123456787", LocalDate.now().minusDays(0), Cobertura.TODORIESGO);


	@Test
	public void testValido1() {
		//caso valido
		assertEquals(seguro1.precio(), 400);
	}
	
	@Test
	public void testValido2() {
		//caso valido
		assertEquals(seguro2.precio(), 600);
	}
	
	@Test
	public void testValido3() {
		//caso valido
		assertEquals(seguro3.precio(), 1050);
	}
	
	@Test
	public void testValido4() {
		//caso valido
		assertEquals(seguro4.precio(), 378);
	}
	
	@Test
	public void testValido5() {
		//caso valido
		assertEquals(seguro5.precio(), 567);
	}
	
	@Test
	public void testValido6() {
		//caso valido
		assertEquals(seguro6.precio(), 945);
	}
	
	@Test
	public void testValido7() {
		//caso valido
		assertEquals(seguro7.precio(), 336);
	}
	
	@Test
	public void testValido8() {
		//caso valido
		assertEquals(seguro8.precio(), 576);
	}
	
	@Test
	public void testValido9() {
		//caso valido
		assertEquals(seguro9.precio(), 960);
	}
	
	
	
	
		
	


}
