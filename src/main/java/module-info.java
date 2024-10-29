module org.hugo.ejerciciok {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.hugo.ejerciciok to javafx.fxml;
    exports org.hugo.ejerciciok;
}