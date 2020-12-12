package controller;

import modele.Tas;
import vue.Ihm;

public class ControleurJeu {

    public Tas tas;
    public Ihm ihm;
    // noud devrons avoir l'instance de ConstructeurJeu
    public ConstructeurJeu constructeurJeu;


    public ControleurJeu(Ihm ihm,Tas tas, ConstructeurJeu constructeurJeu) {
        this.tas = tas;
        this.ihm = ihm;
        this.constructeurJeu=constructeurJeu;
    }


    public void commencerJeu(){

    }
}
