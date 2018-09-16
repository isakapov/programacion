/**
 * Una clase que representa automóviles.
 * 
 */
public class Coche
{
    private String modelo; // Ford Focus, Citrone X-Sara, ...
    private String color;
    private int año;
    
    /**
     * Constructor para los objetos de la clase Coche.
     * @param  queModelo el modelo del coche
     * @param  queColor el color del coche
     * @param  queAño el año de fabricación del coche
     * 
     */
    public Coche(String queModelo, String queColor, int queAño)
    {
        modelo = queModelo;
        color = queColor;
        año = queAño;
    }

    /**
     * cambiar el modelo del coche
     * @param  mod el coche modelo del coche
     */
     public void setModelor(String  mod)
    {
        modelo = mod;
    }   
 
    /**
     * cambiar el color del coche
     * @param  col el color del coche
     */
    public void setColor(String col)
    {
        color = col;
    }     
  
    /**
     * cambiar el año del coche
     * @param  an el año de fabricación del coche
     */
    public void setAño(int an) 
    {
        año = an;
    } 
    
    /**
     * visualizar la información del coche
     */
    public void print()
    {
        System.out.println("Modelo " + modelo + "\nAño " + año + 
                           "\nColor " + color + ".");
    }    
   
    /**
     * devolver el modelo del coche
     * @return el modelo del coche
     */
    public String getModelo() 
    { 
        return modelo;
    }
  
    /**
     * devolver el color del coche
     * @return el color del coche
     */
    public String getColor()
    { 
        return color;
    }
  
    /**
     * devolver el año del coche
     * @return el año del coche
     */
    public int getAño() 
    { 
        return año;
    }
    
    /**
     * 
     *
     * @param  unCoche el coche a comparar con el actual
     * @return true si los coches que se comparan son iguales   
     */
    public boolean igualQue(Coche unCoche)
    {
        
        return (this.modelo.equals(unCoche.getModelo()) &&
               this.color.equals(unCoche.getColor()) &&
               this.año == unCoche.getAño());
    }
    
    

}
