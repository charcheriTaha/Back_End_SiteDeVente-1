package Site.Spring.Repositories;

import java.util.Date;
import java.util.List;
import java.util.Timer;

import org.springframework.data.jpa.repository.JpaRepository;

import Site.Spring.Entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{
	
	public Commande findCommandeById(long id);
	
	public List<Commande> findByDate(Date date);
		
	//public List<Commande> findByIdClient(long id);
//	
	//public List<Commande> findByIdProduit(long id);

	//public List<Commande> findByNomContains(String partOfNom);

	//public List<Commande> findByDescriptionContains(String partOfDescription);

	//public List<Commande> findByStatusContains(String partOfStatus);

}


