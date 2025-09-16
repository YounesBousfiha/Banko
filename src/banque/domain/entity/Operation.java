package banque.domain.entity;

import java.time.LocalDate;

public abstract class Operation {
	protected String uuid;
	protected LocalDate date;
	protected Double montant;
	
	public Operation(String uuid, LocalDate date, Double montant) {
		this.uuid = uuid;
		this.date = date;
		this.montant = montant;
	}
	
	public String getUuid() {
		return this.uuid;
	}
	
}