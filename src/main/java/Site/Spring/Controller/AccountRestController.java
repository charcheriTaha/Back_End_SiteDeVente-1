package Site.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Site.Spring.Entities.AppUser;
import Site.Spring.ServicesInterfaces.AccountServices;



@RestController
public class AccountRestController {
	@Autowired
	private AccountServices accountServices;

	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		
		
	if (!userForm.getPassword().equals(userForm.getConfirmedPassword()))
			throw new RuntimeException("You must confirm Your Password !");

		AppUser user = accountServices.findUserByUsername(userForm.getUsername());
		if (user != null)
			throw new RuntimeException("This user already exists ! ");
		AppUser appUser = new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());

		 accountServices.save(appUser);
		 accountServices.addRoleToUser(userForm.getUsername(), "USER");
		 return appUser ;
	}

}
