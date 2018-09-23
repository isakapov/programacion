
/**
 *  Modela una bombilla
 *  
 */
public class Bombilla
{

    private String potencia;
    private boolean estado;

    /**
     * Constructor  
     */
    public Bombilla(String quePotencia)
    {
        potencia = quePotencia;
        estado = false;
    }

    /**
     *  accesor para la potencia
     */
    public String getPotencia()
    {
        return potencia;
    }

    /**
     *  accesor para el estado
     */
    public boolean getEstado()
    {
        return estado;
    } 

    /**
     *  
     */
    public void cambiarEstado()
    {
        estado = !estado;
    }

     /**
     *  
     */
    public boolean estaEncendida()
    {
        return estado;

    }
    
    /**
     *  
     */
    public boolean estaApagada()
    {
        return !estado;
    }

    
    /**
     *  mostrar en pantalla los datos de la bombilla
     */
    public void printDatosBombilla()
    {
        System.out.println("Datos de la bombilla");
        System.out.println("Potencia: " + potencia);
        System.out.println("Estado (encendida?): " + estado);
    }
}
