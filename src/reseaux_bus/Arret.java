package reseaux_bus ;
import java.util.ArrayList;
import java.util.HashSet;

public class Arret {
	String nom;
	ArrayList<Integer> ligne;
	public Arret(String nom) {
		super();
		this.nom = nom;
		this.ligne=new ArrayList<Integer>();
		}



	public void add(int ligneNbr){
			this.ligne.add(ligneNbr);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Integer> getLigne() {
		return ligne;
	}

	public void setLigne(ArrayList<Integer> ligne) {
		this.ligne = ligne;
	}



}
