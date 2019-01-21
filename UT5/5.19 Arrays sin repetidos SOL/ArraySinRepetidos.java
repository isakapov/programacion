import java.util.Arrays;

/**
 * Un objeto de esta clase contiene n�meros 
 * que no se repiten
 *   UT5 Ej.5.19
 */
public class ArraySinRepetidos
{
    private static final int MAX = 5;
    private int[]  elementos;
    private int siguiente;

    /**
     * Constructor 
     */
    public ArraySinRepetidos()
    {
        elementos = new int[MAX];
        siguiente = 0;
    }

    /**
     * A�ade un nuevo valor �nicamente si no est�
     * @param nuevoElemento el valor a a�adir

     */
    public void insertar(int nuevoElemento)
    {
        if (!estaCompleto())
        {
            if (!estaElemento(nuevoElemento))
            {
                elementos[siguiente] = nuevoElemento;
                siguiente++;
            }
        }

    }

    /**
     * A�ade un nuevo valor �nicamente si no est�
     * en la posici�n indicada
     * 
     * @param nuevoElemento el valor a a�adir
     * @param pos la posici�n en la que insertar
     */
    public void insertar(int pos, int nuevoElemento)
    {
        if (pos < 0 || pos > siguiente)    {
            System.out.println("Error, posici�n incorrecta");            
        }
        else if (!estaCompleto() && !estaElemento(nuevoElemento))   {
            for (int i = siguiente - 1; i >= pos;i--) {
                elementos[i + 1] = elementos[i];
            }
            elementos[pos] = nuevoElemento;
            siguiente++;
        }
    }


    /**
     * Detecta si el array est� completo
     * @return true si est� completo

     */
    public boolean estaCompleto()
    {
        return siguiente == MAX; 
    }

    /**
     *  Borra todos los elementos del array
     *
     */
    public void clear()
    {
        siguiente = 0;
    }

    /**
     * A�ade un nuevo valor �nicamente si no est�
     * y lo inserta en orden
     * @param nuevoElemento el valor a a�adir

     */
    public void insertarEnOrden(int nuevoElemento)
    {
        if (!estaCompleto())  {
            if (!estaElementoBinaria(nuevoElemento)) {
                int j = siguiente - 1;
                while (j >= 0 && elementos[j] > nuevoElemento) {
                    elementos[j + 1] = elementos[j];
                    j--;
                }
                elementos[j + 1] = nuevoElemento;
                siguiente++;
            }
        }

    }

    /**
     * Detecta si un valor est� o no en el array
     * Se hace una b�squeda dicot�mica
     * @param  numero el valor a buscar
     * @return   true si est� el valor, false en otro caso
     */
    public boolean estaElementoBinaria(int numero)
    {
        int izda = 0;
        int dcha = siguiente - 1;
        int i = 0;
        while (izda <= dcha)   {
            int mitad = (izda + dcha) / 2;
            if (elementos[mitad] == numero) {
                return true;
            }
            else if (elementos[mitad] > numero) {
                dcha = mitad - 1;
            }
            else {
                izda = mitad + 1;
            }
        }
        return false;
    }

    /**
     * Detecta si un valor est� o no en el array
     * Se hace una b�squeda dicot�mica con un m�todo de la clase Arrays
     * @param  numero el valor a buscar
     * @return   true si est� el valor, false en otro caso
     */
    public boolean estaElementoBinariaV2(int numero)
    {
        return Arrays.binarySearch(elementos, 0, siguiente, numero) >= 0;
    }

    /**
     * Detecta si un valor est� o no en el array
     * Se hace una b�squeda lineal
     * @param  numero el valor a buscar
     * @return   true si est� el valor, false en otro caso
     */
    public boolean estaElemento(int numero)
    {
        int i = 0;
        while (i < siguiente) {
            if (elementos[i] == numero) {
                return true;
            }
            else {
                i++;
            }
        }
        return false;
    }

    /**
     * Representaci�n textual de la forma {3, 4, 8, 5, 7, 9}

     */
    public String toString()
    {
        String tmp = "{";
        for (int i = 0; i < siguiente - 1; i++) {
            tmp += elementos[i] + ",\t";
        }
        tmp += elementos[siguiente - 1] + "}";    
        return tmp;
    }

}
