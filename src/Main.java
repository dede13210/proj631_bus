import reseaux_bus.Arret;
import reseaux_bus.Horaire;
import reseaux_bus.Ligne;
import reseaux_bus.Parser;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws Exception {
        String path1 = "C:/Users/dede1/Documents/proj631_bus/src/1_Poisy-ParcDesGlaisins.txt";
        String path2 = "C:/Users/dede1/Documents/proj631_bus/src/2_Piscine-Patinoire_Campus.txt";
        Parser parser= new Parser();
        ArrayList<Ligne> ligne1 = new ArrayList<Ligne>(parser.parseDirection(path1));
        ArrayList<Ligne> ligne2 = new ArrayList<Ligne>(parser.parseDirection(path2));
        ArrayList<ArrayList<Ligne>> ligne = (parser.fusionLigne(ligne1,ligne2));

        ArrayList<Arret> listArret1 = new ArrayList<Arret>(parser.parseStop(path1,1)) ;
        ArrayList<Arret> listArret2 = new ArrayList<Arret>(parser.parseStop(path2,2)) ;
        ArrayList<Arret> listArret = new ArrayList<Arret>(parser.fusionArret(listArret1,listArret2)) ;

        ArrayList<ArrayList<Horaire>> listHoraire1 = new ArrayList<ArrayList<Horaire>>(parser.parseLigne1Horaire(path1, listArret1, ligne1));
        ArrayList<ArrayList<Horaire>> listHoraire2 = new ArrayList<ArrayList<Horaire>>(parser.parseLigne2Horaire(path2, listArret2, ligne2));

        //test
        //parser.displayArret(listArret2);
        //Parser.displayListHoraire(listHoraire2);


        for(int i=0; i<listArret.size(); i++){
            listArret.get(i).setListArretVoisin(listArret1,listArret2);
        }
        Parser.displayArret(listArret);


        /*displayLigne(ligne);
        parser.displayArret(listArret1);
        ;
        parser.displayListHoraire(listHoraire1);
        System.out.println("");*/









    }



}