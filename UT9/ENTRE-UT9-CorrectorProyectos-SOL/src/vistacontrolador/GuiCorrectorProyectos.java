
package vistacontrolador;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.AlumnoNoExistenteExcepcion;
import modelo.CorrectorProyectos;
import modelo.Proyecto;

public class GuiCorrectorProyectos extends Application
{

	private MenuItem itemLeer;
	private MenuItem itemGuardar;
	private MenuItem itemSalir;

	private TextField txtAlumno;
	private Button btnVerProyecto;

	private RadioButton rbtAprobados;
	private RadioButton rbtOrdenados;
	private Button btnMostrar;

	private TextArea areaTexto;

	private Button btnClear;
	private Button btnSalir;

	private CorrectorProyectos corrector;

	@Override
	public void start(Stage stage) {

		corrector = new CorrectorProyectos();

		BorderPane root = crearGui();

		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		stage.setTitle("- Corrector de proyectos -");
		scene.getStylesheets().add(getClass()
		                .getResource("/css/application.css").toExternalForm());
		stage.show();
	}

	private BorderPane crearGui() {

		BorderPane panel = new BorderPane();
		MenuBar barraMenu = crearBarraMenu();
		panel.setTop(barraMenu);

		VBox panelPrincipal = crearPanelPrincipal();
		panel.setCenter(panelPrincipal);

		HBox panelBotones = crearPanelBotones();
		panel.setBottom(panelBotones);

		return panel;
	}

	private MenuBar crearBarraMenu() {

		MenuBar barraMenu = new MenuBar();

		Menu menu = new Menu("Archivo");

		itemLeer = new MenuItem("_Leer de fichero");
		itemLeer.setAccelerator(KeyCombination.keyCombination("CTRL+L"));
		itemLeer.setOnAction(e -> leerDeFichero());
		menu.getItems().add(itemLeer);

		itemGuardar = new MenuItem("_Guardar en fichero");
		itemGuardar.setAccelerator(KeyCombination.keyCombination("CTRL+G"));
		itemGuardar.setDisable(true);
		itemGuardar.setOnAction(e -> salvarEnFichero());

		menu.getItems().add(itemGuardar);

		menu.getItems().add(new SeparatorMenuItem());

		itemSalir = new MenuItem("_Salir");
		itemSalir.setAccelerator(KeyCombination.keyCombination("CTRL+S"));
		itemSalir.setOnAction(e -> salir());
		menu.getItems().add(itemSalir);

		barraMenu.getMenus().add(menu);
		return barraMenu;
	}

	private void salvarEnFichero() {

		try {
			corrector.guardarOrdenadosPorNota();
			areaTexto.setText(
			                "Guardados en fichero de texto los proyectos ordenados\n");
		}
		catch (IOException e) {
			areaTexto.setText(e.getMessage());
		}
	}

	private void leerDeFichero() {

		corrector.leerDatosProyectos();
		areaTexto.setText("Leído fichero de texto\n\n");
		areaTexto.appendText(corrector.getErrores().toString() + "\n\n");
		areaTexto.appendText(
		                "Ya están guardados en memoria los datos de los proyectos\n");
		itemLeer.setDisable(true);
		itemGuardar.setDisable(false);

		cogerFoco();
	}

	private void cogerFoco() {

		txtAlumno.requestFocus();
		txtAlumno.selectAll();

	}

	private VBox crearPanelPrincipal() {

		VBox panel = new VBox();
		panel.setPadding(new Insets(5));
		panel.setSpacing(10);

		Label lblEntrada = new Label("Panel de entrada");
		lblEntrada.setMaxWidth(Integer.MAX_VALUE);
		lblEntrada.getStyleClass().add("titulo-panel");
		panel.getChildren().add(lblEntrada);

		HBox pnlEntrada = crearPanelEntrada();
		panel.getChildren().add(pnlEntrada);

		Label lblOpciones = new Label("Panel de opciones");
		lblOpciones.setMaxWidth(Integer.MAX_VALUE);
		lblOpciones.getStyleClass().add("titulo-panel");
		panel.getChildren().add(lblOpciones);

		HBox pnlOpciones = crearPanelOpciones();
		panel.getChildren().add(pnlOpciones);

		areaTexto = new TextArea();
		panel.getChildren().add(areaTexto);
		VBox.setVgrow(areaTexto, Priority.ALWAYS);

		return panel;
	}

	private HBox crearPanelEntrada() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(5));
		panel.setSpacing(10);

		Label lblNombre = new Label("Alumno");
		txtAlumno = new TextField();
		txtAlumno.setPrefColumnCount(30);
		txtAlumno.setOnAction(e -> verProyecto());

		btnVerProyecto = new Button("Ver proyecto");
		btnVerProyecto.setPrefWidth(120);
		btnVerProyecto.setOnAction(e -> verProyecto());

		panel.getChildren().addAll(lblNombre, txtAlumno, btnVerProyecto);

		return panel;
	}

	private void verProyecto() {

		if (!itemLeer.isDisable()) {
			areaTexto.setText("No se han leído todavía los datos del fichero\n"
			                + "Vaya a la opción leer del menú");
		}
		else {
			String alumno = txtAlumno.getText();
			if (alumno.isEmpty()) {
				areaTexto.setText("Teclee nombre de alumno");
			}
			else {
				try {
					Proyecto proyecto = corrector.proyectoDe(alumno);
					areaTexto.setText(proyecto.toString());
				}
				catch (AlumnoNoExistenteExcepcion e) {
					areaTexto.setText("Alumno/a no existente");
				}
			}

		}
		cogerFoco();

	}

	private HBox crearPanelOpciones() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(5));
		panel.setSpacing(50);
		panel.setAlignment(Pos.CENTER);

		rbtAprobados = new RadioButton("Mostrar aprobados");
		rbtAprobados.setSelected(true);
		rbtOrdenados = new RadioButton("Mostrar ordenados");
		ToggleGroup grupo = new ToggleGroup();
		rbtAprobados.setToggleGroup(grupo);
		rbtOrdenados.setToggleGroup(grupo);

		btnMostrar = new Button("Mostrar");
		btnMostrar.setPrefWidth(120);
		btnMostrar.setOnAction(e -> mostrar());
		panel.getChildren().addAll(rbtAprobados, rbtOrdenados, btnMostrar);

		return panel;
	}

	private void mostrar() {

		clear();
		if (!itemLeer.isDisable()) {
			areaTexto.setText("No se han leído todavía los datos del fichero\n"
			                + "Vaya a la opción leer del menú");
		}
		else {
			if (rbtOrdenados.isSelected()) {
				List<Map.Entry<String, Proyecto>> ordenados =
				                corrector.ordenadosPorNota();
				for (Entry<String, Proyecto> entrada : ordenados) {
					areaTexto.appendText(
					                String.format("%20s\n", entrada.getKey())
					                                + entrada.getValue()
					                                + "\n");
				}

			}
			else {
				areaTexto.setText("Han aprobado el proyecto "
				                + corrector.aprobados() +
				                " alumnos/as");

			}
		}
	}

	private HBox crearPanelBotones() {

		HBox panel = new HBox();
		panel.setPadding(new Insets(5));
		panel.setSpacing(10);
		panel.setAlignment(Pos.CENTER_RIGHT);

		btnClear = new Button("Clear");
		btnClear.setPrefWidth(90);
		btnClear.setOnAction(e -> clear());
		btnSalir = new Button("Salir");
		btnSalir.setOnAction(e -> salir());
		btnSalir.setPrefWidth(90);

		panel.getChildren().addAll(btnClear, btnSalir);

		return panel;
	}

	private void salir() {

		Platform.exit();
	}

	private void clear() {

		areaTexto.clear();
		cogerFoco();
	}

	public static void main(String[] args) {

		launch(args);
	}
}
