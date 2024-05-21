package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;


public class Arme {
    private int pointAttaque;

    public Arme(int pointAttaque) {
        this.pointAttaque = pointAttaque;
    }

    public int getPointAttaque() {
        return this.pointAttaque;
    }

    public String toString() {
        return "Arme :  pointAttaque " + pointAttaque;
    }
}