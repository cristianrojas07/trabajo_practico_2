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
		
		byte op = 0;
		do {
			System.out.println("Menu:");
			//System.out.println("0 - Productos de prueba");
			System.out.println("1 - Crear Producto");
			System.out.println("2 - Mostrar productos");
			System.out.println("3 - Modificar producto");
			System.out.println("4 - Salir");
			System.out.print("Ingrese una opción: ");
			boolean opcionValida = false;
			while(!opcionValida) {
				try {
					op = sc.nextByte();
					if (op > 0 && op < 5) {
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
					System.out.println("-- Alta de producto --");
					System.out.print("Ingrese código del producto: ");
					String codigo = sc.nextLine();
					while(codigo.isBlank()) {
						System.out.println("El código no puede ser vacío.");
						System.out.print("Ingrese código del producto: ");
						codigo = sc.nextLine();
					}
					
					System.out.print("Ingrese descripción del producto: ");
					String descripcion = sc.nextLine();
					while(descripcion.isBlank()) {
						System.out.println("La descripción no puede ser vacía.");
						System.out.print("Ingrese descripción del producto: ");
						descripcion = sc.nextLine();
					}
					
					System.out.print("Ingrese precio del producto (ej. 700.5): ");
                    double precio = 0;
					boolean precioValido = false;
					while(!precioValido) {
						String precioDestinoString = sc.nextLine();
						try {
							precio = Double.parseDouble(precioDestinoString);
							
							if (precio > 0) { 
								precioValido = true;
							}else {
								System.out.print("Por favor ingrese un precio válido (ej. 700.5): ");
							}
						} catch (NumberFormatException e) {
							System.out.print("Por favor ingrese un precio válido (ej. 700.5): ");
						}
					}
					
					System.out.println("---- Origen de fabricación ----");
					for (int i = 0; i < OrigenFabricacion.values().length; i++) {
						System.out.println((i+1) + " - " + OrigenFabricacion.values()[i]);
					}
					
					OrigenFabricacion origenFabricacion = ValidarOrigenFabricacion(sc);
					
					System.out.println("---- Categoría ----");
					for (int i = 0; i < Categoria.values().length; i++) {
						System.out.println((i+1) + " - " + Categoria.values()[i]);
					}
					Categoria categoria = ValidarCategoria(sc);
					
					Producto producto = new Producto(codigo, descripcion, precio, origenFabricacion, categoria);
					
					listaProductos.add(producto);
					break;
				case 2:
					if (!ListaTieneElementos(listaProductos)) break;
					
					for (Producto prod : listaProductos) {
						System.out.println(prod);
					}
					break;
				case 3:
					if (!ListaTieneElementos(listaProductos)) break;
					
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
					origenFabricacion = ValidarOrigenFabricacion(sc);
					
					productoModificar.setOrigenFabricacion(origenFabricacion);
					
					System.out.println("---- Categoría ----");
					for (int i = 0; i < Categoria.values().length; i++) {
						System.out.println((i+1) + " - " + Categoria.values()[i]);
					}
					categoria = ValidarCategoria(sc);
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
	
	private static boolean ListaTieneElementos(ArrayList<Producto> productos) {
    	if(productos.size() == 0) {
    		System.out.println("\nNo existen productos agregados. Por favor dé de alta un producto.");
			return false;
		}
    	
    	return true;
    }
	
	private static OrigenFabricacion ValidarOrigenFabricacion(Scanner sc) {
		boolean origenFabricacionValido = false;
		int origenFabricacionTamanio = OrigenFabricacion.values().length;
		byte opcion = 0;
		String msj = "Ingrese Origen de fabricación del producto [1 - " + origenFabricacionTamanio +"]: ";
		System.out.print(msj);
		while(!origenFabricacionValido) {
			try {
				String origenFabricacionString = sc.nextLine();
				opcion = Byte.parseByte(origenFabricacionString);
				if (opcion > 0 && opcion <= origenFabricacionTamanio) {
					origenFabricacionValido = true;
				}else {
					System.out.print("Opción Inválida. " + msj);
				}
			}catch(Exception ex){
				System.out.print("Opción Inválida. " + msj);
			}
		}
		
		return OrigenFabricacion.values()[opcion-1];
	}
	
	private static Categoria ValidarCategoria(Scanner sc) {
		boolean categoriaValida = false;
		int categoriaTamanio = OrigenFabricacion.values().length;
		byte opcion = 0;
		String msj = "Ingrese Categoría del producto [1 - " + categoriaTamanio +"]: ";
		System.out.print(msj);
		while(!categoriaValida) {
			try {
				String origenFabricacionString = sc.nextLine();
				opcion = Byte.parseByte(origenFabricacionString);
				if (opcion > 0 && opcion <= categoriaTamanio) {
					categoriaValida = true;
				}else {
					System.out.print("Opción Inválida. " + msj);
				}
			}catch(Exception ex){
				System.out.print("Opción Inválida. " + msj);
			}
		}
		
		return Categoria.values()[opcion-1];
	}
}