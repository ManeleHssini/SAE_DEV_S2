package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;



import javafx.scene.layout.TilePane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

    public class Dijkstra {

        private Terrain g;
        private TilePane source;
        /**
         * Associe à chaque sommet son coût minimal d'accès depuis le sommet source
         */
        private Map<TilePane, Double> couts;
        /**
         * Associe à chaque sommet son prédécesseur dans le chemin de coût minimal vers le sommet source
         */
        private Map<TilePane, TilePane> predecesseurs;
        /**
         * Liste des sommets de la composante connexe de g obtenue par Dijkstra depuis le sommet source
         */
        private ArrayList<TilePane> parcours;

        public Dijkstra(Terrain g, TilePane source) {
            this.g = g;
            this.source = source;
            couts = new HashMap<>();
            parcours = new ArrayList<>();
            predecesseurs = new HashMap<>();
            algoDijkstra();
        }

        /**
         * Exécute l'algo Dijkstra sur g à partir du sommet source. Remplit la liste parcours avec les sommets dans l'ordre
         * de visite. Remplit la map predecesseurs en indiquant quel est le prédécesseur de chaque sommet. Le prédécesseur
         * du sommet source est le sommet null. Remplit la map des coûts afin de pouvoir comparer si le coût actuel est
         * inférieur au coût déjà mémorisé dans la file de priorité s'il y en a un.
         */
        private void algoDijkstra() {
            // File de priorité. Le premier à sortir est celui qui a le coût le plus faible.
            PriorityQueue<SommetCout> fifo = new PriorityQueue<>();

                predecesseurs.put(source, null);
                parcours.add(source);
                couts.put(source, 0D);
                fifo.add(new SommetCout(source, 0D));
                while (!fifo.isEmpty()) {
                    SommetCout courant = fifo.poll();
                    for (TilePane voisin : this.g.adjacents(courant.getS())) {
                        if (!predecesseurs.containsKey(voisin)) {
                            predecesseurs.put(voisin, courant.getS());
                            parcours.add(voisin);
                            double cout = courant.getCout();
                            fifo.add(new SommetCout(voisin, cout));
                        }

                    }
                }
        }

        /*************************************************
         **** Pas de modifications à faire ci-dessous ****
         *************************************************/

        public ArrayList<TilePane> getParcours() {
            return parcours;
        }

        public Map<TilePane, TilePane> getPredecesseurs() {
            return predecesseurs;
        }

        public TilePane getSource() {
            return source;
        }

        public void setSource(TilePane source) {
            this.source = source;
            clear();
            algoDijkstra();
        }

        public void setG(Terrain g) {
            this.g = g;
            clear();
            algoDijkstra();
        }

        private void clear() {
            this.predecesseurs.clear();
            this.couts.clear();
            this.parcours.clear();
        }


}
