package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		// ejercicio 6

		// conversión felino domestico a felino salvaje
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		FelinoSalvaje felino = converter.Convert(gato);
		converter.mostrarObjeto(felino);
		
		// conversión felino salvaje a felino domestico
		FelinoSalvaje felino2 = new FelinoSalvaje("Tanner", (byte)20, 186f);
		Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
		boolean noEsNulo = Converter.isNotNull(felino2);
		if(noEsNulo) {
			FelinoDomestico domestico = converter2.Convert(felino2);
			converter2.mostrarObjeto(domestico);
		}else {
			System.out.println("El objeto es nulo.");
		}
	}

}
