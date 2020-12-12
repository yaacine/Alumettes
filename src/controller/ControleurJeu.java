package controller;

import modele.Coup;
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
        this.ihm.start();
        this.ihm.displayTas(this.tas);
        Coup coup = this.ihm.recupererCoup(0);
        boolean coupValide = this.tas.verifierCoup(coup.num_tas, coup.nb_alumettes_retirer);
        if (coupValide){

        }

    }
}
