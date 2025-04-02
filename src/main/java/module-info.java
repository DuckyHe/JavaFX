module projet.javafx {
    exports modele;
    exports vue;
    exports org.example.projetjavafx2; // Ajoutez cette ligne pour exporter le package contenant HelloApplication

    requires javafx.controls;
    requires javafx.fxml;
}