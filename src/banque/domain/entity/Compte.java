package banque.domain.entity;

import java.util.List;

import banque.domain.enums.CompteType;

public abstract class Compte {
	
	private String code;
	private Double solde;
	private List<Operation> operations;
	
	public Compte(String code, Double solde) {
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


	public List<Operation> getOperations() {
		return operations;
	}


	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
	@Override
	public String toString() {
	    return "Compte{" +
	            "code='" + code + '\'' +
	            ", solde=" + solde +
	            ", operations=" + (operations != null ? operations.size() : 0) +
	            '}';
	}


} 