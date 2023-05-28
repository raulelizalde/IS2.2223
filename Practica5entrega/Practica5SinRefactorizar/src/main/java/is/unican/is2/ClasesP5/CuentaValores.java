package is.unican.is2.ClasesP5;

import java.util.LinkedList;
import java.util.List;

public class CuentaValores extends Cuenta {

	private List<Valor> valores;
	
	public CuentaValores(String numCuenta) {
		super(numCuenta);
		valores = new LinkedList<Valor>();
	}//wmc +1
	
	public List<Valor> getValores() {
		return valores;
	}//wmc +1
	
	public boolean anhadeValor(Valor valor) {
		for (Valor v:valores) {//wmc +1 //CCog + 1
			if (v.getEntidad().equals(valor.getEntidad()))//wmc +1 //CCog + 2
				return false;
		}
		valores.add(valor);
		return true;
	}//wmc +1
	
}
