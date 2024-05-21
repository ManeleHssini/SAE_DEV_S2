package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

public class DragonVue extends EnnemiVue{
    public DragonVue(Terrain terrain, Pane panneauDeJeu) {
        super(terrain, panneauDeJeu);
    }

    @Override
    public void creerPersonnage(Personnage personnage) {
        Circle circle = new Circle(7, Color.PURPLE);
        circle.translateXProperty().bind(personnage.xProperty());
        circle.translateYProperty().bind(personnage.yProperty());
        super.getPanneauDeJeu().getChildren().add(circle);
    }
}
