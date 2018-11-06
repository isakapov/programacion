
/**
 * Un objeto de esta clase modela una pizza
 * Toda pizza tiene una denominación, un nº de ingredientes y un tamaño
 * (1 - grande, 2, mediana, 3 - pequeña)
 * 
 */
public class Pizza
{
    private final int GRANDE = 1;
    private final int MEDIANA = 2;
    private final int PEQUEÑA = 3;
    private final int PRECIO_GRANDE = 20; // precio base de la grande
    private final int PRECIO_MEDIANA = 15; // precio base de la mediana
    private final int PRECIO_PEQUEÑA = 10; // precio base de la pequeña
    private final double PRECIO_INGREDIENTE = 1.15;  // precio de cada ingrediente
    private String denominacion; 
    private int ingredientes; // nº de ingredientes
    private int tamaño;

    /**
     * Constructor 1º de objetos de la clase Pizza
     * crea una pizza con la denominación indicada,
     * como nº de ingredientes un valor aleatorio entre 3 y 8 (inclusive)
     * (usa Math.random()) y tamaño grande
     */
    public Pizza(String denominacion)
    {
        this.denominacion = denominacion;
        this.ingredientes = (int) (Math.random() * 6) + 3;
        this.tamaño = GRANDE;

    }

    /**
     * Constructor 2º  de objetos de la clase Pizza
     * crea una pizza con la denominación e ingredientes indicados y
     * un tamaño aleatorio (1, 2 o 3)
     *  
     *  Asumimos los datos correctos
     */
    public Pizza(String denominacion, int ingredientes)
    {
        this.denominacion = denominacion;
        this.ingredientes = ingredientes;
        this.tamaño = (int) (Math.random() * (PEQUEÑA - GRANDE) + 1) + GRANDE;
    }

    /**
     * Constructor de objetos de la clase Pizza
     * crea una pizza con la denominación, ingredientes y
     * tamaño indicados
     *  
     *  Asumimos los datos correctos
     */
    public Pizza(String denominacion, int ingredientes, int tamaño)
    {
        this.denominacion = denominacion;
        this.ingredientes = ingredientes;
        this.tamaño = tamaño;
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
     * Accesor para el tamaño
     */
    public String getTamaño()
    {
        String strTam = "";
        switch (tamaño) {
            case GRANDE: strTam = "GRANDE";
            break;
            case MEDIANA: strTam = "MEDIANA";
            break;
            case PEQUEÑA: strTam = "PEQUEÑA";
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
     *  (según su tamaño) más un plus que es el nº de ingredientes 
     *  por lo que cuesta cada ingrediente
     *  Utiliza una sentencia switch
     */
    public double calcularPrecioTotal()
    {
        double importe = 0.0;
        switch (tamaño) {
            case GRANDE: importe = PRECIO_GRANDE;
            break;
            case MEDIANA: importe = PRECIO_MEDIANA;
            break;
            case PEQUEÑA: importe = PRECIO_PEQUEÑA;
            break;
        }
        importe += ingredientes * PRECIO_INGREDIENTE;
        return importe;
    }

    /**
     * Devuelve true si la pizza actual es más barata
     * que la recibida como parámetro
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
                this.tamaño);
        return copia;
    }

    /**
     * 
     * Representación textual de la pizza
     * Devuelve la denominación, ingredientes, tamaño y precio formateados  
     * 
     * Hay que utilizar String.format() - La  columna de la izquierda 
     * está  ajustada  a la derecha en un espacio de 15 posiciones
     * La  columna de la  derecha está  ajustada  a la derecha en un espacio de 12
     * posiciones
     * El precio total se muestra  con 2 posiciones para decimales
     * (ver enunciado)
     */
    public String toString()
    { 
        String str = String.format("%15s%12s\n", "NOMBRE:", this.denominacion);
        str += String.format("%15s%12d\n", "INGREDIENTES:", this.ingredientes);
        str += String.format("%15s%12s\n", "TAMAÑO:", this.getTamaño());
        str += String.format("%15s%12.2f€\n", "PRECIO TOTAL:", this.calcularPrecioTotal());
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
