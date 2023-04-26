package is.unican.is2.ClasesP5;

public class Direccion {
	public String calle;
	public String zip;
	public String localidad;
	
	
	public Direccion(String calle, String zip, String localidad) {
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	
	public void cambiaDireccion(String calle, String zip, String localidad) {
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	//wmc + 1
	
	public String getCalle() {
		return calle;
	}
	//wmc + 1

	public String getZip() {
		return zip;
	}
	//wmc + 1

	public String getLocalidad() {
		return localidad;
	}
	//wmc + 1
}
