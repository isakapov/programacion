
/**
 * Un objeto de esta clase representa a una
 * aplicación que se descarga desde una tienda on-line
 * Para cada aplicación se guarda el nombre, la categoría a la que
 * pertenece y la cantidad de  descargas que ha tenido
 */
public class Aplicacion
{
    private String nombre;
    private int descargas;
    private Categoria categoria;

    /**
     *  Constructor - recibe los datos de una aplicación en
     *  una cadena de caracteres con el formato "nombre:descargas:categoria". 
     *  Ejemplo, "Netflix : 6500 : cine". 
     *  A partir de esta cadena se parsea la información y
     *  se asignan los valores a los atributos.
     *  Se eliminarán todos los posibles espacios a izquierda / derecha de cada dato
     *  
     *  El nombre se guarda siempre en mayúsculas
     */
    public Aplicacion(String linea)
    {
        String[] tokens = linea.split(":");
        this.nombre = tokens[0].trim().toUpperCase();
        this.descargas = Integer.parseInt(tokens[1].trim());
        this.categoria = Categoria.valueOf(tokens[2].trim().toUpperCase());

    }

    /**
     * Accesor  para el nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Accesor para las descargas
     */
    public int getDescargas()
    {
        return descargas;
    }

    /**
     * Accesor para la categoría
     */
    public Categoria getCategoria()
    {
        return categoria;
    }

    /**
     * Incrementar las descargas 
     */
    public void descargar()
    {
        descargas++;

    }

    /**
     * Representación textual de la aplicación
     */

    public String toString()
    {
        return nombre + "\n" + "Categoría: " + String.format("%10s", this.categoria) + 
        "\tDescargas: " + String.format("%6d", descargas) + "\n";
    }
}
