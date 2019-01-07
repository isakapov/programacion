
/**
 * La clase representa a una lista de 
 * n�meros enteros
 * 
 * @author - 
 * 
 */
import java.util.Arrays;

public class ListaNumeros 
{
    private static final char CARACTER = '#';
    private static final char ESPACIO = ' ';
    private int[] lista; // la lista de elementos
    private int pos; // n� real de elementos en la lista

    /**
     * Constructor de la clase ListaNumeros Crea e inicializa adecuadamente los
     * atributos
     * 
     * @param n el tama�o m�ximo de la lista
     */
    public ListaNumeros(int n) 
    {
        lista = new int[n];
        pos = 0;
    }

    /**
     * @param numero el valor que se a�ade al final de la lista. No se hace nada si
     *               la lista est� completa o ya est� el elemento
     * @return true si se ha podido a�adir, false en otro caso
     */
    public boolean addElemento(int numero)
    {
        if (estaCompleta()) {
            return false;
        }
        if (estaElemento(numero)) {
            return false;
        }

        lista[pos] = numero;
        pos++;
        return true;

    }

    /**
     * devuelve true si la lista est� completa, false en otro caso Hazlo sin if
     */
    public boolean estaCompleta()
    {
        return pos == lista.length;

    }

    /**
     * devuelve true si la lista est� vac�a, false en otro caso. Hazlo sin if
     */
    public boolean estaVacia() 
    {
        return pos == 0;

    }

    /**
     * B�squeda lineal de numero en la lista
     * 
     * devuelve true si existe ya un valor igual en la lista, false en otro caso
     */
    public boolean estaElemento(int numero) 
    {
        for (int i = 0; i < pos; i++) {
            if (lista[i] == numero) {
                return true;
            }

        }
        return false;

    }

    /**
     * devuelve el n� de elementos realmente guardados en la lista
     */
    public int getTotalNumeros()
    {
        return pos;

    }

    /**
     *  Hace una b�squeda binaria del numero indicado
     *  devolviendo -1 si no se encuentra o la posici�n
     *  en la que aparece
     *  
     *  El array original lista no se modifica
     *  Para ello crea previamente una copia de lista
     *  y trabaja con la copia
     *  
     *  Usa exclusivamente m�todos de la clase Arrays
     *  
     */
    public int buscarBinario(int numero)
    {

        int[] copia = Arrays.copyOf(lista, pos);
        Arrays.sort(copia);
        int p = Arrays.binarySearch(copia, numero);
        if (p < 0) {
            return -1;
        }
        return p;

    }

    /**
     * Vac�a la lista
     */
    public void vaciarLista() 
    {
        this.pos = 0;
    }

    /**
     * Representaci�n textual de la lista de la forma indicada 
     * Si lista = {175, 826, 89, 9, 41, 13, 72, 11, 23, 107}
     *  devuelve (0=>175, 1=>826, 2=>89, 3=>9, 4=>41, 5=>13,
     *  		 6=>72, 7=>11, 8=>23, 9=>107)
     * 
     * Si la lista est� vac�a devuelve ()
     */
    public String toString() 
    {
        String str = "(";
        for (int i = 0; i < pos - 1; i++) {
            str = str + i + " => " + lista[i] + " , ";
        }
        if (!estaVacia()) {
            str += (pos - 1) + " => " + lista[pos - 1];
        }
        str += ")\n";
        return str;
    }

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() 
    {
        System.out.println(this.toString());
    }

    /**
     * devuelve un nuevo array resultado de reemplazar
     * cada par de elementos consecutivos de lista por la suma del par.
     * 
     * La lista original no se modifica
     * 
     * Si lista =  {7, -2, 8, -9, 4, 13, -7, 1, 9, 10}
     * El primer par de lista se colapsa en  5 (7 + -2), 
     * el segundo par  en -1 (8 + -9)
     * 
     * Si el array guarda un n� impar de valores el �ltimo elemento no se colapsa 
     *      {11, -2, 3, -4, 5} obtiene al colapsar {9, -1, 5}
     */
    public int[] colapsar() 
    {
        int n = pos / 2 + pos % 2;

        int[] colapsado = new int[n];
        int tope = n;
        if (pos % 2 != 0) {
            colapsado[colapsado.length - 1] = lista[pos - 1];
            tope--;
        }
        for (int i = 0; i < tope; i++) {
            colapsado[i] = lista[2 * i] + lista[2 * i + 1];
        }
        
        return colapsado;
    }

    /**
     * Devuelve una cadena que representa un histograma horizontal
     * (ver enunciado)
     */
    public String histogramaHorizontal()
    {
        int maximo = obtenerMaximo();
        String histograma = "";
        for (int i = 0; i < pos; i++) {
            int valor = Math.abs(lista[i]);
            if (lista[i] < 0) {
                histograma += generarCaracteres(ESPACIO, maximo - valor);
                histograma += generarCaracteres(CARACTER, valor);
                histograma += obtenerValorFormateado(lista[i]);
            } else {
                histograma += generarCaracteres(ESPACIO, maximo);
                histograma += obtenerValorFormateado(lista[i]);
                histograma += generarCaracteres(CARACTER, valor);
            }
            histograma += "\n";
        }

        return histograma;
    }

    /**
     * calcula y devuelve el valor m�ximo de lista (en t�rminos absolutos)
     */
    private int obtenerMaximo()
    {
        int maximo = Integer.MIN_VALUE;
        for (int i = 0; i < pos; i++) {
            int elemento = Math.abs(lista[i]);
            if (elemento > maximo) {
                maximo = elemento;
            }
        }
        return maximo;
    }

    /**
     * 
     * @param valor
     * @return devuelve valor formateado a 4 posiciones de la forma
     *  	(  12)    o  (  -7)
     */
    private String obtenerValorFormateado(int valor) 
    {
        return String.format("(%4d)", valor);
    }

    /**
     * 
     * @param caracter
     * @param n
     * @return genera y devuelve una cadena con n veces el caracter
     */
    private String generarCaracteres(char caracter, int n)
    {
        String str = "";
        for (int i = 1; i <= n; i++) {
            str += caracter;
        }
        return str;
    }

    /**
     * devuelve un array de 2 dimensiones con tantas filas y columnas como valores
     * tenga el atributo lista y de la forma indicada (ver enunciado)
     * 
     */
    public int[][] toArray2D() 
    {
        int[][] array2D = new int[pos][pos];
        for (int f = 0; f < array2D.length; f++) {
            for (int c = 0; c < f; c++) {
                array2D[f][c] = 0;
            }
            for (int c = f; c < array2D[0].length; c++) {
                array2D[f][c] = lista[c];
            }

        }
        return array2D;
    }

    /**
     * Punto de entrada a la aplicaci�n
     * Contiene c�digo para probar los m�todos de ListaNumeros
     */
    public static void main(String[] args) 
    {
        ListaNumeros lista = new ListaNumeros(7);
        lista.addElemento(4);
        lista.addElemento(-5);
        lista.addElemento(6);
        lista.addElemento(-7);
        lista.addElemento(20);
        lista.addElemento(-17);
        lista.addElemento(12);
      //  lista.addElemento(15);

        System.out.println(lista.toString());
        int[] colapsado = lista.colapsar();
        System.out.println("Despu�s de colapsar: " + Arrays.toString(colapsado));
        
        System.out.println();

        System.out.println(lista.toString());
        System.out.println(lista.histogramaHorizontal());

        for (int[] fila : lista.toArray2D()) {
            System.out.println(Arrays.toString(fila));
        }

    }
}
