import java.util.Comparator;

/**
 *  
 * 
 *  Esta clase encapsula un nuevo criterio de ordenación del país, 
 *  en orden ascendente de superficie
 */
public class ComparadorSuperficie implements Comparator<Pais>
{

    /**
     *   
     * 
     */
    public int compare(Pais p1, Pais p2)
    {

        if (p1.getSuperficie() < p2.getSuperficie())    {
            return -1;
        }
        if (p1.getSuperficie() > p2.getSuperficie())   {
            return 1;
        }
        return 0;

        // return (int) (Math.signum(p1.getSuperficie() - p2.getSuperficie()));
    }
}

