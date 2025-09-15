package banque.domain.entity;

import java.time.LocalDate;

public class Retrait extends Operation {
	private String destination;
	
	public Retrait(String uuid, LocalDate date, Double montant, String destination) {
		super(uuid, date, montant);
		this.destination = destination;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public void setDestination(String newDest) {
		this.destination = newDest;
	}
}