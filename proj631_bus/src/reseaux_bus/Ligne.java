package reseaux_bus ;
public class Ligne {
	private Double numero;
	private String destination;

	public Ligne(Double numero, String destination) {
		this.numero = numero;
		this.destination = destination;
	}

	public Double getNumero() {
		return numero;
	}

	public String getDestination() {
		return destination;
	}


	public void setNumero(Double numero) {
		this.numero = numero;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
