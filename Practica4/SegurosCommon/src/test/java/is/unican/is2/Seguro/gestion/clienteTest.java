package is.unican.is2.Seguro.gestion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import is.unican.is2.SegurosCommon.Cliente;
import is.unican.is2.SegurosCommon.Cobertura;
import is.unican.is2.SegurosCommon.Seguro;

class clienteTest {
	
	//creamos seguros
	private Seguro seguro1 = new Seguro(70, "123456789", LocalDate.now().minusDays(745), Cobertura.TERCEROS);
	private Seguro seguro2= new Seguro(89, "123456780", LocalDate.now().minusDays(745), Cobertura.TERCEROSLUNAS);
	//creamos clientes
	private Cliente cliente1= new Cliente("paolo", "12345678D", true);
	private Cliente cliente2= new Cliente("moni", "12345678F", false);
	private Cliente cliente3= new Cliente("alba", "12345678G", true);
	
	@Test
	public void testValido10() {
		cliente1.añadirSeguro(seguro1);
		//caso valido
		assertEquals(cliente1.totalSeguros(), 300);
	}
	
	@Test
	public void testValido11() {
		cliente2.añadirSeguro(seguro2);
		//caso valido
		assertEquals(cliente2.totalSeguros(), 600);
	}
	
	@Test
	public void testValido12() {
		cliente3.añadirSeguro(seguro2);
		cliente3.añadirSeguro(seguro1);
		//caso valido
		assertEquals(cliente3.totalSeguros(), 750);
	}


	
}
