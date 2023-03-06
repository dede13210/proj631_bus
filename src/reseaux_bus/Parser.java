package reseaux_bus ;

import java.io.File;
import java.util.*;

public class Parser {






  /*

    public ArrayList<ArrayList<Horaire>> parseLigne1Horaire(String path, ArrayList<BusStop> listBusStop, ArrayList<Ligne> listLigne){
        ArrayList<Horaire> listHoraire = new ArrayList<Horaire>();
        ArrayList<ArrayList<Horaire>> listListHoraire = new ArrayList<ArrayList<Horaire>>();
        try {
            File file1 = new File(path);
            Scanner scanner1 = new Scanner(file1);
            scanner1.nextLine();
            scanner1.nextLine();
            for(int y = 0; y< listBusStop.size(); y++) {
                String line = scanner1.nextLine();
                String[] lines = line.split(" ");
                for (int i = 1; i < lines.length; i++) {
                    try {

                        Horaire horaire = new Horaire(listLigne.get(1), lines[0], Integer.valueOf(lines[i].split(":")[0]), Integer.valueOf(lines[i].split(":")[1]), true);
                        listHoraire.add(horaire);


                    } catch (Exception e) {
                        Horaire horaire = new Horaire(null, lines[0], null, null, null);
                        listHoraire.add(horaire);
                    }


                }
                listListHoraire.add(listHoraire);
            }
            scanner1.next();
            for(int y = 0; y< listBusStop.size(); y++) {
                String line = scanner1.nextLine();
                String[] lines = line.split(" ");
                for (int i = 1; i < lines.length; i++) {
                    try {

                        Horaire horaire = new Horaire(listLigne.get(3),lines[0], Integer.valueOf(lines[i].split(":")[0]), Integer.valueOf(lines[i].split(":")[1]),true);
                        listHoraire.add(horaire);


                    } catch (Exception e) {
                        Horaire horaire = new Horaire(null,lines[0],null,null,null);
                        listHoraire.add(horaire);
                    }


                }
                listListHoraire.add(listHoraire);
            }
            scanner1.next();
            scanner1.next();
            scanner1.next();
            for(int y = 0; y< listBusStop.size(); y++) {
                String line = scanner1.nextLine();
                String[] lines = line.split(" ");
                for (int i = 1; i < lines.length; i++) {
                    try {

                        Horaire horaire = new Horaire(listLigne.get(1), lines[0], Integer.valueOf(lines[i].split(":")[0]), Integer.valueOf(lines[i].split(":")[1]), false);
                        listHoraire.add(horaire);


                    } catch (Exception e) {
                        Horaire horaire = new Horaire(null, lines[0], null, null, null);
                        listHoraire.add(horaire);
                    }


                }
                listListHoraire.add(listHoraire);
            }
            scanner1.next();
            for(int y = 0; y< listBusStop.size(); y++) {
                String line = scanner1.nextLine();
                String[] lines = line.split(" ");
                for (int i = 1; i < lines.length; i++) {
                    try {

                        Horaire horaire = new Horaire(listLigne.get(2),lines[0], Integer.valueOf(lines[i].split(":")[0]), Integer.valueOf(lines[i].split(":")[1]),false);
                        listHoraire.add(horaire);


                    } catch (Exception e) {
                        Horaire horaire = new Horaire(null,lines[0],null,null,null);
                        listHoraire.add(horaire);
                    }


                }
                listListHoraire.add(listHoraire);
            }
            scanner1.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listListHoraire;
    }

    public ArrayList<ArrayList<Horaire>> parseLigne2Horaire(String path, ArrayList<BusStop> listBusStop, ArrayList<Ligne> listLigne){
        ArrayList<Horaire> listHoraire2 = new ArrayList<Horaire>();
        ArrayList<ArrayList<Horaire>> listListHoraire2 = new ArrayList<ArrayList<Horaire>>();
        try{
            File file2 = new File(path);
            Scanner scanner2 = new Scanner(file2);
            scanner2.nextLine();
            scanner2.nextLine();
            for (int y = 0; y < listBusStop.size(); y++) {
                String line2 = scanner2.nextLine();
                String[] lines2 = line2.split(" ");
                for(int i=1; i<lines2.length ; i++){
                    try {

                        Horaire horaire = new Horaire(listLigne.get(1),lines2[0], Integer.valueOf(lines2[i].split(":")[0]), Integer.valueOf(lines2[i].split(":")[1]),true);
                        listHoraire2.add(horaire);


                    } catch (Exception e) {
                        Horaire horaire = new Horaire(null,lines2[0],null,null,null);
                        listHoraire2.add(horaire);
                    }
                }
                listListHoraire2.add(listHoraire2);

            }
            scanner2.next();
            for (int y = 0; y < listBusStop.size(); y++) {
                String line2 = scanner2.nextLine();
                String[] lines2 = line2.split(" ");
                for(int i=1; i<lines2.length ; i++){
                    try {

                        Horaire horaire = new Horaire(listLigne.get(0),lines2[0], Integer.valueOf(lines2[i].split(":")[0]), Integer.valueOf(lines2[i].split(":")[1]),true);
                        listHoraire2.add(horaire);


                    } catch (Exception e) {
                        Horaire horaire = new Horaire(null,lines2[0],null,null,null);
                        listHoraire2.add(horaire);
                    }
                }
                listListHoraire2.add(listHoraire2);

            }
            scanner2.next();
            scanner2.next();
            scanner2.next();
            for (int y = 0; y < listBusStop.size(); y++) {
                String line2 = scanner2.nextLine();
                String[] lines2 = line2.split(" ");
                for(int i=1; i<lines2.length ; i++){
                    try {

                        Horaire horaire = new Horaire(listLigne.get(1),lines2[0], Integer.valueOf(lines2[i].split(":")[0]), Integer.valueOf(lines2[i].split(":")[1]),false);
                        listHoraire2.add(horaire);


                    } catch (Exception e) {
                        Horaire horaire = new Horaire(null,lines2[0],null,null,null);
                        listHoraire2.add(horaire);
                    }
                }
                listListHoraire2.add(listHoraire2);

            }
            scanner2.next();
            for (int y = 0; y < listBusStop.size(); y++) {
                String line2 = scanner2.nextLine();
                String[] lines2 = line2.split(" ");
                for(int i=1; i<lines2.length ; i++){
                    try {

                        Horaire horaire = new Horaire(listLigne.get(1),lines2[0], Integer.valueOf(lines2[i].split(":")[0]), Integer.valueOf(lines2[i].split(":")[1]),true);
                        listHoraire2.add(horaire);


                    } catch (Exception e) {
                        Horaire horaire = new Horaire(null,lines2[0],null,null,null);
                        listHoraire2.add(horaire);
                    }
                }
                listListHoraire2.add(listHoraire2);

            }

            scanner2.close();
        }

        catch (Exception e){
            System.out.println("mauvais chemin de fichier");

        }

        return listListHoraire2;
    }

    public ArrayList<ArrayList<Ligne>> fusionLigne(ArrayList<Ligne> tabLigne1, ArrayList<Ligne> tabLigne2){
        ArrayList<ArrayList<Ligne>> tabLigne = new ArrayList<ArrayList<Ligne>>();
        tabLigne.add(tabLigne1);
        tabLigne.add(tabLigne1);


        return tabLigne;
    }
    public static void displayArret(ArrayList<BusStop> tabBusStop){
        for(BusStop object: tabBusStop){
            System.out.print(object.getNom());
            System.out.println(object.getLigne());
            if(object.getListArretVoisin().size()==1)
                System.out.println(object.getListArretVoisin().get(0).getNom());
            if((object.getListArretVoisin().size()==2)) {
                System.out.print(object.getListArretVoisin().get(0).getNom()+" ");
                System.out.println(object.getListArretVoisin().get(1).getNom());
            }
            if((object.getListArretVoisin().size()==3)) {
                System.out.print(object.getListArretVoisin().get(0).getNom()+" ");
                System.out.print(object.getListArretVoisin().get(1).getNom()+" ");
                System.out.println(object.getListArretVoisin().get(2).getNom());
            }
            if((object.getListArretVoisin().size()==4)) {
                System.out.print(object.getListArretVoisin().get(0).getNom()+" ");
                System.out.print(object.getListArretVoisin().get(1).getNom()+" ");
                System.out.print(object.getListArretVoisin().get(2).getNom()+" ");
                System.out.println(object.getListArretVoisin().get(3).getNom());
            }
        }
    }
    public static void displayLigne(ArrayList<Ligne> tabLigne){
        for(Ligne object:tabLigne){
                System.out.print(object.getNumero());
                System.out.println(" "+object.getDestination());
        }
    }
    public static void displayListHoraire(ArrayList<ArrayList<Horaire>> list){
                for (ArrayList<Horaire> arrayList : list) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        arrayList.get(i).display();
                    }
                    System.out.println();
                }
            }

            public ArrayList<BusStop> fusionArret(ArrayList<BusStop> list1, ArrayList<BusStop> list2){
                ArrayList<BusStop> list3 = new ArrayList<>();
                ArrayList<BusStop> list11 = (ArrayList<BusStop>) list1.clone();
                ArrayList<BusStop> list22 = (ArrayList<BusStop>) list2.clone();

                int cpt=0;
                for(BusStop busStop1 :list1){
                    for(BusStop busStop2 :list2){
                        if (busStop1.getNom().equals(busStop2.getNom())){
                            list3.add(busStop1);

                            list11.remove(busStop1);
                            list22.remove(busStop2);
                            list3.get(cpt).add(2);
                            cpt+=1;
                        }


                        }
                    if(!list3.contains(busStop1)) {
                        list3.add(busStop1);
                        list11.remove(busStop1);

                    }                }
                if(list11.isEmpty()&&list22.isEmpty()){
                    return list3;
                }

               return fusionArret(list22,list11) ;
            }



*/


}