package is.unican.is2.ClasesP5; 

public abstract class Cuenta {
	
	private String numCuenta;
	protected double totalCuenta;
	
	protected Cuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}//wmc +1
	
	public String getNumCuenta() {
		return numCuenta;
	}//wmc +1
	
	public double calculaTotal() {
		return totalCuenta;
	}
	
}
