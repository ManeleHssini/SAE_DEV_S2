package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

public class PersonnageVue {
    private Pane panneauDeJeu;
    private Terrain terrain;

    public PersonnageVue(Terrain terrain, Pane panneauDeJeu) {
        this.terrain = terrain;
        this.panneauDeJeu = panneauDeJeu;
    }

    public void creerPersonnage(Personnage personnage) {
        Circle circle = new Circle(7, Color.RED);
        circle.translateXProperty().bind(personnage.xProperty());
        circle.translateYProperty().bind(personnage.yProperty());
        panneauDeJeu.getChildren().add(circle);
    }
}
