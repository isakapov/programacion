
package entregaut7.transporte.test;

import java.time.LocalDate;

import entregaut7.transporte.modelo.Conductor;
import entregaut7.transporte.modelo.Empresa;
import entregaut7.transporte.modelo.TransporteMercancias;
import entregaut7.transporte.modelo.TransportePersonas;

public class TestEmpresa
{

	private Empresa empresa;

	public TestEmpresa()
	{
		empresa = new Empresa("Transportes M. Sanz");
	}

	public void testAddConductor()
	{
		Conductor c1 = new Conductor("1234A", "Pedro");
		Conductor c2 = new Conductor("6789B", "Ana");
		Conductor c3 = new Conductor("2323C", "Luis");
		empresa.addConductor("Madrid", c1);
		empresa.addConductor("Madrid", c2);
		empresa.addConductor("Madrid", c3);
		empresa.addConductor("Madrid", c3);

		c1 = new Conductor("8986X", "Alberto");
		c2 = new Conductor("9994Z", "Maribel");
		empresa.addConductor("Pamplona", c1);
		empresa.addConductor("Pamplona", c2);
		empresa.addConductor("Pamplona", c2);

		c1 = new Conductor("6666C", "Juan");
		c2 = new Conductor("7777M", "Ignacio");
		c3 = new Conductor("8888X", "Pablo");
		Conductor c4 = new Conductor("2221M", "Belén");
		empresa.addConductor("Zaragoza", c1);
		empresa.addConductor("Zaragoza", c2);
		empresa.addConductor("Zaragoza", c3);
		empresa.addConductor("Zaragoza", c4);
		empresa.addConductor("Zaragoza", c2);

	}

	public void testAddServicios()
	{
		String sede = "pamplona";
		String dni = "8986X";
		boolean exito = empresa.addServicio(sede, dni, new TransportePersonas(4, LocalDate.of(2019, 3, 16), 22));	
		mensaje(exito, sede, dni);
		exito = empresa.addServicio(sede, dni, new TransportePersonas(4, LocalDate.of(2019, 3, 17), 15));
		mensaje(exito, sede, dni);
		exito = empresa.addServicio(sede, dni, new TransporteMercancias(3, LocalDate.of(2019, 3, 17), 40));
		
		dni = "9994Z";
		mensaje(exito, sede, dni);
		exito = empresa.addServicio(sede, dni, new TransporteMercancias(3, LocalDate.of(2019, 3, 17), 40));
		
		dni = "3333N";
		mensaje(exito, sede, dni);
		
		// ------------------------------------------------------
		
		sede = "zaragoza";
		dni = "6666C";
		exito = empresa.addServicio(sede, dni, new TransportePersonas(7, LocalDate.of(2019, 3, 16), 59));
		mensaje(exito, sede, dni);
		
		dni = "7777M";
		exito = empresa.addServicio(sede, dni, new TransportePersonas(6, LocalDate.of(2019, 3, 15), 40));
		mensaje(exito, sede, dni);
		exito = empresa.addServicio(sede, dni, new TransportePersonas(2, LocalDate.of(2019, 3, 13), 21));
		mensaje(exito, sede, dni);
		exito = empresa.addServicio(sede, dni, new TransportePersonas(5, LocalDate.of(2019, 3, 21), 60));
		mensaje(exito, sede, dni);
		
		dni = "8888X";
		exito = empresa.addServicio(sede, dni, new TransporteMercancias(4, LocalDate.of(2019, 2, 3), 11));
		mensaje(exito, sede, dni);
		
		// ------------------------------------------------------
		sede = "madrid";
		dni = "2323C";
		exito = empresa.addServicio(sede, dni, new TransporteMercancias(7, LocalDate.of(2019, 2, 9), 20));
		mensaje(exito, sede, dni);
		exito = empresa.addServicio(sede, dni, new TransporteMercancias(7, LocalDate.of(2019, 2, 14), 13));
		mensaje(exito, sede, dni);
		exito = empresa.addServicio(sede, dni, new TransporteMercancias(2, LocalDate.of(2019, 2, 16), 7));
		mensaje(exito, sede, dni);
		
		dni = "1234A";
		exito = empresa.addServicio(sede, dni, new TransportePersonas(1, LocalDate.of(2019, 3, 6), 8));
		mensaje(exito, sede, dni);
		exito = empresa.addServicio(sede, dni, new TransportePersonas(1, LocalDate.of(2019, 3, 7), 9));
		mensaje(exito, sede, dni);
		
		dni = "6789B";
		exito = empresa.addServicio(sede, dni, new TransportePersonas(3, LocalDate.of(2019, 3, 3), 33));
		mensaje(exito, sede, dni);
		
		
		
	}

	private void mensaje(boolean exito, String sede,
	                String dni)
	{
		if (!exito) {
			System.out.println("No se ha podido a�adir en la sede " + sede.toUpperCase() +
							" el servicio al conductor con DNI: " + dni.toUpperCase());
		}
		
	}
	
	public void testMostraServiciosFinSemana()
	{
		
		empresa.mostrarServiciosFinDeSemana();
		System.out.println();
		
	}
	
	public void testMostraServiciosOrdenados()
	{
		String sede = "zaragoza";
		empresa.mostrarServiciosOrdenados(sede);
		System.out.println();
		
		sede = "madrid";
		empresa.mostrarServiciosOrdenados(sede);
		System.out.println();
		
		sede = "pamplona";
		empresa.mostrarServiciosOrdenados(sede);
		System.out.println();
	}

	public void testMostraSueldos()
	{
		
		empresa.mostrarSueldos();
		System.out.println();
		
	}

	public static void main(String[] args)
	{
		TestEmpresa test = new TestEmpresa();
		test.testAddConductor();
		test.testAddServicios();
		
		test.testMostraServiciosFinSemana();
		test.testMostraServiciosOrdenados();
		test.testMostraSueldos();

	}

}
