package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;


public abstract class Ennemi extends Personnage{

    public Ennemi(int pointVie, int pointAttaque, int pointDefense, Terrain terrain) {
        super(pointVie, pointAttaque, pointDefense, terrain);
    }
    public abstract void crie();
}
