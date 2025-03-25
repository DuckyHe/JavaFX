package vue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class PremiereApplication extends Application {

    public void start(Stage stage)   {
        File css = new File("css"+File.separator+"premiersStyles.css");
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 300, 80);
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.show();
        Label labelHello = new Label("Hello");
        root.getChildren().add(labelHello);
        Label labelHelloBis = new Label("Hello JavaFX");
        root.getChildren().add(labelHelloBis);
        scene.getStylesheets().add(css.toURI().toString());
    }

    public static void main(String[] args) {
        Application.launch();
    }

}