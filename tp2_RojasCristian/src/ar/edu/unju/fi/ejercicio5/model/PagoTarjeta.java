package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {

	private String nroTarjeta;
	private LocalDate fechaDePago;
	private double montoPagado;
	
	public PagoTarjeta(String nroTarjeta, LocalDate fechaDePago, double montoPagado) {
		super();
		this.nroTarjeta = nroTarjeta;
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}

	public String getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(double monto) {
		this.montoPagado += (this.montoPagado * 0.15);
	}

	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Número de tarjeta: " + this.nroTarjeta);
		System.out.println("Fecha de Pago: " + this.fechaDePago.format(formatter));
		System.out.println("Monto Pagado: " + this.montoPagado);
	}

}
