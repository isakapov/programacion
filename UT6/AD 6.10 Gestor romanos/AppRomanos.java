import pkgromanos.GestorRomanos;
import pkgromanos.ConversorRomanos;
/**
 * La clase que inicia el gestor de romanos
 * 
 * 
 * Desde línea de comandos para crear el jar: jar -cvfe romanos.jar AppRomanos .
 * y para ejecutarlo java -jar romanos.jar I  V XII M II
 */
public class AppRomanos
{
    public static void main (String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Error, Sintaxis: java AppRomanos <romano1> <romano2> <romano3> ....");

        }
        else {       
            GestorRomanos gestor = new GestorRomanos(new ConversorRomanos());
            gestor.añadirRomanos(args);
            gestor.escribirListaArabigos();
        }

    }

        
}
