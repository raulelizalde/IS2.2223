package is.unican.is2.SegurosCommon;




import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Clase que representa un seguro de coche.
 * Un seguro se identifica por la matrícula
 * del coche para el que se contrata el seguro
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Seguro")
public class Seguro {
	
	private static final double PORCENTAJE_TRAMO_1 = 0.95;
	private static final double PORCENTAJE_TRAMO_2 = 0.80;
	private static final int INICIO_TRAMO_1= 90;
	private static final int FIN_TRAMO_1=110;
	private static final double DESCUENTO_PRIMER_ANHO = 0.8;
	private static final double DESCUENTO_SEGUNDO_ANHO = 0.9;
	
    
    @XmlAttribute(required = true)
    private int potencia;
    
    @XmlAttribute(required = true)
    private String matricula;
    
    @XmlAttribute(required = true)
    private Cobertura cobertura;
     
    @XmlAttribute(name="fecha", required=true)
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate fechaContratacion;
    
    double precio;
    
    public Seguro(int potencia, String matricula, LocalDate fechaContratacion, Cobertura cobertura) {
    	this.potencia = potencia;
    	this.matricula = matricula;
    	this.fechaContratacion = fechaContratacion;
    	this.cobertura = cobertura;
    }


	/**
	 * Retorna la matrícula del coche 
	 * asociado al seguro
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Define el valor para la matrícula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Retorna el tipo de cobertura del seguro
	 */
	public Cobertura getCobertura() {
		return cobertura;
	}

	/**
	 * Define el valor para la cobertura
	 */
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}


	/**
     * Retorna la potencia del coche asociado 
     * al seguro. 
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Define el valor de la potencia.
     */
    public void setPotencia(int value) {
        this.potencia = value;
    }
    
    public LocalDate fechaContratacion() {
    	return this.fechaContratacion;
    }
    
    public void setFechaContratacion(LocalDate dia) {
    	this.fechaContratacion = dia;
    }
    
    public void setPrecio(double nuevoPrecio) {
    	precio = nuevoPrecio;
    }
    /**
     * Retorna el precio del seguro
     * @return
     */
    public double precio() {
    	Cobertura c = getCobertura();
    	int p = getPotencia();
    	precio = 0;
    	//calculamos precio de cobertura
    	if (c == Cobertura.TERCEROS) {
    		precio += 400;
    	} else if (c == Cobertura.TERCEROSLUNAS) {
    		precio += 600;
    	} else if (c == Cobertura.TODORIESGO) {
    		precio += 1000;
    	}
    	
    	//calculamos por potencia
    	if (p >= INICIO_TRAMO_1 && p <= FIN_TRAMO_1) {
    		precio = precio * 1.05;
    	} else if (p > FIN_TRAMO_1) {
    		precio = precio * 1.2;
    	}
    	
    	//oferta años
    	LocalDate ahora = LocalDate.now();
    	long dias = DAYS.between(fechaContratacion, ahora);
    	if (dias < 365) {
    		precio = precio * DESCUENTO_PRIMER_ANHO;
    	} else if (dias < 730){
    		precio = precio * DESCUENTO_SEGUNDO_ANHO;
    	}
    	
    	//minusvalia
    	
    	
    	return precio;
    }

}
