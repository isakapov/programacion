package programacion.entregaut6.interfaz;

/**
 * Interfaz de texto
 *  
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import programacion.entregaut6.modelo.Texto;

public class IUConsola
{
	private static final int MOSTRAR_MAP = 1;
	private static final int CAPITALIZAR_ALTERNA = 2;
	private static final int CON_LETRAS_REPETIDAS = 3;
	private static final int BORRAR_DE_FRECUENCIA = 4;
	private static final int SALIR = 5;

	private Scanner teclado;
	private Texto texto;

	/**
	 * Constructor de la clase IUConsola
	 */
	public IUConsola()
	{
		teclado = new Scanner(System.in);
		texto = new Texto();
		texto.leerDeFichero();

	}

	/**
	 *  Incluye la lógica de la aplicación
	 *  
	 */
	public void iniciar()
	{

		int opcion = menu();
		while (opcion != SALIR) {
			switch (opcion) {
				case MOSTRAR_MAP:
					mostrarMap();
					break;
				case CAPITALIZAR_ALTERNA:
					capitalizarAlterna();
					break;
				case CON_LETRAS_REPETIDAS:
					conLetrasRepetidas();
					break;
				case BORRAR_DE_FRECUENCIA:
					borrarDeFrecuencia();
					break;

			}
			pausa();
			opcion = menu();
		}

	}

	/**
	 * Presenta el menú 
	 * @return  la opción seleccionada
	 */
	private int menu()
	{
		borrarPantalla();
		System.out.println("********************************************");
		System.out.println("Palabras de un texto agrupadas por letra\n");
		System.out.println("********************************************");
		System.out.println("1. Mostrar map");
		System.out.println("2. Capitalizar alterna");
		System.out.println("3. Palabras con letras repetidas");
		System.out.println("4. Borrar de frecuencia menor que");
		System.out.println("5. Salir");

		System.out.print("Teclea opción: ");
		int opcion = teclado.nextInt();
		while (!opcionValida(opcion)) {
			System.out.print("Opción incorrecta, Teclea opci�n: ");
			opcion = teclado.nextInt();
		}
		teclado.nextLine();
		return opcion;
	}

	/**
	 *  Devuelve true si la opción es correcta, false en otro caso
	 *
	 */
	private boolean opcionValida(int opcion)
	{
		return opcion >= MOSTRAR_MAP && opcion <= SALIR;
	}

	/**
	 * Muestra el map
	 */
	private void mostrarMap()
	{
		borrarPantalla();
		texto.escribir();
	}

	/**
	 * Muestra las palabras de una letra
	 * capitalizadas de forma alterna
	 */
	private void capitalizarAlterna()
	{
		System.out.print("Teclee letra: ");
		String linea = teclado.nextLine();
		while (linea.isEmpty()) {
			System.out.print("Teclee letra: ");
			linea = teclado.nextLine();
		}
		char letra = linea.charAt(0);

		ArrayList<String> resul = texto.capitalizarAlterna(letra);
		if (resul.size() != 0) {
			System.out.println(
			        "Después de capitalizar alternando\n" + resul.toString());
		}
		else {
			System.out.println("No existe esa letra en el map");
		}

	}

	/**
	 * Muestra las palabras con letras repetidas en el map
	 */
	private void conLetrasRepetidas()
	{
		TreeSet<String> resul = texto.palabrasConLetrasRepetidas();
		System.out
		        .println("Palabras con letras repetidas\n " + resul.toString());
	}

	/**
	 * borrar del map las palabras de una letra con una frecuencia menor que 
	 * la indicada
	 */

	private void borrarDeFrecuencia()
	{
		System.out.print("Teclea letra: ");
		char letra = teclado.nextLine().charAt(0);
		System.out.print("Teclea frecuecia: ");
		int frecuencia = teclado.nextInt();

		int resul = texto.borrarDeFrecuenciaMenor(letra, frecuencia);
		if (resul != -1) {
			System.out.println("Se han borrado " + resul
			        + " palabras en la letra " + letra);
			texto.escribir();
		}
		else {
			System.out.println("No existe esa letra en el map");
		}
		teclado.nextLine();
	}

	/**
	 * Borrar la pantalla
	 */
	private void borrarPantalla()
	{
		System.out.println("\u000C");

	}

	/**
	 * Hacer una pausa
	 */
	private void pausa()
	{
		System.out.println("Pulse <Intro> para continuar");
		teclado.nextLine();
	}
}
