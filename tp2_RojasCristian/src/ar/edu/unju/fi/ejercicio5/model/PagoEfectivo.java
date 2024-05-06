package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {

	private double montoPagado;
	private LocalDate fechaDePago;
	
	public PagoEfectivo(double montoPagado, LocalDate fechaDePago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaDePago = fechaDePago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	@Override
	public void realizarPago(double monto) {
		this.montoPagado -= (this.montoPagado * 0.1);
	}

	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Fecha de Pago: " + this.fechaDePago.format(formatter));
		System.out.println("Monto Pagado: " + this.montoPagado);
	}
}
