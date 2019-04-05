
package entregaut7.transporte.modelo;

import java.time.LocalDate;

/**
 * @author -
 * 
 * Un objeto de esta clase es un servicio de transporte que añade un nº
 * de personas
 * 
 * El coste de un servicio de este tipo es el coste habitual del
 * servicio más un extra por hora que depende del nº de personas
 * transportadas
 */
public class TransportePersonas extends Servicio
{

	private int personas;

	/**
	 * 
	 * @param horas
	 *            las horas que ha durado el servicio
	 * @param fecha
	 *            fecha en la que se hizo el servicio
	 * @param personas
	 *            nº personas transportadas
	 */
	public TransportePersonas(int horas, LocalDate fecha,
	                int personas)
	{
		super(horas, fecha);
		this.personas = personas;
	}

	/**
	 * 
	 * @return nº de personas transportadas
	 */
	public int getPersonas()
	{
		return personas;
	}

	@Override
	public double calcularCoste()
	{
		double precioExtra;
		if (personas >= 10) {
			precioExtra = 1;
		}
		else {
			precioExtra = 0.5;
		}
		return super.calcularCoste()
		                + getHoras() * precioExtra;
	}

	@Override
	public String toString()
	{
		return super.toString() + "\n\tPersonas: "
		                + this.personas;
	}

}
