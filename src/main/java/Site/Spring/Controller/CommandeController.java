package Site.Spring.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Site.Spring.Entities.Commande;
import Site.Spring.Entities.Commande;
import Site.Spring.Entities.Commande;
import Site.Spring.Repositories.CommandeRepository;
import Site.Spring.Services.CommandeServices;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	CommandeServices commandeServices;
	private final CommandeRepository PR;

	public CommandeController(CommandeRepository pR) {
		super();
		PR = pR;
	}

	/*
	 * @RequestMapping(value = "/addCommande", method = RequestMethod.POST) public
	 * String commandeSave(@RequestParam String nom, @RequestParam String
	 * description, @RequestParam float prix,
	 * 
	 * @RequestParam String status,@RequestParam int categorie) { Commande prt = new
	 * Commande(nom, description, prix, status,categorie);
	 * commandeServices.ajouterCommande(prt); return "commande enregistré"; }
	 */
	//@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Commande> listCommande() {
		return commandeServices.findAll();
	}
	//@Secured(value = { "ROLE_ADMIN"})
	@GetMapping("/getCommande/{id}")
	public Optional<Commande> getCommandeById(@PathVariable(value = "id") long id) {
		// long artId = Integer.parseInt(artIdStr);
		return PR.findById(id);

	}
	//@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@RequestMapping(value = "/addCommande", method = RequestMethod.POST)
	public Commande ajoutercommande(@RequestBody Commande prod) {
		
		//Commande toAdd=new Commande();
		//toAdd.setDate(prod.getDate());
		
		return PR.save(prod);
	}
	@RequestMapping(value = "/updateCommande", method = RequestMethod.POST)
	public Commande updateCommande(@RequestBody Commande Commande) {
		Optional<Commande> optionelEntity = PR.findById(Commande.getId());
		Commande prt = optionelEntity.get();
		prt.setDate(Commande.getDate());
		return PR.save(prt);
	}
	//@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@RequestMapping(value = "/updateCommande/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Commande> commandeUpdate(@PathVariable(value = "id") long commande_id,
			@RequestBody Commande commande_Details) {
		Optional<Commande> optionelEntity = PR.findById(commande_id);
		Commande prt = optionelEntity.get();
		prt.setDate(commande_Details.getDate());
		prt.setClient(commande_Details.getClient());
		prt.setProduits(commande_Details.getProduits());
		final Commande updateCommande = PR.save(prt);
		return ResponseEntity.ok(updateCommande);
	}
	//@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@RequestMapping(value = "/deleteCommande/{id}", method = RequestMethod.DELETE)
	public String deleteCommande(@PathVariable(value = "id") long id) {
		commandeServices.deleteCommandeById(id);
		return "commande suprimer!!";
	}
	//@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@GetMapping("/getCommandeByDate")
	public List<Commande> getCommandeByNomContains(Date date) {
		return commandeServices.findCommandeByDate(date);

	}

}
