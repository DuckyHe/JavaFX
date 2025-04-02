package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;
import modele.CalendrierDuMois;
import java.util.Collection;
import java.util.Iterator;

public class VBoxRoot extends VBox {

    public VBoxRoot(int nbDuMois, int annee) {
        super(15); // Espacement de 10 entre les éléments
        VBox v = new VBox();
        StackPane stackPaneDates = new ScrollPane();
        scrollPaneDates.setContent(v);
        VBox.setMargin(scrollPaneDates, new Insets(15));

        CalendrierDuMois cal = new CalendrierDuMois(nbDuMois,annee);
        Collection<DateCalendrier> test = cal.getDates();
        Iterator<DateCalendrier> iterator = test.iterator();
        while(iterator.hasNext()){
            DateCalendrier date = iterator.next();
            Label texdate = new Label(date.toString());
            v.getChildren().add(texdate);
        }
        this.getChildren().add(scrollPaneDates);
    }
}
