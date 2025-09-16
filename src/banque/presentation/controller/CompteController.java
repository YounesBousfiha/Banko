package banque.presentation.controller;

import banque.application.service.CompteService;

public class CompteController {
	
	private final CompteService compteService;
	
	public CompteController(CompteService compteService) {
		this.compteService = compteService;
	} 
}