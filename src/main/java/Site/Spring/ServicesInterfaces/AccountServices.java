package Site.Spring.ServicesInterfaces;

import java.util.List;

import Site.Spring.Entities.AppRole;
import Site.Spring.Entities.AppUser;
import Site.Spring.Entities.Commande;

public interface AccountServices {
	//méthode pour ajouter un user 
	public AppUser save(AppUser user );
	//méthode pour ajouter un role
	public AppRole save(AppRole role );
	//méthode pour associer un role à un user  
	public void addRoleToUser(String userName ,String roleName);
	//méthode pour chrhuer un user avec son username
	public AppUser findUserByUsername(String userName);
	
	public List<AppUser> findAll();

}
