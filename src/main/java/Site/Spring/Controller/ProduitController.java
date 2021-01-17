package Site.Spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Site.Spring.Entities.Categorie;
import Site.Spring.Entities.Produit;
import Site.Spring.Repositories.ProduitRepository;
import Site.Spring.Services.ProduitServices;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/produit")
//@Secured(value = { "ROLE_ADMIN" })
public class ProduitController {

	@Autowired
	ProduitServices produitServices;
	private final ProduitRepository PR;

	public ProduitController(ProduitRepository pR) {
		super();
		PR = pR;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Produit> listProduit() {
		return produitServices.findAll();
	}

	@GetMapping("/getProduit/{id}")
	public Optional<Produit> getProduitById(@PathVariable(value = "id") long id) {
		 //long artId = Integer.parseInt(artIdStr);
		return  PR.findById(id);

	}

	@RequestMapping(value = "/addProduit", method = RequestMethod.POST)
	public Produit ajouterproduit(@RequestBody Produit prod) {
	
		return PR.save(prod);
	}

	@RequestMapping(value = "/updateProduit", method = RequestMethod.POST)
	public Produit updateproduit(@RequestBody Produit prod) {
	//	System.out.println(prod.getId());
	//	System.out.println(prod.getId());
	//	System.out.println(prod.getStatus());
		Optional<Produit> optionelEntity = PR.findById(prod.getId());
		Produit prt = optionelEntity.get();
		prt.setNom(prod.getNom());
		prt.setDescription(prod.getDescription());
		prt.setPrix(prod.getPrix());
		prt.setStatus(prod.getStatus());
		return PR.save(prt);
	}
	@RequestMapping(value = "/updateProduit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Produit> produitUpdate(@PathVariable(value = "id") long produit_id,
			@RequestBody Produit produit_Details) {

		Optional<Produit> optionelEntity = PR.findById(produit_id);
		Produit prt = optionelEntity.get();
		prt.setNom(produit_Details.getNom());
		prt.setDescription(produit_Details.getDescription());
		prt.setPrix(produit_Details.getPrix());
		final Produit updateProduit = PR.save(prt);
		return ResponseEntity.ok(updateProduit);
	}

	@RequestMapping(value = "/deleteProduit/{id}", method = RequestMethod.GET)
	public void deleteProduit(@PathVariable(value = "id") long id) {
		produitServices.deleteProduitById(id);
	}

	@GetMapping("/searching Produit by nom containing")
	public List<Produit> getProduitByNomContains(String partOfNom) {
		return produitServices.findProduitByNom(partOfNom);

	}

	@GetMapping("/searching Produit by description containing")
	public List<Produit> getProduitByPrenomContains(String partOfDescription) {
		return produitServices.findByDescriptionContains(partOfDescription);

	}

	@GetMapping("/searching Produit by statut")
	public List<Produit> getProduitByStatutContains(String statut) {
		return produitServices.findByStatusContains(statut);

	}
}
