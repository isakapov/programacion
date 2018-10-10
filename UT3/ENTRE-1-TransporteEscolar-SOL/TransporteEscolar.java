
/**
 *  Una compañía de transporte ofrece a los clientes a 
 *  través de una aplicación un servicio de venta de billetes. 
 *  La aplicación además de mostrar el precio a pagar por el billete
 *  indica  la hora de llegada y salida del autobús escolar de una determinada parada
 *  y el tiempo total que durará el trayecto desde esa parada hasta el colegio.
 *  También realiza ciertos cálculos estadísticos
 *  
 *  @author    
 */
public class TransporteEscolar
{

    private final int STOP_EN_PARADA = 2;
    private final int DURACION_ENTRE_PARADAS = 3;
    private final int MINUTOS_ANTES_PRIMERA_PARADA = 45;
    private final int PARADAS = 9;
    private final double PRECIO_BASE = 1.0;
    private final double PRECIO_INTERVALO = 0.15;

    private final char LUNES = 'L';
    private final char JUEVES = 'J';
    private final char VIERNES = 'V';

    private String nombre;

    private int vendidosEn2;
    private double totalEn2;
    private int enLunes;
    private int enJueves;
    private int enViernes;

    private double importeTotal; 

    /**
     * Constructor  
     */
    public TransporteEscolar(String queNombre)
    {
        nombre = queNombre;        
        vendidosEn2 = 0;
        totalEn2 = 0;
        importeTotal = 0;
        enLunes = 0;
        enJueves = 0;
        enViernes = 0;
    }

    /**
     *  devuelve el nombre de la compañía de transporte
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     *  cambia el nombre de la compañía de transporte
     */
    public void setNombre(String queNombre)
    {
        nombre = queNombre;
    }

    /**
     *  El método recibe cuatro parámetros que supondremos correctos:
     *    • horaInicio – hora de inicio del colegio (formato 24h)
     *    • minutosInicio –  minutos de inicio del colegio (formato 24h)
     *    • numeroParada -   nº de parada
     *    • dia -  día de la semana para el que se compra el billete
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y mostrarlos en pantalla   (leer enunciado del ejercicio)
     */
    public void ventaBillete(int horaInicio, int minutosInicio, int numeroParada, char dia)
    {
        int inicioColegio = horaInicio * 60 + minutosInicio;  // en minutos
        int salidaPrimeraParada = inicioColegio - 45;

        // if (salidaPrimeraParada < 0) {  // por si el inicio del colegio es en un día y la salida 1ª parada en el anterior
            // salidaPrimeraParada = 24 * 60 - (60 + salidaPrimeraParada);
        // }

        // Calcular a qué hora llegará el autobús a la parada indicada en minutos
        int llegadaParada = salidaPrimeraParada + (numeroParada - 1) * DURACION_ENTRE_PARADAS +
            (numeroParada - 1) * STOP_EN_PARADA;
        int horaLlegadaParada =  llegadaParada / 60;
        int minutosLlegadaParada =  llegadaParada % 60;
        int horaPartidaParada =  (llegadaParada + 2) / 60;
        int minutosPartidaParada =  (llegadaParada + 2) % 60;

        // Duración del viaje
        int duracion = (PARADAS - numeroParada) * STOP_EN_PARADA + 
            (PARADAS + 1 - numeroParada) * DURACION_ENTRE_PARADAS;

        // coste del ticket
        double coste = PRECIO_BASE + (duracion / 4) * PRECIO_INTERVALO;

        importeTotal += coste;

        if (numeroParada == 2) {
            vendidosEn2++;
            totalEn2 += coste;
        }

        switch (dia) {
            case LUNES: enLunes++;
            break;
            case JUEVES: enJueves++;
            break;
            case VIERNES: enViernes++;
            break;
        }

        // impresión de cálculos
        System.out.println("Hora inicio del colegio: " + horaInicio);
        System.out.println("Minutos inicio del colegio: " + minutosInicio);
        System.out.println("Nº parada: " + numeroParada);
        String strMinutosLlegadaParada = "" + minutosLlegadaParada;
        if (minutosLlegadaParada < 10) {
            strMinutosLlegadaParada = "0" + strMinutosLlegadaParada;
        }
        String strMinutosPartidaParada = "" + minutosPartidaParada;
        if (minutosPartidaParada < 10) {
            strMinutosPartidaParada = "0" + strMinutosPartidaParada;
        }

        System.out.println("El autobús llegará a la parada nº " + numeroParada + " a las " +
            horaLlegadaParada + ":" + strMinutosLlegadaParada + " y partirá a las " + horaPartidaParada +
            ":" + strMinutosPartidaParada);

        System.out.println("La duración del viaje desde la parada " + numeroParada +
            " es " + duracion + " minutos");

        System.out.println("El coste del billete desde la parada " + numeroParada +
            " es " + coste + "€");                 
    }

    /**
     *  Mostrar estadísticas de ventas
     *  Muestra en pantalla el importe total entre todos los billetes vendidos,
     *  la cantidad de billetes vendidos en la parada 2 y el importe total recaudado 
     *  por venta de billetes en la parada 2
     */
    public void printEstadisticas()
    {
        System.out.println("**************************************");
        System.out.println("    Estadísticas de venta  ");
        System.out.println("**************************************");
        System.out.println("Importe total recogido entre todos los tickets :" + importeTotal + "€");
        System.out.println("Nº tickets vendidos en la parada 2 :" + vendidosEn2);
        System.out.println("Importe total recogido en la parada 2 :" + totalEn2 + "€\n");

    }
    /**
     *  Calcula y devuelve el nombre del día
     *  en el que ha habido más venta de billetes
     */
    public String diaConMasBilletesVendidos()
    {
        int max = enLunes;
        String maxDia = "LUNES";
        if (enJueves > max) {
            max = enJueves;
            maxDia = "JUEVES";
        }  
        if (enViernes >  max) {
            max = enViernes;
            maxDia = "VIERNES";
        }
        return maxDia;

    }

}
