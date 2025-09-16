package banque.presentation.controller;


import banque.application.service.CompteService;
import banque.infrastructure.config.GlobalValue;
import banque.presentation.dto.CompteCourantDTO;
import banque.presentation.dto.CompteDTO;
import banque.presentation.dto.CompteEpargneDTO;

public class CompteController {
	
	private final CompteService compteService;
	
	public CompteController(CompteService compteService) {
		this.compteService = compteService;
	}
	
	public void CreateAccount(String code, String type, Double solde) {
		CompteDTO compte = null;
		
		switch(type) {
		case "courant":
			compte = new CompteCourantDTO(code, solde, GlobalValue.DECOUVERT);
			break;
		case "epargne":
			compte = new CompteEpargneDTO(code, solde, GlobalValue.TAUX_INTEREST); // TODO:  make More Good Calculation
			break;
		default:
			System.out.println("Invalid choix !");
		}
		
		this.compteService.createAccount(compte);
	}
	
	public Double calcInterest(String code) {
		return this.compteService.calcInterest(code);
	}
	

	
	public Double getSolde(String code) {
		return this.compteService.getSolde(code);
	}
}