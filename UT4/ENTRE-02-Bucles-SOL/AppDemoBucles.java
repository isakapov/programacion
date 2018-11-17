import java.util.Scanner;

/**
 *  @author - 
 *  
 * Incluye todo el código dentro del main()
 * No declares ningún nuevo método en esta clase ni atributos
 *  
 */
public class AppDemoBucles
{

    /**
     *  Punto de entrada a la aplicación. Dentro del main:
     *  - define y crea el teclado  
     *  - define e instancia un objeto DemoBucles
     *  - pide la cantidad tope  máxima de aleatorios a generar
     *  - valida que ese tope esté entre 5 y 15
     *  - muestra los números generados y sus factores primos
     *  
     *  - haz una pausa y borra la pantalla 
     *  
     *  - muestra la tabla de precios tal como se indica en el enunciado
     *  
     *  
     */
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        DemoBucles demo = new DemoBucles();
        System.out.print("Teclee tope de aleatorios a generar: ");
        int tope = teclado.nextInt();
        while (tope < 5 || tope > 15) {
            System.out.print("Error, Teclee tope de aleatorios a generar: ");
            tope = teclado.nextInt();
        }
        System.out.println();
        demo.generarFactoresPrimos(tope);

        Utilidades.hacerPausa();
        Utilidades.borrarPantalla();

        demo.printTablaPrecios();
    }
}

