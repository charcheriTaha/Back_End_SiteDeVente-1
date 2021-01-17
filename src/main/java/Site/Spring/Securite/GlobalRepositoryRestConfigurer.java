package Site.Spring.Securite;

import java.util.Arrays;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import Site.Spring.Entities.AppRole;
import Site.Spring.Entities.AppUser;
import Site.Spring.Entities.Categorie;
import Site.Spring.Entities.Client;
import Site.Spring.Entities.Commande;
import Site.Spring.Entities.Produit;


public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryrestconfiguration) {
		repositoryrestconfiguration.setReturnBodyOnCreate(true);
		repositoryrestconfiguration.setReturnBodyOnUpdate(true);
		repositoryrestconfiguration.exposeIdsFor(Categorie.class,Client.class,Commande.class,Produit.class,AppUser.class,AppRole.class);
		repositoryrestconfiguration.getCorsRegistry()
		//spécifier l'url
		.addMapping("/*")
		//spécifier le domaine
	     .allowedOrigins("http://localhost:4200/")
		.allowedHeaders("Origin", "Content-Type", "Accept")
		.exposedHeaders("Authorization")
		.allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH")
		.allowCredentials(true);
	}
	
}
