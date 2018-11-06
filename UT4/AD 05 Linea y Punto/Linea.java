
/**
 * Represenra auna línea en el plano
 * definida por dos puntos
 * 
 * @author 
 * @version 
 */
public class Linea
{
        private Punto p1;
        private Punto p2;

        /**
         * Constructor de la clase Linea
         */
        public Linea()
        {
                p1 = new Punto(0, 0);
                p2 = new Punto(0, 0);
        }

        /**
         * Constructor parametrizado de la clase Linea
         */
        public Linea(Punto p1, Punto p2)
        {
                this.p1 = p1;
                this.p2 = p2;
        }
        /**
         * 
         * Desplazar a la derecha la línea 
         */
        public void moverDerecha(int distancia)
        {
                p1.desplaza(distancia, 0);
                p2.desplaza(distancia, 0);
        }
        
        /**
         * 
         * Desplazar a la izquierda la línea 
         */
        public void moverIzquierda(int distancia)
        {
                p1.desplaza(-distancia, 0);
                p2.desplaza(-distancia, 0);
        }
        
        /**
         * 
         * Desplazar arriba la línea 
         */
        public void moverArriba(int distancia)
        {
                p1.desplaza(0, distancia);
                p2.desplaza(0, distancia);
        }
        
        /**
         * 
         * Desplazar abajo la línea 
         */
        public void moverAbajo(int distancia)
        {
                p1.desplaza(0, -distancia);
                p2.desplaza(0, -distancia);
        }
        
        /**
          *    
          */
         public void printLinea()
         {
                 System.out.println("Punto 1 - " + p1.toString());
                 System.out.println("Punto 2 - " + p1.toString());
         }
 
 
}
