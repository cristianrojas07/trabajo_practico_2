package ar.edu.unju.fi.ejercicio4.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador
{
	private String nombre;
	private String apellido;
	private Calendar fechaNacimiento;
	private String nacionalidad;
	private double estatura;
	private double peso;
	private Posicion posicion;

	public Jugador() { }
	
	public Jugador(String nombre, String apellido, Calendar fechaNacimiento, String nacionalidad, double estatura,
			double peso, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + formatter.format(this.fechaNacimiento.getTime())
				+ ", nacionalidad=" + nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + "]";
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public double getEstatura() {
		return estatura;
	}



	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public Posicion getPosicion() {
		return posicion;
	}



	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}



	public int calcularEdad() {
	    Calendar ahora = Calendar.getInstance();
	    int edad = ahora.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
	    int diaNacimiento = fechaNacimiento.get(Calendar.DAY_OF_YEAR);
	    int diaActual = ahora.get(Calendar.DAY_OF_YEAR);

	    if (diaActual < diaNacimiento) {
	        edad--;
	    }

	    return edad;
	}

}