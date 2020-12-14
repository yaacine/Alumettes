package controller;

import modele.Coup;
import modele.Joueur;
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
        Joueur currentPlayerObjet= this.constructeurJeu.joueur1;
        this.ihm.start();
        boolean victoire= false;
        while (continuer){
            this.ihm.displayTas(this.tas);
            boolean coupValide= false;
            Coup coup=null;
            while (!coupValide){
                coup = this.ihm.recupererCoup(joueurCourant);
                coupValide = this.tas.verifierCoup(coup);
                if (!coupValide){
                    this.ihm.coupInvalide();
                }
            }

            this.tas.jouerCoup(coup);
            victoire = this.tas.verifierVictoire();
            if(victoire){
                currentPlayerObjet.setNb_victoires(currentPlayerObjet.getNb_victoires()+1);
                this.ihm.finPartie(currentPlayerObjet.id, currentPlayerObjet.name);
                continuer = this.ihm.choixContinuer();

            }

            // permuter d'utilisateur
            if (joueurCourant==0) {
                joueurCourant=1;
                currentPlayerObjet= this.constructeurJeu.joueur2;
            }
            else {
                joueurCourant=0;
                currentPlayerObjet= this.constructeurJeu.joueur1;
            }

        }

        this.ihm.finJeu(this.constructeurJeu.joueur1, this.constructeurJeu.joueur2);



    }
}
