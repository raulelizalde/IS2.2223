package is.unican.is2.ClasesP5;

import java.time.LocalDateTime;

public class Movimiento {
	private String mConcepto;
	private LocalDateTime mFecha;
	private double mImporte;

	public double getI() {
		return mImporte;
	}//wmc +1

	public void setI(double newMImporte) {
		mImporte = newMImporte;
	}//wmc +1
	
	public String getC() {
		return mConcepto;
	}//wmc +1

	public void setC(String newMConcepto) {
		mConcepto = newMConcepto;
	}//wmc +1

	public LocalDateTime getF() {
		return mFecha;
	}//wmc +1

	public void setF(LocalDateTime newMFecha) {
		mFecha = newMFecha;
	}//wmc +1
	
}