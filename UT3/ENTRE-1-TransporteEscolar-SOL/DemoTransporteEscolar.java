import java.util.Scanner;

/**
 *  class DemoTransporteEscolar  
 *  Clase para testear la clase TransporteEscolar
 *  
 *  
 */
public class DemoTransporteEscolar
{

    private  TransporteEscolar transporte;
    private Scanner teclado;

    /**
     * Constructor de la clase DemoTransporteEscolar
     */
    public DemoTransporteEscolar()
    {
        teclado = new Scanner(System.in);
        transporte = new TransporteEscolar("Autocares KIDS");
    }

    /**
     *  
     */
    public void demo()
    {
        System.out.println("*****************************************");
        System.out.println("   Transporte Escolar  " +  transporte.getNombre());
        System.out.println("*****************************************\n\n");

        transporte.ventaBillete(10, 30, 5, 'J');      
        pausa();

        transporte.ventaBillete(8, 14, 7, 'J');      
        pausa();

        transporte.ventaBillete(9, 15, 8, 'L');      
        pausa();

        transporte.ventaBillete(10, 12, 2, 'V');      
        pausa();

        transporte.ventaBillete(9, 25, 2, 'M');      
        pausa();
        
        transporte.ventaBillete(9, 35, 1, 'J');      
        pausa();

        transporte.printEstadisticas();
        System.out.println("El día con más billetes vendidos es " + 
            transporte.diaConMasBilletesVendidos());
    }

    /**
     *  hacer una pausa
     */
    private void pausa()
    {
        System.out.println("\nPulse <Intro> para continuar");        
        teclado.nextLine();
        System.out.println("\u000C");    
    }

}
