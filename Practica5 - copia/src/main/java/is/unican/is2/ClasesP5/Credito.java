package is.unican.is2.ClasesP5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class Credito extends Tarjeta {
	
	private double mCredito;
	private List<Movimiento> mMovimientosMensuales;
	private List<Movimiento> mhistoricoMovimientos;
	
	
	public Credito(String numero, String titular, CuentaAhorro c, double credito) {
		super(numero, titular, c);
		mCredito = credito;
		mMovimientosMensuales = new LinkedList<Movimiento>();
		mhistoricoMovimientos = new LinkedList<Movimiento>();
	}//wmc +1

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. Se aplica una comisión del 5%.
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	@Override
	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException {
		if (x<0)//wmc +1 //CCog + 1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Retirada en cajero automático");
		x += x * 0.05; // Añadimos una comisión de un 5%
		m.setImporte(-x);
		
		if (getGastosAcumulados()+x > mCredito)//wmc +1 //CCog + 1
			throw new saldoInsuficienteException("Crédito insuficiente");
		else { //CCog + 1
			mMovimientosMensuales.add(m);
		}
	}//wmc +1

	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws saldoInsuficienteException, datoErroneoException {
		if (x<0)//wmc +1 //CCog + 1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		
		if (getGastosAcumulados() + x > mCredito)//wmc +1 //CCog + 1
			throw new saldoInsuficienteException("Saldo insuficiente");
		
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setFecha(now);
		m.setConcepto("Compra a crédito en: " + datos);
		m.setImporte(-x);
		mMovimientosMensuales.add(m);
	}//wmc +1
	
    public double getGastosAcumulados() {
		double r = 0.0;
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) {
			Movimiento m = (Movimiento) mMovimientosMensuales.get(i);
			r += m.getImporte();
		}//wmc +1 //CCog + 1
		return -r;
	}//wmc +1
	
	
	public LocalDate getCaducidadCredito() {
		return this.mCuentaAsociada.getCaducidadCredito();
	}//wmc +1

	/**
	 * Método que se invoca automáticamente el día 1 de cada mes
	 */
	public void liquidar() {
		Movimiento liq = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		liq.setFecha(now);
		liq.setConcepto("Liquidación de operaciones tarjeta crédito");
		double r = 0.0;
		for (int i = 0; i < this.mMovimientosMensuales.size(); i++) {
			Movimiento m = (Movimiento) mMovimientosMensuales.get(i);
			r += m.getImporte();
		}//wmc +1 //CCog + 1
		liq.setImporte(r);
	
		if (r != 0)//wmc +1 //CCog + 1
			mCuentaAsociada.addMovimiento(liq);
		
		mhistoricoMovimientos.addAll(mMovimientosMensuales);
		mMovimientosMensuales.clear();
	}//wmc +1

	public List<Movimiento> getMovimientosUltimoMes() {
		return mMovimientosMensuales;
	}//wmc +1
	
	public Cuenta getCuentaAsociada() {
		return mCuentaAsociada;
	}//wmc +1
	
	public List<Movimiento> getMovimientos() {
		return mhistoricoMovimientos;
	}//wmc +1

}