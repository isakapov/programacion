
/**
 * Representa a objetos Ordenador 
 * 
 *  
 */
public class Ordenador
{
    // m�xima cantidad de memoria en Mb que puede tener instalada
    private int maxMemoria;
    // memoria actualmente instalada en Mb
    private int memoriaInstalada;

    /**
     * constructor para los objetos de la clase Ordenador
     * @param maximaMemoria la memoria m�xima que va a ser instalada
     */
    public Ordenador(int maximaMemoria)
    {
        if (maximaMemoria <= 0)
        {
            maxMemoria = 1024;
        }           
        else
        {
            maxMemoria = maximaMemoria;
        }
        memoriaInstalada = 0;
    }

    /**
     * devolver la m�xima memoria que puede tener instalada
     * 
     * @return  la m�xima cantidad de memoria que puede tener
     *          el ordenador
     */
    public int getMaxMemoria()
    {
        return maxMemoria;
    }

    /**
     * Devolver la memoria que puede ser instalada todav�a
     * @return  la memoria disponible
     */
    public int obtenerMemoriaDisponible()
    {
        return  (maxMemoria - memoriaInstalada);
    }

    /**
     * vaciar la memoria, m�todo mutador
     *  
     */
    public void vaciarMemoria()
    {
        memoriaInstalada = 0;
    }

    /**
     * Escribir informaci�n sobre el ordenador
     */
    public void printInformacion()
    {
        System.out.println("El ordenador puede tener c�mo m�ximo " + maxMemoria +
            " Mb instalados");
        System.out.println("El ordenador tienen instalados " + memoriaInstalada +
            " Mb ");                  
        System.out.println("Se puede instalar todav�a " + (maxMemoria - memoriaInstalada) +
            " Mb instalados");
    }

    /**
     * Instalar 256 Mb de memoria 
     * @return true si la memoria se ha instalado
     *          false en otro caso
     */
    public boolean instalar256Mb()
    {
        boolean exito;
        if (maxMemoria - memoriaInstalada >= 256)
        {
            memoriaInstalada += 256;
            exito = true;
        }
        else
        {
             exito = false;
        }           
        return exito;
    }

    /**
     * Instalar la cantidad de memoria que se pasa como 
     * argumento (en Mb) si es posible
     * @param cuanta la cantidad de memoria a instalar
     * @return true si la memoria se ha instalado
     *          false en otro caso
     */ 
    public boolean instalarMemoria(int cuanta)
    {
        boolean exito;
        if (cuanta > 0 && (maxMemoria - memoriaInstalada) >= cuanta)
        {
            memoriaInstalada += cuanta;
            exito = true;
        }
        else
        {
            exito = false;
        }            
        return exito;
    }

}

