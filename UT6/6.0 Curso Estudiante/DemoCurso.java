
/**
 * Clase para probar las otras dos
 */
public class DemoCurso
{

    /**
     *   
     */
    public static void main(String[] args)
    {
        Curso daw = new Curso();
        daw.a�adirEstudiante("Luisa", 9);
        daw.a�adirEstudiante("Angel", 3);
        daw.a�adirEstudiante("Ana", 4);
        daw.a�adirEstudiante("Alberto", 8);
        System.out.println("Hay " + daw.cuantosAlumnos() +
            " alumnos");
        System.out.println(daw.toString());                      
        System.out.printf("La media es %4.2f" , daw.getMedia());  
        System.out.println("\nAlumno con nota m�xima " +
            daw.alumnoNotaMaxima());
        //                 daw.borrarPrimero();
        //                 System.out.println(daw.toString()); 
        //                 daw.borrarSuspensos();
        //                 System.out.println(daw.toString()); 
        int suspensoMasAlto = daw.suspensoMasAlto();
        if (suspensoMasAlto == 0)
        {
            System.out.println("No hay suspensos");
        }
        else
        {
            System.out.println("Suspenso m�s alto " + suspensoMasAlto); 
        }
        System.out.println("Dos notas m�s altas " + daw.dosNotasMasAltas()); 
    }

}
