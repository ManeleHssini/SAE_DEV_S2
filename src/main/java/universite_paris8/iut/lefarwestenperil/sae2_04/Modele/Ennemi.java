package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;



public abstract class Ennemi extends Personnage{
    private int vitesse;
    public static int compteurId =0;
    private String id;
    private int tuileActuel;
    private BarreDeVie barreDeVie;

    public Ennemi(int x, int y,int pointVie, int pointAttaque, int pointDefense,Terrain terrain/*,int vitesse*/ ) {
        super(x,y,pointVie, pointAttaque, pointDefense, terrain);
      //  this.vitesse = vitesse;
      //  this.id="E"+ compteurId;
       // compteurId++;
       // this.tuileActuel = 0;

    }
  /*  public String getId() {
        return id;
    }
    public BarreDeVie getBarreDeVie() {
        return barreDeVie;
    }*/
/*
    public void seDeplace() {
        if (tuileActuel < this.env.getCheminCourt().size() - 1) {
            Point prochaineTuile = this.env.getCheminCourt().get(tuileActuel + 1);
            double prochainePosX = prochaineTuile.getY() * 32;
            double prochainePosY = prochaineTuile.getX() * 32;

            double deltaX = prochainePosX - getX();
            double deltaY = prochainePosY - getY();

            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

            if (distance <= vitesse) {
                // Si la distance restante est inférieure ou égale à la vitesse, on arrive à la tuile suivante
                setX(prochainePosX);
                setY(prochainePosY);
                tuileActuel++;
            } else {
                // Sinon, on se déplace vers la prochaine tuile en fonction de la vitesse
                double deplacementX = (deltaX / distance) * vitesse;
                double deplacementY = (deltaY / distance) * vitesse;

                setX(getX() + deplacementX);
                setY(getY() + deplacementY);
            }
        }
   */
}
