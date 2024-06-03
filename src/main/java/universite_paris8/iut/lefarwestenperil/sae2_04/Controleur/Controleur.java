package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.*;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Controleur implements Initializable {
    private Terrain terrain;
    private Timeline gameLoop;
    private Environnement env;
    private Link link;
    private LinkVue linkVue;
    @FXML
    private Pane panneauDeJeu;
    @FXML
    private TilePane tuile;
    private Scale scaleTransform;
    @FXML
    private HBox vieBox;

    private ListCoeurVue coeurVue;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrain = new Terrain();
        link = new Link(terrain,8);

        env = new Environnement(terrain, link);

        TerrainVue tv = new TerrainVue(terrain, tuile);
        linkVue = new LinkVue(panneauDeJeu);

        tv.creerCarte();
        linkVue.creerLink(link);
        ListChangeListener<BarreDeVie> listenB = new ListObsBarreDeVie(panneauDeJeu);
        env.getBarreDeVies().addListener(listenB);

        ListChangeListener<BarreDeVie> listenB = new ListObsBarreDeVie(panneauDeJeu);
        env.getBarreDeVies().addListener(listenB);

        ListChangeListener<Ennemi> listenE = new ListObsEnnemis(panneauDeJeu);
        env.getEnnemis().addListener(listenE);

        this.env.ajouterEnnemisAleatoirement(50);
        panneauDeJeu.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(this::gererTouchePressee);
            }
        });


        scaleTransform = new Scale();
        panneauDeJeu.getTransforms().add(scaleTransform);
        scaleTransform.setPivotX(link.getX()-200);
        scaleTransform.setPivotY(link.getY()-200);
        setScale(1);

        coeurVue = new ListCoeurVue(link, vieBox);

        initAnimation();
        gameLoop.play();
    }

    private void setScale(double scale) {
        scaleTransform.setX(scale);
        scaleTransform.setY(scale);
    }


    @FXML
    private void gererTouchePressee(KeyEvent event) {
        System.out.println("Touche pressée: " + event.getCode());
        switch (event.getCode()) {
            case Z:
                link.deplacerHaut();
                break;
            case Q:
                link.deplacerGauche();
                break;
            case S:
                link.deplacerBas();
                break;
            case D:
                link.deplacerDroite();
                break;
            default:
                return;
        }
        miseAJourZoom();
        System.out.println("Position du personnage: x=" + link.getX() + ", y=" + link.getY());
    }


    public void miseAJourZoom(){
        double paneWidth = panneauDeJeu.getWidth();
        double paneHeight = panneauDeJeu.getHeight();
        double linkX = link.getX();
        double linkY = link.getY();

        panneauDeJeu.setTranslateX(-linkX * scaleTransform.getX() + paneWidth / 2);
        panneauDeJeu.setTranslateY(-linkY * scaleTransform.getY() + paneHeight / 2);
}

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        AtomicInteger i = new AtomicInteger();

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.1),
                ev -> {
                    env.unTour();
                    miseAJourZoom();

                    i.getAndIncrement();
                    System.out.println(i.get());
                    if (i.get() == 30) {
                        link.recevoirDegats(2);
                        i.set(0);
                    }
                    coeurVue.mettreAJourCoeurs(link.getPointVie());

                }
        );
        gameLoop.getKeyFrames().add(kf);
    }
}
