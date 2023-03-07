package reseaux_bus ;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BusStop {
	String nom;
	ArrayList<Double> ligne;
	ArrayList<BusStop> listBusStopVoisin;
	public BusStop(String nom) {
		super();
		this.nom = nom;
		this.ligne=new ArrayList<Double>();
		this.listBusStopVoisin =new ArrayList<BusStop>();
		}

	public  void busStopVoisin(@NotNull ArrayList<BusStop> listBusStop){
		if(listBusStop.contains(this)) {
			if (listBusStop.indexOf(this) != 0)
				this.listBusStopVoisin.add(listBusStop.get(listBusStop.indexOf(this) - 1));
			if (listBusStop.indexOf(this) != listBusStop.size() - 1)
				this.listBusStopVoisin.add(listBusStop.get(listBusStop.indexOf(this) + 1));
		}

	}
	public void addBusStopVoisin(BusStop busStop){
		this.listBusStopVoisin.add(busStop);
	}

	public void setListBusStopVoisin(ArrayList<BusStop> listBusStopVoisin) {
		this.listBusStopVoisin = listBusStopVoisin;
	}

	public void add(Double ligneNbr){
			this.ligne.add(ligneNbr);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Double> getLigne() {
		return ligne;
	}

	public ArrayList<BusStop> getListBusStopVoisin() {
		return listBusStopVoisin;
	}

	public void setLigne(ArrayList<Double> ligne) {
		this.ligne = ligne;
	}
	public void display() {
		System.out.println("Nom de l'arrêt de bus : " + nom);
		System.out.println("	Ligne de bus : " + ligne.toString());

		if (listBusStopVoisin.isEmpty()) {
			System.out.println("	Aucun arrêt de bus voisin.");
		} else {
			System.out.println("	Liste des arrêts de bus voisins :");
			for (BusStop voisin : listBusStopVoisin) {
				System.out.println("	- " + voisin.nom);
			}
		}
	}


}






