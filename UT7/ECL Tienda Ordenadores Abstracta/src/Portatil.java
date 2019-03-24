
/**
 *   
 */
public   class Portatil extends Ordenador  
{
    private static final double DESCUENTO = 2;
    private double peso;

    /**
     * Constructor  
     */
    public Portatil(String codigo, double precio, double peso)
    {
         super(codigo, precio);
         this.peso = peso;
    }

    /**
     *  
     * 
     */
    public double getPeso()
    {
         return peso;
    }
    
      /**
     *  
     * 
     */
    public String getSlogan()
    {
         return "Ideal para viajes";
    }
    
    /**
     * 
     */
    public  void setPeso(double peso)
    {
        this.peso = peso;
    }
    
    /**
     * 
     */
    public double calcularDescuento()
    {
        return getPrecio() * DESCUENTO / 100;
    }

    
    /**
     * 
     */
    public  String toString()
    {
        return super.toString() + 
              "Peso: " + peso + "Kg.\n\n";
    }
}
