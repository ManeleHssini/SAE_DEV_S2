package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.collections.ObservableList;
import javafx.scene.layout.TilePane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Terrain {

    private int [][] tab;
    private Map<TilePane, Set<TilePane>> listeAdj;
    private ObservableList<TilePane> obstacles;
    public Terrain() {
        chargerTerrain();
    }


    private void chargerTerrain() {
        List<int[]> lignes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("terrain.txt"))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] valeurs = ligne.split(",");
                int[] ligneTab = new int[valeurs.length];
                for (int i = 0; i < valeurs.length; i++) {
                    ligneTab[i] = Integer.parseInt(valeurs[i].trim());
                }
                lignes.add(ligneTab);
            }
            tab = lignes.toArray(new int[0][]); // Convert List to Array
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int[][] getTab() {
        return this.tab;
    }

    public int getHauteur() {
        return tab.length;
    }

    public int getLargeur() {
        return tab[0].length;
    }
    public boolean estDeconnecte(Sommet s) {
        return this.obstacles.contains(s);
    }
    public Set<universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Sommet>adjacents(Sommet s) {
        return (Set)(!this.estDeconnecte(s) ? (Set)this.listeAdj.get(s) : new HashSet());
    }




    public boolean estMarchable(int y, int x) {
        if (x >= 0 && x < getLargeur() && y >= 0 && y < getHauteur()) {
            return tab[y][x] == 0;
        }
        return false;
    }

}
