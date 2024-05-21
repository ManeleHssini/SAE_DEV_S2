package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

public class Dragon extends Ennemi {
    public Dragon(Terrain terrain) {
        super(100, 20, 10, 5,5,terrain);
        super.ramasserArme(new Feu());
    }

    @Override
    public void crie() {
        System.out.println("Roar!");
    }
}
