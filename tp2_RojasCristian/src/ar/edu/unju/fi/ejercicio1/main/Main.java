package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 1
		
		ArrayList<Producto> listaProductos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		byte op;
		do {
			System.out.println("Menu:");
			//System.out.println("0 - Productos de prueba");
			System.out.println("1 - Crear Producto");
			System.out.println("2 - Mostrar productos");
			System.out.println("3 - Modificar producto");
			System.out.println("4 - Salir");
			System.out.print("Ingrese una opción: ");
			op = sc.nextByte();
			sc.nextLine();
			switch (op) {
				/*case 0:
					Producto producto0 = new Producto("P1", "Martillo", 10.5, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS);
					Producto producto1 = new Producto("P2", "Destornillador", 10.5, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS);
					Producto producto2 = new Producto("P3", "Intel I5 10400", 1000.8, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA);
					Producto producto3 = new Producto("P4", "Samsung S24 Ultra", 100000.5, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA);
					listaProductos.add(producto0);
					listaProductos.add(producto1);
					listaProductos.add(producto2);
					listaProductos.add(producto3);
					break;*/
				case 1:
					System.out.println("Alta de producto:");
					System.out.print("Ingrese código del producto: ");
					String codigo = sc.nextLine();
					System.out.print("Ingrese descripción del producto: ");
					String descripcion = sc.nextLine();
					System.out.print("Ingrese precio del producto: ");
					double precio = sc.nextDouble();
					sc.nextLine();
					System.out.println("---- Origen de fabricación ----");
					for (int i = 0; i < OrigenFabricacion.values().length; i++) {
						System.out.println((i+1) + " - " + OrigenFabricacion.values()[i]);
					}
					System.out.print("Ingrese Origen de fabricación del producto: ");
					byte origenFabricacionByte = sc.nextByte();
					OrigenFabricacion origenFabricacion = OrigenFabricacion.values()[origenFabricacionByte-1];
					
					System.out.println("---- Categoría ----");
					for (int i = 0; i < Categoria.values().length; i++) {
						System.out.println((i+1) + " - " + Categoria.values()[i]);
					}
					
					System.out.print("Ingrese Categoría del producto: ");
					byte categoriaByte = sc.nextByte();
					Categoria categoria = Categoria.values()[categoriaByte-1];
					
					Producto producto = new Producto(codigo, descripcion, precio, origenFabricacion, categoria);
					
					listaProductos.add(producto);
					break;
				case 2:
					for (Producto prod : listaProductos) {
						System.out.println(prod);
					}
					break;
				case 3:
					System.out.print("Ingrese código de producto a modificar: ");
					String codigoBuscar = sc.nextLine();
					Producto productoModificar = null;
					for (Producto prod : listaProductos) {
						if (prod.getCodigo().equals(codigoBuscar)) {
							productoModificar = prod;
							break;
						}
					}
					
					if (productoModificar == null) System.out.println("No se encontro el código del producto.");
					
					System.out.print("Ingrese la nueva descripción del producto: ");
					descripcion = sc.nextLine();
					productoModificar.setDescripcion(descripcion);
					
					System.out.print("Ingrese el nuevo precio del producto: ");
					precio = sc.nextDouble();
					sc.nextLine();
					productoModificar.setPrecioUnitario(precio);
					
					
					System.out.println("---- Origen de fabricación ----");
					for (int i = 0; i < OrigenFabricacion.values().length; i++) {
						System.out.println((i+1) + " - " + OrigenFabricacion.values()[i]);
					}
					System.out.print("Ingrese el nuevo origen de fabricación: ");
					origenFabricacionByte = sc.nextByte();
					origenFabricacion = OrigenFabricacion.values()[origenFabricacionByte-1];
					
					productoModificar.setOrigenFabricacion(origenFabricacion);
					
					System.out.println("---- Categoría ----");
					for (int i = 0; i < Categoria.values().length; i++) {
						System.out.println((i+1) + " - " + Categoria.values()[i]);
					}
					
					System.out.print("Ingrese la nueva categoria: ");
					categoriaByte = sc.nextByte();
					categoria = Categoria.values()[categoriaByte-1];
					
					productoModificar.setCategoria(categoria);
					System.out.println("Producto modificado..");
					break;
				case 4:
					System.out.println("Saliendo del programa..");
					break;
				default:
					System.out.println("Por favor, elija una opción válida.");
					break;
			}
			System.out.println("");
		}while(op != 4);
		
		sc.close();
	}

}