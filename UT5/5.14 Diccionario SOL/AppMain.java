
/**
 *  
 */
public class AppMain
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        Diccionario diccionario = new Diccionario(20);
        InterfazDiccionario interfaz =  new InterfazDiccionario(diccionario);
        interfaz.iniciar();
    }
}
