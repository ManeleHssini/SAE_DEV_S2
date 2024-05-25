package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.net.URL;

public class DragonVue extends EnnemiVue {

    private Image imageDragon;
    private ImageView iv2;

    public DragonVue(Terrain terrain, Pane panneauDeJeu) {
        super(terrain, panneauDeJeu);
        URL urlImageEnn = Main.class.getResource("dragon.png");
        imageDragon = new Image(String.valueOf(urlImageEnn));
    }
    public void creerPersonnage(Personnage personnage) {
        iv2 = new ImageView(imageDragon);
        iv2.translateXProperty().bind(personnage.xProperty());
        iv2.translateYProperty().bind(personnage.yProperty());
        super.getPanneauDeJeu().getChildren().add(iv2);
    }
}
