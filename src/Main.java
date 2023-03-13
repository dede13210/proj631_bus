import reseaux_bus.BusStop;
import reseaux_bus.Graph;
import reseaux_bus.Ligne;

import java.util.ArrayList;
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
        Map<BusStop,Integer> distanceMandallaz = reseau1.shortestPath(reseau1.findBusStop("Mandallaz"));
        ArrayList<BusStop> itineraireGareVernod=reseau1.ShortestPathItinerary(reseau1.findBusStop("Vernod"),reseau1.findBusStop("GARE"));


        //test
        /*for(BusStop busStop:distanceMandallaz.keySet()){
            System.out.println(busStop.getNom()+" "+distanceMandallaz.get(busStop));
        }*/


        //reseau1.displayBusStop();
        for(BusStop busStop: itineraireGareVernod)
            System.out.println(busStop.getNom());
        System.out.println(itineraireGareVernod.size());
        //System.out.println(reseau1.getListBusStop().size());
        //reseau1.displayArete();
        /*
        ligne1.displayLigne();
        System.out.println(" ");
        ligne2.displayLigne();
*/

    }
}