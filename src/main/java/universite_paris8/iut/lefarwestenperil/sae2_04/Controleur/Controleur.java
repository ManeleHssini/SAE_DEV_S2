package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.KeyEvent;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.LinkVue;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.PersonnageVue;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.TerrainVue;

public class Controleur implements Initializable {
    private Terrain terrain;
    private Timeline gameLoop;

    private Personnage personnage;
    private PersonnageVue personnageVue;
    @FXML
    private Pane panneauDeJeu;
    @FXML
    private TilePane tuile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrain = new Terrain();
        personnage = new Personnage(336, 16, terrain);
        TerrainVue tv = new TerrainVue(terrain, tuile);
        personnageVue = new LinkVue(terrain, panneauDeJeu);
        tv.creerCarte();
       // tv.afficherTerrain();

        personnageVue.creerPersonnage(personnage);

//        panneauDeJeu.setOnKeyPressed(event -> {
//            gererTouchePressee(event);
//        });

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
                personnage.deplacerHaut();
                break;
            case Q:
                personnage.deplacerGauche();
                break;
            case S:
                personnage.deplacerBas();
                break;
            case D:
                personnage.deplacerDroite();
                break;
            default:
                return;
        }
        System.out.println("Position du personnage: x=" + personnage.getX() + ", y=" + personnage.getY());
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.1),
                (ev ->{})
        );
        gameLoop.getKeyFrames().add(kf);
    }
}
