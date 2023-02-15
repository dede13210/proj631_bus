package reseaux_bus ;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.System.*;

public class Parser {
	private String path1 = "C:/Users/dede1/Documents/proj631_bus/src/1_Poisy-ParcDesGlaisins.txt";
    private String path2 = "C:/Users/dede1/Documents/proj631_bus/src/2_Piscine-Patinoire_Campus.txt";

    private ArrayList<String> stopLine1= new ArrayList<String>();
    private ArrayList<String> stopLine2= new ArrayList<String>();
    private Map<Double, String> line=new HashMap<Double, String>();




    public void parseDirection(){
        try
        {
            File file1 = new File(this.getPath1());
            Scanner scanner1 = new Scanner(file1);
            String ligne1= scanner1.nextLine();
            String[] mot = ligne1.split(" ");
            line.put(1.1,mot[0]);
            line.put(1.3,mot[2]);
            line.put(1.2,mot[mot.length-1]);

            scanner1.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            File file2 = new File(this.getPath2());
            Scanner scanner2 = new Scanner(file2);
            String ligne2= scanner2.nextLine();
            String[] mot = ligne2.split(" ");
            line.put(2.1,mot[0]);
            line.put(2.2,mot[mot.length-1]);

            scanner2.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    public void parseStop(){
        try
        {
            File file1 = new File(this.getPath1());
            Scanner scanner1 = new Scanner(file1);
            String stopIn1= scanner1.nextLine();
            String[] mot = stopIn1.split(" ");
            for (String word:mot) {
                if(!Objects.equals(word, "+")){
                    if(!Objects.equals(word, "N")){
                        stopLine1.add(word);
                    }
                }
            }
            scanner1.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            File file2 = new File(this.getPath2());
            Scanner scanner2 = new Scanner(file2);
            String stopIn2= scanner2.nextLine();
            String[] mot = stopIn2.split(" ");
            for (String word:mot) {
                if(!Objects.equals(word, "+")){
                    if(!Objects.equals(word, "N")){
                        stopLine2.add(word);
                    }
                }
            }
            scanner2.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void dysplayLine(){
        for(Entry<Double,String> mp: line.entrySet()){ System.out.println(mp.getKey() + " " + mp.getValue());}
    }
    public String getPath2() {
        return path2;
    }
    public String getPath1() {
		return path1;
	}
    public Map<Double, String> getLine() {
        return line;
    }

    public void setLine(Map<Double, String> line) {
        this.line= line;
    }

    public ArrayList<String> getStopLine1() {
        return stopLine1;
    }


    public ArrayList<String> getStopLine2() {
        return stopLine2;
    }}