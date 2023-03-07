package reseaux_bus ;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Ligne {
	private Double numero;
	private ArrayList<String> destination;

	public Ligne(Double numero) {
		this.numero = numero;
		this.destination = new ArrayList<String>();
	}
	public void addDestination(String terminus){
		this.destination.add(terminus);
	}

	public void parseDirection(String path){

		String[] nomFichier = path.split("");
		this.setNumero(Double.valueOf(nomFichier[5]));
		try
		{
			File file1 = new File(path);
			Scanner scanner1 = new Scanner(file1);
			String ligneFiche1= scanner1.nextLine();
			String[] mot = ligneFiche1.split(" ");
			this.addDestination( mot[0]);
			this.addDestination(mot[mot.length-1]);
			if(Objects.equals(mot[1], "+")){
				this.addDestination(mot[2]);
			}

			scanner1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void displayLigne(){
		System.out.println(numero+" "+destination.get(0)+" "+destination.get(1));
	}

	public Double getNumero() {
		return numero;
	}

	public ArrayList<String> getDestination() {
		return destination;
	}


	public void setNumero(Double numero) {
		this.numero = numero;
	}

	public void setDestination(ArrayList<String> destination) {
		this.destination = destination;
	}

}
