package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.TilePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.net.URL;

public class TerrainVue {

    private TilePane tuile;
    private Terrain terrain;

    public TerrainVue(Terrain terrain, TilePane tuile) {
        this.terrain = terrain;
        this.tuile = tuile;
    }

    public void creerCarte() {

        URL urlImageSol = Main.class.getResource("sable.png");
        Image imageSol = new Image(String.valueOf(urlImageSol));

        URL urlImageSol2 = Main.class.getResource("dune.png");
        Image imageSol2 = new Image(String.valueOf(urlImageSol2));

        URL urlImageSol3 = Main.class.getResource("troue.png");
        Image imageSol3 = new Image(String.valueOf(urlImageSol3));

        URL urlImageSol4 = Main.class.getResource("cactus (2).png");
        Image imageSol4 = new Image(String.valueOf(urlImageSol4));

        URL urlImageSol5 = Main.class.getResource("eau.png");
        Image imageSol5 = new Image(String.valueOf(urlImageSol5));

        URL urlImageSol6 = Main.class.getResource("tente1.png");
        Image imageSol6 = new Image(String.valueOf(urlImageSol6));

        for (int i = 0; i < terrain.getTab().length; i++) {
            for (int j = 0; j < terrain.getTab()[i].length; j++) {

                if (terrain.getTab()[i][j] == 0) {
                    ImageView iv1 = new ImageView(imageSol2);
                    this.tuile.getChildren().add(iv1);
                } else if (terrain.getTab()[i][j] == 1) {
                    ImageView iv2 = new ImageView(imageSol);
                    this.tuile.getChildren().add(iv2);
                } else if (terrain.getTab()[i][j] == 2) {
                    ImageView iv3 = new ImageView(imageSol3);
                    this.tuile.getChildren().add(iv3);
                } else if (terrain.getTab()[i][j] == 3) {
                    ImageView iv4 = new ImageView(imageSol4);
                    this.tuile.getChildren().add(iv4);
                } else if (terrain.getTab()[i][j] == 4){
                    ImageView iv5 = new ImageView(imageSol5);
                    this.tuile.getChildren().add(iv5);
                }else{
                    ImageView iv6 = new ImageView(imageSol6);
                    this.tuile.getChildren().add(iv6);

                }
            }
        }
    }
}

