package modele;

public class Joueur {
    String name;
    Integer nb_victoires =0;


    public Joueur(String name, Integer nb_victoires) {
        this.name = name;
        this.nb_victoires = nb_victoires;
    }
}
