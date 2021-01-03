package controller;

import modele.Coup;
import modele.Joueur;
import modele.Tas;
import vue.Ihm;

public class ControlleurJeuIA extends ControleurJeu{

    public ControlleurJeuIA(Ihm ihm, Tas tas, ConstructeurJeu constructeurJeu) {
        super(ihm, tas, constructeurJeu);
    }



    public void commencerJeu()  {
        boolean continuer = true;
        int joueurCourant=0;
        Joueur currentPlayerObjet= this.getConstructeurJeu().getJoueur1();
        this.getIhm().start();
        boolean victoire= false;
        while (continuer){

            this.getIhm().displayTas(this.getTas());
            boolean coupValide= false;
            Coup coup=null;

            if (joueurCourant==1){  // tour de l'ordinateur de jouer
                while (!coupValide){
                    boolean sitGagnante = this.getTas().situaitonGagnante()!=0;
                    if (sitGagnante){
                        coup= this.getTas().meulleurCoupIA(getConstructeurJeu().getNbMaxCoups());
                    }else {
                        coup= this.getTas().joueruCoupQuelconque();
                    }
                    coupValide = this.getTas().verifierCoup(coup);

                }
            }
            else{  // tour du joueur  de jouer
                while (!coupValide){
                    coup = this.getIhm().recupererCoup(currentPlayerObjet);
                    coupValide = this.getTas().verifierCoup(coup);
                    if (!coupValide){
                        this.getIhm().coupInvalide();
                    }
                }
            }


            this.getTas().jouerCoup(coup);
            if (joueurCourant==1) this.getIhm().afficherCoupIA(coup);
            victoire = this.getTas().verifierVictoire();


            if(victoire){

                currentPlayerObjet.setNb_victoires(currentPlayerObjet.getNb_victoires()+1);
                this.getIhm().finPartie(currentPlayerObjet.getId(), currentPlayerObjet.getName());
                continuer = this.getIhm().choixContinuer();
                if(continuer) {
                    try{
                        this.setTas((Tas) this.getTas().clone());
                    }catch (Exception e){
                        System.out.println("Erreure dans le clonage du tas");
                    }
                }
            }

            // permuter l'utilisateur
            if (joueurCourant==0) {
                joueurCourant=1;
                currentPlayerObjet= this.getConstructeurJeu().getJoueur2();
            }
            else {
                joueurCourant=0;
                currentPlayerObjet= this.getConstructeurJeu().getJoueur1();
            }

        }

        this.getIhm().finJeu(this.getConstructeurJeu().getJoueur1(), this.getConstructeurJeu().getJoueur2());



    }


}
