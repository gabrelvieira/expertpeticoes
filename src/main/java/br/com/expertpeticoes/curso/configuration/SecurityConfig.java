package br.com.expertpeticoes.curso.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.expertpeticoes.curso.model.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests()
//			.antMatchers("/adm/**").authenticated()
//			.anyRequest().permitAll()
//			.and().formLogin()
//			.and().csrf().disable();
		
		http.authorizeHttpRequests()
			.anyRequest().permitAll();
		
		http.requiresChannel(
				channel -> channel.anyRequest().requiresSecure());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			User user = new User();
			user.setUsername("ADMIN");
			user.setPassword(
					new BCryptPasswordEncoder().encode("Expertpeticoes26"));
			return user;
		})
		.passwordEncoder(new BCryptPasswordEncoder());
	}
}
