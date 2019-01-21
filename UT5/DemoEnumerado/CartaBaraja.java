
/**
 * clase CartaBaraja  
 * 
 *  
 */
public class CartaBaraja
{
  
    private  Palo palo;
    private int valor;

    /**
     * Constructor  
     */
    public CartaBaraja(int valor, Palo palo)
    {
         this.palo = palo;
         this.valor = valor;
    }

    /**
     *  Accesor para el palo
     */
    public Palo  getPalo()
    {
         return palo;
    }
    
    /**
     *  Accesor para el valor
     */
    public int   getValor()
    {
         return valor;
    }
    
    /**
     *  Representación textual de la carta
     * 
     */
    public String toString()
    { 
        return valor + " de " +  palo.toString();
    }
    
    /**
     * 
     */
    public  void valoresDelTipo()
    {
        Palo[] palos = Palo.values();
        for (int i = 0; i < palos.length; i++) {
            System.out.println(palos[i].toString());
        }
    }


}