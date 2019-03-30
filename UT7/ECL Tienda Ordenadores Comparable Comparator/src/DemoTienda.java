import java.util.List;

/**
 * 
 * 
 * @author
 * @version
 */
public class DemoTienda
{

	public static void main(String[] args) {

		Tienda tienda = new Tienda("PeCeOrdenador");
		Portatil p1 = new Portatil("P1", 799, 1.5);
		Portatil p2 = new Portatil("P2", 599, 2);
		Portatil p3 = new Portatil("P3", 599, 2.200);
		SobreMesa s1 = new SobreMesa("s1", 599, "Intel Core i5 2,5 GHz");
		SobreMesa s2 = new SobreMesa("s2", 1300, "Intel Core i7 2600");
		tienda.addOrdenador(p1);
		tienda.addOrdenador(p2);
		tienda.addOrdenador(p3);
		tienda.addOrdenador(s1);
		tienda.addOrdenador(s2);

		System.out.println(tienda.toString());

		System.out.println("Los ordenadores más baratos son "
		                + tienda.masBaratos());

		System.out.println("Nº portátiles: " + tienda.cuantosPortatiles());

		tienda.borrarMasBaratos();

		System.out.println("Después de borrar los más baratos: "
		                + tienda.toString());

		System.out.println("Elementos portables");
		List<Portable> lista = tienda.obtenerPortables();
		for (Portable p : lista) {
			System.out.println(p.toString());
		}

		System.out.println("Clonar un ordenador aleatorio");
		System.out.println("Clonando un ordenador aleatorio de la tienda ...\n"
		                + tienda.clonarAleatorio());

		System.out.println("------------------------");
		System.out.println("Ordenado por código de < a >");
		tienda.ordenarPorCodigo();

		System.out.println("------------------------");
		System.out.println("Ordenado por precio de < a >");
		tienda.ordenarPorPrecioAscendente();

		System.out.println("------------------------");
		System.out.println("Ordenado por código de > a <");
		tienda.ordenarPorCodigoDescendente();

		System.out.println("------------------------");
		System.out.println("Ordenado por precio de > a <");
		tienda.ordenarPorPrecioDescendente();

		System.out.println("------------------------");
		System.out.println(
		                "Ordenadores de sobremesa ordenados por precio de > a <");
		List<SobreMesa> ordenados = tienda.ordenarPorPrecioSobremesa();
		for (SobreMesa ord : ordenados) {
			System.out.println(ord.toString());
		}
	}

}
