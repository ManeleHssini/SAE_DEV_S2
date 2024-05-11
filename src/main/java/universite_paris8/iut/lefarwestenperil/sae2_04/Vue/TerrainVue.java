package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;


public class TerrainVue {

    private TilePane tuile;
    private Terrain terrain;

    public TerrainVue(Terrain terrain, TilePane tuile) {
        this.terrain = terrain;
        this.tuile = tuile;
    }

    public void creerCarte() {
        for (int i = 0; i < terrain.getTab().length; i++) {
            for (int j = 0; j < terrain.getTab()[i].length; j++) {
                Rectangle rectangle = new Rectangle(32, 32);
                if (terrain.getTab()[i][j] == 0) {
                    rectangle.setFill(Color.GOLD);
                } else if (terrain.getTab()[i][j] == 1) {
                    rectangle.setFill(Color.CORAL);
                } else if (terrain.getTab()[i][j] == 2) {
                    rectangle.setFill(Color.BROWN);
                } else if (terrain.getTab()[i][j] == 3) {
                    rectangle.setFill(Color.GREEN);
                } else {
                    rectangle.setFill(Color.BLUE);
                }
                tuile.getChildren().add(rectangle);
            }
        }
    }
}