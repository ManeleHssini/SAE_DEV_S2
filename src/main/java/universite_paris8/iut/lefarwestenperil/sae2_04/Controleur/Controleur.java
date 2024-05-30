package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.*;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.KeyEvent;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.*;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrain = new Terrain();
        link = new Link( terrain);

        env = new Environnement(terrain, link);

        TerrainVue tv = new TerrainVue(terrain, tuile);
        linkVue = new LinkVue(panneauDeJeu);

        tv.creerCarte();

        linkVue.creerLink(link);

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

        initAnimation();
        gameLoop.play();



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
        System.out.println("Position du personnage: x=" + link.getX() + ", y=" + link.getY());
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.1),
                (ev ->{
                    env.unTour();
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }
}
