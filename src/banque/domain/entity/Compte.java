package banque.domain.entity;

public abstract class Compte {
	
	protected String code;
	protected Double solde;
	
	public Compte( String code, Double solde) {
		this.code = code;
		this.solde = solde;
	}
	
	public abstract void retiter();
	public abstract Double calculerInteret();
	public abstract void afficherDetails();
} 