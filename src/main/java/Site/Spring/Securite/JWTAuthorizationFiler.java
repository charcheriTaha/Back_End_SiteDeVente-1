package Site.Spring.Securite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;



public class JWTAuthorizationFiler extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
				
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else if (request.getRequestURI().equals("/login")) {
			filterChain.doFilter(request, response);
			return;
		} else {
			String jwtToken = request.getHeader(SecurityConstants.HEADER_STRING);
			System.out.println("Token=" + jwtToken);
			if (jwtToken == null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}

		
			Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
					.parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody(); // récupérer le
																										// contenu de
																										// token aprés
																										// avoir enlever
																										// le prefix

			String username = claims.getSubject();// getSubject() ça represente usernames
			ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");

			/*
			 * JWTVerifier verifier =
			 * JWT.require(Algorithm.HMAC256(SecurityConstants.SECRET)).build(); String jwt
			 * = jwtToken.substring(SecurityConstants.HEADER_PREFIX.length()); DecodedJWT
			 * decodedJWT = verifier.verify(jwt); System.out.println("JWT="+jwt); String
			 * username = decodedJWT.getSubject(); List<String> roles =
			 * decodedJWT.getClaims().get("roles").asList(String.class);
			 * System.out.println("username="+username); System.out.println("roles="+roles);
			 */

			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(r -> {
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});
			UsernamePasswordAuthenticationToken authenticationUser = new UsernamePasswordAuthenticationToken(username,
					null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticationUser);// charger l'utilisateur
																						// authentifier
			filterChain.doFilter(request, response);
		}

	}
}
