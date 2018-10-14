
/**
 * clase TresNumeros 
 * Ejercicio 15 UT3
 */
public class TresNumeros
{
    private int numero1;
    private int numero2;
    private int numero3;

    /**
     * Constructor de objetos de la clase TresNumeros
     */
    public TresNumeros(int n1, int n2, int n3)
    {
        numero1 = n1;
        numero2 = n2;
        numero3 = n3;
    }

   
    /**
     * Usando variables auxiliares y comparando de dos en dos
     * @return el m�ximo de los tres
     * 
     */
    public int getMaximo()
    {
        int mayor;
        if (numero1 > numero2)
        {
            mayor = numero1;
        }
        else 
        {
            mayor = numero2;
        }
        if (numero3 > mayor) 
        {
            mayor = numero3;
        }
        return mayor;
    }
    
    
    /**
     * Versi�n 2
     * 
     * 
     */
    public int getMaximoV2()
    {
        int mayor;
        if (numero1 > numero2 && numero1 > numero3)
        {
            mayor = numero1;
        }
        else if (numero2 > numero1 && numero2 > numero3)
        {
            mayor = numero2;
        }
        else
        {
            mayor = numero3;
        }
        return mayor;
    }

     /**
     * @return el m�nimo de los tres
     * 
     */
    public int getMinimo()
    {
        int menor;
        if (numero1 < numero2)
        {
            menor = numero1;
        }
        else 
        {
            menor = numero2;
        }
        if (numero3 < menor) 
        {
            menor = numero3;
        }
        return menor;
    }

   

   
    /**
     *  Devuelve true si los 3 n�s son igusles, false en otro caso
     */
    public boolean sonIguales()
    {
        if (numero1 != numero2)
        {
            return false;
        }
        if (numero1 != numero3)
        {
            return false;
        }
        return true;
    }

    /**
     * 
     */
    public int cuantosPares()
    {
        int pares = 0;
        if (numero1 % 2 == 0)
        {
            pares++;
        }
        if (numero2 % 2 == 0)
        {
            pares++;
        }
        if (numero3 % 2 == 0)
        {
            pares++;
        }
        return pares;
    }

    /**
     * 
     */
    public int cuantosAcabanEn7()
    {
        int enSiete = 0;
        if (Math.abs(numero1 % 10) == 7)
        {
            enSiete++;
        }
        if (Math.abs(numero2 % 10) == 7)
        {
            enSiete++;
        }
        if (Math.abs(numero3 % 10) == 7)
        {
            enSiete++;
        }
        return enSiete;
    }
    
     /**
     * Ordenar los tres n�meros
     *
     * 
     */
    public void ordenar()
    {
        
        if (numero1 > numero2)
        {
            int tmp = numero1;
            numero1 = numero2;
            numero2 = tmp;
        }
        if (numero1 > numero3)
        {
            int tmp = numero1;
            numero1 = numero3;
            numero3 = tmp;
        }
        if (numero2 > numero3)
        {
            int tmp = numero2;
            numero2 = numero3;
            numero3 = tmp;
        }
    }

}
