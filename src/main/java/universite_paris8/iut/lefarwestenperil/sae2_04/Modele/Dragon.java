package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

public class Dragon extends Ennemi {
    public Dragon(Terrain terrain) {
        super(200, 200, 10, 5,5,terrain,2);
        super.ramasserArme(new Feu());
    }
}
