package reseaux_bus ;
import java.util.ArrayList;

public class Horaire {
	private int id;
	private String type;
	private ArrayList<Heure> listHoraire;

	public Horaire(int id, String type, ArrayList<Heure> listHoraire) {
		super();
		this.id = id;
		this.type = type;
		this.listHoraire = listHoraire;
		}


}
