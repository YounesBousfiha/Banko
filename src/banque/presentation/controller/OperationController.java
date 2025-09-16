package banque.presentation.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import banque.application.service.OperationService;
import banque.domain.entity.Operation;
import banque.domain.exception.SelfTransferException;
import banque.presentation.dto.RetraitDTO;
import banque.presentation.dto.VersementDTO;

public class OperationController {
	
	private final OperationService operationService;
	
	public OperationController(OperationService operationService) {
		this.operationService = operationService;
	}
	
	public void makeDepot(String code, Double amount, String source) {
		String uuid = UUID.randomUUID().toString();
		VersementDTO dto = new VersementDTO(uuid, LocalDate.now(), amount, source);
		this.operationService.depot(dto, code);
	}
	
	public void makeRetrait(String code, Double amount, String destination) {
		String uuid = UUID.randomUUID().toString();
		RetraitDTO dto = new RetraitDTO(uuid, LocalDate.now(), amount, destination);
		this.operationService.retrait(dto, code);
	}
	
	public void makeViremenet(String senderCode, String receiverCode, Double amount, String source, String destination) {
		
		try {
			if(senderCode == receiverCode) {
				throw new SelfTransferException();
			}
			
			this.makeRetrait(senderCode, amount, destination);
			this.makeDepot(receiverCode, amount, source);
			
		} catch (SelfTransferException e) {
			System.err.println(e.getMessage());
		}

	}
	
	public List<Operation> getAllOperations(String code) {
		return this.operationService.getAllOperations(code);
	}
}