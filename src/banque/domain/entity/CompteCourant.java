package banque.domain.entity;

public class CompteCourant extends Compte {
	
	private Double decouvert;
	
	public CompteCourant(String code, Double solde, Double decouvert) {
		super(code, solde);
		this.decouvert = decouvert;
	}
	
	public Double getDecouvert() {
		return this.decouvert;
		}
	
	public void setDecouvert(Double newDecouvert) {
		this.decouvert = newDecouvert;
	}
	
	@Override
	public void retiter() {
		// TODO solde ne doit pas etre inferieur a decourvert
		
	}

	@Override
	public Double calculerInteret() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public void afficherDetails() {
		// TODO Auto-generated method stub
		
	}
	
}