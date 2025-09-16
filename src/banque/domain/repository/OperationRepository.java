package banque.domain.repository;

import banque.domain.entity.Operation;
import java.util.List;

public interface OperationRepository {
	void save(Operation operation, String code);
	List<Operation> findByCode(String code);
}