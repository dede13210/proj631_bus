package reseaux_bus ;

import java.io.File;
import java.util.*;

public class Parser {




    public ArrayList<Ligne> parseDirection(String path){
        ArrayList<Ligne> listLigne = new ArrayList<Ligne>();
        try
        {
            File file1 = new File(path);
            Scanner scanner1 = new Scanner(file1);
            String ligneFiche1= scanner1.nextLine();
            String[] mot = ligneFiche1.split(" ");
            String[] nomFichier = path.split("");
            double numLigne = Double.valueOf(nomFichier[41]);
            Ligne ligneObject = new Ligne(numLigne+0.1, mot[0]);
            listLigne.add(ligneObject);
            Ligne ligneObject2 = new Ligne(numLigne+0.2,mot[mot.length-1]);
            listLigne.add(ligneObject2);
            if(Objects.equals(mot[1], "+")){
                Ligne ligneObject3 = new Ligne(numLigne+0.3,mot[2]);
                listLigne.add(ligneObject3);
            }

            scanner1.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listLigne;
    }

   public ArrayList<Arret> parseStop(String path,int ligne) throws Exception {
       ArrayList<Arret> listArret = new ArrayList<Arret>();
       File file1 = new File(path);
       Scanner scanner1 = new Scanner(file1);
       String stopIn1= scanner1.nextLine();
       String[] mot = stopIn1.split(" ");
       for (String word:mot) {
           if(!Objects.equals(word, "+")){
               if(!Objects.equals(word, "N")){
                   Arret arret = new Arret(word);
                   arret.add(ligne);
                   listArret.add(arret);
               }
           }
       }
       scanner1.close();
       return listArret;
    }

    public ArrayList<ArrayList<Horaire>> parseLigne1Horaire(String path, ArrayList<Arret> listArret,ArrayList<Ligne> listLigne){
        ArrayList<Horaire> listHoraire = new ArrayList<Horaire>();
        ArrayList<ArrayList<Horaire>> listListHoraire = new ArrayList<ArrayList<Horaire>>();
        try {
            File file1 = new File(path);
            Scanner scanner1 = new Scanner(file1);
            scanner1.nextLine();
            scanner1.nextLine();
            for(int y=0;y<listArret.size();y++) {
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
            for(int y=0;y<listArret.size();y++) {
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
            for(int y=0;y<listArret.size();y++) {
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
            for(int y=0;y<listArret.size();y++) {
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

    public ArrayList<ArrayList<Horaire>> parseLigne2Horaire(String path, ArrayList<Arret> listArret,ArrayList<Ligne> listLigne){
        ArrayList<Horaire> listHoraire2 = new ArrayList<Horaire>();
        ArrayList<ArrayList<Horaire>> listListHoraire2 = new ArrayList<ArrayList<Horaire>>();
        try{
            File file2 = new File(path);
            Scanner scanner2 = new Scanner(file2);
            scanner2.nextLine();
            scanner2.nextLine();
            for (int y = 0; y < listArret.size(); y++) {
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
            for (int y = 0; y < listArret.size(); y++) {
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
            for (int y = 0; y < listArret.size(); y++) {
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
            for (int y = 0; y < listArret.size(); y++) {
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
    public static void displayArret(ArrayList<Arret> tabArret){
        for(Arret object:tabArret){
            System.out.print(object.getNom());
            System.out.println(object.getLigne());
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






}