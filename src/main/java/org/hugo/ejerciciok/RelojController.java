package org.hugo.ejerciciok;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * La clase RelojController se encarga de gestionar la lógica del reloj en la
 * aplicación JavaFX. Controla la actualización de las imágenes que representan
 * las horas, minutos y segundos en la interfaz de usuario.
 */
public class RelojController {

    @FXML
    private ImageView imgHorasDerecha;
    @FXML
    private ImageView imgHorasIzquierda;
    @FXML
    private ImageView imgMinutosDerecha;
    @FXML
    private ImageView imgMinutosIzquierda;
    @FXML
    private ImageView imgSegundosDerecha;
    @FXML
    private ImageView imgSegundosIzquierda;

    private final Timer timer = new Timer();

    /**
     * Este método se invoca automáticamente al inicializar el controlador.
     * Se utiliza para iniciar el reloj.
     */
    public void initialize() {
        startClock();
    }

    /**
     * Inicia un temporizador que actualiza la hora cada segundo.
     */
    private void startClock() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                updateClock();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Actualiza cada segundo
    }

    /**
     * Actualiza la hora, los minutos y los segundos del reloj.
     * Llama a los métodos correspondientes para actualizar las imágenes.
     */
    private void updateClock() {
        LocalDateTime now = LocalDateTime.now();
        int horas = now.getHour();
        int minutos = now.getMinute();
        int segundos = now.getSecond();
        actualizarHorasImages(horas);
        actualizarMinutosImages(minutos);
        actualizarSegundosImages(segundos);
    }

    /**
     * Actualiza las imágenes que representan las horas en el reloj.
     *
     * @param horas el número de horas actual.
     */
    private void actualizarHorasImages(int horas) {
        int leftHour = horas / 10; // Horas a la izquierda
        int rightHour = horas % 10; // Horas a la derecha
        imgHorasIzquierda.setImage(getImageForNumber(leftHour));
        imgHorasDerecha.setImage(getImageForNumber(rightHour));
    }

    /**
     * Actualiza las imágenes que representan los minutos en el reloj.
     *
     * @param minutos el número de minutos actual.
     */
    private void actualizarMinutosImages(int minutos) {
        int leftMinute = minutos / 10; // Minutos a la izquierda
        int rightMinute = minutos % 10; // Minutos a la derecha
        imgMinutosIzquierda.setImage(getImageForNumber(leftMinute));
        imgMinutosDerecha.setImage(getImageForNumber(rightMinute));
    }

    /**
     * Actualiza las imágenes que representan los segundos en el reloj.
     *
     * @param segundos el número de segundos actual.
     */
    private void actualizarSegundosImages(int segundos) {
        int leftSecond = segundos / 10; // Segundos a la izquierda
        int rightSecond = segundos % 10; // Segundos a la derecha
        imgSegundosIzquierda.setImage(getImageForNumber(leftSecond));
        imgSegundosDerecha.setImage(getImageForNumber(rightSecond));
    }

    /**
     * Devuelve la imagen correspondiente a un número del 0 al 9.
     *
     * @param number el número para el cual se desea obtener la imagen.
     * @return la imagen correspondiente al número.
     */
    private javafx.scene.image.Image getImageForNumber(int number) {
        String imageName = switch (number) {
            case 0 -> "ZERO.png";
            case 1 -> "ONE.png";
            case 2 -> "TWO.png";
            case 3 -> "THREE.png";
            case 4 -> "FOUR.png";
            case 5 -> "FIVE.png";
            case 6 -> "SIX.png";
            case 7 -> "SEVEN.png";
            case 8 -> "EIGHT.png";
            case 9 -> "NINE.png";
            default -> "ZERO.png"; // Por defecto, si el número es inválido
        };
        return new javafx.scene.image.Image(getClass().getResourceAsStream("/Imagenes/" + imageName));
    }
}
