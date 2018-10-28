
/**
 * Representa a un cuadrado con un centro y un lado
 */
public class Cuadrado
{
     private Punto centro;
     private double lado;

    /**
     * Constructor  
     */
    public Cuadrado()
    {
         centro = new Punto();
         lado = 0;
    }
    
     /**
     * Constructor  
     */
    public Cuadrado(int queX, int queY, int queLado)
    {
         centro = new Punto(queX, queY);
         lado = queLado;
    }
    
      /**
     * Constructor  
     */
    public Cuadrado(Punto queCentro, int queLado)
    {
         // centro = queCentro;
         centro = new Punto(queCentro.getX(), queCentro.getY());
         lado = queLado;
    }
    
    /**
     *  
     */
    public String toString()
    {
        return "Punto: " + centro.toString() +
                "\nLado: " + String.format("%7.2f", lado);
    }


    
}
