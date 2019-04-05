
package entregaut7.transporte.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Modela un conductor que trabaja para la empresa en una determinada sede
 * Todo conductor tiene un DNI, nombre y un conjunto de servicios
 * asociados (los que ha realizado hasta el momento (inicialmente vacío)
 * 
 * Dos conductores se consideran iguales si además de ser del mismo tipo
 * tienen el mismo DNI
 */
public class Conductor
{

	private static final double SUELDO_BASE = 700;
	private String dni;
	private String nombre;
	private Set<Servicio> servicios;

	public Conductor(String dni, String nombre)
	{
		this.dni = dni.toUpperCase();
		this.nombre = nombre.toUpperCase();
		this.servicios = new TreeSet<>();

	}

	/**
	 * 
	 * @return el dni del conductor
	 */
	public String getDni()
	{

		return dni;
	}

	/**
	 * 
	 * @return el nombre del conductor
	 */
	public String getNombre()
	{

		return nombre;
	}

	/**
	 * 
	 * @param servicio el servicio que se añade al conjunto de servicios
	 */
	public void addServicio(Servicio servicio)
	{
		servicios.add(servicio);
	}

	/**
	 * 
	 * @return nº de servicios realizados hasta el momento
	 */
	public int numeroServicios()
	{
		return servicios.size();
	}

	/**
	 * 
	 * @return el nº total de horas de conducci�n del conductor
	 */
	public int calcularTotalHorasConducidas()
	{
		int total = 0;
		for (Servicio servicio : servicios) {
			total += servicio.getHoras();
		}
		return total;
	}

	/**
	 * 
	 * @return el sueldo a pagar al conductor
	 * 
	 * Será el sueldo base más el importe de cada servicio realizado
	 */
	public double calcularSueldo()
	{
		double sueldo = SUELDO_BASE;
		for (Servicio servicio : servicios) {
			sueldo += servicio.calcularCoste();
		}
		return sueldo;
	}

	/**
	 * 
	 * @return el nº de servicios que ha realizado el conductor en fin de semana
	 */
	public int serviciosEnFinDeSemana()
	{
		int total = 0;
		for (Servicio servicio : servicios) {
			if (servicio.enFinDeSemana()) {
				total++;
			}
		}
		return total;
	}

	/**
	 * Usar un iterador
	 * 
	 * @return el nº de personas transportadas por el conductor entre
	 * todos los servicios
	 */
	public int personasTransportadas()
	{
		int total = 0;
		Iterator<Servicio> it = servicios.iterator();
		while (it.hasNext()) {
			Servicio servicio = it.next();
			if (servicio instanceof TransportePersonas) {
				TransportePersonas transporte = (TransportePersonas) servicio;
				total += transporte.getPersonas();
			}
		}
		return total;
	}

	@Override
	public int hashCode()
	{
		return dni.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Conductor otro = (Conductor) obj;
		return this.dni.equalsIgnoreCase(otro.getDni());
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder(
		                "Conductor: " + this.nombre + "\n");
		sb.append("Servicios realizados: "
		                + numeroServicios() + "\n");
		for (Servicio servicio : servicios) {
			sb.append(servicio.toString() + "\n");
		}
		sb.append("\n");
		sb.append("Horas conducidas: "
		                + calcularTotalHorasConducidas()
		                + "\n");
		sb.append("Nº personas transportadas: "
		                + personasTransportadas() + "\n");
		sb.append("Sueldo: "
		                + String.format("%7.2f",
		                                calcularSueldo())
		                + "€\n");
		return sb.toString();
	}

	/**
	 * 
	 * @return una colección ArrayList con todos los servicios ordenados
	 * por coste (no se modifica la colección original)
	 */
	public List<Servicio> ordenadosPorCoste()
	{
		List<Servicio> ordenados = new ArrayList<>();
		ordenados.addAll(servicios);
		ordenados.sort(new Comparator<Servicio>() {

			@Override
			public int compare(Servicio s1, Servicio s2)
			{
				return (int) (Math.signum(s1.calcularCoste()
				                - s2.calcularCoste()));
			}

		});
		return ordenados;
	}

	/**
	 * Código para probar los métodos de la clase Conductor
	 */
	public static void main(String[] args)
	{
		Conductor c1 = new Conductor("1234A", "Pedro");
		Servicio s1 = new TransportePersonas(5,
		                LocalDate.now(), 12);
		Servicio s2 = new TransportePersonas(4,
		                LocalDate.now(), 6);

		Servicio s3 = new TransporteMercancias(5,
		                LocalDate.of(2019, 3, 16), 10);

		Servicio s4 = new TransporteMercancias(2,
		                LocalDate.of(2019, 3, 16), 20);

		Servicio s5 = new TransporteMercancias(12,
		                LocalDate.now(), 11);
		Servicio s6 = new TransportePersonas(7,
		                LocalDate.of(2019, 2, 12), 19);

		c1.addServicio(s1);
		c1.addServicio(s2);
		c1.addServicio(s3);
		c1.addServicio(s4);
		c1.addServicio(s5);
		c1.addServicio(s6);

		System.out.println(c1.toString());

		System.out.println("Ordenados por coste");
		List<Servicio> ordenados = c1.ordenadosPorCoste();
		System.out.println(ordenados.toString());

	}
}
