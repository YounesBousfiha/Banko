package banque;

// import java.sql.Connection;

import banque.application.service.CompteService;
import banque.application.service.OperationService;
import banque.domain.repository.CompteRepository;
import banque.domain.repository.OperationRepository;
import banque.infrastructure.config.GlobalValue;
import banque.infrastructure.persistence.CompteRepositoryMemory;
import banque.infrastructure.persistence.OperationRepositoryMemory;
import banque.presentation.ConsoleUI;
import banque.presentation.controller.CompteController;
import banque.presentation.controller.OperationController;
// import banque.infrastructure.config.DatabaseConfig;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello");
		CompteRepository compteRepository = null;
		OperationRepository operationRepository = null;
		 // Create repository Instance inject database Depencendy
		if(GlobalValue.USE_DATABASE) {
			//Connection db = DatabaseConfig.getInstance().getConnection();
			// compteRepository = new CompteRepositoryDB(db);
			// operationRepository = new OperationRepositoryDB(db);
		} else {
			compteRepository = new CompteRepositoryMemory();
			operationRepository = new OperationRepositoryMemory();	
		}
		
		
		// Create Service Instance with repository
		CompteService compteService = new CompteService(compteRepository);
		OperationService operationService = new OperationService(operationRepository, compteRepository);
		
		// Create controller with Service
		CompteController compteController = new CompteController(compteService);
		OperationController operationController = new OperationController(operationService);
		
		// Create Consoleui with controllers
		ConsoleUI ui = new ConsoleUI(compteController, operationController);
		
		ui.start();
	}
}
