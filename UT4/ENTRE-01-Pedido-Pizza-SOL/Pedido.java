
/**
 * Modela un pedido que incluye tres pizzas
 *  
 */
public class Pedido
{
    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;

    /**
     * Constructor de objetos de la clase Pedido
     * Crea el pedido con las tres pizzas  
     * La primera pizza se crea con el primer constructor
     *      (pizza "Mexicana")
     * La segunda pizza se crea con el segundo constructor
     *      (pizza "Margarita" con 5  ingredientes)
     * La tercera pizza se crea con el tercer constructor
     *      (pizza "Tres quesos" con 4 ingredientes y tamaño mediana)
     */
    public Pedido()
    {
        pizza1 = new Pizza("Mexicana");
        pizza2 = new Pizza("Margarita", 5);
        pizza3 = new Pizza("Tres quesos", 4, 2);

    }

    /**
     *   devuelve el importe total del pedido
     */
    public double getImporteTotal()
    {
        return  pizza1.calcularPrecioTotal() + 
                pizza2.calcularPrecioTotal() + 
                pizza3.calcularPrecioTotal();
    }

    /**
     * 
     * Devuelve la pizza más barata
     * en el pedido
     *  
     *  Usa el método masBarataQue() de Pizza
     */
    public Pizza masBarata()
    {
        Pizza barata = null;        
        if (pizza1.masBarataQue(pizza2)) {
            barata = pizza1;           
        }
        else {
            barata = pizza2;     
        }
        if (pizza3.masBarataQue(barata)) {
            barata = pizza3;
        }
        return barata;
    }

    /**
     * Mostrar los datos del pedido actual (ver figura) 
     * Los resultados han de quedar como indica la figura
     * 
     * La columna izquierda está ajustada a la derecha en
     * 15 posiciones y la columna derecha está ajustada a la derecha en 10
     * posiciones
     * El importe total aparece formateado a 2 decimales

     * Al final se muestra una copia de la primera pizza y
     * la pizza más barata
     */
    public void printPedido()
    {
        System.out.printf("%15s%10.2f€\n",
            "Precio pizza 1:", pizza1.calcularPrecioTotal());
        System.out.printf("%15s%10.2f€\n",
            "Precio pizza 2:",  pizza2.calcularPrecioTotal());
        System.out.printf("%15s%10.2f€\n",
            "Precio pizza 3:",  pizza3.calcularPrecioTotal());
        System.out.printf("%15s%10.2f€\n",
            "Total pedido:", this.getImporteTotal());

        System.out.println("--------------------");
        System.out.println("Copia de la pizza 1\n" +
            pizza1.obtenerCopia().toString());

        System.out.println("--------------------");
        System.out.println("Pizza más barata\n" +
            masBarata().toString());
    }
}
