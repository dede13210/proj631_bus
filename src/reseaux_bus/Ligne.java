package reseaux_bus ;
public class Ligne {
	private int id;
	private int numero;
	private String destination;

	public Ligne(int id, int numero, String destination) {
		super();
		this.id = id;
		this.numero = numero;
		this.destination = destination;
	}
	public int getId() {
		return id;
	}

	public int getNumero() {
		return numero;
	}

	public String getDestination() {
		return destination;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
