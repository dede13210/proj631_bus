package reseaux_bus ;
import java.util.ArrayList;
import java.util.HashSet;

public class Arret {
	String nom;
	ArrayList<Integer> ligne;
	ArrayList<Arret> listArretVoisin;
	public Arret(String nom) {
		super();
		this.nom = nom;
		this.ligne=new ArrayList<Integer>();
		this.listArretVoisin=new ArrayList<Arret>();
		}

	public  void setListArretVoisin(ArrayList<Arret> listArret1, ArrayList<Arret> listArret2){
		if(listArret1.contains(this)) {
			if (listArret1.indexOf(this) != 0)
				this.listArretVoisin.add(listArret1.get(listArret1.indexOf(this) - 1));
			if (listArret1.indexOf(this) != listArret1.size() - 1)
				this.listArretVoisin.add(listArret1.get(listArret1.indexOf(this) + 1));
		}
		if(listArret2.contains(this)){
			if (listArret2.indexOf(this) != 0)
				this.listArretVoisin.add(listArret2.get(listArret2.indexOf(this) - 1));
			if (listArret2.indexOf(this) != listArret2.size() - 1)
				this.listArretVoisin.add(listArret2.get(listArret2.indexOf(this) + 1));
		}
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

	public ArrayList<Arret> getListArretVoisin() {
		return listArretVoisin;
	}

	public void setLigne(ArrayList<Integer> ligne) {
		this.ligne = ligne;
	}





}
