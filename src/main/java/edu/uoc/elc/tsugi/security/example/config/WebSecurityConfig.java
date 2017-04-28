package edu.uoc.elc.tsugi.security.example.config;

import edu.uoc.elc.tsugi.security.PreAuthenticatedProcessingFilter;
import edu.uoc.elc.tsugi.security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

/**
 * @author Xavi Aracil <xaracil@uoc.edu>
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		PreAuthenticatedProcessingFilter preAuthFilter = new PreAuthenticatedProcessingFilter();
		preAuthFilter.setCheckForPrincipalChanges(true);
		preAuthFilter.setAuthenticationManager(authenticationManager());

		http
						.addFilter(preAuthFilter)
						.servletApi()
						.and()

						.authorizeRequests()
						.antMatchers("/").permitAll()
						.antMatchers("/error/**").permitAll()
						.antMatchers("/error").permitAll()
						.anyRequest().fullyAuthenticated()
						.and()

						.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PreAuthenticatedAuthenticationProvider authenticationProvider = new PreAuthenticatedAuthenticationProvider();
		authenticationProvider.setPreAuthenticatedUserDetailsService(new UserDetailsService<>());

		auth.authenticationProvider(authenticationProvider);
	}
}
