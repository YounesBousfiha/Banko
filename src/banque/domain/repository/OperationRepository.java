package banque.domain.repository;

import banque.domain.entity.Operation;
import java.util.List;

public interface OperationRepository {
	void save(Operation operation);
	List<Operation> findAll();
	//void virement(); // Move it to the Operation Services
	//void depot(); // Move it to the Operation Services
	//void retrait(); // Move it to the Operation Services
}