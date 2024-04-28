package ar.edu.unju.fi.ejercicio4.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 4
		
		byte op = 0;
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Elija una de las opciones del menu.");
			//System.out.println("0 - Agregar 4 jugadores por defecto.");
			System.out.println("1 - Alta de jugador");
			System.out.println("2 - Mostrar todos los jugadores");
			System.out.println("3 - Modificar los datos de un jugador");
			System.out.println("4 - Eliminar un jugador");
			System.out.println("5 - Salir");
			
			String msj = "Ingrese una opción: ";
			System.out.print(msj);
			
			while(true) {
				try {
					op = sc.nextByte();
					if (op > 0 && op < 6) break;
					
					MostrarMensajeError(msj);
				}catch (Exception ex){
					MostrarMensajeError(msj);
					sc.nextLine();
				}
			}
			
			sc.nextLine();
			switch (op) {
				/*case 0:
					Calendar calendar = Calendar.getInstance();
					calendar.set(1996, 5, 7);
					Jugador jugador1 = new Jugador("Cristian", "Rojas", calendar, "Argentino", 1.8, 55, Posicion.ARQUERO);
					Jugador jugador2 = new Jugador("Maria", "Orosco", calendar, "Argentino", 1.8, 55, Posicion.DEFENSA);
					Jugador jugador3 = new Jugador("Karen", "Navarro", calendar, "Argentino", 1.8, 55, Posicion.DELANTERO);
					Jugador jugador4 = new Jugador("Gael", "Mendoza", calendar, "Argentino", 1.8, 55, Posicion.MEDIO);
					jugadores.add(jugador1);
					jugadores.add(jugador2);
					jugadores.add(jugador3);
					jugadores.add(jugador4);
					break;*/
				case 1:
					System.out.print("Ingrese nombre del jugador: ");
					String nombre = sc.nextLine();
					nombre = ValidarDatosString(sc, nombre);
					
					System.out.print("Ingrese apellido del jugador: ");
					String apellido = sc.nextLine();
					apellido = ValidarDatosString(sc, apellido);
					
					System.out.print("Ingrese fecha de nacimiento del jugador (dd/mm/yyyy): ");
					String fechaNacimientoString = sc.nextLine();
					fechaNacimientoString = ValidarDatosString(sc, fechaNacimientoString);
					Calendar fechaNacimiento = ValidarFechaCalendar(sc, fechaNacimientoString);
					
					System.out.print("Ingrese nacionalidad del jugador: ");
					String nacionalidad = sc.nextLine();
					nacionalidad = ValidarDatosString(sc, nacionalidad);
					
					double estatura = ValidarDatosDouble(sc, "Ingrese estatura del jugador (ej. 1.8): ");
					
					double peso = ValidarDatosDouble(sc, "Ingrese peso del jugador (ej. 80.4): ");
					
					MostrarPosiciones();
					Posicion posicion = ValidarPosicion(sc);
					
					Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
					jugadores.add(nuevoJugador);
					break;
				case 2:
					if(!ListaTieneElementos(jugadores)) break;
					
					for (Jugador jugador : jugadores) {
						System.out.println(jugador);
					}
					
					break;
				case 3:
					if(!ListaTieneElementos(jugadores)) break;

					System.out.print("\nIngrese nombre del jugador a buscar: ");
					nombre = sc.nextLine();
					nombre = ValidarDatosString(sc, nombre);
					
					System.out.print("Ingrese apellido del jugador a buscar: ");
					apellido = sc.nextLine();
					apellido = ValidarDatosString(sc, apellido);
					
					Jugador jugadorEncontrado = null;
					for (Jugador jugador : jugadores) {
						if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)){
							jugadorEncontrado = jugador;
							break;
						}
					}
					
					if(jugadorEncontrado == null) {
						System.out.println("\nNo se encontró el jugador: " + nombre + " " + apellido);
						break;
					}
					
					System.out.println("\nSe encontró el jugador " + nombre + " " + apellido);
					System.out.print("\nIngrese el nombre nuevo del jugador: ");
					nombre = sc.nextLine();
					nombre = ValidarDatosString(sc, nombre);
					System.out.print("Ingrese el apellido nuevo del jugador: ");
					apellido = sc.nextLine();
					apellido = ValidarDatosString(sc, apellido);
					System.out.print("Ingrese fecha de nacimiento nueva del jugador (dd/mm/yyyy): ");
					fechaNacimientoString = sc.nextLine();
					fechaNacimiento = ValidarFechaCalendar(sc, fechaNacimientoString);
					
					System.out.print("Ingrese nacionalidad del jugador: ");
					nacionalidad = sc.nextLine();
					nacionalidad = ValidarDatosString(sc, nacionalidad);
					
					estatura = ValidarDatosDouble(sc, "Ingrese estatura del jugador (ej. 1.8): ");
					peso = ValidarDatosDouble(sc, "Ingrese peso del jugador (ej. 80.4): ");
					
					MostrarPosiciones();
					posicion = ValidarPosicion(sc);
					
					jugadorEncontrado.setNombre(nombre);
					jugadorEncontrado.setApellido(apellido);
					jugadorEncontrado.setFechaNacimiento(fechaNacimiento);
					jugadorEncontrado.setNacionalidad(nacionalidad);
					jugadorEncontrado.setEstatura(estatura);
					jugadorEncontrado.setPeso(peso);
					jugadorEncontrado.setPosicion(posicion);
					
					System.out.println("\nDatos del jugador modificado: ");
					System.out.println(jugadorEncontrado);
					
					break;
				case 4:
					if(!ListaTieneElementos(jugadores)) break;
					
					System.out.print("\nIngrese nombre del jugador a eliminar: ");
					nombre = sc.nextLine();
					nombre = ValidarDatosString(sc, nombre);
					System.out.print("Ingrese apellido del jugador a eliminar: ");
					apellido = sc.nextLine();
					apellido = ValidarDatosString(sc, apellido);
					
					boolean encontro = false;
					Iterator<Jugador> iterator = jugadores.iterator();
					while(iterator.hasNext()) {
						Jugador jugador = (Jugador)iterator.next();
						if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
							System.out.println("\nSe va a eliminar al jugador: " + nombre + " " + apellido);
							iterator.remove();
							encontro = true;
							System.out.println("Jugador eliminado.");
							break;
						}
					}
					
					if (!encontro) System.out.println("\nNo se encontró el jugador: " + nombre + " " + apellido);
					break;
				case 5:
					System.out.println("Saliendo del programa...");
                    break;
				default:
					System.out.println("\nElija una opción entre [1-5]");
					break;
			};
			System.out.println("");
		}while(op != 5);
		
		sc.close();
	}
	
	private static boolean ListaTieneElementos(ArrayList<Jugador> jugadores) {
    	if(jugadores.size() == 0) {
    		System.out.println("\nNo existen jugadores agregados. Por favor dé de alta un jugador");
			return false;
		}
    	
    	return true;
    }
	
	private static String ValidarDatosString(Scanner sc, String valor) {
		while(valor.isBlank()) {
			System.out.println("El valor ingresado no puede ser vacío.");
			System.out.print("Ingrese un valor válido: ");
			valor = sc.nextLine();
		}
		
		return valor;
	}
	
	private static Posicion ValidarPosicion(Scanner sc) {
		int posicionTamanio = Posicion.values().length;
		String msj = "Ingrese Posición [1 - " + posicionTamanio +"]: ";
		System.out.print(msj);
		
		byte opcion;
		while(true) {
			try {
				String posicionString = sc.nextLine();
				opcion = Byte.parseByte(posicionString);
				
				if (opcion > 0 && opcion <= posicionTamanio) return Posicion.values()[opcion-1];
				
				MostrarMensajeError(msj);
			}catch(NumberFormatException ex){
				MostrarMensajeError(msj);
			}
		}
	}
	
	private static void MostrarPosiciones() {
		System.out.println("-- POSICIONES --");
		for (int i = 0; i < Posicion.values().length; i++) {
			System.out.println((i+1) + " - " + Posicion.values()[i]);
		}
	}
	
	private static Double ValidarDatosDouble(Scanner sc, String msj) {
		System.out.print(msj);
		double valor = 0;
		while(true) {
			String valorString = sc.nextLine();
			try {
				valor = Double.parseDouble(valorString);
				
				if (valor > 0) return valor;
				
				MostrarMensajeError(msj);
			} catch (NumberFormatException e) {
				MostrarMensajeError(msj);
			}
		}
	}
	
	private static void MostrarMensajeError(String msj) {
		System.out.print("Opción inválida. " + msj);
	}
	
	private static Calendar ValidarFechaCalendar(Scanner sc, String fechaNacimientoString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar fechaNacimiento = Calendar.getInstance();
		
		while(true) {
			try {
				fechaNacimiento.setTime(formatter.parse(fechaNacimientoString));
				return fechaNacimiento;
			} catch (ParseException e) {
				System.out.print("Por favor ingrese una fecha válida (dd/MM/yyyy): ");
				fechaNacimientoString = sc.nextLine();
				fechaNacimientoString = ValidarDatosString(sc, fechaNacimientoString);
			}
		}
	}
}