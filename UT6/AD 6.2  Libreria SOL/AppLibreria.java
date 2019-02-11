
/**
 * Prueba de la aplicaci�n
 */
public class AppLibreria
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Error en argumentos, Sintaxis: java AppLibreria <nombre-libreria>");
        }
        else {
            Libro l1 = new Libro("La colmena", "Camilo Jos� Cela", 150);
            Libro l2 = new Libro("Madame Bovary", "Gustave Flaubert", 400);
            Libro l3 = new Libro("Anna Karenina", "Tolstoi", 1000);
            Libro l4 = new Libro("Mi vida querida", "Alice Munro", 336);
            Libro l5 = new Libro("Escapada", "Alice Munro", 336);
            Libreria libreria = new Libreria("La librer�a");
            libreria.addLibro(l1);
            libreria.addLibro(l2);
            libreria.addLibro(l3);
            libreria.addLibro(l1);
            libreria.addLibro(l4);
            libreria.addLibro(l2);
            libreria.addLibro(l5);
            System.out.println("Despu�s de a�adir varios libros\n" +
                libreria.toString());

            libreria.prestarTitulo("La Colmena");
            libreria.prestarTitulo("Mi vida querida");
            libreria.prestarTitulo("Piel de lobo");
            System.out.println("\nDespu�s de prestar varios libros\n" +
                libreria.toString());

            String autor = "Dolores Redondo";
            if (!libreria.hayLibrosDe(autor))
            {
                System.out.println("No hay libros de " + autor);
            }
            System.out.println();
            autor = "Alice munro";
            libreria.borrarLibrosDe(autor);
            System.out.println("Despu�s de borrar los libros de " +
                autor + " \n" + libreria.toString());
        }
    }
}
