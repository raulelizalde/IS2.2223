package is.unican.is2.SegurosCommon;



import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase que representa un cliente de la empresa de seguros
 * Un cliente se identifica por su dni
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Cliente")
public class Cliente {

	@XmlElement(required=true, name="seguro")
    private List<Seguro> seguros = new LinkedList<Seguro>();
    
    @XmlAttribute(required = true)
    private String nombre;
    
    @XmlAttribute(required = true)
    private String dni;
    
    @XmlAttribute(required = true)
    private boolean minusvalia;
    
    
    public Cliente(){
    }  

    public void creaDatos(String nombre, String dni, boolean minusvalia){
    	this.nombre = nombre;
    	this.dni = dni;
    	this.minusvalia = minusvalia;
    }  
	/**
     * Retorna los seguros del cliente 
     */
    public List<Seguro> getSeguros() {
        if (seguros == null) {
        	seguros = new LinkedList<Seguro>();
        }
        return seguros;
    }
    
    /**
     * Define el valor de la propiedad seguros
     */
    public void setSeguros(List<Seguro> value) {
		this.seguros = value;
		
	}

    /**
     * Retorna el nombre del cliente.   
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.  
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Retorna el dni del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     */
    public void setDni(String value) {
        this.dni = value;
    }
    
    /**
     * Indica si el cliente es minusv�lido
     */
    public boolean getMinusvalia() {
    	return minusvalia;
    }
    
    public void setMinusvalia(boolean minus)  {
    	minusvalia = minus;
    }
    
    public void a�adirSeguro(Seguro seguro) {
    	seguros.add(seguro);
    }
    
    /**
     * Calcula el total a pagar por el cliente por 
     * todos los seguros a su nombre
     */
    public double totalSeguros() {
    	double suma = 0;
    	for (Seguro s: seguros) {
    		if(this.getMinusvalia()) {
    			suma += s.precio() * 0.75;
    		} else {
    			suma += s.precio();
    		}
    	}
    	return suma;
    }
    
    

}
