package controller;

import modele.Joueur;
import modele.Tas;
import vue.Ihm;

public class ConstructeurJeu {

    private Tas tas;
    private Ihm ihm;
    private Joueur joueur1;
    private Joueur joueur2;
    private int nbMaxCoups;
    private String nomjoueur1;
    private String nomjoueur2;
    private int nbTas;
    public boolean contreIA=true;



    public ConstructeurJeu(Ihm ihm) {
        this.setIhm(ihm);
    }

    public void construireJeu(){

        this.setNbTas(this.getIhm().getNbTas());
        this.setTas(new Tas(this.getNbTas()));

        this.setNbMaxCoups(this.getIhm().getMaxAlumettesNb());
        this.contreIA = this.getIhm().jouerContreIA();

        this.setNomjoueur1(this.getIhm().nomJoueur(0));
        if (!this.contreIA) this.setNomjoueur2(this.getIhm().nomJoueur(1));
        else this.setNomjoueur2("Ordinateur");

        this.setJoueur1(new Joueur(1, this.getNomjoueur1(), 0 ));
        this.setJoueur2(new Joueur(2, this.getNomjoueur2(), 0 ));

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
