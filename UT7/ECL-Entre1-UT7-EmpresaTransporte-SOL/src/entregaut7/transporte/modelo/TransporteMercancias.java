
package entregaut7.transporte.modelo;

import java.time.LocalDate;

/**
 * @author -
 * 
 * Un objeto de esta clase es un servicio de transporte que añade un nº
 * de toneladas
 * 
 * El coste de un servicio de este tipo es el coste habitual del
 * servicio más un extra por hora que depende del nº de toneladas
 * transportadas
 */
public class TransporteMercancias extends Servicio
{

	private static final int PRECIO_TONELADA = 2;
	private int toneladas;

	/**
	 * 
	 * @param horas
	 *            las horas que ha durado el servicio
	 * @param fecha
	 *            fecha en la que se hizo el servicio
	 * @param toneladas
	 *            nº toneladas transportadas
	 */
	public TransporteMercancias(int horas, LocalDate fecha,
	                int toneladas) {

		super(horas, fecha);
		this.toneladas = toneladas;
	}

	/**
	 * 
	 * @return nº de toneladas transportadas
	 */
	public int getToneladas() {

		return toneladas;
	}

	@Override
	public double calcularCoste() {

		return super.calcularCoste()
		                + this.toneladas * PRECIO_TONELADA;
	}

	@Override
	public String toString() {

		return super.toString() + "\n\tToneladas: "
		                + this.toneladas;
	}

}
