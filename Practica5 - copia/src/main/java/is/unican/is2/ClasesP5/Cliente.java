package is.unican.is2.ClasesP5;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	public String nombre;
	public String telefono;
	public String dni;
	
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>();

 	public Cliente(String titular, String telefono, String dni) {  
		this.nombre = titular;
		this.telefono = telefono;
		this.dni = dni;
	}
 	//wmc + 1
	
	public void anhadeCuenta(Cuenta c) {
		Cuentas.add(c);
	}
	//wmc + 1
	
	public double getSaldoTotal() {
		double total = 0.0;
		for (Cuenta c: Cuentas) {  //wmc + 1 //Ccog +1
			total += c.calculaTotal();
		}
		return total;
	}
	//wmc + 1
	
	public String getNombre() {
		return nombre;
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