/**
 * La clase modela objetos Personaje en un hipot�tico
 * juego. Los personajes pueden avanzr y girar en diferentes 
 * direcciones
 * 
 * @author 
 * @version 
 */
public class Personaje
{
            
        
        private String nombre;
        private int x;
        private int y;
        private Direccion orientacion;

        /**
         * Constructor de la clase Personaje
         * @paran queNombre elnombre del personaje
         */
        public Personaje(String queNombre)
        {
             nombre = queNombre;
             x = 0;
             y = 0;
             orientacion = Direccion.NORTE;
        }

        /**
         * Cambia la orientaci�n del personaje que
         * siempre gira en el sentido de las
         * agujas del reloj
         */
        public void girar()
        {
              if (orientacion == Direccion.NORTE)
                orientacion = Direccion.ESTE;
              else if (orientacion == Direccion.ESTE)
                orientacion = Direccion.SUR;
              else if (orientacion == Direccion.SUR)
                orientacion = Direccion.OESTE;
              else
                orientacion = Direccion.NORTE;
        }
        
        /**
         * Avanzar una determinada distancia seg�n
         * la orientaci�n del personaje
         *
         * @param  distancia unidades deavance   
         */
        public void  avanzar(int distancia)
        {
                if (orientacion == Direccion.NORTE)
                        y += distancia;
                else if (orientacion == Direccion.SUR)
                         y -= distancia;
                else if (orientacion == Direccion.ESTE)
                        x += distancia;
                else
                        x -= distancia;
        }
        
        /**
         * Devuelve una representaci�n textual del personaje
         *
         * @return el string que representa el personaje 
         */
        public String toString()
        {
                String auxStr = "";
                auxStr += "Personaje " + nombre + "\n" +
                          "Orientacion = " + orientacion.toString() + "\n" +
                          "Posicion = " + "[ " + x + " , " + y + " ] ";
                return auxStr;
        }    
                
}
