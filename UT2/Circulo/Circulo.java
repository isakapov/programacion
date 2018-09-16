
/**
 *  
 * Modela un círculo de un
 * determinado radio
 * @author  
 * @version  
 */
public class Circulo
{
     
    private double radio;

    /**
     * Constructor  
     */
    public Circulo(double queRadio)
    {
         radio = queRadio;
    }

    /**
     *  
     * 
     * @param   
     * 
     */
    public double getRadio()
    {
         return radio;
    }
    
    /**
     * 
     */
    public  double calcularArea()
    {
        double area;
        area = 1 * 3.1416 * radio;
        return area;
    }

}
