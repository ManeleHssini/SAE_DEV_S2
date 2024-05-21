package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;




import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.BarreDeVie;

public class BarreDeVieVue {
    private Pane panneauJeu;

    public BarreDeVieVue (Pane panneauJeu) {
        this.panneauJeu = panneauJeu;
    }

    public void afficherBarreVie(BarreDeVie barre){
        ProgressBar barreDeVie = new ProgressBar();
        barreDeVie.setId(barre.getId());
        barreDeVie.setProgress(barre.getVieTotale()); // Ajustez la valeur de progression de la barre de vie
        barreDeVie.setTranslateX(barre.getX());
        barreDeVie.setTranslateY(barre.getY());
        barreDeVie.setMaxHeight(10);
        barreDeVie.setMaxWidth(30);
        barreDeVie.setStyle("-fx-accent: green"); // Utilisez la couleur appropriée en fonction de la vie
        this.panneauJeu.getChildren().add(barreDeVie);
        System.out.println(barre.getVieTotale());
        barreDeVie.translateXProperty().bind(barre.xProperty());
        barreDeVie.translateYProperty().bind(barre.yProperty());
        barreDeVie.progressProperty().bind(barre.vieTotaleProperty());
        barre.vieTotaleProperty().addListener(event -> {
            double pourcentageVie = barre.getVieTotale();
            if (pourcentageVie <= 0.55) {
                barreDeVie.setStyle("-fx-accent: red"); // Rouge pour moins de 30% de vie
            } else if (pourcentageVie <= 0.85) {
                barreDeVie.setStyle("-fx-accent: orange"); // Orange pour 30% à 70% de vie
            } else {
                barreDeVie.setStyle("-fx-accent: green"); // Vert pour plus de 70% de vie
            }
        });
    }
}


