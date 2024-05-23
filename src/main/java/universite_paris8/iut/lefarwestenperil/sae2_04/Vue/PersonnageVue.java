package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

public abstract class PersonnageVue {
    private Pane panneauDeJeu;


    public PersonnageVue(Terrain terrain, Pane panneauDeJeu) {
        this.panneauDeJeu = panneauDeJeu;
    }
    public Pane getPanneauDeJeu() {
        return this.panneauDeJeu;
    }

    public abstract void creerPersonnage(Personnage personnage);
}
