
import java.util.Arrays;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GuiLista extends Application {
	private static final int TAM_LISTA = 10;
	private static final int MIN_INTERVALO_NUM = -20;
	private static final int MAX_INTERVALO_NUM = 20;

	private Stage stage;

	private Button btnAdd;
	private Button btnColapsar;
	private Button btnHistograma;
	private Button btnBuscarBinaria;
	private Button btnArray2D;
	private Button btnMostrarLista;
	private Button btnVaciarLista;
	private Button btnClear;
	private Button btnSalir;

	private TextField txtNumero;

	private TextArea areaTexto;

	private ListaNumeros lista;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		crearLista();
		BorderPane root = crearGui();

		Scene scene = new Scene(root, 950, 500);
		stage.setScene(scene);
		stage.setTitle("- Entrega 1 UT5 - Lista de números -");
		scene.getStylesheets().add(getClass().getResource("/application.css")
		                    .toExternalForm());
		stage.show();
		mostrarLista();
	}

	private void crearLista() {

		lista = new ListaNumeros(TAM_LISTA);
		int n = (int) (Math.random() * TAM_LISTA) + 1;
		for (int i = 0; i < n; i++) {
			lista.addElemento((int) (Math.random()
			                    * (MAX_INTERVALO_NUM - MIN_INTERVALO_NUM + 1))
			                    + MIN_INTERVALO_NUM);
		}

	}

	private BorderPane crearGui() {
		BorderPane panel = new BorderPane();
		panel.setRight(crearPanelBotones());
		panel.setCenter(crearPanelCentral());
		return panel;
	}

	private BorderPane crearPanelCentral() {
		BorderPane panel = new BorderPane();
		panel.setTop(crearPanelEntrada());

		areaTexto = new TextArea();
		areaTexto.setId("areatexto");
		panel.setCenter(areaTexto);
		return panel;
	}

	private HBox crearPanelEntrada() {
		HBox panel = new HBox();
		panel.setStyle("-fx-background-color: #ECEAE0");
		panel.setSpacing(10);
		panel.setPadding(new Insets(10));
		panel.setAlignment(Pos.CENTER);

		Label lblNumero = new Label("Teclee nº");
		txtNumero = new TextField();
		txtNumero.setPrefColumnCount(20);
		txtNumero.setOnAction(e -> addNumero());

		btnAdd = new Button("Add número");
		btnAdd.setId("botonadd");
		btnAdd.setOnAction(e -> addNumero());

		panel.getChildren().addAll(lblNumero, txtNumero, btnAdd);

		return panel;
	}

	private VBox crearPanelBotones() {
		VBox panel = new VBox();
		panel.setStyle("-fx-background-color: #ECEAE0");
		panel.setSpacing(10);
		panel.setPadding(new Insets(10));

		btnColapsar = new Button("Colapsar");
		btnColapsar.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		VBox.setVgrow(btnColapsar, Priority.ALWAYS);
		btnColapsar.setOnAction(e -> colapsar());

		btnHistograma = new Button("Mostrar histograma");
		btnHistograma.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		VBox.setVgrow(btnHistograma, Priority.ALWAYS);
		btnHistograma.setOnAction(e -> mostrarHistograma());

		btnBuscarBinaria = new Button("Búsqueda binaria");
		btnBuscarBinaria.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		VBox.setVgrow(btnBuscarBinaria, Priority.ALWAYS);
		btnBuscarBinaria.setOnAction(e -> buscarBinaria());

		btnArray2D = new Button("to Array2D");
		btnArray2D.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		VBox.setVgrow(btnArray2D, Priority.ALWAYS);
		btnArray2D.setOnAction(e -> toArray2D());

		btnMostrarLista = new Button("Mostrar lista");
		btnMostrarLista.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		VBox.setVgrow(btnMostrarLista, Priority.ALWAYS);
		btnMostrarLista.setOnAction(e -> mostrarLista());

		btnVaciarLista = new Button("Vaciar lista");
		btnVaciarLista.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		VBox.setVgrow(btnVaciarLista, Priority.ALWAYS);
		btnVaciarLista.setOnAction(e -> vaciarLista());

		btnClear = new Button("Limpiar área de texto");
		btnClear.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		VBox.setVgrow(btnClear, Priority.ALWAYS);
		btnClear.setOnAction(e -> clear());

		btnSalir = new Button("_Salir");
		btnSalir.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
		btnSalir.setId("botonsalir");
		VBox.setVgrow(btnSalir, Priority.ALWAYS);
		btnSalir.setOnAction(e -> salir());

		panel.getChildren().addAll(btnColapsar, btnHistograma, btnBuscarBinaria,
		                    btnArray2D);
		panel.getChildren().addAll(btnMostrarLista, btnVaciarLista, btnClear,
		                    btnSalir);

		return panel;

	}

	/**
	 * añade un nuevo número a la lista mostrando el estado actual de la lista en el
	 * área de texto
	 * 
	 */
	private void addNumero() {
		mostrarLista();
		String strNumero = txtNumero.getText();
		if (strNumero.isEmpty()) {
			areaTexto.appendText("\nTeclee nº");

		} else {
			try {
				int numero = Integer.parseInt(strNumero);
				if (numero < MIN_INTERVALO_NUM || numero > MAX_INTERVALO_NUM) {
					throw new IllegalArgumentException();
				}
				boolean exito = lista.addElemento(numero);
				if (!exito) {
					areaTexto.appendText(
					                    "\nLista completa o nº repetido, no se ha podido añadir\n");
				} else {
					mostrarLista();
				}

			} catch (NumberFormatException e) {
				areaTexto.appendText("\nTeclee solo dígitos numéricos");
			} catch (IllegalArgumentException e) {
				areaTexto.appendText(
				                    "\nTeclee valores en el intervalo ["
				                                        + MIN_INTERVALO_NUM
				                                        + ","
				                                        + MAX_INTERVALO_NUM
				                                        + "]");
			}
		}

		cogerFoco();

	}

	/**
	 * Muestra en el área de texto el array2D obtenido a partir de la lista
	 */
	private void toArray2D() {
		clear();
		mostrarLista();
		if (!lista.estaVacia()) {
			int[][] array2D = lista.toArray2D();

			GridPane panel2D = crearPanel2D(array2D);
			Scene escena2D = new Scene(panel2D, 400, 400);

			Stage escenario2D = new Stage();

			escenario2D.setScene(escena2D);
			escenario2D.initModality(Modality.WINDOW_MODAL);
			escenario2D.initOwner(this.stage);
			escenario2D.setX(this.stage.getX() + 100);

			escenario2D.setTitle("- ARRAY 2D -");
			escena2D.getStylesheets()
			                    .add(getClass().getResource("/application.css")
			                                        .toExternalForm());
			escenario2D.sizeToScene();
			escenario2D.show();
		}

	}

	private GridPane crearPanel2D(int[][] array2D) {
		GridPane panel = new GridPane();
		panel.setPadding(new Insets(10));
		panel.setAlignment(Pos.CENTER);
		panel.setHgap(5);
		panel.setVgap(5);

		for (int f = 0; f < array2D.length; f++) {
			for (int c = 0; c < array2D[f].length; c++) {
				Button btn = new Button(array2D[f][c] + "");
				btn.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
				GridPane.setHgrow(btn, Priority.ALWAYS);
				GridPane.setVgrow(btn, Priority.ALWAYS);
				btn.getStyleClass().add("button2D");
				if (c < f) {
					btn.getStyleClass().add("button2Dsombreado");
				}
				panel.add(btn, c, f);

			}
		}
		return panel;
	}

	/**
	 * Muestra en el área de texto la lista colapsada
	 * 
	 */
	private void colapsar() {
		clear();
		if (lista.estaVacia()) {
			areaTexto.appendText("Lista vacía\n");
			escribirLista();
		} else {
			escribirLista();
			areaTexto.appendText("\nLista colapsada:  "
			                    + Arrays.toString(lista.colapsar()));
		}
		cogerFoco();
	}

	/**
	 * Mostrar histograma horizontal
	 */
	private void mostrarHistograma() {

		mostrarLista();
		if (!lista.estaVacia()) {
			areaTexto.appendText(lista.histogramaHorizontal());
		}

		cogerFoco();
	}

	/**
	 * pedir un valor e indicar si existe o no  en 
	 * la lista  
	 */
	private void buscarBinaria() {
		mostrarLista();
		if (!lista.estaVacia()) {
			try {
				int numero = pedirNumero();
				int p = lista.buscarBinario(numero);
				if (p < 0) {
					areaTexto.appendText("No existe el valor " + numero
					                    + " en la lista");

				} else {
					areaTexto.appendText(
					                    "El nº " + numero + " está en la lista ");
				}
			} catch (IllegalArgumentException e) {
				areaTexto.appendText(e.getMessage());
			}
		}

	}

	private int pedirNumero() {

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("TextInputDialog - Entrada de datos");
		dialog.setHeaderText(null);
		dialog.setContentText("Teclee un valor:");
		Optional<String> result = dialog.showAndWait();

		int numero = 0;
		if (result.isPresent()) {
			String strNumero = result.get();
			try {
				numero = Integer.parseInt(strNumero);
			} catch (Exception e) {

				throw new IllegalArgumentException("Teclee valor numérico");
			}
		} else {

			throw new IllegalArgumentException("Ha pulsado Cancel");
		}

		return numero;
	}

	/**
	 * mostrar la lista y su nº de elementos en el área de texto
	 */
	private void mostrarLista() {
		clear();
		if (lista.estaVacia()) {
			areaTexto.appendText("Lista vacía\n");
		}
		escribirLista();

		cogerFoco();

	}

	private void escribirLista() {
		areaTexto.appendText("Lista: " + lista.toString());
		areaTexto.appendText("\nNº de elementos en la lista "
		                    + lista.getTotalNumeros() + "\n\n");

	}

	/**
	 * Vacía la lista
	 */
	private void vaciarLista() {
		clear();
		lista.vaciarLista();
		areaTexto.appendText("Borrados todos los valores de la lista");
		cogerFoco();

	}

	/**
	 * limpiar área de texto
	 */
	private void clear() {
		areaTexto.setText("");
		cogerFoco();
	}

	/**
	 * finalizar aplicación
	 */
	private void salir() {
		Platform.exit();

	}

	/**
	 * llevar el foco al campo de texto y seleccionar todo
	 */
	private void cogerFoco() {
		txtNumero.requestFocus();
		txtNumero.selectAll();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
