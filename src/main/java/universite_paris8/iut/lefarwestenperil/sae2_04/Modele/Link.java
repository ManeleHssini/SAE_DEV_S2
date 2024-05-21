package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

public class Link extends Personnage{


    public Link(Terrain terrain) {
        super(336, 16,5,2,1, terrain);
        super.ramasserArme(new Pistolet());

    }

    public String toString() {
        return "Link : " + super.toString();
    }
}
