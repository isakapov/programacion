import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * La clase representa a una tienda on-line desde
 * la que se descargan aplicaciones
 * Un objeto de esta clase guarda en un array las aplicaciones
 * que tiene
 *  
 */
public class Tienda
{
    private String nombre;
    private Aplicacion[] aplicaciones;
    private int pos;

    /**
     * Constructor  
     * Crea el array al tamaño máximo indicado por la constante
     * e inicializa el resto de atributos
     */
    public Tienda(String nombre, int n)
    {
        this.nombre = nombre;
        aplicaciones = new Aplicacion[n];
        pos = 0;
    }

    /**
     * Devuelve true si el array está completo, false en otro caso
     */
    public  boolean estaCompleto()
    {
        return pos == aplicaciones.length;
    }

    /**
     *    Añade una nueva aplicación siempre en primera posición.
     *    Se añade si el array no está completo y no existe ya otra 
     *    aplicación con el mismo nombre   
     *    Si no se puede añadir se muestra un mensaje
     */
    public void add(Aplicacion aplicacion)
    {
        if (!estaCompleto()) {
            int p = estaAplicacion(aplicacion.getNombre());
            if (p == -1)             {
                System.arraycopy(aplicaciones, 0, aplicaciones, 1, pos);
                aplicaciones[0] = aplicacion;   
                pos ++;
            }
            else {
                System.out.println("Ya existe la aplicación " + aplicacion.getNombre());
            }
        }
        else {
            System.out.println("La tienda está completa ");
        }

    }

    /**
     * Efectúa una búsqueda lineal en el array de la aplicación cuyo nombre se
     * recibe como parámetro. Indiferente mayúsculas y minúsculas
     * Si existe devuelve su posición, si no existe devuelve -1
     */
    public  int estaAplicacion(String nombre)
    {
        for (int i = 0; i < pos; i++) {
            if (aplicaciones[i].getNombre().equalsIgnoreCase(nombre))  {
                return i;
            }
        }
        return -1;

    }

    /**
     *  Simula la descarga de una aplicación cuyo nombre se pasa como parámetro
     *  Si existe la aplicación se descarga (aumenta en 1 el nº de descargas), si no
     *  existe se emite el  mensaje "No se puede descargar la aplicación XXXXX"
     *  Indiferente mayúsculas y minúsculas
     */
    public  void descargar(String nombre)
    {
        int p = estaAplicacion(nombre); 
        if (p != -1) {
            aplicaciones[p].descargar();
        }
        else {
            System.out.println("No se puede descargar la aplicación " + nombre );
        }

    }

    /**
     * Devuelve un array con los nombres de las aplicaciones 
     * que van alfabéticamente después del argumento proporcionado.
     * Indiferente mayúsculas o minúsculas
     * 
     * El array se devuelve todo en mayúsculas y ordenado ascendentemente
     */
    public  String[] mayoresQue(String nombre)
    {
        String[] mayores = new String[pos];
        int total = 0;
        for (int i = 0; i < pos; i++)    {
            if (aplicaciones[i].getNombre().compareToIgnoreCase(nombre) > 0) {
                mayores[total] = aplicaciones[i].getNombre();
                total++;
            }
        }
        mayores = Arrays.copyOf(mayores, total);
        Arrays.sort(mayores);
        return mayores;

    }

    /**
     * Borra las aplicaciones de la categoría indicada devolviendo
     * el nº de aplicaciones borradas
     */
    public  int borrarDeCategoria(Categoria categoria)
    {
        int borradas = 0;
        for (int i = pos - 1; i >=0; i--)    {
            if (aplicaciones[i].getCategoria().equals(categoria)) {
                System.arraycopy(aplicaciones, i + 1, aplicaciones, i, pos - i - 1);
                borradas++;
                pos--;
            }
        }
        return borradas;

    }

    /**
     * Representación textual de la tienda
     * Utiliza StringBuilder como clase de apoyo.
     * Se incluye el nombre de la tienda.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("\nAplicaciones disponibles en la tienda " +
                nombre + "\n");
        for (int i = 0; i < pos; i++)   { 
            sb.append(aplicaciones[i].toString() + "\n");
        }
        return sb.toString();

    }

    /**
     * Lee de un fichero de texto los datos de las aplicaciones
     *   con ayuda de un objeto de la  clase Scanner
     *   y los guarda en el array. 
     */
    public void cargarDeFichero() 
    {
        try  {
            Scanner sc = new Scanner(new File("tienda.txt"));
            while (sc.hasNextLine())     {
                Aplicacion aplicacion = new Aplicacion(sc.nextLine());
                add(aplicacion);

            }
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
