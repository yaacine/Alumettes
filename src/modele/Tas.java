package modele;

import java.util.ArrayList;

public class Tas {

    public int nb_tas;
    public ArrayList<Integer> alumettesParTas;

    public Tas(int nb_tas, ArrayList<Integer> alumettesParTas) {
        this.nb_tas = nb_tas;
        this.alumettesParTas = alumettesParTas;
    }
}
