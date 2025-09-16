package banque.application.service;

import java.util.List;

import banque.application.mapper.OperationMapper;
import banque.domain.entity.Compte;
import banque.domain.entity.CompteCourant;
import banque.domain.entity.Operation;
import banque.domain.exception.CompteNotFound;
import banque.domain.exception.DecouvertLimitExceeded;
import banque.domain.exception.InsufficientFunds;
import banque.domain.exception.NegativeAmount;
import banque.domain.repository.CompteRepository;
import banque.domain.repository.OperationRepository;
import banque.presentation.dto.RetraitDTO;
import banque.presentation.dto.VersementDTO;

public class OperationService {
	private final OperationRepository operationRepository;
	private final CompteRepository compteRepository;
	
	public OperationService(OperationRepository operationRepository, CompteRepository compteRepository) {
		this.operationRepository = operationRepository;
		this.compteRepository = compteRepository;
	}
	
	public void depot(VersementDTO dto, String code) {
		try {
			Operation versement = OperationMapper.toEntity(dto);
			Compte compte = this.compteRepository.findByCode(code);
			
			if(compte == null) {
				throw new CompteNotFound();
			}
			
			if(versement.getMontant() < 0) {
				throw new NegativeAmount();
			}
			
			compte.setSolde(compte.getSolde() + versement.getMontant());
			this.compteRepository.save(compte);
			this.operationRepository.save(versement, code);
		} catch (CompteNotFound | InsufficientFunds |  NegativeAmount e ) {
			System.err.println(e.getMessage());
		} 
	}
	
	public void retrait(RetraitDTO dto, String code) {
		try {
			Operation retrait = OperationMapper.toEntity(dto);
			Compte compte = this.compteRepository.findByCode(code);
			if(compte == null) {
				throw new CompteNotFound();
			}
			
			if(compte.getSolde() > retrait.getMontant()) {
				throw new InsufficientFunds();
			}
			
			if(retrait.getMontant() < 0) {
				throw new NegativeAmount();
			}
			
			if (compte instanceof CompteCourant) {
			    CompteCourant cpt = (CompteCourant) compte;
			    double nouveauSolde = cpt.getSolde() - retrait.getMontant();
			    if (nouveauSolde < -cpt.getDecouvert()) {
			        throw new DecouvertLimitExceeded();
			    }
			}
			
			compte.setSolde(compte.getSolde() - retrait.getMontant());
			this.compteRepository.save(compte);
			this.operationRepository.save(retrait, code);
		} catch (CompteNotFound | InsufficientFunds | DecouvertLimitExceeded | NegativeAmount e) {
			System.err.println(e.getMessage());
		}

	}
	

	public List<Operation> getAllOperations(String code) {
		try {
			Compte compte = this.compteRepository.findByCode(code);
			if(compte == null) {
				throw new CompteNotFound();
			}
		} catch (CompteNotFound e) {
			System.err.println(e.getMessage());
		}
		return this.operationRepository.findByCode(code);

	}
}