package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TerrainVue {

    private TilePane tuile;
    private Terrain terrain;

    public TerrainVue(Terrain terrain, TilePane tuile) {
        this.terrain = terrain;
        this.tuile = tuile;
    }

    public void creerCarte() {
        try {
            // Chargement du fichier TMX créé avec Tiled
            FileInputStream inputStream = new FileInputStream("src/main/resources/universite_paris8/iut/lefarwestenperil/sae2_04/terrainzelda2.tmx");
            Image imageSol = new Image(inputStream);

            // Parcours du tableau de terrain
            for (int i = 0; i < terrain.getTab().length; i++) {
                for (int j = 0; j < terrain.getTab()[i].length; j++) {
                    // Création d'une ImageView pour chaque tuile
                    ImageView imageView = new ImageView(imageSol);
                    imageView.setX(j * 32);  // Position en X de l'image
                    imageView.setY(i * 32);  // Position en Y de l'image
                    imageView.setFitWidth(32);  // Largeur de l'image
                    imageView.setFitHeight(32); // Hauteur de l'image
                    tuile.getChildren().add(imageView);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

