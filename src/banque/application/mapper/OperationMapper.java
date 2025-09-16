package banque.application.mapper;

import banque.domain.entity.Operation;
import banque.domain.entity.Versement;
import banque.domain.entity.Retrait;
import banque.presentation.dto.OperationDTO;
import banque.presentation.dto.RetraitDTO;
import banque.presentation.dto.VersementDTO;

public class OperationMapper {
	
	public static OperationDTO toDto(Operation operation) {
		if(operation instanceof Versement) {
			Versement ve = (Versement) operation;
			return new VersementDTO(
					ve.getUuid(),
					ve.getDate(),
					ve.getMontant(),
					ve.getSource());
		} else if (operation instanceof Retrait) {
			Retrait re = (Retrait) operation;
			return new RetraitDTO(
						re.getUuid(),
						re.getDate(),
						re.getMontant(),
						re.getDestination()
					);
		}
		
		return new OperationDTO(operation.getUuid(), operation.getDate(), operation.getMontant());
	}
	
	public static Operation toEntity(OperationDTO operationDto) {
		if(operationDto instanceof VersementDTO) {
			VersementDTO ve = (VersementDTO) operationDto;
			return new Versement(ve.getUuid(), ve.getDate(), ve.getMontant(), ve.getSource());
		} else if (operationDto instanceof RetraitDTO ) {
			RetraitDTO re = (RetraitDTO) operationDto;
			return new Retrait(re.getUuid(), re.getDate(), re.getMontant(), re.getDestination());
		}
		
		throw new IllegalArgumentException("Unsupported DTO type: " + operationDto.getClass().getName());
	}
}