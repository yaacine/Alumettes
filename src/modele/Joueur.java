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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNb_victoires() {
        return nb_victoires;
    }

    public void setNb_victoires(int nb_victoires) {
        this.nb_victoires = nb_victoires;
    }
}
