package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {
    private IntegerProperty x, y;

    private Terrain terrain;

    public Personnage(int x, int y,Terrain terrain) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.terrain = terrain;
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
    public void deplacerHaut() {
        int newY = getY() - 4;
        if (newY >= 7 && terrain.estMarchable((newY - 7) / 32, (getX() + 7) / 32) && terrain.estMarchable((newY - 7) / 32, (getX() - 7) / 32)) {
            setY(newY);
        }
    }

    public void deplacerBas() {
        int newY = getY() + 4;
        if (newY <= (terrain.getHauteur() * 32 - 7) && terrain.estMarchable((newY + 7) / 32, (getX() + 7) / 32) && terrain.estMarchable((newY + 7) / 32, (getX() - 7) / 32)) {
            setY(newY);
        }
    }

    public void deplacerGauche() {
        int newX = getX() - 4;
        if (newX >= 7 && terrain.estMarchable((getY() + 7) / 32, (newX - 7) / 32) && terrain.estMarchable((getY() - 7) / 32, (newX - 7) / 32)) {
            setX(newX);
        }
    }

    public void deplacerDroite() {
        int newX = getX() + 4;
        if (newX <= (terrain.getLargeur() * 32 - 7) && terrain.estMarchable((getY() + 7) / 32, (newX + 7) / 32) && terrain.estMarchable((getY() - 7) / 32, (newX + 7) / 32)) {
            setX(newX);
        }
    }
}
