package is.unican.is2.Seguro.gestion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import is.unican.is2.SegurosCommon.Seguro;
import is.unican.is2.SegurosCommon.Cobertura;

class seguroTest {


	private Seguro seguro1 = new Seguro();
	private Seguro seguro2= new Seguro();
	private Seguro seguro3 = new Seguro();
	private Seguro seguro4 = new Seguro();
	private Seguro seguro5 = new Seguro();
	private Seguro seguro6 = new Seguro();
	private Seguro seguro7 = new Seguro();
	private Seguro seguro8 = new Seguro();
	private Seguro seguro9 = new Seguro();


	@Test
	public void testValido1() {
		//caso valido4
		seguro1.datosSeguro(70, "123456789", LocalDate.now().minusDays(745), Cobertura.TERCEROS);
		assertEquals(seguro1.precio(), 400);
	}
	
	@Test
	public void testValido2() {
		//caso valido
		seguro2.datosSeguro(89, "123456780", LocalDate.now().minusDays(745), Cobertura.TERCEROSLUNAS);
		assertEquals(seguro2.precio(), 600);
	}
	
	@Test
	public void testValido3() {
		//caso valido
		seguro3.datosSeguro(90, "123456781", LocalDate.now().minusDays(730), Cobertura.TODORIESGO);
		assertEquals(seguro3.precio(), 1050);
	}
	
	@Test
	public void testValido4() {
		//caso valido
		seguro4.datosSeguro(91, "123456782", LocalDate.now().minusDays(729), Cobertura.TERCEROS);
		assertEquals(seguro4.precio(), 378);
	}
	
	@Test
	public void testValido5() {
		//caso valido
		seguro5.datosSeguro(100, "123456783", LocalDate.now().minusDays(550), Cobertura.TERCEROSLUNAS);
		assertEquals(seguro5.precio(), 567);
	}
	
	@Test
	public void testValido6() {
		//caso valido
		seguro6.datosSeguro(109, "123456784", LocalDate.now().minusDays(365), Cobertura.TODORIESGO);
		assertEquals(seguro6.precio(), 945);
	}
	
	@Test
	public void testValido7() {
		//caso valido
		seguro7.datosSeguro(110, "123456785", LocalDate.now().minusDays(364), Cobertura.TERCEROS);
		assertEquals(seguro7.precio(), 336);
	}
	
	@Test
	public void testValido8() {
		//caso valido
		seguro8.datosSeguro(111, "123456786", LocalDate.now().minusDays(200), Cobertura.TERCEROSLUNAS);
		assertEquals(seguro8.precio(), 576);
	}
	
	@Test
	public void testValido9() {
		//caso valido
		seguro9.datosSeguro(120, "123456787", LocalDate.now().minusDays(0), Cobertura.TODORIESGO);
		assertEquals(seguro9.precio(), 960);
	}
	
	
	
	
		
	


}
