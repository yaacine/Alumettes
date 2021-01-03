package modele;

import java.util.ArrayList;

public class Tas {

    private int nb_tas;
    private int maxCoups=0;
    private ArrayList<Integer> alumettesParTas;


    public Tas(int nb_tas) {
        this.setNb_tas(nb_tas);
        ArrayList<Integer> tableau = new ArrayList<>(nb_tas);
        for (int i = 0; i < nb_tas; i++) {
            tableau.add(i, 2*i+1);
        }
        this.setAlumettesParTas(tableau);
    }

    // cette methode verifie si le coup est valide
    public boolean verifierCoup(Coup coup){

        if (getMaxCoups() >0 && coup.getNb_alumettes_retirer() > this.getMaxCoups()) return false;

        if(this.getAlumettesParTas().get(coup.getNum_tas() -1)< coup.getNb_alumettes_retirer()) return  false;
        else return true;
    }



    // cette methode joue le coup
    public boolean jouerCoup(Coup coup){
        if(this.getAlumettesParTas().get(coup.getNum_tas() -1)>= coup.getNb_alumettes_retirer()){

            this.getAlumettesParTas().set(coup.getNum_tas() -1, this.getAlumettesParTas().get(coup.getNum_tas() -1)- coup.getNb_alumettes_retirer());
            return  true;
        }
        else return false;
    }

    // cette methode verifie si la partie est terminée avec une victoure
    public boolean verifierVictoire(){
        boolean victoir = true;
        for (int i = 0; i < this.getAlumettesParTas().size(); i++) {
            if (this.getAlumettesParTas().get(i)>0) victoir = false;
        }
        return victoir;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Tas clonedTas = new Tas(this.getNb_tas());
        return clonedTas;
    }




    public int getNb_tas() {
        return nb_tas;
    }

    public void setNb_tas(int nb_tas) {
        this.nb_tas = nb_tas;
    }

    public int getMaxCoups() {
        return maxCoups;
    }

    public void setMaxCoups(int maxCoups) {
        this.maxCoups = maxCoups;
    }

    public ArrayList<Integer> getAlumettesParTas() {
        return alumettesParTas;
    }

    public void setAlumettesParTas(ArrayList<Integer> alumettesParTas) {
        this.alumettesParTas = alumettesParTas;
    }

    /**
     *  Cette partie est intégrée pour le mode IA
     * **/

    // cette methode retourne vrai si la situation est ganante et faux sinon
    public int situaitonGagnante(){
        int resultatXor = alumettesParTas.get(0);
        for (int i = 1; i < this.nb_tas; i++) {
            resultatXor = resultatXor ^ this.alumettesParTas.get(i);
        }
        return  resultatXor ;
    }

    // cette methode permet de jouer un coup quelconque
    public Coup joueruCoupQuelconque(){
        int tasJoue=0;
        for (int i = 0; i < this.nb_tas; i++) {
            if (this.alumettesParTas.get(i)>0){
                tasJoue= i;
                break;
            }
        }
        return new Coup(tasJoue+1,1);
    }

    // cette methode calcule le meilleur coup à jouer pour l'IA
    public Coup meulleurCoupIA(int resultXor){
        int tasJoue=0;
        int nbAlumetteNecessaires= 0;

        for (int i = 0; i < this.nb_tas; i++) {
            if (this.alumettesParTas.get(i)>0){
                tasJoue= i;
                nbAlumetteNecessaires = this.alumettesParTas.get(i) ^ resultXor ;
                if ( this.alumettesParTas.get(i)  >= nbAlumetteNecessaires){
                    break;
                }

            }
        }
        return new Coup(tasJoue+1,nbAlumetteNecessaires);
    }


}
