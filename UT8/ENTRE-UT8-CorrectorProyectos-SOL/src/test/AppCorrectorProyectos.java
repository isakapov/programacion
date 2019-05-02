package test;

import java.io.IOException;

import modelo.AlumnoNoExistenteExcepcion;
import modelo.CorrectorProyectos;

public class AppCorrectorProyectos
{

	public static void main(String[] args)
	{
		CorrectorProyectos corrector = new CorrectorProyectos();
		try {

			corrector.leerDatosProyectos();
			System.out.println(corrector.toString());
			System.out.println(corrector.getErrores().toString());

			System.out.println();

			System.out.println("Han aprobado el proyecto: "
			                + corrector.aprobados());

			System.out.println();

			corrector.guardarOrdenadosPorNota();

			String nombre = "JAvier".toUpperCase();
			System.out.println("Proyecto de " + nombre
			                + "\n" + corrector.proyectoDe(nombre));

			nombre = "Pablo".toUpperCase();
			System.out.println(corrector.proyectoDe(nombre));



		}
		catch (AlumnoNoExistenteExcepcion e) {
			System.out.println(e.toString());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
