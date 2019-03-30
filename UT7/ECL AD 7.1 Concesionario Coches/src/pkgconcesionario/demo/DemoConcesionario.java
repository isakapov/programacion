package pkgconcesionario.demo;

import pkgconcesionario.modelo.Concesionario;

public class DemoConcesionario
{

	private Concesionario con;

	/**
	 * Constructor de la clase DemoConcesionario
	 */
	public DemoConcesionario(String nombre)
	{
		con = new Concesionario(nombre);
		con.leerConcesionarioDeFicheroTexto();

	}

	/**
	 *  
	 */
	public void demoListarCoches()
	{
		con.listarCoches();

	}

	/**
	 *  
	 */
	public void demoAvanzar()
	{
		con.avanzarTodos();

	}

	/**
	 *  
	 */
	public void demoBorrarDeConductor(String conductor)
	{
		con.borrarDeConductor(conductor);
	}

	/**
	 *  
	 */
	public void demoBorrarTaxis()
	{

		con.borrarTaxis();

	}

	/**
	 *  
	 */
	public void demoListarOrdenadoConductor()
	{

		con.listarOrdenadoConductor();

	}

	/**
	 * Aceptar como argumento el nombre del concesionario y - listar el
	 * concesionario - avanzar todos los coches y volver a listar - mostrar el
	 * listado ordenado por conductor - borrar los del conductor "Jesus" -
	 * listar el concesionario - borrar los taxis - listar el concesionario
	 */
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println(
			        "Error en nº argumentos\n Sintaxis: java DemoConcesionario <nombre>");

		}
		DemoConcesionario demo = new DemoConcesionario(args[0]);
		demo.demoListarCoches();

		System.out.println("\nAvanzando todos los coches ...");
		demo.demoAvanzar();
		demo.demoListarCoches();

		System.out.println("\nListado ordenado por conductor ...");
		demo.demoListarOrdenadoConductor();

		System.out.println("\nBorrando los de conductor...");
		String conductor = "Jesus";
		demo.demoBorrarDeConductor(conductor);
		demo.demoListarCoches();

		System.out.println("\nBorrando los taxis..");
		demo.demoBorrarTaxis();
		demo.demoListarCoches();

	}
}
