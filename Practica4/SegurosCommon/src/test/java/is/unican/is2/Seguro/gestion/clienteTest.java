package is.unican.is2.Seguro.gestion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import is.unican.is2.SegurosCommon.Cliente;
import is.unican.is2.SegurosCommon.Cobertura;
import is.unican.is2.SegurosCommon.Seguro;

class clienteTest {
	
	//creamos seguros
	private Seguro seguro1 = new Seguro();
	private Seguro seguro2= new Seguro();
	//creamos clientes
	private Cliente cliente1 = new Cliente();
	private Cliente cliente2 = new Cliente();
	private Cliente cliente3 = new Cliente();
	
	@Test
	public void testValido1() {
		seguro1.datosSeguro(70, "123456789", LocalDate.now().minusDays(745), Cobertura.TERCEROS);
		cliente1.creaDatos("paolo", "12345678D", true);
		cliente1.añadirSeguro(seguro1);
		//caso valido
		assertEquals(cliente1.totalSeguros(), 300);
		
		seguro2.datosSeguro(89, "123456780", LocalDate.now().minusDays(745), Cobertura.TERCEROSLUNAS);
		cliente2.creaDatos("moni", "12345678F", false);
		cliente2.añadirSeguro(seguro2);
		//caso valido
		assertEquals(cliente2.totalSeguros(), 600);
		
		cliente3.creaDatos("alba", "12345678G", true);
		seguro2.datosSeguro(89, "123456780", LocalDate.now().minusDays(745), Cobertura.TERCEROSLUNAS);
		seguro1.datosSeguro(70, "123456789", LocalDate.now().minusDays(745), Cobertura.TERCEROS);

		cliente3.añadirSeguro(seguro2);
		cliente3.añadirSeguro(seguro1);
		//caso valido
		assertEquals(cliente3.totalSeguros(), 750);
	}
	
	/*
	@Test
	public void testValido11() {
		seguro2.datosSeguro(89, "123456780", LocalDate.now().minusDays(745), Cobertura.TERCEROSLUNAS);
		cliente2.creaDatos("moni", "12345678F", false);
		cliente2.añadirSeguro(seguro2);
		//caso valido
		assertEquals(cliente2.totalSeguros(), 600);
	}
	
	@Test
	public void testValido12() {
		cliente3.creaDatos("alba", "12345678G", true);
		seguro2.datosSeguro(89, "123456780", LocalDate.now().minusDays(745), Cobertura.TERCEROSLUNAS);
		seguro1.datosSeguro(70, "123456789", LocalDate.now().minusDays(745), Cobertura.TERCEROS);

		cliente3.añadirSeguro(seguro2);
		cliente3.añadirSeguro(seguro1);
		//caso valido
		assertEquals(cliente3.totalSeguros(), 750);
	}
	*/
	
	@Test
	public void testNoValido1() {
		java.util.LinkedList<Seguro> seguros = null;
		cliente3.creaDatos("alba", "12345678G", true);
		cliente3.setSeguros(seguros);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
		    cliente3.getSeguros().remove(1);
		});
	}


	
}
