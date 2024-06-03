package universite_paris8.iut.lefarwestenperil.sae2_04.BFS;

import javafx.scene.layout.TilePane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.util.*;


public class BFS {

        private Terrain terrain;

        private TilePane source;

        private ArrayList<TilePane> parcours;

        private Map<TilePane, TilePane> predecesseurs;

        public BFS(Terrain terrain, TilePane source) {
            this.terrain = terrain;
            this.source = source;
            parcours = new ArrayList<>();
            predecesseurs = new HashMap<TilePane, TilePane>();
            algoBFS();
        }

        private void algoBFS() {
            LinkedList<TilePane> fifo = new LinkedList<>();

            predecesseurs.put(source, null);
            fifo.add(source);
            while (!fifo.isEmpty()) {
                TilePane courant = fifo.poll();
              /*  for (TilePane voisin : this.terrain.adjacents(courant)) {
                    if (!predecesseurs.containsKey(voisin)) {
                        predecesseurs.put(voisin, courant);
                        fifo.add(voisin);
                        parcours.add(voisin);
                    }
                }*/
            }
        }
}