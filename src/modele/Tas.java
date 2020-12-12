package modele;

import java.util.ArrayList;

public class Tas {

    public int nb_tas;
    public ArrayList<Integer> alumettesParTas;

    public Tas(int nb_tas) {
        this.nb_tas = nb_tas;
        ArrayList<Integer> tableau = new ArrayList<>();
        for (int i = 1; i <= nb_tas; i++) {
            tableau.add(i, 2*i+1);
        }
        this.alumettesParTas = tableau;
    }

    // cette methode verifie si le coup est valide
    public boolean verifierCoup(int tas , int nbAlumettes){
        if(this.alumettesParTas.get(tas-1)< nbAlumettes) return  false;
        else return true;
    }

    // cette methode joue le coup
    public boolean jouerCoup(int tas, int nbAlumetts){
        if(this.alumettesParTas.get(tas-1)>= nbAlumetts){
            this.alumettesParTas.set(tas-1,this.alumettesParTas.get(tas-1)- nbAlumetts);
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
