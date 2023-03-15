package is.unican.is2.SegurosBusiness;

import is.unican.is2.SegurosCommon.Cliente;
import is.unican.is2.SegurosCommon.IClientesDAO;
import is.unican.is2.SegurosCommon.ISegurosDAO;
import is.unican.is2.SegurosCommon.Seguro;

public class GestionSeguros {
	IClientesDAO daoContribuyentes;
	ISegurosDAO daoVehiculos;
	
	public GestionSeguros(IClientesDAO daoContribuyentes, ISegurosDAO daoVehiculos) {
		// TODO Auto-generated constructor stub
		this.daoContribuyentes = daoContribuyentes;
		this.daoVehiculos = daoVehiculos;
		
	}
	
	public Cliente nuevoCliente(Cliente c) {
		return c;
		
	}
	
	public Cliente eliminaCliente(String dni) {
		Cliente c = null;
		return c;
	}
	
	public Seguro nuevoSeguro(Seguro s, String dni) {
		return s;
	}
	
	public Seguro bajaSeguro(String matricula, String dni) {
		Seguro s = null;
		return s;
	}

	public Cliente cliente(String dni) {
		Cliente c = null;
		return c;
	}
	
	public Seguro seguro(String matricula) {
		Seguro s = null;
		return s;
	}
	
	
}
