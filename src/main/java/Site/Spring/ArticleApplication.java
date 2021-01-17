package Site.Spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Site.Spring.Entities.AppRole;
import Site.Spring.Entities.AppUser;
import Site.Spring.Repositories.RoleRepository;
import Site.Spring.Repositories.UserRepository;
import Site.Spring.ServicesInterfaces.AccountServices;



@SpringBootApplication
public class ArticleApplication /*implements CommandLineRunner*/{
	
	@Autowired
	AccountServices  accountServices;

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(ArticleApplication.class, args);
		System.out.println("bonjour taha !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	 @Bean
		public BCryptPasswordEncoder getBCPE() {
			return new BCryptPasswordEncoder();
		}
/*
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//ajouter des user et roles
		accountServices.save(new AppUser(null,"admin","1234",null));
		accountServices.save(new AppUser(null,"user","1234",null));
		accountServices.save(new AppRole(null,"ADMIN"));
		accountServices.save(new AppRole(null,"USER"));
		accountServices.addRoleToUser("admin", "ADMIN");
		accountServices.addRoleToUser("user", "USER");
	
		*/


		
		/*
		Stream.of("T1", "T2", "T3").forEach(t -> {
			TR.save(new Task(null, t));
		});

		TR.findAll().forEach(t -> {
			System.out.println(t.getTaskName());
		});
		}
		*/
	
	/*
	    RoleRepository roleRepository=ctx.getBean(RoleRepository.class);
	  //  UserRepository userRepository=ctx.getBean(UserRepository.class);
	    
	   // private Collection<Role> r =new Collection<Role> ;
	    
	    
	  roleRepository.save(new Role(1,"Admin","100%"));
	  roleRepository.save(new Role(2,"Client","60%"));
	  
	  
	//  userRepository.save(new User("taha","pass",true,roleRepository.findAll()));
	 // userRepository.save(new User("taha","Admin"));
	  
	System.out.println("***************************Ensemble De Roles*******************************************");
	java.util.List<Role> etds = roleRepository.findAll();
	etds.forEach(e->System.out.println(e.getRole()));
	/*
	System.out.println("*****************************type des Users*********************************************");
	java.util.List<User> etd = userRepository.findAll();
	etd.forEach(e->System.out.println(e.getUsername()));
	
	*/
	

}
