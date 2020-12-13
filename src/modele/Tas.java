package modele;

import java.util.ArrayList;

public class Tas {

    public int nb_tas;
    public ArrayList<Integer> alumettesParTas;

    public Tas(int nb_tas) {
        this.nb_tas = nb_tas;
        ArrayList<Integer> tableau = new ArrayList<>(nb_tas);
        for (int i = 0; i < nb_tas; i++) {
            tableau.add(i, 2*i+1);
        }
        this.alumettesParTas = tableau;
    }

    // cette methode verifie si le coup est valide
    public boolean verifierCoup(Coup coup){

        if(this.alumettesParTas.get(coup.num_tas-1)< coup.nb_alumettes_retirer) return  false;
        else return true;
    }

    // cette methode joue le coup
    public boolean jouerCoup(Coup coup){
        if(this.alumettesParTas.get(coup.num_tas-1)>= coup.nb_alumettes_retirer){
            this.alumettesParTas.set(coup.num_tas-1,this.alumettesParTas.get(coup.num_tas-1)- coup.nb_alumettes_retirer);
            return  true;
        }
        else return true;
    }

    // cette methode verifie si la partie est terminée avec une victoure
    public boolean verifierVictoire(){
        boolean victoir = true;
        for (int i = 0; i < this.alumettesParTas.size(); i++) {
            if (this.alumettesParTas.get(i)>0) victoir = false;
        }
        return victoir;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Tas clonedTas = new Tas(this.nb_tas);
        return clonedTas;
    }
}
