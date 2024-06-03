package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * La classe BarreDeVie représente une barre de vie pour un personnage ou un objet dans le jeu.
 * Elle gère la position (x, y), la vie actuelle, la vie maximale, et l'identifiant de la barre de vie.
 */
public class BarreDeVie {
    // Propriétés pour la position x et y de la barre de vie
    private IntegerProperty x, y;
    // Propriété pour le pourcentage de vie totale
    private DoubleProperty vieTotale;
    // Variables pour la vie actuelle et la vie maximale
    private Double vie;
    private Double vieMax;
    // Identifiant unique pour la barre de vie
    private String id;

    /**
     * Constructeur pour initialiser une BarreDeVie avec les valeurs données.
     * @param vie la vie actuelle
     * @param vieMax la vie maximale
     * @param id l'identifiant unique
     * @param x la position x
     * @param y la position y
     */
    public BarreDeVie(int vie, int vieMax, String id, int x, int y){
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.vie= (double) vie;
        this.vieMax = (double)vieMax;
        this.id = id;
        this.vieTotale = new SimpleDoubleProperty(vie / (double) vieMax);
    }

    /**
     * Retourne le pourcentage de vie totale.
     * @return le pourcentage de vie totale
     */
    public double getVieTotale() {
        return vieTotale.getValue();
    }

    /**
     * Retourne la propriété vieTotale.
     * @return la propriété vieTotale
     */
    public DoubleProperty vieTotaleProperty() {
        return vieTotale;
    }

    /**
     * Met à jour la propriété vieTotale en fonction de la vie actuelle et de la vie maximale.
     */
    public void miseAJourVieTotale() {
        this.vieTotale.setValue(vie / vieMax);
    }

    /**
     * Définit la vie actuelle et met à jour la vie totale.
     * @param vie la nouvelle valeur de vie actuelle
     */
    public void setVie(double vie) {
        this.vie = vie;
    }

    /**
     * Retourne la propriété x.
     * @return la propriété x
     */
    public IntegerProperty xProperty() {
        return x;
    }

    /**
     * Retourne la propriété y.
     * @return la propriété y
     */
    public IntegerProperty yProperty() {
        return y;
    }

    /**
     * Retourne l'identifiant unique de la barre de vie.
     * @return l'identifiant unique
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne la position x.
     * @return la position x
     */
    public final int getX() {
        return this.xProperty().getValue();
    }

    /**
     * Définit la position x.
     * @param x la nouvelle valeur de x
     */
    public final void setX(int x) {
        this.xProperty().setValue(x);
    }

    /**
     * Retourne la position y.
     * @return la position y
     */
    public final int getY() {
        return this.yProperty().getValue();
    }

    /**
     * Définit la position y.
     * @param y la nouvelle valeur de y (réduite de 10)
     */
    public final void setY(int y) {
        this.yProperty().setValue(y - 10); // Ajuste la position y avec une réduction de 10
    }
}
