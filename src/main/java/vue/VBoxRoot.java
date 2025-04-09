package vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modele.CalendrierDuMois;
import modele.DateCalendrier;

import java.util.Collection;
import java.util.List;

public class VBoxRoot extends VBox {

    private int currentMonth; // Mois courant
    private StackPane stackPaneMois; // Conteneur des mois

    public VBoxRoot(int moisInitial, int anneeInitiale) {
        super(15); // Espacement de 15 entre les éléments
        this.currentMonth = moisInitial;

        // Titre avec le mois et l'année
        Label labelTitle = new Label("Calendrier de l'année " + anneeInitiale);

        // Boutons pour naviguer entre les mois
        Button boutonPrevious = new Button("<");
        Button boutonNext = new Button(">");
        Button boutonDebut = new Button("<<");
        Button boutonFin = new Button(">>");

        // Conteneur HBox pour aligner le titre et les boutons
        HBox header = new HBox(10, labelTitle, boutonPrevious, boutonNext,boutonDebut,boutonFin);
        header.setAlignment(Pos.CENTER_RIGHT); // Aligner les boutons à droite
        VBox.setMargin(header, new Insets(10));

        // Conteneur StackPane pour empiler les 12 mois
        stackPaneMois = new StackPane();

        // Ajouter les 12 ScrollPane pour chaque mois
        for (int mois = 1; mois <= 12; mois++) {
            // Créer un calendrier pour le mois et l'année
            CalendrierDuMois calendrier = new CalendrierDuMois(mois, anneeInitiale);
            Collection<DateCalendrier> dates = calendrier.getDates();

            // Conteneur VBox pour les dates du mois
            VBox boiteDates = new VBox();
            boiteDates.setSpacing(5);

            // Ajouter les dates au VBox
            for (DateCalendrier date : dates) {
                Label labelDate = new Label(date.toString());
                boiteDates.getChildren().add(labelDate);
            }

            // Créer un ScrollPane pour le mois
            ScrollPane scrollPaneMois = new ScrollPane(boiteDates);
            scrollPaneMois.setFitToWidth(true);

            // Associer le nom du mois au ScrollPane
            scrollPaneMois.setAccessibleText(String.valueOf(mois));

            // Ajouter le ScrollPane au StackPane
            stackPaneMois.getChildren().add(scrollPaneMois);
        }

        // Placer le mois courant en haut de la pile
        afficherMoisCourant();

        // Ajouter les actions des boutons
        boutonPrevious.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton previous");
                currentMonth = (currentMonth == 1) ? 12 : currentMonth - 1; // Passer à décembre si janvier
                afficherMoisCourant();
            }
        });
        boutonDebut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton début");
                currentMonth =  1;
                afficherMoisCourant();
            }
        });
        boutonFin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton fin");
                currentMonth =  12;
                afficherMoisCourant();
            }
        });
        boutonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                currentMonth = (currentMonth == 12) ? 1 : currentMonth + 1; // Passer à janvier si décembre
                afficherMoisCourant();
            }
        });

        // Ajouter le header et le StackPane à la VBox principale
        this.getChildren().addAll(header, stackPaneMois);
    }

    /**
     * Méthode pour afficher le mois courant en haut de la pile.
     */
    private void afficherMoisCourant() {
        List<javafx.scene.Node> enfants = stackPaneMois.getChildren();
        for (javafx.scene.Node node : enfants) {
            if (node instanceof ScrollPane) {
                ScrollPane scrollPane = (ScrollPane) node;
                if (scrollPane.getAccessibleText().equals(String.valueOf(currentMonth))) {
                    scrollPane.toFront(); // Placer le mois courant en haut de la pile
                    break;
                }
            }
        }
    }
}