package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.BarreDeVieVue;


public class ListObsBarreDeVie implements ListChangeListener<BarreDeVie> {

    private Pane panneauDeJeu;
    private BarreDeVieVue barreDeVieVue;

    public ListObsBarreDeVie(Pane PanneauJeu) {
        this.panneauDeJeu = PanneauJeu;
        barreDeVieVue = new BarreDeVieVue(PanneauJeu);
    }

    @Override
    public void onChanged(Change<? extends BarreDeVie> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (BarreDeVie b : change.getAddedSubList()) {
                    System.out.println("add");
                    barreDeVieVue.afficherBarreVie(b);
                }
            }
        }
    }
}
