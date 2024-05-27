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

public class LinkVue extends PersonnageVue {
    private Image imageLink;
    private ImageView iv3;

    public LinkVue(Pane panneauDeJeu) {
        super(panneauDeJeu);
        URL urlImageEnn = Main.class.getResource("link.png");
        imageLink = new Image(String.valueOf(urlImageEnn));
    }

    public void creerLink(Personnage personnage) {
        iv3 = new ImageView(imageLink);
        iv3.translateXProperty().bind(personnage.xProperty());
        iv3.translateYProperty().bind(personnage.yProperty());
        super.getPanneauDeJeu().getChildren().add(iv3);
    }

}
