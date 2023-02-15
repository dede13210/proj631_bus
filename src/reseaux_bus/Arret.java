package reseaux_bus ;
import java.util.ArrayList;

public class Arret {
	int id;
	String nom;
	ArrayList<Ligne> ligne;
	public Arret(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		this.ligne=new ArrayList<Ligne>();
		}

	public Arret() {

	}

}
