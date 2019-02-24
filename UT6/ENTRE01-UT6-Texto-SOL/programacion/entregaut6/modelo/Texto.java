package programacion.entregaut6.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import programacion.entregaut6.utils.Utilidades;

/**
 * Un objeto de esta clase mantiene una 
 * colección map que asocia  letras (las claves) con
 * la lista (una colección ArrayList) de objetos Palabra
 * que empiezan por esa letra. 
 * Por ej. una entrada del map asocia la letra 'M' con
 * una lista de palabras que empiezan por 'M'
 * 
 * Las claves en el map se recuperan en orden alfabético y son de tipo
 * Character y siempre se guardan en mayúsculas
 */

public class Texto
{

	private TreeMap<Character, ArrayList<Palabra>> mapTexto;

	/**
	 * Constructor 
	 */
	public Texto()
	{
		mapTexto = new TreeMap<>();
	}

	/**
	 * añadir una palabra al map
	 * Hay que comprobar si existe ya una clave (la primera letra de
	 * la palabra) en el map. Si es así se busca la palabra
	 *  en la lista de palabras asociadas a esa letra. 
	 *  Si la palabra está se incrementa su frecuencia, si no está
	 *  se crea un nuevo objeto Palabra y se añade a la lista
	 * 	 
	 *  Si la clave no existe se  crea una nueva entrada en el map asociando esa 
	 * letra (clave) a una nueva lista de palabras conteniendo la palabra
	 *  
	 * Las claves siempre se añaden en mayúsculas 
	 *  
	 */
	public void addPalabra(String pal)
	{
		char letra = Character.toUpperCase(pal.charAt(0));
		if (!mapTexto.containsKey(letra)) {
			Palabra p = new Palabra(pal);
			ArrayList<Palabra> lista = new ArrayList<>();
			lista.add(p);
			mapTexto.put(letra, lista);
		}
		else {
			ArrayList<Palabra> lista = mapTexto.get(letra);
			int pos = estaPalabra(lista, pal);
			if (pos == -1) {
				Palabra p = new Palabra(pal);
				lista.add(p);
			}
			else {
				lista.get(pos).incrementar();
			}

		}

	}

	/**
	 * añadir una palabra al map
	 * Hay que comprobar si existe ya una clave (la primera letra de
	 * la palabra) en el map. Si es así se busca la palabra
	 *  en la lista de palabras asociadas a esa letra. 
	 *  Si la palabra está se incrementa su frecuencia, si no está
	 *  se crea un nuevo objeto Palabra y se añade a la lista
	 * 	 
	 *  Si la clave no existe se  crea una nueva entrada en el map asociando esa 
	 * letra (clave) a una nueva lista de palabras conteniendo la palabra
	 *  
	 * Las claves siempre se añaden en mayúsculas 
	 *  
	 */
	public void addPalabraV2(String pal)
	{
		char letra = Character.toUpperCase(pal.charAt(0));
		ArrayList<Palabra> lista = mapTexto.get(letra);
		if (lista == null) {
			mapTexto.put(letra, new ArrayList<>());
		}
		lista = mapTexto.get(letra);
		int pos = estaPalabra(lista, pal);
		if (pos == -1) {
			Palabra p = new Palabra(pal);
			lista.add(p);
		}
		else {
			lista.get(pos).incrementar();
		}

	}

	/**
	 * Dada una lista de objetos Palabra y una palabra pal a buscar devuelve
	 * la posición donde se encuentra o -1 si no está
	 */
	private int estaPalabra(ArrayList<Palabra> lista, String pal)
	{
		for (int i = 0; i < lista.size(); i++) {
			Palabra palabra = lista.get(i);
			if (palabra.getPalabra().trim().equalsIgnoreCase(pal)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * añade las palabras del array al map 
	 * Hay que eliminar los posibles espacios a derecha
	 * e izquierda de cada palabra
	 *  
	 */
	public void addPalabras(String[] palabras)
	{
		for (String palabra : palabras) {
			if (!palabra.isEmpty()) {
				this.addPalabra(palabra.trim());
			}
		}

	}

	/**
	* Representación textual del map, cada letra junto con el  total
	* de palabras distintas que hay en ella y a 
	* continuación la relación de palabras
	* en esa letra (ver resultados de ejecución)
	* 
	* De forma eficiente ya que habrá muchas concatenaciones
	* 
	* Usa el conjunto de entradas y un iterador
	*/
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		Set<Map.Entry<Character, ArrayList<Palabra>>> entradas = mapTexto
		        .entrySet();
		Iterator<Map.Entry<Character, ArrayList<Palabra>>> it = entradas
		        .iterator();
		while (it.hasNext()) {
			Map.Entry<Character, ArrayList<Palabra>> entrada = it.next();
			ArrayList<Palabra> lista = entrada.getValue();
			sb.append(entrada.getKey());
			sb.append("(" + lista.size() + " palabra/s distinta/s)\n\t");
			for (int i = 0; i < lista.size(); i++) {
				Palabra palabra = lista.get(i);
				sb.append(palabra.toString());
				if ((i + 1) % 5 == 0) {
					sb.append("\n\t");
				}
			}
			sb.append("\n\n");
		}
		return sb.toString();

	}

	/**
	 * Dada una letra devuelve una nueva colección 
	 * con las mismas palabras de esa letra pero capitalizadas 
	 * de forma alterna
	 *  
	 * 
	 * Si la clave no existe se devuelve la colección  vacía
	 * 
	 * Hay que usar el método de la clase Utilidades capitalizarAlterna()
	 */
	public ArrayList<String> capitalizarAlterna(char letra)
	{
		ArrayList<String> resul = new ArrayList<>();
		letra = Character.toUpperCase(letra);
		if (!mapTexto.containsKey(letra)) {
			return resul;
		}
		ArrayList<Palabra> lista = mapTexto.get(letra);
		for (Palabra palabra : lista) {
			resul.add(Utilidades.capitalizarAlterna(palabra.getPalabra()));
		}
		return resul;

	}

	/**
	 *  Devuelve un conjunto (en orden alfabético) con  todas
	 *  las palabras que hay en el map que tienen letras repetidas
	 *   
	 *  
	 *  Hay que usar el método de la clase Utilidades tieneLetrasRepetidas()
	 *  
	 * Usar para recorrer el map el conjunto de claves.
	 */
	public TreeSet<String> palabrasConLetrasRepetidas()
	{
		TreeSet<String> resul = new TreeSet<>();
		for (char clave : mapTexto.keySet()) {
			ArrayList<Palabra> lista = mapTexto.get(clave);
			for (Palabra palabra : lista) {
				String pal = palabra.getPalabra();
				if (Utilidades.tieneLetrasRepetidas(pal)) {
					resul.add(pal);
				}
			}
		}
		return resul;

	}

	/**
	 *  Borra del map  las palabras de letra (clave) 
	 *  que tengan una frecuencia menor a la indicada
	 *  Si no existe la clave devuelve -1
	 *  
	 *  Hay que devolver el nº de palabras borradas
	 *  No se puede utilizar ninguna colección auxiliar
	 *  
	 */
	public int borrarDeFrecuenciaMenor(char letra, int frecuencia)
	{
		letra = Character.toUpperCase(letra);
		if (!mapTexto.containsKey(letra)) {
			return -1;
		}
		int borradas = 0;
		ArrayList<Palabra> lista = mapTexto.get(letra);
		Iterator<Palabra> it = lista.iterator();
		while (it.hasNext()) {
			Palabra palabra = it.next();
			if (palabra.getFrecuencia() < frecuencia) {
				it.remove();
				borradas++;
			}
		}
		return borradas;
	}

	/**
	 *  Lee de un fichero un texto formado por una 
	 *  serie de líneas. Cada línea contiene varias palabras
	 *   
	 */
	public void leerDeFichero()
	{
		Scanner sc = new Scanner(
		        this.getClass().getResourceAsStream("/texto.txt"));
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			String[] palabras = linea.split(" ");
			this.addPalabras(palabras);
		}
		sc.close();

	}

	/**
	 * Mostrar el mapa
	 */
	public void escribir()
	{
		System.out.println(this.toString());
	}

	public static void main(String[] args)
	{
		Texto texto = new Texto();
		texto.leerDeFichero();

		System.out.println(texto.toString());

		ArrayList<String> resul = texto.capitalizarAlterna('l');
		char letra = 'l';
		System.out.println("Después de capitalizar palabras de la letra "
		        + Character.toUpperCase(letra) + " " + resul.toString());

		System.out.println("\nPalabras con letras repetidas\n"
		        + texto.palabrasConLetrasRepetidas());

		int frecuencia = 2;
		System.out.println("\nDespués de borrar palabras de frecuencia < "
		        + frecuencia + " en la letra " + letra);
		int borradas = texto.borrarDeFrecuenciaMenor(letra, frecuencia);
		System.out.println("Se han borrado " + borradas + " palabras");
		System.out.println(texto.toString());

	}
}
