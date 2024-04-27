package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 2
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		byte op = 0;
		do {
			System.out.println("Menu:");
			//System.out.println("0 - Efemérides de prueba");
			System.out.println("1 - Crear efeméride");
			System.out.println("2 - Mostrar efemérides");
			System.out.println("3 - Eliminar efeméride");
			System.out.println("4 - Modificar efeméride");
			System.out.println("5 - Salir");
			System.out.print("Ingrese una opción: ");
			boolean opcionValida = false;
			while(!opcionValida) {
				try {
					op = sc.nextByte();
					if (op >= 0 && op < 6) {
						opcionValida = true;	
					}else {
						System.out.print("Ingrese una opción válida: ");
					}
				}catch (Exception ex){
					System.out.println("Ingrese una opción válida. Solo se permiten valores enteros.");
					sc.nextLine();
				}
			}
			
			sc.nextLine();
			switch (op) {
				/*case 0:
					Efemeride efemeride0 = new Efemeride("Cod1", Mes.MAYO, 1, "Dia del trabajador");
					Efemeride efemeride1 = new Efemeride("Cod2", Mes.JUNIO, 20, "Dia de la bandera");
					Efemeride efemeride2 = new Efemeride("Cod3", Mes.ABRIL, 29, "Dia del animal");
					Efemeride efemeride3 = new Efemeride("Cod3", Mes.FEBRERO, 14, "San Valentin");
					efemerides.add(efemeride0);
					efemerides.add(efemeride1);
					efemerides.add(efemeride2);
					efemerides.add(efemeride3);
					break;*/
				case 1:
					System.out.println("-- Alta de efeméride --");
					
					System.out.println("---- Mes del año ----");
					Mes mes = ValidarMes(sc);
					
					System.out.print("Ingrese código del efémeride: ");
					String codigo = sc.nextLine();
					while(codigo.isBlank()) {
						System.out.println("El código no puede ser vacío.");
						System.out.print("Ingrese código del efémeride: ");
						codigo = sc.nextLine();
					}
					
					Calendar calendar = Calendar.getInstance();
			        calendar.set(Calendar.MONTH, mes.ordinal());
			        int ultimaDiaDelMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			        System.out.print("Ingrese dia del efémeride [1 - " + ultimaDiaDelMes + "]: ");
			        
			        boolean diaValido = false;
			        int dia = 0;
			        while(!diaValido) {
			        	try {
			        		dia = sc.nextInt();
				        	if (dia >= 1 && dia <= ultimaDiaDelMes) {
				        		diaValido = true;
				        	}else{
				        		System.out.print("Ingrese un dia válido del efémeride [1 - " + ultimaDiaDelMes + "]: ");
				        	}
			        	}catch(Exception ex){
			        		System.out.print("Ingrese un dia válido del efémeride [1 - " + ultimaDiaDelMes + "]: ");
			        	}
			        }
					sc.nextLine();
					System.out.print("Ingrese detalle del efémeride: ");
					String detalle = sc.nextLine();
					while(detalle.isBlank()) {
						System.out.println("El detalle no puede ser vacío.");
						System.out.print("Ingrese detalle del efémeride: ");
						detalle = sc.nextLine();
					}
					
					Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
					
					efemerides.add(efemeride);
					break;
				case 2:
					if (!ListaTieneElementos(efemerides)) break;
					
					for (Efemeride efem : efemerides) {
						System.out.println(efem);
					}
					break;
				case 3:
					if (!ListaTieneElementos(efemerides)) break;
					System.out.println("Ingrese mes del año del efeméride a eliminar: ");
					mes = ValidarMes(sc);
					
					boolean encontro = false;
					
					Iterator<Efemeride> iterator = efemerides.iterator();
					while(iterator.hasNext()) {
						efemeride = (Efemeride)iterator.next();
						if(efemeride.getMes().equals(mes)) {
							iterator.remove();
							encontro = true;
							System.out.println("Efeméride eliminado.");
							break;
						}
					}
					
					if (!encontro) System.out.println("No se encontro el efeméride.");
					break;
				case 4:
					if (!ListaTieneElementos(efemerides)) break;
					System.out.println("Ingrese mes del año del efeméride a modificar: ");
					mes = ValidarMes(sc);
					
					Efemeride efemerideModificar = null;
					for (Efemeride efem : efemerides) {
						if (efem.getMes().equals(mes)) {
							efemerideModificar = efem;
							break;
						}
					}
					
					if (efemerideModificar == null) {
						System.out.println("No se encontro el efeméride.");
						break;
					}
					
					calendar = Calendar.getInstance();
			        calendar.set(Calendar.MONTH, mes.ordinal());
			        ultimaDiaDelMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			        System.out.print("Ingrese nuevo dia del efémeride [1 - " + ultimaDiaDelMes + "]: ");
			        
			        diaValido = false;
			        dia = 0;
			        while(!diaValido) {
			        	try {
			        		dia = sc.nextInt();
				        	if (dia >= 1 && dia <= ultimaDiaDelMes) {
				        		diaValido = true;
				        	}else{
				        		System.out.print("Ingrese un dia válido del efémeride [1 - " + ultimaDiaDelMes + "]: ");
				        	}
			        	}catch(Exception ex){
			        		System.out.print("Ingrese un dia válido del efémeride [1 - " + ultimaDiaDelMes + "]: ");
			        	}
			        }
			        
					efemerideModificar.setDia(dia);
					sc.nextLine();
					
					System.out.print("Ingrese el nuevo detalle del efémeride: ");
					detalle = sc.nextLine();
					
					while(detalle.isBlank()) {
						System.out.println("El detalle no puede ser vacío.");
						System.out.print("Ingrese detalle del efémeride: ");
						detalle = sc.nextLine();
					}
					
					efemerideModificar.setDetalle(detalle);
					
					System.out.println("Efeméride modificado..");
					break;
				case 5:
					System.out.println("Saliendo del programa..");
					break;
				default:
					System.out.println("Por favor, elija una opción válida.");
					break;
			}
			System.out.println("");
		}while(op != 5);
		
		sc.close();
	}

	private static boolean ListaTieneElementos(ArrayList<Efemeride> efemerides) {
    	if(efemerides.size() == 0) {
    		System.out.println("\nNo existen efemérides agregados. Por favor dé de alta un efeméride.");
			return false;
		}
    	
    	return true;
    }
	
	private static Mes ValidarMes(Scanner sc) {
		for (int i = 0; i < Mes.values().length; i++) {
			System.out.println((i+1) + " - " + Mes.values()[i]);
		}
		
		boolean mesValido = false;
		int mesTamanio = Mes.values().length;
		byte opcion = 0;
		String msj = "Ingrese Mes del año [1 - " + mesTamanio +"]: ";
		System.out.print(msj);
		while(!mesValido) {
			try {
				String origenFabricacionString = sc.nextLine();
				opcion = Byte.parseByte(origenFabricacionString);
				if (opcion > 0 && opcion <= mesTamanio) {
					mesValido = true;
				}else {
					System.out.print("Opción Inválida. " + msj);
				}
			}catch(Exception ex){
				System.out.print("Opción Inválida. " + msj);
			}
		}
		
		return Mes.values()[opcion-1];
	}
}
