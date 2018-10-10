
/**
 * Clase Fecha que representa a fechas
 * Ejercicios 13 y 14
 *  
 */
public class Fecha
{
    private int dia;
    private int mes;
    private int a�o;

    /**
     * constructor parametrizado 
     * para los objetos de la clase Fecha
     */
    public Fecha(int queDia, int queMes, int queAnio)
    {
        dia = queDia;
        mes = queMes;
        a�o = queAnio;
    }   

    /**
     * Obtener el d�a   
     */
    public int getDia()
    {
        return dia;
    }

    /**
     * Obtener el mes 
     */
    public int getMes()
    {
        return mes;
    }

    /**
     * Obtener el anio  
     */
    public int getA�o()
    {
        return a�o;
    }

    /**
     * Establecer un nuevo a�o
     */
    public void setA�o(int a�o)
    {
        this.a�o = a�o;
    }

    /**
     * Establecer un nuevo mes
     */
    public void setMes(int mes)
    {
        this.mes= mes;
    }

    /**
     * Establecer un nuevo dia
     */
    public void setDia(int dia)
    {
        this.dia= dia;
    }

    /**
     * Comprobar si el a�o es bisiesto
     * Es m�ltiplo de 4 pero no de 100 o bien m�ltiplo de 400
     * 
     * @return devuelve true si es bisiesto, false en otro caso
     */
    public boolean esBisiesto()
    {
        return (a�o % 4 == 0  && a�o % 100 != 0) || 
                    (a�o % 400 == 0);
    }

    /**
     * Devolver el n� de d�as del mes de la fecha en cuesti�n dependiendo del a�o
     * @return devuelve los d�as del mes
     */
    public int diasMes()
    {
        int num = 31;

        switch (mes) 
        {
            case 4:
            case 6:
            case 9:
            case 11:
            num = 30;
            break;
            case 2:
            if ( a�o % 4 == 0  && a�o % 100 != 0 || 
                            a�o % 400 == 0 )       // tambi�n esBisiesto()
            {
                num = 29;
            }
            else
            {
                num = 28;
            }
            break;
        } 
        return num;
    }

    /**
     * Escribir la fecha en formato corto
     */
    public void printCorta()
    {
        System.out.println(dia + " - " + mes + " - " + a�o);
    }

    /**
     * Escribir la fecha en formato largo
     */
    public void printLarga()
    {
        String nombre = "";
        System.out.print(dia);
        switch (mes)
        {
            case 1: nombre = "enero";
            break;
            case 2: nombre = "febrero";
            break;
            case 3: nombre = "marzo";
            break;
            case 4: nombre = "abril";
            break;
            case 5: nombre = "mayo";
            break;
            case 6: nombre = "junio";
            break;
            case 7: nombre = "julio";
            break;
            case 8: nombre = "agosto";
            break;
            case 9: nombre = "septiembre";
            break;
            case 10: nombre = "octubre";
            break;
            case 11: nombre = "noviembre";
            break;
            case 12: nombre = "diciembre";
            break;
        }
        System.out.println(" de " + nombre + " de " + a�o);

    }

    /**
     * Comprobar si la fecha almacenada es correcta
     */
    public boolean esCorrecta()
    {
        boolean correcta = true;      

        if (dia < 1 || dia > 31)
        {
            correcta = false;
        }
        else if (mes < 1 || mes > 12)
        {
            correcta = false;
        }
        else if (mes != 2)
        {
            switch (mes)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: correcta = (dia <= 31);
                break;
                case 4:
                case 6:
                case 9:
                case 11: correcta = (dia <= 30);
                break;
            }
        }
        else  // el mes es febrero
        {                 
            int limite;
            // comprobar si a�o bisiesto
            if   ( a�o % 4 == 0  && a�o % 100 != 0 || 
                        a�o % 400 == 0 )       // tambi�n esBisiesto()
            {
                limite = 29;
            }
            else
            {
                limite = 28;
            }
            correcta = (dia <= limite);
        }
        return correcta;
    }    

    /**
     *  Comprueba si la fecha preceda a otra
     *  recibida como par�metro
     *
     *  Suponemos los argumentos recibidos todos correctos
     */
    public boolean precedeA(int queDia, int queMes, int queA�o)
    {
        return (a�o < queA�o) ||
                (a�o == queA�o && (mes < queMes || 
                (mes == queMes &&  dia < queDia)));

    }

    /**
     *  Comprueba si la fecha preceda a otra
     *  recibida como par�metro
     *
     *  Suponemos los argumentos recibidos todos correctos
     */
    public boolean precedeAV2(int queDia, int queMes, int queA�o)
    {
        boolean precede;
        if (a�o < queA�o) 
        {
            precede = true;
        }
        else if (a�o > queA�o) 
        {
            precede = false;
        }
        else  if (mes < queMes)
        {
            precede = true;
        }
        else if (mes > queMes)
        {
            precede = false;
        }
        else  if (dia < queDia)
        {
            precede = true;
        }
        else if (dia > queDia)
        {
            precede = false;
        }
        else
        {
            precede = false;
        }
        return precede;
    }

    /**
     *  Avanza un d�a la fecha
     *
     */
    public void avanzarDia()
    {
        int diasMes = 30;
        switch (mes) 
        {
            case 2:
            if ( esBisiesto() )
            {
                diasMes = 29;
            }
            else
            {
                diasMes = 28;
            }
            break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 12:
            diasMes = 31;
            break;
        }
        dia++;
        if (dia > diasMes)
        {
            dia = 1;
            mes++;
            if (mes > 12)
            {
                mes = 1;
                a�o++;
            }
        }
    }

}

