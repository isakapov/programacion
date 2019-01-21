
/**
 * Interfaz texto para interactuar con el usuario.
 * 
 * Un objeto de esta clase nos permitirá leer
 * valores para guardarlos en la clase
 * ArraySinRepetidos
 *  UT5 Ej.5.19
 */
import java.util.Scanner;
public class InterfazUsuario
{
    private ArraySinRepetidos unArray;
    private Scanner teclado;

    /**
     * Constructor 
     */
    public InterfazUsuario()
    {
        teclado = new Scanner(System.in);
        unArray = new ArraySinRepetidos();
    }

    /**
     * Permite pedir datos al usuario hasta introducir un 0
     * o hasta que el objeto unArray esté completo
     */
    public void ejecutar()
    {

        System.out.println("Introduce un valor, pulsa 0 para terminar");
        int valor = teclado.nextInt();
        while (valor != 0 && !(unArray.estaCompleto()))     {
            unArray.insertar(valor);
            if (!unArray.estaCompleto())   {
                System.out.println("Introduce un valor, pulsa 0 para terminar");
                valor = teclado.nextInt();
            }
        }
        printArray();

        // --------------------------
        System.out.println("Introduce posición para insertar");
        int p = teclado.nextInt();
        System.out.println("Introduce valor a insertar");
        valor = teclado.nextInt();
        unArray.insertar(p, valor);
        printArray();
        // --------------------------

        borrarArray();
        // --------------------------

        System.out.println("Introduce un valor, pulsa 0 para terminar");
        valor = teclado.nextInt();
        while (valor != 0 && !(unArray.estaCompleto()))
        {
            unArray.insertarEnOrden(valor);
            if (!unArray.estaCompleto())
            {
                System.out.println("Introduce un valor, pulsa 0 para terminar");
                valor = teclado.nextInt();
            }
        }
        printArray();

    }

    /**
     * Muestra el array
     *  
     */
    private void printArray()
    {
        System.out.println("Array");
        System.out.println(unArray.toString());
    }

    /**
     * borrar el array
     *  
     */
    private void borrarArray()
    {
        System.out.println("Borrando elementos ....");
        unArray.clear();
        System.out.println("Borrados todos los elementos del array");
    }

}
