package Site.Spring.Securite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.fasterxml.jackson.databind.ObjectMapper;


import Site.Spring.Entities.AppUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager ;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	
	
	 @Override
	    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		 AppUser appUser =null ;
	        try {
	            appUser= new ObjectMapper().readValue(request.getInputStream(),AppUser.class);
	            /*request.getInputStream() retourner la requette et la stocker ou désiérializer dans AppUser */
	            /*ObjectMapper() permet de prendre des objets json et les stoker d=ans un objet java */
	            
	            System.out.println("JWT***************************************");
	    		System.out.println("username :"+appUser.getUsername());
	    		System.out.println("password :"+appUser.getPassword());
	            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(),appUser.getPassword()));
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
	                                          FilterChain chain, Authentication authResult) throws IOException, ServletException {
	       
	    	 /* 
	    	User user=(User)authResult.getPrincipal();
	        List<String> roles=new ArrayList<>();
	        authResult.getAuthorities().forEach(a->{
	            roles.add(a.getAuthority());
	        });
	        */
	        User user=(User)authResult.getPrincipal();
	        String jwt= Jwts.builder()
	                .setSubject(user.getUsername())
	                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS256,SecurityConstants.SECRET)
	                .claim("roles",user.getAuthorities())
	                .compact();
	        
	        response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+jwt);
 	    }
	    
}
