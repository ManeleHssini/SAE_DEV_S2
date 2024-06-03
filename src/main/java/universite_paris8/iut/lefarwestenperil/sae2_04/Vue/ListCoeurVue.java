package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.HBox;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Link;

import java.util.ArrayList;
import java.util.List;

public class ListCoeurVue {
    private List<CoeurVue> coeurs;

    public ListCoeurVue(Link link, HBox vieBox) {
        coeurs = new ArrayList<>();

        int nbCoeurs = (int) Math.ceil(link.getPointVie() / 4.0);
        for (int i = 0; i < nbCoeurs; i++) {
            CoeurVue coeur = new CoeurVue();
            coeurs.add(coeur);
            vieBox.getChildren().add(coeur.getImageView());
        }

        mettreAJourCoeurs(link.getPointVie());
    }

    public void mettreAJourCoeurs(int vie) {
        int coeursPleins = vie / 4;
        int reste = vie % 4;

        for (int i = 0; i < coeurs.size(); i++) {
            if (i < coeursPleins) {
                coeurs.get(i).setVie(4);
            } else if (i == coeursPleins) {
                coeurs.get(i).setVie(reste);
            } else {
                coeurs.get(i).setVie(0);
            }
        }
    }
}
