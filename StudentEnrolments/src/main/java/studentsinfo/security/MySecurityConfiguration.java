package studentsinfo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecurityConfiguration {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//			// Anyone can access /all 
//		http.authorizeHttpRequests().requestMatchers("/all/**").permitAll();
		
		//http.authorizeHttpRequests().requestMatchers("/students").hasRole("USER");
// 			
// 			// Only admins can access /admin
//		http.authorizeHttpRequests().requestMatchers("/**").hasRole("ADMIN");
		
//		http.authorizeHttpRequests().requestMatchers("/**").hasRole("USER");
// 			
//			//http.authorizeHttpRequests().requestMatchers(HttpMethod.DELETE, "/admin/**").denyAll();
//			
// 			// Needs authentication 
		http.authorizeHttpRequests().anyRequest().authenticated();
// 			
//     	 
		http.httpBasic();
// 			//http.formLogin();
// 
		http.csrf().disable(); // needed for POST requests
		http.cors();

		return http.build();
	}
}
