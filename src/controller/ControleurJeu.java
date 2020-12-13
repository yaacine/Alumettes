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
        boolean continuer = true;
        int joueurCourant=0;
        this.ihm.start();
        while (continuer){
            this.ihm.displayTas(this.tas);
            Coup coup = this.ihm.recupererCoup(joueurCourant);
            boolean coupValide = this.tas.verifierCoup(coup);
            if (coupValide){

            }
        }



    }
}
