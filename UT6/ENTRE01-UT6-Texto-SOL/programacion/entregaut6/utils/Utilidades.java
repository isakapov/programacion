package programacion.entregaut6.utils;
import java.util.HashSet;

/**
 * clase Utilidades 
 * incluye  métodos estáticos para trabajar con String
 * 
 */
public class Utilidades
{

   /**
     * Dada una cadena devuelve una nueva capitalizando los caracteres de forma
     * alterna empezando por mayúscula (mayúscula, minúscula,mayúscula,
     * minúscula, ....) 
     * Ej. si la cadena recibida es "texto" devuelve "TeXtO" si
     * la cadena recibida es "zapato" devuelve "ZaPaTo"
     */
      
    public static String capitalizarAlterna(String cadena)
    {
        cadena = cadena.toUpperCase();
        String resul = "";
        int mitad = cadena.length() / 2;         
        for (int i = 0; i < mitad; i++) {
            char car1 = cadena.charAt(2 * i);
            char car2 = cadena.charAt(2 * i + 1);
            resul += car1;
            resul += Character.toLowerCase(car2);

        }
        if (cadena.length() % 2 != 0) {
            resul += cadena.charAt(cadena.length() - 1);
        }
        return resul;
    }

    /**
     * Dada una cadena devuelve una nueva capitalizando los caracteres de forma
     * alterna empezando por mayúscula (mayúscula, minúscula,mayúscula,
     * minúscula, ....) 
     * Ej. si la cadena recibida es "texto" devuelve "TeXtO" si
     * la cadena recibida es "zapato" devuelve "ZaPaTo"
     */
    public static String capitalizarAlternaV2(String cadena)
    {
        StringBuilder sb = new StringBuilder(cadena.toUpperCase());
        int mitad = cadena.length() / 2;         
        for (int i = 0; i < mitad; i++) {
            char car = sb.charAt(2 * i + 1);
            car = Character.toLowerCase(car);
            sb.setCharAt(2 * i + 1, car);
        }
        return sb.toString();
    }

    /**
     * Dada una cadena devuelve true si hay letras repetidas, false en otro caso
     * Es indiferente mayússculas o minúsculas
     * 
     * Pista!! haz este método con ayuda de un HashSet
     * 
     */
    public static boolean tieneLetrasRepetidas(String cadena)
    {
       int letras = 0;
        HashSet<Character> setLetras = new HashSet<>();
        cadena = cadena.toUpperCase();
        for (int i = 0; i < cadena.length(); i++) {
            char car = cadena.charAt(i);
            if (Character.isLetter(car)) {
                setLetras.add(car);
                letras++;
            }
        }
        return letras != setLetras.size();
    }

    /**
     *  
     */
    public static void main(String[] args)
    {
        String cadena = "zapato";
        System.out.println(cadena + "\tCapitalizada inversa: " +
            Utilidades.capitalizarAlterna(cadena));
        cadena = "pez";
        System.out.println(cadena + "\tCapitalizada inversa: " + 
            Utilidades.capitalizarAlterna(cadena));

        cadena = "semana";
        System.out.println(cadena + "\tTiene letras repetidas?: " + 
            Utilidades.tieneLetrasRepetidas(cadena));

        cadena = "quebrantos";
        System.out.println(cadena + "\tTiene letras repetidas?: " + 
            Utilidades.tieneLetrasRepetidas(cadena));

    }

}
