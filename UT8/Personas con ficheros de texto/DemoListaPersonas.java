import java.io.IOException;
/**
 *  Esta clase nos sirve para probar las clases ListaPersonas y Persona
 *  
 *  1º Instancia un objeto de esta clase
 *  2º Llama al método demoAdd()
 *  3º llama al método demoEscribir()
 *  4º llama a demoSalvarEnFicheroDeTexto() 
 *  5º llama al método demoVaciar()
 *  6º llama a leerDeFicheroDeTexto()
 *  7º llama al método demoEscribir()
 *  
 *      
 */
public class DemoListaPersonas
{
     private ListaPersonas lista;

    /**
     * Constructor  
     */
    public DemoListaPersonas()
    {
         lista = new ListaPersonas();
    }

    /**
     *  
     */
    public void demoAdd()
    {
         lista.add(new Persona("Pepe", 34, 's'));
         lista.add(new Persona("Ana", 14, 'c'));
         lista.add(new Persona("Luis", 23, 's'));
         lista.add(new Persona("Juan", 50, 'd'));
         lista.add(new Persona("Elena", 22, 's'));
         
    }
    
     
      /**
     *  
     */
    public void demoSalvarEnFicheroDeTexto() throws IOException
    {
         lista.guardarEnFicheroDeTexto();
         
    }
    
    /**
     * 
     */
    public void demoLeerDeFicheroDeTexto()
    {
        lista.leerDeFicheroDeTexto();
        
    }
    
   
    /**
     * 
     */
    public void demoLeerDeFicheroDeTextoConScanner()
    {
        lista.leerDeFicheroDeTextoConScanner();
        
        
    }
    
    /**
     *  
     */
    public void demoVaciar()
    {
         lista.clear();
         
    }
    
     /**
     *  
     */
    public void demoEstadisticas() throws IOException
    {
         lista.guardarEstadisticas();
         
    }
      /**
     *  
     */
    public void demoEscribir()
    {
         lista.mostrar();
         
    }
    
}
