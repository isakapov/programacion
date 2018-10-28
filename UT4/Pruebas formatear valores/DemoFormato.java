import java.text.DecimalFormat;

/**
 * 
 */
public class DemoFormato
{

    /**
     * Constructor  
     */
    public DemoFormato()
    {

    }

    /**
     *  
     */
    public void demoPrintf( )
    {
        int cantidad = 5;
        double importeTotal = 34.6789;
        System.out.printf("Total productos %7d \nImporte total %7.2f", cantidad, importeTotal);

        System.out.printf("\n%40s", "Cadena justificada a la derecha");
        System.out.printf("\n%-40s", "Cadena justificada a la izquierda");

        System.out.printf("\n%07d", 12);
        System.out.printf("\nOtros ejemplos");
        System.out.printf("\n'%+5d'", 10);
        System.out.printf("\n'%-+5d'", 10);

        int ancho = 30;
        System.out.printf("\n%" + ancho + "s%10s", "Nombre", "Edad");
        System.out.printf("\n%" + ancho + "s%10d", "pepe", 23);

    }

    /**
     *  
     */
    public void demoStringFormat( )
    {
        int cantidad = 5;
        double importeTotal = 34.6789;
        String cadenaFormateada = String.format("Total productos %4d \nImporte total %7.2f", cantidad, importeTotal);
        
        System.out.println(cadenaFormateada);
        System.out.println(String.format("\n%40s", "Cadena justificada a la derecha"));
        System.out.println(String.format("\n%-40s", "Cadena justificada a la izquierda")); 
    }

    /**
     *  
     */
    public void demoDecimalFormat( )
    {
        double importe = 12.3456;
        DecimalFormat formateador = new DecimalFormat("00.000");         
        System.out.println(formateador.format(importe));

        importe = 3.5;
        formateador.applyPattern("000.000€");
        System.out.println(formateador.format(importe));

        formateador.applyPattern("#0.0#€");
        System.out.println(formateador.format(importe));

        formateador.applyPattern("###.##%");
        System.out.println(formateador.format(importe));

        formateador.applyPattern("###,###.###");
        System.out.println(formateador.format(12345.670));

    }
}
