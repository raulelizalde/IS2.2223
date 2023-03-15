package is.unican.is2.SeguroMain;

import is.unican.is2.SegurosBusiness.GestionSeguros;
import is.unican.is2.SegurosCommon.IClientesDAO;
import is.unican.is2.SegurosCommon.ISegurosDAO;
import is.unican.is2.SegurosDAO.ClientesDAO;
import is.unican.is2.SegurosDAO.SegurosDAO;
import is.unican.is2.SegurosGUI.VistaAgente;

public class Runner {

	public static void main(String[] args) {
		IClientesDAO daoContribuyentes = (IClientesDAO) new ClientesDAO();
		ISegurosDAO daoVehiculos = new SegurosDAO();
		GestionSeguros negocio = new GestionSeguros(daoContribuyentes, daoVehiculos);
		VistaAgente vista = new VistaAgente(negocio, negocio, negocio);
		vista.setVisible(true);

	}

}
