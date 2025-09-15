package banque.domain.entity;

public class CompteEpargne extends Compte {
	
	private Double tauxInteret;
	public CompteEpargne(String code, Double solde, Double tauxInteret) {
		super(code, solde);
		this.tauxInteret = tauxInteret;
	}
	
	
	public Double getTauxInteret() {
		return this.tauxInteret;
	}
	
	public void setTauxInteret(Double newTaux) {
		this.tauxInteret = newTaux;
	}
	@Override
	public void retiter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double calculerInteret() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficherDetails() {
		// TODO Auto-generated method stub
		
	}
	
}