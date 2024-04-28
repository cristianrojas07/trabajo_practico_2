package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 3

		Provincia[] provincias = Provincia.values();

        for (Provincia provincia : provincias) {
            System.out.println("Provincia: " + provincia);
            System.out.println("Población: " + provincia.getPoblacion());
            System.out.println("Superficie: " + provincia.getSuperficie() + " km^2");
            System.out.println("Densidad poblacional: " + provincia.calcularDensidadPoblacional() + " hab/km^2");
            System.out.println();
        }
	}

}
