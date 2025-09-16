package banque.presentation.dto;

import java.time.LocalDate;

public class VersementDTO extends OperationDTO {
	
	private String source;
	
	public VersementDTO(String uuid, LocalDate date, Double montant, String source) {
		super(uuid, date, montant);
		this.setSource(source);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
}