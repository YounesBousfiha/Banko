package banque.application.service;

import banque.application.mapper.CompteMapper;
import banque.domain.entity.Compte;
import banque.domain.repository.CompteRepository;
import banque.presentation.dto.CompteDTO;

public class CompteService {
	
	private final CompteRepository compteRepository;
	
	public CompteService(CompteRepository compteRepository) {
		this.compteRepository = compteRepository;
	}
		
	// TODO: Validations
	public CompteDTO createAccount(CompteDTO compteDto) {
		
		Compte compte = CompteMapper.toEntity(compteDto);
		
		this.compteRepository.save(compte);
		
		return CompteMapper.toDTO(compte);
	}
	
	
	
	public Double getSolde(String code) {
		Compte compte = this.compteRepository.findByCode(code);
		return compte.getSolde();
	}
}