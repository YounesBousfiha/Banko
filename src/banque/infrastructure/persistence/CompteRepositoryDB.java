package banque.infrastructure.persistence;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import banque.domain.entity.Compte;
import banque.domain.repository.CompteRepository;
/*import banque.infrastructure.strategy.CompteSaveStrategy;
import banque.infrastructure.strategy.CompteCourantSaveStrategy;
import banque.infrastructure.strategy.CompteEpargneSaveStrategy;*/

public class CompteRepositoryDB implements CompteRepository {
	
	private Connection db; 
	//private Map<String, CompteSaveStrategy> strategies = new HashMap<>();
	
	public CompteRepositoryDB(Connection db) {
		this.db = db;
		
		//strategies.put("courant", new CompteCourantSaveStrategy(this.db));
		//strategies.put("epargne", new CompteEpargneSaveStrategy(this.db));
	}
	
	@Override
	public void save(Compte compte) {
		/*CompteSaveStrategy strategy = strategies.get(compte.getaccountType().name());
		if(strategy != null) {
			strategy.save(compte);
		} else {
			throw new IllegalArgumentException("No strategy for type " + compte.getaccountType());
		}*/
	}

	@Override
	public Compte findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String code) {
		// TODO Auto-generated method stub
		return false;
	}}