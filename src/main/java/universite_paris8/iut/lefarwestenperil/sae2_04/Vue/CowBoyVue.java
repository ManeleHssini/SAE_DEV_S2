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


public class CowBoyVue extends EnnemiVue{

    private Image imageCowboy;
    private ImageView iv1;


    public CowBoyVue(Terrain terrain, Pane panneauDeJeu) {
        super(terrain, panneauDeJeu);
        URL urlImageEnn = Main.class.getResource("CowBoy.png");
        imageCowboy = new Image(String.valueOf(urlImageEnn));
    }
    public void creerPersonnage(Personnage personnage) {
        iv1 = new ImageView(imageCowboy);
        iv1.translateXProperty().bind(personnage.xProperty());
        iv1.translateYProperty().bind(personnage.yProperty());
        super.getPanneauDeJeu().getChildren().add(iv1);
    }
}
