/**
 * La clase modela una lista de personas
 * 
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ListaPersonas 
{
    private static final String NOMBRE_FICHERO = "personas.txt";
    private List<Persona> personas;

    public ListaPersonas()
    {
        personas = new ArrayList<>();

    }

    /**
     * añade una persona a la lista
     */
    public void add(Persona p)
    {

        personas.add(p);

    }

    /**
     * vacía la lista
     */
    public void clear()
    {
        personas.clear();
    }

    /**
     * guarda en un fichero de texto los datos de cada persona
     * Recorreremos la lista y guardaremos por cada persona sus 
     * datos en el fichero. Escribirimeos una línea
     * de texto por cada persona con formato nombre:edad:estado
     * 
     * 
     * Usa las clases PrintWriter, BufferedWriter, FileWriter  
     * 
     * Hay que propagar las excepciones, no capturarlas
     */
    public void guardarEnFicheroDeTexto() throws IOException
    {

        PrintWriter salida = null;
        File f = new File(NOMBRE_FICHERO);
        if (f.exists())    {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
        }
        else  {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        }
        for (Persona p : personas)   {
            salida.println(p.getNombre() + ":" +
                p.getEdad() + ":" +
                p.getEstadoCivil());
        }
        salida.close();

    }

    /**
     * Lee del fichero de texto  una a una las líneas de datos que 
     * contienen los datos de cada persona. Cada línea se parsea
     * (según el separador utilizado, en nuestro caso los :) y 
     * se crea un objeto Persona que añadiremos a la lista
     * Usa las clases  BuffererReader, FileReader  
     * 
     * Hay que capturar las excepciones generadas
     */
    public void leerDeFicheroDeTexto()
    {
        BufferedReader entrada = null;
        try        {
            File f = new File(NOMBRE_FICHERO);
            entrada = new BufferedReader(new FileReader(f));
            String linea = entrada.readLine();
            while (linea != null)
            {
                Persona persona = parsearLinea(linea);
                this.add(persona);
                linea = entrada.readLine();
            }

        }
        catch (IOException e)    {
            System.out.println(e.getMessage());
        }
        finally   {
            if (entrada != null)   {
                try               {
                    entrada.close();
                }
                catch (IOException e)   {
                    System.out.println(e.getMessage());
                }
            }

        }

    }

    /**
     *  Parsea la línea, es decir, extrae de la línea la información
     *  de una persona
     */
    private Persona parsearLinea(String linea)
    {
        String[] datos = linea.split(":");
        return new Persona(datos[0].trim(), 
            Integer.parseInt(datos[1].trim()),
            datos[2].trim().charAt(0));
    }

    /**
     * Lee del fichero de texto  una a una las líneas de datos que 
     * contienen los datos de cada persona. Cada línea se parsea
     * (según el separador utilizado, en nuestro caso los :) y 
     * se crea un objeto Persona que añadiremos a la lista
     * Usa la clase  Scanner
     * 
     * Hay que capturar las excepciones generadas
     */
    public void leerDeFicheroDeTextoConScanner()
    {
        Scanner entrada = null;
        try    {
            File f = new File(NOMBRE_FICHERO);
            // Scanner entrada = new Scanner(new FileReader(f));    
            entrada = new Scanner(f); 
            while (entrada.hasNextLine())    {
                String linea = entrada.nextLine();
                Persona persona = parsearLinea(linea);
                this.add(persona);                 

            }

        }
        catch (IOException e)  {

            System.out.println(e.getMessage());
        }
        finally {
            if (entrada != null)  {
                entrada.close();
            }

        }

    }

    /**
     *  Guarda en el fichero "estadis.txt" la relación de personas solteras
     *  y el nº total de ellas
     *
     *  Se propagan (se avisa)  las excepciones que puedan ocurrir
     */
    public void guardarEstadisticas( ) throws IOException
    {

        File f = new File("estadis.txt");
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
        salida.println("Relación de personas solteras ");
        int solteras = 0;
        for (Persona p : personas) {
            if (p.estaSoltera())            {
                salida.println(p.toString());
                solteras++;
            }
        }
        salida.printf("Total personas solteras %4d", solteras);
        salida.close();

    }

    /**
     * representación textual de la lista de personas
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Lista de personas\n");
        for (Persona p : personas)    {
            sb.append(p.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Mostrar la lista
     */
    public void mostrar()
    {
        System.out.println(this.toString());
    }

    public static void main(String args[]) throws IOException
    {
        ListaPersonas lista = new ListaPersonas();   
        lista.add(new Persona("Pepe", 34, 's'));
        lista.add(new Persona("Ana", 14, 'c'));
        lista.add(new Persona("Luis", 23, 's'));
        lista.add(new Persona("Juan", 50, 'd'));
        lista.add(new Persona("Elena", 22, 's'));

        lista.guardarEnFicheroDeTexto();

        // lista.leerDeFicheroDeTexto();
        // lista.mostrar();
        // lista.clear();

        // lista.leerDeFicheroDeTextoConScanner();
        // lista.mostrar();

        // lista.clear();

        

    }
}
