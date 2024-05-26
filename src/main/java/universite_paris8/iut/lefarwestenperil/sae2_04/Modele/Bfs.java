package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Bfs {
    /**
     * Le graphe (ou grille) sur lequel on travaille
     */
    private Terrain terrain;
    /**
     * Le sommet source de l'algo
     */
    private Sommet source;
    /**
     * Liste des sommets de la composante connexe de g obtenue par un parcours en largeur depuis le sommet source
     */
    private ArrayList<Sommet> parcours;
    /**
     * Chaque sommet (clé) est associé à son prédécesseur (valeur) du parcours en largeur
     */
    private Map<Sommet, Sommet> predecesseurs;

    public Bfs(Terrain t, Sommet source) {
        this.terrain = t;
        this.source = source;
        parcours = new ArrayList<>();
        predecesseurs = new HashMap<Sommet, Sommet>();
        algoBFS();
    }

    /**
     * Exécute l'algo BFS sur g à partir du sommet source Remplit la liste parcours avec les sommets dans l'ordre de
     * visite Remplit la map predecesseurs en indiquant quel est le prédécesseur de chaque sommet Le prédécesseur du
     * sommet source est le sommet null
     */
    private void algoBFS() {
        LinkedList<Sommet> fifo = new LinkedList<>();
        // TODO
        predecesseurs.put(source, null); // Null représente le prédécesseur et source son succeseur
        fifo.add(source);
        while(!fifo.isEmpty())  {
            Sommet courant = fifo.poll();
            for(Sommet voisin : this.terrain.adjacents(courant)) {
                if(!predecesseurs.containsKey(voisin)) {
                    predecesseurs.put(voisin,courant);
                    fifo.add(voisin);
                    parcours.add(voisin);
                }
            }
        }

    }

    /**
     * Retourne une liste donnant la suite des sommets depuis la cible jusqu'à la source
     *
     * @param cible
     * @return le chemin sous forme de liste de sommets
     */
    public ArrayList<Sommet> cheminVersSource(Sommet cible) {
        ArrayList<Sommet> chemin = new ArrayList<>();
        // TODO

        while(predecesseurs.get(cible) != null) {
            cible = predecesseurs.get(cible);
            chemin.add(cible);
        }
        return chemin;
    }

    /*************************************************
     **** Pas de modifications à faire ci-dessous ****
     *************************************************/

    public ArrayList<Sommet> getParcours() {
        return parcours;
    }

    public Map<Sommet, Sommet> getPredecesseurs() {
        return predecesseurs;
    }

    /**
     * Mise à jour quand la source est modifiée suite à un clic droit
     *
     * @param source
     *            le nouveau sommet source
     */
    public void setSource(Sommet source) {
        this.source = source;
        clear();
        algoBFS();
    }

    /**
     * Mise à jour suite au changement de graphe
     *
     * @param t1
     *            le nouveau graphe
     */
    public void setG(Terrain t1) {
        this.terrain = t1;
        clear();
        algoBFS();
    }

    private void clear() {
        this.parcours.clear();
        this.predecesseurs.clear();
    }

}
