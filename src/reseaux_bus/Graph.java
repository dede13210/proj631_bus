package reseaux_bus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class Graph {
    private ArrayList<BusStop> listBusStop;
    private ArrayList<Arete> listArrete;

    public Graph() {
        this.listBusStop = new ArrayList<BusStop>();
        this.listArrete = new ArrayList<Arete>();
    }

    public void parseStop(String path, Ligne ligne) throws Exception {
        File file1 = new File(path);
        Scanner scanner1 = new Scanner(file1);
        String stopIn1= scanner1.nextLine();
        String[] mot = stopIn1.split(" ");
        for (String word:mot) {
            if(!Objects.equals(word, "+")){
                if(!Objects.equals(word, "N")){
                    BusStop busStop = new BusStop(word);
                    busStop.add(ligne.getNumero());
                    listBusStop.add(busStop);
                }
            }
        }
        scanner1.close();
        }

    public void setListBusStopVoisin() {
        for(BusStop busStop:this.listBusStop)
            busStop.busStopVoisin(this.listBusStop);
        ArrayList<BusStop> vernod = new ArrayList<BusStop>();
        vernod.add(this.listBusStop.get(2));
        this.listBusStop.get(0).setListBusStopVoisin(vernod);
        this.listBusStop.get(1).setListBusStopVoisin(vernod);
        BusStop lyceepoysi =this.listBusStop.get(0);
        this.listBusStop.get(2).addBusStopVoisin(lyceepoysi);
    }
    public void fusionBusStop(){
        ArrayList<BusStop> listBusStop2= new ArrayList<BusStop>();
        //on creer la list puis on remplie des busStop
        listBusStop2.addAll(this.listBusStop);
        ArrayList<BusStop> listBusStops3 = new ArrayList<BusStop>();
        listBusStops3.addAll(this.listBusStop);

        for(BusStop busStop1 : listBusStops3){

            for(BusStop busStop2:listBusStop2){

                if(busStop2.getNom().equals(busStop1.getNom()) && !busStop2.getLigne().contains(busStop1.getLigne().get(0)) ) {
                    //on verifie que les nom soit egale et que la ligne est différente

                    BusStop busStop3 = new BusStop(busStop2.getNom());
                    busStop3.add(busStop1.getLigne().get(0));
                    busStop3.add(busStop2.getLigne().get(0));
                    busStop3.addBusStopVoisin(busStop1.listBusStopVoisin.get(0));
                    if (busStop1.getListBusStopVoisin().size() == 2)
                        busStop3.addBusStopVoisin(busStop1.listBusStopVoisin.get(1));
                    busStop3.addBusStopVoisin(busStop2.listBusStopVoisin.get(0));
                    if (busStop2.getListBusStopVoisin().size() == 2)
                        busStop3.addBusStopVoisin(busStop2.listBusStopVoisin.get(1));
                    this.listBusStop.remove(busStop1);
                    this.listBusStop.remove(busStop2);
                    this.listBusStop.add(busStop3);

                }}
        }
        this.listBusStop.remove(this.listBusStop.size()-1);
        this.listBusStop.remove(this.listBusStop.size()-2);
            }

    public void addBusStop(BusStop busStop){
        listBusStop.add(busStop);
    }
    public void addArete(Arete arete){
        listArrete.add(arete);
    }

    public ArrayList<BusStop> getListBusStop() {
        return listBusStop;
    }

    public ArrayList<Arete> getListArrete() {
        return listArrete;
    }
    public void displayGraph(){
        for(BusStop busStop:listBusStop){
            busStop.display();
        }
    }
    public void parseArrete(String path) throws FileNotFoundException {
        try {
            File file1 = new File(path);
            Scanner scanner1 = new Scanner(file1);
            String[] line0 = scanner1.nextLine().split(" ");
            if(line0[1].equals("+")){
                scanner1.nextLine();
                scanner1.nextLine();
                String line1= scanner1.nextLine();
                String line2= scanner1.nextLine();
                String line3= scanner1.nextLine();
                String[] lines1 = line1.split(" ");
                String[] lines2 = line2.split(" ");
                String[] lines3 = line3.split(" ");
                //System.out.println(Arrays.toString(lines2));
                for(int i = 1 ; i<lines1.length ; i++){
                    try{
                        String[] mot1=lines1[i].split(":");
                        String[] mot3=lines3[i].split(":");
                        if(!mot1[0].equals(("-"))&&!mot3[0].equals("-")){
                            Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines3[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot3[0]), Integer.parseInt(mot3[1])}, true);
                            this.listArrete.add(arete);
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    try{
                        String[] mot2=lines2[i].split(":");
                        String[] mot3=lines3[i].split(":");
                        if(!mot2[0].equals(("-"))&&!mot3[0].equals("-")) {
                            Arete arete = new Arete(findBusStop(lines2[0]), findBusStop(lines3[0]), new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, new int[]{Integer.parseInt(mot3[0]), Integer.parseInt(mot3[1])}, true);
                            this.listArrete.add(arete);
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                lines2=lines3;
                for(int i=3 ; i<12 ;i++){

                    lines1=lines2;
                    lines2=scanner1.nextLine().split(" ");
                    for(int y = 1 ; y<lines2.length ; y++){
                        String[] mot1=lines1[y].split(":");
                        String[] mot2=lines2[y].split(":");
                        try{
                            if(!mot1[0].equals(("-"))&&!mot2[0].equals("-")){
                                Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines2[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, true);
                                this.listArrete.add(arete);
                            }
                        }catch(Exception e) {
                            e.printStackTrace();
                        }


                }}
                scanner1.nextLine();
                lines2=scanner1.nextLine().split(" ");
                for(int i=0 ; i<9 ;i++){

                    lines1=lines2;
                    lines2=scanner1.nextLine().split(" ");
                    for(int y = 1 ; y<lines2.length ; y++){
                        String[] mot1=lines1[y].split(":");
                        String[] mot2=lines2[y].split(":");
                        try{
                            if(!mot1[0].equals(("-"))&&!mot2[0].equals("-")){
                                Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines2[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, true);
                                this.listArrete.add(arete);
                            }
                        }catch(Exception e) {
                            e.printStackTrace();
                        }


                    }}


                String lineLyceePoisy= scanner1.nextLine();
                String[] linesVernod = lines1;
                String[] linesPoisyCollege = lines2;
                String[] linesLyceePoisy = lineLyceePoisy.split(" ");
                //System.out.println(Arrays.toString(linesPoisyCollege));
                for(int i = 1 ; i<lines2.length ; i++){
                    try{
                        String[] mot1=linesVernod[i].split(":");
                        String[] mot3=linesPoisyCollege[i].split(":");
                        if(!mot1[0].equals(("-"))&&!mot3[0].equals("-")){
                            Arete arete = new Arete(findBusStop(linesVernod[0]), findBusStop(linesPoisyCollege[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot3[0]), Integer.parseInt(mot3[1])}, true);
                            this.listArrete.add(arete);
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    try{
                        String[] mot2=linesVernod[i].split(":");
                        String[] mot3=linesLyceePoisy[i].split(":");
                        if(!mot2[0].equals(("-"))&&!mot3[0].equals("-")) {
                            Arete arete = new Arete(findBusStop(linesVernod[0]), findBusStop(linesLyceePoisy[0]), new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, new int[]{Integer.parseInt(mot3[0]), Integer.parseInt(mot3[1])}, true);
                            this.listArrete.add(arete);
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }

                scanner1.nextLine();
                scanner1.nextLine();
                line1=null;
                line2=null;
                line3=null;
                lines1=null;
                lines2= null;
                lines3=null;
                line1= scanner1.nextLine();
                line2= scanner1.nextLine();
                line3= scanner1.nextLine();
                lines1 = line1.split(" ");
                lines2 = line2.split(" ");
                lines3 = line3.split(" ");
                //System.out.println(Arrays.toString(lines1));
                for(int i = 1 ; i<lines1.length ; i++){
                    try{
                        String[] mot1=lines1[i].split(":");
                        String[] mot3=lines3[i].split(":");
                        if(!mot1[0].equals(("-"))&&!mot3[0].equals("-")){
                            Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines3[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot3[0]), Integer.parseInt(mot3[1])}, false);
                            this.listArrete.add(arete);
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    try{
                        String[] mot2=lines2[i].split(":");
                        String[] mot3=lines3[i].split(":");
                        if(!mot2[0].equals(("-"))&&!mot3[0].equals("-")) {
                            Arete arete = new Arete(findBusStop(lines2[0]), findBusStop(lines3[0]), new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, new int[]{Integer.parseInt(mot3[0]), Integer.parseInt(mot3[1])}, false);
                            this.listArrete.add(arete);
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                lines2=lines3;
                for(int i=3 ; i<12 ;i++){

                    lines1=lines2;
                    lines2=scanner1.nextLine().split(" ");
                    for(int y = 1 ; y<lines2.length ; y++){
                        String[] mot1=lines1[y].split(":");
                        String[] mot2=lines2[y].split(":");
                        try{
                            if(!mot1[0].equals(("-"))&&!mot2[0].equals("-")){
                                Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines2[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, false);
                                this.listArrete.add(arete);
                            }
                        }catch(Exception e) {
                            e.printStackTrace();
                        }


                    }}
                scanner1.nextLine();
                lines2=scanner1.nextLine().split(" ");
                //System.out.println(Arrays.toString(lines2));
                for(int i=0 ; i<8 ;i++){

                    lines1=lines2;
                    lines2=scanner1.nextLine().split(" ");
                    for(int y = 1 ; y<lines1.length ; y++){
                        String[] mot1=lines1[y].split(":");
                        String[] mot2=lines2[y].split(":");
                        try{
                            if(!mot1[0].equals(("-"))&&!mot2[0].equals("-")){
                                Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines2[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, false);
                                this.listArrete.add(arete);
                            }
                        }catch(Exception e) {
                            e.printStackTrace();
                        }


                    }}
                lineLyceePoisy=null;
                linesVernod=null;
                linesPoisyCollege=null;
                linesLyceePoisy=null;
                linesVernod=null;
                scanner1.nextLine();
                linesVernod = scanner1.nextLine().split(" ");
                String linePoisyCollege= scanner1.nextLine();
                lineLyceePoisy= scanner1.nextLine();
                linesPoisyCollege = linePoisyCollege.split(" ");
                linesLyceePoisy = lineLyceePoisy.split(" ");
                //System.out.println(Arrays.toString(linesLyceePoisy));
                for(int i = 1 ; i<lines2.length ; i++){
                    try{
                        String[] mot1=linesVernod[i].split(":");
                        String[] mot3=linesPoisyCollege[i].split(":");
                        if(!mot1[0].equals(("-"))&&!mot3[0].equals("-")){
                            Arete arete = new Arete(findBusStop(linesVernod[0]), findBusStop(linesPoisyCollege[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot3[0]), Integer.parseInt(mot3[1])}, false);
                            this.listArrete.add(arete);
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    try{
                        String[] mot2=linesVernod[i].split(":");
                        String[] mot3=linesLyceePoisy[i].split(":");
                        if(!mot2[0].equals(("-"))&&!mot3[0].equals("-")) {
                            Arete arete = new Arete(findBusStop(linesVernod[0]), findBusStop(linesLyceePoisy[0]), new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, new int[]{Integer.parseInt(mot3[0]), Integer.parseInt(mot3[1])}, false);
                            this.listArrete.add(arete);
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if(!line0[1].equals("+")){

                scanner1.nextLine();

                String[] lines1=scanner1.nextLine().split(" ");
                String[] lines2=scanner1.nextLine().split(" ");
                //System.out.println(Arrays.toString(lines1));
                for(int i=0 ; i<11 ;i++){
                    for(int y = 1 ; y<lines1.length ; y++){
                            String[] mot1=lines1[y].split(":");
                            String[] mot2=lines2[y].split(":");
                            try{
                                if(!mot1[0].equals(("-"))&&!mot2[0].equals("-")){
                                    Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines2[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, true);
                                    this.listArrete.add(arete);
                                }
                            }catch(Exception e) {
                                e.printStackTrace();
                            }
                    }
                    }
                scanner1.nextLine();

                lines1=scanner1.nextLine().split(" ");
                lines2=scanner1.nextLine().split(" ");
                //System.out.println(Arrays.toString(lines1));
                for(int i=0 ; i<11 ;i++){
                    for(int y = 1 ; y<lines1.length ; y++){
                        String[] mot1=lines1[y].split(":");
                        String[] mot2=lines2[y].split(":");
                        try{
                            if(!mot1[0].equals(("-"))&&!mot2[0].equals("-")){
                                Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines2[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, true);
                                this.listArrete.add(arete);
                            }
                        }catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                scanner1.nextLine();
                scanner1.nextLine();
                scanner1.nextLine();
                lines1=scanner1.nextLine().split(" ");
                lines2=scanner1.nextLine().split(" ");
                    //System.out.println(Arrays.toString(lines2));
                for(int i=0 ; i<11 ;i++) {
                    for (int y = 1; y < lines1.length; y++) {
                        String[] mot1 = lines1[y].split(":");
                        String[] mot2 = lines2[y].split(":");
                        try {
                            if (!mot1[0].equals(("-")) && !mot2[0].equals("-")) {
                                Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines2[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, false);
                                this.listArrete.add(arete);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }
                scanner1.nextLine();
                lines1=scanner1.nextLine().split(" ");
                lines2=scanner1.nextLine().split(" ");
                //System.out.println(Arrays.toString(lines2));
                for(int i=0 ; i<11 ;i++) {
                    for (int y = 1; y < lines2.length; y++) {
                        String[] mot1 = lines1[y].split(":");
                        String[] mot2 = lines2[y].split(":");
                        try {
                            if (!mot1[0].equals(("-")) && !mot2[0].equals("-")) {
                                Arete arete = new Arete(findBusStop(lines1[0]), findBusStop(lines2[0]), new int[]{Integer.parseInt(mot1[0]), Integer.parseInt(mot1[1])}, new int[]{Integer.parseInt(mot2[0]), Integer.parseInt(mot2[1])}, false);
                                this.listArrete.add(arete);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }}

            scanner1.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public BusStop findBusStop(String stringBusStop){
        for(BusStop busStop:this.listBusStop){
            if(busStop.getNom().equals(stringBusStop)) return busStop;
        }
        return null;
    }
    public void displayArete(){
        for(Arete arete:listArrete){
            try{
            arete.display();
            System.out.println(" ");}catch (Exception e){

            }
        }
    }
}
