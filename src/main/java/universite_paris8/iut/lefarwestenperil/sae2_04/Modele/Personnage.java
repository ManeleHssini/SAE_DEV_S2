package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Personnage {
    protected int tailleTuile = 32;
    private int pointVie;
    private int pointAttaque;
    private int pointDefense;
    private Environnement env;
    private int vitesseDeplacement;
    private ArrayList<Arme> armes;
    private Arme armeActuelle;
    private IntegerProperty x, y;

    private Terrain terrain;

    public Personnage(int x, int y,int pointVie, int pointAttaque, int pointDefense,Terrain terrain) {
        this.pointVie = pointVie;
        this.pointAttaque = pointAttaque;
        this.pointDefense = pointDefense;
        this.armes = new ArrayList<Arme>();
        this.armeActuelle = null;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.terrain = terrain;
        this.vitesseDeplacement=4;
    }

    public Personnage(int x, int y, Terrain terrain) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.terrain = terrain;
    }

    public IntegerProperty vieProperty(){
        return new SimpleIntegerProperty(pointVie);
    }

    public int getTailleTuile() {
        return tailleTuile;
    }

    public int getPointVie() {
        return pointVie;
    }

    public int getPointAttaque() {
        return pointAttaque;
    }

    public int getPointDefense() {
        return pointDefense;
    }

    public Environnement getEnv() {
        return env;
    }

    public int getVitesseDeplacement() {
        return vitesseDeplacement;
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public final int getX() {
        return this.xProperty().getValue();
    }

    public final void setX(int n) {
        this.xProperty().setValue(n);
    }

    public final int getY() {
        return this.yProperty().getValue();
    }

    public final void setY(int n) {
        this.yProperty().setValue(n);
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void attaque(Personnage e) {
        int degat = this.pointAttaque;
        if (!this.armes.isEmpty()) {
            int dernier = this.armes.size() - 1;
            degat += getArmeActuelle().getPointAttaque();
        }
        System.out.println("degat a envoyer : " + degat);
        e.recevoirDegats(degat);

    }
    public void recevoirDegats(int pointsDegats) {
        int degatReel = pointsDegats - this.pointDefense;
        System.out.println("degat reel :" + degatReel);
        if (degatReel > 0) {
            if (this.pointVie >= degatReel)
                this.pointVie -= degatReel;
            else {
                this.pointVie = 0;
            }
        }
        System.out.println(pointVie);
    }

    public Arme getArmeActuelle() {
        if(this.armes.size() == 1) {
            this.armeActuelle = armeActuelle = this.armes.get(armes.size()-1);
        }
        if (this.armes.size()>=2) {
            armeActuelle = this.armes.get(armes.size()-1);
        }
        return armeActuelle;
    }
    public ArrayList<Arme> getArmes() {
        return this.armes;
    }

    public void ramasserArme(Arme arme) {
        this.armes.add(arme);
    }



    public void setArmeActuelle(Arme armeActuelle) {
        this.armeActuelle = armeActuelle;
    }


    @Override
    public String toString() {
        return "Personnage{" +
                "pointVie=" + pointVie +
                ", pointAttaque=" + pointAttaque +
                ", pointDefense=" + pointDefense +
                ", armes=" + armes +
                '}';
    }
}

