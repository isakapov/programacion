import java.util.Arrays;
/**
 *  
 *   
 */
public class AppTienda
{

    /**
     *  Punto de entrada  
     *  - aceptar dos argumentos, el nombre de la tienda y el
     *  tamaño máximo del array (comprobar posibles errores y mensajes adecuados)
     *  - si todo es correcto crear la tienda y
     *      * carga desde el fichero los datos de las aplicaciones
     *      * mostrar la tienda
     *      * descargar la aplicación "wallapop" 3 veces, "Spotify Music" 2 veces y "Candy Crush" 1 vez
     *      * mostrar la tienda
     *      * mostrar los nombres de aplicaciones mayores que "netflix"
     *      * borrar las aplicaciones de la categoría JUEGOS
     *      * mostrar la tienda
     *  
     */
    public static void main(String[] args)
    {
        if (args.length != 2) {
            System.out.println("Error en nº de argumentos\n" +
                "Sintaxis: java AppTienda <nombre> <tam>");
        }
        else {
            Tienda tienda = new Tienda(args[0], Integer.parseInt(args[1]));
            tienda.cargarDeFichero();
            System.out.println(tienda.toString());

            tienda.descargar("wallapop");
            tienda.descargar("wallapop");
            tienda.descargar("wallapop");
            tienda.descargar("Spotify Music");
            tienda.descargar("Spotify Music");
            tienda.descargar("Candy Crush");
            tienda.descargar("2048");
            System.out.println("Después de descargar .... ");
            System.out.println(tienda.toString());

            String nombre = "netflix";
            String[] mayores = tienda.mayoresQue(nombre);
            System.out.println("\nLos nombres de aplicaciones alfabéticamente mayores que '" + 
                nombre + "' son\n" +  Arrays.toString(mayores) + "\n");

            Categoria categoria = Categoria.JUEGOS;
            int borrados = tienda.borrarDeCategoria(categoria);
            System.out.println("\nBorradas " + borrados + 
                " aplicaciones \nde la categoria '" + categoria.toString() + "'");
        }
    }
}
