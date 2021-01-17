package Site.Spring.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Site.Spring.Entities.Commande;
import Site.Spring.Repositories.CommandeRepository;
import Site.Spring.ServicesInterfaces.CommandeServicesInterface;

@Transactional
@Service("commandeServices")
public class CommandeServices implements CommandeServicesInterface{
	@Autowired
	CommandeRepository commandeRepository;

	@Override
	public Commande getCommandeById(long id) {
		// TODO Auto-generated method stub
		return commandeRepository.findCommandeById(id);
	}

	@Override
	public String ajouterCommande(Commande commande) {
		// TODO Auto-generated method stub
		commandeRepository.save(commande);
		return "Commande Enregistré";
	}

	@Override
	public String updateCommande(Commande commande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCommande(Commande commande) {
		// TODO Auto-generated method stub
		commandeRepository.delete(commande);
		return "Commande supprimé";
	}

	@Override
	public String deleteCommandeById(long id) {
		// TODO Auto-generated method stub
		commandeRepository.deleteById(id);
		return "Commande supprimé";
	}

	@Override
	public List<Commande> findCommandeByDate(Date date) {
		return (List<Commande>) commandeRepository.findByDate(date);

	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		List<Commande> commandes = new ArrayList<Commande>();
		for (Commande commande : commandeRepository.findAll())
			commandes.add(commande);
		return commandes;
	}



	
}
