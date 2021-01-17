package Site.Spring.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Site.Spring.Entities.AppRole;
import Site.Spring.Entities.AppUser;

import Site.Spring.Repositories.RoleRepository;
import Site.Spring.Repositories.UserRepository;
import Site.Spring.ServicesInterfaces.AccountServices;


@Service
public class AccountServiceImplementation implements AccountServices{
 
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private RoleRepository roleRepository ;
	@Override
	public AppUser save(AppUser user) {
		// TODO Auto-generated method stub
		String hashPW=bcryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return userRepository.save(user);
	}

	@Override
	public AppRole save(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		// TODO Auto-generated method stub
		AppRole role =roleRepository.findByRoleName(roleName);
		AppUser user =userRepository.findByUsername(userName);
		user.getRoles().add(role);
		System.out.println("services ***************************************");
		System.out.println(role.toString());
		System.out.println(user.toString());
		System.out.println(user.getRoles().toString());
	}

	@Override
	public AppUser findUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(userName);
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		List<AppUser> appUsers = new ArrayList<AppUser>();
		for (AppUser appUser : userRepository.findAll())
			appUsers.add(appUser);
		return appUsers;
	}

}
