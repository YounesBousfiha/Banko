package banque.infrastructure.persistence;

import banque.domain.entity.Compte;
import banque.domain.repository.CompteRepository;
import java.util.HashMap;
import java.util.Map;

public class CompteRepositoryMemory implements CompteRepository {
	
	private Map<String, Compte> comptes = new HashMap<>();
	@Override
	public void save(Compte compte) {
		comptes.put(compte.getCode(), compte);
	}

	@Override
	public Compte findByCode(String code) {
		return comptes.get(code);
	}

	@Override
	public boolean exists(String code) {
		return comptes.containsKey(code);
	}}