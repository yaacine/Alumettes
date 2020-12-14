package controller;

import modele.Coup;
import modele.Joueur;
import modele.Tas;
import vue.Ihm;

public class ControleurJeu {

    private Tas tas;
    private Ihm ihm;
    // nous devrons avoir l'instance de ConstructeurJeu
    private ConstructeurJeu constructeurJeu;


    public ControleurJeu(Ihm ihm,Tas tas, ConstructeurJeu constructeurJeu) {
        this.setTas(tas);
        this.setIhm(ihm);
        this.setConstructeurJeu(constructeurJeu);
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
            while (!coupValide){
                coup = this.getIhm().recupererCoup(currentPlayerObjet);
                coupValide = this.getTas().verifierCoup(coup);
                if (!coupValide){
                    this.getIhm().coupInvalide();
                }
            }

            this.getTas().jouerCoup(coup);
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

            // permuter d'utilisateur
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

    public Tas getTas() {
        return tas;
    }

    public void setTas(Tas tas) {
        this.tas = tas;
    }

    public Ihm getIhm() {
        return ihm;
    }

    public void setIhm(Ihm ihm) {
        this.ihm = ihm;
    }

    public ConstructeurJeu getConstructeurJeu() {
        return constructeurJeu;
    }

    public void setConstructeurJeu(ConstructeurJeu constructeurJeu) {
        this.constructeurJeu = constructeurJeu;
    }
}
