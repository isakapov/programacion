
/**
 * Modela un círculo de radio determinado
 * 
 * 
 */
import java.awt.Color;

public class Circulo extends Figura
{
	private double radio;

	/**
	 * Constructor de la clase Circulo
	 * 
	 * @param x
	 *            la coordenada x del centro del círculo
	 * @param y
	 *            la coordenada y del centro del círculo
	 * @param r
	 *            el radio del c�rculo
	 */
	public Circulo(int x, int y, Color color, double r)
	{
		super(x, y, color);
		radio = r;
	}

	/**
	 * 
	 * @return el valor del radio
	 */
	public double getRadio()
	{
		return radio;
	}

	/**
	 * @return el �rea del círculo
	 * @override
	 */
	public double area()
	{
		return Math.PI * radio * radio;
	}

	/**
	 * @param el
	 *            perímetro
	 * @override
	 */
	public double perimetro()
	{
		return Math.PI * 2 * radio;
	}

	/**
	 * 
	 * Representación textual del círculo
	 * 
	 */
	public String toString()
	{
		String s = super.toString();
		return s + "\nRadio: " + getRadio();

	}

}
