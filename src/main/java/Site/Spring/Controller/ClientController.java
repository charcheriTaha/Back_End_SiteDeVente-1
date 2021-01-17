package Site.Spring.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Site.Spring.Entities.Client;
import Site.Spring.Entities.Produit;
import Site.Spring.Repositories.ClientRepository;
import Site.Spring.Services.ClientServices;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientServices clientServices;
	private final ClientRepository PR;

	public ClientController(ClientRepository pR) {
		super();
		PR = pR;
	}
	//@Secured(value = { "ROLE_ADMIN"})
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Client> listClient() {
		return clientServices.findAll();
	}
	//@Secured(value = { "ROLE_ADMIN"})
	@GetMapping("/getClient/{id}")
	public Optional<Client> getClientById(@PathVariable(value = "id") long id) {
		// long artId = Integer.parseInt(artIdStr);
		return PR.findById(id);

	}

	//@Secured(value = { "ROLE_ADMIN", "ROLE_CLIENT" })
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public Client ajouterclient(@RequestBody Client prod) {
		return PR.save(prod);
	}

	@RequestMapping(value = "/updateClient", method = RequestMethod.POST)
	public Client updateClient(@RequestBody Client client) {
		Optional<Client> optionelEntity = PR.findById(client.getId());
		Client prt = optionelEntity.get();
		prt.setNom(client.getNom());
		prt.setPrenom(client.getPrenom());
		prt.setTelephone(client.getTelephone());
		prt.setEmail(client.getEmail());
		prt.setAddresse(client.getAddresse());
		return PR.save(prt);
	}
	
	//@Secured(value = { "ROLE_ADMIN", "ROLE_PERSONNEL", "ROLE_CLIENT" })
	@RequestMapping(value = "/updateClient/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> clientUpdate(@PathVariable(value = "id") long client_id,
			@RequestBody Client client_Details) {

		Optional<Client> optionelEntity = PR.findById(client_id);
		Client prt = optionelEntity.get();
		prt.setNom(client_Details.getNom());
		prt.setPrenom(client_Details.getPrenom());
		prt.setTelephone(client_Details.getTelephone());
		prt.setEmail(client_Details.getEmail());
		prt.setAddresse(client_Details.getAddresse());
		final Client updateClient = PR.save(prt);
		return ResponseEntity.ok(updateClient);
	}

	//@Secured(value = { "ROLE_ADMIN" })
	@RequestMapping(value = "/getLogedUser")
	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for (GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		return params;
	}

	//@Secured(value = { "ROLE_ADMIN" })
	@RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.DELETE)
	public String deleteClient(@PathVariable(value = "id") long id) {
		clientServices.deleteClientById(id);
		return "client suprimer!!";
	}

	//@Secured(value = { "ROLE_ADMIN" })
	@GetMapping("/getClientByNom")
	public List<Client> getClientByNom(String partOfNom) {
		return clientServices.findClientByNom(partOfNom);

	}

	//@Secured(value = { "ROLE_ADMIN" })
	@GetMapping("/searching Client by nom containing")
	public List<Client> getClientByPrenomContains(String partOfNom) {
		return clientServices.findByNomContains(partOfNom);

	}

//	@Secured(value = { "ROLE_ADMIN" })
	@GetMapping("/searching Client by prenom containing")
	public List<Client> getClientByStatutContains(String partOfPrenom) {
		return clientServices.findByPrenomContains(partOfPrenom);

	}
}
