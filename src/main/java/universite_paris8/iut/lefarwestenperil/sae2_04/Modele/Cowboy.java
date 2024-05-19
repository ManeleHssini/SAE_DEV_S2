package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

public class Cowboy extends Ennemi {

    public Cowboy(Terrain terrain) {
        super(50, 5, 3, terrain);
        super.ramasserArme(new Lasso());
    }

    @Override
    public void crie() {
        System.out.println("Yeehaw!");
    }
}