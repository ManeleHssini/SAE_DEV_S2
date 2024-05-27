package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;


public class Environnement {
    private ObservableList<Ennemi> ennemis;
    private ObservableList<BarreDeVie> barreDeVies;
    private IntegerProperty nombreEnnemis;
    private int tours;
    private Terrain terrain;

    public Environnement(Terrain terrain) {
        this.ennemis = FXCollections.observableArrayList();
        this.barreDeVies = FXCollections.observableArrayList();
        this.tours = 0;
        this.terrain = terrain;
        this.nombreEnnemis = new SimpleIntegerProperty(0);
        ajouterEnnemisAleatoirement(50);
    }

    public void ajouterEnnemisAleatoirement(int nombreEnnemis) {
        Random rand = new Random();
        int largeurMap = terrain.getLargeur();
        int hauteurMap = terrain.getHauteur();

        int nombreCowboysHautGauche = (int) (nombreEnnemis * 0.25);
        int nombreDragonsHautGauche = (int) (nombreEnnemis * 0.10);

        int nombreCowboysHautDroit = (int) (nombreEnnemis * 0.15);
        int nombreDragonsHautDroit = (int) (nombreEnnemis * 0.15);

        int nombreCowboysBasDroit = (int) (nombreEnnemis * 0.10);
        int nombreDragonsBasDroit = (int) (nombreEnnemis * 0.25);

        placerEnnemis(rand, nombreCowboysHautGauche, "Cowboy", 0, hauteurMap / 2, 0, largeurMap / 2);
        placerEnnemis(rand, nombreDragonsHautGauche, "Dragon", 0, hauteurMap / 2, 0, largeurMap / 2);

        placerEnnemis(rand, nombreCowboysHautDroit, "Cowboy", 0, hauteurMap / 2, largeurMap / 2, largeurMap);
        placerEnnemis(rand, nombreDragonsHautDroit, "Dragon", 0, hauteurMap / 2, largeurMap / 2, largeurMap);

        placerEnnemis(rand, nombreCowboysBasDroit, "Cowboy", hauteurMap / 2, hauteurMap, largeurMap / 2, largeurMap);
        placerEnnemis(rand, nombreDragonsBasDroit, "Dragon", hauteurMap / 2, hauteurMap, largeurMap / 2, largeurMap);
    }

    private void placerEnnemis(Random rand, int nombreEnnemis, String typeEnnemi, int minY, int maxY, int minX, int maxX) {
        for (int i = 0; i < nombreEnnemis; i++) {
            int x, y;
            do {
                x = minX * 32 + rand.nextInt((maxX - minX) * 32);
                y = minY * 32 + rand.nextInt((maxY - minY) * 32);
            } while (!terrain.estMarchable(y / 32, x / 32));

            Ennemi ennemi;
            if (typeEnnemi.equals("Cowboy")) {
                ennemi = new Cowboy(terrain);
            } else {
                ennemi = new Dragon(terrain);
            }

            ennemi.setX(x);
            ennemi.setY(y);
            ennemis.add(ennemi);
        }
    }

    public void unTour() {
        for (int i = 0; i < ennemis.size(); i++) {
            Ennemi e = ennemis.get(i);
            e.deplacerEnCarre();
        }
        this.tours++;
    }

    public ObservableList<Ennemi> getEnnemis() {
        return ennemis;
    }

}
