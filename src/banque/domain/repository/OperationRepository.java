package banque.domain.repository;

import banque.domain.entity.Operation;

public interface OperationRepository {
	void save(Operation operation);
	void virement();
	void depot();
	void retrait();
}