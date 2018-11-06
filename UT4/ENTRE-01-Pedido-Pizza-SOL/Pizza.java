
/**
 * Un objeto de esta clase modela una pizza
 * Toda pizza tiene una denominaci�n, un n� de ingredientes y un tama�o
 * (1 - grande, 2, mediana, 3 - peque�a)
 * 
 */
public class Pizza
{
    private final int GRANDE = 1;
    private final int MEDIANA = 2;
    private final int PEQUE�A = 3;
    private final int PRECIO_GRANDE = 20; // precio base de la grande
    private final int PRECIO_MEDIANA = 15; // precio base de la mediana
    private final int PRECIO_PEQUE�A = 10; // precio base de la peque�a
    private final double PRECIO_INGREDIENTE = 1.15;  // precio de cada ingrediente
    private String denominacion; 
    private int ingredientes; // n� de ingredientes
    private int tama�o;

    /**
     * Constructor 1� de objetos de la clase Pizza
     * crea una pizza con la denominaci�n indicada,
     * como n� de ingredientes un valor aleatorio entre 3 y 8 (inclusive)
     * (usa Math.random()) y tama�o grande
     */
    public Pizza(String denominacion)
    {
        this.denominacion = denominacion;
        this.ingredientes = (int) (Math.random() * 6) + 3;
        this.tama�o = GRANDE;

    }

    /**
     * Constructor 2�  de objetos de la clase Pizza
     * crea una pizza con la denominaci�n e ingredientes indicados y
     * un tama�o aleatorio (1, 2 o 3)
     *  
     *  Asumimos los datos correctos
     */
    public Pizza(String denominacion, int ingredientes)
    {
        this.denominacion = denominacion;
        this.ingredientes = ingredientes;
        this.tama�o = (int) (Math.random() * (PEQUE�A - GRANDE) + 1) + GRANDE;
    }

    /**
     * Constructor de objetos de la clase Pizza
     * crea una pizza con la denominaci�n, ingredientes y
     * tama�o indicados
     *  
     *  Asumimos los datos correctos
     */
    public Pizza(String denominacion, int ingredientes, int tama�o)
    {
        this.denominacion = denominacion;
        this.ingredientes = ingredientes;
        this.tama�o = tama�o;
    }

    /**
     * 
     * Accesor para el  nombre de la pizza
     */
    public String getDenominacion()
    {
        return this.denominacion;
    }

    /**
     * 
     * Accesor para los ingredientes
     */
    public int getIngredientes()
    {
        return this.ingredientes;
    }

    /**
     * 
     * Accesor para el tama�o
     */
    public String getTama�o()
    {
        String strTam = "";
        switch (tama�o) {
            case GRANDE: strTam = "GRANDE";
            break;
            case MEDIANA: strTam = "MEDIANA";
            break;
            case PEQUE�A: strTam = "PEQUE�A";
            break;
        }
        return strTam;
    }

    /**
     * 
     * Mutador para los ingredientes
     */
    public void setIngredientes(int ingredientes)
    {
        this.ingredientes = ingredientes;
    }

    /**
     *  Calcula y devuelve el precio total de la pizza
     *  El precio de una pizza viene determinado por su precio base
     *  (seg�n su tama�o) m�s un plus que es el n� de ingredientes 
     *  por lo que cuesta cada ingrediente
     *  Utiliza una sentencia switch
     */
    public double calcularPrecioTotal()
    {
        double importe = 0.0;
        switch (tama�o) {
            case GRANDE: importe = PRECIO_GRANDE;
            break;
            case MEDIANA: importe = PRECIO_MEDIANA;
            break;
            case PEQUE�A: importe = PRECIO_PEQUE�A;
            break;
        }
        importe += ingredientes * PRECIO_INGREDIENTE;
        return importe;
    }

    /**
     * Devuelve true si la pizza actual es m�s barata
     * que la recibida como par�metro
     * Sin utilizar if
     */
    public boolean masBarataQue(Pizza otra)
    {
        return this.calcularPrecioTotal() < otra.calcularPrecioTotal();

    }

    /**
     *  Devuelve una copia del la pizza actual
     */
    public Pizza obtenerCopia()
    {
        Pizza copia = new Pizza(this.denominacion, this.ingredientes, 
                this.tama�o);
        return copia;
    }

    /**
     * 
     * Representaci�n textual de la pizza
     * Devuelve la denominaci�n, ingredientes, tama�o y precio formateados  
     * 
     * Hay que utilizar String.format() - La  columna de la izquierda 
     * est�  ajustada  a la derecha en un espacio de 15 posiciones
     * La  columna de la  derecha est�  ajustada  a la derecha en un espacio de 12
     * posiciones
     * El precio total se muestra  con 2 posiciones para decimales
     * (ver enunciado)
     */
    public String toString()
    { 
        String str = String.format("%15s%12s\n", "NOMBRE:", this.denominacion);
        str += String.format("%15s%12d\n", "INGREDIENTES:", this.ingredientes);
        str += String.format("%15s%12s\n", "TAMA�O:", this.getTama�o());
        str += String.format("%15s%12.2f�\n", "PRECIO TOTAL:", this.calcularPrecioTotal());
        return str;
    }

    /**
     * Mostrar datos de la pizza
     */
    public void printPizza()
    {
        System.out.println(toString());
    }

}
