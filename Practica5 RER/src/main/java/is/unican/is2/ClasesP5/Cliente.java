package is.unican.is2.ClasesP5;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	public String nombre;
	public String calle;
	public String zip;
	public String localidad;
	public String telefono;
	public String dni;
	
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>();

 	public Cliente(String titular, String calle, String zip, String localidad, 
 			String telefono, String dni) {  
		this.nombre = titular;
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
		this.telefono = telefono;
		this.dni = dni;
	}
 	//wmc + 1
	
	public void cambiaDireccion(String calle, String zip, String localidad) {
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}
	//wmc + 1
	
	public void anhadeCuenta(Cuenta c) {
		Cuentas.add(c);
	}
	//wmc + 1
	
	public double getSaldoTotal() {
		double total = 0.0;
		for (Cuenta c: Cuentas) {  //wmc + 1 //Ccog +1
			if (c instanceof CuentaAhorro) { //wmc + 1 //Ccog + 2
				total += ((CuentaAhorro) c).getSaldo();
			} else if (c instanceof CuentaValores)  { //wmc + 1 //CCog + 1
				for (Valor v: ((CuentaValores) c).getValores()) { //wmc + 1 //CCog + 3
					total += v.getCotizacion()*v.getNumValores();
				}
			}
		}
		return total;
	}
	//wmc + 1
	
	public String getNombre() {
		return nombre;
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

	public String getTelefono() {
		return telefono;
	}
	//wmc + 1

	public String getDni() {
		return dni;
	}
	//wmc + 1
	
	
}