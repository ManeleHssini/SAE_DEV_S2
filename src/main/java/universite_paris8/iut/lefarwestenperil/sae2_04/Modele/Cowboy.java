package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

public class Cowboy extends Ennemi {

    public Cowboy(Terrain terrain) {
        super(200, 200, 3, 3,3, terrain, 1, 100,false, 19, 25);
        super.ramasserArme(new Lasso());
    }
}