import java.util.Arrays;
/**
 *  
 * Clase de prueba de los métodos de Tienda
 */
public class DemoTienda
{

    private Tienda tienda;

    /**
     * Constructor  
     */
    public DemoTienda()
    {
        tienda = new Tienda("Play Store", 20);
    }

    /**
     *  Probamos los métodos add(), estaCompleto,  estaAplicacion() 
     * 
     */
    public void add()
    {
        tienda.cargarDeFichero();
        mostrartienda();

    }

    /**
     * Prueba de toString()
     */
    public  void mostrartienda()
    {
        System.out.println(tienda.toString() + "\n");
    }

    /**
     * Prueba de descargar()
     */
    public  void descargar()
    {
        tienda.descargar("wallapop");
        tienda.descargar("wallapop");
        tienda.descargar("Spotify Music");
        tienda.descargar("Spotify Music");
        tienda.descargar("Candy Crush");
        System.out.println("Después de descargar .... ");
        mostrartienda();
    }

    /**
     * Prueba de mayoresQue()
     */
    public  void mayoresQue()
    {
        String nombre = "netflix";
        String[] mayores = tienda.mayoresQue(nombre);
        System.out.println("\nLos nombres de aplicaciones alfabéticamente mayores que '" + nombre + "' son\n" + 
            Arrays.toString(mayores) + "'\n");
    }

    /**
     * Prueba de borrarDeCategoria()
     */
    public  void borrarDeCategoria()
    {
        Categoria categoria = Categoria.JUEGOS;
        int borrados = tienda.borrarDeCategoria(categoria);
        System.out.println("\nBorradas " + borrados + 
            " aplicaciones \nde la categoria '" + categoria.toString() + "'");
    }

}