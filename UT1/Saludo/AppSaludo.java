
/**
 * La clase principal que incluye el m�todo main e 
 * inicia el proyecto
 * 
 */
public class AppSaludo
{
   
    /**
     * Punto de entrada a la aplicaci�n
     */
    
    public static void main(String[] args)
    {
        GeneradorSaludos generador = new GeneradorSaludos();
        generador.emitirSaludo();
    }

   
}
