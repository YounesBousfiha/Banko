package banque.presentation.dto;

public class CompteDTO {
	private String code;
	private Double solde;
	
	public CompteDTO(String code, Double solde) {
		this.code = code;
		this.solde = solde;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String newCode) {
		this.code = newCode;
	}
	
	public Double getSolde() {
		return this.solde;
	}
	
	public void setSolde(Double newSolde) {
		this.solde = newSolde;
	}
}