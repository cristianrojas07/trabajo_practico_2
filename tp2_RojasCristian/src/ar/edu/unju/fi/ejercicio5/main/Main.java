package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		// ejercicio 5

		List<Producto> productos = new ArrayList<>();
		List<Producto> carrito = new ArrayList<>();
		Random rand = new Random();

		for (int i = 0; i < 15; i++) {
			int idProd = (i+1);
			Producto producto = new Producto(String.valueOf(idProd), "Descripcion"+idProd, Math.round(rand.nextDouble(1000)), OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
			productos.add(producto);
		}
		
		Scanner sc = new Scanner(System.in);
		byte op = 0;
		byte opCarrito = 0;
		byte opPago = 0;
		do {
			System.out.println("-- MENÚ --");
			System.out.println("1 - Mostrar Productos");
			System.out.println("2 - Realizar compra");
			System.out.println("3 - Salir");
			String msj = "Ingrese una opción: ";
			System.out.print(msj);
			while(true) {
				try {
					op = sc.nextByte();
					if (op > 0 && op < 4) break;
					
					MostrarMensajeError(msj);
				}catch (Exception ex){
					MostrarMensajeError(msj);
					sc.nextLine();
				}
			}
			
			sc.nextLine();
			switch (op) {
				case 1: {
					MostrarProductos(productos, "\n-- Lista de productos --");
					break;
				}
				case 2: {
					while(true) {
						try {
							MostrarProductos(productos, "\n-- Lista de productos --");
							MostrarProductos(carrito, "\n-- Carrito --");
							System.out.println("\nPara salir del carrito de compra escriba 0.");
							System.out.print("Elija un producto para agregar al carrito: ");
							opCarrito = sc.nextByte();
							sc.nextLine();
							if(opCarrito == 0) break;
							if (opCarrito >= 1 && opCarrito <= 15) {
								Producto productoSeleccionado = productos.get(opCarrito-1);
								if (!productoSeleccionado.getEstado())
								{
									System.out.println("\nNo hay stock del producto seleccionado.");
								}else {
									carrito.add(productoSeleccionado);
									productoSeleccionado.setEstado(false);
								}
							}else {
								System.out.println("Opción incorrecta.");
							}
						}catch(Exception ex) {
							System.out.println("Ocurrió un error. Vuelva a intentarlo.");
						}
					}
					
					if (carrito.size() == 0) {
						System.out.println("\nNo agrego productos al carrito.");
						break;
					}
					
					Pago pago = null;
					do {
						System.out.println("\nOpciones de pago");
						System.out.println("1 - Pago efectivo");
						System.out.println("2 - Pago con tarjeta");
						
						msj = "Elija una opción de pago: ";
						System.out.print(msj);
						while(true) {
							try {
								opPago = sc.nextByte();
								if (opPago > 0 && opPago < 3) break;
								
								MostrarMensajeError(msj);
							}catch (Exception ex){
								MostrarMensajeError(msj);
								sc.nextLine();
							}
						}
						
						sc.nextLine();
						double montoAbonado = calcularMontoAbonado(carrito);
				        
				        switch (opPago) {
				            case 1:
				                pago = new PagoEfectivo(montoAbonado, LocalDate.now());
				                break;
				            case 2:
				                pago = new PagoTarjeta("4021123454786010", LocalDate.now(), montoAbonado);
				                break;
			                default:
			                    System.out.println("Ingrese una opción válida.");
			                    break;
				        }

				        if(pago != null) {
				        	pago.realizarPago(montoAbonado);
				        	System.out.println();
					        pago.imprimirRecibo();
				        }
				        
					}while(pago == null);
					
					break;
				}
				case 3: {
					System.out.println("Saliendo del programa..");
					break;
				}
				default:
					System.out.println("Opción Incorrecta.");
					break;
			}
			System.out.println();
		}while(op != 3);
		
		sc.close();
	}
	
	private static void MostrarMensajeError(String msj) {
		System.out.print("Opción inválida. " + msj);
	}
	
	private static void MostrarProductos(List<Producto> productos, String msj) {
		if (productos.size() > 0) {
			System.out.println(msj);
		}
		
		for (int i = 0; i < productos.size(); i++) {
			System.out.println(productos.get(i));	
		}
	}
	
	private static double calcularMontoAbonado(List<Producto> carrito) {
		double montoAbonado = 0;
		for (Producto producto : carrito) {
			montoAbonado += producto.getPrecioUnitario();
		}
		
		return montoAbonado;
	}
}
