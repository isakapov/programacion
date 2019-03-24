/**
 * La clase Articulo representa un artículo multimedia.
 * La información sobre el artículo se almacena y 
 * puede ser extraída.
 * Esta clase sirve como superclase para articulos más
 * específicos.
 */
public class Articulo
{
    private String titulo;
    private int duracionTotal;
    private boolean loTengo;
    private String comentario;

    /**
     * Inicializar los atributos del artículo
     */
    public Articulo(String elTitulo, int duracion)
    {
        titulo = elTitulo;
        duracionTotal = duracion;
        loTengo = false;
        comentario = "";
    }

    /**
     * Introducir un comentario del artículo
     */
    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }

    /**
     * Devolver el comentario del artículo
     */
    public String getComentario()
    {
        return comentario;
    }

   /**
     * Establecer el flag que indica si lo tengo o no
     * @param loTengo a true si lo poseo
     */
    public void setPropiedad(boolean loTengo)
    {
        this.loTengo = loTengo;
    }

    /**
     * @return true si  tengo el CD
     */
    public boolean getPropiedad()
    {
        return loTengo;
    }


    /**
     * accesor para la duración del artículo
     */
    public int getDuracion()
    {
        return duracionTotal;
    }

    /**
     * Escribir detalles sobre el artículo
     */
    public void print()
    {
        System.out.println("--------------------------");
        System.out.println("Título: " + titulo + " (" + duracionTotal + " mins)");
        if(loTengo)  {
            System.out.print(" * ");
        }        
        if (!comentario.isEmpty()) {
            System.out.println("\t" + comentario);
        }
    }
}
