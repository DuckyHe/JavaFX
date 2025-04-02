package vue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class Projet2Application extends Application {
    public void start(Stage stage) {
        VBox root = new VBoxRoot(3,2025);
        Scene scene = new Scene(root, 400, 380);
        File[] fichiersCss = new File("css").listFiles();
        for (File fichier : fichiersCss) {
            scene.getStylesheets().add(fichier.toURI().toString());
        }
        stage.setScene(scene);
        stage.setTitle("Calendrier du mois");
        stage.show();
    }
    public static void main (String [] args) {
        Application.launch(args);
    }
}