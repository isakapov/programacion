
package pkgbombilla;

import javafx.scene.image.Image;

public class Bombilla
{

	private boolean encendida;

	/**
	 * Constructor de la clase Bombilla
	 */
	public Bombilla() {

		encendida = false;
	}

	/**
	 *    
	 */
	public void encender() {

		encendida = true;
	}

	/**
	 *    
	 */
	public void apagar() {

		encendida = false;
	}

	/**
	 *  
	 *       
	 */
	public boolean estaEncendida() {

		return encendida;
	}

	/**
	 * Obtener imagen de la bombilla
	 */
	public Image getImagen() {

		if (estaEncendida()) {

			return new Image(getClass().getResourceAsStream(
			                "/resources/images/encendida.gif"));
		}
		return new Image(getClass()
		                .getResourceAsStream("/resources/images/apagada.gif"));
	}

}
