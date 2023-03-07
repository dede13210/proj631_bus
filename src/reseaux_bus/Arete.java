package reseaux_bus;

public class Arete {
    private BusStop arretDepart;
    private BusStop arretArrive;
    private int[] heureDepart;
    private int[] heureArrive;
    private boolean normalHoraire;  //en fonction des horraire normal ou vacances

    public Arete(BusStop arretDepart, BusStop arretArrive, int[] heureDepart, int[] heureArrive, boolean typeDhorraire) {
        this.arretDepart = arretDepart;
        this.arretArrive = arretArrive;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.normalHoraire = typeDhorraire;
    }
    public void display() {
        System.out.println("Départ : " + arretDepart.getNom());
        System.out.println("Arrivée : " + arretArrive.getNom());
        System.out.println("Heure de départ : " + heureDepart[0] + ":" + heureDepart[1]);
        System.out.println("Heure d'arrivée : " + heureArrive[0] + ":" + heureArrive[1]);
        if (normalHoraire) {
            System.out.println("Le trajet suit les horaires normaux.");
        } else {
            System.out.println("Le trajet suit les horaire d'été.");
        }
    }



    public boolean isNormalHoraire() {
        return normalHoraire;
    }

    public BusStop getArretDepart() {
        return arretDepart;
    }

    public BusStop getArretArrive() {
        return arretArrive;
    }

    public int[] getHeureDepart() {
        return heureDepart;
    }

    public int[] getHeureArrive() {
        return heureArrive;
    }

    public void setHeureDepart(int[] heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeureArrive(int[] heureArrive) {
        this.heureArrive = heureArrive;
    }
}
