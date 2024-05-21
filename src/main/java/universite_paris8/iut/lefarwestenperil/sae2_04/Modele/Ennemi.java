package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;


public abstract class Ennemi extends Personnage{

    public Ennemi(int x, int y,int pointVie, int pointAttaque, int pointDefense,Terrain terrain) {
        super(x,y,pointVie, pointAttaque, pointDefense, terrain);
    }
    public abstract void crie();
}
