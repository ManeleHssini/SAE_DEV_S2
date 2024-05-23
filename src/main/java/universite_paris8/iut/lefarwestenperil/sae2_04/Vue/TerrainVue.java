package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        URL urlImageSol = Main.class.getResource("sand_mountain_image_32x32.png");
        Image imageSol = new Image(String.valueOf(urlImageSol));

        URL urlImageSol2 = Main.class.getResource("eauu.png");
        Image imageSol2 = new Image(String.valueOf(urlImageSol2));

        URL urlImageSol4 = Main.class.getResource("textured_sand_image_32x32.png");
        Image imageSol4 = new Image(String.valueOf(urlImageSol4));


        for (int i = 0; i < terrain.getTab().length; i++) {
            for (int j = 0; j < terrain.getTab()[i].length; j++) {


                if (terrain.getTab()[i][j] == 0) {
                    ImageView iv2 = new ImageView(imageSol4);
                    this.tuile.getChildren().add(iv2);
                } else if (terrain.getTab()[i][j] == 1) {
                    ImageView iv1 = new ImageView(imageSol);
                    this.tuile.getChildren().add(iv1);

                } else if (terrain.getTab()[i][j] == 2) {
                    Rectangle rectangle = new Rectangle(32, 32);
                    rectangle.setFill(Color.BLACK);
                    this.tuile.getChildren().add(rectangle);
                } else if (terrain.getTab()[i][j] == 3) {
                    Rectangle rectangle = new Rectangle(32, 32);
                    rectangle.setFill(Color.GREEN);
                    this.tuile.getChildren().add(rectangle);
                } else {
                    ImageView iv4 = new ImageView(imageSol2);
                    this.tuile.getChildren().add(iv4);
                }
            }
        }
    }
}