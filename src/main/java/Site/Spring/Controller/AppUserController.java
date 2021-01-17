
package Site.Spring.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Site.Spring.Entities.AppRole;
import Site.Spring.Entities.AppUser;
import Site.Spring.Entities.Categorie;
import Site.Spring.Entities.Commande;
import Site.Spring.Repositories.CategorieRepository;
import Site.Spring.Repositories.RoleRepository;

import Site.Spring.Services.CategorieServices;
import Site.Spring.ServicesInterfaces.AccountServices;

@RestController
@RequestMapping("/user")
public class AppUserController {
	@Autowired
	private final RoleRepository roleRepository;
	@Autowired
	private AccountServices accountServices;
	
	public AppUserController(RoleRepository roleRepository, AccountServices accountServices) {
		super();
		this.roleRepository = roleRepository;
		this.accountServices = accountServices;
	}
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public AppUser ajouterUser(@RequestBody AppUser user) {
		return accountServices.save(user);
	}
	
	
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public AppRole ajouterRole(@RequestBody AppRole role) {
		return accountServices.save(role);
	}
	
	@RequestMapping(value = "/addRoleToUser", method = RequestMethod.POST)
	public void ajouterRoleToUser(@RequestParam String username ,@RequestParam String rolename) {
		 accountServices.addRoleToUser(username, rolename);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<AppUser> listCommande() {
		return accountServices.findAll();
	}
	
	@RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
	public AppUser ajouterRoleToUser(@RequestParam String username ) {
		return accountServices.findUserByUsername(username);
	}
	
	
	
}
