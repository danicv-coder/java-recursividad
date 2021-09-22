package org.danicv.recursividad;

import java.util.stream.Stream;

import org.danicv.recursividad.models.Componente;

public class EjemploRecursividad {

	public static void main(String[] args) {
		Componente pc = new Componente("Gabine pc ATX");
		Componente poder = new Componente("Fuente de poder 700w");
		Componente placaMadre = new Componente("mainBoard Asus  sockets AMD");
		Componente cpu = new Componente("cpu AMD Ryzen 5 2800");
		Componente ventilador = new Componente("Ventilador CPU");
		Componente disipador = new Componente("Disipador");
		Componente gpu = new Componente("Nvidia RTX 3080 8GB");
		Componente ram = new Componente("4GB Ram");
		Componente ram2 = new Componente("4GB Ram");
		Componente discoDuro = new Componente(" Disco SSD 2T");

		cpu.addComponetes(ventilador).addComponetes(disipador);
		gpu.addComponetes(ram).addComponetes(ram2);
		placaMadre.addComponetes(discoDuro).addComponetes(ram.addComponetes(ram2)).addComponetes(gpu);
		pc.addComponetes(poder).addComponetes(placaMadre).addComponetes(new Componente("Teclado"))
				.addComponetes(new Componente("Mouse"));

		metodoRecursivo(pc, 0);
	}

	public static void metodoRecursivo(Componente c, int nivel) {
		System.out.println("\t".repeat(nivel) + c.getNombre());
		if (c.tieneHijos()) {
			for (Componente hijo : c.getHijos()) {
				metodoRecursivo(hijo, nivel + 1);
			}
		}
	}

//	public static Stream<Componente> metodoRecursivoJava8(Componente c, int nivel) {
//		c.setNivel(nivel);
//		return Stream.concat(Stream.of(c))
//		c.getHijos().stream().flatMap(hijo -> metodoRecursivoJava8(hijo, nivel + 1));   
//	}
}
