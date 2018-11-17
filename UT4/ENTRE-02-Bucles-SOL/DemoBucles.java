import java.util.Random;
/**
 *    @author - 
 */
public class DemoBucles
{
    private final char ESPACIO = ' ';
    private final double PRECIO_M2 = 20.50;
    private Random generador;

    /**
     * Constructor  
     */
    public DemoBucles()
    {
        generador = new Random();
    }

    /**
     *   Generar un máximo de n aleatorios o hasta que salga el nº 50
     *   Para cada nº aleatorio mostrar su descomposición en factores primos
     *  
     *  Cada nº aleatorio se muestra en un espacio de 8 posiciones en la pantalla
     *  ajustado a la derecha
     *  Cada factor primo se muestra en un espacio de 5 posiciones en la pantalla
     *  ajustado a la derecha
     *  
     *   Utiliza solo bucles while (!! atención a la condición de salida del while !!)
     */
    public void generarFactoresPrimos(int n)
    {
        System.out.println("Factores primos de diferentes números aleatorios\n" +
            "(Tope: " + n + " o hasta que salga el 50)\n");
        int aleatorio = generador.nextInt(91) + 10;
        int contador = 1;
        while (contador <= n && aleatorio!= 50) {
            System.out.print(String.format("%8d |", aleatorio));
            int factor = 2;
            int aux = aleatorio;
            while (aux > 1) {
                if (aux % factor == 0) {
                    System.out.print(String.format("%5d", factor));
                    aux = aux / factor;                    
                }
                else {
                    factor++;
                }
            }
            System.out.println();
            aleatorio = generador.nextInt(91) + 10;
            contador++;
        }

    }
    
    /**
     *  Genera la tabla de precios tal como indica la figura (ver enunciado)
     */
    public void printTablaPrecios()
    {
        System.out.printf("%6c", ESPACIO);
        for (int largo = 50; largo <= 300; largo = largo + 50) {
            System.out.printf("%10d",largo);
        }
        System.out.println("\n");
        for (int ancho = 100; ancho <= 240; ancho = ancho + 20) {
            System.out.printf("%6d", ancho);
            for (int largo = 50; largo <= 300; largo = largo + 50) {
                double superficie = ancho * largo;
                double coste = (superficie / 10000) * PRECIO_M2;
                System.out.printf("%10.2f", coste);
            }
            System.out.println();
        }

    }

}
