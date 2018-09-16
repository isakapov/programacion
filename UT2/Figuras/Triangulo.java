import java.awt.*;
import java.awt.geom.*;

/**
 * Un triángulo que puede ser manipulado y que se 
 * dibuja a sí mismo en el canvas
 * 
 * @autor  Michael Kolling y David J. Barnes
 */

public class Triangulo
{
    private int altura;
    private int ancho;
    private int xPosicion;
    private int yPosicion;
    private String color;
    private boolean esVisible;
    
    /**
     * Crear un triángulo en la posición por defecto y
     * con el color por defecto
     */
    public Triangulo()
    {
        altura = 30;
        ancho = 40;
        xPosicion = 20;
        yPosicion = 60;
        color = "red";
        esVisible = false;
    }

    /**
     * Hacer el triángulo visible, si ya lo está no pasa nada
     */
    public void hacerVisible()
    {
        esVisible = true;
        dibujar();
    }
    
    /**
     * Hacer el triángulo invisible, si ya lo está no pasa nada
     */
    public void hacerInvisible()
    {
        borrar();
        esVisible = false;
    }
    
    /**
     * Mover el triángulo unos cuanto píxeles a la derecha
     */
    public void moverDerecha()
    {
        moverHorizontal(20);
    }

    /**
     * Mover el triángulo unos cuanto píxeles a la izquierda
     */
    public void moverIzquierda()
    {
        moverHorizontal(-20);
    }

    /**
     * Mover el triángulo unos cuanto píxeles hacia arriba
     */
    public void moverArriba()
    {
        moverVertical(-20);
    }

    /**
     * Mover el triángulo unos cuanto píxeles hacia abajo
     */
    public void moverAbajo()
    {
        moverVertical(20);
    }

    /**
     * Mover el triángulo horizontalmente
     */
    public void moverHorizontal(int distancia)
    {
        borrar();
        xPosicion += distancia;
        dibujar();
    }

    /**
     * Mover el triángulo verticalmente
     */
    public void moverVertical(int distancia)
    {
        borrar();
        yPosicion += distancia;
        dibujar();
    }

    /**
     * Mover el triángulo despacio horizontalmente
     */
    public void moverDespacioHorizontal(int distancia)
    {
        int delta;

        if (distancia < 0) 
        {
            delta = -1;
            distancia = -distancia;
        }
        else 
        {
            delta = 1;
        }

        for (int i = 0; i < distancia; i++)
        {
            xPosicion += delta;
            dibujar();
        }
    }

    /**
     * Mover el triángulo despacio verticalmente
     */
    public void moverDespacioVertical(int distancia)
    {
        int delta;

        if (distancia < 0) 
        {
            delta = -1;
            distancia = -distancia;
        }
        else 
        {
            delta = 1;
        }

        for (int i = 0; i < distancia; i++)
        {
            yPosicion += delta;
            dibujar();
        }
    }

    /**
     * Cambiar el tamaño al nuevo tamaño (en pixeles). Debe ser >= 0.
     */
    public void cambiarTamano(int nuevoAlto, int nuevoAncho)
    {
        borrar();
        altura = nuevoAlto;
        ancho = nuevoAncho;
        dibujar();
    }

    /**
     * Cambiar el color. Colores válidos son "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void cambiarColor(String nuevoColor)
    {
        color = nuevoColor;
        dibujar();
    }

    /**
     * Dibujar el triángulo con las especificaciones actuales en la pantalla
     */
    
    private void dibujar()
    {
        if (esVisible) 
		{
            Canvas canvas = Canvas.getCanvas();
            int [] xPuntos={ xPosicion, xPosicion + (ancho / 2), 
                                        xPosicion - (ancho / 2 )};
            int [] yPuntos={ yPosicion, yPosicion + altura, yPosicion + altura };                            
            canvas.dibujar(this, color, new Polygon(xPuntos, yPuntos,3));                                                    
            canvas.esperar(10);
        }
    }

    /*
     * Borra el Triangulo de la pantalla
     */
    private void borrar()
    {
        if (esVisible) 
		{
            Canvas canvas = Canvas.getCanvas();
            canvas.borrar(this);
        }
    }
}
