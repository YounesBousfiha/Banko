package banque.application.service;

import banque.domain.repository.OperationRepository;

public class OperationService {
	private final OperationRepository operationRepository;
	
	public OperationService(OperationRepository operationRepository) {
		this.operationRepository = operationRepository;
	}
}