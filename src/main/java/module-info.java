module org.example.projetjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.projetjavafx to javafx.fxml;
    exports vue;
    exports org.example.projetjavafx;
}