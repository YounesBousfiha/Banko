package banque.presentation.dto;

public class CompteCourantDTO extends CompteDTO {
	private Double decouvert;
	
	public CompteCourantDTO(String code, Double solde, Double decouvert) {
		super(code, solde);
		this.setDecouvert(decouvert);
	}
	
	public Double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}
}