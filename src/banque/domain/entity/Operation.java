package banque.domain.entity;

import java.time.LocalDate;

public abstract class Operation {
	protected String uuid;
	private LocalDate date;
	private Double montant;
	
	public Operation(String uuid, LocalDate date, Double montant) {
		this.uuid = uuid;
		this.setDate(date);
		this.setMontant(montant);
	}
	
	public String getUuid() {
		return this.uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
}