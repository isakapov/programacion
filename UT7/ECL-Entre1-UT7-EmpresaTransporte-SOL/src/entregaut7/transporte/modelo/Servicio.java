
package entregaut7.transporte.modelo;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import utilidades.fecha.Utilidades;

/**
 * @author -
 * 
 *  Representa un servicio de transporte realizado por un conductor en
 *  una fecha determinada y con una duración en horas concreta
 * 
 *  Es una clase de la que no se crearán instancias
 * 
 *  El orden natural para comparar dos objetos Servicio es la fecha
 * 
 *  Todo servicio tiene un coste que es el nº horas que ha durado por el
 *  precio de la hora
 */
public abstract class Servicio
                implements Comparable<Servicio>
{

	private static final int PRECIO_HORA = 5;
	private int horas;
	private LocalDate fecha;

	/**
	 * 
	 * @param horas
	 *            las horas que ha durado el servicio
	 * @param fecha
	 *            fecha en la que se hizo el servicio
	 */
	public Servicio(int horas, LocalDate fecha) {

		super();
		this.horas = horas;
		this.fecha = fecha;
	}

	/**
	 * 
	 * @return el nº de horas
	 */
	public int getHoras() {

		return horas;
	}

	/**
	 * 
	 * @return la fecha
	 */
	public LocalDate getFecha() {

		return fecha;
	}

	/**
	 * 
	 * @return el coste del servicio
	 */
	public double calcularCoste() {

		return PRECIO_HORA * horas;
	}

	@Override
	public int compareTo(Servicio otro) {

		return this.fecha.compareTo(otro.getFecha());
	}

	/**
	 * 
	 * @return true si el servicio se ha realizado en fin de semana Hay que utilizar
	 *         la clase Utilidades
	 */
	public boolean enFinDeSemana() {

		String dia = Utilidades.getDiaSemana(fecha);
		return dia.equalsIgnoreCase("sabado")
		                || dia.equalsIgnoreCase("domingo");
	}

	@Override
	public String toString() {

		return this.getClass().getSimpleName()
		                + "\n\tDuración: " + this.horas
		                + "h." + "\tFecha: "
		                + Utilidades.formatear(fecha)
		                + "\n\tCoste servicio: "
		                + String.format("%7.2f€", calcularCoste());
	}

	/**
	 * Código para probar las clases Servicio, TransporteMercancias y
	 * TransportePersonas
	 */
	public static void main(String[] args) {

		Servicio s1 = new TransportePersonas(5,
		                LocalDate.now(), 12);
		Servicio s2 = new TransportePersonas(2,
		                LocalDate.now(), 6);

		Servicio s3 = new TransporteMercancias(5,
		                LocalDate.of(2019, 3, 16), 6);

		Servicio s4 = new TransporteMercancias(2,
		                LocalDate.of(2019, 3, 16), 22);

		Servicio s5 = new TransporteMercancias(12,
		                LocalDate.now(), 11);

		Set<Servicio> servicios = new TreeSet<>();
		servicios.add(s1);
		servicios.add(s2);
		servicios.add(s3);
		for (Servicio servicio : servicios) {
			System.out.println(servicio.toString());
		}

	}

}
