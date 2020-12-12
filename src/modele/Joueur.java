package modele;

public class Joueur {

    public int id;
    public String name;
    public int nb_victoires =0;


    public Joueur(int id ,String name, int nb_victoires) {
        this.id= id;
        this.name = name;
        this.nb_victoires = nb_victoires;
    }

}
