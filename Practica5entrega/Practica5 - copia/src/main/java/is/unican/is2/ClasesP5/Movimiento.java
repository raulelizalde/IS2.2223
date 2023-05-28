package is.unican.is2.ClasesP5;

import java.time.LocalDateTime;

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	public double getImporte() {
		return mImporte;
	}//wmc +1

	public void setImporte(double newMImporte) {
		mImporte = newMImporte;
	}//wmc +1
	
	public String getConcepto() {
		return mConcepto;
	}//wmc +1

	public void setConcepto(String newMConcepto) {
		mConcepto = newMConcepto;
	}//wmc +1

	public LocalDateTime getFecha() {
		return mFecha;
	}//wmc +1

	public void setFecha(LocalDateTime newMFecha) {
		mFecha = newMFecha;
	}//wmc +1
	
}