package banque.presentation.dto;

import java.time.LocalDate;

public class OperationDTO {
	private String uuid;
	private LocalDate date;
	private Double montant;
	
	public OperationDTO(String uuid, LocalDate date, Double montant) {
		this.setUuid(uuid);
		this.setDate(date);
		this.setMontant(montant);
	}

	public String getUuid() {
		return uuid;
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