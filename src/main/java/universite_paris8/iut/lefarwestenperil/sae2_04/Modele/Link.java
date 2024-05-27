package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

public class Link extends Personnage{


    public Link(Terrain terrain) {
        super(200, 200,5,2,1, terrain);
        super.ramasserArme(new Pistolet());

    }

    public void deplacer(int dx, int dy) {
        int newX = getX() + dx;
        int newY = getY() + dy;

        if (estCorrect(newX, newY)) {
            setX(newX);
            setY(newY);
        } else if (dx != 0 && getX() % tailleTuile < 4) {
            newX = getX() / tailleTuile * tailleTuile + 1;
            setX(newX);
        }
    }

    private boolean estCorrect(int newX, int newY) {
        int tileX = newX / tailleTuile;
        int tileY = newY / tailleTuile;
        int tileXRight = (newX + 13) / tailleTuile;
        int tileYBottom = (newY + 18) / tailleTuile;

        return getTerrain().estMarchable(tileY, tileX) &&
                getTerrain().estMarchable(tileY, tileXRight) &&
                getTerrain().estMarchable(tileYBottom, tileX) &&
                getTerrain().estMarchable(tileYBottom, tileXRight);
    }

    public void deplacerHaut() {
        deplacer(0, -4);
    }

    public void deplacerBas() {
        deplacer(0, 4);
    }

    public void deplacerGauche() {
        deplacer(-4, 0);
    }

    public void deplacerDroite() {
        deplacer(4, 0);
    }

    public String toString() {
        return "Link : " + super.toString();
    }
}
