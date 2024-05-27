package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;

import java.net.URL;

public class CowBoyVue extends EnnemiVue{

    private Image imageCowboy;
    private ImageView iv1;

    public CowBoyVue(Pane panneauDeJeu) {
        super(panneauDeJeu);
        URL urlImageEnn = Main.class.getResource("CowBoy.png");
        imageCowboy = new Image(String.valueOf(urlImageEnn));
    }

}
