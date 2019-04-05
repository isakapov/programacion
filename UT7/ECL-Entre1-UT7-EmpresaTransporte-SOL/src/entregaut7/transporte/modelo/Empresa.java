
package entregaut7.transporte.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Representa a una empresa de transporte con sedes en distintas ciudades En
 * cada sede trabajan para la empresa varios conductores
 * 
 * A través de un map (importa el orden de las claves) se asocia la sede con la
 * lista de conductores que trabajan en ella (un ArrayList)
 * 
 */
public class Empresa
{

	private String nombre;
	private Map<String, List<Conductor>> sedes;

	/**
	 * 
	 * @param nombre
	 *            el nombre de la empresa
	 */
	public Empresa(String nombre) {

		this.nombre = nombre;
		sedes = new TreeMap<>();
	}

	/**
	 * Se añade un conductor a la lista de conductoes de la sede Las claves siempre
	 * se añaden en mayúsculas
	 * 
	 * Si no existe la sede se crea y se añade el conductor y si existe la sede se añade el
	 * conductor únicamente si no está  el conductor todavía
	 * 
	 * @param sede   la sede de la empresa
	 * @param conductor  el conductor que se añade a la sede
	 */
	public void addConductor(String sede,
	                Conductor conductor) {

		sede = sede.toUpperCase();
		if (!sedes.containsKey(sede)) {
			List<Conductor> lista = new ArrayList<>();
			lista.add(conductor);
			sedes.put(sede, lista);
		}
		else {
			List<Conductor> lista = sedes.get(sede);
			if (!lista.contains(conductor)) {
				lista.add(conductor);
			}
		}
	}

	/**
	 * 
	 * @param sede la sede en la que se buscará a un conductor
	 * @param dni  el dni del conductor a buscar
	 * @return el conductor de la sede o null si no existe
	 */
	public Conductor buscarConductor(String sede,
	                String dni) {

		sede = sede.toUpperCase();
		dni = dni.toUpperCase();
		if (sedes.containsKey(sede)) {
			List<Conductor> lista = sedes.get(sede);
			for (Conductor conductor : lista) {
				if (conductor.getDni().equals(dni)) {
					return conductor;
				}
			}
		}
		return null;
	}

	/**
	 * Añadir un servicio realizado por el conductor indicado
	 * Si la sede no existe no se hace nada
	 * Solo se añade el servicio si se encuentra al conductor con el 
	 * DNI indicado
	 * 
	 * @param sede   la sede en la que se añade al conductor
	 * @param dni  el dni del conductor
	 * @param servicio  el servicio realizado
	 * 
	 * @return true si se ha añadido el servicio, false en otro caso
	 */
	public boolean addServicio(String sede, String dni,
	                Servicio servicio) {

		sede = sede.toUpperCase();
		if (sedes.containsKey(sede)) {
			Conductor conductor = buscarConductor(sede,
			                dni.toUpperCase());
			if (conductor != null) {
				conductor.addServicio(servicio);
				return true;
			}
		}
		return false;
	}

	/**
	 * Mostrar para cada sede el nº total de servicios realizados en fin de semana
	 * Se muestra inicialmente el nombre de la empresa
	 */
	public void mostrarServiciosFinDeSemana() {

		System.out.println("Servicios en fin de semana");
		System.out.println("Empresa: " + this.nombre);
		for (Map.Entry<String, List<Conductor>> entrada : sedes
		                .entrySet()) {
			System.out.print(entrada.getKey() + " ( ");
			int total = 0;
			List<Conductor> lista = entrada.getValue();
			for (Conductor conductor : lista) {
				total = total + conductor
				                .serviciosEnFinDeSemana();
			}
			System.out.println(total + " ) ");
		}
	}

	/**
	 * Mostrar dada una sede la lista de servicios realizados por todos sus
	 * conductores ordenada por coste
	 * 
	 * Asumimos que existe la sede
	 */
	public void mostrarServiciosOrdenados(String sede) {

		sede = sede.toUpperCase();
		System.out.println(
		                "Servicios ordenados por coste de "
		                                + sede);
		List<Conductor> lista = sedes.get(sede);
		for (Conductor conductor : lista) {
			System.out.println(conductor.getNombre());
			List<Servicio> ordenados = conductor
			                .ordenadosPorCoste();
			for (Servicio servicio : ordenados) {
				System.out.println(servicio.toString());
			}
		}
	}

	/**
	 * Mostrar para cada sede el sueldo que la empresa debe pagar a cada uno de sus
	 * conductores (solo se muestra nombre y sueldo del conductor)
	 * 
	 * Con el conjunto de entradas y un iterador
	 */
	public void mostrarSueldos() {

		System.out.println(
		                "Sueldos a pagar por la empresa");
		Set<Map.Entry<String, List<Conductor>>> entradas = sedes
		                .entrySet();
		Iterator<Map.Entry<String, List<Conductor>>> it = entradas
		                .iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<Conductor>> entrada = it
			                .next();
			System.out.println(entrada.getKey());
			List<Conductor> lista = entrada.getValue();
			for (Conductor conductor : lista) {
				System.out.println("\t"
				                + conductor.getNombre()
				                + "\t"
				                + String.format("%7.2f€",
				                                conductor.calcularSueldo()));

			}
		}

	}
}
