package modele;

public class Coup {
    private int num_tas =0;
    private int nb_alumettes_retirer;

    public Coup(int num_tas, int nb_alumettes_retirer) {
        this.setNum_tas(num_tas);
        this.setNb_alumettes_retirer(nb_alumettes_retirer);
    }

    public int getNum_tas() {
        return num_tas;
    }

    public void setNum_tas(int num_tas) {
        this.num_tas = num_tas;
    }

    public int getNb_alumettes_retirer() {
        return nb_alumettes_retirer;
    }

    public void setNb_alumettes_retirer(int nb_alumettes_retirer) {
        this.nb_alumettes_retirer = nb_alumettes_retirer;
    }
}
