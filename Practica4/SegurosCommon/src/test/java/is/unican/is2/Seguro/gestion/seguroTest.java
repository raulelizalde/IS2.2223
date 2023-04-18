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
		assertEquals(400, seguro1.precio());
		
		seguro2.datosSeguro(89, "123456780", LocalDate.now().minusDays(745), Cobertura.TERCEROSLUNAS);
		assertEquals(600, seguro2.precio());
		
		seguro3.datosSeguro(90, "123456781", LocalDate.now().minusDays(730), Cobertura.TODORIESGO);
		assertEquals(1050, seguro3.precio());
		
		seguro4.datosSeguro(91, "123456782", LocalDate.now().minusDays(729), Cobertura.TERCEROS);
		assertEquals(378, seguro4.precio());
		
		seguro5.datosSeguro(100, "123456783", LocalDate.now().minusDays(550), Cobertura.TERCEROSLUNAS);
		assertEquals(567, seguro5.precio());
		
		seguro6.datosSeguro(109, "123456784", LocalDate.now().minusDays(365), Cobertura.TODORIESGO);
		assertEquals(945, seguro6.precio());
		
		seguro7.datosSeguro(110, "123456785", LocalDate.now().minusDays(364), Cobertura.TERCEROS);
		assertEquals(336, seguro7.precio());
		
		seguro8.datosSeguro(111, "123456786", LocalDate.now().minusDays(200), Cobertura.TERCEROSLUNAS);
		assertEquals(576, seguro8.precio());
		
		seguro9.datosSeguro(120, "123456786", LocalDate.now().minusDays(0), Cobertura.TODORIESGO);
		assertEquals(960, seguro9.precio());
	}
	
	

}
