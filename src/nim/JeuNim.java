package nim;

import controller.ConstructeurJeu;
import controller.ControleurJeu;
import modele.Tas;
import vue.Ihm;

public class JeuNim {

    public static void main(String[] args) {
        Ihm ihm = new Ihm();
        ConstructeurJeu constructeurJeu= new ConstructeurJeu(ihm);
        constructeurJeu.construireJeu();
        Tas lesTas=constructeurJeu.getTas();
        ControleurJeu controleurJeu=new ControleurJeu(ihm, lesTas, constructeurJeu);
        controleurJeu.commencerJeu();
    }
}
