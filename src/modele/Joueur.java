package modele;

public class Joueur {

    private int id;
    private String name;
    private int nb_victoires =0;


    public Joueur(int id ,String name, int nb_victoires) {
        this.setId(id);
        this.setName(name);
        this.setNb_victoires(nb_victoires);
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
