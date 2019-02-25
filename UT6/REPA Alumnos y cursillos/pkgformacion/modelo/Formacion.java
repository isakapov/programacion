package pkgformacion.modelo;

import  java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

/**
 *  map con la relación de alumnos y su lista de cursillos asociados
 *  La clase en el map es el nombre del alumno, el valor asociado es una colección ArrayList
 *  de objetos Cursillo
 */
public class Formacion
{

    private TreeMap<String, ArrayList<Cursillo>> mapCursos;

    /**
     * Constructor  
     */
    public Formacion()
    {
        mapCursos = new TreeMap<>();
    }

    /**
     *  dado un nombre de alumno se añade un nuevo cursillo a su lista de cursos
     *  si la clave no existe se crea, si ya existe únicamente se añade el cursillo
     *   a la lista de cursillos siempre que éste no esté ya
     * 
     */
    public void addCursillo(String alumno, String curso, int horas)
    {
        Cursillo c = new Cursillo(curso, horas);
        alumno = alumno.toUpperCase();        
        if (!mapCursos.containsKey(alumno))      {
            ArrayList<Cursillo> cursos = new ArrayList<>();
            cursos.add(new Cursillo(curso, horas));
            mapCursos.put(alumno, cursos);
        }
        else    {
            ArrayList<Cursillo> cursos = mapCursos.get(alumno);
            if (!cursos.contains(c))   {
                mapCursos.get(alumno).add(c);
            }

        }
    }

    /**
     * dado un alumno obtener el total horas de cursillos realizadas por él
     * si el alumno no existe se devuelve -1
     * 
     */
    public  int totalHorasCursillosDe(String alumno)
    {
        alumno = alumno.toUpperCase(); 
        if (!mapCursos.containsKey(alumno))  {
            return -1;
        }
        ArrayList<Cursillo> cursillos = mapCursos.get(alumno); // obtener cursillos realizados por el alumno
        int horas = 0;
        for (Cursillo cursillo: cursillos)  {
            horas += cursillo.getHoras();
        }
        return horas;    
    }

    /**
     * Devuelve el nombre del alumno con más horas de cursillos realizadas
     *  
     */
    public String alumnoConMasHorasDeCursillos()
    {
        int max = 0;
        String strMax = "";
        Set<String> alumnos = mapCursos.keySet();
        for (String alumno: alumnos)  {
            int total = totalHorasCursillosDe(alumno);
            if (total > max) {
                strMax = alumno;
                max = total;
            }
        }
        return strMax;
    }

    /**
     * Mostrar cada alumno y nº total de cursillos realizados (usando keySet)
     */
    public  void alumnosTotalCursillos()
    {
        Set<String> claves = mapCursos.keySet();
        for (String clave: claves)    {
            System.out.println(clave + " Total cursos realizados " + mapCursos.get(clave).size());
        }
    }

    /**
     * Mostrar cada alumno y el  total de horas de
     * cursillos realizadss (usando Map.Entry)
     */
    public  void alumnosTotalHorasCursillos() 
    {
        Set<Map.Entry<String, ArrayList<Cursillo>>> entradas = mapCursos.entrySet();
        for (Map.Entry<String, ArrayList<Cursillo>> entrada: entradas)   {
            String alumno = entrada.getKey();
            System.out.println(alumno +
                " Horas cursillos realizadas: " + totalHorasCursillosDe(alumno));
        }
    }

    /**
     *  Representación textual del map mostrando
     *  cada alumno y los nombres de los cursillos realizados - Usando Map.Entry
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, ArrayList<Cursillo>>> entradas = mapCursos.entrySet();
        Iterator<Map.Entry<String, ArrayList<Cursillo>>> it = entradas.iterator();
        while (it.hasNext())   {
            Map.Entry<String, ArrayList<Cursillo>> entrada = it.next();
            sb.append(entrada.getKey() + "\n\tCursos:\t");
            for (Cursillo cursillo: entrada.getValue())      {
                sb.append(cursillo.getNombre() + "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * mostrar el map
     */
    public void mostrar()
    {
        System.out.println(this.toString());
    }

}
