package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

/**
 * La classe Environnement représente le contexte global du jeu, incluant les ennemis, leur barre de vie et le terrain.
 */
public class Environnement {
    // Liste observable d'ennemis dans l'environnement
    private ObservableList<Ennemi> ennemis;
    // Liste observable de barres de vie dans l'environnement
    private ObservableList<BarreDeVie> barreDeVies;
    // Propriété pour le nombre d'ennemis
    private IntegerProperty nombreEnnemis;
    // Compteur de tours
    private int tours;
    // Terrain sur lequel évoluent les ennemis
    private Terrain terrain;

    /**
     * Constructeur pour initialiser l'environnement avec le terrain donné.
     * @param terrain le terrain sur lequel les ennemis se déplaceront
     */
    public Environnement(Terrain terrain) {
        this.ennemis = FXCollections.observableArrayList();
        this.barreDeVies = FXCollections.observableArrayList();
        this.tours = 0;
        this.terrain = terrain;
        this.nombreEnnemis = new SimpleIntegerProperty(0);
    }

    /**
     * Ajoute un nombre donné d'ennemis aléatoirement répartis sur le terrain.
     * @param nombreEnnemis le nombre d'ennemis à ajouter
     */
    public void ajouterEnnemisAleatoirement(int nombreEnnemis) {
        Random rand = new Random();
        int largeurMap = terrain.getLargeur();
        int hauteurMap = terrain.getHauteur();

        // Calcul du nombre d'ennemis de chaque type à placer dans différentes sections de la carte
        int nombreCowboysHautGauche = (int) (nombreEnnemis * 0.25);
        int nombreDragonsHautGauche = (int) (nombreEnnemis * 0.10);

        int nombreCowboysHautDroit = (int) (nombreEnnemis * 0.15);
        int nombreDragonsHautDroit = (int) (nombreEnnemis * 0.15);

        int nombreCowboysBasDroit = (int) (nombreEnnemis * 0.10);
        int nombreDragonsBasDroit = (int) (nombreEnnemis * 0.25);

        // Placer les ennemis dans les différentes sections de la carte
        placerEnnemis(rand, nombreCowboysHautGauche, "Cowboy", 0, hauteurMap / 2, 0, largeurMap / 2);
        placerEnnemis(rand, nombreDragonsHautGauche, "Dragon", 0, hauteurMap / 2, 0, largeurMap / 2);

        placerEnnemis(rand, nombreCowboysHautDroit, "Cowboy", 0, hauteurMap / 2, largeurMap / 2, largeurMap);
        placerEnnemis(rand, nombreDragonsHautDroit, "Dragon", 0, hauteurMap / 2, largeurMap / 2, largeurMap);

        placerEnnemis(rand, nombreCowboysBasDroit, "Cowboy", hauteurMap / 2, hauteurMap, largeurMap / 2, largeurMap);
        placerEnnemis(rand, nombreDragonsBasDroit, "Dragon", hauteurMap / 2, hauteurMap, largeurMap / 2, largeurMap);
    }

    /**
     * Place les ennemis de manière aléatoire dans une section définie de la carte.
     * @param rand instance de Random pour générer des positions aléatoires
     * @param nombreEnnemis le nombre d'ennemis à placer
     * @param typeEnnemi le type d'ennemi ("Cowboy" ou "Dragon")
     * @param minY la position Y minimale de la section
     * @param maxY la position Y maximale de la section
     * @param minX la position X minimale de la section
     * @param maxX la position X maximale de la section
     */
    private void placerEnnemis(Random rand, int nombreEnnemis, String typeEnnemi, int minY, int maxY, int minX, int maxX) {
        for (int i = 0; i < nombreEnnemis; i++) {
            int x, y;
            // Génère des positions aléatoires jusqu'à ce qu'une position marchable soit trouvée
            do {
                x = minX * 32 + rand.nextInt((maxX - minX) * 32);
                y = minY * 32 + rand.nextInt((maxY - minY) * 32);
            } while (!terrain.estMarchable(y / 32, x / 32));

            // Crée un nouvel ennemi du type spécifié
            Ennemi ennemi;
            if (typeEnnemi.equals("Cowboy")) {
                ennemi = new Cowboy(terrain);
            } else {
                ennemi = new Dragon(terrain);
            }

            // Définit la position de l'ennemi et l'ajoute à la liste
            ennemi.setX(x);
            ennemi.setY(y);
            ennemis.add(ennemi);
            ajouterBarreDeVie(ennemi.getBarreDeVie());
        }
    }

    /**
     * Effectue un tour de jeu, déplaçant chaque ennemi sur le terrain.
     */
    public void unTour() {
        for (int i = 0; i < ennemis.size(); i++) {
            Ennemi e = ennemis.get(i);
            e.deplacerEnCarre();
        }
        this.tours++;
    }
    public ObservableList<BarreDeVie> getBarreDeVies() {
        return barreDeVies;
    }
    public void ajouterBarreDeVie(BarreDeVie b) {
        barreDeVies.add(b);
    }


    /**
     * Retourne la liste observable des ennemis.
     * @return la liste observable des ennemis
     */
    public ObservableList<Ennemi> getEnnemis() {
        return ennemis;
    }
}
