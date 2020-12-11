package vue;

import modele.Tas;

import java.util.Scanner;

public class Ihm {

    // cette methode affiche tous le tas
    public void displayTas(Tas tas){
        for (int i = 0; i < tas.nb_tas ; i++) {
            displaySingleTas(tas.alumettesParTas.get(i));
        }
    }

    // cette methode affiche un seule tas
    public void displaySingleTas(int nbAlumettes){
        int i=0;
        while (i<nbAlumettes){
            System.out.print("| ");
        }
    }

    // cette methode demande à l'utilisateur de saisir le nombre de tas
    public int getNbTas(){
        int nbTas=0;
        boolean correct =false;

        while(!correct){
            System.out.print("Introduisez le nombre de tas :");
            Scanner scan = new Scanner(System.in);
            String s = scan.next();
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
            System.out.print("limiter le nombre d'allumettes a retirer a chaque coup? introduisez la limire sinon 0:");
            Scanner scan = new Scanner(System.in);
            String s = scan.next();
            maxCoup = scan.nextInt();
            if (maxCoup<0){
                System.out.println("Le nombre de Tas doit etre superieure ou egale à 0 ! ");
            }
            else {
                correct=true;
            }
        }

        return maxCoup;
    }

    // cette methode demande de saisir le nom du joueur
    public String nomJoueur(){
        String nom ="";
        System.out.print("limiter le nombre d'allumettes a retirer a chaque coup? introduisez la limire sinon 0:");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        nom = scan.nextLine();
        return nom;
    }

}
