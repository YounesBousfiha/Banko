package banque.application.service;

import banque.domain.repository.CompteRepository;

public class CompteService {
	
	private final CompteRepository compteRepository;
	
	public CompteService(CompteRepository compteRepository) {
		this.compteRepository = compteRepository;
	}
}