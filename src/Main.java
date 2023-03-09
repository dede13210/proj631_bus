import reseaux_bus.BusStop;
import reseaux_bus.Graph;
import reseaux_bus.Ligne;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws Exception {
        String path1 = "file/1_Poisy-ParcDesGlaisins.txt";
        String path2 = "file/2_Piscine-Patinoire_Campus.txt";

        Ligne ligne1 =new Ligne(null);//on initialise l'objet ligne à null
        Ligne ligne2= new Ligne(null);
        ligne1.parseDirection(path1);//on parse la ligne avec le terminus
        ligne2.parseDirection(path2);
        Graph reseau1=new Graph();
        reseau1.parseStop(path1,ligne1);
        reseau1.parseStop(path2,ligne2);
        reseau1.setListBusStopVoisin();
        reseau1.fusionBusStop();
        reseau1.parseArrete(path1);
        reseau1.parseArrete(path2);

        Map<BusStop,Integer> gps = reseau1.shortestPath(reseau1.findBusStop("GARE"),reseau1.findBusStop("Mandallaz"));



        //test
        //reseau1.displayBusStop();
        for(BusStop busStop: gps.keySet())
            System.out.println(busStop.getNom()+" "+gps.get(busStop));
        //System.out.println(reseau1.getListBusStop().size());
        //reseau1.displayArete();
        /*
        ligne1.displayLigne();
        System.out.println(" ");
        ligne2.displayLigne();
*/

    }
}