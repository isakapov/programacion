/**
 * Esta clase mantiene informaci�n sobre un libro.
 * Podr�a formar parte de una aplicaci�n m�s grande
 * como un sistema que gestionase una librer�a, por ejemplo.
 *
 * @author 
 * @version 
 */
public class Libro
{
    private String autor;
    private String titulo;
    private int numeroPaginas;
    private String numeroReferencia;
    private int vecesPrestado;

    /**
     * constructor de obkjetos Libro
     */
    public Libro(String queAutor, String queTitulo,
                 int quePaginas)
    {
        autor = queAutor;
        titulo = queTitulo;
        numeroPaginas = quePaginas;
        numeroReferencia = "";
        vecesPrestado = 0;
    }
    
    /**
     * Accesor para el autor
     * @return   el autor del libro
     */
    public String getAutor()
    {
        return autor;       
    }

     /**
     * Accesor para el t�tulo
     * @return   el t�tulo del libro
     */
    public String getTitulo()
    {
        return titulo;        
    }
    
     /**
     * Accesor para el n� de p�ginas
     * @return   el n� de p�ginas
     */
    public int getPaginas()
    {
        return numeroPaginas;        
    }
    
     /**
     * Accesor para el n� de referencia
     * @return   el n� de referencia
     */
    public String getReferencia()
    {
        return numeroReferencia;        
    }
    
      /**
     * Accesor para el n� de veces que
     * se ha presatdo el libro
     * @return   el n� de veces prestado
     */
    public int getVecesPrestado()
    {
        return vecesPrestado;        
    }
    
     /**
     * Mutador para el n� de referencia
     * @param  queReferencia   la nueva referencia del libro
     */
    public void setReferencia(String queReferencia)
    {
        numeroReferencia = queReferencia;   
    }
    
    /**
     * Prestar el libro
     * Es un mutador, cambia el valor del
     * atributo vecesPrestado
     */
    public void prestar()
    {
        vecesPrestado++;
    }
    
    
    /**
     * Muestra el autor en pantalla
     */
    public void printAutor()
    {
        System.out.println("Autor " + autor);      
    }
    
    /**
     * Muestra el t�tulo en pantalla
     */
    public void printTitulo()
    {
        System.out.println("T�tulo " + titulo);      
    }
    
     /**
     * Mostrar la informaci�n del libro
     */
    public void printDetalles()
    {
        System.out.println("T�tulo: " + titulo +
                           "\nAutor: " + autor +
                            "\nN� de p�ginas: " + numeroPaginas + 
                            "\nN� de referencia: " + numeroReferencia +
                            "\nN� de veces prestado: " + vecesPrestado);  
       
    }
    
    

}
