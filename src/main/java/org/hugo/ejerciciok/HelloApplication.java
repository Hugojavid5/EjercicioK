package org.hugo.ejerciciok;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase HelloApplication es la clase principal de la aplicación JavaFX que
 * representa un reloj. Extiende la clase {@link Application} y es responsable
 * de iniciar la interfaz de usuario.
 */
public class HelloApplication extends Application {

    /**
     * El método start es el punto de entrada de la aplicación. Se invoca cuando
     * la aplicación se inicia y se encarga de cargar el archivo FXML y crear la
     * escena.
     *
     * @param stage el escenario principal de la aplicación.
     * @throws IOException si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EjercicioK.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 465, 400);
        stage.setTitle("Reloj");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * El método main es el punto de entrada de la aplicación. Llama al método
     * launch para iniciar la aplicación JavaFX.
     *
     * @param args argumentos de línea de comandos pasados a la aplicación.
     */
    public static void main(String[] args) {
        launch();
    }
}
