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
}
