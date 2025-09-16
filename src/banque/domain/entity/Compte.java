package banque.domain.entity;

public abstract class Compte {
	
	private String code;
	private Double solde;
	
	public Compte( String code, Double solde) {
		this.setCode(code);
		this.setSolde(solde);
	}
	
	
	
	public abstract void retiter();
	public abstract Double calculerInteret();
	public abstract void afficherDetails();

	
	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}

	public Double getSolde() {
		return solde;
	}



	public void setSolde(Double solde) {
		this.solde = solde;
	}



} 