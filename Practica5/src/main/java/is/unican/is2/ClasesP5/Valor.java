package is.unican.is2.ClasesP5;

/**
 * Clase que representa un valor en bolsa (paquete de acciones). 
 * Cada valor contiene un número de acciones 
 * de una de las entidades del IBEX 35
 */
public class Valor {
	
	private String entidad;	
	private int numAcciones;
	private double cotizacion;
	
	public Valor(String entidad, int numAcciones, double cotizacionActual) {
		this.entidad = entidad;
		this.numAcciones = numAcciones;
		this.cotizacion = cotizacionActual;
	}//wmc +1
	
	public int getNumValores() {
		return numAcciones;
	}//wmc +1

	public void setNumValores(int numValores) {
		this.numAcciones = numValores;
	}//wmc +1

	public double getCotizacion() {
		return cotizacion;
	}//wmc +1
	
	public void setCotizacion(double cotizacion) {
		this.cotizacion = cotizacion;
	}//wmc +1

	public String getEntidad() {
		return entidad;
	}//wmc +1

	@Override
	public boolean equals(Object obj) {
		Valor other = (Valor)obj;
		return (entidad.equals(other.entidad) & numAcciones==other.numAcciones);

	}//wmc +1
	
	

}