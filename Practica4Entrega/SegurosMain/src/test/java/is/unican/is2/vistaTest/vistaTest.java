package is.unican.is2.vistaTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;

import is.unican.is2.SegurosBusiness.GestionSeguros;
import is.unican.is2.SegurosCommon.IClientesDAO;
import is.unican.is2.SegurosCommon.ISegurosDAO;
import is.unican.is2.SegurosDAO.ClientesDAO;
import is.unican.is2.SegurosDAO.SegurosDAO;
import is.unican.is2.SegurosGUI.VistaAgente;

@SuppressWarnings("serial")
class vistaTest extends JFrame{

	private FrameFixture demo;

	@BeforeEach
	public void setUp() {
		IClientesDAO daoContribuyentes = (IClientesDAO) new ClientesDAO();
		ISegurosDAO daoVehiculos = new SegurosDAO();
		GestionSeguros negocio = new GestionSeguros(daoContribuyentes, daoVehiculos);
		VistaAgente gui = new VistaAgente(negocio, negocio, negocio);
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}
	
	@AfterEach
	public void tearDown() {
		demo.cleanUp();
	}
	
	
	@Test
	public void testValidoVista1() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnBuscar").requireText("Buscar");
		
		//  Prueba de saludo con nombre
		// Escribimos un nombre
		demo.textBox("txtDNICliente").enterText("12345678V");
		// Pulsamos el boton
		demo.button("btnBuscar").click();		
		// Comprobamos la salida
		demo.textBox("txtNombreCliente").requireText("Lucia Rodriguez");
		
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNoValidoVista1() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnBuscar").requireText("Buscar");
		
		//  Prueba de saludo con nombre
		// Escribimos un nombre
		demo.textBox("txtDNICliente").enterText("abc43");
		// Pulsamos el boton
		demo.button("btnBuscar").click();		
		// Comprobamos la salida
		demo.textBox("txtNombreCliente").requireText("");
		
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

