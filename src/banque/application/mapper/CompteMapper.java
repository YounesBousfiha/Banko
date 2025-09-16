package banque.application.mapper;

import banque.domain.entity.Compte;
import banque.domain.entity.CompteCourant;
import banque.domain.entity.CompteEpargne;
import banque.presentation.dto.CompteCourantDTO;
import banque.presentation.dto.CompteEpargneDTO;
import banque.presentation.dto.CompteDTO;

public class CompteMapper {
	
	public static CompteDTO toDTO(Compte compte) {
		if(compte instanceof CompteCourant) {
			CompteCourant cc = (CompteCourant) compte;
			return new CompteCourantDTO(cc.getCode(), cc.getSolde(), cc.getDecouvert());
		} else if (compte instanceof CompteEpargne) {
			CompteEpargne ce = (CompteEpargne) compte;
			return new CompteEpargneDTO(ce.getCode(), ce.getSolde(), ce.getTauxInteret());
		}
	    return new CompteDTO( compte.getCode(), compte.getSolde());
	}
	
	
	public static Compte toEntity(CompteDTO compteDto) {
		if(compteDto instanceof CompteCourantDTO) {
			CompteCourantDTO cc = (CompteCourantDTO) compteDto;
			return new CompteCourant(cc.getCode(), cc.getSolde(), cc.getDecouvert());
		} else if(compteDto instanceof CompteEpargneDTO) {
			CompteEpargneDTO ce = (CompteEpargneDTO) compteDto;
			return new CompteEpargne(ce.getCode(), ce.getSolde(), ce.getTauxInteret());
		}
		
	    throw new IllegalArgumentException("Unsupported DTO type: " + compteDto.getClass().getName());
	}
}