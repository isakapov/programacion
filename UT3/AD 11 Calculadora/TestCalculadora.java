
/**
 * C�digo para probar la clase Calculadora
 * 
*/
import java.util.Scanner;
public class TestCalculadora
{
	
	public static void main (String args[])
	{
		Calculadora calculadora = new Calculadora();
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca numero: ");
		int numero = teclado.nextInt();
		while (numero !=0) 
		{
		    calculadora.addNumero(numero);
		    System.out.print("Introduzca numero: ");
		    numero = teclado.nextInt();
	    }
	    calculadora.printEstadisticas();
		  
	}

	
}
