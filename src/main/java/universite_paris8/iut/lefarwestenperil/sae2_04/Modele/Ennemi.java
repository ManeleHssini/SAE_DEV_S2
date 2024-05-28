package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import java.util.Random;

/**
 * La classe abstraite Ennemi représente un ennemi dans le jeu.
 * Un ennemi est un personnage qui peut se déplacer sur le terrain.
 */
public abstract class Ennemi extends Personnage {
    // Vitesse de déplacement de l'ennemi
    private int vitesse;
    // Compteur statique pour générer des identifiants uniques
    public static int compteurId = 0;
    // Identifiant unique de l'ennemi
    private String id;
    // Tuile actuelle où se trouve l'ennemi
    private int tuileActuel;
    // Barre de vie de l'ennemi
    private BarreDeVie barreDeVie;
    // Nombre de pixels parcourus dans la direction actuelle
    private int pixelsParcourus;
    // Direction actuelle de déplacement (0: droite, 1: bas, 2: gauche, 3: haut)
    private int directionActuelle;


    /**
     * Constructeur pour initialiser un Ennemi avec les paramètres donnés.
     * @param x la position x initiale
     * @param y la position y initiale
     * @param pointVie les points de vie de l'ennemi
     * @param pointAttaque les points d'attaque de l'ennemi
     * @param pointDefense les points de défense de l'ennemi
     * @param terrain le terrain sur lequel se déplace l'ennemi
     * @param vitesse la vitesse de déplacement de l'ennemi
     */
    public Ennemi(int x, int y, int pointVie, int pointAttaque, int pointDefense, Terrain terrain, int vitesse) {
        super(x, y, pointVie, pointAttaque, pointDefense, terrain);
        this.vitesse = vitesse;
        this.id = "E" + compteurId;
        compteurId++;
    }

    /**
     * Déplace l'ennemi en suivant un chemin en carré.
     * L'ennemi change de direction après avoir parcouru une distance de 32 pixels.
     */
    public void deplacerEnCarre() {
        // Tableau des directions de déplacement (droite, bas, gauche, haut)
        int[][] directions = {{vitesse, 0}, {0, vitesse}, {-vitesse, 0}, {0, -vitesse}};

        // Calcule la nouvelle position en fonction de la direction actuelle
        int newX = getX() + directions[directionActuelle][0];
        int newY = getY() + directions[directionActuelle][1];

        // Calcule la tuile correspondante à la nouvelle position
        int caseX = newX / 32;
        int caseY = newY / 32;

        // Vérifie si la nouvelle position est marchable
        if (getTerrain().estMarchable(caseY, caseX)) {
            setX(newX);
            setY(newY);
            pixelsParcourus += vitesse;

            // Change de direction après avoir parcouru 32 pixels
            if (pixelsParcourus >= 32) {
                directionActuelle = (directionActuelle + 1) % 4;
                pixelsParcourus = 0;
            }
        } else {
            // Change de direction si la position n'est pas marchable
            directionActuelle = (directionActuelle + 1) % 4;
            pixelsParcourus = 0;
        }
    }
    public BarreDeVie getBarreDeVie() {
        return barreDeVie;
    }


 /*   public void seDeplacerAlea() {

        Random random = new Random();
        int nposX, nposY;
        int dx = this.random.nextInt(3)-1 ;
        int dy = this.random.nextInt(3)-1 ;
        nposY = this.getY() + dy * vitesseDeplacement;
        nposX = this.getX() + dx * vitesseDeplacement;
        if(terrain.dansTerrain(nposX,nposY)) {
            if (dx == 1) {
                deplacerDroite();
                System.out.println("D");
            } else if (dx == -1) {
                System.out.println("G");
                deplacerGauche();
            }
            if (dy == 1) {
                System.out.println("B");
                deplacerBas();
            } else if (dy == -1) {
                System.out.println("H");
                deplacerHaut();
            }

        }
        this.setX(nposX);
        this.setY(nposY);

    }
*/

    /**
     * Retourne l'identifiant unique de l'ennemi.
     * @return l'identifiant unique de l'ennemi
     */
    public String getId() {
        return id;
    }
}
