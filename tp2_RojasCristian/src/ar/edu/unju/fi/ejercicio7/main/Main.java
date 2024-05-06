package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto;
import ar.edu.unju.fi.ejercicio7.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio7.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		// ejercicio 7

		List<Producto> productos = new ArrayList<>();
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 15; i++) {
			int idProd = (i+1);
			byte randomCategoria = (byte)rand.nextInt(4);
			byte randomOrigen = (byte)rand.nextInt(4);
			boolean randomBoolean = rand.nextBoolean();
			Producto producto = new Producto(String.valueOf(idProd), "Producto "+idProd, (double)Math.round((rand.nextDouble(1000)*100))/100, OrigenFabricacion.values()[randomOrigen], Categoria.values()[randomCategoria], randomBoolean);
			productos.add(producto);
		}
		
		byte op = 0;
		do {
			System.out.println("--- MENÚ ---");
			System.out.println("1 - Mostrar Productos con stock");
			System.out.println("2 - Mostrar Productos sin stock");
			System.out.println("3 - Incrementar 20% el precio de los productos");
			System.out.println("4 - Mostrar los productos de categoría Electrohogar que posean stock");
			System.out.println("5 - Ordenar los productos por precio de forma descendente");
			System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
			System.out.println("7 - Salir");
			String msj = "Ingrese una opción: ";
			System.out.print(msj);
			while(true) {
				try {
					op = sc.nextByte();
					sc.nextLine();
					if (op > 0 && op < 8) break;
					MostrarMensajeError(msj);
				}catch (Exception ex){
					MostrarMensajeError(msj);
					sc.nextLine();
				}
			}
			
			System.out.println();
			
			switch (op) {
				case 1:
					Consumer<Producto> printConsumer = c -> {
						if (c.getEstado()) {
							System.out.println(c);							
						}
					};
					
					productos.forEach(printConsumer);
					break;
				case 2:
					Predicate<Producto> filtroEstadoFalso = c -> !c.getEstado();
					productos.stream().filter(filtroEstadoFalso).forEach(System.out::println);
					break;
				case 3:
					Function<Producto, Producto> funcionIncrementar = p -> {
						p.setPrecioUnitario((double)Math.round((p.getPrecioUnitario()*1.20*100))/100);
						return p;
					};
					
					List<Producto> productosIncrementados = productos;
					productosIncrementados = productos.stream().map(funcionIncrementar).collect(Collectors.toList());
					productosIncrementados.forEach(System.out::println);
					break;
				case 4:
					Predicate<Producto> filtroCategoriaConStock = c -> c.getCategoria() == Categoria.ELECTROHOGAR && c.getEstado();
					productos.stream().filter(filtroCategoriaConStock).forEach(System.out::println);
					break;
				case 5:
					productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
					productos.forEach(System.out::println);
					break;
				case 6:
					Function<Producto, Producto> funcionMayusculas = p -> {
						p.setDescripcion(p.getDescripcion().toUpperCase());
						return p;
					};
					
					productos.stream().map(funcionMayusculas).forEach(System.out::println);
					break;
				case 7:
					System.out.println("Saliendo del programa..");
					break;
			}
			
			System.out.println();
			
		}while(op != 7);
		
		sc.close();
	}

	private static void MostrarMensajeError(String msj) {
		System.out.print("Opción inválida. " + msj);
	}
}
