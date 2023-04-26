package is.unican.is2.ClasesP5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> mMovimientos;
	private LocalDate mFechaDeCaducidadTarjetaDebito;
	private LocalDate mFechaDeCaducidadTarjetaCredito;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta, LocalDate date, LocalDate date2) throws datoErroneoException {
		super(numCuenta);
		this.mFechaDeCaducidadTarjetaDebito = date;
		this.mFechaDeCaducidadTarjetaCredito = date2;
		mMovimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}//wmc +1

	public void ingresar(double x) throws datoErroneoException {
		if (x <= 0)//wmc +1 //CCog + 1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.mMovimientos.add(m);
	}//wmc +1

	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {
		comprobacionCantidad(x);
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Retirada de efectivo");
		m.setImporte(-x);
		this.mMovimientos.add(m);
	}//wmc +1

	public void ingresar(String concepto, double x) throws datoErroneoException {
		if (x <= 0)//wmc +1 //CCog + 1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto(concepto);
		m.setImporte(x);
		this.mMovimientos.add(m);
	}//wmc +1

	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException {
		comprobacionCantidad(x);
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.mMovimientos.add(m);
	}//wmc +1

	public double getSaldo() {
		double r = 0.0;
		for (int i = 0; i < this.mMovimientos.size(); i++) {
			Movimiento m = (Movimiento) mMovimientos.get(i);
			r += m.getImporte();
		}//wmc +1 //CCog + 1
		return r;
	}//wmc +1

	public void addMovimiento(Movimiento m) {
		mMovimientos.add(m);
	}//wmc +1

	public List<Movimiento> getMovimientos() {
		return mMovimientos;
	}//wmc +1

	public LocalDate getCaducidadDebito() {
		return this.mFechaDeCaducidadTarjetaDebito;
	}//wmc +1

	public LocalDate getCaducidadCredito() {
		return this.mFechaDeCaducidadTarjetaCredito;
	}//wmc +1

	public double getLimiteDebito() {
		return limiteDebito;
	}//wmc +1
	
	private void comprobacionCantidad(double x) {
		if (getSaldo() < x)//wmc +1 //CCog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");
		if (x <= 0)//wmc +1 //CCog + 1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
	}

}