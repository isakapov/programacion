import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.geometry.Pos;
import javafx.stage.Stage; 
import javafx.application.Platform;
public class SaludoGrafico extends Application
{ 
    @Override 
    public void start(Stage primaryStage)
    { 

        BorderPane root = new BorderPane();
        Label lblSaludo = new Label("Bienvenido/a a la POO en Java");
        lblSaludo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        root.setCenter(lblSaludo);
        Button btnSalir = new Button("Salir"); 
        btnSalir.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnSalir.setOnAction(e -> Platform.exit());
        root.setBottom(btnSalir);
        BorderPane.setAlignment(btnSalir, Pos.CENTER);
        Scene scene = new Scene(root, 400, 250); 
        String style = getClass().getResource("estilo.css").toExternalForm(); 
        scene.getStylesheets().addAll(style);
        primaryStage.setTitle("Saludo gráfico en Java");    
        primaryStage.setScene(scene);     
        primaryStage.show(); 
    } 

    public static void main(String[] args) 
    {  
        launch(args); 
    } 
} 
