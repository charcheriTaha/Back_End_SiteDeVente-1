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
import Site.Spring.Entities.Categorie;
import Site.Spring.Entities.Categorie;
import Site.Spring.Repositories.CategorieRepository;
import Site.Spring.Repositories.CategorieRepository;
import Site.Spring.Services.CategorieServices;
import Site.Spring.Services.CategorieServices;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/categorie")
//@Secured(value = { "ROLE_ADMIN" })
public class CategorieController {

	@Autowired
	CategorieServices categorieServices;
	private final CategorieRepository PR;

	public CategorieController(CategorieRepository pR) {
		super();
		PR = pR;
	}
 
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Categorie> listCategorie() {
		return categorieServices.findAll();
	}

	@GetMapping("/getCategorie/{id}")
	public Optional<Categorie> getCategorieById(@PathVariable(value = "id") long id) {
		 //long artId = Integer.parseInt(artIdStr);
		return  PR.findById(id);

	}

	@RequestMapping(value = "/addCategorie", method = RequestMethod.POST)
	public Categorie ajoutercategorie(@RequestBody Categorie prod) {
		return PR.save(prod);
	}
	@RequestMapping(value = "/updateCategorie", method = RequestMethod.POST)
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
		Optional<Categorie> optionelEntity = PR.findById(categorie.getId());
		Categorie prt = optionelEntity.get();
		prt.setNom(categorie.getNom());
		prt.setDescription(categorie.getDescription());
		return PR.save(prt);
	}
	
	@RequestMapping(value = "/updateCategorie/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Categorie> categorieUpdate(@PathVariable(value = "id") long categorie_id,
			@RequestBody Categorie categorie_Details) {

		Optional<Categorie> optionelEntity = PR.findById(categorie_id);
		Categorie prt = optionelEntity.get();
		prt.setNom(categorie_Details.getNom());
		prt.setDescription(categorie_Details.getDescription());

		final Categorie updateCategorie = PR.save(prt);
		return ResponseEntity.ok(updateCategorie);
	}

	@RequestMapping(value = "/deleteCategorie/{id}", method = RequestMethod.DELETE)
	public String deleteCategorie(@PathVariable(value = "id") long id) {
		categorieServices.deleteCategorieById(id);
		return "categorie suprimer!!";
	}

	@GetMapping("/searching Categorie by nom containing")
	public List<Categorie> getCategorieByNomContains(String partOfNom) {
		return categorieServices.findCategorieByNom(partOfNom);

	}

	@GetMapping("/searching Categorie by description containing")
	public List<Categorie> getCategorieByPrenomContains(String partOfDescription) {
		return categorieServices.findByDescriptionContains(partOfDescription);

	}


}