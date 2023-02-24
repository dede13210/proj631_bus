package reseaux_bus ;

public class Horaire {
	private Ligne ligne;
	private String arret1;
	private Integer heure;
	private Integer minute;
	private Boolean normal; //en fonction des horaire normal ou été




	public Horaire(Ligne ligne,String arret1, Integer heure, Integer minute, Boolean normal) {
		this.ligne = ligne;
		this.arret1 = arret1;
		this.heure = heure;
		this.minute = minute;
		this.normal = normal;
	}



	public String getArret1() {
		return arret1;
	}

	public Integer getHeure() {
		return heure;
	}

	public Integer getMinute() {
		return minute;
	}

	public void display(){
		try{
		System.out.println(this.normal.toString()+" "+this.ligne.getDestination() + " "+this.arret1 +" "+ this.heure.toString() + ":" + this.minute.toString());
	}
	catch (Exception e){
		System.out.println("pas d'horaire");}
	}
}
