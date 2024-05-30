package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import universite_paris8.iut.lefarwestenperil.sae2_04.BFS.BFS;

import java.awt.*;
import java.util.List;

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
    private int portee;
    // Dimensions de l'image de l'ennemi
    private int largeurImage;
    private int hauteurImage;
    private BFS bfs;
    private List<Point> chemin;

    /**
     * Constructeur pour initialiser un Ennemi avec les paramètres donnés.
     * @param x la position x initiale
     * @param y la position y initiale
     * @param pointVie les points de vie de l'ennemi
     * @param pointAttaque les points d'attaque de l'ennemi
     * @param pointDefense les points de défense de l'ennemi
     * @param terrain le terrain sur lequel se déplace l'ennemi
     * @param vitesse la vitesse de déplacement de l'ennemi
     * * @param largeurImage la largeur de l'image de l'ennemi
     * * @param hauteurImage la hauteur de l'image de l'ennemi
     */
    public Ennemi(int x, int y, int pointVie, int pointAttaque, int pointDefense, Terrain terrain, int vitesse, int portee, int largeurImage, int hauteurImage) {
        super(x, y, pointVie, pointAttaque, pointDefense, terrain);
        this.vitesse = vitesse;
        this.id = "E" + compteurId;
        compteurId++;
        this.barreDeVie = new BarreDeVie(getPointVie(), pointVie, getId(), getX(), getY());
        this.largeurImage = largeurImage;
        this.hauteurImage = hauteurImage;
        this.pixelsParcourus = 0;
        this.directionActuelle = 0;
        this.portee = portee;
        this.bfs = new BFS();
    }

    public int getVitesse() {
        return vitesse;
    }

    public static int getCompteurId() {
        return compteurId;
    }

    public int getTuileActuel() {
        return tuileActuel;
    }

    public BarreDeVie getBarreDeVie() {
        return barreDeVie;
    }

    public int getPixelsParcourus() {
        return pixelsParcourus;
    }

    public int getDirectionActuelle() {
        return directionActuelle;
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

        // Calcule les cases correspondantes à la nouvelle position
        int caseX1 = newX / 32;
        int caseY1 = newY / 32;
        int caseX2 = (newX + largeurImage - 1) / 32;
        int caseY2 = (newY + hauteurImage - 1) / 32;

        // Vérifie si la nouvelle position est marchable pour toute la zone occupée par l'image
        if (getTerrain().estMarchable(caseY1, caseX1) && getTerrain().estMarchable(caseY2, caseX2)) {
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

    public List<Point> getCheminCourt() {
        return chemin;
    }


    public void seDeplace() {
        if (tuileActuel < getCheminCourt().size() - 1) {
            Point prochaineTuile = getCheminCourt().get(tuileActuel + 1);
            double prochainePosX = prochaineTuile.getY() * 32;
            double prochainePosY = prochaineTuile.getX() * 32;

            double deltaX = prochainePosX - getX();
            double deltaY = prochainePosY - getY();

            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

            if (distance <= vitesse) {
                // Si la distance restante est inférieure ou égale à la vitesse, on arrive à la tuile suivante
                setX((int) prochainePosX);
                setY((int) prochainePosY);
                tuileActuel++;
            } else {
                // Sinon, on se déplace vers la prochaine tuile en fonction de la vitesse
                double deplacementX = (deltaX / distance) * vitesse;
                double deplacementY = (deltaY / distance) * vitesse;

                setX((int) (getX() + deplacementX));
                setY((int) (getY() + deplacementY));
            }
        }
    }

    /**
     * Retourne l'identifiant unique de l'ennemi.
     * @return l'identifiant unique de l'ennemi
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne la largeur de l'image de l'ennemi.
     * @return la largeur de l'image de l'ennemi
     */
    public int getLargeurImage() {
        return largeurImage;
    }

    /**
     * Retourne la hauteur de l'image de l'ennemi.
     * @return la hauteur de l'image de l'ennemi
     */
    public int getHauteurImage() {
        return hauteurImage;
    }

    public boolean detectionLink(Link link) {
        double distance = Math.sqrt(Math.pow(link.getX() - getX() , 2) + Math.pow(link.getY() - getY(), 2));
        if(distance <= portee) {
            this.chemin = BFS.bfs(getTerrain().getTab(),new Point(getX(), getY()), new Point(link.getX(), link.getY()));
            for (Point tuile : chemin) {
                System.out.println(tuile);
            }
        }
        return distance <= portee;
    }
}
