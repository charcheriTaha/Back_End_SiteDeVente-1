package Site.Spring.ServicesInterfaces;

import java.util.Date;
import java.util.List;
import java.util.Timer;

import Site.Spring.Entities.Commande;


public interface CommandeServicesInterface {

	public Commande getCommandeById(long id);

	public String ajouterCommande(Commande commande);

	public String updateCommande(Commande ccommande);

	public String deleteCommande(Commande commande);

	public String deleteCommandeById(long id);

	public List<Commande> findCommandeByDate(Date date);
	

	public List<Commande> findAll();
}
