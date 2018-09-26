
/**
 * Modela un conversor de temperatura
 * Farenheit - Cent�grados y viceversa
 * 
 * 
 */
public class Conversor
{
        private double grados; //cantidad en grados a convertir

        /**
         * Constructor de la clase Conversor
         */
        public Conversor()
        {
                grados = 0;
        }

        /**
         * Mutador que establece la cantidad 
         * en grados a convertir
         * 
         * @param  queGrados los grados a convertir
         */
        public void  setGrados(double queGrados)
        {
                grados = queGrados;
        }
        
        /**
         * Accesor para los grados
         */
        public double  getGrados()
        {
                return grados;
        }
        
        /**
          * Convierte a grados cent�grados
          *
          * @return   los grados cent�grados  
          */
         public double aCentigrados()
         {
                double centigrados = 5 * (grados - 32) / 9;
                return centigrados;
         }
         
          /**
          * Convierte a grados farenheit
          *
          * @return   los grados farenheit  
          */
          public double aFarenheit()
         {
                double farenheit;    
                farenheit = (9.0 / 5) * grados + 32; 
                // farenheit = ((double)9 / 5) * grados + 32; //tambi�n se puede hacer as�
                return farenheit;
         }
}
