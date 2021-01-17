package Site.Spring.Services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User; /*importe DE User*/
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Site.Spring.Entities.AppUser;
import Site.Spring.ServicesInterfaces.AccountServices;


@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private AccountServices accountServices;

	/*
	 * cette clase va implementer l'interface UserDetailsService et cette classe va
	 * redéfinier une seul méthode qui est loadUserByUsername plus précéssément le
	 * SpringSecurityFilterChain lors de l'authentification va automatiquement
	 * appeler cette méthode de UserDetailsServiceImplementation loadUserByUsername
	 * retourn un objet de type user de spring qui est un objet d'une classe user de
	 * spring qui implémente l'interface UserDetails
	 * 
	 * les roles dans springSecurity sont des objet de type GrantedAuthority
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AppUser user = accountServices.findUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});

		return new User(user.getUsername(), user.getPassword(), authorities);
		/* voir importe DE User en haut */
	}

}
