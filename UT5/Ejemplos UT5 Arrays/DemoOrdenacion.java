import java.util.Arrays;

/**
 *  
 *   
 */
public class DemoOrdenacion
{

    /**
     * Constructor  
     */
    public DemoOrdenacion()
    {

    }

    /**
     *  Ordenar en orden ascendente
     */
    public void  ordenarSeleccionDirecta(int[ ] array)
    {

        for  (int i = 0; i < array.length - 1; i++)
        {
            int posmin = i;
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[posmin])
                {
                    posmin = j;
                }
            }
            int aux = array[posmin];
            array[posmin] = array[i];
            array[i] = aux;
        }
    }

    /**
     *  Ordenar en orden ascendente
     */
    public void  ordenarInsercionDirecta(int[ ] array)
    {

        for  (int i = 1; i < array.length; i++)
        {
            int aux = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > aux)
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
    }

    /**
     *  Ordenar en orden ascendente
     */
    public void  ordenarBurbuja(int[ ] array)
    {

        for  (int i = 0; i < array.length - 1; i++)
        {
            for  (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    /**
     *  
     */
    public   static void main(String[] args)
    {
        DemoOrdenacion demo = new DemoOrdenacion();
        int[] array1 = {2, 1, 5, 3, 6, 4};
        demo.ordenarInsercionDirecta(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {2, 1, 5, 3,6, 4};
        demo.ordenarSeleccionDirecta(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {2, 1, 5, 3,6, 4};
        demo.ordenarBurbuja(array3);
        System.out.println(Arrays.toString(array3));
    }

}
