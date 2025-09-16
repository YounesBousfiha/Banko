package banque.domain.repository;

import banque.domain.entity.Compte;

public interface CompteRepository {
	void save(Compte compte);
	Compte findByCode(String code);
	boolean exists(String code); // use this when Cheking for Account Existance
}