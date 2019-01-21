
/**
 * 
 */
public class Baraja
{
    public static final int MAX_CARTAS = 40;
    private CartaBaraja[] baraja;

    /**
     * Constructor  
     */
    public Baraja()
    {
        baraja = new CartaBaraja[MAX_CARTAS];
        inicializar();
    }

    /**
     *  
     */
    private void inicializar( )
    {
        Palo[] palos = Palo.values();
        for (int i = 0; i < palos.length; i++)
        {
            Palo p = palos[i];
            for (int valor = 1; valor <= 10; valor++)
            {
                CartaBaraja carta;
                if (valor <= 7)
				{
					carta = new CartaBaraja(valor, p);
				}
                    
                else
				{
					carta = new CartaBaraja(valor + 2, p);
				}
                    
                baraja[i * 10 + (valor - 1)] = carta;
            }
        }
    }

    /**
     *  
     *
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Baraja española\n");
        for (int i = 0; i < baraja.length; i++)
        {
            sb.append(baraja[i].toString()).append("\n");
        }
        return sb.toString();
    }
    
    /**
     *  
     *
     */
    public void printBaraja()
    {
        System.out.println(this.toString());
    }


}
