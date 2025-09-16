package banque.presentation.controller;

import banque.application.service.CompteService;
import banque.presentation.dto.CompteCourantDTO;
import banque.presentation.dto.CompteDTO;
import banque.presentation.dto.CompteEpargneDTO;

public class CompteController {
	
	private final CompteService compteService;
	
	public CompteController(CompteService compteService) {
		this.compteService = compteService;
	}
	
	// Create Account Method
	public void CreateAccount(String code, String type, Double solde) {
		CompteDTO compte = null;
		
		switch(type) {
		case "courant":
			compte = new CompteCourantDTO(code, solde, 500.00);
			break;
		case "epargne":
			compte = new CompteEpargneDTO(code, solde, 2.00);
			break;
		default:
			System.out.println("Invalid choix !");
		}
		
		CompteDTO newCompte = this.compteService.createAccount(compte);
	}
	
	// getSolde method
	public Double getSolde(String code) {
		return this.compteService.getSolde(code);
	}
}