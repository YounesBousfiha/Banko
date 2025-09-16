package banque.infrastructure.persistence;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import banque.domain.entity.Operation;
import banque.domain.repository.OperationRepository;

public class OperationRepositoryMemory implements OperationRepository {
	private Map<String, Map<String, Operation>> operations = new HashMap<>();

	@Override
	public void save(Operation operation, String code) {
		this.operations.
			computeIfAbsent(code, k -> new HashMap<>())
			.put(operation.getUuid(), operation);
	}

    @Override
    public List<Operation> findByCode(String code) {
        Map<String, Operation> ops = operations.get(code);
        if (ops == null) return new ArrayList<>();
        return new ArrayList<>(ops.values());
    }
}