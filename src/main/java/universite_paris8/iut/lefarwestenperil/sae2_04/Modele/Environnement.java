package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {
    private ObservableList<Ennemi> ennemis;
    private ObservableList<BarreDeVie> barreDeVies;
    private IntegerProperty nombreEnnemis;
    private int tours;
    private Terrain terrain;

    public Environnement(Terrain terrain) {
        this.ennemis = FXCollections.observableArrayList();
        this.barreDeVies = FXCollections.observableArrayList();
        this.tours = 0;
        this.terrain = terrain;
        this.nombreEnnemis = new SimpleIntegerProperty(0);
    }

    public void unTour() {
        this.tours++;
    }


}
