package vue;

import modele.Coup;
import modele.Joueur;
import modele.Tas;

import java.util.Scanner;

public class Ihm {

    // cette methode affiche tous le tas
    public void displayTas(Tas tas){
        for (int i = 0; i < tas.getNb_tas(); i++) {
            displaySingleTas(tas.getAlumettesParTas().get(i));
        }
    }

    // cette methode affiche un seule tas (un etage)
    public void displaySingleTas(int nbAlumettes){
        int i=0;
        while (i<nbAlumettes){
            System.out.print("| ");
            i++;
        }
        System.out.println();
    }

    // cette methode demande à l'utilisateur de saisir le nombre de tas
    public int getNbTas(){
        int nbTas=0;
        boolean correct =false;

        while(!correct){
            System.out.print("Introduisez le nombre de tas :");
            Scanner scan = new Scanner(System.in);
            nbTas = scan.nextInt();
            if (nbTas<1){
                System.out.println("Le nombre de Tas doit etre superieure ou egale à 1 ! ");
            }
            else {
                correct=true;
            }
        }

        return nbTas;
    }

    // cette methode demande le nombre maximal d'allumettes par coup
    public int getMaxAlumettesNb(){
        int maxCoup=0;
        boolean correct =false;

        while (!correct){
            System.out.print("limiter le nombre d'allumettes a retirer a chaque coup? introduisez la limire sinon 0:  ");
            Scanner scan = new Scanner(System.in);
            maxCoup = scan.nextInt();
            if (maxCoup<0){
                System.out.println("Le nombre de Tas doit etre superieure ou egale à 0 ! ");
            }
            else {
                correct=true;
                return maxCoup;
            }
        }
        return maxCoup;

    }

    // cette methode demande de saisir le nom du joueur
    public String nomJoueur(int numJoueur){
        String nom ="";
        System.out.print("Introduisez le nom du joueur " +numJoueur +":  ");
        Scanner scan = new Scanner(System.in);
        nom = scan.nextLine();
        return nom;
    }

    // cette methode annonce le debut de la partie
    public void start(){
        System.out.println("Super! la partie va commance maintenant !!! ");

    }

    // cette methode affiche la fin d'une partie et annonce le vainqueur de la partie
    public void finPartie(int idGagnant , String nomGagnant){
        System.out.println("Partie terminee , le vainqueur est le joueur: "+idGagnant+" => "+nomGagnant);
    }

    // cette methode affiche la fin du jeu et annonce le vainqueur
    public void finJeu(Joueur joueur1 , Joueur joueur2){
        System.out.println("*************************************************");
        System.out.println("***************Le Jeu est terminé****************");
        System.out.println("joueur1:   "+ joueur1.getName() + "  ****||****  "+ joueur2.getName());
        System.out.println("victoites: " + joueur1.getNb_victoires() + "  ****||****  "+ joueur2.getNb_victoires());
        System.out.println("***************Le Jeu est terminé****************");
        if(joueur1.getNb_victoires() > joueur2.getNb_victoires()){
            System.out.println("Le vainqueur est le joueur:  "+ joueur1.getName());

        }else if(joueur1.getNb_victoires() < joueur2.getNb_victoires()){
            System.out.println("Le vainqueur est le joueur:  "+ joueur2.getName());

        }else{

        }

    }

    // cette methode demande si on veut continuer ou quitter le jeu
    public boolean choixContinuer(){
        String result="";
        System.out.print("Voulez vous continuer ? ecrivez oui/non : ");
        Scanner scan = new Scanner(System.in);
        result = scan.nextLine();
        return result.equals("oui");

    }

    // cette methode recupere le coup du joueur
    public Coup recupererCoup(Joueur player){
        Coup coup;
        String result;
        System.out.print("C'est le tour du joueur ## "+ player.getName() +" ## pour jouer.");
        System.out.print("Ecriver votre coup sous forme: tas,nombre_d'alumettes ");
        Scanner scan = new Scanner(System.in);
        result = scan.nextLine();
        int numTas=0;
        int nbAllume=0;
        String tab[];
        tab = result.split(",");
        try{
             numTas  = Integer.parseInt(tab[0]);
             nbAllume  = Integer.parseInt(tab[1]);
        }catch (Exception e){
            System.out.print("Erreur dans le format du coup. Veuillez ecriver votre coup sous forme: tas,nombre_d'alumettes : ");
        }

        coup = new Coup(numTas, nbAllume);
        return  coup;
    }

    // cette methode affiche que le coup n'est pas valide
    public void coupInvalide(){
        System.out.println("Erreur : Le coup n'est pas valide, veulliez réessayer:  ");
    }



    // cette methode demande si on veut continuer ou quitter le jeu
    public boolean jouerContreIA(){
        String result="";
        System.out.print("Voulez vous jouer contre l'IA ? ecrivez oui/non : ");
        Scanner scan = new Scanner(System.in);
        result = scan.nextLine();
        boolean contreIa = result.equals("oui");
        return result.equals("oui");
    }


    public void afficherCoupIA(Coup coup){
        System.out.print("IA joue : " + coup.getNum_tas() +" "+ coup.getNb_alumettes_retirer());
    }
}
