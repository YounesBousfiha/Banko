package banque.presentation.controller;

import banque.application.service.OperationService;

public class OperationController {
	
	private final OperationService operationService;
	
	public OperationController(OperationService operationService) {
		this.operationService = operationService;
	}
}