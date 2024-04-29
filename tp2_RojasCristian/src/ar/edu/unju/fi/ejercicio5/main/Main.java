package ar.edu.unju.fi.ejercicio5.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		// ejercicio 5

		List<Producto> productos = new ArrayList<>();
		Random rand = new Random();

		DecimalFormat df = new DecimalFormat("#.##");
		df.setGroupingUsed(false);
		for (int i = 0; i < 15; i++) {
			int idProd = (i+1);
			Producto producto = new Producto("Prod"+idProd, "Descripcion"+idProd, Math.round(rand.nextDouble(1000)), OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true);
			productos.add(producto);
		}
		
		Scanner sc = new Scanner(System.in);
		byte op = 0;
		do {
			System.out.println("-- MENÚ --");
			System.out.println("1 - Mostrar Productos");
			System.out.println("2 - Realizar compra");
			System.out.println("3 - Salir");
			System.out.print("Elegir opción: ");
			op = sc.nextByte();
			sc.nextLine();
			switch (op) {
				case 1: {
					for (Producto producto : productos) {
						System.out.println(producto);
					}
					break;
				}
				case 2: {
					
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
			
		}while(op != 3);
		
		sc.close();
	}

}
