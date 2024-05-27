package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;


import java.util.Random;

public abstract class Ennemi extends Personnage{
    private int vitesse;
    public static int compteurId =0;
    private String id;
    private int tuileActuel;
    private BarreDeVie barreDeVie;

    public Ennemi(int x, int y,int pointVie, int pointAttaque, int pointDefense,Terrain terrain/*,int vitesse*/ ) {
        super(x,y,pointVie, pointAttaque, pointDefense, terrain);


    }


    public void seDeplacerAlea() {

        Random random = new Random();
        int nposX, nposY;
        int dx = random.nextInt(3)-1 ;
        int dy = random.nextInt(3)-1 ;
        nposY = this.getY() + dy * 4;
        nposX = this.getX() + dx * 4;
        if(super.estCorrect(nposX,nposY)) {
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



}
