package is.unican.is2.SegurosBusiness;

import is.unican.is2.SegurosCommon.Cliente;
import is.unican.is2.SegurosCommon.IClientesDAO;
import is.unican.is2.SegurosCommon.IGestionClientes;
import is.unican.is2.SegurosCommon.IGestionSeguros;
import is.unican.is2.SegurosCommon.IInfoSeguros;
import is.unican.is2.SegurosCommon.ISegurosDAO;
import is.unican.is2.SegurosCommon.OperacionNoValida;
import is.unican.is2.SegurosCommon.Seguro;

public class GestionSeguros implements IGestionClientes, IGestionSeguros, IInfoSeguros{
	IClientesDAO daoContribuyentes;
	ISegurosDAO daoVehiculos;
	
	public GestionSeguros(IClientesDAO daoContribuyentes, ISegurosDAO daoVehiculos) {
		this.daoContribuyentes = daoContribuyentes;
		this.daoVehiculos = daoVehiculos;
		
	}

	public Cliente cliente(String dni) {
		return daoContribuyentes.cliente(dni);
	}

	public Seguro seguro(String matricula) {
		return daoVehiculos.seguro(matricula);
	}

	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida {
		daoVehiculos.creaSeguro(s);
		return s;
	}

	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida {
		daoVehiculos.eliminaSeguro(matricula);
		return daoVehiculos.seguro(matricula);
	}

	public Cliente nuevoCliente(Cliente c) {
		daoContribuyentes.creaCliente(c);
		return c;
	}

	public Cliente bajaCliente(String dni) throws OperacionNoValida {
		daoContribuyentes.eliminaCliente(dni);
		return daoContribuyentes.cliente(dni);
	}

	
}
