package banque.infrastructure.persistence;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import banque.domain.entity.Operation;
import banque.domain.repository.OperationRepository;
 
public class OperationRepositoryMemory implements OperationRepository {
	private Map<String, Operation> operations = new HashMap<>();

	@Override
	public void save(Operation operation) {
		this.operations.put(operation.getUuid(), operation);
	}

	@Override
	public List<Operation> findAll() {
		return new ArrayList<>(this.operations.values());
	}

}