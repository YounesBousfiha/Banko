package banque.presentation.dto;

public class CompteEpargneDTO extends CompteDTO {
	private Double tauxInteret;
	
	
	public CompteEpargneDTO(String code, Double solde, Double tauxInteret) {
		super(code, solde);
		this.tauxInteret = tauxInteret;
	}
	
	public Double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	
}