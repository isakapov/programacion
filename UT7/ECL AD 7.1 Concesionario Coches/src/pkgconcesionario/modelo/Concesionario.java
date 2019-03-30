
package pkgconcesionario.modelo;

import java.awt.Point;
/**
 * Clase Concesionario 
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Concesionario
{

	private String nombre;
	private List<Coche> coches;

	/**
	 * Constructor de la clase Concesionario
	 */
	public Concesionario(String n) {

		nombre = n;
		coches = new ArrayList<>();
	}

	/**
	 * acccsor para el nombre del concesionario
	 */
	public String getNombre() {

		return nombre;
	}

	/**
	 * Añade un c
	 */
	public void añadir(Coche c) {

		if (!coches.contains(c)) {
			coches.add(c);
		}
		else {
			System.out.println("Hay un coche de las mismas características");
		}

	}

	/**
	 * Borrar del concesionario los coches del conductor indicado por el
	 * parámetro quien
	 */
	public void borrarDeConductor(String quien) {

		Iterator<Coche> it = coches.iterator();
		while (it.hasNext()) {
			Coche coche = it.next();
			if (coche.getConductor().equalsIgnoreCase(quien)) {
				it.remove();
			}

		}

	}

	/**
	 * listado del concesionario
	 */
	public void listarCoches() {

		for (Coche c : coches) {
			System.out.println(c.toString() + "\n");
		}

	}

	/**
	 * 
	 * borrar del concesionario los taxis
	 */
	public void borrarTaxis() {

		Iterator<Coche> it = coches.iterator();
		while (it.hasNext()) {
			Coche coche = it.next();
			if (coche instanceof Taxi) {
				it.remove();
			}

		}
	}

	/**
	 * avanzar todos los coches
	 */
	public void avanzarTodos() {

		for (Coche c : coches) {
			c.avanza();
		}

	}

	/**
	 * Leer del fichero de texto "concesionario.txt" los datos de cada coche y
	 * añadirlos al concesionario Hacerlo con Scanner El formato de la línea en
	 * el fichero será tipocoche:conductor:modelo:color para tipocoche 'E'
	 * (económico) Si tipocoche es 'T' (deportivo) entonces la línea es
	 * tipocoche:conductor:modelo:color:posx:posy Cuando se trate de un taxi la
	 * línea será tipocoche:conductor:modelo:color:posx:posy
	 * 
	 * Con ayuda del método privado parsearLinea() extraeremos los datos de un
	 * coche Captura las excepciones
	 */
	public void leerConcesionarioDeFicheroTexto() {

		Scanner entrada = new Scanner(
		                this.getClass().getResourceAsStream(
		                                "/concesionario.txt"));
		while (entrada.hasNextLine()) {
			String linea = entrada.nextLine();
			Coche coche = parsearLinea(linea);
			añadir(coche);
		}
		entrada.close();

	}

	/**
	 * parsea una línea de texto extrayendo los datos y devolviendo un objeto
	 * Coche
	 */
	private Coche parsearLinea(String linea) {

		String[] datos = linea.split(":");
		String nombre = datos[1];
		String modelo = datos[2];
		String color = datos[3];

		char tipo = datos[0].charAt(0);
		if (tipo == 'D') {
			return new CocheDeportivo(nombre, modelo, color);
		}
		int x = Integer.parseInt(datos[4]);
		int y = Integer.parseInt(datos[5]);
		if (tipo == 'T') {
			return new Taxi(nombre, modelo, color, new Point(x, y),
			                Integer.parseInt(datos[6]));
		}
		return new CocheEconomico(nombre, modelo, color, new Point(x, y));
	}

	/**
	 * obtiene un listado ordenado por nombre de conductor especificando además
	 * el tipo de coche que posee. No se modifica la colección de coches Usando
	 * un comparador
	 */
	public void listarOrdenadoConductor() {

		List<Coche> tmp = new ArrayList<>(this.coches);
		//		Collections.sort(tmp, new Comparator<Coche>() {
		//
		//			public int compare(Coche c1, Coche c2) {
		//
		//				return c1.getConductor().compareTo(c2.getConductor());
		//			}
		//		});

		Collections.sort(tmp,
		                (c1, c2) -> c1.getConductor()
		                                .compareTo(c2.getConductor()));

		for (Coche coche : tmp) {
			System.out.println(coche.getConductor() + "("
			                + coche.getClass().getSimpleName() + " )");
		}
	}

}
