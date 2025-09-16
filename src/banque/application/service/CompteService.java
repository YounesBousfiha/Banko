package banque.application.service;

import banque.application.mapper.CompteMapper;
import banque.domain.entity.Compte;
import banque.domain.entity.CompteEpargne;
import banque.domain.exception.CompteNotFound;
import banque.domain.exception.DuplicateAccount;
import banque.domain.exception.InvalidAccountNaming;
import banque.domain.exception.InvalidAccountType;
import banque.domain.repository.CompteRepository;
import banque.infrastructure.config.GlobalValue;
import banque.presentation.dto.CompteDTO;

public class CompteService {
	
	private final CompteRepository compteRepository;
	
	public CompteService(CompteRepository compteRepository) {
		this.compteRepository = compteRepository;
	}
		
	public void createAccount(CompteDTO compteDto) {
		Compte compte = null;
		try {
			if(!(compteDto.getCode().startsWith("CPT-"))) {
				throw new InvalidAccountNaming();
			}
			Compte oldCompte = this.compteRepository.findByCode(compteDto.getCode());
			if(oldCompte != null) {
				throw new DuplicateAccount();
			}
			compte = CompteMapper.toEntity(compteDto);
			

			
			this.compteRepository.save(compte);
			
			
		} catch (DuplicateAccount | InvalidAccountNaming e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public Double calcInterest(String code) {
		Double Interest = 0.0;
		try {
			Compte compte = this.compteRepository.findByCode(code);
						
			if(compte == null) {
				throw new CompteNotFound();
			}
			
			if(!(compte instanceof CompteEpargne)) {
				throw new InvalidAccountType();
			}
			
			Interest =   compte.getSolde() * (100 / GlobalValue.TAUX_INTEREST);

		} catch (CompteNotFound | InvalidAccountType e) {
			System.err.println(e.getMessage());
		}
		
		return Interest;
	}
	
	
	
	public Double getSolde(String code) {
		Compte compte = this.compteRepository.findByCode(code);
		return compte.getSolde();
	}
}