
/**
 * Representa a una urna que contiene dos bolas
 */
public class Urna
{
    private Bola bola1;
    private Bola bola2;

    /**
     * Constructor  
     */
    public Urna()
    {
        bola1 = new Bola();
        bola2 = new Bola();
    }

    /**
     * Constructor  
     */
    public Urna(int c)
    {
        bola1 = new Bola(c);
        bola2 = new Bola(c);
    }

    /**
     * Constructor  
     */
    public Urna(Bola queBola1, Bola queBola2)
    {
        // bola1 = queBola1;
        // bola2 = queBola2;
        bola1 = new Bola(queBola1.getColor());
        bola2 = new Bola(queBola2.getColor());
    }


}
