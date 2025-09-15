package banque.domain.entity;

import java.time.LocalDate;

public class Versement extends Operation {
	private String source;
	
	public Versement(String uuid, LocalDate date, Double montant, String source) {
		super(uuid, date, montant);
		this.source = source;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void setSource(String newSource) {
		this.source = newSource;
	}
}