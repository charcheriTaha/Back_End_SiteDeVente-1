package Site.Spring.Securite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/******************************************************************************/
		// In memory authentication
		/******************************************************************************/
		/*
		 * auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles(
		 * "ADMIN","USER") .and() .withUser("user").password("1234").roles("USER");
		 */
		/******************************************************************************/
		// jdbc authentication
		/******************************************************************************/
		/*
		 * auth.jdbcAuthentication().dataSource(datasource) .usersByUsernameQuery(
		 * "select username as principal, password as credentials, actived from users  where username = ?"
		 * ) .authoritiesByUsernameQuery(
		 * "select user_username as principal , roles_role as role from users_roles  where user_username = ?"
		 * ) .passwordEncoder(passwordEncoder) .rolePrefix("ROLE_");
		 */
		/******************************************************************************/
		// authentication personalisée
		// 1) demander a spring d'utilisé un service ===>un system d'authentification
		// basé sur une couche service
		// 2)on crée UserDetailsService dans la couche métier de notre projet
		// 3) utiliser bcryptPasswordEncoder pour hacher le mot de passe une fois
		// qu'elle est vérifier par spring et li faut l'instancier

		/*
		 * l'orsque lapplication est démarer toute méthode quii utilise l'annotation
		 * Bean va s'exécuter et lorsque ils sont exécuter le résultat devient un bean
		 * spring et ====> donc on peut l'injecter partout donc on doit intancier
		 * BCryptPasswordEncoder de cette manniére
		 * 
		 * @Bean public BCryptPasswordEncoder getBCPE() { return new
		 * BCryptPasswordEncoder(); }
		 */
		/******************************************************************************/
		auth.userDetailsService(userDetailsService).passwordEncoder(bcryptPasswordEncoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.csrf().disable(); // on dit à spring que c'est pas la péne de généré le
		// token dans le formulaire pour qu'on puisse tester les methode put delete et
		// post
		// http.authorizeRequests().antMatchers("/login/*","/register/*").permitAll();
		// http.formLogin().permitAll() ; // c'est un formulaire d'authentification géré
		// par spring
		// http.formLogin().loginPage("/login");

		// http.authorizeRequests().antMatchers(HttpMethod.POST,"/addtasks/*").hasAuthority("ADMIN");
		// http.authorizeRequests().anyRequest().authenticated() ;

		/*
		 * pour utiliser Json web token on doit désactivuer l'authentification basé sur
		 * les sessions c'est à dire on vas passer d'un system d'authentification par
		 * référence vers un systéme d'authentification par valeur
		 */
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/user/**","/appUsers/**","/appRoles/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
	}

}
