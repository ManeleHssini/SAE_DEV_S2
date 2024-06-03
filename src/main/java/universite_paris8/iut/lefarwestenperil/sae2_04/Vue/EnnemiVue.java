package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.Group;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.*;

import java.net.URL;

public class EnnemiVue extends PersonnageVue{

    private Image imageDra ;
    private Image imageCb ;
    private ImageView iv2;


    public EnnemiVue(Pane panneauDeJeu) {
        super(panneauDeJeu);
        URL urlImageDra = Main.class.getResource("dragon.png");
        imageDra = new Image(String.valueOf(urlImageDra));
        URL urlImageCb = Main.class.getResource("CowBoy.png");
        imageCb = new Image(String.valueOf(urlImageCb));
    }

    public void creerEnnemi(Ennemi ennemi) {
        if (ennemi instanceof Dragon){
            iv2 = new ImageView(imageDra);
            iv2.setId(ennemi.getId());

        } else {
                iv2 = new ImageView(imageCb);
                iv2.setId(ennemi.getId());
        }
        ProgressBar barreDeVie =new ProgressBar();
        barreDeVie.setPrefWidth(32);
        barreDeVie.setPrefHeight(5);
        iv2.translateXProperty().bind(ennemi.xProperty());
        iv2.translateYProperty().bind(ennemi.yProperty());
        Group group = new Group(iv2);
        group.getChildren().add(barreDeVie);
        barreDeVie.translateXProperty().bind(ennemi.xProperty());
        ennemi.yProperty().addListener((observableValue, number, t1) -> {
            barreDeVie.setLayoutY(ennemi.getY()-20);
        });
        getPanneauDeJeu().getChildren().add(group);


    }

    public void supprimerEnnemi(Ennemi ennemi){
        getPanneauDeJeu().getChildren().remove(getPanneauDeJeu().lookup("#"+ ennemi.getId()));
        getPanneauDeJeu().getChildren().remove(getPanneauDeJeu().lookup("#"+ ennemi.getId()));
    }


}