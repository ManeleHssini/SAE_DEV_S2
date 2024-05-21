package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

public abstract class EnnemiVue extends PersonnageVue{
    public EnnemiVue(Terrain terrain, Pane panneauDeJeu) {
        super(terrain, panneauDeJeu);
    }


}