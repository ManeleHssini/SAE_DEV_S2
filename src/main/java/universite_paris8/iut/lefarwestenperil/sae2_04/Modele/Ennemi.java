package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;


import java.util.Random;

public abstract class Ennemi extends Personnage{
    private int vitesse;
    public static int compteurId =0;
    private String id;
    private int tuileActuel;
    private BarreDeVie barreDeVie;
    private int pixelsParcourus;
    private int directionActuelle;

    public Ennemi(int x, int y,int pointVie, int pointAttaque, int pointDefense,Terrain terrain, int vitesse) {
        super(x,y,pointVie, pointAttaque, pointDefense, terrain);
        this.vitesse = vitesse;
        this.id="E"+ compteurId;
        compteurId++;
    }

    public void deplacerEnCarre() {
        int[][] directions = {{vitesse, 0}, {0, vitesse}, {-vitesse, 0}, {0, -vitesse}};

        int newX = getX() + directions[directionActuelle][0];
        int newY = getY() + directions[directionActuelle][1];

        int caseX = newX / 32;
        int caseY = newY / 32;

        if (getTerrain().estMarchable(caseY, caseX)) {
            setX(newX);
            setY(newY);
            pixelsParcourus += vitesse;

            if (pixelsParcourus >= 32) {
                directionActuelle = (directionActuelle + 1) % 4;
                pixelsParcourus = 0;
            }
        } else {
            directionActuelle = (directionActuelle + 1) % 4;
            pixelsParcourus = 0;
        }
    }

    public String getId() {
        return id;
    }

}
