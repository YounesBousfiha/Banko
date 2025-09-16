package banque.presentation.dto;

import java.time.LocalDate;

public class RetraitDTO extends OperationDTO {
	
	private String destination;
	
	public RetraitDTO(String uuid, LocalDate date, Double montant, String destination) {
		super(uuid, date, montant);
		this.setDestination(destination);
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}