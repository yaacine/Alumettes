package controller;

import modele.Joueur;
import modele.Tas;
import vue.Ihm;

public class ConstructeurJeu {

    public Tas tas;
    public Ihm ihm;
    public Joueur joueur1;
    public Joueur joueur2;
    public int nbMaxCoups;
    public String nomjoueur1;
    public String nomjoueur2;
    public int nbTas;

    public ConstructeurJeu(Ihm ihm) {
        this.ihm = ihm;
    }

    public void construireJeu(){

        this.nbTas= this.ihm.getNbTas();
        this.tas = new Tas(this.nbTas);
        this.nbMaxCoups= this.ihm.getMaxAlumettesNb();

        this.nomjoueur1 = this.ihm.nomJoueur(0);
        this.nomjoueur2 = this.ihm.nomJoueur(1);

        this.joueur1= new Joueur(1, this.nomjoueur1, 0 );
        this.joueur2= new Joueur(2, this.nomjoueur2, 0 );

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

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public int getNbMaxCoups() {
        return nbMaxCoups;
    }

    public void setNbMaxCoups(int nbMaxCoups) {
        this.nbMaxCoups = nbMaxCoups;
    }

    public String getNomjoueur1() {
        return nomjoueur1;
    }

    public void setNomjoueur1(String nomjoueur1) {
        this.nomjoueur1 = nomjoueur1;
    }

    public String getNomjoueur2() {
        return nomjoueur2;
    }

    public void setNomjoueur2(String nomjoueur2) {
        this.nomjoueur2 = nomjoueur2;
    }

    public int getNbTas() {
        return nbTas;
    }

    public void setNbTas(int nbTas) {
        this.nbTas = nbTas;
    }


}
