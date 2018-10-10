
/**
 * Modela a objetos Calculadora que registran una serie de n�s y
 * calculan la media, el m�ximo y el m�nimo
 * 
 *  
 */
public class Calculadora
{
    private int cantidad; // cantidad de n�s introducidos
    private double suma; // suma de todos los n�s
    private int maximo; // el valor m�ximo de los n�s introducidos
    private int minimo;  // el valor m�nimo de los n�s introducidos

    /**
     * constructor para los objetos de la clase Calculadora
     */
    public Calculadora()
    {
        cantidad = 0;
        suma = 0;
        maximo = 0;
        minimo = 0;
    }

    /**
     * a�ade un n� a la calculadora
     * 
     * @param  el n� a a�adir   
     */
    public void addNumero(int numero)
    {
        this.suma += numero;
        cantidad++;
        if (cantidad == 1)
        {
            maximo = numero;
            minimo = numero;
        }
        else
        {
            if (numero > maximo)
            {
                maximo = numero;
            }
            else if (numero < minimo)
            {
                minimo = numero;
            }
        }
    }
    
    private double getMedia()
    {
        return ( (double) suma / cantidad );
    }
    
    /* Escribir las estad�sticas
     * 
     */
    public void printEstadisticas()
    {
        System.out.println("Estad�stica final ");
        System.out.println("N� total del n�s introducidos: " + cantidad);
        System.out.println("Suma total de los  n�s introducidos: " + suma);
        System.out.println("Valor m�ximo: " + maximo);
        System.out.println("Valor m�nimo: " + minimo);
       // System.out.println("Media de todos los n�s: " + getMedia());   
        System.out.printf("Media de todos los n�s: %f ", getMedia()); 
    }
}
