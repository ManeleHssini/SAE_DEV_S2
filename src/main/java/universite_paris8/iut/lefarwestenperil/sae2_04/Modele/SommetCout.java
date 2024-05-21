package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.scene.layout.TilePane;

public class SommetCout implements Comparable<SommetCout> {

    /**
     * Classe permettant de stocker chaque sommet avec son coût actuel dans une file de priorité pour les algos de Dijkstra
     * et A*. RIEN A CHANGER DANS CETTE CLASSE
     *
     * @author homps
     */


        private Sommet s;
        private double cout;

        /**
         * Construit un SommetCout c.à.d un sommet et son coût actuel dans les algos de Dijkstra et A*
         *
         * @param s
         * @param cout
         */
        public SommetCout(Sommet s, double cout) {
            super();
            this.s = s;
            this.cout = cout;
        }

        public double getCout() {
            return cout;
        }

        public void setCout(double cout) {
            this.cout = cout;
        }

        /**
         * Retourne le sommet correspondant
         */
        public Sommet getS() {
            return s;
        }

        @Override
        public int compareTo(SommetCout o) {
            if (this.cout - o.cout < 0)
                return -1;
            else if (this.cout - o.cout > 0)
                return 1;
            else
                return 0;
        }


}
